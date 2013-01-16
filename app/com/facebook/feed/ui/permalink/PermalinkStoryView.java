package com.facebook.feed.ui.permalink;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.ui.BindableFeedUnitView;
import com.facebook.feed.ui.StoryContentView;
import com.facebook.graphql.model.FeedStory;
import com.facebook.widget.CustomViewGroup;

public class PermalinkStoryView extends CustomViewGroup
  implements BindableFeedUnitView<FeedStory>
{
  private final StoryContentView a;
  private final View b;

  public PermalinkStoryView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PermalinkStoryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PermalinkStoryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903159);
    this.a = ((StoryContentView)getView(2131296693));
    this.b = getView(2131296734);
  }

  public void a()
  {
    this.a.a();
    this.a.b();
  }

  public void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean)
  {
    this.a.a(paramFeedStory, paramFeedUnitViewStyle, paramBoolean);
  }

  public void setHasContentBelowStory(boolean paramBoolean)
  {
    this.a.setPermalinkHasContentBelowStory(paramBoolean);
    View localView = this.b;
    if (paramBoolean);
    for (int i = 0; ; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkStoryView
 * JD-Core Version:    0.6.0
 */