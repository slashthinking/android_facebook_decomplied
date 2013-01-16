package com.facebook.orca.common.util;

import com.facebook.orca.users.UserPhoneNumber;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import javax.inject.Provider;

public class OrcaPhoneNumberUtil
{
  private final PhoneNumberUtil a;
  private final Provider<String> b;
  private final Provider<String> c;

  public OrcaPhoneNumberUtil(PhoneNumberUtil paramPhoneNumberUtil, Provider<String> paramProvider1, Provider<String> paramProvider2)
  {
    this.a = paramPhoneNumberUtil;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public OrcaPhoneNumberUtil.SmsAddress a(String paramString)
  {
    return new OrcaPhoneNumberUtil.SmsAddress(this, paramString);
  }

  public UserPhoneNumber a(String paramString, int paramInt)
  {
    return new OrcaPhoneNumberUtil.SmsAddress(this, paramString).a(paramInt);
  }

  public String b(String paramString)
  {
    return new OrcaPhoneNumberUtil.SmsAddress(this, paramString).b();
  }

  public String c(String paramString)
  {
    return new OrcaPhoneNumberUtil.SmsAddress(this, paramString).c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.OrcaPhoneNumberUtil
 * JD-Core Version:    0.6.0
 */