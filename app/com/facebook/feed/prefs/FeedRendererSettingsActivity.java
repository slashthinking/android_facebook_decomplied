package com.facebook.feed.prefs;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import com.facebook.orca.activity.FbPreferenceActivity;

public class FeedRendererSettingsActivity extends FbPreferenceActivity
{
  private PreferenceScreen a()
  {
    PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
    localPreferenceScreen.addPreference(new FeedRendererPreferences(this));
    return localPreferenceScreen;
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setPreferenceScreen(a());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.prefs.FeedRendererSettingsActivity
 * JD-Core Version:    0.6.0
 */