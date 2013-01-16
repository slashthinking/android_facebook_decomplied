package com.facebook.orca.threadview;

import com.facebook.orca.common.ui.widgets.SlidingOutSuggestionView;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;
import com.google.common.base.Objects;

public class MuteThreadWarningController
{
  private final OrcaSharedPreferences a;
  private final OrcaSharedPreferences.OnSharedPreferenceChangeListener b;
  private final NotificationSettingsUtil c;
  private final SlidingOutSuggestionView d;
  private String e;
  private PrefKey f;

  public MuteThreadWarningController(OrcaSharedPreferences paramOrcaSharedPreferences, NotificationSettingsUtil paramNotificationSettingsUtil, SlidingOutSuggestionView paramSlidingOutSuggestionView)
  {
    this.a = paramOrcaSharedPreferences;
    this.c = paramNotificationSettingsUtil;
    this.d = paramSlidingOutSuggestionView;
    paramSlidingOutSuggestionView.setOnButtonClickListener(new MuteThreadWarningController.1(this));
    this.b = new MuteThreadWarningController.2(this);
    paramOrcaSharedPreferences.a(this.b);
    b();
  }

  private void a(PrefKey paramPrefKey)
  {
    if (Objects.equal(this.f, paramPrefKey))
      b();
  }

  private void b()
  {
    if (this.e == null)
      this.d.e();
    NotificationSetting localNotificationSetting = this.c.a(this.e);
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
    this.a.b().a(this.f, 0L).a();
  }

  public void a()
  {
    b();
  }

  public void a(String paramString)
  {
    this.e = paramString;
    if (this.e != null);
    for (PrefKey localPrefKey = MessagesPrefKeys.a(paramString); ; localPrefKey = null)
    {
      this.f = localPrefKey;
      b();
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.MuteThreadWarningController
 * JD-Core Version:    0.6.0
 */