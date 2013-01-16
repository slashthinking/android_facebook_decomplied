package com.facebook.nearby.places;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.nearby.model.NearbyPlaceEdge;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

public class NearbyPlacesAdapter extends BaseAdapter
{
  private final Context a;
  private final Resources b;
  private final LayoutInflater c;
  private final Object d;
  private final Object e;
  private final Object f;
  private List<NearbyPlaceEdge> g;
  private NearbyPlacesAdapter.StateType h;
  private Location i;

  public NearbyPlacesAdapter(Context paramContext)
  {
    this.a = paramContext;
    this.b = this.a.getResources();
    this.c = LayoutInflater.from(this.a);
    this.g = Lists.a();
    this.h = NearbyPlacesAdapter.StateType.DISPLAY_RESULTS;
    this.d = new Object();
    this.e = new Object();
    this.f = new Object();
  }

  private View a(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null);
    while (true)
    {
      return paramView;
      paramView = this.c.inflate(2130903283, paramViewGroup, false);
      ((TextView)paramView.findViewById(2131297113)).setText(this.b.getString(2131361907));
    }
  }

  private View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    if (paramView != null);
    for (NearbyPlaceDetailsView localNearbyPlaceDetailsView = (NearbyPlaceDetailsView)paramView; ; localNearbyPlaceDetailsView = (NearbyPlaceDetailsView)this.c.inflate(2130903287, paramViewGroup, false))
    {
      localNearbyPlaceDetailsView.a((NearbyPlaceEdge)getItem(paramInt), this.i);
      return localNearbyPlaceDetailsView;
    }
  }

  private View b(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null);
    while (true)
    {
      return paramView;
      paramView = this.c.inflate(2130903283, paramViewGroup, false);
      ((TextView)paramView.findViewById(2131297113)).setText(this.b.getString(2131361906));
    }
  }

  private View c(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null);
    while (true)
    {
      return paramView;
      paramView = this.c.inflate(2130903300, paramViewGroup, false);
    }
  }

  private NearbyPlacesAdapter.RowType d()
  {
    NearbyPlacesAdapter.RowType localRowType;
    if (this.h == NearbyPlacesAdapter.StateType.DETECTING_LOCATION)
      localRowType = NearbyPlacesAdapter.RowType.DETECT_LOCATION;
    while (true)
    {
      return localRowType;
      if (this.h == NearbyPlacesAdapter.StateType.LOADING_PLACES)
      {
        localRowType = NearbyPlacesAdapter.RowType.PLACES_LOADING;
        continue;
      }
      if (this.g.isEmpty())
      {
        localRowType = NearbyPlacesAdapter.RowType.NO_RESULTS;
        continue;
      }
      localRowType = NearbyPlacesAdapter.RowType.PLACE_INFO;
    }
  }

  public void a()
  {
    this.h = NearbyPlacesAdapter.StateType.LOADING_PLACES;
    notifyDataSetChanged();
  }

  public void a(List<NearbyPlaceEdge> paramList, Location paramLocation)
  {
    Preconditions.checkNotNull(paramLocation, "There must exists a current location.");
    this.g = ImmutableList.a(paramList);
    this.i = paramLocation;
    this.h = NearbyPlacesAdapter.StateType.DISPLAY_RESULTS;
    notifyDataSetChanged();
  }

  public void b()
  {
    this.h = NearbyPlacesAdapter.StateType.DETECTING_LOCATION;
    notifyDataSetChanged();
  }

  public void c()
  {
    this.h = NearbyPlacesAdapter.StateType.DISPLAY_RESULTS;
    notifyDataSetChanged();
  }

  public int getCount()
  {
    int j = 1;
    if ((this.h == NearbyPlacesAdapter.StateType.DETECTING_LOCATION) || (this.h == NearbyPlacesAdapter.StateType.LOADING_PLACES));
    while (true)
    {
      return j;
      j = Math.max(j, this.g.size());
    }
  }

  public Object getItem(int paramInt)
  {
    Object localObject;
    if (this.h == NearbyPlacesAdapter.StateType.DETECTING_LOCATION)
      localObject = this.d;
    while (true)
    {
      return localObject;
      if (this.h == NearbyPlacesAdapter.StateType.LOADING_PLACES)
      {
        localObject = this.e;
        continue;
      }
      if (this.g.isEmpty())
      {
        localObject = this.f;
        continue;
      }
      localObject = this.g.get(paramInt);
    }
  }

  public long getItemId(int paramInt)
  {
    NearbyPlacesAdapter.RowType localRowType = d();
    long l;
    switch (NearbyPlacesAdapter.1.a[localRowType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unknown row type");
    case 1:
      l = -3L;
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return l;
      l = -1L;
      continue;
      l = -2L;
      continue;
      l = Long.valueOf(((NearbyPlaceEdge)getItem(paramInt)).place.id).longValue();
    }
  }

  public int getItemViewType(int paramInt)
  {
    return d().ordinal();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    View localView;
    if (localObject == this.d)
      localView = a(paramView, paramViewGroup);
    while (true)
    {
      return localView;
      if (localObject == this.e)
      {
        localView = b(paramView, paramViewGroup);
        continue;
      }
      if (localObject == this.f)
      {
        localView = c(paramView, paramViewGroup);
        continue;
      }
      localView = a(paramView, paramViewGroup, paramInt);
    }
  }

  public int getViewTypeCount()
  {
    return NearbyPlacesAdapter.RowType.values().length;
  }

  public boolean hasStableIds()
  {
    return true;
  }

  public boolean isEnabled(int paramInt)
  {
    int j = NearbyPlacesAdapter.1.a[d().ordinal()];
    int k = 0;
    switch (j)
    {
    default:
      throw new IllegalArgumentException("Unknown row type");
    case 4:
      k = 1;
    case 1:
    case 2:
    case 3:
    }
    return k;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyPlacesAdapter
 * JD-Core Version:    0.6.0
 */