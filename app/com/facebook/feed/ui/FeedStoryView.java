package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.facebook.common.util.Log;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.graphql.model.FeedStory;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.listview.recycle.IViewAttachAware;

public class FeedStoryView extends CustomViewGroup
  implements BindableFeedUnitView<FeedStory>, IViewAttachAware
{
  private final StoryContentView a;
  private boolean b;
  private WindowManager c;
  private String d;
  private long e = -1L;
  private int f = -1;

  public FeedStoryView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public FeedStoryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FeedStoryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903177);
    this.a = ((StoryContentView)getView(2131296693));
    this.c = ((WindowManager)paramContext.getSystemService("window"));
    Log.e("FeedStoryView", "feed: created a new FeedStoryView");
  }

  public void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean)
  {
    int i = this.c.getDefaultDisplay().getRotation();
    if ((this.d != null) && (this.d.equals(paramFeedStory.cacheId)) && (this.e == paramFeedStory.getFetchTimeMs()) && (i == this.f));
    while (true)
    {
      return;
      this.d = paramFeedStory.cacheId;
      this.e = paramFeedStory.getFetchTimeMs();
      this.f = i;
      this.a.a(paramFeedStory, paramFeedUnitViewStyle, paramBoolean);
    }
  }

  public boolean a()
  {
    return this.b;
  }

  public void b()
  {
    this.a.a();
  }

  public void c()
  {
    this.a.b();
  }

  public void d()
  {
    this.a.c();
  }

  public View getDefaultMenuButton()
  {
    return this.a.getDefaultMenuButton();
  }

  public View getExplanationSectionMenuButton()
  {
    return this.a.getExplanationSectionMenuButton();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setHasBeenAttached(true);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setHasBeenAttached(false);
    this.a.destroyDrawingCache();
  }

  public void setHasBeenAttached(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.FeedStoryView
 * JD-Core Version:    0.6.0
 */