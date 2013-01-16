package com.facebook.orca.app;

import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.MessengerPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.OrcaSharedPreferencesImpl;

class OrcaDataManager$2
  implements Runnable
{
  public void run()
  {
    if (!OrcaDataManager.c(this.a).a(MessagesPrefKeys.g, false))
    {
      this.a.f();
      this.a.g();
      OrcaDataManager.d(this.a).a();
    }
    while (true)
    {
      return;
      OrcaSharedPreferences.Editor localEditor = OrcaDataManager.c(this.a).b();
      localEditor.a(MessengerPrefKeys.j, true);
      localEditor.a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.OrcaDataManager.2
 * JD-Core Version:    0.6.0
 */