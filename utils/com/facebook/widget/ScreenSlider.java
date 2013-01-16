package com.facebook.widget;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ui.touch.DragMotionDetector;
import com.facebook.orca.ui.touch.Draggable;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

public abstract class ScreenSlider
{
  private ScreenSlider.ScreenSliderOpenListener a = new ScreenSlider.1(this);
  private Draggable b = new ScreenSlider.2(this);
  private Draggable c = new ScreenSlider.3(this);
  private final ScreenSlider.OnConfigurationChangedListener d = new ScreenSlider.4(this);
  private final ScreenSlider.ScreenSliderConfig e;
  private ScreenSlider.ScreenSliderState f = ScreenSlider.ScreenSliderState.CLOSED;
  private Activity g;
  private AndroidThreadUtil h;
  private ViewGroup i;
  private View j;
  private View k;
  private View l;
  private float m = -1.0F;
  private DragMotionDetector n;
  private DragMotionDetector o;
  private ScreenSlider.ScreenSliderHost p;
  private int q = 0;
  private Animation r;
  private View s;
  private ScreenSlider.StateListener t;
  private Set<View> u = Sets.a();
  private Set<View> v = Sets.a();

  public ScreenSlider(int paramInt, float paramFloat1, float paramFloat2)
  {
    this(paramInt, paramFloat1, paramFloat2, 45.0F, 15.0F);
  }

  public ScreenSlider(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(new ScreenSlider.ScreenSliderConfig(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat3, paramFloat4));
  }

  public ScreenSlider(ScreenSlider.ScreenSliderConfig paramScreenSliderConfig)
  {
    this.e = paramScreenSliderConfig;
  }

