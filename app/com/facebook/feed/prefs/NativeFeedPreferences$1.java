package com.facebook.feed.prefs;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.orca.inject.FbInjector;

class NativeFeedPreferences$1
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if (!((Boolean)paramObject).booleanValue())
      ((NewsFeedCache)NativeFeedPreferences.a(this.a).a(NewsFeedCache.class)).a();
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.prefs.NativeFeedPreferences.1
 * JD-Core Version:    0.6.0
 */