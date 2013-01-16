package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class CountBadge extends CustomFrameLayout
{
  private ViewPropertyAnimator a;
  private ObjectAnimator b;
  private TextView c;
  private AnimatorListenerAdapter d;
  private int e;
  private ViewTransform f;

  public CountBadge(Context paramContext)
  {
    this(paramContext, null);
  }

  public CountBadge(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903124);
    setBackgroundResource(2130838842);
    this.c = ((TextView)b(2131296617));
    this.f = new ViewTransform(this);
    setCount(0);
    this.a = ViewPropertyAnimator.a(this);
    this.a.a(150L);
    this.d = new CountBadge.1(this);
    this.b = BounceAnimationCreator.a(this);
  }

  private void c()
  {
    this.f.setScaleX(1.0F);
    this.f.setScaleY(1.0F);
  }

  private void d()
  {
    this.a.a(this.d);
    this.a.b(1.0F);
    this.a.c(1.0F);
  }

  private void e()
  {
    this.f.setScaleX(0.0F);
    this.f.setScaleY(0.0F);
  }

  private void f()
  {
    this.a.a(this.d);
    this.a.b(0.0F);
    this.a.c(0.0F);
  }

  private void i()
  {
    if (this.f.getScaleX() == 1.0F)
      this.b.c();
  }

  public void a()
  {
    if (this.e == 0)
    {
      this.e = 1;
      d();
    }
    while (true)
    {
      return;
      if (this.e > 0)
      {
        setCount(1 + this.e);
        this.b.c();
      }
    }
  }

  public void b()
  {
    if (this.e == 1)
    {
      this.e = 0;
      f();
    }
    while (true)
    {
      return;
      if (this.e > 1)
      {
        setCount(-1 + this.e);
        this.b.c();
      }
    }
  }

  public int getCount()
  {
    return this.e;
  }

  public void setCount(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.e = 0;
      this.c.setText("1");
      e();
    }
    while (true)
    {
      return;
      this.e = paramInt;
      this.c.setText(Integer.toString(this.e));
      c();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CountBadge
 * JD-Core Version:    0.6.2
 */