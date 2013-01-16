package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.facebook.R.styleable;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.app.UserInteractionListener;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.images.FetchImageCoordinator;
import com.facebook.orca.images.FetchImageExecutor;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.images.ImageCacheKey;
import com.facebook.orca.images.ImageViewTouchBase;
import com.facebook.orca.images.MultiFetchImageParams;
import com.facebook.orca.images.UrlImageCompositor;
import com.facebook.orca.images.UrlImageProcessor;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.listview.recycle.RecyclableView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;

public class UrlImage extends CustomViewGroup
  implements RecyclableView
{
  public static final FetchImageParams a;
  private static Class<?> b = UrlImage.class;
  private static final ImageView.ScaleType[] c;
  private static final UrlImage.LoadResolutionDuringScrollMode[] d = arrayOfLoadResolutionDuringScrollMode;
  private boolean A;
  private boolean B = false;
  private boolean C = false;
  private Bitmap D;
  private final FetchImageExecutor e;
  private final FetchImageCoordinator f;
  private LayoutInflater g;
  private final UserInteractionListener h;
  private final ImageCache i;
  private ImageView j;
  private ProgressBar k;
  private Animation l;
  private final UrlImage.ImageSpec m = new UrlImage.ImageSpec(null);
  private final UrlImage.ImageSpec n = new UrlImage.ImageSpec(null);
  private UrlImage.CurrentMode o;
  private boolean p;
  private ListenableFuture<List<Bitmap>> q;
  private UrlImage.OnImageDownloadListener r;
  private boolean s;
  private UrlImage.LoadResolutionDuringScrollMode t = UrlImage.LoadResolutionDuringScrollMode.NONE;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;

  static
  {
    a = null;
    ImageView.ScaleType[] arrayOfScaleType = new ImageView.ScaleType[8];
    arrayOfScaleType[0] = ImageView.ScaleType.MATRIX;
    arrayOfScaleType[1] = ImageView.ScaleType.FIT_XY;
    arrayOfScaleType[2] = ImageView.ScaleType.FIT_START;
    arrayOfScaleType[3] = ImageView.ScaleType.FIT_CENTER;
    arrayOfScaleType[4] = ImageView.ScaleType.FIT_END;
    arrayOfScaleType[5] = ImageView.ScaleType.CENTER;
    arrayOfScaleType[6] = ImageView.ScaleType.CENTER_CROP;
    arrayOfScaleType[7] = ImageView.ScaleType.CENTER_INSIDE;
    c = arrayOfScaleType;
    UrlImage.LoadResolutionDuringScrollMode[] arrayOfLoadResolutionDuringScrollMode = new UrlImage.LoadResolutionDuringScrollMode[3];
    arrayOfLoadResolutionDuringScrollMode[0] = UrlImage.LoadResolutionDuringScrollMode.NONE;
    arrayOfLoadResolutionDuringScrollMode[1] = UrlImage.LoadResolutionDuringScrollMode.LOW_RES;
    arrayOfLoadResolutionDuringScrollMode[2] = UrlImage.LoadResolutionDuringScrollMode.FULL_RES;
  }

  public UrlImage(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public UrlImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public UrlImage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    FbInjector localFbInjector = getInjector();
    this.g = ((LayoutInflater)localFbInjector.a(LayoutInflater.class));
    this.e = ((FetchImageExecutor)localFbInjector.a(FetchImageExecutor.class));
    this.i = ((ImageCache)localFbInjector.a(ImageCache.class));
    this.f = ((FetchImageCoordinator)localFbInjector.a(FetchImageCoordinator.class));
    this.m.g = ImageView.ScaleType.CENTER_INSIDE;
    this.n.g = ImageView.ScaleType.FIT_CENTER;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.UrlImage);
    int i1 = localTypedArray.getInt(9, -1);
    if (i1 >= 0)
      this.t = d[i1];
    this.y = localTypedArray.getBoolean(6, false);
    this.z = localTypedArray.getBoolean(7, false);
    this.l = AnimationUtils.loadAnimation(paramContext, 2130968587);
    this.v = localTypedArray.getBoolean(3, false);
    this.w = localTypedArray.getBoolean(4, false);
    if (this.v)
      this.g.inflate(2130903432, this);
    while (true)
    {
      this.j = ((ImageView)getView(2131297526));
      this.k = ((ProgressBar)getView(2131297527));
      String str = localTypedArray.getString(0);
      if (!StringUtil.a(str))
        this.n.a = new FetchImageParams(Uri.parse(str));
      int i2 = localTypedArray.getInt(11, -1);
      if (i2 >= 0)
        this.n.g = c[i2];
      this.n.i = localTypedArray.getBoolean(8, false);
      int i3 = localTypedArray.getInt(10, -1);
      if (i3 >= 0)
        this.m.g = c[i3];
      this.p = localTypedArray.getBoolean(2, false);
      this.m.d = Integer.valueOf(localTypedArray.getResourceId(1, 2130838707));
      this.o = UrlImage.CurrentMode.PLACEHOLDER;
      this.j.setImageResource(this.m.d.intValue());
      this.j.setScaleType(this.m.g);
      this.x = localTypedArray.getBoolean(5, false);
      localTypedArray.recycle();
      UserInteractionController localUserInteractionController = (UserInteractionController)localFbInjector.a(UserInteractionController.class);
      this.h = new UrlImage.1(this);
      localUserInteractionController.a(this.h);
      return;
      if (this.w)
        this.g.inflate(2130903434, this);
      else
        this.g.inflate(2130903431, this);
    }
  }

  private void a(Drawable paramDrawable)
  {
    if ((paramDrawable != null) && ((this.j instanceof ImageViewTouchBase)))
      ((ImageViewTouchBase)this.j).setDrawable(paramDrawable);
    while (true)
    {
      return;
      this.j.setImageDrawable(paramDrawable);
    }
  }

  private void a(UrlImage.ImageSpec paramImageSpec)
  {
    this.j.setScaleType(paramImageSpec.g);
    this.j.setImageMatrix(paramImageSpec.h);
    this.j.setAdjustViewBounds(paramImageSpec.i);
    if ((paramImageSpec.f != null) && (paramImageSpec.f.intValue() != -1))
    {
      this.j.setBackgroundResource(paramImageSpec.f.intValue());
      if (paramImageSpec.c == null)
        break label92;
      a(paramImageSpec.c);
    }
    while (true)
    {
      return;
      this.j.setBackgroundDrawable(null);
      break;
      label92: if (paramImageSpec.e != null)
        a(paramImageSpec.e);
      else if ((paramImageSpec.d != null) && (paramImageSpec.d.intValue() != -1))
        this.j.setImageResource(paramImageSpec.d.intValue());
      else
        a(null);
    }
  }

  private void a(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CancellationException));
    while (true)
    {
      return;
      this.q = null;
      setMode(UrlImage.CurrentMode.PLACEHOLDER);
    }
  }

  private void a(List<FetchImageParams> paramList)
  {
    ArrayList localArrayList = Lists.c(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FetchImageParams localFetchImageParams = (FetchImageParams)localIterator.next();
      localArrayList.add(this.e.b(localFetchImageParams));
    }
    this.q = Futures.a(localArrayList);
    ListenableFuture localListenableFuture = this.q;
    Futures.a(this.q, new UrlImage.2(this, localListenableFuture), this.f);
  }

  private void b(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ShapeDrawable localShapeDrawable = new ShapeDrawable();
      localShapeDrawable.setIntrinsicHeight(paramDrawable.getIntrinsicHeight());
      localShapeDrawable.setIntrinsicWidth(paramDrawable.getIntrinsicWidth());
      a(localShapeDrawable);
    }
    while (true)
    {
      return;
      a(null);
    }
  }

  private void b(List<Bitmap> paramList)
  {
    this.q = null;
    Bitmap localBitmap = (Bitmap)paramList.get(0);
    Object localObject;
    if ((this.n.a != null) && (localBitmap != null) && (localBitmap.getWidth() > 0))
      localObject = new BitmapDrawable(getResources(), localBitmap);
    while (true)
    {
      if (f())
        b((Drawable)localObject);
      while (true)
      {
        return;
        if (this.n.b == null)
          break label143;
        localObject = this.n.b.b().a(paramList);
        break;
        this.n.c = ((Drawable)localObject);
        if (localObject != null)
        {
          setMode(UrlImage.CurrentMode.LOADED_IMAGE);
          if (this.y)
            d();
          if (this.r != null)
            this.r.a((Drawable)localObject);
        }
      }
      label143: localObject = null;
    }
  }

  private void c()
  {
    this.u = false;
    this.C = false;
    if (this.q != null)
    {
      this.q.cancel(false);
      this.q = null;
    }
    this.m.c = null;
    if (this.m.a != null)
    {
      ImageCacheKey localImageCacheKey2 = this.m.a.d();
      if (localImageCacheKey2 != null)
      {
        Bitmap localBitmap2 = (Bitmap)this.i.b(localImageCacheKey2);
        if (localBitmap2 != null)
          this.m.c = new BitmapDrawable(getResources(), localBitmap2);
      }
    }
    List localList = getImagesToDownload();
    this.D = null;
    ArrayList localArrayList2;
    if (localList != null)
    {
      localArrayList2 = Lists.a();
      Iterator localIterator2 = localList.iterator();
      while (true)
      {
        if (!localIterator2.hasNext())
          break label414;
        ImageCacheKey localImageCacheKey1 = ((FetchImageParams)localIterator2.next()).d();
        if (localImageCacheKey1 != null)
        {
          Bitmap localBitmap1 = (Bitmap)this.i.b(localImageCacheKey1);
          if (localBitmap1 == null)
            break;
          localArrayList2.add(localBitmap1);
          if (this.y)
            d();
        }
      }
    }
    label397: label414: for (int i1 = 0; ; i1 = 1)
    {
      if (i1 != 0)
      {
        this.C = true;
        b(localArrayList2);
      }
      while (true)
      {
        return;
        this.n.c = null;
        if (localList != null)
        {
          if (((this.s) || (!this.A)) && (this.t != UrlImage.LoadResolutionDuringScrollMode.FULL_RES))
          {
            if (this.p);
            ArrayList localArrayList1;
            for (UrlImage.CurrentMode localCurrentMode2 = UrlImage.CurrentMode.PROGRESS_BAR; ; localCurrentMode2 = UrlImage.CurrentMode.PLACEHOLDER)
            {
              setMode(localCurrentMode2);
              this.u = true;
              if (this.t == UrlImage.LoadResolutionDuringScrollMode.NONE)
                break;
              localArrayList1 = new ArrayList();
              Iterator localIterator1 = localList.iterator();
              while (localIterator1.hasNext())
                localArrayList1.add(((FetchImageParams)localIterator1.next()).f());
            }
            a(localArrayList1);
          }
          else
          {
            if (!this.u)
              if (!this.p)
                break label397;
            for (UrlImage.CurrentMode localCurrentMode1 = UrlImage.CurrentMode.PROGRESS_BAR; ; localCurrentMode1 = UrlImage.CurrentMode.PLACEHOLDER)
            {
              setMode(localCurrentMode1);
              this.u = false;
              a(localList);
              break;
            }
          }
        }
        else
          setMode(UrlImage.CurrentMode.PLACEHOLDER);
      }
    }
  }

  private void d()
  {
    if ((this.n.b == null) && (this.n.a != null))
    {
      ImageCacheKey localImageCacheKey = this.n.a.e();
      Bitmap localBitmap = (Bitmap)this.i.b(localImageCacheKey);
      if (localBitmap != null)
        this.D = localBitmap;
    }
  }

  private void e()
  {
    if (this.k == null)
    {
      this.k = ((ProgressBar)this.g.inflate(2130903433, this, false));
      addView(this.k);
    }
  }

  private boolean f()
  {
    if ((!this.A) && (!this.z));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private List<FetchImageParams> getImagesToDownload()
  {
    ImmutableList localImmutableList;
    if (this.n.a != null)
      localImmutableList = ImmutableList.a(this.n.a);
    while (true)
    {
      return localImmutableList;
      if (this.n.b != null)
        localImmutableList = this.n.b.a();
      else
        localImmutableList = null;
    }
  }

  private void setMode(UrlImage.CurrentMode paramCurrentMode)
  {
    if ((this.x) && (this.o == UrlImage.CurrentMode.LOADED_IMAGE) && (paramCurrentMode != UrlImage.CurrentMode.LOADED_IMAGE))
      return;
    if (this.v)
    {
      if ((paramCurrentMode == UrlImage.CurrentMode.LOADED_IMAGE) || (paramCurrentMode == UrlImage.CurrentMode.PLACEHOLDER))
        this.k.setVisibility(8);
      if (paramCurrentMode == UrlImage.CurrentMode.PLACEHOLDER)
        a(this.m);
    }
    while (true)
    {
      this.o = paramCurrentMode;
      break;
      if (paramCurrentMode == UrlImage.CurrentMode.LOADED_IMAGE)
      {
        a(this.n);
        this.j.clearAnimation();
        if ((this.z) && (this.A) && (!this.C))
        {
          this.j.startAnimation(this.l);
          continue;
          if (paramCurrentMode == UrlImage.CurrentMode.PROGRESS_BAR)
          {
            this.j.setVisibility(8);
            e();
            this.k.setVisibility(0);
          }
          else if (paramCurrentMode == UrlImage.CurrentMode.PLACEHOLDER)
          {
            this.j.setVisibility(0);
            if (this.k != null)
              this.k.setVisibility(8);
            a(this.m);
          }
          else if (paramCurrentMode == UrlImage.CurrentMode.LOADED_IMAGE)
          {
            a(this.n);
            this.j.clearAnimation();
            if ((this.z) && (this.A) && (!this.C))
              this.j.startAnimation(this.l);
            this.j.setVisibility(0);
            if (this.k != null)
              this.k.setVisibility(8);
          }
        }
      }
    }
  }

  public void a(boolean paramBoolean)
  {
    if (this.A == paramBoolean);
    while (true)
    {
      return;
      this.A = paramBoolean;
      if (f())
        b(this.n.c);
      else
        c();
    }
  }

  public boolean a()
  {
    return this.B;
  }

  public void b()
  {
    setImageParams((FetchImageParams)null);
  }

  public void b(boolean paramBoolean)
  {
    this.s = paramBoolean;
    if ((!paramBoolean) && (this.u))
      c();
  }

  public boolean getAdjustViewBounds()
  {
    return this.n.i;
  }

  public FetchImageParams getImageParams()
  {
    return this.n.a;
  }

  public ImageView getImageView()
  {
    return this.j;
  }

  public MultiFetchImageParams getMultiFetchImageParams()
  {
    return this.n.b;
  }

  public Bitmap getOriginalImageBitmap()
  {
    if ((this.D == null) && (this.n.a != null))
    {
      ImageCacheKey localImageCacheKey = this.n.a.e();
      this.D = ((Bitmap)this.i.e(localImageCacheKey));
    }
    return this.D;
  }

  public int getPlaceHolderBackgroundResourceId()
  {
    if (this.m.f == null);
    for (int i1 = this.m.f.intValue(); ; i1 = -1)
      return i1;
  }

  public Drawable getPlaceHolderDrawable()
  {
    return this.m.e;
  }

  public int getPlaceHolderResourceId()
  {
    if (this.m.d != null);
    for (int i1 = this.m.d.intValue(); ; i1 = -1)
      return i1;
  }

  public ImageView.ScaleType getPlaceHolderScaleType()
  {
    return this.m.g;
  }

  public FetchImageParams getPlaceholderImageParams()
  {
    return this.m.a;
  }

  public int getRecyclableViewType()
  {
    return -1;
  }

  public boolean getRetainImageDuringUpdate()
  {
    return this.x;
  }

  public ImageView.ScaleType getScaleType()
  {
    return this.n.g;
  }

  public boolean getShowProgressBar()
  {
    return this.p;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((!this.v) && (!this.w))
      c();
    a(true);
    setHasBeenAttached(true);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a(false);
    setHasBeenAttached(false);
  }

  public void setAdjustViewBounds(boolean paramBoolean)
  {
    this.n.i = paramBoolean;
    if (this.o == UrlImage.CurrentMode.LOADED_IMAGE)
      this.j.setAdjustViewBounds(paramBoolean);
  }

  public void setHasBeenAttached(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }

  public void setImageMatrix(Matrix paramMatrix)
  {
    this.n.h = paramMatrix;
    if (this.o == UrlImage.CurrentMode.LOADED_IMAGE)
      this.j.setImageMatrix(paramMatrix);
  }

  public void setImageParams(Uri paramUri)
  {
    if (paramUri == null)
      setImageParams((FetchImageParams)null);
    while (true)
    {
      return;
      setImageParams(paramUri, null);
    }
  }

  public void setImageParams(Uri paramUri, UrlImageProcessor paramUrlImageProcessor)
  {
    if (paramUri == null)
      setImageParams((FetchImageParams)null);
    while (true)
    {
      return;
      setImageParams(new FetchImageParams(paramUri, paramUrlImageProcessor));
    }
  }

  public void setImageParams(FetchImageParams paramFetchImageParams)
  {
    this.n.b = null;
    if (!FetchImageParams.a(paramFetchImageParams, this.n.a))
    {
      this.n.a = paramFetchImageParams;
      c();
    }
  }

  public void setLoadResolutionDuringScroll(UrlImage.LoadResolutionDuringScrollMode paramLoadResolutionDuringScrollMode)
  {
    this.t = paramLoadResolutionDuringScrollMode;
  }

  public void setMultiFetchImageParams(MultiFetchImageParams paramMultiFetchImageParams)
  {
    this.n.a = null;
    if (!MultiFetchImageParams.a(paramMultiFetchImageParams, this.n.b))
    {
      this.n.b = paramMultiFetchImageParams;
      c();
    }
  }

  public void setOnImageDownloadListener(UrlImage.OnImageDownloadListener paramOnImageDownloadListener)
  {
    this.r = paramOnImageDownloadListener;
  }

  public void setPlaceHolderDrawable(Drawable paramDrawable)
  {
    this.m.d = null;
    this.m.e = paramDrawable;
    if (this.o == UrlImage.CurrentMode.PLACEHOLDER)
      this.j.setImageDrawable(paramDrawable);
  }

  public void setPlaceHolderResourceId(int paramInt)
  {
    this.m.d = Integer.valueOf(paramInt);
    this.m.e = null;
    if (this.o == UrlImage.CurrentMode.PLACEHOLDER)
      this.j.setImageResource(paramInt);
  }

  public void setPlaceHolderScaleType(ImageView.ScaleType paramScaleType)
  {
    this.m.g = paramScaleType;
    if (this.o == UrlImage.CurrentMode.PLACEHOLDER)
      this.j.setScaleType(paramScaleType);
  }

  public void setPlaceholderBackgroundResourceId(int paramInt)
  {
    this.m.f = Integer.valueOf(paramInt);
    if (this.o == UrlImage.CurrentMode.PLACEHOLDER)
      this.j.setBackgroundResource(paramInt);
  }

  public void setPlaceholderImageParams(FetchImageParams paramFetchImageParams)
  {
    if (!FetchImageParams.a(paramFetchImageParams, this.m.a))
    {
      this.m.a = paramFetchImageParams;
      c();
    }
  }

  public void setRetainImageDuringUpdate(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }

  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    this.n.g = paramScaleType;
    if (this.o == UrlImage.CurrentMode.LOADED_IMAGE)
      this.j.setScaleType(paramScaleType);
  }

  public void setShouldCacheOriginal(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }

  public void setShowProgressBar(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.UrlImage
 * JD-Core Version:    0.6.2
 */