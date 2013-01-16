package com.facebook.katana.activity.notifications;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;

public class NotificationsActivity extends BaseFacebookActivity
  implements AnalyticsActivity, NotNewNavEnabled
{
  public String a()
  {
    return FB4A_AnalyticEntities.w;
  }

  protected void a(Bundle paramBundle)
  {
    setContentView(2130903305);
  }

  public String i()
  {
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.notifications.NotificationsActivity
 * JD-Core Version:    0.6.0
 */