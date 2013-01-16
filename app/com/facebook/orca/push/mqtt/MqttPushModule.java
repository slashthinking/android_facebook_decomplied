package com.facebook.orca.push.mqtt;

import android.content.Context;
import com.facebook.analytics.AnalyticsModule;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnUiThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.common.http.OrcaHttpModule;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.mqtt.MqttClient;
import com.facebook.orca.push.PushManager;
import com.facebook.orca.push.PushModule;
import com.facebook.orca.push.annotations.IsMobileOnlineAvailabilityEnabled;
import com.facebook.orca.push.annotations.MqttEndpointCapability;

public class MqttPushModule extends AbstractModule
{
  private final Context a;

  public MqttPushModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    e(OrcaHttpModule.class);
    e(AnalyticsModule.class);
    e(PushModule.class);
    a(MqttConnectionManager.class).a(new MqttPushModule.MqttConnectionManagerProvider(this, null)).a();
    a(PushStateBroadcaster.class).a(new MqttPushModule.PushStateBroadcasterProvider(this, null));
    a(MqttClient.class).a(new MqttPushModule.MqttClientProvider(this, null));
    a(MqttBroadcastReceiver.class).a(new MqttBroadcastReceiver(this.a));
    a(MqttForegroundStateSender.class).a(new MqttPushModule.MqttForegroundStateSenderProvider(this, null));
    a(MqttPushManager.class).a(new MqttPushModule.MqttPushManagerProvider(this, null)).a();
    a(MqttReceiverWakeLockHolder.class).a(new MqttPushModule.MqttReceiverWakeLockHolderProvider(this, null)).a();
    a(MqttPushServiceManager.class).a(new MqttPushModule.MqttPushServiceManagerProvider(this, null)).a();
    a(INeedInit.class, NeedsLowPriorityInitOnUiThread.class).a(MqttForegroundStateSender.class).a(MqttBroadcastReceiver.class);
    c(MqttPushHandler.class);
    c(PushManager.class).a(MqttPushManager.class);
    b(Boolean.class).a(IsMobileOnlineAvailabilityEnabled.class).a(Boolean.valueOf(false));
    b(Long.class).a(MqttEndpointCapability.class).a(Long.valueOf(0L));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushModule
 * JD-Core Version:    0.6.0
 */