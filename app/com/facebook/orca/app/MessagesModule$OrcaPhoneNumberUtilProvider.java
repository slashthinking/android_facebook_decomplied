package com.facebook.orca.app;

import com.facebook.orca.annotations.MeUserPhoneNumber;
import com.facebook.orca.annotations.PhoneIsoCountryCode;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

class MessagesModule$OrcaPhoneNumberUtilProvider extends AbstractProvider<OrcaPhoneNumberUtil>
{
  private MessagesModule$OrcaPhoneNumberUtilProvider(MessagesModule paramMessagesModule)
  {
  }

  public OrcaPhoneNumberUtil a()
  {
    return new OrcaPhoneNumberUtil((PhoneNumberUtil)b(PhoneNumberUtil.class), a(String.class, PhoneIsoCountryCode.class), a(String.class, MeUserPhoneNumber.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.OrcaPhoneNumberUtilProvider
 * JD-Core Version:    0.6.0
 */