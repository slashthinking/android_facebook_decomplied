package com.facebook.feed.ui;

import android.widget.BaseAdapter;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.widget.BetterListView;
import com.facebook.widget.ListViewPreloader;
import com.facebook.widget.ListViewPreloader.PreloadDirection;
import com.facebook.widget.ListViewPreloader.PreloadType;

public class FeedImagePrefetchViewPreloader extends ListViewPreloader
{
  private final FeedImageLoader a;
  private final BaseAdapter d;

  public FeedImagePrefetchViewPreloader(BetterListView paramBetterListView, BaseAdapter paramBaseAdapter, FeedImageLoader paramFeedImageLoader, int paramInt, UserInteractionController paramUserInteractionController, boolean paramBoolean)
  {
    super(paramBetterListView, paramInt, ListViewPreloader.PreloadDirection.CLOSEST_FIRST, ListViewPreloader.PreloadType.ALL_OFFSCREEN, paramUserInteractionController, paramBoolean);
    this.a = paramFeedImageLoader;
    this.d = paramBaseAdapter;
  }

  public FeedImagePrefetchViewPreloader(BetterListView paramBetterListView, BaseAdapter paramBaseAdapter, FeedImageLoader paramFeedImageLoader, UserInteractionController paramUserInteractionController, boolean paramBoolean)
  {
    this(paramBetterListView, paramBaseAdapter, paramFeedImageLoader, 3, paramUserInteractionController, paramBoolean);
  }

  public void a(int paramInt)
  {
    Object localObject = this.d.getItem(paramInt);
    if ((localObject instanceof FeedEdge))
      this.a.a(((FeedEdge)localObject).b());
    while (true)
    {
      return;
      if ((localObject instanceof FeedUnit))
      {
        this.a.a((FeedUnit)localObject);
        continue;
      }
    }
  }

  public void b(int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.FeedImagePrefetchViewPreloader
 * JD-Core Version:    0.6.0
 */