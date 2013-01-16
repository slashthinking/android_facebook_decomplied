package com.facebook.katana.service.vault.methods;

public class VaultAllImagesGetParams
{
  private final String a;
  private final int b;

  public VaultAllImagesGetParams(int paramInt, String paramString)
  {
    this.a = paramString;
    this.b = paramInt;
  }

  public String a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultAllImagesGetParams
 * JD-Core Version:    0.6.0
 */