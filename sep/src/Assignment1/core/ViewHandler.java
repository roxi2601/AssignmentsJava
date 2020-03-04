package Assignment1.core;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Assignment1.view.control.ControlViewController;
import Assignment1.view.display.DisplayViewController;

import java.io.IOException;

public class ViewHandler
{

   private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf)
    {
        this.vmf = vmf;
    }
    public void start() throws Exception
    {
        openView("Radiator Controller");
       // openView("Display");

    }
    public void openView(String viewToOpen) throws IOException
    {
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        Stage tmpStage = new Stage();
        if("Radiator Controller".equals(viewToOpen))
        {
            loader.setLocation(getClass().getResource("../view/control/control.fxml"));
            root = loader.load();
            ControlViewController view = loader.getController();
            view.init(vmf.getControlViewModel());
            tmpStage.setTitle("Radiator Controller");
        }
        else if ("Display".equals(viewToOpen)) {
            loader.setLocation(getClass().getResource("../view/display/display.fxml"));
            root = loader.load();
            DisplayViewController view = loader.getController();
            view.init(vmf.getDisplayViewModel());
            tmpStage.setTitle("Display");
        }

        scene = new Scene(root);
        tmpStage.setScene(scene);
        tmpStage.show();
    }
}
