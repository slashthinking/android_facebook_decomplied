package com.facebook.photos.photogallery.util;

import android.view.View;
import com.facebook.widget.ViewTransform;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class VisibilityAnimator
{
  private View a;
  private boolean b;
  private ViewTransform c;
  private ViewPropertyAnimator d;

  public VisibilityAnimator(View paramView, long paramLong, boolean paramBoolean)
  {
    this.a = paramView;
    this.b = paramBoolean;
    this.c = new ViewTransform(paramView);
    this.d = ViewPropertyAnimator.a(paramView);
    this.d.a(paramLong);
    this.d.a(new VisibilityAnimator.1(this));
  }

  private void f()
  {
    if (this.b)
      this.a.setVisibility(4);
    while (true)
    {
      return;
      this.a.setVisibility(8);
    }
  }

  public boolean a()
  {
    if (this.c.getAlpha() == 1.0F);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void b()
  {
    this.a.setVisibility(0);
    this.d.d(1.0F);
  }

  public void c()
  {
    this.a.setVisibility(0);
    this.c.setAlpha(1.0F);
  }

  public void d()
  {
    this.d.d(0.0F);
  }

  public void e()
  {
    this.c.setAlpha(0.0F);
    f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.util.VisibilityAnimator
 * JD-Core Version:    0.6.0
 */