package com.facebook.orca.app;

import com.facebook.orca.auth.FacebookCredentials;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$AuthTokenStringProvider extends AbstractProvider<String>
{
  private MessagesModule$AuthTokenStringProvider(MessagesModule paramMessagesModule)
  {
  }

  public String a()
  {
    FacebookCredentials localFacebookCredentials = (FacebookCredentials)b(FacebookCredentials.class);
    if (localFacebookCredentials != null);
    for (String str = localFacebookCredentials.a(); ; str = null)
      return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.AuthTokenStringProvider
 * JD-Core Version:    0.6.0
 */