package com.facebook.feed.protocol;

public class ApiMethodNotFoundException extends RuntimeException
{
  public ApiMethodNotFoundException(String paramString)
  {
    super("Unknown ApiMethod type: " + paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.ApiMethodNotFoundException
 * JD-Core Version:    0.6.0
 */