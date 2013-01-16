package com.facebook.katana.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.facebook.katana.activity.findfriends.FriendFinderActivity;

class GrowthUtils$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent(this.a, FriendFinderActivity.class);
    this.a.startActivity(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.GrowthUtils.2
 * JD-Core Version:    0.6.0
 */