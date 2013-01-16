package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.attachments.ImageAttachmentData;
import com.facebook.orca.attachments.ImageAttachmentData.Orientation;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.MultiFetchImageParams;
import com.facebook.orca.images.UrlImageProcessor;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.photos.sizing.CropRegionConstraintsBuilder;
import com.facebook.orca.photos.sizing.CropRegionGraphicOp.CropType;
import com.facebook.orca.photos.sizing.GraphicOpConstraints;
import com.facebook.orca.photos.sizing.GraphicOpConstraintsBuilder;
import com.facebook.orca.photos.sizing.GraphicSizerFactory;
import com.facebook.orca.photos.view.PhotoViewActivity;
import com.facebook.orca.threads.Message;
import com.facebook.widget.UrlImage;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.Map;

public class ThreadViewImageAttachmentView extends ViewGroup
{
  private static final Class<?> a = ThreadViewImageAttachmentView.class;
  private static final int[] b = { 16842919 };
  private static final int[] c = { 16842910 };
  private static final Map<String, GraphicOpConstraints> t = Maps.a();
  private AttachmentDataFactory d;
  private GraphicSizerFactory e;
  private AnalyticsLogger f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private Message m;
  private ImmutableList<ImageAttachmentData> n;
  private int o;
  private ThreadViewImageAttachmentView.MyImageCompositor p = new ThreadViewImageAttachmentView.MyImageCompositor(this, null);
  private int q;
  private int r;
  private Point[] s;

  public ThreadViewImageAttachmentView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ThreadViewImageAttachmentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ThreadViewImageAttachmentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private int a(int paramInt, ImageAttachmentData paramImageAttachmentData)
  {
    return (int)(paramInt * paramImageAttachmentData.e() / paramImageAttachmentData.d());
  }

