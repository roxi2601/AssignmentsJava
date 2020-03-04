package Assignment1;

import Assignment1.core.ModelFactory;
import Assignment1.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import Assignment1.mediator.TemperatureModel;
import Assignment1.viewmodel.control.ControlViewModel;

public class TemperatureApp extends Application
{
    @Override public void start(Stage stage) throws Exception
    {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        runAutoUpdate((TemperatureModel) mf.getModel(),vmf.getControlViewModel());
    }
    private void runAutoUpdate(TemperatureModel model, ControlViewModel vm)
    {
        Thread thread =  new Thread(() -> {
            int state =  vm.getRadiatorState(vm.getRadiatorState());
            while(true)
            {
                model.getTemperatureValues(state);
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
