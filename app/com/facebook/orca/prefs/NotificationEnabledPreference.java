package com.facebook.orca.prefs;

import android.content.Context;
import android.preference.CheckBoxPreference;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.notify.NotificationSettingsUtil;
import java.util.Date;

public class NotificationEnabledPreference extends CheckBoxPreference
{
  private OrcaSharedPreferences a;
  private NotificationSettingsUtil b;
  private NotificationSetting c;

  public NotificationEnabledPreference(Context paramContext)
  {
    super(paramContext);
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.a = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.b = ((NotificationSettingsUtil)localFbInjector.a(NotificationSettingsUtil.class));
    this.c = this.b.a();
    setDefaultValue(Boolean.valueOf(true));
    setKey(MessagesPrefKeys.l.a());
    setSummary(a());
  }

  private String a()
  {
    Context localContext = getContext();
    String str;
    if (this.b.b(this.c))
    {
      Date localDate = new Date(1000L * this.c.b());
      str = localContext.getString(2131362588, new Object[] { android.text.format.DateFormat.getTimeFormat(localContext).format(localDate) });
    }
    while (true)
    {
      return str;
      if (this.c.a())
      {
        str = localContext.getString(2131362586);
        continue;
      }
      str = localContext.getString(2131362587);
    }
  }

  protected void onSetInitialValue(boolean paramBoolean, Object paramObject)
  {
    if (!this.b.b(this.c));
    for (boolean bool = true; ; bool = false)
    {
      setChecked(bool);
      return;
    }
  }

  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    if (paramBoolean);
    for (this.c = NotificationSetting.a; ; this.c = NotificationSetting.a(28800L + System.currentTimeMillis() / 1000L))
    {
      PrefKey localPrefKey = MessagesPrefKeys.m;
      OrcaSharedPreferences.Editor localEditor = this.a.b();
      localEditor.a(localPrefKey, this.c.d());
      localEditor.a();
      setSummary(a());
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.NotificationEnabledPreference
 * JD-Core Version:    0.6.0
 */