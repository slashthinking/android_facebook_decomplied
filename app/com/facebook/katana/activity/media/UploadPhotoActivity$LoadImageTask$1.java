package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import java.io.File;

class UploadPhotoActivity$LoadImageTask$1
  implements Runnable
{
  public void run()
  {
    if (UploadPhotoActivity.a(this.b.a))
      UploadPhotoActivity.a(this.b.a, this.a, UploadPhotoActivity.LoadImageTask.a(this.b));
    while (true)
    {
      return;
      new File(UploadPhotoActivity.LoadImageTask.a(this.b)).delete();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.LoadImageTask.1
 * JD-Core Version:    0.6.0
 */