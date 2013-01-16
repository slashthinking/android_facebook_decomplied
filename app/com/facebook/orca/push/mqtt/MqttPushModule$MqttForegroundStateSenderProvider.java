package com.facebook.orca.push.mqtt;

import android.content.Context;
import com.facebook.app.UserActivityManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MqttPushModule$MqttForegroundStateSenderProvider extends AbstractProvider<MqttForegroundStateSender>
{
  private MqttPushModule$MqttForegroundStateSenderProvider(MqttPushModule paramMqttPushModule)
  {
  }

  public MqttForegroundStateSender a()
  {
    return new MqttForegroundStateSender((Context)b(Context.class, FromApplication.class), (UserActivityManager)b(UserActivityManager.class), (MqttConnectionManager)b(MqttConnectionManager.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushModule.MqttForegroundStateSenderProvider
 * JD-Core Version:    0.6.0
 */