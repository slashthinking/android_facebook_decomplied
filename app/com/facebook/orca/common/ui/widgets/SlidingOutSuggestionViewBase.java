package com.facebook.orca.common.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.facebook.R.styleable;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.animatablelistview.AnimatingItemInfo;
import com.facebook.widget.animatablelistview.AnimatingItemView;
import com.nineoldandroids.animation.ObjectAnimator;

public class SlidingOutSuggestionViewBase extends CustomFrameLayout
{
  private AnimatingItemView a;
  private boolean b;
  private int c;
  private SlidingOutSuggestionViewBase.DesiredVisibility d;

  public SlidingOutSuggestionViewBase(Context paramContext)
  {
    this(paramContext, null);
  }

  public SlidingOutSuggestionViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SlidingOutSuggestionViewBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SlidingOutSuggestionView);
    int i = localTypedArray.getIndexCount();
    int j = 0;
    if (j < i)
    {
      int k = localTypedArray.getIndex(j);
      switch (k)
      {
      default:
      case 1:
      }
      while (true)
      {
        j++;
        break;
        this.c = localTypedArray.getInteger(k, this.c);
      }
    }
    localTypedArray.recycle();
  }

  private void a()
  {
    if (this.b)
      return;
    int i;
    if (this.a.getVisibility() == 0)
    {
      i = 1;
      label20: switch (SlidingOutSuggestionViewBase.2.a[this.d.ordinal()])
      {
      case 3:
      default:
      case 1:
      case 2:
      case 4:
      }
    }
    while (true)
    {
      this.d = SlidingOutSuggestionViewBase.DesiredVisibility.WHATEVER;
      break;
      i = 0;
      break label20;
      this.a.setVisibility(0);
      continue;
      this.a.setVisibility(8);
      continue;
      if (i == 0)
        continue;
      b();
    }
  }

  private void b()
  {
    float f;
    if (this.c == 1)
      f = 1.0F;
    while (true)
    {
      AnimatingItemInfo localAnimatingItemInfo = new AnimatingItemInfo(null);
      this.a.setItemInfo(localAnimatingItemInfo);
      ObjectAnimator localObjectAnimator = ObjectAnimator.a(localAnimatingItemInfo, "animationOffset", new float[] { f, 0.0F });
      localObjectAnimator.d(300L);
      localObjectAnimator.a(new LinearInterpolator());
      localObjectAnimator.a(new SlidingOutSuggestionViewBase.1(this, localAnimatingItemInfo));
      localObjectAnimator.c();
      this.b = true;
      return;
      f = -1.0F;
    }
  }

  public void d()
  {
    this.d = SlidingOutSuggestionViewBase.DesiredVisibility.SHOW;
    a();
  }

  public void e()
  {
    this.d = SlidingOutSuggestionViewBase.DesiredVisibility.HIDE;
    a();
  }

  public void f()
  {
    this.d = SlidingOutSuggestionViewBase.DesiredVisibility.ANIMATE_OUT;
    a();
  }

  public int getAnimateOutDirection()
  {
    return this.c;
  }

  public void setAnimateOutDirection(int paramInt)
  {
    this.c = paramInt;
  }

  protected void setContainer(AnimatingItemView paramAnimatingItemView)
  {
    this.a = paramAnimatingItemView;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.SlidingOutSuggestionViewBase
 * JD-Core Version:    0.6.0
 */