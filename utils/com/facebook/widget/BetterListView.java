package com.facebook.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.ui.util.MultitouchResampler;
import com.facebook.orca.common.util.ArraySet;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.listeners.BetterViewOnScrollListener;
import com.facebook.widget.listview.recycle.ManagedRecycleViewAdapter;

public class BetterListView extends ListView
  implements ScrollableView
{
  private static final boolean k;
  private BetterViewOnScrollListener a;
  private MultitouchResampler b;
  private MotionEvent c;
  private boolean d;
  private UserInteractionController e;
  private AbsListView.OnScrollListener f;
  private ViewTreeObserver.OnPreDrawListener g;
  private ArraySet<BetterListView.OnRemoveDetachedViewListener> h;
  private int i = 0;
  private int j = 0;

  static
  {
    if (Build.VERSION.SDK_INT <= 10);
    for (boolean bool = true; ; bool = false)
    {
      k = bool;
      return;
    }
  }

  public BetterListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public BetterListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public BetterListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.a = new BetterViewOnScrollListener();
    super.setOnScrollListener(this.a.a());
    this.c = null;
    this.b = null;
    this.d = false;
    this.e = null;
    this.f = new BetterListView.1(this);
    this.e = ((UserInteractionController)FbInjector.a(getContext()).a(UserInteractionController.class));
    this.h = new ArraySet();
    this.g = new BetterListView.2(this);
  }

  private boolean a()
  {
    int m = getChildCount();
    boolean bool = false;
    if (m > 0)
    {
      int n = getFirstVisiblePosition();
      if ((n + m != getCount()) || (getChildAt(m - 1).getBottom() > getHeight()))
      {
        bool = false;
        if (n == 0)
        {
          int i1 = getChildAt(0).getTop();
          bool = false;
          if (i1 < 0);
        }
      }
      else
      {
        bool = true;
      }
    }
    return bool;
  }

  protected void a(int paramInt)
  {
    if ((k) && (a()))
      paramInt = 0;
    if (paramInt != this.j)
    {
      this.j = paramInt;
      if (paramInt != 0)
        break label41;
      this.e.b(this);
    }
    while (true)
    {
      return;
      label41: this.e.a(this);
    }
  }

  public void a(View paramView, int paramInt)
  {
    AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new AbsListView.LayoutParams(-1, -2, 0);
      paramView.setLayoutParams(localLayoutParams);
    }
    int m = ViewGroup.getChildMeasureSpec(this.i, getListPaddingLeft() + getListPaddingRight(), localLayoutParams.width);
    int n = localLayoutParams.height;
    if (n > 0);
    for (int i1 = View.MeasureSpec.makeMeasureSpec(n, 1073741824); ; i1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(m, i1);
      return;
    }
  }

  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.b(paramOnScrollListener);
  }

  public void a(BetterListView.OnRemoveDetachedViewListener paramOnRemoveDetachedViewListener)
  {
    this.h.add(paramOnRemoveDetachedViewListener);
  }

  public void b(View paramView, int paramInt)
  {
    int m = paramView.getMeasuredWidth();
    int n = paramView.getMeasuredHeight();
    paramView.layout(getListPaddingLeft(), 0, m + getListPaddingLeft(), n + 0);
  }

  public void b(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.c(paramOnScrollListener);
  }

  public void c(View paramView, int paramInt)
  {
    int m = getFirstVisiblePosition();
    int n = getLastVisiblePosition();
    int i2;
    if ((paramInt - 1 >= m) && (paramInt - 1 <= n))
      i2 = getChildAt(paramInt - 1 - m).getBottom() + getDividerHeight();
    while (true)
    {
      paramView.offsetTopAndBottom(i2 - paramView.getTop());
      return;
      int i1 = paramInt + 1;
      i2 = 0;
      if (i1 >= m)
      {
        int i3 = paramInt + 1;
        i2 = 0;
        if (i3 <= n)
          i2 = getChildAt(paramInt + 1 - m).getTop() - getDividerHeight() - paramView.getHeight();
      }
    }
  }

  protected void e()
  {
    if (this.c != null)
    {
      MotionEvent localMotionEvent = this.b.a(this.c, 2, getNextEstimatedDrawTime());
      super.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.c.recycle();
      this.c = null;
    }
  }

  protected long getNextEstimatedDrawTime()
  {
    return SystemClock.uptimeMillis();
  }

  protected void onAttachedToWindow()
  {
    getViewTreeObserver().addOnPreDrawListener(this.g);
    super.onAttachedToWindow();
  }

  protected void onDetachedFromWindow()
  {
    getViewTreeObserver().removeOnPreDrawListener(this.g);
    super.onDetachedFromWindow();
    this.e.b(this);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    super.onMeasure(paramInt1, paramInt2);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((Build.VERSION.SDK_INT < 11) || (Build.VERSION.SDK_INT > 15))
      bool = super.onTouchEvent(paramMotionEvent);
    while (true)
    {
      return bool;
      if (this.b == null)
        this.b = new MultitouchResampler();
      if (!isEnabled())
      {
        if ((!isClickable()) && (!isLongClickable()))
          bool = false;
      }
      else
      {
        this.b.a(paramMotionEvent);
        switch (paramMotionEvent.getActionMasked())
        {
        default:
          if (this.c != null)
          {
            this.c.recycle();
            this.c = null;
          }
          bool = super.onTouchEvent(paramMotionEvent);
          break;
        case 2:
          if (this.c != null)
            this.c.recycle();
          this.c = MotionEvent.obtain(paramMotionEvent);
          invalidate();
        }
      }
    }
  }

  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    boolean bool = true;
    for (int m = 0; m < this.h.size(); m++)
      bool &= ((BetterListView.OnRemoveDetachedViewListener)this.h.a(m)).a(this, paramView);
    if (bool)
      super.removeDetachedView(paramView, paramBoolean);
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    ListAdapter localListAdapter = getAdapter();
    if ((localListAdapter != paramListAdapter) && ((localListAdapter instanceof ManagedRecycleViewAdapter)))
      setRecyclerListener(null);
    super.setAdapter(paramListAdapter);
  }

  public void setBroadcastInteractionChanges(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (this.d)
      a(this.f);
    while (true)
    {
      return;
      b(this.f);
    }
  }

  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.a(paramOnScrollListener);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.BetterListView
 * JD-Core Version:    0.6.2
 */