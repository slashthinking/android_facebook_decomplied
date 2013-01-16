package com.facebook.katana.activity;

import com.facebook.analytics.AnalyticsActivity;
import com.facebook.katana.features.bugreporter.annotations.BugReportingNotRequired;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.orca.activity.BaseSplashScreenActivity;
import com.facebook.orca.annotations.AppInitializationNotRequired;
import com.facebook.orca.annotations.AuthNotRequired;

@BugReportingNotRequired
@AppInitializationNotRequired
@AuthNotRequired
public class FB4ASplashScreenActivity extends BaseSplashScreenActivity
  implements AnalyticsActivity
{
  public FB4ASplashScreenActivity()
  {
    super(2130903139, FbFragmentChromeActivity.class);
  }

  public String a()
  {
    return FB4A_AnalyticEntities.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FB4ASplashScreenActivity
 * JD-Core Version:    0.6.0
 */