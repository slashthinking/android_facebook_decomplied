package com.facebook.orca.contacts.picker;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserWithIdentifier;

class PickedUserSpan extends ReplacementSpan
{
  private final UserWithIdentifier a;
  private final int b;
  private final int c;
  private final Drawable d;

  public PickedUserSpan(UserWithIdentifier paramUserWithIdentifier, TextPaint paramTextPaint, Resources paramResources)
  {
    this.a = paramUserWithIdentifier;
    this.b = paramResources.getDimensionPixelOffset(2131230814);
    this.c = paramResources.getDimensionPixelOffset(2131230815);
    this.d = a(paramTextPaint, paramResources);
  }

  private Drawable a(TextPaint paramTextPaint, Resources paramResources)
  {
    Drawable localDrawable = paramResources.getDrawable(2130838991);
    String str = this.a.a().g();
    int i = (int)(paramTextPaint.measureText(str) + 2 * this.b);
    int j = (int)(i + paramTextPaint.measureText(" "));
    Paint.FontMetricsInt localFontMetricsInt = paramTextPaint.getFontMetricsInt();
    int k = localFontMetricsInt.bottom - localFontMetricsInt.top + 2 * this.c;
    Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(0);
    localDrawable.setBounds(0, 0, i, k);
    localDrawable.draw(localCanvas);
    float f = k - this.c - localFontMetricsInt.bottom;
    localCanvas.drawText(str, this.b, f, paramTextPaint);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramResources, localBitmap);
    localBitmapDrawable.setBounds(0, 0, j, k);
    return localBitmapDrawable;
  }

  public UserWithIdentifier a()
  {
    return this.a;
  }

  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt5 - this.d.getBounds().bottom);
    this.d.draw(paramCanvas);
    paramCanvas.restore();
  }

  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    TextPaint localTextPaint = (TextPaint)paramPaint;
    if (paramFontMetricsInt != null)
    {
      localTextPaint.getFontMetricsInt(paramFontMetricsInt);
      paramFontMetricsInt.top -= this.c;
      paramFontMetricsInt.bottom += this.c;
      paramFontMetricsInt.ascent = paramFontMetricsInt.top;
      paramFontMetricsInt.descent = paramFontMetricsInt.bottom;
    }
    return this.d.getBounds().width();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.PickedUserSpan
 * JD-Core Version:    0.6.0
 */