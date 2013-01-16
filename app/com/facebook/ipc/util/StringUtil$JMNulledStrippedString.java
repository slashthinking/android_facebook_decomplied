package com.facebook.ipc.util;

import com.facebook.common.json.jsonmirror.types.JMString;

public class StringUtil$JMNulledStrippedString extends JMString
{
  public String a(String paramString)
  {
    String str = StringUtil.a(paramString);
    if (str.length() == 0)
      str = null;
    return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.util.StringUtil.JMNulledStrippedString
 * JD-Core Version:    0.6.0
 */