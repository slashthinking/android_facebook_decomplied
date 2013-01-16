package com.facebook.katana;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.base.BuildConstants;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.util.PlatformUtils;

public class Constants
{
  private static SharedPreferences a;

  static SharedPreferences a(Context paramContext)
  {
    if (a == null)
      a = PreferenceManager.getDefaultSharedPreferences(paramContext);
    return a;
  }

  public static boolean a()
  {
    if ((FacebookAffiliation.c()) && (BuildConstants.a()) && (!PlatformUtils.a()));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.Constants
 * JD-Core Version:    0.6.0
 */