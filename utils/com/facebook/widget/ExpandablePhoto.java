package com.facebook.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.orca.common.util.SizeUtil;
import com.google.common.collect.Lists;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ExpandablePhoto extends RelativeLayout
{
  private View a;
  private RelativeLayout b;
  private ImageView c;
  private ExpandablePhoto.OnPhotoAnimationStartListener d;
  private ExpandablePhoto.OnPhotoAnimationEndListener e;
  private boolean f;
  private Collection<Animator> g;
  private int h;
  private int i;
  private DisplayMetrics j;
  private Rect k;
  private Bitmap l;
  private Context m;
  private int n = 200;
  private int o;

  public ExpandablePhoto(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public ExpandablePhoto(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public ExpandablePhoto(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
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
    setVisibility(8);
    setVisibility(0);
    this.k.left = 0;
    this.k.top = 0;
    this.k.right = this.h;
    this.k.bottom = this.i;
    return this.k;
  }

  private ExpandablePhoto.TransformData a(int paramInt1, int paramInt2, Rect paramRect1, Rect paramRect2)
  {
    ExpandablePhoto.TransformData localTransformData = new ExpandablePhoto.TransformData(null);
    float f1 = paramInt1 / paramInt2;
    float f2 = paramRect1.width() / paramRect1.height();
    float f3;
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
    }
    for (float f4 = paramRect1.width() / f1; ; f4 = paramRect1.height())
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
    }
  }

  private void a()
  {
    setVisibility(4);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.b.setLayerType(0, null);
      this.c.setLayerType(0, null);
      this.a.setLayerType(0, null);
    }
    a(this.f);
    this.g.clear();
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    View.inflate(paramContext, 2130903134, this);
    this.m = paramContext;
    this.a = findViewById(2131296656);
    this.b = ((RelativeLayout)findViewById(2131296657));
    this.c = ((ImageView)findViewById(2131296658));
    this.g = Lists.a();
    this.o = SizeUtil.a(paramContext);
    this.j = this.m.getResources().getDisplayMetrics();
    this.h = this.j.widthPixels;
    this.i = (this.j.heightPixels - this.o);
    this.k = new Rect();
    int[] arrayOfInt = new int[1];
    Arrays.fill(arrayOfInt, getContext().getResources().getColor(2131165254));
    this.l = Bitmap.createBitmap(arrayOfInt, 1, 1, Bitmap.Config.ARGB_8888);
  }

  private void a(AnimatorSet paramAnimatorSet, boolean paramBoolean)
  {
    if (this.d != null)
      this.d.a(paramAnimatorSet, paramBoolean);
  }

  private void a(boolean paramBoolean)
  {
    if (this.e != null)
      this.e.a(paramBoolean);
  }

  private AnimatorSet getAnimatorSet()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.a(new ExpandablePhoto.1(this));
    return localAnimatorSet;
  }

  public void a(Bitmap paramBitmap, Rect paramRect)
  {
    this.f = true;
    Rect localRect = a(paramBitmap);
    ExpandablePhoto.TransformData localTransformData = a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramRect, localRect);
    this.b.getLayoutParams().width = localTransformData.a;
    this.b.getLayoutParams().height = localTransformData.b;
    this.c.getLayoutParams().width = localTransformData.a;
    this.c.getLayoutParams().height = localTransformData.b;
    Collection localCollection1 = this.g;
    RelativeLayout localRelativeLayout1 = this.b;
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = localTransformData.k;
    arrayOfFloat1[1] = localTransformData.c;
    localCollection1.add(ObjectAnimator.a(localRelativeLayout1, "scaleX", arrayOfFloat1));
    Collection localCollection2 = this.g;
    RelativeLayout localRelativeLayout2 = this.b;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = localTransformData.l;
    arrayOfFloat2[1] = localTransformData.d;
    localCollection2.add(ObjectAnimator.a(localRelativeLayout2, "scaleY", arrayOfFloat2));
    Collection localCollection3 = this.g;
    RelativeLayout localRelativeLayout3 = this.b;
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = localTransformData.m;
    arrayOfFloat3[1] = localTransformData.e;
    localCollection3.add(ObjectAnimator.a(localRelativeLayout3, "translationX", arrayOfFloat3));
    Collection localCollection4 = this.g;
    RelativeLayout localRelativeLayout4 = this.b;
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = localTransformData.n;
    arrayOfFloat4[1] = localTransformData.f;
    localCollection4.add(ObjectAnimator.a(localRelativeLayout4, "translationY", arrayOfFloat4));
    Collection localCollection5 = this.g;
    ImageView localImageView1 = this.c;
    float[] arrayOfFloat5 = new float[2];
    arrayOfFloat5[0] = localTransformData.o;
    arrayOfFloat5[1] = localTransformData.g;
    localCollection5.add(ObjectAnimator.a(localImageView1, "scaleX", arrayOfFloat5));
    Collection localCollection6 = this.g;
    ImageView localImageView2 = this.c;
    float[] arrayOfFloat6 = new float[2];
    arrayOfFloat6[0] = localTransformData.p;
    arrayOfFloat6[1] = localTransformData.h;
    localCollection6.add(ObjectAnimator.a(localImageView2, "scaleY", arrayOfFloat6));
    Collection localCollection7 = this.g;
    ImageView localImageView3 = this.c;
    float[] arrayOfFloat7 = new float[2];
    arrayOfFloat7[0] = localTransformData.q;
    arrayOfFloat7[1] = localTransformData.i;
    localCollection7.add(ObjectAnimator.a(localImageView3, "translationX", arrayOfFloat7));
    Collection localCollection8 = this.g;
    ImageView localImageView4 = this.c;
    float[] arrayOfFloat8 = new float[2];
    arrayOfFloat8[0] = localTransformData.r;
    arrayOfFloat8[1] = localTransformData.j;
    localCollection8.add(ObjectAnimator.a(localImageView4, "translationY", arrayOfFloat8));
    this.g.add(ObjectAnimator.a(this.a, "alpha", new float[] { 0.0F, 1.0F }));
    AnimatorSet localAnimatorSet = getAnimatorSet();
    localAnimatorSet.a(this.g);
    localAnimatorSet.a(this.n);
    a(localAnimatorSet, this.f);
    localAnimatorSet.c();
  }

  public void a(List<ObjectAnimator> paramList)
  {
    this.g.addAll(paramList);
  }

  public void b(Bitmap paramBitmap, Rect paramRect)
  {
    this.f = false;
    Rect localRect = a(paramBitmap);
    ExpandablePhoto.TransformData localTransformData = a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramRect, localRect);
    this.b.getLayoutParams().width = localTransformData.a;
    this.b.getLayoutParams().height = localTransformData.b;
    this.c.getLayoutParams().width = localTransformData.a;
    this.c.getLayoutParams().height = localTransformData.b;
    Collection localCollection1 = this.g;
    RelativeLayout localRelativeLayout1 = this.b;
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = localTransformData.c;
    arrayOfFloat1[1] = localTransformData.k;
    localCollection1.add(ObjectAnimator.a(localRelativeLayout1, "scaleX", arrayOfFloat1));
    Collection localCollection2 = this.g;
    RelativeLayout localRelativeLayout2 = this.b;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = localTransformData.d;
    arrayOfFloat2[1] = localTransformData.l;
    localCollection2.add(ObjectAnimator.a(localRelativeLayout2, "scaleY", arrayOfFloat2));
    Collection localCollection3 = this.g;
    RelativeLayout localRelativeLayout3 = this.b;
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = localTransformData.e;
    arrayOfFloat3[1] = localTransformData.m;
    localCollection3.add(ObjectAnimator.a(localRelativeLayout3, "translationX", arrayOfFloat3));
    Collection localCollection4 = this.g;
    RelativeLayout localRelativeLayout4 = this.b;
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = localTransformData.f;
    arrayOfFloat4[1] = localTransformData.n;
    localCollection4.add(ObjectAnimator.a(localRelativeLayout4, "translationY", arrayOfFloat4));
    Collection localCollection5 = this.g;
    ImageView localImageView1 = this.c;
    float[] arrayOfFloat5 = new float[2];
    arrayOfFloat5[0] = localTransformData.g;
    arrayOfFloat5[1] = localTransformData.o;
    localCollection5.add(ObjectAnimator.a(localImageView1, "scaleX", arrayOfFloat5));
    Collection localCollection6 = this.g;
    ImageView localImageView2 = this.c;
    float[] arrayOfFloat6 = new float[2];
    arrayOfFloat6[0] = localTransformData.h;
    arrayOfFloat6[1] = localTransformData.p;
    localCollection6.add(ObjectAnimator.a(localImageView2, "scaleY", arrayOfFloat6));
    Collection localCollection7 = this.g;
    ImageView localImageView3 = this.c;
    float[] arrayOfFloat7 = new float[2];
    arrayOfFloat7[0] = localTransformData.i;
    arrayOfFloat7[1] = localTransformData.q;
    localCollection7.add(ObjectAnimator.a(localImageView3, "translationX", arrayOfFloat7));
    Collection localCollection8 = this.g;
    ImageView localImageView4 = this.c;
    float[] arrayOfFloat8 = new float[2];
    arrayOfFloat8[0] = localTransformData.j;
    arrayOfFloat8[1] = localTransformData.r;
    localCollection8.add(ObjectAnimator.a(localImageView4, "translationY", arrayOfFloat8));
    this.g.add(ObjectAnimator.a(this.a, "alpha", new float[] { 1.0F, 0.0F }));
    AnimatorSet localAnimatorSet = getAnimatorSet();
    localAnimatorSet.a(this.g);
    localAnimatorSet.a(this.n);
    a(localAnimatorSet, this.f);
    localAnimatorSet.c();
  }

  public Bitmap getPlaceholderBitmap()
  {
    return this.l;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(new ExpandablePhoto.2(this));
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setVisibility(8);
  }

  public void setAnimationDurationMs(int paramInt)
  {
    this.n = paramInt;
  }

  public void setBitmap(Bitmap paramBitmap)
  {
    this.c.setImageBitmap(paramBitmap);
  }

  public void setOnPhotoAnimationEndListener(ExpandablePhoto.OnPhotoAnimationEndListener paramOnPhotoAnimationEndListener)
  {
    this.e = paramOnPhotoAnimationEndListener;
  }

  public void setOnPhotoAnimationStartListener(ExpandablePhoto.OnPhotoAnimationStartListener paramOnPhotoAnimationStartListener)
  {
    this.d = paramOnPhotoAnimationStartListener;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ExpandablePhoto
 * JD-Core Version:    0.6.2
 */