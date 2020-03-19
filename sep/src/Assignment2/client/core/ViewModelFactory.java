package Assignment2.client.core;

import Assignment2.client.views.chat.ChatViewModel;
import Assignment2.client.views.login.LoginViewModel;

import java.io.IOException;

public class ViewModelFactory {
  private final ModelFactory mf;
  private ChatViewModel chatViewModel;
  private LoginViewModel loginViewModel;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public ChatViewModel getChatViewModel() throws IOException
  {
    if(chatViewModel ==null)
      chatViewModel = new ChatViewModel(mf.getChatModel());
    return chatViewModel;
  }

  public LoginViewModel getLoginViewModel() throws IOException
  {
    if(loginViewModel==null)
      loginViewModel = new LoginViewModel(mf.getChatModel());
    return loginViewModel;
  }
}
