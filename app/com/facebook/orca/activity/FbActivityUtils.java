package com.facebook.orca.activity;

import android.app.Activity;
import java.util.UUID;

public final class FbActivityUtils
{
  public static String a()
  {
    return UUID.randomUUID().toString();
  }

  public static String a(Activity paramActivity)
  {
    FbActivityish localFbActivityish = (FbActivityish)paramActivity;
    if (localFbActivityish != null);
    for (String str = localFbActivityish.e(); ; str = "")
      return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.FbActivityUtils
 * JD-Core Version:    0.6.0
 */