package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import android.net.Uri;

class UploadPhotoActivity$ScaleImageTask$1
  implements Runnable
{
  public void run()
  {
    if (UploadPhotoActivity.a(this.b.a))
      if (!UploadPhotoActivity.ScaleImageTask.a(this.b))
        break label62;
    label62: for (Uri localUri = UploadPhotoActivity.ScaleImageTask.b(this.b); ; localUri = null)
    {
      new UploadPhotoActivity.SaveImageTask(this.b.a, UploadPhotoActivity.ScaleImageTask.c(this.b), this.a, true, localUri).start();
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.ScaleImageTask.1
 * JD-Core Version:    0.6.0
 */