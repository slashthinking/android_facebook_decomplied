package com.facebook.orca.common.util;

import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.facebook.orca.users.UserPhoneNumber;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import javax.inject.Provider;

public class OrcaPhoneNumberUtil$SmsAddress
{
  private final String b;
  private final Phonenumber.PhoneNumber c;

  public OrcaPhoneNumberUtil$SmsAddress(OrcaPhoneNumberUtil paramOrcaPhoneNumberUtil, String paramString)
  {
    this.b = paramString;
    this.c = a(paramString);
  }

  private Phonenumber.PhoneNumber a(String paramString)
  {
    String str = (String)OrcaPhoneNumberUtil.c(this.a).b();
    if (paramString != null);
    while (true)
    {
      try
      {
        Phonenumber.PhoneNumber localPhoneNumber2 = OrcaPhoneNumberUtil.a(this.a).parse(paramString, str);
        localPhoneNumber1 = localPhoneNumber2;
        return localPhoneNumber1;
      }
      catch (NumberParseException localNumberParseException)
      {
        localPhoneNumber1 = null;
        continue;
      }
      Phonenumber.PhoneNumber localPhoneNumber1 = null;
    }
  }

  public UserPhoneNumber a(int paramInt)
  {
    return new UserPhoneNumber(c(), b(), paramInt);
  }

  public boolean a()
  {
    if (this.c != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public String b()
  {
    String str;
    if (this.c == null)
      str = this.b;
    while (true)
    {
      return str;
      if (!OrcaPhoneNumberUtil.a(this.a).isValidNumber(this.c))
      {
        str = this.b;
        continue;
      }
      str = OrcaPhoneNumberUtil.a(this.a).format(this.c, PhoneNumberUtil.PhoneNumberFormat.E164);
    }
  }

  public String c()
  {
    String str;
    if (this.c == null)
    {
      str = this.b;
      return str;
    }
    Phonenumber.PhoneNumber localPhoneNumber = a((String)OrcaPhoneNumberUtil.b(this.a).b());
    if ((localPhoneNumber == null) || (localPhoneNumber.getCountryCode() != this.c.getCountryCode()));
    for (PhoneNumberUtil.PhoneNumberFormat localPhoneNumberFormat = PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL; ; localPhoneNumberFormat = PhoneNumberUtil.PhoneNumberFormat.NATIONAL)
    {
      str = OrcaPhoneNumberUtil.a(this.a).format(this.c, localPhoneNumberFormat).replace(' ', ' ').replace('-', '‑');
      break;
    }
  }

  public UserKey d()
  {
    return new UserKey(User.Type.PHONE_NUMBER, b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.OrcaPhoneNumberUtil.SmsAddress
 * JD-Core Version:    0.6.0
 */