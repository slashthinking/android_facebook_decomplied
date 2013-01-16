package com.facebook.orca.push.mqtt;

import android.content.Context;
import android.content.IntentFilter;
import com.facebook.app.UserActivityManager;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.mqtt.MqttQOSLevel;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.push.prefs.PushPrefKeys;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MqttForegroundStateSender
  implements INeedInit
{
  private final Context a;
  private final UserActivityManager b;
  private final MqttConnectionManager c;
  private final AndroidThreadUtil d;
  private final OrcaSharedPreferences e;
  private final OrcaSharedPreferences.OnSharedPreferenceChangeListener f;
  private SafeLocalBroadcastReceiver g;
  private boolean h;
  private boolean i;
  private final Runnable j = new MqttForegroundStateSender.1(this);

  public MqttForegroundStateSender(Context paramContext, UserActivityManager paramUserActivityManager, MqttConnectionManager paramMqttConnectionManager, AndroidThreadUtil paramAndroidThreadUtil, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramContext;
    this.b = paramUserActivityManager;
    this.c = paramMqttConnectionManager;
    this.d = paramAndroidThreadUtil;
    this.e = paramOrcaSharedPreferences;
    this.f = new MqttForegroundStateSender.2(this);
  }

  private void a(PrefKey paramPrefKey)
  {
    if (PushPrefKeys.a.equals(paramPrefKey))
    {
      boolean bool = this.e.a(PushPrefKeys.a, true);
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("make_user_available_when_in_foreground", bool);
      this.c.a("/set_client_settings", localObjectNode, MqttQOSLevel.FIRE_AND_FORGET);
    }
  }

  private boolean a(boolean paramBoolean)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("foreground", paramBoolean);
    if (this.c.a("/foreground_state", localObjectNode, MqttQOSLevel.FIRE_AND_FORGET) != -1);
    for (int k = 1; ; k = 0)
      return k;
  }

  void b()
  {
    if (this.b.b(10000L))
    {
      if ((!this.i) && (a(true)))
        this.i = true;
      if (!this.h)
      {
        this.d.a(this.j, 60000L);
        this.h = true;
      }
    }
    while (true)
    {
      return;
      if ((this.i) && (a(false)))
      {
        this.i = false;
        continue;
      }
    }
  }

  public void i_()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.app.USER_MAYBE_BECAME_ACTIVE_OR_INACTIVE");
    this.g = new MqttForegroundStateSender.3(this, this.a, localIntentFilter);
    this.g.a();
    this.e.a(this.f);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttForegroundStateSender
 * JD-Core Version:    0.6.0
 */