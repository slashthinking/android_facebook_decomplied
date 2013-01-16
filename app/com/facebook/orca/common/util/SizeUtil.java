package com.facebook.orca.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class SizeUtil
{
  public static int a(Context paramContext)
  {
    return a(paramContext, 25.0F);
  }

  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(0.5F + paramFloat * paramContext.getResources().getDisplayMetrics().density);
  }

  public static int a(Resources paramResources, float paramFloat)
  {
    return (int)(0.5F + paramFloat * paramResources.getDisplayMetrics().density);
  }

  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(0.5F + paramFloat * paramContext.getResources().getDisplayMetrics().scaledDensity);
  }

  public static int b(Resources paramResources, float paramFloat)
  {
    return (int)(0.5F + paramFloat * paramResources.getDisplayMetrics().scaledDensity);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.SizeUtil
 * JD-Core Version:    0.6.0
 */