package Assignment2.client.core;

import Assignment2.client.views.ViewController;
import Assignment2.client.views.chat.ChatViewModel;
import Assignment2.client.views.login.LoginViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

  private Scene loginScene;
  private Stage stage;
  private ViewModelFactory vmf;
  private Scene chatScene;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }
  public void start()
  {
    stage = new Stage();
    openLogin();
  }
  public void openLogin() {
    if (loginScene == null) {
      try {
        Parent root = loadFXML("../views/login/Login.fxml");

        stage.setTitle("Log in ");
        loginScene = new Scene(root);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(loginScene);
    stage.show();
  }

  public void openChat() {

    if (chatScene == null) {
      try {
        Parent root = loadFXML("../views/chat/Chat.fxml");
        chatScene = new Scene(root);
        stage.setTitle("Chat");

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(chatScene);
    stage.show();
  }

  private Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }

}
