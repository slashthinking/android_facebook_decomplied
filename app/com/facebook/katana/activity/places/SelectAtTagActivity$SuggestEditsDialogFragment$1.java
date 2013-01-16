package com.facebook.katana.activity.places;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.AlertDialogs.MenuOption;

class SelectAtTagActivity$SuggestEditsDialogFragment$1 extends AlertDialogs.MenuOption
{
  public int a()
  {
    return 2131363345;
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent(this.b.n(), SuggestPlaceInfoActivity.class);
    localIntent.putExtra("android.intent.extra.SUBJECT", this.a);
    this.b.n().startActivityForResult(localIntent, 2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectAtTagActivity.SuggestEditsDialogFragment.1
 * JD-Core Version:    0.6.0
 */