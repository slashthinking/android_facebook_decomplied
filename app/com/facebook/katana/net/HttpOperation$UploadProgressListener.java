package com.facebook.katana.net;

import com.facebook.orca.entity.mime.content.ChunkedContentSerializationListener;

class HttpOperation$UploadProgressListener extends ChunkedContentSerializationListener
{
  public HttpOperation$UploadProgressListener(HttpOperation paramHttpOperation, long paramLong)
  {
    super(paramLong, 5);
  }

  public void a(long paramLong1, long paramLong2)
  {
    HttpOperation.a(this.a).a(this.a, paramLong1, paramLong2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.net.HttpOperation.UploadProgressListener
 * JD-Core Version:    0.6.0
 */