package com.facebook.katana;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.RingtonePreference;
import android.provider.Settings.System;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.appcenter.prefs.AppCenterPrefKeys;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.NetAccessLogger;
import com.facebook.content.SecureContextHelper;
import com.facebook.dash.annotation.ForDash;
import com.facebook.diagnostics.FPSLoggingPreference;
import com.facebook.diagnostics.FPSPreference;
import com.facebook.feed.prefs.NativeFeedPreferences;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.activity.photos.PhotosTabActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore.Expirer;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.features.Gatekeeper.Expirer;
import com.facebook.katana.features.bugreporter.Fb4aBugReporterConfig;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.katana.platform.FacebookAuthenticationService;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.service.vault.VaultHelpers;
import com.facebook.katana.settings.KeyValueBackedManager.EditTextPreference;
import com.facebook.katana.settings.RolloutSetting;
import com.facebook.katana.util.PlatformUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.orca.activity.FbPreferenceActivity;
import com.facebook.orca.activity.IProvidePreferences;
import com.facebook.orca.annotations.IsMobileOnlineAvailabilityPermitted;
import com.facebook.orca.config.NetworkConfigUpdater;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.ProvisioningException;
import com.facebook.orca.prefs.CheckSslCertsPreference;
import com.facebook.orca.prefs.HttpProxyPreference;
import com.facebook.orca.prefs.InternalHttpPrefKeys;
import com.facebook.orca.prefs.LocationServicesPreference;
import com.facebook.orca.prefs.MobileOnlineAvailabilityPreference;
import com.facebook.orca.prefs.NotificationEnabledPreference;
import com.facebook.orca.prefs.OrcaCheckBoxPreference;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SettingsActivity extends FbPreferenceActivity
  implements AnalyticsActivity, NotNewNavEnabled
{
  public static final String a = Settings.System.DEFAULT_NOTIFICATION_URI.toString();
  public static final String[] b = { "notif_wall_posts", "notif_friend_requests", "notif_friend_confirmations", "notif_photo_tags", "notif_event_invites", "notif_comments", "notif_place_tags", "notif_nearby_friends", "notif_app_requests", "notif_groups" };
  public static final String c = InternalHttpPrefKeys.f.a();
  private static boolean f = false;
  protected boolean d;
  private NetworkConfigUpdater e;
  private InteractionLogger g;

  private CheckBoxPreference a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(paramString);
    localCheckBoxPreference.setTitle(paramInt1);
    if (paramInt2 > 0)
      localCheckBoxPreference.setSummary(paramInt2);
    if (paramInt3 > 0)
      localCheckBoxPreference.setSummaryOff(paramInt3);
    if (paramInt4 > 0)
      localCheckBoxPreference.setSummaryOn(paramInt4);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(paramBoolean));
    a(localCheckBoxPreference);
    return localCheckBoxPreference;
  }

  private CheckBoxPreference a(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return a(paramString, paramInt1, 0, paramInt2, paramInt3, paramBoolean);
  }

  private CheckBoxPreference a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(paramString, paramInt1, paramInt2, 0, 0, paramBoolean);
  }

  private CheckBoxPreference a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, 0, 2131363179, 2131363180, paramBoolean);
  }

  private String a(CharSequence[] paramArrayOfCharSequence1, CharSequence[] paramArrayOfCharSequence2, String paramString)
  {
    int i = 0;
    if (i < paramArrayOfCharSequence1.length)
      if (!paramArrayOfCharSequence1[i].toString().equals(paramString));
    for (String str = paramArrayOfCharSequence2[i].toString(); ; str = null)
    {
      return str;
      i++;
      break;
    }
  }

  private void a(Preference paramPreference)
  {
    paramPreference.setOnPreferenceChangeListener(new SettingsActivity.17(this));
  }

  private void a(Preference paramPreference, Object paramObject)
  {
    this.g.a(new SettingsActivity.SettingChangedEvent(this, paramPreference.getKey(), paramObject));
  }

  private void a(PreferenceCategory paramPreferenceCategory)
  {
    paramPreferenceCategory.addPreference(a("vibrate", 2131363168, 2131363167, true));
    paramPreferenceCategory.addPreference(a("use_led", 2131363166, 2131363165, true));
    RingtonePreference localRingtonePreference = new RingtonePreference(this);
    localRingtonePreference.setRingtoneType(2);
    localRingtonePreference.setKey("ringtone");
    localRingtonePreference.setShowSilent(true);
    localRingtonePreference.setShowDefault(true);
    localRingtonePreference.setTitle(2131363163);
    localRingtonePreference.setSummary(2131363162);
    localRingtonePreference.setDefaultValue(a);
    a(localRingtonePreference);
    paramPreferenceCategory.addPreference(localRingtonePreference);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    Boolean localBoolean1 = Gatekeeper.a(this, "android_push_notifications_settings_migration");
    int j;
    Intent localIntent;
    if (Boolean.TRUE.equals(localBoolean1))
    {
      Boolean localBoolean4 = Boolean.valueOf(localSharedPreferences.getBoolean(FbandroidPrefKeys.n.toString(), false));
      Boolean localBoolean5 = Boolean.valueOf(false);
      String[] arrayOfString = b;
      int i = arrayOfString.length;
      j = 0;
      if (j < i)
      {
        if (localSharedPreferences.contains(arrayOfString[j]))
          localBoolean5 = Boolean.valueOf(true);
      }
      else
      {
        if ((!localBoolean4.booleanValue()) && (localBoolean5.booleanValue()))
          break label331;
        localIntent = IntentUriHandler.a(this, "fb://notifications_settings");
        label217: Preference localPreference = new Preference(this);
        localPreference.setTitle(2131363020);
        localPreference.setSummary(2131363021);
        localPreference.setIntent(localIntent);
        paramPreferenceCategory.addPreference(localPreference);
      }
    }
    while (true)
    {
      Boolean localBoolean2 = Boolean.valueOf(localSharedPreferences.getBoolean("continuous_import", false));
      Boolean localBoolean3 = Gatekeeper.a(this, "android_continuous_import");
      if (((Boolean.TRUE.equals(localBoolean2)) && (localBoolean3 == null)) || (Boolean.TRUE.equals(localBoolean3)))
        paramPreferenceCategory.addPreference(a("continuous_import", 2131363177, 2131363176, false));
      return;
      j++;
      break;
      label331: localIntent = IntentUriHandler.a(this, "fb://notifications_settings_migration");
      break label217;
      paramPreferenceCategory.addPreference(a("notif_wall_posts", 2131363169, true));
      NotificationEnabledPreference localNotificationEnabledPreference = new NotificationEnabledPreference(this);
      localNotificationEnabledPreference.setTitle(2131363155);
      paramPreferenceCategory.addPreference(localNotificationEnabledPreference);
      paramPreferenceCategory.addPreference(a("notif_comments", 2131363172, true));
      paramPreferenceCategory.addPreference(a("notif_friend_requests", 2131363153, true));
      paramPreferenceCategory.addPreference(a("notif_friend_confirmations", 2131363170, true));
      paramPreferenceCategory.addPreference(a("notif_photo_tags", 2131363171, true));
      paramPreferenceCategory.addPreference(a("notif_event_invites", 2131363152, true));
      paramPreferenceCategory.addPreference(a("notif_nearby_friends", 2131363173, true));
      paramPreferenceCategory.addPreference(a("notif_app_requests", 2131363175, true));
      paramPreferenceCategory.addPreference(a("notif_groups", 2131363174, true));
    }
  }

  private void a(AppSession paramAppSession, Preference paramPreference)
  {
    if (paramAppSession == null);
    while (true)
    {
      return;
      String str = paramAppSession.b().username;
      boolean bool1 = FacebookAuthenticationService.d(this, str);
      boolean bool2 = FacebookAuthenticationService.c(this, str);
      if (bool1)
      {
        if (bool2)
        {
          paramPreference.setSummary(2131363217);
          continue;
        }
        paramPreference.setSummary(2131363219);
        continue;
      }
      paramPreference.setSummary(2131363213);
    }
  }

  private void a(String paramString)
  {
    Toast localToast = Toast.makeText(this, paramString, 0);
    SettingsActivity.15 local15 = new SettingsActivity.15(this, (SecureContextHelper)b().a(SecureContextHelper.class));
    localToast.show();
    local15.start();
  }

  public static boolean a(Context paramContext)
  {
    boolean bool1 = BuildConstants.a();
    boolean bool2 = false;
    if (!bool1);
    while (true)
    {
      return bool2;
      if (f)
      {
        bool2 = true;
        continue;
      }
      f = Constants.a(paramContext).getBoolean("do_not_crash", false);
      bool2 = f;
    }
  }

  private CharSequence[] a(Map<String, ManagedDataStore.Expirer> paramMap, String paramString)
  {
    CharSequence[] arrayOfCharSequence = new CharSequence[paramMap.size()];
    Iterator localIterator = paramMap.keySet().iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      String str = (String)localIterator.next();
      j = i + 1;
      arrayOfCharSequence[i] = (paramString + str);
    }
    return arrayOfCharSequence;
  }

  private int b(String paramString)
  {
    int i;
    if (paramString.equals("MOBILE_RADIO"))
      i = 2131363581;
    while (true)
    {
      return i;
      if (paramString.equals("WIFI_ONLY"))
      {
        i = 2131363582;
        continue;
      }
      i = 2131363583;
    }
  }

  private PreferenceScreen c()
  {
    PreferenceScreen localPreferenceScreen1 = getPreferenceManager().createPreferenceScreen(this);
    PreferenceCategory localPreferenceCategory1 = new PreferenceCategory(this);
    localPreferenceCategory1.setTitle(2131363154);
    localPreferenceScreen1.addPreference(localPreferenceCategory1);
    FbInjector localFbInjector = b();
    if (((Boolean)localFbInjector.a(Boolean.class, IsMobileOnlineAvailabilityPermitted.class)).booleanValue())
      localPreferenceCategory1.addPreference(new MobileOnlineAvailabilityPreference(this));
    ListPreference localListPreference1 = new ListPreference(this);
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(getString(2131363147));
    localArrayList1.add(getString(2131363148));
    localArrayList1.add(getString(2131363149));
    localArrayList1.add(getString(2131363150));
    localArrayList1.add(getString(2131363151));
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add("30");
    localArrayList2.add("60");
    localArrayList2.add("120");
    localArrayList2.add("240");
    localArrayList2.add("0");
    if (FacebookAffiliation.c())
    {
      localArrayList1.add("Every minute (beta-only option)");
      localArrayList2.add("1");
    }
    CharSequence[] arrayOfCharSequence1 = (CharSequence[])localArrayList1.toArray(new CharSequence[localArrayList1.size()]);
    CharSequence[] arrayOfCharSequence2 = (CharSequence[])localArrayList2.toArray(new CharSequence[localArrayList2.size()]);
    localListPreference1.setEntries(arrayOfCharSequence1);
    localListPreference1.setEntryValues(arrayOfCharSequence2);
    localListPreference1.setDefaultValue(arrayOfCharSequence2[1]);
    localListPreference1.setDialogTitle(2131363161);
    localListPreference1.setKey("polling_interval");
    localListPreference1.setTitle(2131363161);
    localListPreference1.setSummary(a(arrayOfCharSequence2, arrayOfCharSequence1, PreferenceManager.getDefaultSharedPreferences(this).getString("polling_interval", arrayOfCharSequence2[1].toString())));
    localPreferenceCategory1.addPreference(localListPreference1);
    localListPreference1.setOnPreferenceChangeListener(new SettingsActivity.1(this, arrayOfCharSequence2, arrayOfCharSequence1));
    PackageManager localPackageManager = getPackageManager();
    if ((localPackageManager.hasSystemFeature("android.hardware.location.gps")) || (localPackageManager.hasSystemFeature("android.hardware.location.network")))
    {
      LocationServicesPreference localLocationServicesPreference = new LocationServicesPreference(this);
      localLocationServicesPreference.setTitle(2131363178);
      localPreferenceCategory1.addPreference(localLocationServicesPreference);
    }
    if (VaultHelpers.a(this))
    {
      if (!VaultHelpers.f(this))
        break label679;
      PreferenceScreen localPreferenceScreen3 = getPreferenceManager().createPreferenceScreen(this);
      Intent localIntent = new Intent(this, PhotosTabActivity.class);
      localIntent.putExtra("tab_to_show", "sync");
      localIntent.putExtra("nux_ref", "pref");
      localPreferenceScreen3.setTitle(2131363580);
      localPreferenceScreen3.setSummary(2131363583);
      localPreferenceScreen3.setIntent(localIntent);
      localPreferenceCategory1.addPreference(localPreferenceScreen3);
    }
    while (true)
    {
      SettingsActivity.DynamicPreferenceCategory localDynamicPreferenceCategory = new SettingsActivity.DynamicPreferenceCategory(this);
      localDynamicPreferenceCategory.setTitle(2131363156);
      localPreferenceScreen1.addPreference(localDynamicPreferenceCategory);
      CheckBoxPreference localCheckBoxPreference1 = a("notif", 2131363159, 2131363158, 2131363157, true);
      localDynamicPreferenceCategory.addPreference(localCheckBoxPreference1);
      a(localDynamicPreferenceCategory);
      localCheckBoxPreference1.setOnPreferenceChangeListener(new SettingsActivity.3(this, localListPreference1, localDynamicPreferenceCategory));
      localDynamicPreferenceCategory.setEnabled(localCheckBoxPreference1.isChecked());
      if (Boolean.TRUE.equals(Gatekeeper.a(this, "lolcats_viewer")))
        try
        {
          localIProvidePreferences = (IProvidePreferences)localFbInjector.a(IProvidePreferences.class, ForDash.class);
          if (localIProvidePreferences != null)
          {
            Iterator localIterator2 = localIProvidePreferences.a(this).iterator();
            while (localIterator2.hasNext())
            {
              localPreferenceScreen1.addPreference((Preference)localIterator2.next());
              continue;
              label679: ListPreference localListPreference7 = new ListPreference(this);
              ArrayList localArrayList7 = new ArrayList();
              localArrayList7.add(getString(2131363581));
              localArrayList7.add(getString(2131363582));
              localArrayList7.add(getString(2131363583));
              ArrayList localArrayList8 = new ArrayList();
              localArrayList8.add("MOBILE_RADIO");
              localArrayList8.add("WIFI_ONLY");
              localArrayList8.add("OFF");
              String str3 = UserValuesManager.j(this);
              c(str3);
              localListPreference7.setEntries((CharSequence[])localArrayList7.toArray(new CharSequence[localArrayList7.size()]));
              localListPreference7.setEntryValues((CharSequence[])localArrayList8.toArray(new CharSequence[localArrayList8.size()]));
              localListPreference7.setDefaultValue(str3);
              localListPreference7.setKey("vault_sync_mode");
              localListPreference7.setDialogTitle(2131363580);
              localListPreference7.setTitle(2131363580);
              localListPreference7.setSummary(b(str3));
              localListPreference7.setOnPreferenceChangeListener(new SettingsActivity.2(this));
              localPreferenceCategory1.addPreference(localListPreference7);
            }
          }
        }
        catch (ProvisioningException localProvisioningException)
        {
          while (true)
            IProvidePreferences localIProvidePreferences = null;
        }
    }
    if ((PlatformUtils.a(this)) || (FacebookAffiliation.c(this)) || (FacebookAffiliation.b()))
    {
      PreferenceCategory localPreferenceCategory2 = new PreferenceCategory(this);
      localPreferenceCategory2.setTitle(2131363160);
      localPreferenceScreen1.addPreference(localPreferenceCategory2);
      if (PlatformUtils.a(this))
      {
        AppSession localAppSession = AppSession.a(this, false);
        if (localAppSession != null)
        {
          PreferenceScreen localPreferenceScreen2 = getPreferenceManager().createPreferenceScreen(this);
          localPreferenceScreen2.setKey("sync_contacts");
          localPreferenceScreen2.setTitle(2131363164);
          a(localAppSession, localPreferenceScreen2);
          localPreferenceScreen2.setIntent(new Intent(this, SyncContactsChangeActivity.class));
          localPreferenceCategory2.addPreference(localPreferenceScreen2);
        }
      }
      if ((FacebookAffiliation.c(this)) || (FacebookAffiliation.b()))
      {
        localPreferenceScreen1.addPreference(new NativeFeedPreferences(this));
        OrcaCheckBoxPreference localOrcaCheckBoxPreference1 = new OrcaCheckBoxPreference(this);
        OrcaSharedPreferences localOrcaSharedPreferences = (OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class);
        KeyValueBackedManager.EditTextPreference localEditTextPreference = new KeyValueBackedManager.EditTextPreference(this, "sandbox", "facebook.com");
        CheckSslCertsPreference localCheckSslCertsPreference = new CheckSslCertsPreference(this);
        ListPreference localListPreference2 = new ListPreference(this);
        OrcaCheckBoxPreference localOrcaCheckBoxPreference2 = new OrcaCheckBoxPreference(this);
        OrcaCheckBoxPreference localOrcaCheckBoxPreference3 = new OrcaCheckBoxPreference(this);
        new OrcaCheckBoxPreference(this);
        OrcaCheckBoxPreference localOrcaCheckBoxPreference4 = new OrcaCheckBoxPreference(this);
        OrcaCheckBoxPreference localOrcaCheckBoxPreference5 = new OrcaCheckBoxPreference(this);
        OrcaCheckBoxPreference localOrcaCheckBoxPreference6 = new OrcaCheckBoxPreference(this);
        OrcaCheckBoxPreference localOrcaCheckBoxPreference7 = new OrcaCheckBoxPreference(this);
        ListPreference localListPreference3 = new ListPreference(this);
        ListPreference localListPreference4 = new ListPreference(this);
        localOrcaCheckBoxPreference1.a(FbandroidPrefKeys.h);
        localOrcaCheckBoxPreference1.setTitle("Enable Faceweb News Feed");
        localOrcaCheckBoxPreference1.setSummary("Default to Faceweb feed / permalinks instead of Native");
        localOrcaCheckBoxPreference1.setDefaultValue(Boolean.valueOf(false));
        localPreferenceCategory2.addPreference(localOrcaCheckBoxPreference1);
        localEditTextPreference.setTitle("Sandbox");
        localEditTextPreference.setSummary("e.g., beta, prod, your-unix-name.sb, your-unix-name.devrsXXX, blank=facebook.com");
        localEditTextPreference.setDialogTitle("Sandbox");
        localEditTextPreference.getEditText().setHint("e.g., beta, latest, intern, prod, dev, facebook.com");
        localEditTextPreference.setOnPreferenceChangeListener(new SettingsActivity.4(this, localCheckSslCertsPreference, localListPreference3));
        localPreferenceCategory2.addPreference(localEditTextPreference);
        localPreferenceCategory2.addPreference(localCheckSslCertsPreference);
        localOrcaCheckBoxPreference2.a(FbandroidPrefKeys.b);
        localOrcaCheckBoxPreference2.setTitle("Native Friend Requests");
        localOrcaCheckBoxPreference2.setSummary("Will open the friends requests in native");
        localOrcaCheckBoxPreference2.setDefaultValue(Boolean.valueOf(true));
        localPreferenceCategory2.addPreference(localOrcaCheckBoxPreference2);
        localOrcaCheckBoxPreference4.a(FbandroidPrefKeys.d);
        localOrcaCheckBoxPreference4.setTitle("Native Search");
        localOrcaCheckBoxPreference4.setSummary("Will open search in native");
        localOrcaCheckBoxPreference4.setDefaultValue(Boolean.valueOf(true));
        localPreferenceCategory2.addPreference(localOrcaCheckBoxPreference4);
        localOrcaCheckBoxPreference5.a(FbandroidPrefKeys.c);
        localOrcaCheckBoxPreference5.setTitle("Fullscreen Jewels");
        localOrcaCheckBoxPreference5.setSummary("Will open friend request, message, and notif jewels fullscreen");
        localOrcaCheckBoxPreference5.setDefaultValue(Boolean.valueOf(true));
        localOrcaCheckBoxPreference5.setOnPreferenceChangeListener(new SettingsActivity.5(this));
        localPreferenceCategory2.addPreference(localOrcaCheckBoxPreference5);
        localOrcaCheckBoxPreference6.a(SharedPrefKeys.w);
        localOrcaCheckBoxPreference6.setTitle("New Photo Gallery");
        localOrcaCheckBoxPreference6.setSummary("Use the new photo gallery in NNF and Multipicker");
        localOrcaCheckBoxPreference6.setDefaultValue(Boolean.valueOf(false));
        localPreferenceCategory2.addPreference(localOrcaCheckBoxPreference6);
        localOrcaCheckBoxPreference7.a(SharedPrefKeys.x);
        localOrcaCheckBoxPreference7.setTitle("Face Recognition Prototype");
        localOrcaCheckBoxPreference7.setSummary("Enable prototyped facial recognition flows");
        localOrcaCheckBoxPreference7.setDefaultValue(Boolean.valueOf(false));
        localPreferenceCategory2.addPreference(localOrcaCheckBoxPreference7);
        localOrcaCheckBoxPreference3.a(AppCenterPrefKeys.b);
        localOrcaCheckBoxPreference3.setTitle("Native App Center");
        localOrcaCheckBoxPreference3.setSummary("Will open the App Center in native");
        localOrcaCheckBoxPreference3.setDefaultValue(Boolean.valueOf(false));
        localPreferenceCategory2.addPreference(localOrcaCheckBoxPreference3);
        localListPreference2.setEntries(new CharSequence[] { "Reload Bookmarks" });
        localListPreference2.setEntryValues(new CharSequence[] { "bookmarks" });
        localListPreference2.setDialogTitle("Bookmarks menu");
        localListPreference2.setTitle("Bookmarks menu control");
        localListPreference2.setSummary("Reloads Bookmarks navigation data");
        localListPreference2.setPositiveButtonText("Reload");
        localListPreference2.setNegativeButtonText("Cancel");
        localListPreference2.setKey("navbar");
        localListPreference2.setOnPreferenceChangeListener(new SettingsActivity.6(this));
        localPreferenceCategory2.addPreference(localListPreference2);
        localListPreference3.setEntries(new CharSequence[] { "Clear cookies", "Clear cache" });
        localListPreference3.setEntryValues(new CharSequence[] { "cookies", "cache" });
        localListPreference3.setDialogTitle("Reset webviews");
        localListPreference3.setTitle("Webview control");
        localListPreference3.setSummary("Clears webview cookies or caches");
        localListPreference3.setPositiveButtonText("Clear");
        localListPreference3.setNegativeButtonText("Cancel");
        localListPreference3.setKey("reset");
        localListPreference3.setOnPreferenceChangeListener(new SettingsActivity.7(this));
        localPreferenceCategory2.addPreference(localListPreference3);
        if (Constants.a())
        {
          PreferenceCategory localPreferenceCategory3 = new PreferenceCategory(this);
          localPreferenceCategory3.setTitle("FPS Counter");
          localPreferenceScreen1.addPreference(localPreferenceCategory3);
          localPreferenceCategory3.addPreference(new FPSPreference(this, BuildConstants.a()));
          localPreferenceCategory3.addPreference(new FPSLoggingPreference(this));
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("gatekeepers", new Gatekeeper.Expirer());
        localListPreference4.setEntries(a(localHashMap, "Expire "));
        localListPreference4.setEntryValues(a(localHashMap, ""));
        localListPreference4.setDialogTitle("ManagedDataStore");
        localListPreference4.setTitle("ManagedDataStore Control");
        localListPreference4.setSummary("Expire native caches");
        localListPreference4.setPositiveButtonText("Clear");
        localListPreference4.setNegativeButtonText("Cancel");
        localListPreference4.setKey("reset");
        localListPreference4.setOnPreferenceChangeListener(new SettingsActivity.8(this, localHashMap));
        localPreferenceCategory2.addPreference(localListPreference4);
        localPreferenceCategory2.addPreference(new HttpProxyPreference(this));
        CheckBoxPreference localCheckBoxPreference2 = new CheckBoxPreference(this);
        localCheckBoxPreference2.setKey("force_upgrade");
        localCheckBoxPreference2.setTitle("Force Upgrade");
        FB4AVersion localFB4AVersion = FB4AVersion.a(this);
        AlertDialog localAlertDialog = new AlertDialog.Builder(this).setMessage("Reset version number and kill the app?").setPositiveButton("Yes", new SettingsActivity.9(this, localFB4AVersion, this)).setNegativeButton("No", null).create();
        localCheckBoxPreference2.setSummary("Current build version is " + localFB4AVersion.c() + ". Force Upgrade will reset the last run version, and will kill the app." + "The app will upgrade on restart.");
        localCheckBoxPreference2.setOnPreferenceChangeListener(new SettingsActivity.10(this, localAlertDialog));
        localPreferenceCategory2.addPreference(localCheckBoxPreference2);
        CheckBoxPreference localCheckBoxPreference3 = new CheckBoxPreference(this);
        localCheckBoxPreference3.setKey("do_not_crash");
        localCheckBoxPreference3.setTitle("Monkey mode");
        localCheckBoxPreference3.setOnPreferenceChangeListener(new SettingsActivity.11(this));
        localCheckBoxPreference3.setDefaultValue(Boolean.valueOf(false));
        localCheckBoxPreference3.setSummary("Disables Logout, Crash, Report Bug, and this preference.");
        localPreferenceCategory2.addPreference(localCheckBoxPreference3);
        PreferenceCategory localPreferenceCategory4 = new PreferenceCategory(this);
        localPreferenceCategory4.setTitle("A/B Testing");
        localPreferenceScreen1.addPreference(localPreferenceCategory4);
        Iterator localIterator1 = RolloutSetting.a.iterator();
        while (localIterator1.hasNext())
          localPreferenceCategory4.addPreference(((RolloutSetting)localIterator1.next()).a(this));
        CheckBoxPreference localCheckBoxPreference4 = new CheckBoxPreference(this);
        PerformanceLogger localPerformanceLogger = (PerformanceLogger)localFbInjector.a(PerformanceLogger.class);
        localCheckBoxPreference4.setKey("perfmarker_to_logcat");
        localCheckBoxPreference4.setTitle("Show PerfMarker in LogCat");
        localCheckBoxPreference4.setOnPreferenceChangeListener(new SettingsActivity.12(this, localPerformanceLogger));
        localCheckBoxPreference4.setDefaultValue(Boolean.valueOf(localPerformanceLogger.b()));
        localCheckBoxPreference4.setSummary("PerfMarker timestamp and elapsed time are reported in LogCat");
        localPreferenceCategory2.addPreference(localCheckBoxPreference4);
        localPreferenceCategory2.addPreference(d());
        ListPreference localListPreference5 = new ListPreference(this);
        String str1 = "" + localOrcaSharedPreferences.a(SharedPrefKeys.l, 120000L) / 1000L;
        ArrayList localArrayList3 = new ArrayList();
        localArrayList3.add("1 second");
        localArrayList3.add("5 seconds");
        localArrayList3.add("30 seconds");
        localArrayList3.add("1 minute");
        localArrayList3.add("2 minutes");
        ArrayList localArrayList4 = new ArrayList();
        localArrayList4.add("1");
        localArrayList4.add("5");
        localArrayList4.add("30");
        localArrayList4.add("60");
        localArrayList4.add("120");
        CharSequence[] arrayOfCharSequence3 = (CharSequence[])localArrayList3.toArray(new CharSequence[localArrayList3.size()]);
        CharSequence[] arrayOfCharSequence4 = (CharSequence[])localArrayList4.toArray(new CharSequence[localArrayList4.size()]);
        localListPreference5.setEntries(arrayOfCharSequence3);
        localListPreference5.setEntryValues(arrayOfCharSequence4);
        localListPreference5.setDefaultValue(str1);
        localListPreference5.setKey("device_stat_interval");
        localListPreference5.setTitle("Device Status Interval");
        localListPreference5.setSummary("how long between Device Status notifications");
        localListPreference5.setOnPreferenceChangeListener(new SettingsActivity.13(this, localOrcaSharedPreferences));
        localPreferenceCategory2.addPreference(localListPreference5);
        ListPreference localListPreference6 = new ListPreference(this);
        String str2 = "" + localOrcaSharedPreferences.a(SharedPrefKeys.m, 300000L) / 1000L;
        ArrayList localArrayList5 = new ArrayList();
        localArrayList5.add("1 second");
        localArrayList5.add("2 seconds");
        localArrayList5.add("5 seconds");
        localArrayList5.add("10 seconds");
        localArrayList5.add("300 seconds");
        ArrayList localArrayList6 = new ArrayList();
        localArrayList6.add("1");
        localArrayList6.add("2");
        localArrayList6.add("5");
        localArrayList6.add("10");
        localArrayList6.add("300");
        CharSequence[] arrayOfCharSequence5 = (CharSequence[])localArrayList5.toArray(new CharSequence[localArrayList5.size()]);
        CharSequence[] arrayOfCharSequence6 = (CharSequence[])localArrayList6.toArray(new CharSequence[localArrayList6.size()]);
        localListPreference6.setEntries(arrayOfCharSequence5);
        localListPreference6.setEntryValues(arrayOfCharSequence6);
        localListPreference6.setDefaultValue(str2);
        localListPreference6.setKey("batch_log_interval");
        localListPreference6.setTitle("Batch Log Interval");
        localListPreference6.setSummary("how long to batch logs before send them back");
        localListPreference6.setOnPreferenceChangeListener(new SettingsActivity.14(this, localOrcaSharedPreferences));
        localPreferenceCategory2.addPreference(localListPreference6);
        OrcaCheckBoxPreference localOrcaCheckBoxPreference8 = new OrcaCheckBoxPreference(this);
        localOrcaCheckBoxPreference8.a(SharedPrefKeys.v);
        localOrcaCheckBoxPreference8.setTitle(2131362004);
        localOrcaCheckBoxPreference8.setSummary(2131362005);
        localOrcaCheckBoxPreference8.setDefaultValue(Boolean.valueOf(Fb4aBugReporterConfig.e()));
        a(localOrcaCheckBoxPreference8);
        localPreferenceCategory2.addPreference(localOrcaCheckBoxPreference8);
      }
    }
    return localPreferenceScreen1;
  }

  private void c(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    if (!localSharedPreferences.getString("vault_sync_mode", "").equals(paramString))
    {
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putString("vault_sync_mode", paramString);
      localEditor.commit();
    }
  }

  private CheckBoxPreference d()
  {
    NetAccessLogger localNetAccessLogger = (NetAccessLogger)b().a(NetAccessLogger.class);
    CheckBoxPreference localCheckBoxPreference = a("fb_log_net_access", 2131362785, false);
    localCheckBoxPreference.setOnPreferenceChangeListener(new SettingsActivity.16(this, localNetAccessLogger));
    return localCheckBoxPreference;
  }

  private void f()
  {
    f = true;
    findPreference("do_not_crash").setEnabled(false);
    findPreference("do_not_crash").setDefaultValue(Boolean.valueOf(false));
    findPreference(InternalHttpPrefKeys.f.a()).setEnabled(false);
    findPreference("sandbox").setEnabled(false);
    findPreference("do_not_crash").setSummary("Monkey mode irrevocably on. Reinstall the app or clear application data to turn it off.");
  }

  public String a()
  {
    return FB4A_AnalyticEntities.j;
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.e = ((NetworkConfigUpdater)FbInjector.a(this).a(NetworkConfigUpdater.class));
    setPreferenceScreen(c());
    this.d = false;
    if (a(this))
      f();
    this.g = new InteractionLogger(this);
  }

  public String i()
  {
    return null;
  }

  public void onResume()
  {
    super.onResume();
    Preference localPreference = findPreference("sync_contacts");
    if (localPreference != null)
      a(AppSession.a(this, false), localPreference);
  }

  protected void onStop()
  {
    super.onStop();
    if (this.d)
    {
      AppSession localAppSession = AppSession.a(this, false);
      if (localAppSession != null)
        localAppSession.h(getApplicationContext());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity
 * JD-Core Version:    0.6.0
 */