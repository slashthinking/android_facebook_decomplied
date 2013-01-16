package com.facebook.katana.webview;

import com.facebook.common.util.Tuple;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import com.facebook.orca.common.util.StringLocaleUtil;

public class FacewebComponentsStoreCache$Value extends Tuple<Tuple<FacewebComponentsStoreCache.LoadError, String>, FacewebComponentsStore>
{
  public FacewebComponentsStoreCache$Value(FacewebComponentsStore paramFacewebComponentsStore)
  {
    super(null, paramFacewebComponentsStore);
  }

  public FacewebComponentsStoreCache$Value(FacewebComponentsStoreCache.LoadError paramLoadError, String paramString)
  {
    super(new Tuple(paramLoadError, paramString), null);
  }

  public Tuple<FacewebComponentsStoreCache.LoadError, String> a()
  {
    return (Tuple)this.a;
  }

  public FacewebComponentsStore b()
  {
    return (FacewebComponentsStore)this.b;
  }

  public boolean c()
  {
    if (this.a != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = a();
    arrayOfObject[1] = b();
    return StringLocaleUtil.a("FwCSC.Value<error=%s fcs=%s>", arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebComponentsStoreCache.Value
 * JD-Core Version:    0.6.0
 */