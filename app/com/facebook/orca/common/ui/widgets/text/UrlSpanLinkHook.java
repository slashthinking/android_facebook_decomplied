package com.facebook.orca.common.ui.widgets.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.facebook.widget.BetterTextViewHook;

public class UrlSpanLinkHook
  implements BetterTextViewHook
{
  private final TextView a;
  private final Paint b;
  private URLSpan c;
  private Path d = new Path();

  public UrlSpanLinkHook(TextView paramTextView)
  {
    this(paramTextView, -3355444);
  }

  public UrlSpanLinkHook(TextView paramTextView, int paramInt)
  {
    this.a = paramTextView;
    this.b = new Paint();
    this.b.setColor(paramInt);
    this.b.setStyle(Paint.Style.FILL_AND_STROKE);
  }

  private Rect a()
  {
    Rect localRect = new Rect(0, 0, this.a.getWidth(), this.a.getHeight());
    localRect.left += this.a.getTotalPaddingLeft();
    localRect.top += this.a.getTotalPaddingTop();
    localRect.bottom -= this.a.getTotalPaddingBottom();
    localRect.right -= this.a.getTotalPaddingRight();
    return localRect;
  }

  private URLSpan b(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    URLSpan[] arrayOfURLSpan;
    if (a().contains(i, j))
    {
      int k = i - this.a.getTotalPaddingLeft();
      int m = j - this.a.getTotalPaddingTop();
      Layout localLayout = this.a.getLayout();
      int n = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(m), k);
      arrayOfURLSpan = (URLSpan[])((Spanned)this.a.getText()).getSpans(n, n, URLSpan.class);
      if (arrayOfURLSpan.length <= 0);
    }
    for (URLSpan localURLSpan = arrayOfURLSpan[0]; ; localURLSpan = null)
      return localURLSpan;
  }

  public void a(Canvas paramCanvas)
  {
    if (this.c == null);
    while (true)
    {
      return;
      paramCanvas.save();
      Rect localRect = a();
      paramCanvas.translate(localRect.left, localRect.top);
      Layout localLayout = this.a.getLayout();
      Spanned localSpanned = (Spanned)this.a.getText();
      localLayout.getSelectionPath(localSpanned.getSpanStart(this.c), localSpanned.getSpanEnd(this.c), this.d);
      paramCanvas.drawPath(this.d, this.b);
      paramCanvas.restore();
    }
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = this.a.getText() instanceof Spanned;
    int i = 0;
    if (!bool)
      return i;
    int j = paramMotionEvent.getAction();
    if (j == 0)
    {
      this.c = b(paramMotionEvent);
      this.a.invalidate();
    }
    while (true)
    {
      URLSpan localURLSpan1 = this.c;
      i = 0;
      if (localURLSpan1 == null)
        break;
      i = 1;
      break;
      if (j == 1)
      {
        if (this.c == null)
          continue;
        if (this.c == b(paramMotionEvent))
        {
          URLSpan localURLSpan2 = this.c;
          this.c = null;
          this.a.invalidate();
          localURLSpan2.onClick(this.a);
          continue;
        }
        this.c = null;
        this.a.invalidate();
        continue;
      }
      if ((j != 3) || (this.c == null))
        continue;
      this.c = null;
      this.a.invalidate();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.UrlSpanLinkHook
 * JD-Core Version:    0.6.0
 */