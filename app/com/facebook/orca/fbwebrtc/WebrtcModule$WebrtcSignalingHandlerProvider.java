package com.facebook.orca.fbwebrtc;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.push.mqtt.MqttConnectionManager;

class WebrtcModule$WebrtcSignalingHandlerProvider extends AbstractProvider<WebrtcSignalingHandler>
{
  private WebrtcModule$WebrtcSignalingHandlerProvider(WebrtcModule paramWebrtcModule)
  {
  }

  public WebrtcSignalingHandler a()
  {
    return new WebrtcSignalingHandler((MqttConnectionManager)b(MqttConnectionManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcModule.WebrtcSignalingHandlerProvider
 * JD-Core Version:    0.6.0
 */