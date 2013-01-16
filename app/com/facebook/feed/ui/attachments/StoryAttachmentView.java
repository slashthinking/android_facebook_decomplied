package com.facebook.feed.ui.attachments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.listview.recycle.RecyclableView;

public abstract class StoryAttachmentView extends CustomLinearLayout
  implements RecyclableView
{
  public static final int a = StoryAttachmentView.StoryAttachmentViewType.values().length;
  protected static int b = -1;
  protected final Context c;
  protected NewsFeedAnalyticsEventBuilder d;
  private IFeedUnitRenderer e;
  private boolean f = false;

  public StoryAttachmentView(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryAttachmentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    FbInjector localFbInjector = getInjector();
    this.e = ((IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class));
    this.d = ((NewsFeedAnalyticsEventBuilder)localFbInjector.a(NewsFeedAnalyticsEventBuilder.class));
  }

  public void a(int paramInt)
  {
    if (b == -1)
      b = this.c.getResources().getDimensionPixelSize(2131230788);
    FeedUtils.a(this.c, getChildAt(0), paramInt, b);
  }

  protected void a(Intent paramIntent, HoneyClientEvent paramHoneyClientEvent)
  {
    this.e.a(getChildAt(0), paramIntent, paramHoneyClientEvent);
  }

  public abstract void a(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory);

  protected void a(String paramString, FeedStory paramFeedStory, HoneyClientEvent paramHoneyClientEvent)
  {
    this.e.a(getChildAt(0), paramString, paramHoneyClientEvent);
  }

  public void a(boolean paramBoolean)
  {
  }

  public boolean a()
  {
    return this.f;
  }

  public void b()
  {
  }

  protected void c()
  {
    getChildAt(0).setOnClickListener(null);
    getChildAt(0).setTag(null);
  }

  public int getRecyclableViewType()
  {
    return getViewType().ordinal();
  }

  public abstract StoryAttachmentView.StoryAttachmentViewType getViewType();

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setHasBeenAttached(true);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setHasBeenAttached(false);
  }

  public void setHasBeenAttached(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentView
 * JD-Core Version:    0.6.0
 */