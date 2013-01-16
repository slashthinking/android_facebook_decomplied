package com.facebook.notifications.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.graphql.model.FeedStory;

public class NotificationStoryAdapter extends BaseAdapter
{
  FeedStory a;
  IFeedUnitRenderer b;

  public NotificationStoryAdapter(FeedStory paramFeedStory, IFeedUnitRenderer paramIFeedUnitRenderer)
  {
    this.a = paramFeedStory;
    this.b = paramIFeedUnitRenderer;
  }

  public int getCount()
  {
    return 1;
  }

  public Object getItem(int paramInt)
  {
    return this.a;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null);
    for (NotificationStoryView localNotificationStoryView = (NotificationStoryView)paramView; ; localNotificationStoryView = new NotificationStoryView(paramViewGroup.getContext()))
      return this.b.a(this.a, localNotificationStoryView, paramViewGroup, FeedUnitViewStyle.NEWSFEED_STORY, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.notifications.ui.NotificationStoryAdapter
 * JD-Core Version:    0.6.0
 */