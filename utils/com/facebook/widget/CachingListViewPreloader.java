package com.facebook.widget;

import android.view.View;
import com.facebook.orca.app.UserInteractionController;
import com.google.common.base.Preconditions;

public class CachingListViewPreloader extends ListViewPreloader
{
  public static int a = 10;
  private final BetterListView d;
  private final CachingListAdapter e;
  private final BetterListView.OnRemoveDetachedViewListener f;
  private boolean g = false;

  public CachingListViewPreloader(BetterListView paramBetterListView, CachingListAdapter paramCachingListAdapter, UserInteractionController paramUserInteractionController, boolean paramBoolean)
  {
    super(paramBetterListView, a, ListViewPreloader.PreloadDirection.CLOSEST_FIRST, ListViewPreloader.PreloadType.ALL_OFFSCREEN, paramUserInteractionController, paramBoolean);
    Preconditions.checkNotNull(paramBetterListView);
    Preconditions.checkNotNull(paramCachingListAdapter);
    this.d = paramBetterListView;
    this.e = paramCachingListAdapter;
    this.e.b(this.g);
    this.e.a(new CachingListViewPreloader.1(this));
    this.f = new CachingListViewPreloader.2(this);
    this.d.a(this.f);
  }

  public void a(int paramInt)
  {
    this.e.b(paramInt, this.d);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean != this.g)
    {
      this.g = paramBoolean;
      if (this.e != null)
      {
        this.e.b(this.g);
        this.d.setAdapter(this.e);
      }
    }
  }

  public boolean a(View paramView)
  {
    if (!this.e.a(paramView));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void b(int paramInt)
  {
    this.e.b(paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CachingListViewPreloader
 * JD-Core Version:    0.6.2
 */