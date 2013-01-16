package com.facebook.orca.attachments;

import android.net.Uri;

public class ImageAttachmentDataBuilder
{
  private Uri a;
  private Uri b;
  private int c;
  private int d;
  private Uri e;

  public Uri a()
  {
    return this.a;
  }

  public ImageAttachmentDataBuilder a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }

  public ImageAttachmentDataBuilder a(Uri paramUri)
  {
    this.a = paramUri;
    return this;
  }

  public Uri b()
  {
    return this.b;
  }

  public ImageAttachmentDataBuilder b(int paramInt)
  {
    this.d = paramInt;
    return this;
  }

  public ImageAttachmentDataBuilder b(Uri paramUri)
  {
    this.b = paramUri;
    return this;
  }

  public int c()
  {
    return this.c;
  }

  public ImageAttachmentDataBuilder c(Uri paramUri)
  {
    this.e = paramUri;
    return this;
  }

  public int d()
  {
    return this.d;
  }

  public Uri e()
  {
    return this.e;
  }

  public ImageAttachmentData f()
  {
    return new ImageAttachmentData(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.ImageAttachmentDataBuilder
 * JD-Core Version:    0.6.0
 */