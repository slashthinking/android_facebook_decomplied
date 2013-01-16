package com.facebook.katana.service.method;

import android.os.Handler;
import com.facebook.katana.binding.SystemTrayNotificationManager;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;

public class VideoUpload$VideoUploadListener extends NetworkServiceOperation.NetworkServiceOperationHttpListener
{
  protected VideoUpload$VideoUploadListener(VideoUpload paramVideoUpload)
  {
    super(paramVideoUpload);
  }

  public void a(HttpOperation paramHttpOperation, int paramInt, String paramString, HttpOperation.ResponseInputStream paramResponseInputStream, Exception paramException)
  {
    super.a(paramHttpOperation, paramInt, paramString, paramResponseInputStream, paramException);
    SystemTrayNotificationManager.a(this.b.o, Integer.parseInt(VideoUpload.a(this.b)), paramInt, VideoUpload.b(this.b));
  }

  public void a(HttpOperation paramHttpOperation, long paramLong1, long paramLong2)
  {
    if ((this.b.q == null) || (VideoUpload.a(this.b) == null));
    while (true)
    {
      return;
      ServiceOperation.n.post(new VideoUpload.VideoUploadListener.1(this, paramLong1, paramLong2));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.VideoUpload.VideoUploadListener
 * JD-Core Version:    0.6.0
 */