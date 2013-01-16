package com.facebook.photos.photogallery.photoviewcontrollers;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import com.facebook.photos.photogallery.PhotoViewController;
import com.facebook.photos.photogallery.PhotoViewController.PhotoViewControllerListener;
import com.facebook.photos.photogallery.util.Measuring;

public class AdapterViewPhotoViewController
  implements PhotoViewController
{
  private Window a;
  private AdapterView b;
  private PhotoViewController.PhotoViewControllerListener c;

  public AdapterViewPhotoViewController(Window paramWindow, AdapterView paramAdapterView)
  {
    this.a = paramWindow;
    this.b = paramAdapterView;
  }

  private View e(int paramInt)
  {
    int i = this.b.getChildCount();
    int j = this.b.getFirstVisiblePosition();
    for (int k = 0; ; k++)
    {
      View localView = null;
      if (k < i)
      {
        if (j + k != paramInt)
          continue;
        localView = this.b.getChildAt(k);
      }
      return localView;
    }
  }

  public Rect a(int paramInt)
  {
    return Measuring.a(this.a, e(paramInt));
  }

  public void a(PhotoViewController.PhotoViewControllerListener paramPhotoViewControllerListener)
  {
    this.c = paramPhotoViewControllerListener;
  }

  public void b(int paramInt)
  {
    e(paramInt).setVisibility(0);
  }

  public void c(int paramInt)
  {
    e(paramInt).setVisibility(4);
  }

  public void d(int paramInt)
  {
    if ((paramInt < this.b.getFirstVisiblePosition()) || (paramInt > this.b.getLastVisiblePosition()))
    {
      this.b.setSelection(paramInt);
      new Handler().postDelayed(new AdapterViewPhotoViewController.1(this), 0L);
    }
    while (true)
    {
      return;
      this.c.a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photoviewcontrollers.AdapterViewPhotoViewController
 * JD-Core Version:    0.6.0
 */