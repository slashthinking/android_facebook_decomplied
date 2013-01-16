package com.facebook.nearby.search;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.nearby.model.NearbyTopic;
import com.facebook.nearby.model.TypeaheadPlace;
import com.facebook.nearby.places.NearbyPlaceDetailsView;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class NearbySearchAdapter extends BaseAdapter
{
  private final Context a;
  private final LayoutInflater b;
  private ImmutableList<NearbyTopic> c;
  private ImmutableList<TypeaheadPlace> d;
  private Location e;

  public NearbySearchAdapter(Context paramContext)
  {
    this.a = paramContext;
    this.c = ImmutableList.d();
    this.d = ImmutableList.d();
    this.b = LayoutInflater.from(this.a);
  }

  private int a(NearbySearchAdapter.RowType paramRowType)
  {
    switch (NearbySearchAdapter.1.a[paramRowType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unexpected RowType type: " + paramRowType);
    case 1:
    case 2:
    }
    for (int i = 0; ; i = this.c.size())
      return i;
  }

  private NearbyPlaceDetailsView a(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null);
    for (NearbyPlaceDetailsView localNearbyPlaceDetailsView = (NearbyPlaceDetailsView)paramView; ; localNearbyPlaceDetailsView = (NearbyPlaceDetailsView)this.b.inflate(2130903291, paramViewGroup, false))
      return localNearbyPlaceDetailsView;
  }

  private NearbySearchAdapter.RowType a(int paramInt)
  {
    if (paramInt < this.c.size());
    for (NearbySearchAdapter.RowType localRowType = NearbySearchAdapter.RowType.TOPIC_INFO; ; localRowType = NearbySearchAdapter.RowType.PLACE_INFO)
      return localRowType;
  }

  private NearbySearchTopicRowView a(View paramView)
  {
    if (paramView != null);
    for (NearbySearchTopicRowView localNearbySearchTopicRowView = (NearbySearchTopicRowView)paramView; ; localNearbySearchTopicRowView = new NearbySearchTopicRowView(this.a))
      return localNearbySearchTopicRowView;
  }

  public void a(List<NearbyTopic> paramList)
  {
    this.c = ImmutableList.a(paramList);
    this.d = ImmutableList.d();
    notifyDataSetChanged();
  }

  public void a(List<NearbyTopic> paramList, List<TypeaheadPlace> paramList1, Location paramLocation)
  {
    this.c = ImmutableList.a(paramList);
    this.d = ImmutableList.a(paramList1);
    this.e = paramLocation;
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.c.size() + this.d.size();
  }

  public Object getItem(int paramInt)
  {
    NearbySearchAdapter.RowType localRowType = a(paramInt);
    int i = a(localRowType);
    switch (NearbySearchAdapter.1.a[localRowType.ordinal()])
    {
    default:
      throw new IllegalStateException("Unexpected RowType type: " + localRowType);
    case 1:
    case 2:
    }
    for (Object localObject = this.c.get(paramInt - i); ; localObject = this.d.get(paramInt - i))
      return localObject;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    return a(paramInt).ordinal();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    NearbySearchAdapter.RowType localRowType = a(paramInt);
    NearbySearchTopicRowView localNearbySearchTopicRowView;
    switch (NearbySearchAdapter.1.a[localRowType.ordinal()])
    {
    default:
      throw new IllegalStateException("Unexpected type");
    case 1:
      localNearbySearchTopicRowView = a(paramView);
      localNearbySearchTopicRowView.a((NearbyTopic)getItem(paramInt));
    case 2:
    }
    NearbyPlaceDetailsView localNearbyPlaceDetailsView;
    for (Object localObject = localNearbySearchTopicRowView; ; localObject = localNearbyPlaceDetailsView)
    {
      return localObject;
      localNearbyPlaceDetailsView = a(paramView, paramViewGroup);
      localNearbyPlaceDetailsView.a((TypeaheadPlace)getItem(paramInt), this.e);
    }
  }

  public int getViewTypeCount()
  {
    return NearbySearchAdapter.RowType.values().length;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.search.NearbySearchAdapter
 * JD-Core Version:    0.6.0
 */