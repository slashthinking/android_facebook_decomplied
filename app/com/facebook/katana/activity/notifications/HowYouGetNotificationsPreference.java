package com.facebook.katana.activity.notifications;

import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.util.AttributeSet;

public class HowYouGetNotificationsPreference extends PreferenceCategory
{
  public HowYouGetNotificationsPreference(Context paramContext)
  {
    super(paramContext);
  }

  public HowYouGetNotificationsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public HowYouGetNotificationsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onAttachedToHierarchy(PreferenceManager paramPreferenceManager)
  {
    super.onAttachedToHierarchy(paramPreferenceManager);
    setTitle(2131363616);
    Preference localPreference1 = new Preference(getContext());
    localPreference1.setTitle(2131363618);
    addPreference(localPreference1);
    Preference localPreference2 = new Preference(getContext());
    localPreference2.setTitle(2131363619);
    addPreference(localPreference2);
    Preference localPreference3 = new Preference(getContext());
    localPreference3.setTitle(2131363620);
    addPreference(localPreference3);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.notifications.HowYouGetNotificationsPreference
 * JD-Core Version:    0.6.0
 */