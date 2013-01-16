package com.facebook.app;

import android.app.KeyguardManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.app.ActivityBroadcaster;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class UserActivityModule$UserActivityManagerProvider extends AbstractProvider<UserActivityManager>
{
  private UserActivityModule$UserActivityManagerProvider(UserActivityModule paramUserActivityModule)
  {
  }

  public UserActivityManager a()
  {
    return new UserActivityManager((ActivityBroadcaster)b(ActivityBroadcaster.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (Clock)b(Clock.class), (KeyguardManager)b(KeyguardManager.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.app.UserActivityModule.UserActivityManagerProvider
 * JD-Core Version:    0.6.0
 */