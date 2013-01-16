package com.facebook.orca.app;

import com.facebook.orca.auth.AuthDataStore;
import com.facebook.orca.auth.FacebookCredentials;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$FacebookCredentialsProvider extends AbstractProvider<FacebookCredentials>
{
  private MessagesModule$FacebookCredentialsProvider(MessagesModule paramMessagesModule)
  {
  }

  public FacebookCredentials a()
  {
    return ((AuthDataStore)b(AuthDataStore.class)).c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FacebookCredentialsProvider
 * JD-Core Version:    0.6.0
 */