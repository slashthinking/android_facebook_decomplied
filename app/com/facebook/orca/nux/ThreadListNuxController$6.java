package com.facebook.orca.nux;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;

class ThreadListNuxController$6
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ThreadListNuxController.f(this.a).b().a(MessagesPrefKeys.g, true).a();
    ThreadListNuxController.g(this.a).a();
    ThreadListNuxController.h(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.ThreadListNuxController.6
 * JD-Core Version:    0.6.0
 */