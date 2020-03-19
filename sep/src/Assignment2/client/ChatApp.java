package Assignment2.client;

import Assignment2.client.core.ClientFactory;
import Assignment2.client.core.ModelFactory;
import Assignment2.client.core.ViewHandler;
import Assignment2.client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ClientFactory cf = new ClientFactory();
    ModelFactory mf = new ModelFactory(cf);
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();

  }
}
