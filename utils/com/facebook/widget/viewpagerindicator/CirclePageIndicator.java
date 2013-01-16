package com.facebook.widget.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.facebook.R.styleable;

public class CirclePageIndicator extends View
  implements PageIndicator
{
  private float a;
  private final Paint b = new Paint(1);
  private final Paint c = new Paint(1);
  private final Paint d = new Paint(1);
  private ViewPager e;
  private ViewPager.OnPageChangeListener f;
  private int g;
  private int h;
  private float i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private int n;
  private float o = -1.0F;
  private int p = -1;
  private boolean q;

  public CirclePageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }

  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772033);
  }

  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode());
    while (true)
    {
      return;
      Resources localResources = getResources();
      int i1 = localResources.getColor(2131165334);
      int i2 = localResources.getColor(2131165333);
      int i3 = localResources.getInteger(2131558405);
      int i4 = localResources.getColor(2131165335);
      float f1 = localResources.getDimension(2131230823);
      float f2 = localResources.getDimension(2131230822);
      boolean bool1 = localResources.getBoolean(2131623936);
      boolean bool2 = localResources.getBoolean(2131623937);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CirclePageIndicator, paramInt, 0);
      this.l = localTypedArray.getBoolean(1, bool1);
      this.k = localTypedArray.getInt(0, i3);
      this.b.setStyle(Paint.Style.FILL);
      this.b.setColor(localTypedArray.getColor(4, i1));
      this.c.setStyle(Paint.Style.FILL);
      this.c.setColor(localTypedArray.getColor(7, i4));
      this.c.setStrokeWidth(localTypedArray.getDimension(2, f1));
      this.d.setStyle(Paint.Style.FILL);
      this.d.setColor(localTypedArray.getColor(3, i2));
      this.a = localTypedArray.getDimension(5, f2);
      this.m = localTypedArray.getBoolean(6, bool2);
      localTypedArray.recycle();
      this.n = ViewConfigurationCompat.a(ViewConfiguration.get(paramContext));
    }
  }

  private int c(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    int i3;
    if ((i1 == 1073741824) || (this.e == null))
      i3 = i2;
    while (true)
    {
      return i3;
      int i4 = this.e.getAdapter().b();
      i3 = (int)(1.0F + (getPaddingLeft() + getPaddingRight() + i4 * 2 * this.a + (i4 - 1) * this.a));
      if (i1 == -2147483648)
        i3 = Math.min(i3, i2);
    }
  }

  private int d(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    if (i1 == 1073741824);
    while (true)
    {
      return i2;
      int i3 = (int)(1.0F + (2.0F * this.a + getPaddingTop() + getPaddingBottom()));
      if (i1 == -2147483648)
        i2 = Math.min(i3, i2);
      else
        i2 = i3;
    }
  }

  public void a()
  {
    this.g = 0;
    this.h = 0;
    this.i = 0.0F;
    invalidate();
  }

  public void a(int paramInt)
  {
    if ((this.m) || (this.j == 0))
    {
      this.g = paramInt;
      this.h = paramInt;
      invalidate();
    }
    if (this.f != null)
      this.f.a(paramInt);
  }

  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    this.g = paramInt1;
    this.i = paramFloat;
    invalidate();
    if (this.f != null)
      this.f.a(paramInt1, paramFloat, paramInt2);
  }

  public void b(int paramInt)
  {
    this.j = paramInt;
    if (this.f != null)
      this.f.b(paramInt);
  }

  public int getFillColor()
  {
    return this.d.getColor();
  }

  public int getOrientation()
  {
    return this.k;
  }

  public int getPageColor()
  {
    return this.b.getColor();
  }

  public float getRadius()
  {
    return this.a;
  }

  public int getStrokeColor()
  {
    return this.c.getColor();
  }

  public float getStrokeWidth()
  {
    return this.c.getStrokeWidth();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.e == null);
    int i1;
    while (true)
    {
      return;
      i1 = this.e.getAdapter().b();
      if (i1 != 0)
      {
        if (this.g < i1)
          break;
        setCurrentItem(i1 - 1);
      }
    }
    int i2;
    int i3;
    int i4;
    int i5;
    float f1;
    float f2;
    float f3;
    float f4;
    int i6;
    label170: float f8;
    float f9;
    if (this.k == 0)
    {
      i2 = getWidth();
      i3 = getPaddingLeft();
      i4 = getPaddingRight();
      i5 = getPaddingTop();
      f1 = 3.0F * this.a;
      f2 = i5 + this.a;
      f3 = i3 + this.a;
      if (this.l)
        f3 += (i2 - i3 - i4) / 2.0F - f1 * i1 / 2.0F;
      f4 = this.a;
      if (this.c.getStrokeWidth() > 0.0F)
        f4 -= this.c.getStrokeWidth() / 2.0F;
      i6 = 0;
      if (i6 >= i1)
        break label291;
      f8 = f3 + f1 * i6;
      if (this.k != 0)
        break label284;
      f9 = f8;
      f8 = f2;
    }
    while (true)
    {
      if (this.b.getAlpha() > 0)
        paramCanvas.drawCircle(f9, f8, f4, this.b);
      if (f4 != this.a)
        paramCanvas.drawCircle(f9, f8, this.a, this.c);
      i6++;
      break label170;
      i2 = getHeight();
      i3 = getPaddingTop();
      i4 = getPaddingBottom();
      i5 = getPaddingLeft();
      break;
      label284: f9 = f2;
    }
    label291: int i7;
    label304: float f5;
    float f7;
    if (this.m)
    {
      i7 = this.h;
      f5 = f1 * i7;
      if (!this.m)
        f5 += f1 * this.i;
      if (this.k != 0)
        break label373;
      f7 = f3 + f5;
    }
    while (true)
    {
      paramCanvas.drawCircle(f7, f2, this.a, this.d);
      break;
      i7 = this.g;
      break label304;
      label373: float f6 = f3 + f5;
      f7 = f2;
      f2 = f6;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.k == 0)
      setMeasuredDimension(c(paramInt1), d(paramInt2));
    while (true)
    {
      return;
      setMeasuredDimension(d(paramInt1), c(paramInt2));
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    CirclePageIndicator.SavedState localSavedState = (CirclePageIndicator.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.g = localSavedState.a;
    this.h = localSavedState.a;
    requestLayout();
  }

  public Parcelable onSaveInstanceState()
  {
    CirclePageIndicator.SavedState localSavedState = new CirclePageIndicator.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.g;
    return localSavedState;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 1;
    if (super.onTouchEvent(paramMotionEvent));
    while (true)
    {
      return i1;
      if ((this.e == null) || (this.e.getAdapter().b() == 0))
        i1 = 0;
      else
        switch (0xFF & paramMotionEvent.getAction())
        {
        case 4:
        default:
          break;
        case 0:
          this.p = MotionEventCompat.b(paramMotionEvent, 0);
          this.o = paramMotionEvent.getX();
          break;
        case 2:
          float f3 = MotionEventCompat.c(paramMotionEvent, MotionEventCompat.a(paramMotionEvent, this.p));
          float f4 = f3 - this.o;
          if ((!this.q) && (Math.abs(f4) > this.n))
            this.q = i1;
          if (this.q)
          {
            this.o = f3;
            if ((this.e.f()) || (this.e.d()))
              this.e.b(f4);
          }
          break;
        case 1:
        case 3:
          if (!this.q)
          {
            int i5 = this.e.getAdapter().b();
            int i6 = getWidth();
            float f1 = i6 / 2.0F;
            float f2 = i6 / 6.0F;
            if ((this.g > 0) && (paramMotionEvent.getX() < f1 - f2))
              this.e.setCurrentItem(-1 + this.g);
            else if ((this.g < i5 - 1) && (paramMotionEvent.getX() > f2 + f1))
              this.e.setCurrentItem(1 + this.g);
          }
          else
          {
            this.q = false;
            this.p = -1;
            if (this.e.f())
              this.e.e();
          }
          break;
        case 5:
          int i4 = MotionEventCompat.a(paramMotionEvent);
          this.o = MotionEventCompat.c(paramMotionEvent, i4);
          this.p = MotionEventCompat.b(paramMotionEvent, i4);
          break;
        case 6:
          int i2 = MotionEventCompat.a(paramMotionEvent);
          if (MotionEventCompat.b(paramMotionEvent, i2) == this.p)
          {
            int i3 = 0;
            if (i2 == 0)
              i3 = i1;
            this.p = MotionEventCompat.b(paramMotionEvent, i3);
          }
          this.o = MotionEventCompat.c(paramMotionEvent, MotionEventCompat.a(paramMotionEvent, this.p));
        }
    }
  }

  public void setCentered(boolean paramBoolean)
  {
    this.l = paramBoolean;
    invalidate();
  }

  public void setCurrentItem(int paramInt)
  {
    if (this.e == null)
      throw new IllegalStateException("ViewPager has not been bound.");
    this.e.setCurrentItem(paramInt);
    this.g = paramInt;
    invalidate();
  }

  public void setFillColor(int paramInt)
  {
    this.d.setColor(paramInt);
    invalidate();
  }

  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.f = paramOnPageChangeListener;
  }

  public void setOrientation(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    case 0:
    case 1:
    }
    this.k = paramInt;
    requestLayout();
  }

  public void setPageColor(int paramInt)
  {
    this.b.setColor(paramInt);
    invalidate();
  }

  public void setRadius(float paramFloat)
  {
    this.a = paramFloat;
    invalidate();
  }

  public void setSnap(boolean paramBoolean)
  {
    this.m = paramBoolean;
    invalidate();
  }

  public void setStrokeColor(int paramInt)
  {
    this.c.setColor(paramInt);
    invalidate();
  }

  public void setStrokeWidth(float paramFloat)
  {
    this.c.setStrokeWidth(paramFloat);
    invalidate();
  }

  public void setViewPager(ViewPager paramViewPager)
  {
    if (this.e == paramViewPager);
    while (true)
    {
      return;
      if (this.e != null)
        this.e.setOnPageChangeListener(null);
      if (paramViewPager.getAdapter() == null)
        throw new IllegalStateException("ViewPager does not have adapter instance.");
      this.e = paramViewPager;
      this.e.setOnPageChangeListener(this);
      invalidate();
    }
  }

  public void setViewPager(ViewPager paramViewPager, int paramInt)
  {
    setViewPager(paramViewPager);
    setCurrentItem(paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.viewpagerindicator.CirclePageIndicator
 * JD-Core Version:    0.6.2
 */