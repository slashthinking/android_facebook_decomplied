package com.facebook.nearby.search;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.nearby.model.NearbyTopic;

class SubcategorySearchFragment$1
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = SubcategorySearchFragment.a(this.a).getItem(paramInt);
    if ((localObject instanceof NearbyTopic))
    {
      SubcategorySearchFragment.a(this.a, (NearbyTopic)localObject);
      return;
    }
    throw new RuntimeException("unexpected object type: " + localObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.search.SubcategorySearchFragment.1
 * JD-Core Version:    0.6.0
 */