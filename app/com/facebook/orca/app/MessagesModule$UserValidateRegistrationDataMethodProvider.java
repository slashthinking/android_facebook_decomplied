package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.protocol.methods.UserValidateRegistrationDataMethod;

class MessagesModule$UserValidateRegistrationDataMethodProvider extends AbstractProvider<UserValidateRegistrationDataMethod>
{
  private MessagesModule$UserValidateRegistrationDataMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public UserValidateRegistrationDataMethod a()
  {
    return new UserValidateRegistrationDataMethod((OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.UserValidateRegistrationDataMethodProvider
 * JD-Core Version:    0.6.0
 */