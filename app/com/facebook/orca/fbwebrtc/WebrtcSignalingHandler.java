package com.facebook.orca.fbwebrtc;

import com.facebook.orca.push.mqtt.MqttConnectionManager;
import com.facebook.webrtc.IWebrtcSignalingMessageInterface;

public class WebrtcSignalingHandler
  implements IWebrtcSignalingMessageInterface
{
  private static final Class<?> a = WebrtcSignalingHandler.class;
  private final MqttConnectionManager b;

  public WebrtcSignalingHandler(MqttConnectionManager paramMqttConnectionManager)
  {
    this.b = paramMqttConnectionManager;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcSignalingHandler
 * JD-Core Version:    0.6.0
 */