package com.facebook.katana.activity.media;

public class MediaPickerEnvironment$Builder
{
  private boolean a = false;
  private final long b;
  private boolean c = true;
  private String d = null;
  private boolean e = false;
  private boolean f = true;

  public MediaPickerEnvironment$Builder(long paramLong)
  {
    this.b = paramLong;
  }

  public Builder a(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public Builder a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }

  public MediaPickerEnvironment a()
  {
    return new MediaPickerEnvironment(this, null);
  }

  public Builder b(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }

  public Builder c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  public Builder d(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaPickerEnvironment.Builder
 * JD-Core Version:    0.6.0
 */