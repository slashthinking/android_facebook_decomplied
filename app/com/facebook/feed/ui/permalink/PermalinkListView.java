package com.facebook.feed.ui.permalink;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.BetterListView;

public class PermalinkListView extends BetterListView
{
  private boolean a = false;
  private boolean b;
  private final FeedEventBus c;

  public PermalinkListView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PermalinkListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PermalinkListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = ((FeedEventBus)FbInjector.a(paramContext).a(FeedEventBus.class));
    setOnScrollListener(new PermalinkListView.1(this));
  }

  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt2 == paramInt3);
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean a(ListAdapter paramListAdapter)
  {
    int i;
    if (paramListAdapter == getAdapter())
      i = 1;
    while (true)
    {
      return i;
      if (((getAdapter() instanceof HeaderViewListAdapter)) && (((HeaderViewListAdapter)getAdapter()).getWrappedAdapter() == paramListAdapter))
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public void a()
  {
    this.a = true;
  }

  public void addFooterView(View paramView)
  {
    if (!this.b)
    {
      super.addFooterView(paramView);
      this.b = true;
    }
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (a(paramListAdapter));
    while (true)
    {
      return;
      super.setAdapter(paramListAdapter);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkListView
 * JD-Core Version:    0.6.0
 */