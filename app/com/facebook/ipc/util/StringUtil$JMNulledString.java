package com.facebook.ipc.util;

import com.facebook.common.json.jsonmirror.types.JMString;

public class StringUtil$JMNulledString extends JMString
{
  public String a(String paramString)
  {
    if (paramString.length() == 0)
      paramString = null;
    return paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.util.StringUtil.JMNulledString
 * JD-Core Version:    0.6.0
 */