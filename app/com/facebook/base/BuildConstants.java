package com.facebook.base;

public class BuildConstants
{
  private static Boolean a = null;

  public static void a(boolean paramBoolean)
  {
    if (a != null)
      throw new RuntimeException("IS_BETA_BUILD has already been set!");
    a = Boolean.valueOf(paramBoolean);
  }

  public static final boolean a()
  {
    if (a == null)
      a = Boolean.valueOf(true);
    return a.booleanValue();
  }

  public static final String b()
  {
    if (a());
    for (String str = "com.facebook.wakizashi"; ; str = "com.facebook.katana")
      return str;
  }

  public static final String c()
  {
    if (a());
    for (String str = "wakizashi"; ; str = "katana")
      return str;
  }

  public static final String d()
  {
    if (a());
    for (String str = "https://m.facebook.com/mobile_builds"; ; str = "https://market.android.com/details?id=com.facebook.katana")
      return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.base.BuildConstants
 * JD-Core Version:    0.6.0
 */