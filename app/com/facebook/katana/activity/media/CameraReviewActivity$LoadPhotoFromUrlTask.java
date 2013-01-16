package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.common.util.Log;
import java.net.URL;
import java.net.URLConnection;

class CameraReviewActivity$LoadPhotoFromUrlTask extends AsyncTask<String, Void, Boolean>
{
  private Bitmap b;

  private CameraReviewActivity$LoadPhotoFromUrlTask(CameraReviewActivity paramCameraReviewActivity)
  {
  }

  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt1 / paramInt3;
    float f2 = paramInt2 / paramInt4;
    if (f1 > f2);
    while (true)
    {
      return f1;
      f1 = f2;
    }
  }

  private Bitmap a(URL paramURL)
  {
    float f1 = 2.0F;
    Display localDisplay = this.a.getWindowManager().getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    Bitmap localBitmap1 = BitmapFactory.decodeStream(paramURL.openConnection().getInputStream());
    int k = localBitmap1.getWidth();
    int m = localBitmap1.getHeight();
    float f2;
    if ((i > k) && (j > m))
    {
      f2 = a(k, m, i, j);
      if (f2 <= f1);
    }
    for (Bitmap localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, (int)(k / f1), (int)(m / f1), true); ; localBitmap2 = localBitmap1)
    {
      return localBitmap2;
      f1 = f2;
      break;
    }
  }

  protected Boolean a(String[] paramArrayOfString)
  {
    Object localObject;
    if (CameraReviewActivity.q(this.a) != null)
    {
      this.b = CameraReviewActivity.q(this.a);
      localObject = Boolean.valueOf(true);
    }
    while (true)
    {
      return localObject;
      String str = paramArrayOfString[0];
      try
      {
        this.b = a(new URL(str));
        Boolean localBoolean = Boolean.valueOf(true);
        localObject = localBoolean;
      }
      catch (Exception localException)
      {
        Log.a(this.a.x(), "Cannot decode bitmap from url img", localException);
        localObject = Boolean.valueOf(false);
      }
    }
  }

  protected void a(Boolean paramBoolean)
  {
    if ((paramBoolean.booleanValue()) && (this.b != null))
    {
      CameraReviewActivity.a(this.a, this.b);
      CameraReviewActivity.t(this.a).setVisibility(4);
      CameraReviewActivity.u(this.a).setVisibility(0);
      CameraReviewActivity.e(this.a).setImageBitmap(CameraReviewActivity.q(this.a));
      CameraReviewActivity.e(this.a).setOnTouchListener(new CameraReviewActivity.PhotoTouchListener(this.a, null));
      if (CameraReviewActivity.u(this.a).getVisibility() == 0)
        CameraReviewActivity.u(this.a).bringToFront();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CameraReviewActivity.LoadPhotoFromUrlTask
 * JD-Core Version:    0.6.0
 */