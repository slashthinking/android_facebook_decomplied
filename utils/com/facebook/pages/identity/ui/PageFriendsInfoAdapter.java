package com.facebook.pages.identity.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.graphql.model.GraphQLProfile;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PageFriendsInfoAdapter extends BaseAdapter
{
  private final Context a;
  private final Resources b;
  private final Map<String, ImmutableList<GraphQLProfile>> c = new LinkedHashMap();
  private final Map<String, PageFriendsInfoRowHeader> d = new LinkedHashMap();

  public PageFriendsInfoAdapter(Context paramContext)
  {
    this.a = paramContext;
    this.b = this.a.getResources();
  }

  private View a(int paramInt, String paramString, View paramView)
  {
    if (paramInt == 0);
    PageFriendsInfoRowView localPageFriendsInfoRowView;
    for (Object localObject = (View)this.d.get(paramString); ; localObject = localPageFriendsInfoRowView)
    {
      return localObject;
      localPageFriendsInfoRowView = a(paramView);
      localPageFriendsInfoRowView.a((GraphQLProfile)((ImmutableList)this.c.get(paramString)).get(paramInt - 1));
    }
  }

  private PageFriendsInfoRowView a(View paramView)
  {
    if (paramView != null);
    for (PageFriendsInfoRowView localPageFriendsInfoRowView = (PageFriendsInfoRowView)paramView; ; localPageFriendsInfoRowView = new PageFriendsInfoRowView(this.a))
      return localPageFriendsInfoRowView;
  }

  private Object a(int paramInt, String paramString)
  {
    if (paramInt == 0);
    while (true)
    {
      return paramString;
      paramString = ((ImmutableList)this.c.get(paramString)).get(paramInt - 1);
    }
  }

  public void a(String paramString, List<GraphQLProfile> paramList)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramList);
    ImmutableList localImmutableList = ImmutableList.a(paramList);
    this.c.put(paramString, localImmutableList);
    PageFriendsInfoRowHeader localPageFriendsInfoRowHeader = new PageFriendsInfoRowHeader(this.a);
    localPageFriendsInfoRowHeader.setHeader(paramString);
    this.d.put(paramString, localPageFriendsInfoRowHeader);
    notifyDataSetChanged();
  }

  public int getCount()
  {
    Iterator localIterator = this.c.values().iterator();
    int i = 0;
    while (localIterator.hasNext())
      i += ((ImmutableList)localIterator.next()).size();
    return i + this.c.values().size();
  }

  public Object getItem(int paramInt)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = 1 + ((ImmutableList)this.c.get(str)).size();
      if (paramInt <= i)
        return a(paramInt, str);
      paramInt -= i;
    }
    throw new IllegalArgumentException("Invalid Position");
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    Iterator localIterator = this.c.keySet().iterator();
    ImmutableList localImmutableList;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localImmutableList = (ImmutableList)this.c.get(str);
      if (paramInt != 0);
    }
    for (int i = PageFriendsInfoAdapter.RowType.SECTION_HEADING.ordinal(); ; i = PageFriendsInfoAdapter.RowType.FRIEND_VIEW.ordinal())
    {
      return i;
      paramInt -= 1 + localImmutableList.size();
      break;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = 1 + ((ImmutableList)this.c.get(str)).size();
      if (paramInt < i)
        return a(paramInt, str, paramView);
      paramInt -= i;
    }
    throw new IllegalArgumentException("Invalid Position");
  }

  public int getViewTypeCount()
  {
    return PageFriendsInfoAdapter.RowType.values().length;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageFriendsInfoAdapter
 * JD-Core Version:    0.6.2
 */