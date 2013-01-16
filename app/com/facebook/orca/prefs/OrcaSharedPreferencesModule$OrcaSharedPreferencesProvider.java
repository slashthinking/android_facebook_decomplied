package com.facebook.orca.prefs;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.orca.annotations.DefaultSharedPreferences;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class OrcaSharedPreferencesModule$OrcaSharedPreferencesProvider extends AbstractProvider<OrcaSharedPreferencesImpl>
{
  private OrcaSharedPreferencesModule$OrcaSharedPreferencesProvider(OrcaSharedPreferencesModule paramOrcaSharedPreferencesModule)
  {
  }

  public OrcaSharedPreferencesImpl a()
  {
    return new OrcaSharedPreferencesImpl((Context)b(Context.class, FromApplication.class), (ContentResolver)b(ContentResolver.class, FromApplication.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (SharedPreferences)b(SharedPreferences.class, DefaultSharedPreferences.class), (OrcaSharedPreferencesContract)b(OrcaSharedPreferencesContract.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesModule.OrcaSharedPreferencesProvider
 * JD-Core Version:    0.6.0
 */