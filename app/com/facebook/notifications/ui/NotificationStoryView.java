package com.facebook.notifications.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.ui.BindableFeedUnitView;
import com.facebook.feed.ui.StoryContentView;
import com.facebook.graphql.model.FeedStory;
import com.facebook.widget.CustomViewGroup;

public class NotificationStoryView extends CustomViewGroup
  implements BindableFeedUnitView<FeedStory>
{
  private final StoryContentView a;

  public NotificationStoryView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public NotificationStoryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public NotificationStoryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903304);
    this.a = ((StoryContentView)getView(2131296693));
  }

  public void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean)
  {
    this.a.a(paramFeedStory, paramFeedUnitViewStyle, paramBoolean);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.notifications.ui.NotificationStoryView
 * JD-Core Version:    0.6.0
 */