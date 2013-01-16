package com.facebook.feed.ui.footer;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class UFIStyle
{
  private UFIParams a;
  private UFIParams b;
  private UFIParams c;
  private UFIParams d;
  private UFIParams e;
  private UFIParams f;
  private UFIParams g;

  public UFIParams a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    UFIParams localUFIParams;
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3))
      localUFIParams = this.a;
    while (true)
    {
      return localUFIParams;
      if ((paramBoolean1) && (paramBoolean2))
      {
        localUFIParams = this.b;
        continue;
      }
      if ((paramBoolean2) && (paramBoolean3))
      {
        localUFIParams = this.c;
        continue;
      }
      if ((paramBoolean1) && (paramBoolean3))
      {
        localUFIParams = this.d;
        continue;
      }
      if (paramBoolean1)
      {
        localUFIParams = this.e;
        continue;
      }
      if (paramBoolean2)
      {
        localUFIParams = this.f;
        continue;
      }
      if (paramBoolean3)
      {
        localUFIParams = this.g;
        continue;
      }
      localUFIParams = this.a;
    }
  }

  public UFIStyle a(Resources paramResources)
  {
    int i = paramResources.getDimensionPixelSize(2131230804);
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramResources.getDimension(2131230805));
    localPaint.setTypeface(Typeface.DEFAULT_BOLD);
    int j = (int)Math.ceil(localPaint.measureText(paramResources.getString(2131362075)));
    int k = (int)Math.ceil(localPaint.measureText(paramResources.getString(2131362077)));
    int m = (int)Math.ceil(localPaint.measureText(paramResources.getString(2131362078)));
    int n = paramResources.getDrawable(2130839007).getIntrinsicWidth();
    this.a = new UFIParams(i, n, new int[] { j, k, m });
    this.b = new UFIParams(i, n, new int[] { j, k, 0 });
    this.c = new UFIParams(i, n, new int[] { 0, k, m });
    this.d = new UFIParams(i, n, new int[] { j, 0, m });
    this.e = new UFIParams(i, n, new int[] { j, 0, 0 });
    this.f = new UFIParams(i, n, new int[] { 0, k, 0 });
    this.g = new UFIParams(i, n, new int[] { 0, 0, m });
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.UFIStyle
 * JD-Core Version:    0.6.0
 */