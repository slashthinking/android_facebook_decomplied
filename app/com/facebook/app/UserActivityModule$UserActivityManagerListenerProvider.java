package com.facebook.app;

import com.facebook.orca.inject.AbstractProvider;

class UserActivityModule$UserActivityManagerListenerProvider extends AbstractProvider<UserActivityManager.MyActivityListener>
{
  private UserActivityModule$UserActivityManagerListenerProvider(UserActivityModule paramUserActivityModule)
  {
  }

  public UserActivityManager.MyActivityListener a()
  {
    return ((UserActivityManager)b(UserActivityManager.class)).e();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.app.UserActivityModule.UserActivityManagerListenerProvider
 * JD-Core Version:    0.6.0
 */