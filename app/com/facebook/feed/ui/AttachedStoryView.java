package com.facebook.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedStory;
import com.facebook.widget.CustomViewGroup;

public class AttachedStoryView extends CustomViewGroup
  implements DepthAwareView
{
  protected final StoryContentView a;
  private final Context b;

  public AttachedStoryView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AttachedStoryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AttachedStoryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903143);
    this.a = ((StoryContentView)getView(2131296693));
    this.b = paramContext;
  }

  public void a(int paramInt)
  {
    int i = FeedUtils.a(this.b, paramInt);
    Resources localResources = this.b.getResources();
    int j = i - localResources.getDimensionPixelSize(2131230788);
    int k = localResources.getDimensionPixelSize(2131230789);
    Drawable localDrawable = getBackground();
    if (localDrawable != null)
      ((LayerDrawable)localDrawable).setLayerInset(0, j, k, j, k);
  }

  public void a(FeedStory paramFeedStory, FeedUnitViewStyle paramFeedUnitViewStyle)
  {
    int i = paramFeedStory.t();
    if (paramFeedStory.s() >= 2)
      setVisibility(8);
    while (true)
    {
      return;
      setVisibility(0);
      if (i > 0)
        a(i);
      this.a.a(paramFeedStory, paramFeedUnitViewStyle);
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      this.a.setBackgroundDrawable(getResources().getDrawable(2130838179));
    while (true)
    {
      return;
      this.a.setBackgroundDrawable(null);
    }
  }

  public Drawable getBackground()
  {
    Drawable localDrawable1 = this.a.getBackground();
    if (localDrawable1 != null);
    for (Drawable localDrawable2 = localDrawable1.mutate(); ; localDrawable2 = null)
      return localDrawable2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.AttachedStoryView
 * JD-Core Version:    0.6.0
 */