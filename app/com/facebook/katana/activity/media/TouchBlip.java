package com.facebook.katana.activity.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class TouchBlip
{
  private final Animation a;
  private final ImageView b;
  private final Matrix c;
  private final int d;
  private final int e;

  public TouchBlip(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    this.b = new ImageView(paramContext);
    Drawable localDrawable = paramContext.getResources().getDrawable(2130838965);
    this.b.setImageDrawable(localDrawable);
    this.b.setVisibility(8);
    this.b.setScaleType(ImageView.ScaleType.MATRIX);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    paramRelativeLayout.addView(this.b, localLayoutParams);
    this.d = localDrawable.getIntrinsicWidth();
    this.e = localDrawable.getIntrinsicHeight();
    this.c = new Matrix();
    this.a = AnimationUtils.loadAnimation(paramContext, 2130968584);
  }

  public void a()
  {
    if (this.b.getVisibility() != 0)
      this.b.setVisibility(0);
    this.a.reset();
    this.b.startAnimation(this.a);
  }

  public void a(PointF paramPointF, RectF paramRectF)
  {
    if (paramPointF == null);
    while (true)
    {
      return;
      if (this.b.getVisibility() != 0)
        a();
      float f1 = paramRectF.left + paramPointF.x * paramRectF.width();
      float f2 = paramRectF.top + paramPointF.y * paramRectF.height();
      this.c.reset();
      this.c.postTranslate(f1 - this.d / 2, f2 - this.e / 2);
      this.b.setImageMatrix(this.c);
    }
  }

  public void b()
  {
    this.b.setVisibility(4);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.TouchBlip
 * JD-Core Version:    0.6.0
 */