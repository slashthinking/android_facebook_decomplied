package com.facebook.katana;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.facebook.content.SecureContextHelper;

class SettingsActivity$15 extends Thread
{
  public void run()
  {
    try
    {
      Thread.sleep(200L);
      Intent localIntent = this.b.getBaseContext().getPackageManager().getLaunchIntentForPackage(this.b.getBaseContext().getPackageName());
      localIntent.addFlags(335609856);
      this.a.a(localIntent, this.b);
      this.b.finish();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.15
 * JD-Core Version:    0.6.0
 */