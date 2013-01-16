package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaAuthPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MessagesModule$ShouldExpireAuthTokenProvider extends AbstractProvider<Boolean>
{
  private MessagesModule$ShouldExpireAuthTokenProvider(MessagesModule paramMessagesModule)
  {
  }

  public Boolean a()
  {
    return Boolean.valueOf(((OrcaSharedPreferences)b(OrcaSharedPreferences.class)).a(OrcaAuthPrefKeys.a, false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ShouldExpireAuthTokenProvider
 * JD-Core Version:    0.6.0
 */