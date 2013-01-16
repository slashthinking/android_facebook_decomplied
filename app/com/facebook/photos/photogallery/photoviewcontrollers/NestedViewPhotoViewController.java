package com.facebook.photos.photogallery.photoviewcontrollers;

import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.facebook.photos.photogallery.util.Measuring;

public class NestedViewPhotoViewController extends ViewPhotoViewController
{
  private Window a;
  private View b;

  public NestedViewPhotoViewController(Window paramWindow, View paramView1, View paramView2)
  {
    super(paramWindow, paramView1);
    this.a = paramWindow;
    this.b = paramView2;
  }

  public Rect a(int paramInt)
  {
    return Measuring.a(this.a, this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photoviewcontrollers.NestedViewPhotoViewController
 * JD-Core Version:    0.6.0
 */