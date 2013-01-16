package com.facebook.nearby.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.nearby.model.NearbyTopic;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class SubcategorySearchAdapter extends BaseAdapter
{
  private final Context a;
  private ImmutableList<NearbyTopic> b;

  public SubcategorySearchAdapter(Context paramContext)
  {
    this.a = paramContext;
  }

  public void a(List<NearbyTopic> paramList)
  {
    this.b = ImmutableList.a(paramList);
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.b.size();
  }

  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null);
    for (NearbySearchTopicRowView localNearbySearchTopicRowView = (NearbySearchTopicRowView)paramView; ; localNearbySearchTopicRowView = new NearbySearchTopicRowView(this.a))
    {
      localNearbySearchTopicRowView.a((NearbyTopic)getItem(paramInt));
      return localNearbySearchTopicRowView;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.search.SubcategorySearchAdapter
 * JD-Core Version:    0.6.0
 */