  private Bitmap a(Bitmap paramBitmap, Drawable paramDrawable)
  {
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramDrawable.setBounds(localRect);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, null);
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }

  private MultiFetchImageParams a(Uri paramUri, UrlImageProcessor paramUrlImageProcessor)
  {
    return new MultiFetchImageParams(ImmutableList.a(new FetchImageParams(paramUri, a(paramUrlImageProcessor, 2130838556)), new FetchImageParams(paramUri, a(paramUrlImageProcessor, 2130838557))), this.p);
  }

  private UrlImageProcessor a(UrlImageProcessor paramUrlImageProcessor, int paramInt)
  {
    return new ThreadViewImageAttachmentView.2(this, paramUrlImageProcessor, paramInt);
  }

  private GraphicOpConstraints a(Point paramPoint, boolean paramBoolean)
  {
    GraphicOpConstraintsBuilder localGraphicOpConstraintsBuilder = new GraphicOpConstraintsBuilder().a(0).c(paramPoint.x).b(0).d(paramPoint.y).a(true);
    CropRegionConstraintsBuilder localCropRegionConstraintsBuilder = new CropRegionConstraintsBuilder().a(paramPoint.x / paramPoint.y).b(0.0F).c(0.0F);
    if (paramBoolean)
    {
      localCropRegionConstraintsBuilder.b(0.5F);
      localCropRegionConstraintsBuilder.c(0.5F);
      localCropRegionConstraintsBuilder.a(CropRegionGraphicOp.CropType.CENTER);
    }
    localGraphicOpConstraintsBuilder.a(localCropRegionConstraintsBuilder.e());
    return localGraphicOpConstraintsBuilder.i();
  }

  private void a(int paramInt)
  {
    UrlImage localUrlImage = (UrlImage)getChildAt(paramInt);
    ImageAttachmentData localImageAttachmentData = (ImageAttachmentData)this.n.get(paramInt);
    a(localUrlImage, localImageAttachmentData, this.s[paramInt]);
    localUrlImage.setVisibility(0);
    localUrlImage.setOnClickListener(new ThreadViewImageAttachmentView.1(this, localImageAttachmentData));
  }

  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 2) || (paramInt1 == 4) || (paramInt1 == 5))
    {
      int i1 = Math.min((paramInt2 - this.g) / 2, this.h);
      if (i1 < this.h)
        this.h = i1;
    }
    for (int i2 = 1; ; i2 = 0)
    {
      if ((paramInt1 == 3) || (paramInt1 == 5) || (paramInt1 == 6))
      {
        int i3 = Math.min((paramInt2 - 2 * this.g) / 3, this.i);
        if (i3 < this.i)
        {
          this.i = i3;
          i2 = 1;
        }
      }
      if (i2 != 0)
      {
        this.s = getImageDimensions();
        for (int i4 = 0; (i4 < this.o) && (i4 < this.n.size()); i4++)
        {
          UrlImage localUrlImage = (UrlImage)getChildAt(i4);
          localUrlImage.setImageParams((FetchImageParams)null);
          a(localUrlImage, (ImageAttachmentData)this.n.get(i4), this.s[i4]);
        }
      }
      return;
    }
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Point localPoint = b(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.makeMeasureSpec(localPoint.x, 1073741824);
    int i2 = View.MeasureSpec.makeMeasureSpec(localPoint.y, 1073741824);
    this.q = resolveSize(localPoint.x, paramInt3);
    this.r = resolveSize(localPoint.y, paramInt4);
    if ((this.s == null) || (this.q != this.s[0].x) || (this.r != this.s[0].y))
      this.s = getImageDimensions();
    measureChild(getChildAt(0), i1, i2);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.d = ((AttachmentDataFactory)localFbInjector.a(AttachmentDataFactory.class));
    this.e = ((GraphicSizerFactory)localFbInjector.a(GraphicSizerFactory.class));
    this.f = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.g = SizeUtil.a(paramContext, 5.0F);
    this.h = SizeUtil.a(paramContext, 111.0F);
    this.i = SizeUtil.a(paramContext, 72.0F);
    this.j = SizeUtil.a(paramContext, 152.0F);
    this.k = SizeUtil.a(paramContext, 232.0F);
    this.l = SizeUtil.a(paramContext, 232.0F);
  }

  private void a(ImageAttachmentData paramImageAttachmentData)
  {
    Context localContext = getContext();
    Intent localIntent = new Intent(localContext, PhotoViewActivity.class);
    localIntent.putExtra("imageData", paramImageAttachmentData);
    localIntent.putExtra("imageAttachments", this.n);
    localIntent.putExtra("message", this.m);
    this.f.a(new HoneyClientEvent("click").e("message_image").f(this.m.a()).b("threadid", this.m.b()).a("num_images", this.n.size()));
    localContext.startActivity(localIntent);
  }

  private void a(UrlImage paramUrlImage, ImageAttachmentData paramImageAttachmentData, Point paramPoint)
  {
    boolean bool;
    String str;
    GraphicOpConstraints localGraphicOpConstraints;
    label102: UrlImageProcessor localUrlImageProcessor;
    int i2;
    int i1;
    if ((this.n.size() != 1) || (!paramImageAttachmentData.c()))
    {
      bool = true;
      Joiner localJoiner = Joiner.on('|');
      Integer localInteger1 = Integer.valueOf(paramPoint.x);
      Integer localInteger2 = Integer.valueOf(paramPoint.y);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(bool);
      str = localJoiner.join(localInteger1, localInteger2, arrayOfObject);
      if (!t.containsKey(str))
        break label256;
      localGraphicOpConstraints = (GraphicOpConstraints)t.get(str);
      localUrlImageProcessor = this.e.a(localGraphicOpConstraints);
      if (paramImageAttachmentData.g() != null)
        paramUrlImage.setPlaceholderImageParams(new FetchImageParams(paramImageAttachmentData.g(), localUrlImageProcessor));
      if (!paramImageAttachmentData.c())
        break label341;
      if (paramImageAttachmentData.d() <= paramImageAttachmentData.e())
        break label281;
      float f1 = paramImageAttachmentData.d() / paramImageAttachmentData.e();
      i2 = paramPoint.y;
      i1 = (int)(f1 * paramPoint.x);
    }
    while (true)
    {
      Uri.Builder localBuilder = paramImageAttachmentData.a().buildUpon();
      localBuilder.appendQueryParameter("preview", "1");
      localBuilder.appendQueryParameter("max_height", String.valueOf(i2));
      localBuilder.appendQueryParameter("max_width", String.valueOf(i1));
      paramUrlImage.setMultiFetchImageParams(a(localBuilder.build(), localUrlImageProcessor));
      return;
      bool = false;
      break;
      label256: localGraphicOpConstraints = a(paramPoint, bool);
      t.put(str, localGraphicOpConstraints);
      break label102;
      label281: if (paramImageAttachmentData.d() < paramImageAttachmentData.e())
      {
        i2 = (int)(paramImageAttachmentData.e() / paramImageAttachmentData.d() * paramPoint.y);
        i1 = paramPoint.x;
        continue;
      }
      i1 = Math.max(paramPoint.x, paramPoint.y);
      i2 = i1;
      continue;
      label341: i1 = (int)(1.5D * Math.max(paramPoint.x, paramPoint.y));
      i2 = i1;
    }
  }

  private int b(int paramInt, ImageAttachmentData paramImageAttachmentData)
  {
    return (int)(paramInt * paramImageAttachmentData.d() / paramImageAttachmentData.e());
  }

  private Point b(int paramInt1, int paramInt2)
  {
    ImageAttachmentData localImageAttachmentData = (ImageAttachmentData)this.n.get(0);
    ImageAttachmentData.Orientation localOrientation = localImageAttachmentData.f();
    int i1;
    int i2;
    int i3;
    if ((localOrientation == ImageAttachmentData.Orientation.PORTRAIT) || (localOrientation == ImageAttachmentData.Orientation.SQUARE) || (localOrientation == ImageAttachmentData.Orientation.UNKNOWN))
    {
      i1 = Math.min(this.l, paramInt1);
      i2 = Math.min(this.k, paramInt2);
      if (i2 > i1)
        i2 = i1;
      if (localImageAttachmentData.c())
        i3 = Math.min(b(i2, localImageAttachmentData), i1);
    }
    while (true)
    {
      return new Point(i3, i2);
      i3 = Math.min(this.l, i1);
      continue;
      int i4 = Math.min(this.l, paramInt1);
      int i5 = Math.min(this.j, paramInt2);
      if (i5 > i4)
        i5 = i4;
      i2 = Math.min(a(i4, localImageAttachmentData), i5);
      i3 = Math.min(b(i2, localImageAttachmentData), i4);
    }
  }

  private void c()
  {
    if (this.n.size() == 1)
    {
      removeAllViews();
      this.o = 0;
    }
    this.s = getImageDimensions();
    while ((this.o < this.n.size()) && (this.o < 6))
    {
      UrlImage localUrlImage = new UrlImage(getContext());
      localUrlImage.setShowProgressBar(false);
      localUrlImage.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localUrlImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localUrlImage.setClickable(true);
      localUrlImage.setLongClickable(true);
      localUrlImage.setPlaceHolderDrawable(null);
      localUrlImage.setPlaceholderBackgroundResourceId(2130838708);
      addView(localUrlImage, this.o);
      this.o = (1 + this.o);
    }
    for (int i1 = 0; (i1 < this.o) && (i1 < this.n.size()); i1++)
    {
      ((UrlImage)getChildAt(i1)).setImageParams((FetchImageParams)null);
      a(i1);
    }
    while (i1 < this.o)
    {
      ((UrlImage)getChildAt(i1)).setVisibility(8);
      i1++;
    }
    requestLayout();
  }

  private void c(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
    int i2 = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
    int i3 = Math.min(this.n.size(), 6);
    int i4 = 1;
    for (int i5 = 0; i5 < i3; i5++)
      measureChild(getChildAt(i5), i1, i2);
    if (i3 == 4)
      i4 = 2;
    this.r = resolveSize(i4 * this.h + this.g * (i4 - 1), paramInt2);
    this.q = resolveSize(2 * this.h + this.g, paramInt1);
  }

  private void d(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
    int i2 = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
    int i3 = Math.min(this.n.size(), 6);
    int i4 = 1;
    for (int i5 = 0; i5 < i3; i5++)
      measureChild(getChildAt(i5), i1, i2);
    if (i3 >= 6)
      i4 = 2;
    this.r = resolveSize(i4 * this.i + this.g * (i4 - 1), paramInt2);
    this.q = resolveSize(3 * this.i + 2 * this.g, paramInt1);
  }

  private void e(int paramInt1, int paramInt2)
  {
    int i1 = 2;
    int i2 = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
    int i3 = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
    for (int i4 = 0; i4 < i1; i4++)
      measureChild(getChildAt(i4), i2, i3);
    int i5 = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
    int i6 = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
    int i7 = Math.min(this.n.size(), 6);
    while (i1 < i7)
    {
      measureChild(getChildAt(i1), i5, i6);
      i1++;
    }
    this.r = resolveSize(this.h + this.i + 2 * this.g, paramInt2);
    this.q = Math.max(resolveSize(2 * this.h + this.g, paramInt1), resolveSize(3 * this.i + 2 * this.g, paramInt1));
  }

  private Point[] getImageDimensions()
  {
    int i1 = Math.min(this.n.size(), 6);
    Point[] arrayOfPoint = new Point[i1];
    int i2 = 0;
    if (i2 < i1)
    {
      if ((i1 == 2) || (i1 == 4))
        arrayOfPoint[i2] = new Point(this.h, this.h);
      while (true)
      {
        i2++;
        break;
        if ((i1 == 3) || (i1 == 6))
        {
          arrayOfPoint[i2] = new Point(this.i, this.i);
          continue;
        }
        if (i1 == 5)
        {
          if (i2 < 2)
          {
            arrayOfPoint[i2] = new Point(this.h, this.h);
            continue;
          }
          arrayOfPoint[i2] = new Point(this.i, this.i);
          continue;
        }
        if ((this.q == 0) || (this.r == 0))
        {
          arrayOfPoint[i2] = b(2147483647, 2147483647);
          continue;
        }
        arrayOfPoint[i2] = new Point(this.q, this.r);
      }
    }
    return arrayOfPoint;
  }

  public Message getMessage()
  {
    return this.m;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = Math.min(this.n.size(), 6);
    if (i1 == 1)
    {
      UrlImage localUrlImage = (UrlImage)getChildAt(0);
      ImageAttachmentData.Orientation localOrientation = ((ImageAttachmentData)this.n.get(0)).f();
      if ((localOrientation == ImageAttachmentData.Orientation.PORTRAIT) || (localOrientation == ImageAttachmentData.Orientation.SQUARE) || (localOrientation == ImageAttachmentData.Orientation.UNKNOWN))
        localUrlImage.layout(0, 0, this.q, Math.min(this.k, this.r));
      while (true)
      {
        return;
        if (localOrientation == ImageAttachmentData.Orientation.LANDSCAPE)
        {
          localUrlImage.layout(0, 0, this.q, Math.min(this.j, this.r));
          continue;
        }
      }
    }
    int i2 = paramInt3 - paramInt1;
    int i3 = 0;
    int i4 = 1;
    int i5 = 0;
    int i6 = 0;
    int i7 = i2;
    label148: int i8;
    int i10;
    int i11;
    int i12;
    if ((i5 < i1) && (i7 >= this.s[i5].x))
    {
      ((UrlImage)getChildAt(i5)).layout(i6, i3, i6 + this.s[i5].x, paramInt2 + i3 + this.s[i5].y);
      i6 += this.s[i5].x + this.g;
      i8 = i7 - (this.s[i5].x + this.g);
      if ((i8 >= this.s[i5].x) && ((i1 != 4) || (i5 != 1) || (i4 != 1)) && ((i1 != 6) || (i5 != 2) || (i4 != 1)) && ((i1 != 5) || (i5 != 1) || (i4 != 1)))
        break label381;
      int i9 = paramInt3 - paramInt1;
      i10 = i4 + 1;
      i11 = i3 + (this.s[i5].y + this.g);
      i12 = i9;
      i6 = 0;
    }
    while (true)
    {
      i5++;
      i7 = i12;
      i3 = i11;
      i4 = i10;
      break label148;
      break;
      label381: int i13 = i4;
      i11 = i3;
      i12 = i8;
      i10 = i13;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = Math.max(2147483647, getSuggestedMinimumHeight());
    int i2 = resolveSize(Math.max(2147483647, getSuggestedMinimumWidth()), paramInt1);
    int i3 = resolveSize(i1, paramInt2);
    int i4 = Math.min(this.n.size(), 6);
    a(i4, i2);
    if (i4 == 1)
      a(i2, i3, paramInt1, paramInt2);
    while (true)
    {
      setMeasuredDimension(Math.min(this.q, i2), Math.min(this.r, i3));
      return;
      if ((i4 == 2) || (i4 == 4))
      {
        c(paramInt1, paramInt2);
        continue;
      }
      if ((i4 == 3) || (i4 >= 6))
      {
        d(paramInt1, paramInt2);
        continue;
      }
      if (i4 != 5)
        continue;
      e(paramInt1, paramInt2);
    }
  }

  public void setMessage(Message paramMessage)
  {
    this.m = paramMessage;
    this.n = this.d.b(paramMessage);
    c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewImageAttachmentView
 * JD-Core Version:    0.6.0
 */