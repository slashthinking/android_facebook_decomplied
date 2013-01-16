package com.facebook.orca.threads;

public class TitanAttachmentInfoBuilder
{
  private String a;
  private int b;
  private String c;
  private String d;
  private int e;
  private TitanAttachmentInfo.ImageData f;

  public TitanAttachmentInfoBuilder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }

  public TitanAttachmentInfoBuilder a(TitanAttachmentInfo.ImageData paramImageData)
  {
    this.f = paramImageData;
    return this;
  }

  public TitanAttachmentInfoBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public String a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public TitanAttachmentInfoBuilder b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public TitanAttachmentInfoBuilder b(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public TitanAttachmentInfoBuilder c(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }

  public TitanAttachmentInfo.ImageData f()
  {
    return this.f;
  }

  public TitanAttachmentInfo g()
  {
    return new TitanAttachmentInfo(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.TitanAttachmentInfoBuilder
 * JD-Core Version:    0.6.0
 */