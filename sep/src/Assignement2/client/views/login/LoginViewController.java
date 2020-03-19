package Assignement2.client.views.login;

import Assignement2.client.core.ViewHandler;
import Assignement2.client.core.ViewModelFactory;
import Assignement2.client.views.ViewController;

import javafx.scene.control.TextField;

public class LoginViewController implements ViewController {
    public TextField nameField;
    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;

    public void onLoginButton() {
        viewHandler.openChat();
    }

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=viewHandler;
        loginViewModel=vmf.getLoginViewModel();
    }
}
