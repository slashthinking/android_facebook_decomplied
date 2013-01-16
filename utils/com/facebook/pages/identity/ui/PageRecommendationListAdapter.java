package com.facebook.pages.identity.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.graphql.model.PageRecommendation;
import com.facebook.graphql.model.PageStarRatersEdge;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class PageRecommendationListAdapter extends BaseAdapter
{
  private final Context a;
  private final Resources b;
  private final PageRecommendationRowHeader c;
  private final PageRecommendationRowHeader d;
  private final PageRecommendationRowHeader e;
  private ImmutableList<PageRecommendation> f = ImmutableList.d();
  private ImmutableList<PageStarRatersEdge> g;
  private ImmutableList<PageRecommendation> h = ImmutableList.d();

  public PageRecommendationListAdapter(Context paramContext)
  {
    this.a = paramContext;
    this.b = this.a.getResources();
    this.c = new PageRecommendationRowHeader(this.a);
    this.c.setHeader(this.b.getString(2131361865));
    this.d = new PageRecommendationRowHeader(this.a);
    this.d.setHeader(this.b.getString(2131361867));
    this.e = new PageRecommendationRowHeader(this.a);
    this.e.setHeader(this.b.getString(2131361866));
    this.g = ImmutableList.d();
    this.f = ImmutableList.d();
    this.h = ImmutableList.d();
  }

  private int a(PageRecommendationListAdapter.RowType paramRowType)
  {
    int i = PageRecommendationListAdapter.1.a[paramRowType.ordinal()];
    int j = 0;
    switch (i)
    {
    default:
      throw new IllegalArgumentException("Unexpected RowType type: " + paramRowType);
    case 2:
      j = 1 + a(PageRecommendationListAdapter.RowType.FRIENDS_COMMENDATION_HEADING);
    case 1:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      return j;
      int m = this.f.size();
      j = 0;
      if (m > 0)
      {
        j = a(PageRecommendationListAdapter.RowType.FRIENDS_RECOMMENDATION) + this.f.size();
        continue;
        j = 1 + a(PageRecommendationListAdapter.RowType.FRIENDS_RATING_HEADING);
        continue;
        if (this.g.size() > 0)
        {
          j = a(PageRecommendationListAdapter.RowType.FRIENDS_RATING) + this.g.size();
        }
        else
        {
          int k = this.f.size();
          j = 0;
          if (k > 0)
          {
            j = a(PageRecommendationListAdapter.RowType.FRIENDS_RECOMMENDATION) + this.f.size();
            continue;
            j = 1 + a(PageRecommendationListAdapter.RowType.NONFRIENDS_COMMENDATION_HEADING);
          }
        }
      }
    }
  }

  private PageRecommendationListAdapter.RowType a(int paramInt)
  {
    PageRecommendationListAdapter.RowType localRowType;
    if (this.f.size() > 0)
      if (paramInt == a(PageRecommendationListAdapter.RowType.FRIENDS_COMMENDATION_HEADING))
        localRowType = PageRecommendationListAdapter.RowType.FRIENDS_COMMENDATION_HEADING;
    while (true)
    {
      return localRowType;
      if (paramInt < a(PageRecommendationListAdapter.RowType.FRIENDS_RECOMMENDATION) + this.f.size())
      {
        localRowType = PageRecommendationListAdapter.RowType.FRIENDS_RECOMMENDATION;
      }
      else if (this.g.size() > 0)
      {
        if (paramInt == a(PageRecommendationListAdapter.RowType.FRIENDS_RATING_HEADING))
          localRowType = PageRecommendationListAdapter.RowType.FRIENDS_RATING_HEADING;
        else if (paramInt < a(PageRecommendationListAdapter.RowType.FRIENDS_RATING) + this.g.size())
          localRowType = PageRecommendationListAdapter.RowType.FRIENDS_RATING;
      }
      else
      {
        if (this.h.size() <= 0)
          break;
        if (paramInt == a(PageRecommendationListAdapter.RowType.NONFRIENDS_COMMENDATION_HEADING))
        {
          localRowType = PageRecommendationListAdapter.RowType.NONFRIENDS_COMMENDATION_HEADING;
        }
        else
        {
          if (paramInt >= a(PageRecommendationListAdapter.RowType.NONFRIENDS_RECOMMENDATION) + this.h.size())
            break;
          localRowType = PageRecommendationListAdapter.RowType.NONFRIENDS_RECOMMENDATION;
        }
      }
    }
    throw new IllegalArgumentException("invalid position value " + paramInt + ", " + this.f.size() + ", " + this.h.size());
  }

  private PageRecommendationRowView a(View paramView)
  {
    if (paramView != null);
    for (PageRecommendationRowView localPageRecommendationRowView = (PageRecommendationRowView)paramView; ; localPageRecommendationRowView = new PageRecommendationRowView(this.a))
      return localPageRecommendationRowView;
  }

  public void a(List<PageStarRatersEdge> paramList)
  {
    Preconditions.checkNotNull(paramList);
    this.g = ImmutableList.a(paramList);
  }

  public void a(List<PageRecommendation> paramList, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramList);
    if (paramBoolean)
      this.f = ImmutableList.a(paramList);
    while (true)
    {
      notifyDataSetChanged();
      return;
      this.h = ImmutableList.a(paramList);
    }
  }

  public int getCount()
  {
    int i = this.f.size();
    int j = 0;
    if (i > 0)
      j = 0 + (1 + this.f.size());
    if (this.g.size() > 0)
      j += 1 + this.g.size();
    if (this.h.size() > 0)
      j += 1 + this.h.size();
    return j;
  }

  public Object getItem(int paramInt)
  {
    PageRecommendationListAdapter.RowType localRowType = a(paramInt);
    Object localObject;
    switch (PageRecommendationListAdapter.1.a[localRowType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("unknown row type " + localRowType + " at " + paramInt);
    case 1:
      localObject = this.b.getString(2131361865);
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      return localObject;
      localObject = this.f.get(paramInt - a(localRowType));
      continue;
      localObject = this.b.getString(2131361867);
      continue;
      localObject = this.g.get(paramInt - a(localRowType));
      continue;
      localObject = this.b.getString(2131361866);
      continue;
      localObject = this.h.get(paramInt - a(localRowType));
    }
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
    PageRecommendationListAdapter.RowType localRowType = a(paramInt);
    Object localObject;
    switch (PageRecommendationListAdapter.1.a[localRowType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("unknown row type " + localRowType + " at " + paramInt);
    case 1:
      localObject = this.c;
    case 3:
    case 5:
    case 2:
    case 4:
    case 6:
    }
    while (true)
    {
      return localObject;
      localObject = this.d;
      continue;
      localObject = this.e;
      continue;
      PageRecommendationRowView localPageRecommendationRowView3 = a(paramView);
      localPageRecommendationRowView3.a((PageRecommendation)getItem(paramInt));
      localObject = localPageRecommendationRowView3;
      continue;
      PageRecommendationRowView localPageRecommendationRowView2 = a(paramView);
      localPageRecommendationRowView2.a((PageStarRatersEdge)getItem(paramInt));
      localObject = localPageRecommendationRowView2;
      continue;
      PageRecommendationRowView localPageRecommendationRowView1 = a(paramView);
      localPageRecommendationRowView1.a((PageRecommendation)getItem(paramInt));
      localObject = localPageRecommendationRowView1;
    }
  }

  public int getViewTypeCount()
  {
    return PageRecommendationListAdapter.RowType.values().length;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageRecommendationListAdapter
 * JD-Core Version:    0.6.2
 */