package com.nineoldandroids.view.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy extends Animation
{
  public static final boolean a;
  private static final WeakHashMap<View, AnimatorProxy> b;
  private final WeakReference<View> c;
  private final Camera d = new Camera();
  private boolean e;
  private float f = 1.0F;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l = 1.0F;
  private float m = 1.0F;
  private float n;
  private float o;
  private final RectF p = new RectF();
  private final RectF q = new RectF();
  private final Matrix r = new Matrix();

  static
  {
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11);
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      b = new WeakHashMap();
      return;
    }
  }

  private AnimatorProxy(View paramView)
  {
    setDuration(0L);
    setFillAfter(true);
    if (paramView.getVisibility() == 0)
      paramView.setAnimation(this);
    this.c = new WeakReference(paramView);
  }

  public static AnimatorProxy a(View paramView)
  {
    AnimatorProxy localAnimatorProxy = (AnimatorProxy)b.get(paramView);
    if ((localAnimatorProxy == null) || (localAnimatorProxy != paramView.getAnimation()))
    {
      localAnimatorProxy = new AnimatorProxy(paramView);
      b.put(paramView, localAnimatorProxy);
    }
    return localAnimatorProxy;
  }

  private void a()
  {
    View localView = (View)this.c.get();
    if (localView != null)
      a(this.p, localView);
  }

  private void a(Matrix paramMatrix, View paramView)
  {
    float f1 = paramView.getWidth();
    float f2 = paramView.getHeight();
    boolean bool = this.e;
    float f3;
    if (bool)
    {
      f3 = this.g;
      if (!bool)
        break label233;
    }
    label233: for (float f4 = this.h; ; f4 = f2 / 2.0F)
    {
      float f5 = this.i;
      float f6 = this.j;
      float f7 = this.k;
      if ((f5 != 0.0F) || (f6 != 0.0F) || (f7 != 0.0F))
      {
        Camera localCamera = this.d;
        localCamera.save();
        localCamera.rotateX(f5);
        localCamera.rotateY(f6);
        localCamera.rotateZ(-f7);
        localCamera.getMatrix(paramMatrix);
        localCamera.restore();
        paramMatrix.preTranslate(-f3, -f4);
        paramMatrix.postTranslate(f3, f4);
      }
      float f8 = this.l;
      float f9 = this.m;
      if ((f8 != 1.0F) || (f9 != 1.0F))
      {
        paramMatrix.postScale(f8, f9);
        paramMatrix.postTranslate(-(f3 / f1) * (f8 * f1 - f1), -(f4 / f2) * (f9 * f2 - f2));
      }
      paramMatrix.postTranslate(this.n, this.o);
      return;
      f3 = f1 / 2.0F;
      break;
    }
  }

  private void a(RectF paramRectF, View paramView)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = this.r;
    localMatrix.reset();
    a(localMatrix, paramView);
    this.r.mapRect(paramRectF);
    paramRectF.offset(paramView.getLeft(), paramView.getTop());
    if (paramRectF.right < paramRectF.left)
    {
      float f2 = paramRectF.right;
      paramRectF.right = paramRectF.left;
      paramRectF.left = f2;
    }
    if (paramRectF.bottom < paramRectF.top)
    {
      float f1 = paramRectF.top;
      paramRectF.top = paramRectF.bottom;
      paramRectF.bottom = f1;
    }
  }

  private void b()
  {
    View localView = (View)this.c.get();
    if ((localView == null) || (localView.getParent() == null));
    while (true)
    {
      return;
      RectF localRectF = this.q;
      a(localRectF, localView);
      localRectF.union(this.p);
      ((View)localView.getParent()).invalidate((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
    }
  }

  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    View localView = (View)this.c.get();
    if (localView != null)
    {
      paramTransformation.setAlpha(this.f);
      a(paramTransformation.getMatrix(), localView);
    }
  }

  public float getAlpha()
  {
    return this.f;
  }

  public float getPivotX()
  {
    return this.g;
  }

  public float getPivotY()
  {
    return this.h;
  }

  public float getRotation()
  {
    return this.k;
  }

  public float getRotationX()
  {
    return this.i;
  }

  public float getRotationY()
  {
    return this.j;
  }

  public float getScaleX()
  {
    return this.l;
  }

  public float getScaleY()
  {
    return this.m;
  }

  public int getScrollX()
  {
    View localView = (View)this.c.get();
    if (localView == null);
    for (int i1 = 0; ; i1 = localView.getScrollX())
      return i1;
  }

  public int getScrollY()
  {
    View localView = (View)this.c.get();
    if (localView == null);
    for (int i1 = 0; ; i1 = localView.getScrollY())
      return i1;
  }

  public float getTranslationX()
  {
    return this.n;
  }

  public float getTranslationY()
  {
    return this.o;
  }

  public float getX()
  {
    View localView = (View)this.c.get();
    if (localView == null);
    for (float f1 = 0.0F; ; f1 = localView.getLeft() + this.n)
      return f1;
  }

  public float getY()
  {
    View localView = (View)this.c.get();
    if (localView == null);
    for (float f1 = 0.0F; ; f1 = localView.getTop() + this.o)
      return f1;
  }

  public void setAlpha(float paramFloat)
  {
    if (this.f != paramFloat)
    {
      this.f = paramFloat;
      View localView = (View)this.c.get();
      if (localView != null)
        localView.invalidate();
    }
  }

  public void setPivotX(float paramFloat)
  {
    if ((!this.e) || (this.g != paramFloat))
    {
      a();
      this.e = true;
      this.g = paramFloat;
      b();
    }
  }

  public void setPivotY(float paramFloat)
  {
    if ((!this.e) || (this.h != paramFloat))
    {
      a();
      this.e = true;
      this.h = paramFloat;
      b();
    }
  }

  public void setRotation(float paramFloat)
  {
    if (this.k != paramFloat)
    {
      a();
      this.k = paramFloat;
      b();
    }
  }

  public void setRotationX(float paramFloat)
  {
    if (this.i != paramFloat)
    {
      a();
      this.i = paramFloat;
      b();
    }
  }

  public void setRotationY(float paramFloat)
  {
    if (this.j != paramFloat)
    {
      a();
      this.j = paramFloat;
      b();
    }
  }

  public void setScaleX(float paramFloat)
  {
    if (this.l != paramFloat)
    {
      a();
      this.l = paramFloat;
      b();
    }
  }

  public void setScaleY(float paramFloat)
  {
    if (this.m != paramFloat)
    {
      a();
      this.m = paramFloat;
      b();
    }
  }

  public void setScrollX(int paramInt)
  {
    View localView = (View)this.c.get();
    if (localView != null)
      localView.scrollTo(paramInt, localView.getScrollY());
  }

  public void setScrollY(int paramInt)
  {
    View localView = (View)this.c.get();
    if (localView != null)
      localView.scrollTo(localView.getScrollX(), paramInt);
  }

  public void setTranslationX(float paramFloat)
  {
    if (this.n != paramFloat)
    {
      a();
      this.n = paramFloat;
      b();
    }
  }

  public void setTranslationY(float paramFloat)
  {
    if (this.o != paramFloat)
    {
      a();
      this.o = paramFloat;
      b();
    }
  }

  public void setVisibility(int paramInt)
  {
    View localView = (View)this.c.get();
    if (localView != null)
    {
      if (paramInt != 0)
        break label30;
      localView.setAnimation(this);
    }
    while (true)
    {
      localView.setVisibility(paramInt);
      return;
      label30: localView.clearAnimation();
    }
  }

  public void setX(float paramFloat)
  {
    View localView = (View)this.c.get();
    if (localView != null)
      setTranslationX(paramFloat - localView.getLeft());
  }

  public void setY(float paramFloat)
  {
    View localView = (View)this.c.get();
    if (localView != null)
      setTranslationY(paramFloat - localView.getTop());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.animation.AnimatorProxy
 * JD-Core Version:    0.6.2
 */