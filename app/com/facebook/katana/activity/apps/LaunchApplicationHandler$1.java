package com.facebook.katana.activity.apps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.katana.NativeThirdPartyUriHelper;

class LaunchApplicationHandler$1
  implements Runnable
{
  public void run()
  {
    Intent localIntent = NativeThirdPartyUriHelper.a(this.a, this.b);
    if (localIntent != null)
    {
      NativeThirdPartyUriHelper.a(this.a, localIntent);
      this.a.startActivity(localIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.apps.LaunchApplicationHandler.1
 * JD-Core Version:    0.6.0
 */