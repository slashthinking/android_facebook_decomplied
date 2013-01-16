package com.facebook.orca.push.mqtt;

import android.os.Handler;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.mqtt.ConnectionFailureReason;
import com.facebook.orca.mqtt.MqttClient;
import com.facebook.orca.mqtt.MqttClientCallback;
import java.util.Set;

class MqttConnectionManager$CallbackHandler
  implements MqttClientCallback
{
  private final MqttClient b;

  public MqttConnectionManager$CallbackHandler(MqttConnectionManager paramMqttConnectionManager, MqttClient paramMqttClient)
  {
    this.b = paramMqttClient;
  }

  public void a()
  {
    MqttConnectionManager.c(this.a).post(new MqttConnectionManager.CallbackHandler.1(this));
  }

  public void a(int paramInt)
  {
    synchronized (MqttConnectionManager.e(this.a))
    {
      MqttConnectionManager.e(this.a).remove(Integer.valueOf(paramInt));
      MqttConnectionManager.e(this.a).notifyAll();
      return;
    }
  }

  public void a(ConnectionFailureReason paramConnectionFailureReason)
  {
    MqttConnectionManager.c(this.a).post(new MqttConnectionManager.CallbackHandler.2(this));
  }

  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    String str = StringUtil.a(paramArrayOfByte);
    MqttConnectionManager.d(this.a).a(paramString, str);
  }

  public void b()
  {
    MqttConnectionManager.c(this.a).post(new MqttConnectionManager.CallbackHandler.3(this));
  }

  public void b(int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttConnectionManager.CallbackHandler
 * JD-Core Version:    0.6.0
 */