package com.facebook.photos.photogallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.widget.CustomFrameLayout;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

public class ExpandablePhoto extends CustomFrameLayout
{
  private View a;
  private RelativeLayout b;
  private ImageView c;
  private ExpandablePhoto.PhotoAnimatorListenerAdapter d;
  private boolean e;

  public ExpandablePhoto(Context paramContext)
  {
    this(paramContext, null);
  }

  public ExpandablePhoto(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903134);
    this.a = b(2131296656);
    this.b = ((RelativeLayout)b(2131296657));
    this.c = ((ImageView)b(2131296658));
    setVisibility(4);
  }

  private Rect a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.b.setLayerType(2, null);
      this.c.setLayerType(2, null);
      this.a.setLayerType(2, null);
    }
    this.c.setImageBitmap(paramBitmap);
    setVisibility(0);
    return new Rect(0, 0, getWidth(), getHeight());
  }

  private void a(boolean paramBoolean)
  {
    if (this.d != null)
      this.d.a(paramBoolean);
  }

  private void b(boolean paramBoolean)
  {
    if (this.d != null)
      this.d.b(paramBoolean);
  }

  private AnimatorSet getAnimatorSet()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.a(new ExpandablePhoto.1(this));
    return localAnimatorSet;
  }

  ExpandablePhoto.TransformData a(int paramInt1, int paramInt2, Rect paramRect1, Rect paramRect2)
  {
    ExpandablePhoto.TransformData localTransformData = new ExpandablePhoto.TransformData(this);
    float f1 = paramInt1 / paramInt2;
    float f2 = paramRect1.width() / paramRect1.height();
    float f3;
    float f4;
    if (f1 >= paramRect2.width() / paramRect2.height())
    {
      localTransformData.a = paramRect2.width();
      localTransformData.b = Math.round(paramRect2.width() / f1);
      localTransformData.e = 0.0F;
      localTransformData.f = ((paramRect2.height() - localTransformData.b) / 2.0F);
      localTransformData.c = 1.0F;
      localTransformData.d = 1.0F;
      localTransformData.g = 1.0F;
      localTransformData.h = 1.0F;
      localTransformData.i = 0.0F;
      localTransformData.j = 0.0F;
      localTransformData.k = (paramRect1.width() / localTransformData.a);
      localTransformData.l = (paramRect1.height() / localTransformData.b);
      localTransformData.m = (paramRect1.left - (localTransformData.a - localTransformData.a * localTransformData.k) / 2.0F);
      localTransformData.n = (paramRect1.top - (localTransformData.b - localTransformData.b * localTransformData.l) / 2.0F);
      if (f2 <= f1)
        break label356;
      f3 = paramRect1.width();
      f4 = paramRect1.width() / f1;
    }
    while (true)
    {
      localTransformData.o = (f3 / paramRect1.width());
      localTransformData.p = (f4 / paramRect1.height());
      localTransformData.q = 0.0F;
      localTransformData.r = 0.0F;
      return localTransformData;
      localTransformData.a = Math.round(f1 * paramRect2.height());
      localTransformData.b = paramRect2.height();
      localTransformData.e = ((paramRect2.width() - localTransformData.a) / 2.0F);
      localTransformData.f = 0.0F;
      break;
      label356: f3 = f1 * paramRect1.height();
      f4 = paramRect1.height();
    }
  }

  public void a()
  {
    setVisibility(4);
  }

  public void a(Bitmap paramBitmap, Rect paramRect)
  {
    this.e = true;
    Rect localRect = a(paramBitmap);
    ExpandablePhoto.TransformData localTransformData = a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramRect, localRect);
    this.b.setLayoutParams(new FrameLayout.LayoutParams(localTransformData.a, localTransformData.b));
    this.c.setLayoutParams(new RelativeLayout.LayoutParams(localTransformData.a, localTransformData.b));
    AnimatorSet localAnimatorSet = getAnimatorSet();
    Animator[] arrayOfAnimator = new Animator[9];
    RelativeLayout localRelativeLayout1 = this.b;
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = localTransformData.k;
    arrayOfFloat1[1] = localTransformData.c;
    arrayOfAnimator[0] = ObjectAnimator.a(localRelativeLayout1, "scaleX", arrayOfFloat1);
    RelativeLayout localRelativeLayout2 = this.b;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = localTransformData.l;
    arrayOfFloat2[1] = localTransformData.d;
    arrayOfAnimator[1] = ObjectAnimator.a(localRelativeLayout2, "scaleY", arrayOfFloat2);
    RelativeLayout localRelativeLayout3 = this.b;
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = localTransformData.m;
    arrayOfFloat3[1] = localTransformData.e;
    arrayOfAnimator[2] = ObjectAnimator.a(localRelativeLayout3, "translationX", arrayOfFloat3);
    RelativeLayout localRelativeLayout4 = this.b;
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = localTransformData.n;
    arrayOfFloat4[1] = localTransformData.f;
    arrayOfAnimator[3] = ObjectAnimator.a(localRelativeLayout4, "translationY", arrayOfFloat4);
    ImageView localImageView1 = this.c;
    float[] arrayOfFloat5 = new float[2];
    arrayOfFloat5[0] = localTransformData.o;
    arrayOfFloat5[1] = localTransformData.g;
    arrayOfAnimator[4] = ObjectAnimator.a(localImageView1, "scaleX", arrayOfFloat5);
    ImageView localImageView2 = this.c;
    float[] arrayOfFloat6 = new float[2];
    arrayOfFloat6[0] = localTransformData.p;
    arrayOfFloat6[1] = localTransformData.h;
    arrayOfAnimator[5] = ObjectAnimator.a(localImageView2, "scaleY", arrayOfFloat6);
    ImageView localImageView3 = this.c;
    float[] arrayOfFloat7 = new float[2];
    arrayOfFloat7[0] = localTransformData.q;
    arrayOfFloat7[1] = localTransformData.i;
    arrayOfAnimator[6] = ObjectAnimator.a(localImageView3, "translationX", arrayOfFloat7);
    ImageView localImageView4 = this.c;
    float[] arrayOfFloat8 = new float[2];
    arrayOfFloat8[0] = localTransformData.r;
    arrayOfFloat8[1] = localTransformData.j;
    arrayOfAnimator[7] = ObjectAnimator.a(localImageView4, "translationY", arrayOfFloat8);
    arrayOfAnimator[8] = ObjectAnimator.a(this.a, "alpha", new float[] { 0.0F, 1.0F });
    localAnimatorSet.a(arrayOfAnimator);
    localAnimatorSet.a(200L);
    localAnimatorSet.c();
  }

  public void a(ExpandablePhoto.PhotoAnimatorListenerAdapter paramPhotoAnimatorListenerAdapter)
  {
    this.d = paramPhotoAnimatorListenerAdapter;
  }

  public void b(Bitmap paramBitmap, Rect paramRect)
  {
    this.e = false;
    Rect localRect = a(paramBitmap);
    ExpandablePhoto.TransformData localTransformData = a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramRect, localRect);
    this.b.setLayoutParams(new FrameLayout.LayoutParams(localTransformData.a, localTransformData.b));
    this.c.setLayoutParams(new RelativeLayout.LayoutParams(localTransformData.a, localTransformData.b));
    AnimatorSet localAnimatorSet = getAnimatorSet();
    Animator[] arrayOfAnimator = new Animator[9];
    RelativeLayout localRelativeLayout1 = this.b;
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = localTransformData.c;
    arrayOfFloat1[1] = localTransformData.k;
    arrayOfAnimator[0] = ObjectAnimator.a(localRelativeLayout1, "scaleX", arrayOfFloat1);
    RelativeLayout localRelativeLayout2 = this.b;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = localTransformData.d;
    arrayOfFloat2[1] = localTransformData.l;
    arrayOfAnimator[1] = ObjectAnimator.a(localRelativeLayout2, "scaleY", arrayOfFloat2);
    RelativeLayout localRelativeLayout3 = this.b;
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = localTransformData.e;
    arrayOfFloat3[1] = localTransformData.m;
    arrayOfAnimator[2] = ObjectAnimator.a(localRelativeLayout3, "translationX", arrayOfFloat3);
    RelativeLayout localRelativeLayout4 = this.b;
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = localTransformData.f;
    arrayOfFloat4[1] = localTransformData.n;
    arrayOfAnimator[3] = ObjectAnimator.a(localRelativeLayout4, "translationY", arrayOfFloat4);
    ImageView localImageView1 = this.c;
    float[] arrayOfFloat5 = new float[2];
    arrayOfFloat5[0] = localTransformData.g;
    arrayOfFloat5[1] = localTransformData.o;
    arrayOfAnimator[4] = ObjectAnimator.a(localImageView1, "scaleX", arrayOfFloat5);
    ImageView localImageView2 = this.c;
    float[] arrayOfFloat6 = new float[2];
    arrayOfFloat6[0] = localTransformData.h;
    arrayOfFloat6[1] = localTransformData.p;
    arrayOfAnimator[5] = ObjectAnimator.a(localImageView2, "scaleY", arrayOfFloat6);
    ImageView localImageView3 = this.c;
    float[] arrayOfFloat7 = new float[2];
    arrayOfFloat7[0] = localTransformData.i;
    arrayOfFloat7[1] = localTransformData.q;
    arrayOfAnimator[6] = ObjectAnimator.a(localImageView3, "translationX", arrayOfFloat7);
    ImageView localImageView4 = this.c;
    float[] arrayOfFloat8 = new float[2];
    arrayOfFloat8[0] = localTransformData.j;
    arrayOfFloat8[1] = localTransformData.r;
    arrayOfAnimator[7] = ObjectAnimator.a(localImageView4, "translationY", arrayOfFloat8);
    arrayOfAnimator[8] = ObjectAnimator.a(this.a, "alpha", new float[] { 1.0F, 0.0F });
    localAnimatorSet.a(arrayOfAnimator);
    localAnimatorSet.a(200L);
    localAnimatorSet.c();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.ExpandablePhoto
 * JD-Core Version:    0.6.0
 */