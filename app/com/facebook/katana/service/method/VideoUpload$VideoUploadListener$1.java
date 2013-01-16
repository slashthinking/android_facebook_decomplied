package com.facebook.katana.service.method;

import com.facebook.katana.binding.SystemTrayNotificationManager;

class VideoUpload$VideoUploadListener$1
  implements Runnable
{
  public void run()
  {
    if (this.c.b.l == null);
    while (true)
    {
      return;
      SystemTrayNotificationManager.a(this.c.b.o, Integer.parseInt(VideoUpload.a(this.c.b)), Math.min((int)(100L * this.a / this.b), 100));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.VideoUpload.VideoUploadListener.1
 * JD-Core Version:    0.6.0
 */