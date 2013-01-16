package com.facebook.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.R.styleable;
import com.facebook.orca.debug.Tracer;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class VariableTextLayoutView<T> extends View
{
  private static final Class<?> a = VariableTextLayoutView.class;
  private T b;
  private int c;
  private int d;
  private int e;
  private Typeface f = Typeface.SANS_SERIF;
  private int g = 1;
  private Layout.Alignment h;
  private int i;
  private List<TextPaint> j;
  private Layout k;
  private Map<Integer, Layout> l;
  private int m = 0;
  private ViewTreeObserver.OnPreDrawListener n = new VariableTextLayoutView.1(this);

  public VariableTextLayoutView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public VariableTextLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public VariableTextLayoutView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private int a(Layout paramLayout, int paramInt)
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < paramLayout.getLineCount())
    {
      i2 = Math.max(i2, (int)paramLayout.getLineWidth(i1));
      i1++;
    }
    int i3 = i2 + (getPaddingLeft() + getPaddingRight());
    int i4 = View.MeasureSpec.getMode(paramInt);
    int i5 = View.MeasureSpec.getSize(paramInt);
    switch (i4)
    {
    default:
    case 0:
    case -2147483648:
    }
    for (i3 = i5; ; i3 = Math.min(i3, i5))
      return i3;
  }

  private Layout.Alignment a(int paramInt)
  {
    Layout.Alignment localAlignment;
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Invalid alignment: " + paramInt);
    case 0:
      localAlignment = Layout.Alignment.ALIGN_NORMAL;
    case 1:
    case 2:
    }
    while (true)
    {
      return localAlignment;
      localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
      continue;
      localAlignment = Layout.Alignment.ALIGN_CENTER;
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    Typeface localTypeface = null;
    switch (paramInt1)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      setTypeface(localTypeface, paramInt2);
      return;
      localTypeface = Typeface.SANS_SERIF;
      continue;
      localTypeface = Typeface.SERIF;
      continue;
      localTypeface = Typeface.MONOSPACE;
    }
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.l = new MapMaker().b(5).c(120L, TimeUnit.SECONDS).n();
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.VariableTextLayoutView);
    this.c = localTypedArray.getColor(0, Color.rgb(0, 0, 0));
    this.d = localTypedArray.getInteger(4, 14);
    this.e = localTypedArray.getInteger(5, 18);
    this.h = a(localTypedArray.getInteger(6, 2));
    this.i = localTypedArray.getInteger(1, 2);
    int i1 = localTypedArray.getInteger(3, 0);
    a(localTypedArray.getInt(2, -1), i1);
    localTypedArray.recycle();
    if (this.e < this.d)
      throw new IllegalArgumentException("Invalid text sizes");
  }

  private float b(int paramInt)
  {
    if (paramInt == -1);
    for (float f1 = -1.0F; ; f1 = TypedValue.applyDimension(2, paramInt, getResources().getDisplayMetrics()))
      return f1;
  }

  private int b(Layout paramLayout, int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    int i3 = paramLayout.getHeight() + getPaddingBottom() + getPaddingTop();
    switch (i1)
    {
    default:
    case 0:
    case -2147483648:
    }
    for (i3 = i2; ; i3 = Math.min(i3, i2))
      return i3;
  }

  private void b()
  {
    this.j = Lists.a();
    for (int i1 = this.e; i1 >= this.d; i1--)
      this.j.add(c(i1));
  }

  private TextPaint c(int paramInt)
  {
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.density = getResources().getDisplayMetrics().density;
    localTextPaint.setTextSize(b(paramInt));
    localTextPaint.setTypeface(Typeface.create(this.f, this.g));
    localTextPaint.setColor(this.c);
    return localTextPaint;
  }

  private void c()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver == null);
    while (true)
    {
      return;
      if (this.m == 0)
      {
        localViewTreeObserver.addOnPreDrawListener(this.n);
        this.m = 1;
      }
      else if (this.m == 2)
      {
        this.m = 1;
      }
    }
  }

  private Layout d(int paramInt)
  {
    return getVariableTextLayoutComputer().a(this.b, this.j, paramInt, this.h, this.i, -1);
  }

  private boolean d()
  {
    int i1 = 1;
    if (this.m != i1);
    while (true)
    {
      return i1;
      g();
      f();
      boolean bool = e();
      this.m = 2;
      if (bool)
        int i2 = 0;
    }
  }

  private boolean e()
  {
    Layout.Alignment localAlignment = this.k.getParagraphAlignment(0);
    int i1 = this.k.getParagraphDirection(0);
    int i2 = getWidth() - (getPaddingLeft() + getPaddingRight());
    int i3;
    int i4;
    if (localAlignment == Layout.Alignment.ALIGN_CENTER)
    {
      i3 = (int)FloatMath.floor(this.k.getLineLeft(0));
      i4 = (int)FloatMath.ceil(this.k.getLineRight(0));
      if (i4 - i3 < i2)
      {
        i3 = (i3 + i4) / 2 - i2 / 2;
        if (i3 == getScrollX())
          break label215;
        scrollTo(i3, getScrollY());
      }
    }
    label215: for (boolean bool = true; ; bool = false)
    {
      return bool;
      if (i1 >= 0)
        break;
      i3 = i4 - i2;
      break;
      if (localAlignment == Layout.Alignment.ALIGN_NORMAL)
      {
        if (i1 < 0)
        {
          i3 = (int)FloatMath.ceil(this.k.getLineRight(0)) - i2;
          break;
        }
        i3 = (int)FloatMath.floor(this.k.getLineLeft(0));
        break;
      }
      if (i1 < 0)
      {
        i3 = (int)FloatMath.floor(this.k.getLineLeft(0));
        break;
      }
      i3 = (int)FloatMath.ceil(this.k.getLineRight(0)) - i2;
      break;
    }
  }

  private void f()
  {
    if (this.k == null)
      this.k = getVariableTextLayoutComputer().a(this.b, this.j, getWidth() - (getPaddingLeft() + getPaddingRight()), this.h, this.i, getHeight());
  }

  private void g()
  {
    if (this.j == null)
      b();
  }

  protected void a()
  {
    this.k = null;
    this.l.clear();
    requestLayout();
    invalidate();
    c();
  }

  public Layout.Alignment getAlignment()
  {
    return this.h;
  }

  public T getData()
  {
    return this.b;
  }

  public int getMaxLines()
  {
    return this.i;
  }

  public float getMaxScaledTextSize()
  {
    return this.e;
  }

  public float getMinScaledTextSize()
  {
    return this.d;
  }

  public int getTextColor()
  {
    return this.c;
  }

  public Typeface getTypefaceFamily()
  {
    return this.f;
  }

  public int getTypefaceStyle()
  {
    return this.g;
  }

  protected abstract VariableTextLayoutComputer<T> getVariableTextLayoutComputer();

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if ((localViewTreeObserver != null) && (this.m != 0))
    {
      localViewTreeObserver.removeOnPreDrawListener(this.n);
      this.m = 0;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    g();
    f();
    paramCanvas.save();
    int i1 = getPaddingTop();
    int i2 = getPaddingRight();
    int i3 = getPaddingBottom();
    int i4 = getScrollX();
    int i5 = getScrollY();
    int i6 = getHeight() - i3 - i1;
    int i7 = this.k.getHeight() - i6;
    float f1 = i4 + getPaddingLeft();
    if (i5 == 0);
    for (float f2 = 0.0F; ; f2 = i1 + i5)
    {
      float f3 = i4 + (getWidth() - i2);
      int i8 = i5 + getHeight();
      if (i5 == i7)
        i3 = 0;
      paramCanvas.clipRect(f1, f2, f3, i8 - i3);
      int i9 = Math.max(0, i6 - this.k.getHeight()) / 2;
      paramCanvas.translate(getPaddingLeft(), i9 + i1);
      this.k.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Tracer localTracer = Tracer.a("ThreadNameView.onMeasure");
    g();
    int i1 = getDefaultSize(16384, paramInt1);
    Layout localLayout = (Layout)this.l.get(Integer.valueOf(i1));
    if (localLayout == null)
    {
      localLayout = d(i1 - (getPaddingLeft() + getPaddingRight()));
      this.l.put(Integer.valueOf(i1), localLayout);
    }
    int i2 = a(localLayout, paramInt1);
    int i4;
    if (i2 == i1)
    {
      i4 = b(localLayout, paramInt2);
      this.k = localLayout;
    }
    for (int i3 = i4; ; i3 = b(this.k, paramInt2))
    {
      setMeasuredDimension(i2, i3);
      localTracer.a();
      return;
      this.k = d(i2 - (getPaddingLeft() + getPaddingRight()));
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }

  public void setAlignment(Layout.Alignment paramAlignment)
  {
    this.h = paramAlignment;
    this.j = null;
    a();
    invalidate();
  }

  public void setData(T paramT)
  {
    this.b = paramT;
    a();
    invalidate();
  }

  public void setMaxLines(int paramInt)
  {
    this.i = paramInt;
    a();
    invalidate();
  }

  public void setScaledTextSizes(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1)
      throw new IllegalArgumentException("Invalid text sizes");
    this.d = paramInt1;
    this.e = paramInt2;
    this.j = null;
    a();
    invalidate();
  }

  public void setTextColor(int paramInt)
  {
    this.c = paramInt;
    this.j = null;
    invalidate();
  }

  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    if (paramInt > 0)
      if (paramTypeface != null)
        break label37;
    label37: for (paramTypeface = Typeface.defaultFromStyle(paramInt); ; paramTypeface = Typeface.create(paramTypeface, paramInt))
    {
      this.f = paramTypeface;
      this.g = paramInt;
      this.j = null;
      a();
      invalidate();
      return;
    }
  }

  public void setTypefaceFamily(Typeface paramTypeface)
  {
    this.f = paramTypeface;
    this.j = null;
    a();
    invalidate();
  }

  public void setTypefaceStyle(int paramInt)
  {
    this.g = paramInt;
    this.j = null;
    a();
    invalidate();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.VariableTextLayoutView
 * JD-Core Version:    0.6.2
 */