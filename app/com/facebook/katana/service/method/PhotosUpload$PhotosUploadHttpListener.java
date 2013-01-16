package com.facebook.katana.service.method;

import android.os.Handler;
import com.facebook.katana.net.HttpOperation;

public class PhotosUpload$PhotosUploadHttpListener extends NetworkServiceOperation.NetworkServiceOperationHttpListener
{
  protected PhotosUpload$PhotosUploadHttpListener(PhotosUpload paramPhotosUpload)
  {
    super(paramPhotosUpload);
  }

  public void a(HttpOperation paramHttpOperation, long paramLong1, long paramLong2)
  {
    if (this.b.q == null);
    while (true)
    {
      return;
      ServiceOperation.n.post(new PhotosUpload.PhotosUploadHttpListener.1(this, paramLong1, paramLong2));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosUpload.PhotosUploadHttpListener
 * JD-Core Version:    0.6.0
 */