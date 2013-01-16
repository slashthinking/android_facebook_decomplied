package com.facebook.orca.emoji;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

public class EmojiSpan extends ImageSpan
{
  private WeakReference<Drawable> a;

  public EmojiSpan(BitmapDrawable paramBitmapDrawable)
  {
    super(paramBitmapDrawable, 0);
  }

  private int a(Paint paramPaint, int paramInt)
  {
    TextPaint localTextPaint = (TextPaint)paramPaint;
    return (int)(0.5F + paramInt * localTextPaint.density);
  }

  private Drawable a()
  {
    WeakReference localWeakReference = this.a;
    Drawable localDrawable = null;
    if (localWeakReference != null)
      localDrawable = (Drawable)localWeakReference.get();
    if (localDrawable == null)
    {
      localDrawable = getDrawable();
      this.a = new WeakReference(localDrawable);
    }
    return localDrawable;
  }

  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    Drawable localDrawable = a();
    paramCanvas.save();
    int i = paramInt5 - localDrawable.getBounds().bottom - a(paramPaint, 2);
    paramCanvas.translate(paramFloat + a(paramPaint, 1), i);
    localDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }

  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    Rect localRect = a().getBounds();
    return a(paramPaint, 2) + localRect.right;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiSpan
 * JD-Core Version:    0.6.0
 */