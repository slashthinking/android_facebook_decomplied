package com.facebook.feed.flyout;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.feed.data.PagedCommentCollection;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedComment;

public class FeedFlyoutCommentsAdapter extends BaseAdapter
{
  private static final Object c = new Object();
  private static final Object d = new Object();
  private final PagedCommentCollection a;
  private final int b = FeedFlyoutCommentsAdapter.RowType.values().length;
  private boolean e = false;
  private final FeedFlyoutHeaderView f;
  private final FeedFlyoutCommentsAdapter.MoreCommentsView g;
  private final FeedEventBus h;
  private FeedFlyoutCommentsAdapter.FetchPreviousCommentsResultSubscriber i;
  private View.OnClickListener j;

  public FeedFlyoutCommentsAdapter(Context paramContext, FeedEventBus paramFeedEventBus, PagedCommentCollection paramPagedCommentCollection, FlyoutParams paramFlyoutParams)
  {
    this.a = paramPagedCommentCollection;
    this.f = new FeedFlyoutHeaderView(paramContext);
    this.f.a(paramFlyoutParams);
    this.g = new FeedFlyoutCommentsAdapter.MoreCommentsView(this, paramContext);
    this.h = paramFeedEventBus;
    this.i = new FeedFlyoutCommentsAdapter.FetchPreviousCommentsResultSubscriber(this, null);
    this.h.a(this.i);
    this.j = new FeedFlyoutCommentsAdapter.1(this);
    this.g.setOnClickListener(this.j);
  }

  private View a(View paramView, ViewGroup paramViewGroup, FeedComment paramFeedComment)
  {
    if (paramView != null);
    for (FeedFlyoutCommentView localFeedFlyoutCommentView = (FeedFlyoutCommentView)paramView; ; localFeedFlyoutCommentView = new FeedFlyoutCommentView(paramViewGroup.getContext()))
    {
      localFeedFlyoutCommentView.a(paramFeedComment);
      return localFeedFlyoutCommentView;
    }
  }

  private int b()
  {
    if (c());
    for (int k = 2; ; k = 1)
      return k;
  }

  private boolean c()
  {
    if ((!this.a.g()) && (this.a.e()));
    for (int k = 1; ; k = 0)
      return k;
  }

  public void a()
  {
    if (this.i != null)
    {
      this.h.b(this.i);
      this.i = null;
    }
  }

  public int getCount()
  {
    return this.a.a() + b();
  }

  public Object getItem(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
      localObject = c;
    while (true)
    {
      return localObject;
      if ((paramInt == 1) && (c()))
      {
        localObject = d;
        continue;
      }
      localObject = this.a.a(paramInt - b());
    }
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    int k;
    if (localObject == c)
      k = FeedFlyoutCommentsAdapter.RowType.HEADER.ordinal();
    while (true)
    {
      return k;
      if (localObject == d)
      {
        k = FeedFlyoutCommentsAdapter.RowType.LOADPREV.ordinal();
        continue;
      }
      k = FeedFlyoutCommentsAdapter.RowType.COMMENT.ordinal();
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = getItem(paramInt);
    Object localObject2;
    if (localObject1 == c)
      localObject2 = this.f;
    while (true)
    {
      return localObject2;
      if (localObject1 == d)
      {
        localObject2 = this.g;
        continue;
      }
      localObject2 = a(paramView, paramViewGroup, (FeedComment)localObject1);
    }
  }

  public int getViewTypeCount()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutCommentsAdapter
 * JD-Core Version:    0.6.0
 */