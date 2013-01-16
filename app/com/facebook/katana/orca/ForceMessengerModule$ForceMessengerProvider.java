package com.facebook.katana.orca;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class ForceMessengerModule$ForceMessengerProvider extends AbstractProvider<ForceMessenger>
{
  private ForceMessengerModule$ForceMessengerProvider(ForceMessengerModule paramForceMessengerModule)
  {
  }

  public ForceMessenger a()
  {
    return new ForceMessenger((Context)b(Context.class, FromApplication.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.ForceMessengerModule.ForceMessengerProvider
 * JD-Core Version:    0.6.0
 */