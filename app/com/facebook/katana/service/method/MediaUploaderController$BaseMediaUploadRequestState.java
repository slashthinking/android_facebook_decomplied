package com.facebook.katana.service.method;

import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.MediaItem;

class MediaUploaderController$BaseMediaUploadRequestState
{
  protected MediaItem a;
  protected String b = "";
  protected int c = 0;
  protected MediaUploaderController.MediaUploadRequest d = null;
  protected boolean e;
  protected int f = 200;
  protected String g = "OK";
  FacebookPhoto h = null;

  MediaUploaderController$BaseMediaUploadRequestState(MediaItem paramMediaItem)
  {
    this.a = paramMediaItem;
    this.e = true;
  }

  public String a()
  {
    return this.b;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public int b()
  {
    return this.c;
  }

  public void c()
  {
    this.c = (1 + this.c);
  }

  public MediaUploaderController.MediaUploadRequest d()
  {
    return this.d;
  }

  public MediaItem e()
  {
    return this.a;
  }

  public boolean f()
  {
    return this.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaUploaderController.BaseMediaUploadRequestState
 * JD-Core Version:    0.6.0
 */