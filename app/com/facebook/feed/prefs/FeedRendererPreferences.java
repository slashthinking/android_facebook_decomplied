package com.facebook.feed.prefs;

import android.content.Context;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import com.facebook.orca.prefs.OrcaCheckBoxPreference;

public class FeedRendererPreferences extends PreferenceCategory
{
  public FeedRendererPreferences(Context paramContext)
  {
    super(paramContext);
  }

  public FeedRendererPreferences(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public FeedRendererPreferences(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onAttachedToHierarchy(PreferenceManager paramPreferenceManager)
  {
    super.onAttachedToHierarchy(paramPreferenceManager);
    setTitle("Feed Renderer Options");
    Context localContext = getContext();
    OrcaCheckBoxPreference localOrcaCheckBoxPreference1 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference1.a(FeedPrefKeys.t);
    localOrcaCheckBoxPreference1.setTitle("Header: render title");
    localOrcaCheckBoxPreference1.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference1);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference2 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference2.a(FeedPrefKeys.u);
    localOrcaCheckBoxPreference2.setTitle("Header: render story info");
    localOrcaCheckBoxPreference2.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference2);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference3 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference3.a(FeedPrefKeys.v);
    localOrcaCheckBoxPreference3.setTitle("Story Message");
    localOrcaCheckBoxPreference3.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference3);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference4 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference4.a(FeedPrefKeys.w);
    localOrcaCheckBoxPreference4.setTitle("Story Attachments");
    localOrcaCheckBoxPreference4.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference4);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference5 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference5.a(FeedPrefKeys.x);
    localOrcaCheckBoxPreference5.setTitle("Story Location Map");
    localOrcaCheckBoxPreference5.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference5);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference6 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference6.a(FeedPrefKeys.y);
    localOrcaCheckBoxPreference6.setTitle("Story: attached story");
    localOrcaCheckBoxPreference6.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference6);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference7 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference7.a(FeedPrefKeys.z);
    localOrcaCheckBoxPreference7.setTitle("Story: substories");
    localOrcaCheckBoxPreference7.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference7);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference8 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference8.a(FeedPrefKeys.A);
    localOrcaCheckBoxPreference8.setTitle("Story: render footer");
    localOrcaCheckBoxPreference8.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference8);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.prefs.FeedRendererPreferences
 * JD-Core Version:    0.6.0
 */