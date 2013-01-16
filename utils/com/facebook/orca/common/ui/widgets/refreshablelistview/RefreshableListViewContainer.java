package com.facebook.orca.common.ui.widgets.refreshablelistview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.facebook.R.styleable;
import com.facebook.orca.common.util.ObjectPool;
import com.facebook.orca.common.util.ObjectPoolManager;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.ScrollableView;

public class RefreshableListViewContainer extends ViewGroup
{
  private static final Class<?> a = RefreshableListViewContainer.class;
  private Scroller b;
  private RefreshableListViewState c = RefreshableListViewState.NORMAL;
  private int d = 0;
  private int e;
  private RefreshableListViewContainer.OnRefreshListener f;
  private int g;
  private int h;
  private int i;
  private int j = 0;
  private int k;
  private float l = 0.0F;
  private float m = 0.0F;
  private float n = 0.0F;
  private float o;
  private float p = -1.0F;
  private float q = -1.0F;
  private float r = -1.0F;
  private boolean s;
  private boolean t = true;
  private boolean u = false;
  private ObjectPool<Rect> v;

  public RefreshableListViewContainer(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public RefreshableListViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public RefreshableListViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private RefreshableListViewState a(int paramInt)
  {
    if (paramInt == 0);
    for (RefreshableListViewState localRefreshableListViewState = RefreshableListViewState.PULL_TO_REFRESH; ; localRefreshableListViewState = RefreshableListViewState.PUSH_TO_REFRESH)
    {
      return localRefreshableListViewState;
      if (paramInt != 1)
        break;
    }
    throw new IllegalArgumentException("Unknown direction: " + paramInt);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.b = new Scroller(paramContext);
    this.d = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PullToRefreshListView).getInt(0, 0);
    this.e = ((int)(5.0F * paramContext.getResources().getDisplayMetrics().density));
    this.v = ((ObjectPoolManager)FbInjector.a(paramContext).a(ObjectPoolManager.class)).b(Rect.class);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RefreshableListViewContainer);
    this.j = ((int)localTypedArray.getDimension(0, 0.0F));
    localTypedArray.recycle();
    this.k = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }

  private void a(RefreshableListViewState paramRefreshableListViewState)
  {
    a(paramRefreshableListViewState, false);
  }

  private void a(RefreshableListViewState paramRefreshableListViewState, boolean paramBoolean)
  {
    RefreshableListViewItem localRefreshableListViewItem;
    if (paramRefreshableListViewState != this.c)
    {
      this.c = paramRefreshableListViewState;
      localRefreshableListViewItem = getHeaderView();
      localRefreshableListViewItem.setDirection(this.d);
      if (paramRefreshableListViewState != RefreshableListViewState.NORMAL)
        break label76;
      localRefreshableListViewItem.setState(a(this.d));
    }
    while (true)
    {
      if ((paramRefreshableListViewState == RefreshableListViewState.LOADING) && (this.f != null))
        this.f.a(paramBoolean);
      return;
      label76: localRefreshableListViewItem.setState(paramRefreshableListViewState);
    }
  }

  private void a(boolean paramBoolean)
  {
    if (this.c == RefreshableListViewState.NORMAL)
    {
      float f1 = this.h + this.i;
      int i3 = Math.max((int)(1200.0F * (this.m / f1)), 300);
      int i4 = (int)this.m;
      int i5 = (int)(f1 * 0.05F);
      if (i4 < i5)
        i3 = i3 * i4 / i5;
      this.b.startScroll(0, i4, 0, -i4, i3);
      invalidate();
      return;
    }
    int i1;
    if (this.c == RefreshableListViewState.LOADING)
      if (!paramBoolean)
      {
        i1 = (int)this.m;
        if (this.d != 0)
          break label149;
      }
    label149: for (int i2 = this.h - i1; ; i2 = -this.h - i1)
    {
      this.b.startScroll(0, i1, 0, i2, 500);
      invalidate();
      break;
      break;
    }
  }

  private boolean a(float paramFloat)
  {
    int i1 = 1;
    if (this.m != 0.0F);
    while (true)
    {
      return i1;
      if (this.d == 0)
      {
        if (f())
        {
          if (paramFloat <= 0.0F)
            i1 = 0;
        }
        else
          i1 = 0;
      }
      else
      {
        if (this.d != i1)
          break;
        int i2;
        if (g())
        {
          if (paramFloat >= 0.0F)
            i2 = 0;
        }
        else
          i2 = 0;
      }
    }
    throw new IllegalStateException("Unknown direction: " + this.d);
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    AbsListView localAbsListView = getListView();
    if ((localAbsListView.getVisibility() == 0) && (localAbsListView.getAnimation() == null))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = f1 + getScrollX();
      float f4 = f2 + getScrollY();
      int i1 = (int)f3;
      int i2 = (int)f4;
      if (paramMotionEvent.getActionMasked() == 0)
      {
        Rect localRect = (Rect)this.v.a();
        localAbsListView.getHitRect(localRect);
        this.u = localRect.contains(i1, i2);
        this.v.a(localRect);
      }
      if (this.u)
      {
        float f5 = f3 - localAbsListView.getLeft();
        float f6 = f4 - localAbsListView.getTop();
        this.q = f5;
        this.r = f6;
        paramMotionEvent.setLocation(f5, f6);
      }
    }
    for (boolean bool = a(localAbsListView, paramMotionEvent); ; bool = true)
      return bool;
  }

  private boolean a(AbsListView paramAbsListView, MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool2 = paramAbsListView.dispatchTouchEvent(paramMotionEvent);
      bool1 = bool2;
      return bool1;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      while (true)
      {
        BLog.d(a, "Caught and ignoring ArrayIndexOutOfBoundsException", localArrayIndexOutOfBoundsException);
        boolean bool1 = true;
      }
    }
  }

  private float b(float paramFloat)
  {
    if (this.d == 0)
      if (paramFloat > 0.0F)
      {
        this.l = (paramFloat + this.l);
        if (this.l > this.e)
        {
          paramFloat = this.l - this.e;
          this.l = this.e;
        }
      }
    while (true)
    {
      return paramFloat;
      paramFloat = 0.0F;
      continue;
      this.l = 0.0F;
      continue;
      if (paramFloat < 0.0F)
      {
        this.l -= paramFloat;
        if (this.l > this.e)
        {
          paramFloat = -(this.l - this.e);
          this.l = this.e;
        }
        else
        {
          paramFloat = 0.0F;
        }
      }
      else
      {
        this.l = 0.0F;
      }
    }
  }

  private void b(MotionEvent paramMotionEvent)
  {
    if (this.s);
    while (true)
    {
      return;
      if (Math.abs(paramMotionEvent.getY() - this.p) >= this.k)
      {
        AbsListView localAbsListView = getListView();
        if ((localAbsListView.getVisibility() == 0) && (localAbsListView.getAnimation() == null))
        {
          int i1 = 1 + this.k;
          if (this.d == 1)
            i1 = -i1;
          MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
          localMotionEvent.setLocation(this.q, this.r - i1);
          a(localAbsListView, localMotionEvent);
          localMotionEvent.setLocation(this.q, this.r);
          a(localAbsListView, localMotionEvent);
          this.s = true;
        }
      }
    }
  }

  private void c(float paramFloat)
  {
    this.m = (0.8F * paramFloat + this.m);
    if (this.d == 0)
    {
      this.m = Math.max(0.0F, this.m);
      if (this.c == RefreshableListViewState.LOADING)
        if (this.d != 0)
          break label82;
    }
    label82: for (this.m = Math.min(this.m, this.h); ; this.m = Math.max(this.m, -this.h))
    {
      return;
      this.m = Math.min(0.0F, this.m);
      break;
    }
  }

  private void e()
  {
    if (this.b.computeScrollOffset())
    {
      this.m = this.b.getCurrY();
      if (!this.b.isFinished())
        invalidate();
    }
    if (this.n == this.m);
    while (true)
    {
      return;
      int i1 = (int)(this.m - this.n);
      if (i1 != 0)
      {
        this.n += i1;
        getListView().offsetTopAndBottom(i1);
        getHeaderView().offsetTopAndBottom(i1);
        getOverScrollHeaderView().offsetTopAndBottom(i1);
        invalidate();
      }
    }
  }

  private boolean f()
  {
    boolean bool = true;
    AbsListView localAbsListView = getListView();
    if (this.m > 0.0F);
    while (true)
    {
      return bool;
      if (localAbsListView.getFirstVisiblePosition() > 0)
      {
        bool = false;
      }
      else
      {
        View localView = localAbsListView.getChildAt(0);
        if ((localView != null) && (localView.getTop() < 0))
          bool = false;
      }
    }
  }

  private boolean g()
  {
    boolean bool = true;
    AbsListView localAbsListView = getListView();
    if (this.m < 0.0F);
    View localView;
    while (true)
    {
      return bool;
      if (localAbsListView.getLastVisiblePosition() != -1 + localAbsListView.getCount())
      {
        bool = false;
      }
      else
      {
        localView = localAbsListView.getChildAt(-1 + localAbsListView.getChildCount());
        if (localView != null)
          break;
        bool = false;
      }
    }
    Rect localRect1 = (Rect)this.v.a();
    Rect localRect2 = (Rect)this.v.a();
    localAbsListView.getDrawingRect(localRect2);
    localView.getHitRect(localRect1);
    if (localRect1.bottom <= localRect2.bottom);
    while (true)
    {
      this.v.a(localRect2);
      this.v.a(localRect1);
      break;
      bool = false;
    }
  }

  private RefreshableListViewItem getHeaderView()
  {
    return (RefreshableListViewItem)getChildAt(1);
  }

  private AbsListView getListView()
  {
    return (AbsListView)getChildAt(2);
  }

  private View getOverScrollHeaderView()
  {
    return getChildAt(0);
  }

  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.g = paramInt;
  }

  public boolean a()
  {
    if (this.m >= this.h);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void b()
  {
    if (this.c != RefreshableListViewState.LOADING)
    {
      a(RefreshableListViewState.LOADING);
      a(true);
    }
  }

  public void c()
  {
    if (this.c != RefreshableListViewState.LOADING)
    {
      a(RefreshableListViewState.LOADING);
      a(false);
    }
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return true;
  }

  public void d()
  {
    if (this.c == RefreshableListViewState.LOADING)
    {
      a(RefreshableListViewState.NORMAL);
      a(true);
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    e();
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -1);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.LayoutParams(paramLayoutParams);
  }

  public int getDirection()
  {
    return this.d;
  }

  public float getHeaderHeightExposed()
  {
    return this.m;
  }

  public RefreshableListViewContainer.OnRefreshListener getOnRefreshListener()
  {
    return this.f;
  }

  public RefreshableListViewState getState()
  {
    return this.c;
  }

  protected void onFinishInflate()
  {
    ((ScrollableView)getListView()).a(new RefreshableListViewContainer.1(this));
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() != 3)
      return;
    Tracer localTracer = Tracer.a("RefreshableListViewContainer.onLayout");
    if (this.d == 0)
    {
      int i4 = paramInt4 - paramInt2;
      getListView().layout(0, 0, paramInt3 - paramInt1, i4);
      int i5 = 0 + this.j;
      int i6 = i5 - this.h;
      getHeaderView().layout(0, i6, paramInt3 - paramInt1, i5);
      int i7 = i6 - this.i;
      getOverScrollHeaderView().layout(0, i7, paramInt3 - paramInt1, i6);
    }
    while (true)
    {
      this.n = 0.0F;
      e();
      localTracer.a();
      break;
      if (this.d != 1)
        break label203;
      int i1 = paramInt4 - paramInt2;
      getListView().layout(0, 0, paramInt3 - paramInt1, i1);
      int i2 = i1 + this.h;
      getHeaderView().layout(0, i1, paramInt3 - paramInt1, i2);
      int i3 = i2 + this.i;
      getOverScrollHeaderView().layout(0, i2, paramInt3 - paramInt1, i3);
    }
    label203: throw new IllegalStateException("Unknown direction: " + this.d);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    Tracer localTracer = Tracer.a("RefreshableListViewContainer.onMeasure");
    int i2 = getChildCount();
    int i3 = 0;
    int i4 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      measureChild(localView, paramInt1, paramInt2);
      i3 = Math.max(i3, localView.getMeasuredWidth());
      i4 = Math.max(i4, localView.getMeasuredHeight());
      i1++;
    }
    int i5 = Math.max(i4, getSuggestedMinimumHeight());
    setMeasuredDimension(resolveSize(Math.max(i3, getSuggestedMinimumWidth()), paramInt1), resolveSize(i5, paramInt2));
    this.h = getHeaderView().getMeasuredHeight();
    this.i = getOverScrollHeaderView().getMeasuredHeight();
    localTracer.a();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    boolean bool;
    switch (i1)
    {
    default:
    case 0:
      for (bool = a(paramMotionEvent); ; bool = a(paramMotionEvent))
      {
        this.o = f1;
        e();
        return bool;
        this.p = f1;
        this.s = false;
        if (!this.b.isFinished())
          this.b.abortAnimation();
      }
    case 1:
      if ((this.c == RefreshableListViewState.PULL_TO_REFRESH) || (this.c == RefreshableListViewState.PUSH_TO_REFRESH) || (this.c == RefreshableListViewState.BUFFERING))
      {
        a(RefreshableListViewState.NORMAL);
        a(false);
      }
      while (true)
      {
        this.l = 0.0F;
        bool = a(paramMotionEvent);
        break;
        if (this.c == RefreshableListViewState.RELEASE_TO_REFRESH)
        {
          a(RefreshableListViewState.LOADING, true);
          a(false);
        }
        else if (this.c == RefreshableListViewState.NORMAL)
        {
          this.m = 0.0F;
        }
      }
    case 2:
    }
    float f2 = f1 - this.o;
    int i2;
    if (this.c == RefreshableListViewState.NORMAL)
      if (this.g == 0)
      {
        bool = a(paramMotionEvent);
        i2 = 0;
        label228: if ((this.g == 1) && (a(f2)))
          a(RefreshableListViewState.BUFFERING);
      }
    while (true)
    {
      float f3;
      label295: int i3;
      if (this.c == RefreshableListViewState.BUFFERING)
      {
        f3 = b(f2);
        if (this.l >= this.e)
        {
          a(a(this.d));
          i3 = 0;
        }
      }
      while (true)
      {
        if ((this.c == RefreshableListViewState.PULL_TO_REFRESH) || (this.c == RefreshableListViewState.RELEASE_TO_REFRESH) || (this.c == RefreshableListViewState.PUSH_TO_REFRESH))
        {
          c(f3);
          if (this.m == 0.0F)
            a(RefreshableListViewState.NORMAL);
        }
        while (true)
        {
          if (i3 == 0)
            break label475;
          bool = a(paramMotionEvent);
          break;
          if (this.l != 0.0F)
            break label295;
          a(RefreshableListViewState.NORMAL);
          break label295;
          if (Math.abs(this.m) >= this.h)
            a(RefreshableListViewState.RELEASE_TO_REFRESH);
          while (true)
          {
            i3 = 0;
            break;
            if (Math.abs(this.m) < this.h)
              a(a(this.d));
          }
          if ((this.c == RefreshableListViewState.LOADING) && (a(f3)))
          {
            c(f3);
            i3 = 0;
          }
        }
        label475: if (this.c != RefreshableListViewState.LOADING)
          break;
        b(paramMotionEvent);
        break;
        i3 = i2;
        f3 = f2;
      }
      i2 = 1;
      bool = true;
      break label228;
      i2 = 1;
      bool = true;
    }
  }

  public void setDirection(int paramInt)
  {
    this.d = paramInt;
  }

  public void setLastLoadedTime(long paramLong)
  {
    getHeaderView().setLastLoadedTime(paramLong);
  }

  public void setOnRefreshListener(RefreshableListViewContainer.OnRefreshListener paramOnRefreshListener)
  {
    this.f = paramOnRefreshListener;
  }

  public void setOverflowListOverlap(int paramInt)
  {
    this.j = getContext().getResources().getDimensionPixelSize(paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer
 * JD-Core Version:    0.6.2
 */