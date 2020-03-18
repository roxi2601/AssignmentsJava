package Assignment1master;

import Assignment1master.core.ModelFactory;
import Assignment1master.core.ViewHandler;
import Assignment1master.core.ViewModelFactory;
import Assignment1master.mediator.TemperatureListModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class TemperatureApp extends Application
{
    @Override public void start(Stage stage) throws Exception
    {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh =  new ViewHandler(stage,vmf);
        vh.start();

        Thread thread =  new Thread(() -> {
            TemperatureListModel model =  mf.getModel();
            while(true)
            {
                model.addTemperature();
                model.warning();
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

}
