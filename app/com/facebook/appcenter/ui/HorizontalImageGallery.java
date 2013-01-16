package com.facebook.appcenter.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.facebook.R.styleable;
import com.google.common.base.Preconditions;

public class HorizontalImageGallery extends HorizontalScrollView
{
  private int a;
  private LinearLayout b;
  private int c;
  private int d = 0;
  private int e = 0;
  private float f = 0.0F;
  private float g = 0.0F;
  private View.OnTouchListener h;
  private HorizontalImageGallery.CustomOnTouchListener i;
  private float j = 0.0F;
  private float k = 0.0F;
  private int l;
  private boolean m;
  private boolean n;
  private HorizontalImageGalleryItemIndicator o = null;
  private Context p;

  public HorizontalImageGallery(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public HorizontalImageGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public HorizontalImageGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.p = paramContext;
    this.b = new LinearLayout(this.p);
    this.b.setOrientation(0);
    super.addView(this.b, -1, new FrameLayout.LayoutParams(-1, -2));
    setSmoothScrollingEnabled(true);
    setHorizontalFadingEdgeEnabled(false);
    setHorizontalScrollBarEnabled(false);
    this.c = getScreenMetrics().widthPixels;
    setItemWidth(this.c);
    this.e = 0;
    this.i = new HorizontalImageGallery.CustomOnTouchListener(this, null);
    super.setOnTouchListener(this.i);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.HorizontalImageGallery);
    setLeftItemWidthPercentage(localTypedArray.getInt(0, 5));
    this.n = localTypedArray.getBoolean(1, true);
  }

  private int a(MotionEvent paramMotionEvent)
  {
    int i1;
    if (this.l != 0)
      i1 = this.l;
    while (true)
    {
      return i1;
      float f1 = Math.abs(this.f - paramMotionEvent.getX());
      if (Math.abs(this.g - paramMotionEvent.getY()) - f1 > 10.0F)
      {
        i1 = 2;
        continue;
      }
      i1 = 1;
    }
  }

  private DisplayMetrics getScreenMetrics()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = ((Activity)this.p).getWindowManager();
    Preconditions.checkNotNull(localWindowManager);
    Display localDisplay = localWindowManager.getDefaultDisplay();
    Preconditions.checkNotNull(localDisplay);
    localDisplay.getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }

  public void a()
  {
    this.b.removeAllViews();
    this.e = 0;
    if (this.o != null)
      this.o.a();
  }

  public void a(int paramInt)
  {
    int i1 = this.e;
    if (paramInt >= getItemCount());
    for (int i2 = paramInt - 1; ; i2 = paramInt)
    {
      if (i2 < 0)
        i2 = 0;
      int i3 = (int)(this.a / 100.0F * this.d);
      smoothScrollTo(i2 * this.d - i3, 0);
      this.e = i2;
      if ((this.o != null) && (i1 != i2))
        this.o.setCurrentPage(i2);
      return;
    }
  }

  public void addView(View paramView)
  {
    addView(paramView, -1);
  }

  public void addView(View paramView, int paramInt)
  {
    Object localObject;
    if (paramView.getLayoutParams() == null)
      localObject = new FrameLayout.LayoutParams(this.d, -1);
    while (true)
    {
      addView(paramView, paramInt, (ViewGroup.LayoutParams)localObject);
      return;
      localObject = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.d;
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    requestLayout();
    invalidate();
    this.b.addView(paramView, paramInt, paramLayoutParams);
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.width = this.d;
    addView(paramView, -1, paramLayoutParams);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (!this.n)
      bool = super.dispatchTouchEvent(paramMotionEvent);
    while (true)
    {
      return bool;
      if (paramMotionEvent.getAction() == 0)
      {
        this.j = paramMotionEvent.getX();
        this.k = paramMotionEvent.getY();
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      if ((!bool) || (paramMotionEvent.getAction() != 2) || (Math.abs(paramMotionEvent.getX() - this.j) <= Math.abs(paramMotionEvent.getY() - this.k)) || (Math.abs(paramMotionEvent.getX() - this.j) <= 20.0F))
        continue;
      requestDisallowInterceptTouchEvent(true);
    }
  }

  public int getActiveItem()
  {
    return this.e;
  }

  public int getItemCount()
  {
    return this.b.getChildCount();
  }

  public HorizontalImageGalleryItemIndicator getItemIndicator()
  {
    return this.o;
  }

  public int getItemWidth()
  {
    return this.d;
  }

  public LinearLayout getItemsContainer()
  {
    return this.b;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    int i2;
    if (paramMotionEvent.getAction() == 0)
    {
      this.f = paramMotionEvent.getX();
      this.g = paramMotionEvent.getY();
      if (!this.m)
        this.l = 0;
      int i1 = this.l;
      i2 = 0;
      if (i1 != 2)
        break label76;
    }
    while (true)
    {
      return i2;
      if (paramMotionEvent.getAction() != 2)
        break;
      a(paramMotionEvent);
      break;
      label76: if (this.l == 1)
      {
        this.m = true;
        i2 = 1;
        continue;
      }
      i2 = bool;
    }
  }

  public void setActiveItem(int paramInt)
  {
    this.e = paramInt;
  }

  public void setItemIndicator(HorizontalImageGalleryItemIndicator paramHorizontalImageGalleryItemIndicator)
  {
    this.o = paramHorizontalImageGalleryItemIndicator;
    paramHorizontalImageGalleryItemIndicator.setPageCount(getItemCount());
    paramHorizontalImageGalleryItemIndicator.setCurrentPage(this.e);
  }

  public void setItemWidth(int paramInt)
  {
    this.d = paramInt;
  }

  public void setLeftItemWidthPercentage(int paramInt)
  {
    this.a = paramInt;
  }

  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.h = paramOnTouchListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.HorizontalImageGallery
 * JD-Core Version:    0.6.0
 */