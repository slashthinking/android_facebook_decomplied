package com.facebook.katana.service;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class MediaUploadService$ServiceHandler extends Handler
{
  public MediaUploadService$ServiceHandler(MediaUploadService paramMediaUploadService, Looper paramLooper)
  {
    super(paramLooper);
  }

  public void handleMessage(Message paramMessage)
  {
    this.a.a((Intent)paramMessage.obj);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.MediaUploadService.ServiceHandler
 * JD-Core Version:    0.6.0
 */