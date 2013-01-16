package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageException;
import com.facebook.orca.common.util.StringLocaleUtil;

class UploadPhotoActivity$ScaleImageTask extends Thread
{
  private final Handler b;
  private final Uri c;
  private final boolean d;

  public UploadPhotoActivity$ScaleImageTask(UploadPhotoActivity paramUploadPhotoActivity, Handler paramHandler, Uri paramUri, boolean paramBoolean)
  {
    this.b = paramHandler;
    this.c = paramUri;
    this.d = paramBoolean;
  }

  public void run()
  {
    try
    {
      Bitmap localBitmap = ImageUtils.a(this.a, this.c, 960, 960, true);
      this.b.post(new UploadPhotoActivity.ScaleImageTask.1(this, localBitmap));
      return;
    }
    catch (ImageUtils.ImageException localImageException)
    {
      while (true)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = getClass();
        arrayOfObject[1] = this.c;
        ErrorReporting.a("photo_upload", StringLocaleUtil.a("%s upload failure (filename=%s)", arrayOfObject), localImageException);
        Log.a("ScaleImageTask.run", "upload failed", localImageException);
        this.b.post(new UploadPhotoActivity.ScaleImageTask.2(this));
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.ScaleImageTask
 * JD-Core Version:    0.6.0
 */