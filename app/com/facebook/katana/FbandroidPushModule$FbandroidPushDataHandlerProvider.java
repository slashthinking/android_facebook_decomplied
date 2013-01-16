package com.facebook.katana;

import com.facebook.katana.orca.FbandroidMqttPushHandler;
import com.facebook.katana.orca.FbandroidPushHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class FbandroidPushModule$FbandroidPushDataHandlerProvider extends AbstractProvider<FbandroidMqttPushHandler>
{
  private FbandroidPushModule$FbandroidPushDataHandlerProvider(FbandroidPushModule paramFbandroidPushModule)
  {
  }

  public FbandroidMqttPushHandler a()
  {
    return new FbandroidMqttPushHandler((FbandroidPushHandler)b(FbandroidPushHandler.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FbandroidPushModule.FbandroidPushDataHandlerProvider
 * JD-Core Version:    0.6.0
 */