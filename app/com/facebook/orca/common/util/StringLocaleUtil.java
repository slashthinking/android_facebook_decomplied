package com.facebook.orca.common.util;

import java.util.Locale;

public class StringLocaleUtil
{
  public static final String a(String paramString, Object[] paramArrayOfObject)
  {
    return String.format((Locale)null, paramString, paramArrayOfObject);
  }

  public static final String b(String paramString, Object[] paramArrayOfObject)
  {
    return String.format(Locale.getDefault(), paramString, paramArrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.StringLocaleUtil
 * JD-Core Version:    0.6.0
 */