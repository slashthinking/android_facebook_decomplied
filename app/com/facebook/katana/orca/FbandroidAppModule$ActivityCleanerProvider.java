package com.facebook.katana.orca;

import android.app.ActivityManager;
import com.facebook.katana.activity.ActivityCleaner;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$ActivityCleanerProvider extends AbstractProvider<ActivityCleaner>
{
  private FbandroidAppModule$ActivityCleanerProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public ActivityCleaner a()
  {
    ActivityManager localActivityManager = (ActivityManager)b(ActivityManager.class, FromApplication.class);
    return new ActivityCleaner((Clock)b(Clock.class), localActivityManager.getMemoryClass());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.ActivityCleanerProvider
 * JD-Core Version:    0.6.0
 */