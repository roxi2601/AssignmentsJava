package Assignment2.client.views.chat;

import Assignment2.client.core.ViewHandler;
import Assignment2.client.core.ViewModelFactory;
import Assignment2.client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChatViewController implements ViewController
{
  @FXML
  private TextArea chatArea;
  @FXML
  private TextField sendField;

  private ChatViewModel viewModel;


  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
      throws IOException
  {
    this.viewModel = vmf.getChatViewModel();

    chatArea.setDisable(true);

    chatArea.textProperty().bind(viewModel.getChatAreaProperty());
    sendField.textProperty().bindBidirectional(viewModel.getSendFieldProperty());
  }
  public void onSendButton() throws IOException
  {
  viewModel.sendMessage(sendField.getText());
  sendField.clear();
  }
}
