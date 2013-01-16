package com.facebook.katana.activity.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.katana.RotateBitmap;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.ui.ImageViewTouchBase;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageOutOfMemoryException;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.images.ImageCacheKey;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.media.MediaCacheKey;
import com.facebook.widget.GalleryWithSwipingFix;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhotosetGalleryAdapter extends BasePhotosetAdapter
{
  private AppSession a;
  private GalleryWithSwipingFix b;
  private LayoutInflater c = a();
  private Bitmap d;
  private ImageCache e;
  private final Map<Long, String> f = Collections.synchronizedMap(new HashMap());
  private final Set<Long> g = Collections.synchronizedSet(new HashSet());
  private final Map<Long, ImageCacheKey> h = Collections.synchronizedMap(new HashMap());
  private final FbErrorReporter i;
  private final PerformanceLogger j;

  public PhotosetGalleryAdapter(Context paramContext, AppSession paramAppSession, GalleryWithSwipingFix paramGalleryWithSwipingFix, ImageCache paramImageCache)
  {
    super(paramContext);
    this.a = paramAppSession;
    this.b = paramGalleryWithSwipingFix;
    this.e = paramImageCache;
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.i = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.j = ((PerformanceLogger)localFbInjector.a(PerformanceLogger.class));
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    try
    {
      this.d = ImageUtils.b(paramContext.getResources(), 2130838840);
      return;
    }
    catch (ImageUtils.ImageOutOfMemoryException localImageOutOfMemoryException)
    {
      while (true)
        ErrorReporting.a("photoset-gallery", "Cannot decode resource photo_placeholder_dark: OOM", localImageOutOfMemoryException);
    }
  }

  private void b(long paramLong)
  {
    if (this.g.add(Long.valueOf(paramLong)))
    {
      PhotosetGalleryAdapter.LoadPhotoTask localLoadPhotoTask = new PhotosetGalleryAdapter.LoadPhotoTask(this, null);
      Long[] arrayOfLong = new Long[1];
      arrayOfLong[0] = Long.valueOf(paramLong);
      localLoadPhotoTask.execute(arrayOfLong);
    }
  }

  private void c(long paramLong)
  {
    this.g.remove(Long.valueOf(paramLong));
  }

  private boolean d(long paramLong)
  {
    String str = (String)this.f.get(Long.valueOf(paramLong));
    if (str == null);
    for (boolean bool = false; ; bool = this.a.a(str))
      return bool;
  }

  public ImageCacheKey a(Long paramLong)
  {
    return (ImageCacheKey)this.h.get(paramLong);
  }

  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount()));
    while (true)
    {
      return;
      long l = ((Long)getItem(paramInt)).longValue();
      Object localObject = this.h.get(Long.valueOf(l));
      Bitmap localBitmap = null;
      if (localObject != null)
        localBitmap = (Bitmap)this.e.e((MediaCacheKey)this.h.get(Long.valueOf(l)));
      if (localBitmap != null)
        continue;
      b(l);
    }
  }

  public void a(long paramLong)
  {
    int k = 0;
    if (k < getCount())
      if (((Long)getItem(k)).longValue() != paramLong);
    while (true)
    {
      if (k > 0)
        this.b.setSelection(k);
      return;
      k++;
      break;
      k = -1;
    }
  }

  public void a(Long paramLong, Bitmap paramBitmap)
  {
    ImageCacheKey localImageCacheKey = (ImageCacheKey)this.h.get(paramLong);
    if (localImageCacheKey != null)
      this.e.a(localImageCacheKey, paramBitmap);
  }

  public void a(Long paramLong, Uri paramUri)
  {
    this.h.put(paramLong, new ImageCacheKey(paramUri, ImageCacheKey.c));
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PhotosetGalleryAdapter.ViewHolder localViewHolder2;
    if (paramView == null)
    {
      paramView = this.c.inflate(2130903483, null);
      localViewHolder2 = new PhotosetGalleryAdapter.ViewHolder(null);
      localViewHolder2.b = ((ImageViewTouchBase)paramView.findViewById(2131296625));
      localViewHolder2.d = ((ProgressBar)paramView.findViewById(2131296462));
      paramView.setTag(localViewHolder2);
    }
    long l;
    for (PhotosetGalleryAdapter.ViewHolder localViewHolder1 = localViewHolder2; ; localViewHolder1 = (PhotosetGalleryAdapter.ViewHolder)paramView.getTag())
    {
      l = ((Long)getItem(paramInt)).longValue();
      if ((l != localViewHolder1.c) || (!localViewHolder1.a))
        break;
      return paramView;
    }
    localViewHolder1.c = l;
    localViewHolder1.a = false;
    ImageCacheKey localImageCacheKey = (ImageCacheKey)this.h.get(Long.valueOf(localViewHolder1.c));
    Bitmap localBitmap1;
    if (localImageCacheKey != null)
    {
      localBitmap1 = (Bitmap)this.e.b(localImageCacheKey);
      if (localBitmap1 != null)
        break label342;
    }
    label342: for (Bitmap localBitmap2 = (Bitmap)this.e.e(localImageCacheKey); ; localBitmap2 = localBitmap1)
    {
      if (localBitmap2 != null)
      {
        this.j.b("NNFPhotoViewCached", Long.toString(localViewHolder1.c), SystemClock.b().a());
        this.j.c("NNFPhotoViewUncached", Long.toString(localViewHolder1.c));
        localViewHolder1.b.setImageRotateBitmapResetBase(new RotateBitmap(localBitmap2, 0), true);
        localViewHolder1.a = true;
        localViewHolder1.d.setVisibility(8);
      }
      for (int k = 0; ; k = 1)
      {
        if (k != 0)
        {
          localViewHolder1.b.setImageBitmapResetBaseNoScale(new RotateBitmap(this.d), true);
          localViewHolder1.d.setVisibility(0);
        }
        if (localViewHolder1.a)
          break;
        this.j.c("NNFPhotoViewCached", Long.toString(localViewHolder1.c));
        b(l);
        break;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotosetGalleryAdapter
 * JD-Core Version:    0.6.0
 */