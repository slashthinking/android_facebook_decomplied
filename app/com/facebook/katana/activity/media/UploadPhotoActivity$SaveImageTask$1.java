package com.facebook.katana.activity.media;

import android.net.Uri;
import java.io.File;

class UploadPhotoActivity$SaveImageTask$1
  implements Runnable
{
  public void run()
  {
    if (UploadPhotoActivity.a(this.b.a))
    {
      UploadPhotoActivity.a(this.b.a, UploadPhotoActivity.SaveImageTask.a(this.b), this.a);
      if (UploadPhotoActivity.SaveImageTask.b(this.b) != null)
        new File(UploadPhotoActivity.SaveImageTask.b(this.b).getPath()).delete();
    }
    while (true)
    {
      return;
      UploadPhotoActivity.SaveImageTask.a(this.b, null);
      new File(this.a).delete();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.SaveImageTask.1
 * JD-Core Version:    0.6.0
 */