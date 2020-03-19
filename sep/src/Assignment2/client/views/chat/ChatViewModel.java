package Assignment2.client.views.chat;

import Assignment2.client.model.ChatModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.io.IOException;

public class ChatViewModel {

  private StringProperty chatArea, sendField;
  private ChatModel model;

  public ChatViewModel(ChatModel chatModel)
  {
    chatArea = new SimpleStringProperty();
    sendField = new SimpleStringProperty();
    model = chatModel;
    model.addListener("NewMessage",this::receiveMessage);
  }
  public StringProperty getChatAreaProperty()
  {
    return chatArea;
  }
  public StringProperty getSendFieldProperty()
  {
    return sendField;
  }

  public void receiveMessage(PropertyChangeEvent evt)
  {
    if(chatArea.get()!=null)
    chatArea.setValue(chatArea.get()+"\n"+evt.getNewValue());
    else
      chatArea.setValue(evt.getNewValue()+"");
  }
  public void sendMessage(String msg) throws IOException
  {
    String un = model.getUsername();
    System.out.println("view model tells model to send "+ msg+ " from "+model.getUsername());
    model.sendMessage(un+": "+msg);
  }
}
