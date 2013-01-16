package com.facebook.orca.app;

import com.facebook.orca.auth.FacebookCredentials;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.auth.UserTokenCredentials;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.User;

class MessagesModule$UserCredentialsProvider extends AbstractProvider<UserTokenCredentials>
{
  private MessagesModule$UserCredentialsProvider(MessagesModule paramMessagesModule)
  {
  }

  public UserTokenCredentials a()
  {
    MeUserAuthDataStore localMeUserAuthDataStore = (MeUserAuthDataStore)b(MeUserAuthDataStore.class);
    User localUser = localMeUserAuthDataStore.g();
    FacebookCredentials localFacebookCredentials = localMeUserAuthDataStore.c();
    if ((localUser != null) && (localFacebookCredentials != null) && (localUser.b() != null) && (localFacebookCredentials.a() != null));
    for (UserTokenCredentials localUserTokenCredentials = new UserTokenCredentials(localUser.b(), localFacebookCredentials.a()); ; localUserTokenCredentials = null)
      return localUserTokenCredentials;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.UserCredentialsProvider
 * JD-Core Version:    0.6.0
 */