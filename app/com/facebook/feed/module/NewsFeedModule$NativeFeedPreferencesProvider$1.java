package com.facebook.feed.module;

import android.content.Context;
import android.preference.Preference;
import com.facebook.feed.prefs.NativeFeedPreferences;
import com.facebook.orca.activity.IProvidePreferences;
import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.List;

class NewsFeedModule$NativeFeedPreferencesProvider$1
  implements IProvidePreferences
{
  public List<Preference> a(Context paramContext)
  {
    LinkedList localLinkedList = Lists.b();
    localLinkedList.add(new NativeFeedPreferences(paramContext));
    return localLinkedList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NativeFeedPreferencesProvider.1
 * JD-Core Version:    0.6.0
 */