package com.facebook.katana.webview;

import com.facebook.katana.util.StringUtils.StringProcessor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

final class FacebookJsBridge$1
  implements StringUtils.StringProcessor
{
  public String a(Object paramObject)
  {
    if (((paramObject instanceof JSONArray)) || ((paramObject instanceof JSONObject)) || ((paramObject instanceof JSONStringer)));
    for (String str = paramObject.toString(); ; str = JSONObject.quote(paramObject.toString()))
      return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacebookJsBridge.1
 * JD-Core Version:    0.6.0
 */