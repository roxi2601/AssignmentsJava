package Assignment2.client.views.login;

import Assignment2.client.core.ViewHandler;
import Assignment2.client.core.ViewModelFactory;
import Assignment2.client.views.ViewController;

import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginViewController implements ViewController {
    public TextField nameField;
    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) throws IOException
    {
        this.viewHandler=vh;
        loginViewModel=vmf.getLoginViewModel();
        nameField.textProperty().bindBidirectional(loginViewModel.getNameField());
    }
    public void onLoginButton() {
        viewHandler.openChat();
        loginViewModel.saveUsername(nameField.getText());
    }
}
