package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.types.JMString;

public class FacebookUserFull$JMTrimWhiteString extends JMString
{
  public String a(String paramString)
  {
    String str = FacebookUserFull.a(paramString, true);
    if (str.length() == 0)
      str = null;
    return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookUserFull.JMTrimWhiteString
 * JD-Core Version:    0.6.0
 */