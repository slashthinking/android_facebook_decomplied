package com.facebook.katana.orca;

import android.app.Application;
import android.content.SharedPreferences;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidMessengerAppModule$DefaultSharedPreferencesProvider extends AbstractProvider<SharedPreferences>
{
  private FbandroidMessengerAppModule$DefaultSharedPreferencesProvider(FbandroidMessengerAppModule paramFbandroidMessengerAppModule)
  {
  }

  public SharedPreferences a()
  {
    return FbandroidMessengerAppModule.a(this.a).getSharedPreferences("com.facebook.orca_preferences", 0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessengerAppModule.DefaultSharedPreferencesProvider
 * JD-Core Version:    0.6.0
 */