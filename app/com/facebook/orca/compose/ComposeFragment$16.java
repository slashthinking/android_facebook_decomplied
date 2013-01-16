package com.facebook.orca.compose;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;

class ComposeFragment$16
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    OrcaSharedPreferences.Editor localEditor = ComposeFragment.v(this.a).b();
    localEditor.a(MessagesPrefKeys.r, true);
    localEditor.a();
    ComposeFragment.d(this.a, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeFragment.16
 * JD-Core Version:    0.6.0
 */