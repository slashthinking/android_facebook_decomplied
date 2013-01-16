package com.facebook.feed.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.facebook.feed.data.AbstractDataLoader;
import com.facebook.feed.data.FeedDataLoaderListener;
import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.feed.model.FetchResultState;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.server.DataFreshnessParam;
import com.google.common.base.Preconditions;

class AbstractFeedFragment$2
  implements FeedDataLoaderListener
{
  public void a()
  {
    if (this.a.K())
    {
      if (!this.a.c.d())
        break label34;
      this.a.a.c();
    }
    while (true)
    {
      return;
      label34: this.a.a.b();
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      this.a.c.a();
    this.a.M();
    if (paramBoolean)
    {
      if (this.a.d.a() - this.a.d.b() < 1)
        this.a.c.a(1, 0);
      this.a.c.b();
    }
  }

  public void a(boolean paramBoolean, FetchResultState paramFetchResultState, Bundle paramBundle, int paramInt)
  {
    Preconditions.checkNotNull(paramBundle);
    Preconditions.checkState(paramBundle.containsKey("uui"));
    boolean bool1 = paramBundle.getBoolean("uui");
    if (!this.a.K());
    boolean bool2;
    label76: AbstractFeedFragment.ErrorState localErrorState;
    while (true)
    {
      return;
      bool2 = this.a.aa.b();
      switch (AbstractFeedFragment.7.a[paramFetchResultState.ordinal()])
      {
      default:
        if ((this.a.a != null) && (paramBoolean))
          this.a.a.d();
        break;
      case 1:
        if (bool2)
          this.a.c.b(false);
        if (this.a.aj)
        {
          this.a.b();
          this.a.aj = false;
        }
        if ((paramBoolean) && (bool1) && (!this.a.a.a()) && (paramInt > 0))
        {
          this.a.f(paramInt);
          this.a.c.a();
        }
        this.a.M();
        NewsFeedListView localNewsFeedListView;
        if ((paramInt > 0) && (bool1))
        {
          localNewsFeedListView = this.a.c;
          if (!AbstractFeedFragment.a(this.a, paramInt))
            break label312;
        }
        for (int j = 1; ; j = 0)
        {
          localNewsFeedListView.a(j + paramInt, (int)this.a.a.getHeaderHeightExposed());
          this.a.onScroll(this.a.c, this.a.c.getFirstVisiblePosition(), 1 + (this.a.c.getLastVisiblePosition() - this.a.c.getFirstVisiblePosition()), this.a.d.getCount());
          break;
        }
      case 2:
        label312: AbstractFeedFragment localAbstractFeedFragment = this.a;
        if (!bool2)
          break label436;
        localErrorState = AbstractFeedFragment.ErrorState.SERVER_ERROR;
        label334: int i = localAbstractFeedFragment.a(localErrorState);
        ((TextView)this.a.f.findViewById(2131296699)).setText(i);
        ((TextView)this.a.g.findViewById(2131296703)).setText(i);
        if (this.a.ad.a() <= 0)
          break label444;
        if ((bool2) || (bool2 != this.a.ab))
          this.a.c.b(true);
      }
    }
    while (true)
    {
      this.a.ab = bool2;
      break label76;
      break;
      label436: localErrorState = AbstractFeedFragment.ErrorState.CONNECTION_ERROR;
      break label334;
      label444: this.a.g.setVisibility(0);
    }
  }

  public void b()
  {
    this.a.M();
    this.a.N().a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, this.a.N().g(), this.a.ah);
  }

  public void b(boolean paramBoolean)
  {
    NewsFeedListView localNewsFeedListView;
    if (this.a.K())
    {
      this.a.ab = paramBoolean;
      localNewsFeedListView = this.a.c;
      if (paramBoolean)
        break label54;
    }
    label54: for (boolean bool = true; ; bool = false)
    {
      localNewsFeedListView.b(bool);
      if (paramBoolean)
        this.a.g.setVisibility(8);
      return;
    }
  }

  public boolean c()
  {
    return this.a.s();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.AbstractFeedFragment.2
 * JD-Core Version:    0.6.0
 */