  private void a(int paramInt)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(paramInt, paramInt, 0.0F, 0.0F);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(0L);
    a(localTranslateAnimation);
    this.q = paramInt;
  }

  private void a(int paramInt, Runnable paramRunnable)
  {
    d();
    a(ScreenSlider.ScreenSliderState.CLOSED, paramInt, new ScreenSlider.12(this, paramRunnable));
  }

  private void a(long paramLong)
  {
    t();
    b();
    a(ScreenSlider.ScreenSliderState.OPENED, paramLong, new ScreenSlider.8(this));
  }

  protected static void a(Activity paramActivity)
  {
    if (paramActivity == null);
    while (true)
    {
      return;
      InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if (localInputMethodManager != null)
        localInputMethodManager.hideSoftInputFromWindow(paramActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
  }

  private static void a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
      ((ViewGroup)paramView.getParent()).removeView(paramView);
  }

  private void a(Animation paramAnimation)
  {
    if (this.r != null)
      this.r.cancel();
    if (this.j != null)
      this.j.setVisibility(0);
    if (this.s != null)
    {
      this.s.bringToFront();
      this.s.requestFocus();
    }
    this.r = paramAnimation;
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      localView.bringToFront();
      localView.startAnimation(paramAnimation);
    }
  }

  private void a(ScreenSlider.ScreenSliderState paramScreenSliderState, long paramLong, Runnable paramRunnable)
  {
    int i1 = i();
    int i2 = this.q;
    if (paramScreenSliderState == ScreenSlider.ScreenSliderState.OPENED)
      if (this.e.a != 1);
    for (i1 = -i1; ; i1 = 0)
    {
      this.q = i1;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(i2, i1, 0.0F, 0.0F);
      localTranslateAnimation.setDuration(paramLong);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setAnimationListener(new ScreenSlider.9(this, paramScreenSliderState, paramRunnable));
      this.f = ScreenSlider.ScreenSliderState.ANIMATING;
      a(localTranslateAnimation);
      return;
    }
  }

  private void b(int paramInt)
  {
    int i1 = 5;
    if (this.k == null)
    {
      this.k = new View(this.g);
      this.s.setBackgroundDrawable(new ColorDrawable(0));
    }
    int i2;
    View localView1;
    if (this.k.getParent() == null)
    {
      ViewGroup localViewGroup = this.i;
      View localView2 = this.k;
      if (j())
      {
        i2 = i1;
        localViewGroup.addView(localView2, new FrameLayout.LayoutParams(paramInt, -1, i2));
      }
    }
    else if (this.k.getWidth() != paramInt)
    {
      localView1 = this.k;
      if (!j())
        break label170;
    }
    while (true)
    {
      localView1.setLayoutParams(new FrameLayout.LayoutParams(paramInt, -1, i1));
      this.k.requestLayout();
      this.k.setVisibility(0);
      this.k.bringToFront();
      this.k.setOnTouchListener(new ScreenSlider.11(this));
      return;
      i2 = 3;
      break;
      label170: i1 = 3;
    }
  }

  private void g()
  {
    int i1 = 3;
    int i2;
    if (this.j != null)
    {
      i2 = i();
      if (this.j.getParent() != null)
        break label74;
      this.j.setVisibility(4);
      localViewGroup = this.i;
      localView2 = this.j;
      if (!j())
        break label69;
      localViewGroup.addView(localView2, new FrameLayout.LayoutParams(i2, -1, i1));
    }
    label69: label74: 
    while (this.j.getWidth() == i2)
      while (true)
      {
        ViewGroup localViewGroup;
        View localView2;
        return;
        i1 = 5;
      }
    View localView1 = this.j;
    if (j());
    while (true)
    {
      localView1.setLayoutParams(new FrameLayout.LayoutParams(i2, -1, i1));
      this.j.requestLayout();
      break;
      i1 = 5;
    }
  }

  private void h()
  {
    int i1 = 0;
    int i2 = this.g.getTheme().obtainStyledAttributes(new int[] { 16842801 }).getColor(0, 17170447);
    if (i1 < this.i.getChildCount())
    {
      View localView = this.i.getChildAt(i1);
      if ((localView.getVisibility() != 0) || (localView == this.j) || (localView == this.s) || (localView == this.k));
      while (true)
      {
        i1++;
        break;
        if (!this.p.a(localView))
        {
          if (localView.getBackground() == null)
          {
            this.u.add(localView);
            localView.setBackgroundDrawable(new ColorDrawable(i2));
          }
          this.v.add(localView);
        }
      }
    }
  }

  private int i()
  {
    int i1 = this.g.getWindowManager().getDefaultDisplay().getWidth() - this.e.a(this.g);
    int i2;
    if (this.e.d > 0.0F)
    {
      i2 = this.e.b(this.g);
      if (i1 <= i2);
    }
    while (true)
    {
      return i2;
      i2 = i1;
    }
  }

  private void p()
  {
    if (this.s == null)
    {
      this.s = new View(this.g);
      this.s.setBackgroundDrawable(new ColorDrawable(0));
      this.s.setOnTouchListener(new ScreenSlider.10(this));
    }
    if (this.s.getParent() == null)
    {
      this.s.setVisibility(0);
      this.i.addView(this.s, new FrameLayout.LayoutParams(-1, -1));
    }
  }

  private void q()
  {
    if (this.g == null)
      throw new IllegalStateException("ScreenSlider not attached to an activity");
  }

  private void r()
  {
    a(this.s);
    if (this.j != null)
      this.j.bringToFront();
    b(this.g.getWindowManager().getDefaultDisplay().getWidth() - i());
  }

  private void s()
  {
    if (this.k != null)
    {
      a(this.k);
      this.k.setOnTouchListener(null);
    }
  }

  private void t()
  {
    ViewGroup localViewGroup;
    View localView;
    int i1;
    if (this.j == null)
    {
      this.j = f();
      if (this.j != null)
      {
        this.j.setVisibility(4);
        localViewGroup = this.i;
        localView = this.j;
        i1 = i();
        if (!j())
          break label72;
      }
    }
    label72: for (int i2 = 3; ; i2 = 5)
    {
      localViewGroup.addView(localView, new FrameLayout.LayoutParams(i1, -1, i2));
      return;
    }
  }

  public void a()
  {
    if (this.l != null)
      this.l.setOnTouchListener(null);
    this.p.b();
    this.p.c();
    this.g = null;
    this.p = null;
    this.i = null;
    this.j = null;
    this.r = null;
    this.l = null;
    this.k = null;
    this.m = -1.0F;
    if (this.t != null)
    {
      this.t.e();
      this.t = null;
    }
    this.n = null;
    this.o = null;
  }

  public void a(float paramFloat)
  {
    this.e.c = paramFloat;
  }

  public void a(float paramFloat, Runnable paramRunnable)
  {
    this.h.a();
    q();
    a(paramFloat);
    g();
    a(this.g);
    p();
    a(ScreenSlider.ScreenSliderState.OPENED, 140L, new ScreenSlider.5(this, paramRunnable));
  }

  public void a(Activity paramActivity, ScreenSlider.ScreenSliderHost paramScreenSliderHost)
  {
    Preconditions.checkNotNull(paramActivity);
    AndroidThreadUtil localAndroidThreadUtil = (AndroidThreadUtil)FbInjector.a(paramActivity).a(AndroidThreadUtil.class);
    localAndroidThreadUtil.a();
    this.g = paramActivity;
    this.p = paramScreenSliderHost;
    this.h = localAndroidThreadUtil;
    this.i = ((ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290));
    Draggable localDraggable1 = this.b;
    Integer[] arrayOfInteger1 = new Integer[1];
    arrayOfInteger1[0] = Integer.valueOf(this.e.a);
    this.n = new DragMotionDetector(localDraggable1, Lists.a(arrayOfInteger1), this.e.c(paramActivity), this.e.d(paramActivity));
    Draggable localDraggable2 = this.c;
    Integer[] arrayOfInteger2 = new Integer[1];
    arrayOfInteger2[0] = Integer.valueOf(this.e.b);
    this.o = new DragMotionDetector(localDraggable2, Lists.a(arrayOfInteger2), this.e.e(paramActivity), this.e.f(paramActivity));
    this.l = this.p.a();
    if (this.l != null)
      this.l.setOnTouchListener(new ScreenSlider.6(this));
    this.p.a(this.a);
    this.p.a(this.d);
    if (this.t != null)
      this.t.a(paramActivity);
    Looper.myQueue().addIdleHandler(new ScreenSlider.7(this));
  }

  protected void a(Configuration paramConfiguration)
  {
    if (k())
      a(0L);
  }

  protected void a(ScreenSlider.ScreenSliderState paramScreenSliderState)
  {
    if (this.f != paramScreenSliderState)
      this.f = paramScreenSliderState;
  }

  public void a(ScreenSlider.StateListener paramStateListener)
  {
    this.t = paramStateListener;
  }

  public void a(Runnable paramRunnable)
  {
    this.h.a();
    q();
    if (this.f == ScreenSlider.ScreenSliderState.CLOSED);
    while (true)
    {
      return;
      a(140, paramRunnable);
    }
  }

  protected void b()
  {
    g();
    a(this.g);
    p();
    h();
    if (this.t != null)
      this.t.a();
  }

  protected void c()
  {
    r();
    if (this.t != null)
      this.t.b();
  }

  protected void d()
  {
    a(this.g);
    p();
    if (this.t != null)
      this.t.d();
  }

  protected void e()
  {
    a(this.s);
    a(this.j);
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
      ((View)localIterator.next()).setBackgroundResource(0);
    this.u.clear();
    s();
    if (this.t != null)
      this.t.c();
  }

  protected abstract View f();

  public boolean j()
  {
    if (this.e.a == -1);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean k()
  {
    if (this.f == ScreenSlider.ScreenSliderState.OPENED);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean l()
  {
    if (this.f == ScreenSlider.ScreenSliderState.CLOSED);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void m()
  {
    this.h.a();
    q();
    if (this.f != ScreenSlider.ScreenSliderState.CLOSED);
    while (true)
    {
      return;
      a(140L);
    }
  }

  public void n()
  {
    a(null);
  }

  public void o()
  {
    this.h.a();
    q();
    if (this.f == ScreenSlider.ScreenSliderState.CLOSED);
    while (true)
    {
      return;
      d();
      a(0);
      a(ScreenSlider.ScreenSliderState.CLOSED);
      e();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ScreenSlider
 * JD-Core Version:    0.6.2
 */