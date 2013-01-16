package com.facebook.megaphone.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.facebook.megaphone.constants.MegaphoneConstants;

public class MegaphoneScreenLayout
{
  public static int a(Context paramContext)
  {
    int i;
    switch (paramContext.getResources().getDisplayMetrics().densityDpi)
    {
    default:
      i = MegaphoneConstants.a;
    case 240:
    case 160:
    case 120:
    }
    while (true)
    {
      return i;
      i = MegaphoneConstants.b;
      continue;
      i = MegaphoneConstants.c;
      continue;
      i = MegaphoneConstants.d;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.ui.MegaphoneScreenLayout
 * JD-Core Version:    0.6.2
 */