package com.facebook.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.BetterListView;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;

public class NewsFeedListView extends BetterListView
{
  private static final int a = View.MeasureSpec.makeMeasureSpec(0, 0);
  private final FbErrorReporter b;
  private final PerformanceLogger c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private boolean i = true;
  private final int j;
  private VelocityTracker k;
  private NewsFeedListView.FeedChromeVisibility l = NewsFeedListView.FeedChromeVisibility.VISIBLE;
  private NewsFeedListView.ListScrollStateSnapshot m;
  private NewsFeedListView.ListScrollStateSnapshot n;
  private NewsFeedListView.ListScrollStateSnapshot o;
  private int p;
  private int q;
  private float r;
  private ObjectAnimator s;
  private ObjectAnimator t;
  private Handler u = new Handler();
  private Runnable v = new NewsFeedListView.1(this);
  private final AbsListView.OnScrollListener w = new NewsFeedListView.2(this);

  public NewsFeedListView(Context paramContext)
  {
    this(paramContext, null);
  }

  public NewsFeedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public NewsFeedListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = ((FbErrorReporter)FbInjector.a(paramContext).a(FbErrorReporter.class));
    this.c = ((PerformanceLogger)FbInjector.a(paramContext).a(PerformanceLogger.class));
    f();
    c();
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    int i1 = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.j = (int)Math.max(0.05D * localViewConfiguration.getScaledMaximumFlingVelocity(), i1);
    this.m = new NewsFeedListView.ListScrollStateSnapshot(this);
    this.n = new NewsFeedListView.ListScrollStateSnapshot(this);
  }

  private void a(View paramView1, View paramView2)
  {
    if (paramView2.getVisibility() == 0)
    {
      a(false, paramView2);
      this.s.a(new NewsFeedListView.4(this, paramView1));
    }
    while (true)
    {
      return;
      a(true, paramView1);
    }
  }

  private void a(View paramView, StringBuffer paramStringBuffer, int paramInt)
  {
    int i1 = 0;
    for (int i2 = 0; i2 < paramInt; i2++)
      paramStringBuffer.append(' ');
    paramStringBuffer.append(paramView.getClass().getName() + "\n");
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      while (i1 < localViewGroup.getChildCount())
      {
        a(localViewGroup.getChildAt(i1), paramStringBuffer, paramInt + 1);
        i1++;
      }
    }
  }

  private void a(boolean paramBoolean, View paramView)
  {
    if (paramView.getVisibility() == 0);
    for (boolean bool = true; paramBoolean == bool; bool = false)
      return;
    View localView1;
    label27: View localView2;
    label37: float f1;
    label48: int i1;
    label55: float f2;
    if (paramBoolean)
    {
      localView1 = paramView;
      if (!paramBoolean)
        break label186;
      localView2 = this.f;
      if (!paramBoolean)
        break label192;
      f1 = this.p;
      if (!paramBoolean)
        break label198;
      i1 = 0;
      if ((this.s != null) && (this.s.f()))
      {
        if (this.s.h() != paramView)
          break label207;
        f2 = ((Float)this.s.o()).floatValue();
      }
    }
    while (true)
    {
      this.s.d();
      f1 = f2;
      localView1.setVisibility(0);
      paramView.setVisibility(0);
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = i1;
      this.s = ObjectAnimator.a(paramView, "translationY", arrayOfFloat);
      this.s.a(new NewsFeedListView.5(this, localView2));
      this.s.c();
      break;
      localView1 = this.f;
      break label27;
      label186: localView2 = paramView;
      break label37;
      label192: f1 = 0.0F;
      break label48;
      label198: i1 = this.p;
      break label55;
      label207: f2 = f1;
    }
  }

  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      this.l = NewsFeedListView.FeedChromeVisibility.VISIBLE;
      paramInt1 = 0;
    }
    label134: 
    while (true)
    {
      if (this.q == paramInt1);
      while (true)
      {
        return;
        if (paramInt1 > this.p)
          break label134;
        this.l = NewsFeedListView.FeedChromeVisibility.HIDDEN;
        paramInt1 = this.p;
        break;
        this.q = paramInt1;
        if ((this.t != null) && (this.t.f()))
          this.t.d();
        View localView = this.d;
        float[] arrayOfFloat = new float[1];
        arrayOfFloat[0] = paramInt1;
        this.t = ObjectAnimator.a(localView, "translationY", arrayOfFloat);
        if (Build.VERSION.SDK_INT < 11)
          this.t.a(getChromeAnimationEndListener());
        this.t.d(paramInt2).c();
      }
    }
  }

  private void f()
  {
    if (Build.VERSION.SDK_INT < 14);
    while (true)
    {
      return;
      setOverScrollMode(2);
    }
  }

  private AnimatorListenerAdapter getChromeAnimationEndListener()
  {
    return new NewsFeedListView.3(this);
  }

  public void a()
  {
    this.o = new NewsFeedListView.ListScrollStateSnapshot(this);
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (this.o == null)
      return;
    int i1 = this.o.d();
    if (this.o.b() == 0)
      i1 -= paramInt2 + this.o.c();
    while (true)
    {
      View localView = getAdapter().getView(paramInt1, null, this);
      localView.measure(a, a);
      i1 += localView.getMeasuredHeight();
      if ((paramInt1 == 0) || (i1 > 0))
      {
        setSelectionFromTop(paramInt1 + this.o.b(), -i1);
        this.o = null;
        break;
      }
      paramInt1--;
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 0; ; i1 = this.p)
    {
      b(i1, 100);
      return;
    }
  }

  public void b()
  {
    if (getFirstVisiblePosition() > 10)
      setSelection(10);
    this.u.postDelayed(this.v, 0L);
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
      a(this.h, this.g);
    while (true)
    {
      return;
      a(false, this.h);
    }
  }

  public void c()
  {
    this.p = (-getResources().getDimensionPixelOffset(2131230811));
    if (this.l == NewsFeedListView.FeedChromeVisibility.HIDDEN)
      a(false);
  }

  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
      a(this.g, this.h);
    while (true)
    {
      return;
      a(false, this.g);
    }
  }

  public boolean d()
  {
    int i1;
    if (getChildCount() != 0)
    {
      int i2 = getFirstVisiblePosition();
      i1 = 0;
      if (i2 == 0)
      {
        int i3 = getChildAt(0).getTop();
        i1 = 0;
        if (i3 != 0);
      }
    }
    else
    {
      i1 = 1;
    }
    return i1;
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() == 0)
      this.m.a();
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    StringBuffer localStringBuffer;
    try
    {
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      return bool;
    }
    catch (StackOverflowError localStackOverflowError1)
    {
      localStringBuffer = new StringBuffer("Stack overflow while drawing:\n");
    }
    try
    {
      a(paramView, localStringBuffer, 0);
      this.b.a("NNFViewNesting", localStringBuffer.toString(), false);
      throw localStackOverflowError1;
    }
    catch (StackOverflowError localStackOverflowError2)
    {
      while (true)
        localStringBuffer.append("-- ERROR: Stack overflow while printing view tree\n");
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(this.w);
    this.k = VelocityTracker.obtain();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b(this.w);
    this.k.recycle();
    this.k = null;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.i) && (getChildCount() > 0))
    {
      this.i = false;
      this.c.b("FetchSuccessToFirstRender");
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.u.removeCallbacks(this.v);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      return bool;
      this.k.addMovement(paramMotionEvent);
      continue;
      this.k.computeCurrentVelocity(1000);
      this.r = this.k.getYVelocity();
    }
  }

  public void setupAnimationViews(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5)
  {
    this.d = paramView1;
    this.e = paramView2;
    this.f = paramView3;
    this.g = paramView4;
    this.h = paramView5;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedListView
 * JD-Core Version:    0.6.0
 */