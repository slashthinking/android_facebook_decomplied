package com.facebook.feed.prefs;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.feed.db.NewsFeedDatabaseSupplier;
import com.facebook.orca.inject.FbInjector;

class NativeFeedPreferences$2
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if (!((Boolean)paramObject).booleanValue())
      ((NewsFeedDatabaseSupplier)NativeFeedPreferences.a(this.a).a(NewsFeedDatabaseSupplier.class)).b();
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.prefs.NativeFeedPreferences.2
 * JD-Core Version:    0.6.0
 */