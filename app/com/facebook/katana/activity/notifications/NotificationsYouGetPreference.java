package com.facebook.katana.activity.notifications;

import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.util.AttributeSet;

public class NotificationsYouGetPreference extends PreferenceCategory
{
  public NotificationsYouGetPreference(Context paramContext)
  {
    super(paramContext);
  }

  public NotificationsYouGetPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NotificationsYouGetPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onAttachedToHierarchy(PreferenceManager paramPreferenceManager)
  {
    super.onAttachedToHierarchy(paramPreferenceManager);
    setTitle(2131363617);
    Preference localPreference1 = new Preference(getContext());
    localPreference1.setTitle(2131363621);
    addPreference(localPreference1);
    Preference localPreference2 = new Preference(getContext());
    localPreference2.setTitle(2131363622);
    addPreference(localPreference2);
    Preference localPreference3 = new Preference(getContext());
    localPreference3.setTitle(2131363623);
    addPreference(localPreference3);
    Preference localPreference4 = new Preference(getContext());
    localPreference4.setTitle(2131363624);
    addPreference(localPreference4);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.notifications.NotificationsYouGetPreference
 * JD-Core Version:    0.6.0
 */