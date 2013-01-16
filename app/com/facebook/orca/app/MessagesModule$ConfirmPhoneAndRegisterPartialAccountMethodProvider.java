package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.protocol.methods.ConfirmPhoneAndRegisterPartialAccountMethod;

class MessagesModule$ConfirmPhoneAndRegisterPartialAccountMethodProvider extends AbstractProvider<ConfirmPhoneAndRegisterPartialAccountMethod>
{
  private MessagesModule$ConfirmPhoneAndRegisterPartialAccountMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public ConfirmPhoneAndRegisterPartialAccountMethod a()
  {
    return new ConfirmPhoneAndRegisterPartialAccountMethod((OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ConfirmPhoneAndRegisterPartialAccountMethodProvider
 * JD-Core Version:    0.6.0
 */