package com.facebook.photos.photogallery.photoviewcontrollers;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Gallery;
import com.facebook.photos.photogallery.PhotoViewController;
import com.facebook.photos.photogallery.PhotoViewController.PhotoViewControllerListener;
import com.facebook.photos.photogallery.util.Measuring;

public class GalleryPhotoViewController
  implements PhotoViewController
{
  private Window a;
  private Gallery b;
  private PhotoViewController.PhotoViewControllerListener c;

  public GalleryPhotoViewController(Window paramWindow, Gallery paramGallery)
  {
    this.a = paramWindow;
    this.b = paramGallery;
  }

  public Rect a(int paramInt)
  {
    return Measuring.a(this.a, this.b.getSelectedView());
  }

  public void a(PhotoViewController.PhotoViewControllerListener paramPhotoViewControllerListener)
  {
    this.c = paramPhotoViewControllerListener;
  }

  public void b(int paramInt)
  {
    this.b.getSelectedView().setVisibility(0);
  }

  public void c(int paramInt)
  {
    if (this.b.getSelectedView() != null)
      this.b.getSelectedView().setVisibility(4);
  }

  public void d(int paramInt)
  {
    this.b.setSelection(paramInt);
    new Handler().postDelayed(new GalleryPhotoViewController.1(this), 0L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photoviewcontrollers.GalleryPhotoViewController
 * JD-Core Version:    0.6.0
 */