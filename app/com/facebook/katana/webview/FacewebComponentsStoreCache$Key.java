package com.facebook.katana.webview;

import com.facebook.common.util.Tuple;
import com.facebook.orca.common.util.StringLocaleUtil;

public class FacewebComponentsStoreCache$Key extends Tuple<String, String>
{
  public FacewebComponentsStoreCache$Key(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }

  public String a()
  {
    return (String)this.a;
  }

  public String b()
  {
    return (String)this.b;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = a();
    arrayOfObject[1] = b();
    return StringLocaleUtil.a("FwCSC.Key<host=%s, fwVersion=%s>", arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebComponentsStoreCache.Key
 * JD-Core Version:    0.6.0
 */