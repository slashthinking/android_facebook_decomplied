package com.facebook.orca.sms;

import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil.SmsAddress;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.users.BuiltInContactsUserIterator;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserBuilder;
import com.facebook.orca.users.UserPhoneNumber;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

public class MmsSmsUserUtils
{
  private final Provider<User> a;
  private final BuiltInContactsUserIterator b;
  private final OrcaPhoneNumberUtil c;

  public MmsSmsUserUtils(Provider<User> paramProvider, BuiltInContactsUserIterator paramBuiltInContactsUserIterator, OrcaPhoneNumberUtil paramOrcaPhoneNumberUtil)
  {
    this.a = paramProvider;
    this.b = paramBuiltInContactsUserIterator;
    this.c = paramOrcaPhoneNumberUtil;
  }

  private User a(String paramString1, String paramString2, String paramString3)
  {
    OrcaPhoneNumberUtil.SmsAddress localSmsAddress = this.c.a(paramString1);
    UserPhoneNumber localUserPhoneNumber = localSmsAddress.a(2);
    if (StringUtil.a(paramString2))
      paramString2 = localSmsAddress.c();
    return new UserBuilder().a(User.Type.PHONE_NUMBER, localSmsAddress.b()).a(paramString2).b(ImmutableList.a(localUserPhoneNumber)).d(paramString3).e(paramString3).w();
  }

  public ParticipantInfo a()
  {
    User localUser = (User)this.a.b();
    if (localUser.a() == User.Type.FACEBOOK);
    for (ParticipantInfo localParticipantInfo = new ParticipantInfo(localUser.c(), localUser.g(), localUser.b() + "@facebook.com"); ; localParticipantInfo = new ParticipantInfo(localUser.c(), localUser.g()))
    {
      return localParticipantInfo;
      if (localUser.a() != User.Type.PHONE_NUMBER)
        break;
    }
    throw new IllegalArgumentException("Invalid me user type");
  }

  public ParticipantInfo a(User paramUser)
  {
    if (paramUser.a() == User.Type.PHONE_NUMBER);
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramUser.a();
      Preconditions.checkArgument(bool, "Expecting User of type PHONE_NUMBER, was given User of type %s", arrayOfObject);
      String str1 = paramUser.b();
      OrcaPhoneNumberUtil.SmsAddress localSmsAddress = this.c.a(str1);
      String str2 = localSmsAddress.c();
      if (paramUser != null)
        str2 = paramUser.f();
      return new ParticipantInfo(localSmsAddress.d(), str2);
    }
  }

  public User a(String paramString)
  {
    this.b.a(paramString);
    while (true)
    {
      try
      {
        User localUser = this.b.b();
        this.b.a();
        if (localUser != null)
        {
          str2 = localUser.g();
          str1 = localUser.p();
          return a(paramString, str2, str1);
        }
      }
      finally
      {
        this.b.a();
      }
      String str1 = null;
      String str2 = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsUserUtils
 * JD-Core Version:    0.6.0
 */