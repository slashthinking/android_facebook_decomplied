package com.facebook.katana.util;

import com.facebook.common.json.jsonmirror.types.JMString;

public class StringUtils$JMNulledStrippedString extends JMString
{
  public String a(String paramString)
  {
    String str = StringUtils.b(paramString);
    if (str.length() == 0)
      str = null;
    return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.StringUtils.JMNulledStrippedString
 * JD-Core Version:    0.6.0
 */