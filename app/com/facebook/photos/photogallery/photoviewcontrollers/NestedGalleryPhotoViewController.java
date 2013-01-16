package com.facebook.photos.photogallery.photoviewcontrollers;

import android.graphics.Rect;
import android.view.Window;
import android.widget.Gallery;
import com.facebook.photos.photogallery.util.Measuring;

public class NestedGalleryPhotoViewController extends GalleryPhotoViewController
{
  private Window a;
  private Gallery b;
  private NestedGalleryPhotoViewController.InnerViewGetter c;

  public NestedGalleryPhotoViewController(Window paramWindow, Gallery paramGallery, NestedGalleryPhotoViewController.InnerViewGetter paramInnerViewGetter)
  {
    super(paramWindow, paramGallery);
    this.a = paramWindow;
    this.b = paramGallery;
    this.c = paramInnerViewGetter;
  }

  public Rect a(int paramInt)
  {
    return Measuring.a(this.a, this.c.a(this.b.getSelectedView()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photoviewcontrollers.NestedGalleryPhotoViewController
 * JD-Core Version:    0.6.0
 */