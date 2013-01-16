package com.facebook.katana.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Button;

public class ResizableFontButton extends Button
{
  private static final Canvas a = new Canvas();
  private final float b = getContext().getResources().getDisplayMetrics().density;
  private boolean c = false;
  private float d = getTextSizeInDip();
  private float e = 8.0F;
  private float f = 1.0F;
  private float g = 0.0F;
  private boolean h = true;

  public ResizableFontButton(Context paramContext)
  {
    super(paramContext);
  }

  public ResizableFontButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ResizableFontButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private float a(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat)
  {
    paramTextPaint.setTextSize(a(paramFloat));
    return paramTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
  }

  private int a(float paramFloat)
  {
    return (int)(0.5F + paramFloat * this.b);
  }

  private void a()
  {
    super.setTextSize(1, this.d);
  }

  private float b(float paramFloat)
  {
    return paramFloat / this.b;
  }

  private int b(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat)
  {
    paramTextPaint.setTextSize(a(paramFloat));
    Rect localRect = new Rect();
    paramTextPaint.getTextBounds(paramCharSequence.toString(), 0, paramCharSequence.length(), localRect);
    return localRect.bottom;
  }

  private void b()
  {
    int i = getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight();
    int j = getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom();
    CharSequence localCharSequence = getText();
    if ((localCharSequence == null) || (localCharSequence.length() == 0) || (j <= 0) || (i <= 0));
    while (true)
    {
      return;
      TextPaint localTextPaint = new TextPaint(getPaint());
      float f1 = Math.max(this.d, this.e);
      float f2 = b(localCharSequence, localTextPaint, f1);
      while ((f2 > j) && (f1 > this.e))
      {
        f1 = Math.max(f1 - 1.0F, this.e);
        f2 = b(localCharSequence, localTextPaint, f1);
      }
      float f3 = a(localCharSequence, localTextPaint, f1);
      float f4 = f1;
      while ((f3 > i) && (f4 > this.e))
      {
        float f7 = Math.max(f4 - 1.0F, this.e);
        f3 = a(localCharSequence, localTextPaint, f7);
        f4 = f7;
      }
      if ((this.h) && (f4 <= this.e) && ((f3 > i) || (f2 > j)))
      {
        StaticLayout localStaticLayout = new StaticLayout(localCharSequence, localTextPaint, i, Layout.Alignment.ALIGN_NORMAL, this.f, this.g, false);
        localStaticLayout.draw(a);
        int k = -1 + localStaticLayout.getLineForVertical(j);
        int m = localStaticLayout.getLineStart(k);
        int n = localStaticLayout.getLineEnd(k);
        float f5 = localStaticLayout.getLineWidth(k);
        float f6 = localTextPaint.measureText("…");
        while (i < f5 + f6)
        {
          f5 = localTextPaint.measureText(localCharSequence.subSequence(m, n).toString());
          n--;
        }
        setText(localCharSequence.subSequence(0, n) + "…");
      }
      super.setTextSize(1, f4);
      setLineSpacing(this.g, this.f);
      this.c = false;
    }
  }

  private float getTextSizeInDip()
  {
    float f1 = b(getTextSize());
    if (f1 > 0.0F);
    while (true)
    {
      return f1;
      f1 = 14.0F;
    }
  }

  public float getMinTextSize()
  {
    return this.e;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.c)
      b();
    super.onDraw(paramCanvas);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
      this.c = true;
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = true;
    a();
  }

  public void setAddEllipsis(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    super.setLineSpacing(paramFloat1, paramFloat2);
    this.f = paramFloat2;
    this.g = paramFloat1;
  }

  public void setMinTextSize(float paramFloat)
  {
    this.e = paramFloat;
    this.c = true;
    requestLayout();
    invalidate();
  }

  public void setTextSize(float paramFloat)
  {
    super.setTextSize(paramFloat);
    this.d = getTextSizeInDip();
  }

  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    this.d = getTextSizeInDip();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.ResizableFontButton
 * JD-Core Version:    0.6.0
 */