package com.facebook.katana.activity.places;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.Log;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookEvent;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.util.StringUtils;
import com.facebook.widget.UrlImage;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectAtTagAdapter extends BaseAdapter
{
  private static final Class<?> a = SelectAtTagAdapter.class;
  private List<FacebookPlace> b;
  private Map<Long, FacebookPlace> c;
  private SelectAtTagActivity d;
  private boolean e = false;
  private LayoutInflater f;

  public SelectAtTagAdapter(SelectAtTagActivity paramSelectAtTagActivity, List<FacebookPlace> paramList)
  {
    this.d = paramSelectAtTagActivity;
    this.b = paramList;
    this.f = ((LayoutInflater)this.d.getSystemService("layout_inflater"));
  }

  public Collection<FacebookPlace> a()
  {
    Preconditions.checkState(this.e);
    return this.c.values();
  }

  public void a(FacebookPlace paramFacebookPlace, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramFacebookPlace);
    Preconditions.checkState(this.e);
    boolean bool;
    if (paramBoolean)
      if (!this.c.containsKey(Long.valueOf(paramFacebookPlace.mPageId)))
      {
        bool = true;
        Preconditions.checkState(bool);
        this.c.put(Long.valueOf(paramFacebookPlace.mPageId), paramFacebookPlace);
      }
    while (true)
    {
      return;
      bool = false;
      break;
      Preconditions.checkState(this.c.containsKey(Long.valueOf(paramFacebookPlace.mPageId)));
      this.c.remove(Long.valueOf(paramFacebookPlace.mPageId));
    }
  }

  public void a(List<FacebookPlace> paramList)
  {
    Assert.a(this.e);
    this.b = paramList;
    notifyDataSetChanged();
  }

  public void a(boolean paramBoolean)
  {
    if (this.e != paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.e = paramBoolean;
      if (paramBoolean)
        this.c = new HashMap();
      notifyDataSetChanged();
      return;
    }
  }

  protected boolean a(ListView paramListView, int paramInt)
  {
    if (paramListView.getHeaderViewsCount() > paramInt);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean a(FacebookPlace paramFacebookPlace)
  {
    Preconditions.checkNotNull(paramFacebookPlace);
    Preconditions.checkState(this.e);
    return this.c.containsKey(Long.valueOf(paramFacebookPlace.mPageId));
  }

  protected int b(ListView paramListView, int paramInt)
  {
    boolean bool1 = true;
    int i = paramInt - paramListView.getHeaderViewsCount();
    boolean bool2;
    if (i >= 0)
    {
      bool2 = bool1;
      Assert.b("the list index should not include headers", bool2);
      if (i >= this.b.size())
        break label54;
    }
    while (true)
    {
      Assert.b("the places index should be within bounds", bool1);
      return i;
      bool2 = false;
      break;
      label54: bool1 = false;
    }
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
    return ((FacebookPlace)getItem(paramInt)).mPageId;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool1;
    SelectAtTagAdapter.PlaceViewHolder localPlaceViewHolder;
    label124: FacebookPlace localFacebookPlace;
    int i;
    if (paramInt <= this.b.size())
    {
      bool1 = true;
      Assert.b("index is a list index", bool1);
      if (paramView != null)
        break label277;
      paramView = this.f.inflate(2130903545, null);
      localPlaceViewHolder = new SelectAtTagAdapter.PlaceViewHolder(null);
      localPlaceViewHolder.a = ((CheckBox)paramView.findViewById(2131297821));
      localPlaceViewHolder.b = ((UrlImage)paramView.findViewById(2131297114));
      localPlaceViewHolder.c = ((TextView)paramView.findViewById(2131297116));
      localPlaceViewHolder.d = ((TextView)paramView.findViewById(2131297822));
      localPlaceViewHolder.e = ((ImageView)paramView.findViewById(2131297823));
      paramView.setTag(localPlaceViewHolder);
      localFacebookPlace = (FacebookPlace)getItem(paramInt);
      if (!this.e)
        break label314;
      boolean bool2 = this.c.containsKey(Long.valueOf(localFacebookPlace.mPageId));
      localPlaceViewHolder.b.setVisibility(4);
      if (localFacebookPlace.c() != null)
        break label296;
      if (!bool2)
        break label289;
      i = 0;
      label185: paramView.setBackgroundResource(i);
      localPlaceViewHolder.a.setChecked(bool2);
      localPlaceViewHolder.a.setVisibility(0);
      label210: localPlaceViewHolder.c.setText(localFacebookPlace.mName);
      if ((!StringUtils.c(localFacebookPlace.mDisplaySubtext)) || (localFacebookPlace.c() != null))
        break label408;
      localPlaceViewHolder.d.setVisibility(8);
      label252: if (localFacebookPlace.b() == null)
        break label470;
      localPlaceViewHolder.e.setVisibility(0);
    }
    while (true)
    {
      return paramView;
      bool1 = false;
      break;
      label277: localPlaceViewHolder = (SelectAtTagAdapter.PlaceViewHolder)paramView.getTag();
      break label124;
      label289: i = 2131165496;
      break label185;
      label296: paramView.setBackgroundResource(2131165496);
      localPlaceViewHolder.a.setVisibility(4);
      break label210;
      label314: paramView.setBackgroundResource(0);
      localPlaceViewHolder.a.setVisibility(4);
      localPlaceViewHolder.b.setVisibility(0);
      if (localFacebookPlace.mPicUrl == null)
      {
        Log.b(a, "null image URL for place " + localFacebookPlace.mPageId);
        localPlaceViewHolder.b.setImageParams((Uri)null);
        break label210;
      }
      localPlaceViewHolder.b.setImageParams(Uri.parse(localFacebookPlace.mPicUrl));
      break label210;
      label408: localPlaceViewHolder.d.setVisibility(0);
      if (localFacebookPlace.c() != null)
      {
        localPlaceViewHolder.d.setText(DefaultTimeFormatUtil.a(this.d, TimeFormatUtil.TimeFormatStyle.EVENTS_RELATIVE_STYLE, localFacebookPlace.c().d()));
        break label252;
      }
      localPlaceViewHolder.d.setText(localFacebookPlace.mDisplaySubtext);
      break label252;
      label470: localPlaceViewHolder.e.setVisibility(8);
    }
  }

  public boolean hasStableIds()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectAtTagAdapter
 * JD-Core Version:    0.6.0
 */