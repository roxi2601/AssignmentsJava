package Assignment1;

import Assignment1.core.ModelFactory;
import Assignment1.core.ViewHandler;
import Assignment1.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import Assignment1.mediator.TemperatureModel;

public class TemperatureApp extends Application
{
    @Override public void start(Stage stage) throws Exception
    {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh =  new ViewHandler(stage,vmf);
        vh.start();
        //Why threads are always in application, not in the model?
        Thread thread =  new Thread(() -> {
            TemperatureModel model = (TemperatureModel)mf.getModel();
            while(true)
            {
               double temp1 =  model.calcTemp1();
                String wrg= model.warning();
                System.out.println("temp1: "+temp1+"  "+wrg);

                double temp2 =model.calcTemp2();

                System.out.println("temp2: "+temp2+"  "+wrg);
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
        //(I'm not sure)thread.setDaemon(true);
        thread.start();
    }

}
