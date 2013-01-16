package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.katana.binding.ManagedDataStore;

public class MFacewebVersion
{
  protected static ManagedDataStore<Object, String> a;

  public static String a(Context paramContext)
  {
    return (String)b(paramContext).a("MRootVersion");
  }

  public static void a(Context paramContext, String paramString)
  {
    b(paramContext).a(paramContext, true, "MRootVersion", paramString, paramString);
  }

  protected static ManagedDataStore<Object, String> b(Context paramContext)
  {
    if (a == null)
      a = new ManagedDataStore(new MFacewebVersionClient(), paramContext);
    return a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.MFacewebVersion
 * JD-Core Version:    0.6.0
 */