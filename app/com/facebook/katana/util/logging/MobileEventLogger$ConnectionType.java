package com.facebook.katana.util.logging;

import com.facebook.orca.common.util.StringLocaleUtil;

public class MobileEventLogger$ConnectionType
{
  public static final ConnectionType a = new ConnectionType("None", "");
  private String b;
  private String c;

  private MobileEventLogger$ConnectionType(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }

  public String toString()
  {
    String str = this.b;
    if ((this.c != null) && (this.c.length() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.c;
      str = StringLocaleUtil.a("(%s)", arrayOfObject);
    }
    return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.MobileEventLogger.ConnectionType
 * JD-Core Version:    0.6.0
 */