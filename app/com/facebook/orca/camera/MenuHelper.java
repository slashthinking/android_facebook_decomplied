package com.facebook.orca.camera;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import android.widget.Toast;
import java.io.File;

public class MenuHelper
{
  private static final Class<?> a = MenuHelper.class;

  public static int a()
  {
    int i;
    try
    {
      if (!ImageManager.a())
      {
        i = -1;
      }
      else
      {
        StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().toString());
        float f = localStatFs.getAvailableBlocks();
        int j = localStatFs.getBlockSize();
        i = (int)(f * j / 1500000.0F);
      }
    }
    catch (Exception localException)
    {
      i = -2;
    }
    return i;
  }

  public static void a(Activity paramActivity)
  {
    a(paramActivity, a());
  }

  public static void a(Activity paramActivity, int paramInt)
  {
    String str;
    if (paramInt == -1)
      if (Environment.getExternalStorageState() == "checking")
        str = paramActivity.getString(2131362635);
    while (true)
    {
      if (str != null)
        Toast.makeText(paramActivity, str, 5000).show();
      return;
      str = paramActivity.getString(2131362636);
      continue;
      str = null;
      if (paramInt >= 1)
        continue;
      str = paramActivity.getString(2131362637);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.MenuHelper
 * JD-Core Version:    0.6.0
 */