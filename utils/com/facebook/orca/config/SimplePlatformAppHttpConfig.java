package com.facebook.orca.config;

import android.net.Uri;
import android.net.Uri.Builder;

public class SimplePlatformAppHttpConfig
  implements PlatformAppHttpConfig
{
  private final String a;
  private final boolean b;

  public SimplePlatformAppHttpConfig(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }

  public Uri.Builder a()
  {
    if (this.b);
    for (Uri.Builder localBuilder = Uri.parse("https://api." + this.a).buildUpon(); ; localBuilder = Uri.parse("http://api." + this.a).buildUpon())
      return localBuilder;
  }

  public Uri.Builder b()
  {
    if (this.b);
    for (Uri.Builder localBuilder = Uri.parse("https://graph." + this.a).buildUpon(); ; localBuilder = Uri.parse("http://graph." + this.a).buildUpon())
      return localBuilder;
  }

  public String c()
  {
    return null;
  }

  public String d()
  {
    return null;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.config.SimplePlatformAppHttpConfig
 * JD-Core Version:    0.6.2
 */