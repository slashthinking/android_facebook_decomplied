package com.facebook.orca.fbwebrtc;

public class WebrtcConfig
{
  private static final Class<?> a = WebrtcConfig.class;
  private final String b;
  private final String c;

  public WebrtcConfig(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }

  public String a()
  {
    return "STUN " + this.b + ",TURN " + this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcConfig
 * JD-Core Version:    0.6.0
 */