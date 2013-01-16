package com.facebook.nearby.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.facebook.common.util.HeightAnimation;
import com.facebook.widget.BetterListView;
import com.google.common.base.Preconditions;

public class SplitHideableListView extends BetterListView
{
  private final Runnable a = new SplitHideableListView.1(this);
  private HeightAnimation b;
  private HeightAnimation c;
  private HeightAnimation d;
  private View e;
  private float f;
  private SplitHideableListView.OnSplitHeightChangedListener g;
  private int h;
  private int i;

  public SplitHideableListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public SplitHideableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public SplitHideableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    Resources localResources = getResources();
    this.h = localResources.getDimensionPixelSize(2131230742);
    this.i = localResources.getDimensionPixelSize(2131230743);
    setOnScrollListener(new SplitHideableListView.2(this));
  }

  private void c()
  {
    this.e.clearAnimation();
    this.e.getLayoutParams().height = getHeight();
    this.e.requestLayout();
  }

  private void d()
  {
    this.b.reset();
    this.e.startAnimation(this.b);
  }

  private void f()
  {
    this.b = new HeightAnimation(this.e, this.h);
    this.b.setInterpolator(new DecelerateInterpolator());
    this.b.setDuration(250L);
    this.d = new HeightAnimation(this.e, this.h);
    this.d.setInterpolator(new DecelerateInterpolator());
    this.d.setDuration(200L);
    this.d.setAnimationListener(new SplitHideableListView.3(this));
    this.c = new HeightAnimation(this.e, getHeight());
    this.c.setInterpolator(new AccelerateInterpolator());
    this.c.setDuration(150L);
    this.c.setAnimationListener(new SplitHideableListView.4(this));
  }

  private void g()
  {
    if (this.g != null)
    {
      int j = getFirstVisiblePosition();
      int k = 0;
      if (j == 0)
        k = Math.max(0, this.e.getHeight() + this.e.getTop());
      this.g.a(k);
    }
  }

  public void a()
  {
    if (isEnabled())
    {
      this.e.clearAnimation();
      this.c.reset();
      this.e.startAnimation(this.c);
    }
  }

  public void b()
  {
    if (!isEnabled())
    {
      this.e.clearAnimation();
      this.d.reset();
      this.e.startAnimation(this.d);
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      f();
      if (!isEnabled())
        c();
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (!isEnabled())
    {
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      this.e.clearAnimation();
      this.f = -1.0F;
      continue;
      int n = this.e.getHeight();
      if (n >= this.i)
      {
        a();
        continue;
      }
      if (n <= this.h)
        continue;
      d();
      continue;
      if (this.e.getTop() != 0)
        continue;
      if (this.f < 0.0F)
        this.f = paramMotionEvent.getRawY();
      float f1 = paramMotionEvent.getRawY() - this.f;
      int j = getHeight();
      float f2 = (j - f1 / 2.0F) / j;
      float f3 = this.h + f1 * f2;
      int k = (int)Math.max(this.h, f3);
      int m = this.e.getHeight();
      this.e.getLayoutParams().height = k;
      this.e.requestLayout();
      post(this.a);
      if (k > this.h)
      {
        if (m == this.h)
        {
          MotionEvent localMotionEvent2 = MotionEvent.obtain(paramMotionEvent);
          localMotionEvent2.setAction(3);
          super.onTouchEvent(localMotionEvent2);
        }
        bool = true;
        break;
      }
      if ((k != this.h) || (k >= m))
        continue;
      MotionEvent localMotionEvent1 = MotionEvent.obtain(paramMotionEvent);
      localMotionEvent1.setAction(0);
      super.onTouchEvent(localMotionEvent1);
    }
  }

  public void setExpandableHeader(View paramView)
  {
    boolean bool;
    if ((this.e == null) || (paramView == null))
    {
      bool = true;
      Preconditions.checkState(bool);
      if (paramView != null)
        break label41;
      removeHeaderView(this.e);
    }
    while (true)
    {
      this.e = paramView;
      return;
      bool = false;
      break;
      label41: addHeaderView(paramView);
    }
  }

  public void setOnSplitHeightChangedListener(SplitHideableListView.OnSplitHeightChangedListener paramOnSplitHeightChangedListener)
  {
    this.g = paramOnSplitHeightChangedListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.ui.SplitHideableListView
 * JD-Core Version:    0.6.0
 */