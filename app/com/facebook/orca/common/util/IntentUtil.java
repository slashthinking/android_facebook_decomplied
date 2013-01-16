package com.facebook.orca.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

public class IntentUtil
{
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if (paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 65536).size() > 0);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.IntentUtil
 * JD-Core Version:    0.6.0
 */