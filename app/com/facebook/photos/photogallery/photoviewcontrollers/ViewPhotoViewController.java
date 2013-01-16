package com.facebook.photos.photogallery.photoviewcontrollers;

import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.facebook.photos.photogallery.PhotoViewController;
import com.facebook.photos.photogallery.PhotoViewController.PhotoViewControllerListener;
import com.facebook.photos.photogallery.util.Measuring;

public class ViewPhotoViewController
  implements PhotoViewController
{
  private Window a;
  private View b;
  private PhotoViewController.PhotoViewControllerListener c;

  public ViewPhotoViewController(Window paramWindow, View paramView)
  {
    this.a = paramWindow;
    this.b = paramView;
  }

  public Rect a(int paramInt)
  {
    return Measuring.a(this.a, this.b);
  }

  public void a(PhotoViewController.PhotoViewControllerListener paramPhotoViewControllerListener)
  {
    this.c = paramPhotoViewControllerListener;
  }

  public void b(int paramInt)
  {
    this.b.setVisibility(0);
  }

  public void c(int paramInt)
  {
    this.b.setVisibility(4);
  }

  public void d(int paramInt)
  {
    this.c.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photoviewcontrollers.ViewPhotoViewController
 * JD-Core Version:    0.6.0
 */