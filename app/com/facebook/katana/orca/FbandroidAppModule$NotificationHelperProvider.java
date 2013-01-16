package com.facebook.katana.orca;

import android.content.Context;
import com.facebook.feed.annotations.IsNativeNewsFeedEnabled;
import com.facebook.katana.model.NotificationHelper;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$NotificationHelperProvider extends AbstractProvider<NotificationHelper>
{
  private FbandroidAppModule$NotificationHelperProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public NotificationHelper a()
  {
    return new NotificationHelper((Context)b(Context.class, FromApplication.class), a(Boolean.class, IsNativeNewsFeedEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.NotificationHelperProvider
 * JD-Core Version:    0.6.0
 */