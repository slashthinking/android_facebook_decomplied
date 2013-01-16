package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.R.styleable;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;

public abstract class DragSortListView extends ListView
{
  protected int a = -1;
  protected int b = -1;
  protected int c = -1;
  private ImageView d;
  private LinearLayout e;
  private WindowManager f;
  private WindowManager.LayoutParams g;
  private int h;
  private int i;
  private int j;
  private int k;
  private DragSortListView.DragListener l;
  private DragSortListView.DropListener m;
  private int n;
  private int o;
  private int p;
  private GestureDetector q;
  private Rect r = new Rect();
  private Bitmap s;
  private final int t;
  private int u = -1;
  private Drawable v = null;
  private Drawable w = null;
  private long x;
  private final FbErrorReporter y;

  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.t = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView, 0, 0);
      this.a = localTypedArray.getDimensionPixelSize(0, 0);
      this.b = (-1 + 2 * this.a);
      this.c = localTypedArray.getResourceId(i1, -1);
      this.u = localTypedArray.getResourceId(2, -1);
      this.v = localTypedArray.getDrawable(4);
      this.w = localTypedArray.getDrawable(3);
      localTypedArray.recycle();
    }
    if (this.a > 0)
    {
      int i3 = i1;
      Preconditions.checkArgument(i3, "Item height must be > 0");
      if (this.c <= 0)
        break label207;
    }
    while (true)
    {
      Preconditions.checkArgument(i1, "Grabber id must be valid");
      this.y = ((FbErrorReporter)FbInjector.a(paramContext).a(FbErrorReporter.class));
      return;
      int i4 = 0;
      break;
      label207: int i2 = 0;
    }
  }

  private int a(int paramInt)
  {
    int i1 = paramInt - this.j - this.a / 2;
    int i2 = a(0, i1);
    if (i2 >= 0)
      if (i2 <= this.i)
        i2++;
    while (true)
    {
      return i2;
      if (i1 < 0)
        i2 = 0;
    }
  }

  private int a(int paramInt1, int paramInt2)
  {
    Rect localRect = this.r;
    int i1 = -1 + getChildCount();
    if (i1 >= 0)
    {
      getChildAt(i1).getHitRect(localRect);
      if (!localRect.contains(paramInt1, paramInt2));
    }
    for (int i2 = i1 + getFirstVisiblePosition(); ; i2 = -1)
    {
      return i2;
      i1--;
      break;
    }
  }

  private void a()
  {
    for (int i1 = 0; ; i1++)
      if (getChildAt(i1) == null)
      {
        layoutChildren();
        if (getChildAt(i1) == null)
        {
          e();
          return;
        }
      }
  }

  private void a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    c();
    this.x = SystemClock.elapsedRealtime();
    this.g = new WindowManager.LayoutParams();
    this.g.gravity = 51;
    this.g.x = paramInt1;
    this.g.y = (paramInt2 - this.j + this.k);
    this.g.height = -2;
    this.g.width = -2;
    this.g.flags = 408;
    this.g.format = -3;
    this.g.windowAnimations = 0;
    this.d = new ImageView(getContext());
    if (this.v != null)
      this.d.setBackgroundDrawable(this.v);
    this.d.setImageBitmap(paramBitmap);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.addView(this.d);
    if (this.w != null)
      localLinearLayout.setBackgroundDrawable(this.w);
    this.s = paramBitmap;
    this.f = ((WindowManager)FbInjector.a(getContext()).a(WindowManager.class));
    this.f.addView(localLinearLayout, this.g);
    this.e = localLinearLayout;
  }

  private void b()
  {
    if (SystemClock.elapsedRealtime() - this.x < 50L)
      return;
    int i1 = getDragSortListAdapter().a();
    int i2 = getDragSortListAdapter().b();
    int i3 = getBoundedDragPosition() - getFirstVisiblePosition();
    if ((this.h >= this.i) && (this.h < i2))
      i3++;
    int i4 = 1 + (getLastVisiblePosition() - getFirstVisiblePosition());
    int i5 = this.i - getFirstVisiblePosition();
    int i6;
    if ((this.i == i2) && (this.h >= i2))
      i6 = i3 - 1;
    while (true)
    {
      if (i1 == i2)
      {
        a(getChildAt(i5), this.a, 80, 4);
        break;
        if ((this.i != i1) || (this.h >= i1))
          break label296;
        i6 = i3 + 1;
        continue;
      }
      int i7 = 0;
      View localView;
      if (i7 < i4)
      {
        localView = getChildAt(i7);
        if (localView != null);
      }
      else
      {
        layoutChildren();
        break;
      }
      int i8 = this.a;
      int i11;
      int i9;
      int i10;
      if (i7 == i5)
      {
        i11 = 4;
        i9 = 1;
        i10 = 80;
      }
      while (true)
      {
        a(localView, i9, i10, i11);
        i7++;
        break;
        if (i7 == i6)
        {
          int i12 = this.b;
          if (this.h >= i2)
          {
            i10 = 48;
            i9 = i12;
            i11 = 0;
          }
          else
          {
            i10 = 80;
            i9 = i12;
            i11 = 0;
          }
        }
        else
        {
          i9 = i8;
          i10 = 80;
          i11 = 0;
        }
      }
      label296: i6 = i3;
    }
  }

  private void b(int paramInt)
  {
    if (paramInt >= this.p / 3)
      this.n = (this.p / 3);
    if (paramInt <= 2 * this.p / 3)
      this.o = (2 * this.p / 3);
  }

  private void b(int paramInt1, int paramInt2)
  {
    this.g.y = (paramInt2 - this.j + this.k);
    this.f.updateViewLayout(this.e, this.g);
  }

  private void c()
  {
    d();
  }

  private void d()
  {
    if (this.e != null)
    {
      ((WindowManager)FbInjector.a(getContext()).a(WindowManager.class)).removeView(this.e);
      this.d.setImageDrawable(null);
      this.d = null;
      this.e = null;
    }
    if (this.s != null)
    {
      this.s.recycle();
      this.s = null;
    }
  }

  private void e()
  {
    for (int i1 = 0; i1 < getChildCount(); i1++)
      a(getChildAt(i1));
  }

  private int getBoundedDragPosition()
  {
    int i1 = getDragSortListAdapter().a();
    int i2 = getDragSortListAdapter().b();
    int i3 = this.h;
    if (i3 > i2);
    while (true)
    {
      return i2;
      if (i3 < i1)
        i2 = i1;
      else
        i2 = i3;
    }
  }

  private DragSortListView.DragSortListAdapter getDragSortListAdapter()
  {
    return (DragSortListView.DragSortListAdapter)getAdapter();
  }

  protected abstract void a(View paramView);

  protected void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1);
    while (true)
    {
      return;
      View localView = paramView.findViewById(paramInt1);
      if (localView != null)
        localView.setVisibility(paramInt2);
    }
  }

  protected abstract void a(View paramView, int paramInt1, int paramInt2, int paramInt3);

  public final void addFooterView(View paramView)
  {
    throw new RuntimeException("Footers are not supported with DragSortListView in conjunction with remove_mode");
  }

  public final void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    throw new RuntimeException("Footers are not supported with DragSortListView in conjunction with remove_mode");
  }

  public final void addHeaderView(View paramView)
  {
    throw new RuntimeException("Headers are not supported with DragSortListView");
  }

  public final void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    throw new RuntimeException("Headers are not supported with DragSortListView");
  }

  protected abstract boolean b(View paramView);

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.l != null) || (this.m != null))
      switch (paramMotionEvent.getAction())
      {
      default:
      case 0:
      }
    while (true)
    {
      boolean bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      label43: return bool1;
      int i1 = (int)paramMotionEvent.getX();
      int i2 = (int)paramMotionEvent.getY();
      int i3 = pointToPosition(i1, i2);
      if (i3 != -1)
      {
        View localView1 = getChildAt(i3 - getFirstVisiblePosition());
        if (b(localView1))
        {
          this.j = (i2 - localView1.getTop());
          this.k = ((int)paramMotionEvent.getRawY() - i2);
          View localView2 = localView1.findViewById(this.c);
          Rect localRect1 = this.r;
          localRect1.left = localView2.getLeft();
          localRect1.right = localView2.getRight();
          localRect1.top = localView2.getTop();
          localRect1.bottom = localView2.getBottom();
          if ((localRect1.left <= i1) && (i1 <= localRect1.right))
          {
            View localView3 = localView1.findViewById(this.u);
            int i4 = localView3.getVisibility();
            if (i4 == 0)
              localView3.setVisibility(4);
            boolean bool2 = localView1.isDrawingCacheEnabled();
            boolean bool3 = localView1.willNotCacheDrawing();
            localView1.setDrawingCacheEnabled(true);
            localView1.setWillNotCacheDrawing(false);
            try
            {
              if (localView1.getDrawingCache() == null)
              {
                this.y.a("bookmark", "The drawing cache is null while dragging the item in the list! " + localView1, false);
                localView1.setDrawingCacheEnabled(bool2);
                localView1.setWillNotCacheDrawing(bool3);
                continue;
              }
              Bitmap localBitmap = Bitmap.createBitmap(localView1.getDrawingCache());
              localView1.setDrawingCacheEnabled(bool2);
              localView1.setWillNotCacheDrawing(bool3);
              if (i4 == 0)
                localView3.setVisibility(0);
              Rect localRect2 = new Rect();
              getGlobalVisibleRect(localRect2, null);
              a(localBitmap, localRect2.left, i2);
              this.h = i3;
              this.i = this.h;
              this.p = getHeight();
              int i5 = this.t;
              this.n = Math.min(i2 - i5, this.p / 3);
              this.o = Math.max(i5 + i2, 2 * this.p / 3);
              bool1 = false;
              break label43;
            }
            finally
            {
              localView1.setDrawingCacheEnabled(bool2);
              localView1.setWillNotCacheDrawing(bool3);
            }
          }
          else
          {
            this.e = null;
          }
        }
      }
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.q != null)
      this.q.onTouchEvent(paramMotionEvent);
    boolean bool;
    int i2;
    int i7;
    if (((this.l != null) || (this.m != null)) && (this.e != null))
    {
      switch (paramMotionEvent.getAction())
      {
      default:
      case 1:
      case 3:
      case 0:
      case 2:
      }
      int i3;
      do
      {
        while (true)
        {
          bool = true;
          return bool;
          Rect localRect = this.r;
          this.e.getDrawingRect(localRect);
          c();
          if ((this.m != null) && (this.h != this.i))
            this.m.a(this.i, getBoundedDragPosition());
          a();
        }
        int i1 = (int)paramMotionEvent.getX();
        i2 = (int)paramMotionEvent.getY();
        b(i1, i2);
        i3 = a(i2);
      }
      while (i3 < 0);
      if (this.l != null)
        this.l.a(this.h, i3);
      this.h = i3;
      b();
      b(i2);
      if (i2 > this.o)
        if (i2 > (this.p + this.o) / 2)
        {
          i7 = 16;
          label237: if (getLastVisiblePosition() >= 2 + getDragSortListAdapter().b())
            break label417;
        }
    }
    while (true)
    {
      int i4 = i7;
      while (true)
      {
        label259: if (i4 == 0)
          break label415;
        int i5 = pointToPosition(0, this.p / 2);
        if (i5 == -1)
          i5 = pointToPosition(0, 64 + (this.p / 2 + getDividerHeight()));
        View localView = getChildAt(i5 - getFirstVisiblePosition());
        if (localView == null)
          break;
        setSelectionFromTop(i5, localView.getTop() - i4);
        break;
        i7 = 4;
        break label237;
        if (i2 < this.n)
        {
          int i6;
          if (i2 < this.n / 2)
            i6 = -16;
          while (true)
            if (getFirstVisiblePosition() > -2 + getDragSortListAdapter().a())
            {
              i4 = i6;
              break label259;
              i6 = -4;
              continue;
              bool = super.onTouchEvent(paramMotionEvent);
              break;
            }
        }
        i4 = 0;
      }
      label415: break;
      label417: i7 = 0;
    }
  }

  public final void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter != null) && (!(paramListAdapter instanceof DragSortListView.DragSortListAdapter)))
      throw new RuntimeException("DragSortListView expects a DragSortListAdapter based adapter");
    super.setAdapter(paramListAdapter);
  }

  public void setDragListener(DragSortListView.DragListener paramDragListener)
  {
    this.l = paramDragListener;
  }

  public void setDropListener(DragSortListView.DropListener paramDropListener)
  {
    this.m = paramDropListener;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.DragSortListView
 * JD-Core Version:    0.6.2
 */