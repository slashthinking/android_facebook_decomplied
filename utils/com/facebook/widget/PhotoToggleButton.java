package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.Checkable;
import com.facebook.R.styleable;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class PhotoToggleButton extends PhotoButton
  implements Checkable
{
  private int a;
  private int b;
  private PhotoToggleButton.OnCheckedChangeListener c;
  private ViewPropertyAnimator d;
  private AnimatorListenerAdapter e;
  private ObjectAnimator f;
  private boolean g;
  private boolean h;
  private boolean i;
  private ViewTransform j;

  public PhotoToggleButton(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public PhotoToggleButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.PhotoToggleButton);
    this.a = localTypedArray.getResourceId(0, 0);
    this.b = localTypedArray.getResourceId(1, 0);
    localTypedArray.recycle();
    this.j = new ViewTransform(this);
    setChecked(false);
    this.d = h();
    this.f = BounceAnimationCreator.a(this);
  }

  private void f()
  {
    this.d.a(this.e);
    this.d.a(120L);
    this.d.b(0.75F);
    this.d.c(0.75F);
  }

  private void g()
  {
    this.d.a(this.e);
    this.d.a(100L);
    this.d.b(1.0F);
    this.d.c(1.0F);
  }

  private ViewPropertyAnimator h()
  {
    ViewPropertyAnimator localViewPropertyAnimator = ViewPropertyAnimator.a(this);
    this.e = new PhotoToggleButton.1(this);
    return localViewPropertyAnimator;
  }

  private void i()
  {
    if (this.j.getScaleX() == 0.75F)
      if (!this.g)
        g();
    while (true)
    {
      return;
      if ((this.j.getScaleX() == 1.0F) && (this.i))
      {
        this.f.c();
        this.i = false;
      }
    }
  }

  private void j()
  {
    if (this.c != null)
      this.c.a(this, isChecked());
  }

  protected void c()
  {
    f();
    this.g = true;
  }

  protected void d()
  {
    if (this.j.getScaleX() == 0.75F)
      g();
    this.g = false;
  }

  protected void e()
  {
    toggle();
    j();
  }

  public boolean isChecked()
  {
    return this.h;
  }

  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    this.d.a();
    this.f.d();
    this.j.setScaleX(1.0F);
    this.j.setScaleY(1.0F);
    if (Build.VERSION.SDK_INT >= 16)
      setHasTransientState(false);
  }

  public void setChecked(boolean paramBoolean)
  {
    if (paramBoolean)
      setImageResource(this.b);
    while (true)
    {
      this.h = paramBoolean;
      this.i = paramBoolean;
      return;
      setImageResource(this.a);
    }
  }

  public void setOnCheckedChangeListener(PhotoToggleButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.c = paramOnCheckedChangeListener;
  }

  public void toggle()
  {
    if (!this.h);
    for (boolean bool = true; ; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.PhotoToggleButton
 * JD-Core Version:    0.6.2
 */