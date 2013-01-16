package com.facebook.apache.http.entity.mime.content;

import java.io.OutputStream;

public abstract interface ContentBody extends ContentDescriptor
{
  public abstract void a(OutputStream paramOutputStream);

  public abstract String b();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.apache.http.entity.mime.content.ContentBody
 * JD-Core Version:    0.6.0
 */