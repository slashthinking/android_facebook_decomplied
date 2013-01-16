package com.facebook.app;

import android.app.Activity;
import com.facebook.orca.activity.AbstractFbActivityListener;

public class UserActivityManager$MyActivityListener extends AbstractFbActivityListener
{
  public UserActivityManager$MyActivityListener(UserActivityManager paramUserActivityManager)
  {
  }

  public void b(Activity paramActivity)
  {
    UserActivityManager.a(this.a);
  }

  public void c(Activity paramActivity)
  {
    UserActivityManager.b(this.a);
  }

  public void e(Activity paramActivity)
  {
    UserActivityManager.c(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.app.UserActivityManager.MyActivityListener
 * JD-Core Version:    0.6.0
 */