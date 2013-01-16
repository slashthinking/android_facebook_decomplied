package com.facebook.katana.activity.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageView;
import com.facebook.katana.util.ImageUtils;
import com.google.common.base.Preconditions;

class CameraReviewActivity$VideoPreviewTask extends AsyncTask<Void, Void, Bitmap>
{
  private Context b;
  private Uri c;

  public CameraReviewActivity$VideoPreviewTask(CameraReviewActivity paramCameraReviewActivity, Context paramContext, Uri paramUri)
  {
    this.b = ((Context)Preconditions.checkNotNull(paramContext));
    this.c = paramUri;
  }

  public Bitmap a(Void[] paramArrayOfVoid)
  {
    return ImageUtils.a(this.b, this.c, this.a.getContentResolver(), 2);
  }

  public void a(Bitmap paramBitmap)
  {
    CameraReviewActivity.a(this.a, paramBitmap);
    CameraReviewActivity.e(this.a).setImageBitmap(CameraReviewActivity.q(this.a));
    CameraReviewActivity.e(this.a).bringToFront();
    CameraReviewActivity.c(this.a).bringToFront();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CameraReviewActivity.VideoPreviewTask
 * JD-Core Version:    0.6.0
 */