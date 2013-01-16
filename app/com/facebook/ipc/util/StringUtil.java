package com.facebook.ipc.util;

public class StringUtil
{
  public static String a(String paramString)
  {
    if (paramString == null);
    String str1;
    for (String str2 = null; ; str2 = Entities.c.b(str1.replaceAll("<(.|\n)*?>", "")).trim())
    {
      return str2;
      str1 = paramString.replaceAll("<br", "\n<br").replaceAll("<div", "\n<div");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.util.StringUtil
 * JD-Core Version:    0.6.0
 */