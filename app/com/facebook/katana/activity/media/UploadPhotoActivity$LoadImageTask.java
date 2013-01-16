package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import android.os.Handler;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageException;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.io.File;

class UploadPhotoActivity$LoadImageTask extends Thread
{
  private final Handler b;
  private final String c;

  public UploadPhotoActivity$LoadImageTask(UploadPhotoActivity paramUploadPhotoActivity, Handler paramHandler, String paramString)
  {
    this.b = paramHandler;
    this.c = paramString;
  }

  public void run()
  {
    try
    {
      Bitmap localBitmap = ImageUtils.a(this.c, 960, 960, 1);
      this.b.post(new UploadPhotoActivity.LoadImageTask.1(this, localBitmap));
      return;
    }
    catch (ImageUtils.ImageException localImageException)
    {
      while (true)
      {
        new File(this.c).delete();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = getClass();
        arrayOfObject[1] = this.c;
        ErrorReporting.a("photo_upload", StringLocaleUtil.a("%s upload failure (filename=%s)", arrayOfObject), localImageException);
        Log.a("LoadImageTask.run", "Cannot load bitmap: " + this.c, localImageException);
        this.b.post(new UploadPhotoActivity.LoadImageTask.2(this));
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.LoadImageTask
 * JD-Core Version:    0.6.0
 */