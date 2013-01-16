package com.facebook.orca.sms;

import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.BuiltInContactsUserIterator;
import com.facebook.orca.users.User;

class MmsSmsModule$MmsSmsUserUtilsProvider extends AbstractProvider<MmsSmsUserUtils>
{
  private MmsSmsModule$MmsSmsUserUtilsProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsSmsUserUtils a()
  {
    return new MmsSmsUserUtils(a(User.class, MeUser.class), (BuiltInContactsUserIterator)b(BuiltInContactsUserIterator.class), (OrcaPhoneNumberUtil)b(OrcaPhoneNumberUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsSmsUserUtilsProvider
 * JD-Core Version:    0.6.0
 */