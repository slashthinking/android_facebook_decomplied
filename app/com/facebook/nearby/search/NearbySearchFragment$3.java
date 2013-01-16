package com.facebook.nearby.search;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

class NearbySearchFragment$3
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    NearbySearchFragment.a(this.a, paramInt - NearbySearchFragment.c(this.a).getHeaderViewsCount());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.search.NearbySearchFragment.3
 * JD-Core Version:    0.6.0
 */