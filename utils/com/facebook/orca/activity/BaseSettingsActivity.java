package com.facebook.orca.activity;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import com.facebook.annotations.ApplicationPreferences;
import com.facebook.annotations.LibraryPreferencesList;
import com.facebook.orca.inject.FbInjector;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

public class BaseSettingsActivity extends FbPreferenceActivity
{
  private void a(IProvidePreferences paramIProvidePreferences, PreferenceScreen paramPreferenceScreen)
  {
    Iterator localIterator = paramIProvidePreferences.a(this).iterator();
    while (localIterator.hasNext())
    {
      Preference localPreference = (Preference)localIterator.next();
      if (a(localPreference))
      {
        paramPreferenceScreen.addPreference(localPreference);
        b(localPreference);
      }
    }
  }

  private void a(Provider<Set<IProvidePreferences>> paramProvider, PreferenceScreen paramPreferenceScreen)
  {
    Iterator localIterator = ((Set)paramProvider.b()).iterator();
    while (localIterator.hasNext())
      a((IProvidePreferences)localIterator.next(), paramPreferenceScreen);
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = b();
    Provider localProvider1 = localFbInjector.b(IProvidePreferences.class, ApplicationPreferences.class);
    Provider localProvider2 = localFbInjector.d(IProvidePreferences.class, LibraryPreferencesList.class);
    PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
    a(localPreferenceScreen);
    a((IProvidePreferences)localProvider1.b(), localPreferenceScreen);
    a(localProvider2, localPreferenceScreen);
    b(localPreferenceScreen);
    setPreferenceScreen(localPreferenceScreen);
  }

  protected void a(PreferenceScreen paramPreferenceScreen)
  {
  }

  protected boolean a(Preference paramPreference)
  {
    return true;
  }

  protected void b(Preference paramPreference)
  {
  }

  protected void b(PreferenceScreen paramPreferenceScreen)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.BaseSettingsActivity
 * JD-Core Version:    0.6.2
 */