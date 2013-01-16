package com.facebook.photos.photogallery;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.images.ImageCacheKey;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewTransform;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class GalleryLauncher extends CustomFrameLayout
{
  private ExpandablePhoto a;
  private LaunchableGalleryFragment b;
  private View c;
  private PhotoViewController d;
  private FragmentManager e;
  private PhotoSource f;
  private ImageCache g;
  private LaunchableGalleryFragmentFactory h;
  private ViewPropertyAnimator i;
  private ViewTransform j;
  private int k;
  private int l;

  public GalleryLauncher(Context paramContext)
  {
    this(paramContext, null);
  }

  public GalleryLauncher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903236);
    this.a = ((ExpandablePhoto)b(2131296992));
    this.a.a(new GalleryLauncher.1(this));
    this.g = ((ImageCache)FbInjector.a(getContext()).a(ImageCache.class));
  }

  private Bitmap a(Photo paramPhoto)
  {
    ImageCacheKey localImageCacheKey1 = paramPhoto.a(Photo.PhotoSize.SCREENNAIL).d();
    Bitmap localBitmap = (Bitmap)this.g.b(localImageCacheKey1);
    if (localBitmap == null)
    {
      ImageCacheKey localImageCacheKey2 = paramPhoto.a(Photo.PhotoSize.THUMBNAIL).d();
      localBitmap = (Bitmap)this.g.b(localImageCacheKey2);
    }
    if (localBitmap == null)
      localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    return localBitmap;
  }

  private void c()
  {
    ((Activity)getContext()).getWindow().setSoftInputMode(16);
    this.d.c(this.l);
    this.b.b();
    FragmentTransaction localFragmentTransaction = this.e.a();
    localFragmentTransaction.a(this.b);
    localFragmentTransaction.a();
    this.b = null;
    Bitmap localBitmap = a(this.f.a(this.l));
    Rect localRect = this.d.a(this.l);
    this.a.b(localBitmap, localRect);
    this.j.setScaleX(0.95F);
    this.j.setScaleY(0.95F);
    this.i.b(1.0F);
    this.i.c(1.0F);
  }

  private void d()
  {
    this.b = this.h.a(this.k);
    this.b.a(new GalleryLauncher.4(this));
    FragmentTransaction localFragmentTransaction = this.e.a();
    localFragmentTransaction.a(2131296991, this.b);
    localFragmentTransaction.a();
    this.d.b(this.k);
    ((Activity)getContext()).getWindow().setSoftInputMode(32);
  }

  private void e()
  {
    this.d.b(this.l);
    this.a.a();
  }

  public void a(int paramInt)
  {
    this.k = paramInt;
    this.d.c(this.k);
    Bitmap localBitmap = a(this.f.a(this.k));
    Rect localRect = this.d.a(this.k);
    this.a.a(localBitmap, localRect);
    this.i.b(0.95F);
    this.i.c(0.95F);
  }

  public void a(FragmentManager paramFragmentManager, View paramView)
  {
    this.e = paramFragmentManager;
    this.c = paramView;
    this.i = ViewPropertyAnimator.a(this.c);
    this.i.a(200L);
    this.i.a(new GalleryLauncher.2(this));
    this.j = new ViewTransform(this.c);
  }

  public void a(PhotoViewController paramPhotoViewController, PhotoSource paramPhotoSource, LaunchableGalleryFragmentFactory paramLaunchableGalleryFragmentFactory)
  {
    this.d = paramPhotoViewController;
    this.f = paramPhotoSource;
    this.h = paramLaunchableGalleryFragmentFactory;
    this.d.a(new GalleryLauncher.3(this));
  }

  public boolean a()
  {
    if (this.b != null);
    for (int m = 1; ; m = 0)
      return m;
  }

  public void b()
  {
    this.l = this.b.a();
    this.d.d(this.l);
  }

  public int getCurrentIndex()
  {
    if (a());
    for (int m = this.b.a(); ; m = -1)
      return m;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.GalleryLauncher
 * JD-Core Version:    0.6.0
 */