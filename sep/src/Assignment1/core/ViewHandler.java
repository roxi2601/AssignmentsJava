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

   private ViewModelFactory viewModelFactory;
   private Scene controlScene;
   private Scene displayScene;
   private Stage mainStage;

    public ViewHandler(Stage mainStage, ViewModelFactory viewModelFactory)
    {
        this.mainStage=mainStage;
        this.viewModelFactory = viewModelFactory;
    }
    public void start() throws Exception
    {
        openControlView();
    }
    public void openControlView()
    {
        try
        {
            if(controlScene==null)
            {
                controlScene = getSceneController("../view/control/control.fxml");
                changeScene("Radiator controller", controlScene);
            }
            else
                changeScene("Radiator controller", controlScene);

        }
        catch (Exception e)
        {
            e.printStackTrace();
//sjugsh
        }
    }
    public void openDisplayView()
    {
        try {
            if(displayScene==null)
            {
                displayScene=getSceneDisplay("../view/display/display.fxml");
                changeScene("Display",displayScene);
            }
            else
                changeScene("Display",displayScene);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void changeScene(String s, Scene scene)
    {
        mainStage.setTitle(s);
        mainStage.setScene(scene);
        mainStage.show();
    }
    private Scene getSceneController(String path) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource(path));
            root = loader.load();

            ControlViewController view = loader.getController();
            view.init(this, viewModelFactory);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scene(root);
    }
    private Scene getSceneDisplay(String path) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource(path));
            root = loader.load();

            DisplayViewController view = loader.getController();
            view.init(this, viewModelFactory);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scene(root);


    }
}
