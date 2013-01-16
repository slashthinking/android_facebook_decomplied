package com.facebook.katana.provider;

import android.content.Context;
import com.facebook.orca.inject.FbInjector;

public class KeyValueManager
{
  public static final String[] a = { "key", "value" };
  private static final String[] b = { "value" };
  private static final String[] c = { "_id" };
  private final KeyValueStore d;

  public KeyValueManager(KeyValueStore paramKeyValueStore)
  {
    this.d = paramKeyValueStore;
  }

  @Deprecated
  public static long a(Context paramContext, String paramString, long paramLong)
  {
    return a(paramContext).a(paramString, paramLong);
  }

  private static KeyValueManager a(Context paramContext)
  {
    return (KeyValueManager)FbInjector.a(paramContext).a(KeyValueManager.class);
  }

  @Deprecated
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext).a(paramString1, paramString2);
  }

  @Deprecated
  public static void a(Context paramContext, String paramString, Object paramObject)
  {
    KeyValueManager localKeyValueManager = a(paramContext);
    if (paramObject == null);
    for (String str = null; ; str = paramObject.toString())
    {
      localKeyValueManager.b(paramString, str);
      return;
    }
  }

  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.d.a(paramString1, paramString2, paramBoolean);
  }

  @Deprecated
  public static boolean a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, false);
  }

  @Deprecated
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    return a(paramContext).a(paramString, paramBoolean);
  }

  @Deprecated
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext).a(paramString);
  }

  public long a(String paramString, long paramLong)
  {
    return Long.parseLong(a(paramString, String.valueOf(paramLong)));
  }

  public String a(String paramString1, String paramString2)
  {
    return this.d.a(paramString1, paramString2);
  }

  public void a(String paramString)
  {
    this.d.a(paramString);
  }

  public boolean a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "true"; ; str = "false")
      return Boolean.parseBoolean(a(paramString, str));
  }

  public void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.KeyValueManager
 * JD-Core Version:    0.6.0
 */