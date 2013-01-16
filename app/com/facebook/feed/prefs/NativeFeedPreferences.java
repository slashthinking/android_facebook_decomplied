package com.facebook.feed.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import com.facebook.feed.common.FeedConstants;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaCheckBoxPreference;
import com.facebook.orca.prefs.OrcaEditTextPreference;
import com.facebook.orca.prefs.OrcaListPreference;
import com.facebook.orca.prefs.SharedPrefKeys;
import com.facebook.widget.UrlImage.LoadResolutionDuringScrollMode;

public class NativeFeedPreferences extends PreferenceCategory
{
  public NativeFeedPreferences(Context paramContext)
  {
    super(paramContext);
  }

  public NativeFeedPreferences(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NativeFeedPreferences(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private FbInjector a()
  {
    return FbInjector.a(getContext());
  }

  protected void onAttachedToHierarchy(PreferenceManager paramPreferenceManager)
  {
    super.onAttachedToHierarchy(paramPreferenceManager);
    Context localContext = getContext();
    setTitle("Native Feed - internal");
    OrcaCheckBoxPreference localOrcaCheckBoxPreference1 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference1.a(SharedPrefKeys.s);
    localOrcaCheckBoxPreference1.setTitle("ImageCache Bitmap Purgeable");
    localOrcaCheckBoxPreference1.setSummary("Load bitmaps on the native heap");
    localOrcaCheckBoxPreference1.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference1);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference2 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference2.a(FeedPrefKeys.j);
    localOrcaCheckBoxPreference2.setTitle("Warm Images");
    localOrcaCheckBoxPreference2.setSummary("Touch cached images from future stories to make sure they are decoded");
    localOrcaCheckBoxPreference2.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference2);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference3 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference3.a(FeedPrefKeys.k);
    localOrcaCheckBoxPreference3.setTitle("Prefetch Images");
    localOrcaCheckBoxPreference3.setSummary("Prefetch images from future stories");
    localOrcaCheckBoxPreference3.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference3);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference4 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference4.a(FeedPrefKeys.g);
    localOrcaCheckBoxPreference4.setTitle("Show secondary actions button for stories");
    localOrcaCheckBoxPreference4.setSummary("Show the button for feed stories which contains report, hide, save for later actions");
    localOrcaCheckBoxPreference4.setDefaultValue(Boolean.valueOf(false));
    addPreference(localOrcaCheckBoxPreference4);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference5 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference5.a(FeedPrefKeys.f);
    localOrcaCheckBoxPreference5.setTitle("Native Feed View Caching");
    localOrcaCheckBoxPreference5.setSummary("Will cache views in native feed");
    localOrcaCheckBoxPreference5.setDefaultValue(Boolean.valueOf(false));
    addPreference(localOrcaCheckBoxPreference5);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference6 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference6.a(FeedPrefKeys.h);
    localOrcaCheckBoxPreference6.setTitle("Native Feed View Caching During Scrolling");
    localOrcaCheckBoxPreference6.setSummary("Will prebuild views while scrolling instead of just when stopped");
    localOrcaCheckBoxPreference6.setDefaultValue(Boolean.valueOf(false));
    addPreference(localOrcaCheckBoxPreference6);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference7 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference7.a(FeedPrefKeys.c);
    localOrcaCheckBoxPreference7.setTitle("Native Feed Memory Cache");
    localOrcaCheckBoxPreference7.setSummary("The switch to trun on/off nnf memory cache");
    localOrcaCheckBoxPreference7.setDefaultValue(Boolean.valueOf(true));
    localOrcaCheckBoxPreference7.setOnPreferenceChangeListener(new NativeFeedPreferences.1(this));
    addPreference(localOrcaCheckBoxPreference7);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference8 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference8.a(FeedPrefKeys.d);
    localOrcaCheckBoxPreference8.setTitle("Native Feed Disk Cache");
    localOrcaCheckBoxPreference8.setSummary("The switch to turn on/off nnf disk cache");
    localOrcaCheckBoxPreference8.setDefaultValue(Boolean.valueOf(true));
    localOrcaCheckBoxPreference8.setOnPreferenceChangeListener(new NativeFeedPreferences.2(this));
    addPreference(localOrcaCheckBoxPreference8);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference9 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference9.a(FeedPrefKeys.e);
    localOrcaCheckBoxPreference9.setTitle("Background Prefetch of Stories");
    localOrcaCheckBoxPreference9.setSummary("The switch to turn on/off background story fetching");
    localOrcaCheckBoxPreference9.setDefaultValue(Boolean.valueOf(false));
    localOrcaCheckBoxPreference9.setOnPreferenceChangeListener(new NativeFeedPreferences.3(this));
    addPreference(localOrcaCheckBoxPreference9);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference10 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference10.a(FeedPrefKeys.b);
    localOrcaCheckBoxPreference10.setTitle("UFI Flyout in Native Feed");
    localOrcaCheckBoxPreference10.setSummary("Display Flyout in Native Newsfeed instead of permanent link");
    localOrcaCheckBoxPreference10.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference10);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference11 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference11.a(FeedPrefKeys.o);
    localOrcaCheckBoxPreference11.setTitle("Report Spam from Feed");
    localOrcaCheckBoxPreference11.setSummary("Display the spam reporting option in the story menu");
    localOrcaCheckBoxPreference11.setDefaultValue(Boolean.valueOf(false));
    addPreference(localOrcaCheckBoxPreference11);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference12 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference12.a(FeedPrefKeys.i);
    localOrcaCheckBoxPreference12.setTitle("Renderer: Images in Native Feed");
    localOrcaCheckBoxPreference12.setSummary("Enable/disable images in native feed");
    localOrcaCheckBoxPreference12.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference12);
    OrcaListPreference localOrcaListPreference1 = new OrcaListPreference(localContext);
    localOrcaListPreference1.setSummary("Image resolution at scrolling time");
    localOrcaListPreference1.setTitle("Image Resolution at Scroll Time");
    localOrcaListPreference1.setDialogTitle("Image Resolution at Scroll Time");
    localOrcaListPreference1.a(FeedPrefKeys.l);
    localOrcaListPreference1.setDefaultValue(FeedConstants.a);
    localOrcaListPreference1.setEntries(new String[] { "Full Resolution", "Low Resolution", "None" });
    String[] arrayOfString = new String[3];
    arrayOfString[0] = UrlImage.LoadResolutionDuringScrollMode.FULL_RES.toString();
    arrayOfString[1] = UrlImage.LoadResolutionDuringScrollMode.LOW_RES.toString();
    arrayOfString[2] = UrlImage.LoadResolutionDuringScrollMode.NONE.toString();
    localOrcaListPreference1.setEntryValues(arrayOfString);
    addPreference(localOrcaListPreference1);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference13 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference13.a(FeedPrefKeys.B);
    localOrcaCheckBoxPreference13.setTitle("Show Story Freshness");
    localOrcaCheckBoxPreference13.setSummary("Enable/Disable feed story background that represents story freshness");
    localOrcaCheckBoxPreference13.setDefaultValue(Boolean.valueOf(false));
    addPreference(localOrcaCheckBoxPreference13);
    Preference localPreference = new Preference(localContext);
    localPreference.setTitle("Renderer: Story Sections");
    localPreference.setSummary("Enable/disable story sections");
    localPreference.setIntent(new Intent(localContext, FeedRendererSettingsActivity.class));
    addPreference(localPreference);
    OrcaListPreference localOrcaListPreference2 = new OrcaListPreference(localContext);
    localOrcaListPreference2.setSummary("Clear stories from cache to see the scissors gap");
    localOrcaListPreference2.setTitle("Clear stories from cache");
    localOrcaListPreference2.setDialogTitle("Clear top stories");
    localOrcaListPreference2.a(FeedPrefKeys.m);
    localOrcaListPreference2.setEntries(new String[] { "at least 10", "at least 15", "at least 20", "everything" });
    localOrcaListPreference2.setEntryValues(new String[] { "10", "15", "20", "all" });
    localOrcaListPreference2.setDefaultValue("15");
    localOrcaListPreference2.setOnPreferenceChangeListener(new NativeFeedPreferences.4(this));
    addPreference(localOrcaListPreference2);
    OrcaCheckBoxPreference localOrcaCheckBoxPreference14 = new OrcaCheckBoxPreference(localContext);
    localOrcaCheckBoxPreference14.a(FeedPrefKeys.p);
    localOrcaCheckBoxPreference14.setTitle("Enable Custom Physics in News Feed");
    localOrcaCheckBoxPreference14.setSummary("Enable/disable custom physics (friction, velocity scale) in native news feed");
    localOrcaCheckBoxPreference14.setDefaultValue(Boolean.valueOf(true));
    addPreference(localOrcaCheckBoxPreference14);
    OrcaEditTextPreference localOrcaEditTextPreference1 = new OrcaEditTextPreference(localContext);
    localOrcaEditTextPreference1.a(FeedPrefKeys.q);
    localOrcaEditTextPreference1.setTitle("ListView Friction");
    localOrcaEditTextPreference1.setSummary("Android default is 0.015. We default it to 0.005.");
    localOrcaEditTextPreference1.setDefaultValue(String.valueOf(0.005F));
    addPreference(localOrcaEditTextPreference1);
    OrcaEditTextPreference localOrcaEditTextPreference2 = new OrcaEditTextPreference(localContext);
    localOrcaEditTextPreference2.a(FeedPrefKeys.r);
    localOrcaEditTextPreference2.setTitle("ListView Velocity Scale");
    localOrcaEditTextPreference2.setSummary("Android default is 1.0. Ours is as well.");
    localOrcaEditTextPreference2.setDefaultValue(String.valueOf(1.0F));
    addPreference(localOrcaEditTextPreference2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.prefs.NativeFeedPreferences
 * JD-Core Version:    0.6.0
 */