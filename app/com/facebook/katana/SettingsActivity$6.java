package com.facebook.katana;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.orca.inject.FbInjector;

class SettingsActivity$6
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if (paramObject.equals("bookmarks"))
      ((BookmarkManager)FbInjector.a(this.a).a(BookmarkManager.class)).d();
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.6
 * JD-Core Version:    0.6.0
 */