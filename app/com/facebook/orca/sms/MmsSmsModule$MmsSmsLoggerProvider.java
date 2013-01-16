package com.facebook.orca.sms;

import android.content.pm.PackageManager;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MmsSmsModule$MmsSmsLoggerProvider extends AbstractProvider<MmsSmsLogger>
{
  private MmsSmsModule$MmsSmsLoggerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsSmsLogger a()
  {
    return new MmsSmsLogger(MmsSmsModule.a(this.a), (AnalyticsLogger)b(AnalyticsLogger.class), (PackageManager)b(PackageManager.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsSmsLoggerProvider
 * JD-Core Version:    0.6.0
 */