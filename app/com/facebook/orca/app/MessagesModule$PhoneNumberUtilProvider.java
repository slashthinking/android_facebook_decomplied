package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

class MessagesModule$PhoneNumberUtilProvider extends AbstractProvider<PhoneNumberUtil>
{
  private MessagesModule$PhoneNumberUtilProvider(MessagesModule paramMessagesModule)
  {
  }

  public PhoneNumberUtil a()
  {
    return PhoneNumberUtil.getInstance();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.PhoneNumberUtilProvider
 * JD-Core Version:    0.6.0
 */