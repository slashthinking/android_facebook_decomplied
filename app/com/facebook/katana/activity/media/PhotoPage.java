package com.facebook.katana.activity.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.katana.RotateBitmap;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.ui.ImageViewTouchBase;

public class PhotoPage extends RelativeLayout
{
  private static final Class<?> c = PhotoPage.class;
  private static final String d = c.getSimpleName();
  private volatile int a = 0;
  private volatile int b = 0;
  private PhotoItem e;
  private MediaPickerGalleryAdapter f;
  private boolean g = false;

  public PhotoPage(Context paramContext, PhotoItem paramPhotoItem, MediaPickerGalleryAdapter paramMediaPickerGalleryAdapter, int paramInt1, int paramInt2)
  {
    super(paramContext, null);
    this.e = paramPhotoItem;
    this.f = paramMediaPickerGalleryAdapter;
    this.a = paramInt1;
    this.b = paramInt2;
    View.inflate(paramContext, 2130903490, this);
    new PhotoPage.LoadPhotoTask(this, null).execute(new Object[] { paramPhotoItem });
  }

  private int a(int paramInt)
  {
    if (paramInt <= 0);
    for (int i = 300; ; i = (int)(0.5F * paramInt))
      return i;
  }

  private void a(Bitmap paramBitmap, int paramInt)
  {
    ((ImageViewTouchBase)findViewById(2131297064)).setImageRotateBitmapResetBase(new RotateBitmap(paramBitmap, paramInt), true);
  }

  public void a()
  {
    getImageView().setImageBitmap(null);
  }

  protected void b()
  {
    PhotoPage.LoadPhotoTask localLoadPhotoTask = new PhotoPage.LoadPhotoTask(this, null);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.e;
    localLoadPhotoTask.execute(arrayOfObject);
  }

  public ImageViewTouchBase getImageView()
  {
    return (ImageViewTouchBase)findViewById(2131297064);
  }

  public void setBitmapIfNotLoaded(Bitmap paramBitmap, int paramInt)
  {
    if (!this.g)
      a(paramBitmap, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoPage
 * JD-Core Version:    0.6.0
 */