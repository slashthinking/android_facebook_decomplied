package com.facebook.orca.push.c2dm;

import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.push.annotations.IsGcmEnabled;

class C2DMPushModule$PushTokenHolderProvider extends AbstractProvider<PushTokenHolder>
{
  private C2DMPushModule$PushTokenHolderProvider(C2DMPushModule paramC2DMPushModule)
  {
  }

  public PushTokenHolder a()
  {
    return new PushTokenHolder((OrcaSharedPreferences)b(OrcaSharedPreferences.class), a(String.class, MeUserId.class), ((Boolean)b(Boolean.class, IsGcmEnabled.class)).booleanValue());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMPushModule.PushTokenHolderProvider
 * JD-Core Version:    0.6.0
 */