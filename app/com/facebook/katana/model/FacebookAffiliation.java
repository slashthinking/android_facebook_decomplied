package com.facebook.katana.model;

import android.content.Context;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.provider.KeyValueManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class FacebookAffiliation
{
  protected static boolean a;
  protected static boolean b;
  protected static boolean c;
  protected static boolean d;
  protected static boolean e;
  protected static boolean f;
  protected static AtomicBoolean g;
  private static final Class<?> h = FacebookAffiliation.class;

  static
  {
    g = new AtomicBoolean(false);
  }

  public static void a(Context paramContext)
  {
    String str1 = KeyValueManager.a(paramContext, "is_employee", null);
    if (str1 != null)
    {
      b = Boolean.parseBoolean(str1);
      c = true;
    }
    String str2 = KeyValueManager.a(paramContext, "seen_employee", null);
    if (str2 != null)
    {
      d = Boolean.parseBoolean(str2);
      e = true;
    }
    a = true;
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    Log.d(h, "employee bit set to " + paramBoolean);
    b = paramBoolean;
    if (((e) && (d)) || (paramBoolean));
    for (boolean bool = true; ; bool = false)
    {
      d = bool;
      c = true;
      e = true;
      KeyValueManager.a(paramContext, "is_employee", Boolean.valueOf(b));
      KeyValueManager.a(paramContext, "seen_employee", Boolean.valueOf(d));
      a = true;
      return;
    }
  }

  public static boolean a()
  {
    return a;
  }

  public static void b(Context paramContext)
  {
    Log.d(h, "employee accurate bit cleared");
    c = false;
    f = false;
    KeyValueManager.b(paramContext, "is_employee");
  }

  public static boolean b()
  {
    if ((c) && (b));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean c()
  {
    if (((e) && (d)) || ((c) && (b)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean c(Context paramContext)
  {
    return Boolean.TRUE.equals(Gatekeeper.a(paramContext, "android_trusted_tester"));
  }

  public static boolean d()
  {
    boolean bool = true;
    if (((!c) || (!e)) && (g.compareAndSet(false, bool)));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public static boolean d(Context paramContext)
  {
    if ((b()) && (Boolean.TRUE.equals(Gatekeeper.a(paramContext, "android_devs"))));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static void e()
  {
    g.set(false);
  }

  public static void e(Context paramContext)
  {
    if (!f)
    {
      Toaster.a(paramContext.getApplicationContext(), "This beta build is only enabled for employees and authorized users.");
      f = true;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookAffiliation
 * JD-Core Version:    0.6.0
 */