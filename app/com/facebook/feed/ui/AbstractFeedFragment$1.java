package com.facebook.feed.ui;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.data.AbstractDataLoader;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer.OnRefreshListener;
import com.facebook.orca.server.DataFreshnessParam;

class AbstractFeedFragment$1 extends RefreshableListViewContainer.OnRefreshListener
{
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.N().a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, this.a.N().g(), this.a.ah);
      HoneyClientEvent localHoneyClientEvent = this.a.h.a();
      if (localHoneyClientEvent != null)
        this.a.i.a(localHoneyClientEvent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.AbstractFeedFragment.1
 * JD-Core Version:    0.6.0
 */