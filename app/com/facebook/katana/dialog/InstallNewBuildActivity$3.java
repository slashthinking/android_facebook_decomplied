package com.facebook.katana.dialog;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class InstallNewBuildActivity$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.a)));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.dialog.InstallNewBuildActivity.3
 * JD-Core Version:    0.6.0
 */