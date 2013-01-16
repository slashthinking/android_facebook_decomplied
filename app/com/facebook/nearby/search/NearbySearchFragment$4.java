package com.facebook.nearby.search;

import com.facebook.nearby.model.NearbyTopic;
import com.google.common.collect.ImmutableMap;

class NearbySearchFragment$4
  implements NearbySearchCategoriesView.OnCategoryClickedListener
{
  public void a(NearbyTopic paramNearbyTopic)
  {
    if (NearbySearchCategoryList.a(this.a.p()).i.get(paramNearbyTopic.a) != null)
      NearbySearchFragment.a(this.a, paramNearbyTopic);
    while (true)
    {
      return;
      NearbySearchFragment.b(this.a, paramNearbyTopic);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.search.NearbySearchFragment.4
 * JD-Core Version:    0.6.0
 */