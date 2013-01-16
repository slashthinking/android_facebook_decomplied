package com.facebook.katana.activity.places;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.ipc.katana.model.FacebookPage;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class PlacesInfoAdapter extends BaseAdapter
{
  private final Context a;
  private final List<PlacesInfoAdapter.Item> b;

  public PlacesInfoAdapter(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ArrayList();
  }

  public void a(FacebookPlace paramFacebookPlace)
  {
    this.b.clear();
    FacebookPage localFacebookPage = paramFacebookPlace.a();
    if ((localFacebookPage != null) && (localFacebookPage.mFanCount != -1) && (localFacebookPage.mFanCount != 0))
    {
      List localList2 = this.b;
      Resources localResources2 = this.a.getResources();
      int j = localFacebookPage.mFanCount;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(localFacebookPage.mFanCount);
      localList2.add(new PlacesInfoAdapter.Item(0, localResources2.getQuantityString(2131427357, j, arrayOfObject2), null));
    }
    if (paramFacebookPlace.mCheckinCount != 0)
    {
      List localList1 = this.b;
      Resources localResources1 = this.a.getResources();
      int i = paramFacebookPlace.mCheckinCount;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(paramFacebookPlace.mCheckinCount);
      localList1.add(new PlacesInfoAdapter.Item(0, localResources1.getQuantityString(2131427358, i, arrayOfObject1), null));
    }
    if ((localFacebookPage != null) && (localFacebookPage.mLocation != null))
    {
      String str = StringUtils.a(localFacebookPage.mLocation);
      if (!StringUtils.c(str))
        this.b.add(new PlacesInfoAdapter.Item(1, this.a.getString(2131363077), str));
    }
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.b.size();
  }

  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    int i;
    switch (PlacesInfoAdapter.Item.a((PlacesInfoAdapter.Item)this.b.get(paramInt)))
    {
    default:
      i = -1;
    case 0:
    case 1:
    }
    while (true)
    {
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PlacesInfoAdapter.Item localItem = (PlacesInfoAdapter.Item)this.b.get(paramInt);
    LayoutInflater localLayoutInflater;
    if (paramView == null)
      localLayoutInflater = (LayoutInflater)this.a.getSystemService("layout_inflater");
    View localView;
    switch (PlacesInfoAdapter.Item.a(localItem))
    {
    default:
      localView = null;
      paramView = localView;
      switch (PlacesInfoAdapter.Item.a(localItem))
      {
      default:
      case 0:
      case 1:
      }
    case 0:
    case 1:
    }
    while (true)
    {
      return paramView;
      localView = localLayoutInflater.inflate(2130903245, null);
      break;
      localView = localLayoutInflater.inflate(2130903245, null);
      break;
      if (!StringUtils.c(localItem.a()))
        ((TextView)paramView.findViewById(2131297010)).setText(localItem.a());
      while (true)
      {
        if (StringUtils.c(localItem.b()))
          break label196;
        ((TextView)paramView.findViewById(2131297011)).setText(localItem.b());
        break;
        ((TextView)paramView.findViewById(2131297010)).setVisibility(8);
      }
      label196: ((TextView)paramView.findViewById(2131297011)).setVisibility(8);
      continue;
      if (!StringUtils.c(localItem.a()))
        ((TextView)paramView.findViewById(2131297010)).setText(localItem.a());
      while (true)
      {
        if (StringUtils.c(localItem.b()))
          break label289;
        ((TextView)paramView.findViewById(2131297011)).setText(localItem.b());
        break;
        ((TextView)paramView.findViewById(2131297010)).setVisibility(8);
      }
      label289: ((TextView)paramView.findViewById(2131297011)).setVisibility(8);
    }
  }

  public int getViewTypeCount()
  {
    return 2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.PlacesInfoAdapter
 * JD-Core Version:    0.6.0
 */