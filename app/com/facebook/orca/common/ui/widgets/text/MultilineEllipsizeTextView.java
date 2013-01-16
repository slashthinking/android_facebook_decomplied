package com.facebook.orca.common.ui.widgets.text;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.R.styleable;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.Tracer;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MultilineEllipsizeTextView extends View
{
  private static final Class<?> a = MultilineEllipsizeTextView.class;
  private int b;
  private float c;
  private Typeface d;
  private int e;
  private int f;
  private int g;
  private CharSequence h;
  private TextPaint i;
  private MultilineEllipsizeTextView.LayoutResult j;
  private int k = -1;
  private MultilineEllipsizeTextView.LayoutResult l;

  public MultilineEllipsizeTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public MultilineEllipsizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public MultilineEllipsizeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private int a(Layout paramLayout)
  {
    int m = 1;
    int n = 0;
    int i1 = m;
    if (n < paramLayout.getLineCount())
    {
      int i2 = paramLayout.getParagraphDirection(n);
      if (n == 0)
        i1 = i2;
      do
      {
        n++;
        break;
      }
      while (i1 == i2);
      m = 0;
    }
    if (m != 0);
    while (true)
    {
      return i1;
      i1 = 0;
    }
  }

  private int a(Layout paramLayout, int paramInt)
  {
    int m = View.MeasureSpec.getMode(paramInt);
    int n = View.MeasureSpec.getSize(paramInt);
    float f1 = 0.0F;
    for (int i1 = 0; i1 < paramLayout.getLineCount(); i1++)
      f1 = Math.max(f1, paramLayout.getLineWidth(i1));
    int i2 = (int)f1 + getPaddingLeft() + getPaddingRight();
    switch (m)
    {
    default:
    case 0:
    case -2147483648:
    }
    for (i2 = n; ; i2 = Math.min(i2, n))
      return i2;
  }

  private StaticLayout a(MultilineEllipsizeTextView.LineResult paramLineResult, TextPaint paramTextPaint, int paramInt)
  {
    StaticLayout localStaticLayout;
    if (paramLineResult == null)
    {
      localStaticLayout = null;
      return localStaticLayout;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Iterator localIterator = paramLineResult.a.iterator();
    for (int m = 1; localIterator.hasNext(); m = 0)
    {
      CharSequence localCharSequence = (CharSequence)localIterator.next();
      if (m == 0)
        localSpannableStringBuilder.append("\n");
      localSpannableStringBuilder.append(StringUtil.b(localCharSequence));
    }
    if (paramLineResult.b == 0);
    for (int n = paramInt; ; n = 16384)
    {
      localStaticLayout = new StaticLayout(localSpannableStringBuilder, 0, localSpannableStringBuilder.length(), paramTextPaint, n, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, TextUtils.TruncateAt.END, paramInt);
      break;
    }
  }

  private MultilineEllipsizeTextView.LayoutResult a(int paramInt)
  {
    b();
    int m = paramInt - (getPaddingLeft() + getPaddingRight());
    MultilineEllipsizeTextView.LineResult localLineResult = a(this.h, this.i, m, this.g, this.f);
    return new MultilineEllipsizeTextView.LayoutResult(a(localLineResult, this.i, m), localLineResult.b, null);
  }

  private MultilineEllipsizeTextView.LineResult a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = 0;
    if (StringUtil.a(paramCharSequence));
    int n;
    ArrayList localArrayList;
    for (MultilineEllipsizeTextView.LineResult localLineResult = new MultilineEllipsizeTextView.LineResult(Collections.emptyList(), 1, null); ; localLineResult = new MultilineEllipsizeTextView.LineResult(localArrayList, n, null))
    {
      return localLineResult;
      StaticLayout localStaticLayout = new StaticLayout(paramCharSequence, paramTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      n = a(localStaticLayout);
      localArrayList = Lists.a();
      int i1 = paramInt2;
      if ((i1 > 0) && (m < localStaticLayout.getLineCount()))
      {
        int i2 = localStaticLayout.getLineStart(m);
        int i3;
        if ((m < paramInt2 - 1) || (n == 0))
        {
          i3 = localStaticLayout.getLineEnd(m);
          if (paramCharSequence.charAt(i3 - 1) == '\n')
            i3--;
        }
        while (true)
        {
          localArrayList.add(paramCharSequence.subSequence(i2, i3));
          m++;
          i1--;
          break;
          for (i3 = i2; (i3 < paramCharSequence.length()) && (paramCharSequence.charAt(i3) != '\n'); i3++);
        }
      }
      while (localArrayList.size() < paramInt3)
        localArrayList.add("");
    }
  }

  private void a()
  {
    this.j = null;
    this.l = null;
    this.k = -1;
    invalidate();
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
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MultilineEllipsizeTextView);
    this.b = localTypedArray.getColor(0, Color.rgb(0, 0, 0));
    this.c = localTypedArray.getDimensionPixelSize(5, -1);
    this.f = localTypedArray.getInteger(1, 1);
    this.g = localTypedArray.getInteger(1, 2);
    int m = localTypedArray.getInteger(4, 0);
    a(localTypedArray.getInt(3, -1), m);
    localTypedArray.recycle();
    if (this.c == -1.0F)
      this.c = SizeUtil.b(paramContext, 14.0F);
  }

  private int b(Layout paramLayout, int paramInt)
  {
    int m = View.MeasureSpec.getMode(paramInt);
    int n = View.MeasureSpec.getSize(paramInt);
    int i1 = paramLayout.getHeight() + getPaddingTop() + getPaddingBottom();
    switch (m)
    {
    default:
    case 0:
    case -2147483648:
    }
    for (i1 = n; ; i1 = Math.min(i1, n))
      return i1;
  }

  private void b()
  {
    int m;
    TextPaint localTextPaint2;
    float f1;
    if (this.i == null)
    {
      this.i = new TextPaint(1);
      this.i.density = getResources().getDisplayMetrics().density;
      this.i.setTextSize(this.c);
      this.i.setColor(this.b);
      this.i.setTypeface(this.d);
      if (this.d == null)
        break label148;
      m = this.d.getStyle();
      int n = this.e & (m ^ 0xFFFFFFFF);
      TextPaint localTextPaint1 = this.i;
      int i1 = n & 0x1;
      boolean bool = false;
      if (i1 != 0)
        bool = true;
      localTextPaint1.setFakeBoldText(bool);
      localTextPaint2 = this.i;
      if ((n & 0x2) == 0)
        break label153;
      f1 = -0.25F;
    }
    while (true)
    {
      localTextPaint2.setTextSkewX(f1);
      return;
      label148: m = 0;
      break;
      label153: f1 = 0.0F;
    }
  }

  private void c()
  {
    if (this.j == null)
      this.j = a(getWidth());
  }

  public int getMaxLines()
  {
    return this.g;
  }

  public int getMinLines()
  {
    return this.f;
  }

  public CharSequence getText()
  {
    return this.h;
  }

  public int getTextColor()
  {
    return this.b;
  }

  public float getTextSize()
  {
    return this.c;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    b();
    c();
    paramCanvas.save();
    int m = getHeight();
    Layout localLayout = this.j.a;
    int n = Math.max(0, m - localLayout.getHeight()) / 2;
    paramCanvas.translate(getPaddingLeft(), n);
    if (this.j.b == -1)
    {
      int i1 = getWidth() - (getPaddingLeft() + getPaddingRight());
      paramCanvas.translate(-(localLayout.getWidth() - i1), 0.0F);
    }
    localLayout.draw(paramCanvas);
    paramCanvas.restore();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Tracer localTracer = Tracer.a("MultilineEllipsizeTextView.onMeasure");
    b();
    int m = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    if ((m != this.k) || (this.l == null))
    {
      this.l = a(m);
      this.k = m;
    }
    setMeasuredDimension(a(this.l.a, paramInt1), b(this.l.a, paramInt2));
    localTracer.a();
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }

  public void setMaxLines(int paramInt)
  {
    this.g = paramInt;
    a();
    invalidate();
  }

  public void setMinLines(int paramInt)
  {
    this.f = paramInt;
    a();
    invalidate();
  }

  public void setText(CharSequence paramCharSequence)
  {
    this.h = paramCharSequence;
    a();
    invalidate();
  }

  public void setTextColor(int paramInt)
  {
    this.b = paramInt;
    this.i = null;
  }

  public void setTextSize(float paramFloat)
  {
    this.c = paramFloat;
    this.i = null;
  }

  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    if (paramInt > 0)
      if (paramTypeface != null)
        break label37;
    label37: for (paramTypeface = Typeface.defaultFromStyle(paramInt); ; paramTypeface = Typeface.create(paramTypeface, paramInt))
    {
      this.d = paramTypeface;
      this.e = paramInt;
      this.i = null;
      a();
      invalidate();
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.MultilineEllipsizeTextView
 * JD-Core Version:    0.6.0
 */