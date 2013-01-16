package com.facebook.orca.nux;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan.OnUrlClickHandler;

class ThreadListNuxController$4 extends CustomUrlLikeSpan.OnUrlClickHandler
{
  public void a()
  {
    ThreadListNuxController.a(this.a).a(new HoneyClientEvent("click").e("link").f("find_contacts_learn_more_link"));
    ThreadListNuxController.d(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.ThreadListNuxController.4
 * JD-Core Version:    0.6.0
 */