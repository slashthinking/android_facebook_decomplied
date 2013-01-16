package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.os.Handler;

class UploadPhotoActivity$FaceDetectTask extends Thread
{
  private final Handler b;
  private Bitmap c;

  public UploadPhotoActivity$FaceDetectTask(UploadPhotoActivity paramUploadPhotoActivity, Handler paramHandler, Bitmap paramBitmap)
  {
    this.b = paramHandler;
    this.c = paramBitmap;
  }

  public void run()
  {
    try
    {
      int i = 0xFFFFFFFE & this.c.getWidth();
      int j = this.c.getHeight();
      Bitmap localBitmap = Bitmap.createBitmap(this.c, 0, 0, i, j).copy(Bitmap.Config.RGB_565, true);
      if (localBitmap != null)
      {
        FaceDetector localFaceDetector = new FaceDetector(localBitmap.getWidth(), localBitmap.getHeight(), 10);
        FaceDetector.Face[] arrayOfFace = new FaceDetector.Face[10];
        localFaceDetector.findFaces(localBitmap, arrayOfFace);
        this.b.post(new UploadPhotoActivity.FaceDetectTask.1(this, arrayOfFace, i, j));
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.FaceDetectTask
 * JD-Core Version:    0.6.0
 */