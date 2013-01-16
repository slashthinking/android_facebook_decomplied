package com.facebook.orca.threadlist;

import com.facebook.orca.common.ui.widgets.SlidingOutSuggestionView;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;

public class MuteGlobalWarningController
{
  private final OrcaSharedPreferences a;
  private final OrcaSharedPreferences.OnSharedPreferenceChangeListener b;
  private final NotificationSettingsUtil c;
  private final SlidingOutSuggestionView d;

  public MuteGlobalWarningController(OrcaSharedPreferences paramOrcaSharedPreferences, NotificationSettingsUtil paramNotificationSettingsUtil, SlidingOutSuggestionView paramSlidingOutSuggestionView)
  {
    this.a = paramOrcaSharedPreferences;
    this.c = paramNotificationSettingsUtil;
    this.d = paramSlidingOutSuggestionView;
    paramSlidingOutSuggestionView.setOnButtonClickListener(new MuteGlobalWarningController.1(this));
    this.b = new MuteGlobalWarningController.2(this);
    paramOrcaSharedPreferences.a(this.b);
    b();
  }

  private void a(PrefKey paramPrefKey)
  {
    if (MessagesPrefKeys.m.equals(paramPrefKey))
      b();
  }

  private void b()
  {
    NotificationSetting localNotificationSetting = this.c.a();
    if (!this.c.a(localNotificationSetting))
      this.d.d();
    while (true)
    {
      return;
      this.d.e();
    }
  }

  private void c()
  {
    this.d.f();
    this.a.b().a(MessagesPrefKeys.m, 0L).a();
  }

  public void a()
  {
    b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.MuteGlobalWarningController
 * JD-Core Version:    0.6.0
 */