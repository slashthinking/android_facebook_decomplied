package com.facebook.feed.prefs;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.common.util.Log;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.model.FeedType;
import com.facebook.orca.inject.FbInjector;

class NativeFeedPreferences$4
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    NewsFeedCache localNewsFeedCache = (NewsFeedCache)NativeFeedPreferences.a(this.a).a(NewsFeedCache.class);
    if ("all".equals(paramObject))
    {
      localNewsFeedCache.a();
      Log.c("Cache", "Cache: cleared all stories");
    }
    while (true)
    {
      return false;
      int i = localNewsFeedCache.a(FeedType.b, Integer.parseInt(paramObject.toString()));
      Log.c("Cache", "Cache: cleared " + i + "stories");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.prefs.NativeFeedPreferences.4
 * JD-Core Version:    0.6.0
 */