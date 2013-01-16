package com.facebook.katana.dialog;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.katana.service.autoupdate.AutoUpdateNotifier;

class InstallNewBuildActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Intent localIntent = AutoUpdateNotifier.a(this.a);
    this.b.startActivity(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.dialog.InstallNewBuildActivity.1
 * JD-Core Version:    0.6.0
 */