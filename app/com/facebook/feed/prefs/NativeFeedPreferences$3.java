package com.facebook.feed.prefs;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.feed.cache.PrefetchedFeedCache;
import com.facebook.orca.inject.FbInjector;

class NativeFeedPreferences$3
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if (!((Boolean)paramObject).booleanValue())
      ((PrefetchedFeedCache)NativeFeedPreferences.a(this.a).a(PrefetchedFeedCache.class)).a();
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.prefs.NativeFeedPreferences.3
 * JD-Core Version:    0.6.0
 */