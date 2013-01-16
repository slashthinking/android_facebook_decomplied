package com.facebook.feed.ui.location;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.listview.recycle.RecyclableView;

public abstract class StoryLocationView extends CustomLinearLayout
  implements RecyclableView
{
  public static int a = StoryLocationView.StoryLocationViewType.values().length;
  private boolean b = false;

  public StoryLocationView(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryLocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a(boolean paramBoolean)
  {
  }

  public boolean a()
  {
    return this.b;
  }

  public void b()
  {
  }

  public int getRecyclableViewType()
  {
    return getViewType().ordinal();
  }

  public abstract StoryLocationView.StoryLocationViewType getViewType();

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
    this.b = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.location.StoryLocationView
 * JD-Core Version:    0.6.0
 */