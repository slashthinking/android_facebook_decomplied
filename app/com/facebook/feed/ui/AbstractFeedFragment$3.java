package com.facebook.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.data.AbstractDataLoader;
import com.facebook.orca.server.DataFreshnessParam;

class AbstractFeedFragment$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.a.g.setVisibility(8);
    this.a.N().a(DataFreshnessParam.STALE_DATA_OKAY, this.a.N().g(), this.a.ai);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.AbstractFeedFragment.3
 * JD-Core Version:    0.6.0
 */