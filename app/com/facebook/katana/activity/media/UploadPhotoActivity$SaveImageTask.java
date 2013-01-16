package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Handler;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class UploadPhotoActivity$SaveImageTask extends Thread
{
  private final Handler b;
  private Bitmap c;
  private final Uri d;

  public UploadPhotoActivity$SaveImageTask(UploadPhotoActivity paramUploadPhotoActivity, Handler paramHandler, Bitmap paramBitmap, boolean paramBoolean, Uri paramUri)
  {
    this.b = paramHandler;
    this.c = paramBitmap;
    this.d = paramUri;
  }

  public void run()
  {
    String str1 = "upload_" + StringUtils.a(4);
    String str2 = this.a.getFilesDir().getAbsolutePath() + "/" + str1;
    try
    {
      FileOutputStream localFileOutputStream = this.a.openFileOutput(str1, 0);
      this.c.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      localFileOutputStream.close();
      this.b.post(new UploadPhotoActivity.SaveImageTask.1(this, str2));
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        this.c = null;
        new File(str2).delete();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = getClass();
        arrayOfObject[1] = str1;
        ErrorReporting.a("photo_upload", StringLocaleUtil.a("%s upload failure (filen=%s)", arrayOfObject), localIOException);
        Log.a("SaveImageTask.run", "Exception", localIOException);
        this.b.post(new UploadPhotoActivity.SaveImageTask.2(this));
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.SaveImageTask
 * JD-Core Version:    0.6.0
 */