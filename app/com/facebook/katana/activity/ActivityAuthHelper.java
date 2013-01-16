package com.facebook.katana.activity;

import android.app.Activity;
import com.facebook.katana.LoginActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.orca.activity.AbstractFbActivityListener;
import com.facebook.orca.annotations.AuthNotRequired;
import com.facebook.orca.auth.MeUserAuthDataStore;

public class ActivityAuthHelper extends AbstractFbActivityListener
{
  private final MeUserAuthDataStore a;

  public ActivityAuthHelper(MeUserAuthDataStore paramMeUserAuthDataStore)
  {
    this.a = paramMeUserAuthDataStore;
  }

  private void i(Activity paramActivity)
  {
    if (paramActivity.getClass().getAnnotation(AuthNotRequired.class) != null);
    while (true)
    {
      return;
      if ((AppSession.b(paramActivity, true) == null) || (!this.a.d()))
      {
        LoginActivity.b(paramActivity);
        continue;
      }
    }
  }

  public void b(Activity paramActivity)
  {
    i(paramActivity);
  }

  public void f(Activity paramActivity)
  {
    i(paramActivity);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.ActivityAuthHelper
 * JD-Core Version:    0.6.0
 */