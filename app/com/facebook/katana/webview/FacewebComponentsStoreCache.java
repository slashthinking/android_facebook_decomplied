package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.common.util.Tuple;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.ManagedDataStore.ClearType;

public class FacewebComponentsStoreCache
{
  public static final Class<?> a = FacewebComponentsStoreCache.class;
  protected static FacewebComponentsStoreMDS b;

  public static void a(Context paramContext)
  {
    c(paramContext).a(ManagedDataStore.ClearType.CLEAR_ALL);
  }

  public static void a(Context paramContext, FacewebComponentsStoreCache.Listener paramListener)
  {
    String str = MFacewebVersion.a(paramContext);
    if (str == null)
      str = "";
    a(paramContext, str, paramListener);
  }

  public static void a(Context paramContext, String paramString, FacewebComponentsStoreCache.Listener paramListener)
  {
    FacewebComponentsStoreCache.Key localKey = new FacewebComponentsStoreCache.Key(Constants.URL.i(paramContext), paramString);
    FacewebComponentsStoreCache.Value localValue = c(paramContext).a(localKey, paramListener);
    if (localValue == null);
    while (true)
    {
      return;
      if (localValue.c())
      {
        Tuple localTuple = (Tuple)localValue.a;
        paramListener.a((FacewebComponentsStoreCache.LoadError)localTuple.a, (String)localTuple.b);
        continue;
      }
      paramListener.a(localValue.b());
    }
  }

  public static void b(Context paramContext)
  {
    c(paramContext).a(ManagedDataStore.ClearType.CLEAR_ALL, 3600L);
  }

  protected static FacewebComponentsStoreMDS c(Context paramContext)
  {
    if (b == null)
      b = new FacewebComponentsStoreMDS(paramContext);
    return b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebComponentsStoreCache
 * JD-Core Version:    0.6.0
 */