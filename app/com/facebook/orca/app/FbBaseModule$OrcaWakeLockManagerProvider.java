package com.facebook.orca.app;

import android.os.PowerManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$OrcaWakeLockManagerProvider extends AbstractProvider<OrcaWakeLockManager>
{
  private FbBaseModule$OrcaWakeLockManagerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public OrcaWakeLockManager a()
  {
    return new OrcaWakeLockManager((PowerManager)b(PowerManager.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.OrcaWakeLockManagerProvider
 * JD-Core Version:    0.6.0
 */