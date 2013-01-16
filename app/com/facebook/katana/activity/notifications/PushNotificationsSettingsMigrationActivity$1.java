package com.facebook.katana.activity.notifications;

import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class PushNotificationsSettingsMigrationActivity$1
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    PushNotificationsSettingsMigrationActivity.a(this.a);
    OrcaSharedPreferences.Editor localEditor = ((OrcaSharedPreferences)this.a.C().a(OrcaSharedPreferences.class)).b();
    localEditor.a(FbandroidPrefKeys.n, true);
    localEditor.a();
    IntentUriHandler.b(this.a, "fb://notifications_settings");
    this.a.finish();
  }

  public void a(Throwable paramThrowable)
  {
    PushNotificationsSettingsMigrationActivity.a(this.a);
    OrcaSharedPreferences.Editor localEditor = ((OrcaSharedPreferences)this.a.C().a(OrcaSharedPreferences.class)).b();
    localEditor.a(FbandroidPrefKeys.n, false);
    localEditor.a();
    this.a.finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.notifications.PushNotificationsSettingsMigrationActivity.1
 * JD-Core Version:    0.6.0
 */