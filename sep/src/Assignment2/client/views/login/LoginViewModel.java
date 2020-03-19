package Assignment2.client.views.login;

import Assignment2.client.model.ChatModel;
import javafx.beans.property.StringProperty;

public class LoginViewModel {
    private StringProperty nameField;

    private ChatModel model;
    public LoginViewModel(ChatModel model)
    {
        this.model =model;
    }


}
