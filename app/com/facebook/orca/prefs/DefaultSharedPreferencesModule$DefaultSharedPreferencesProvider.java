package com.facebook.orca.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class DefaultSharedPreferencesModule$DefaultSharedPreferencesProvider extends AbstractProvider<SharedPreferences>
{
  private DefaultSharedPreferencesModule$DefaultSharedPreferencesProvider(DefaultSharedPreferencesModule paramDefaultSharedPreferencesModule)
  {
  }

  public SharedPreferences a()
  {
    return PreferenceManager.getDefaultSharedPreferences((Context)b(Context.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.DefaultSharedPreferencesModule.DefaultSharedPreferencesProvider
 * JD-Core Version:    0.6.0
 */