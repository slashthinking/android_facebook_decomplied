package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.SendMessageParameterHelper;
import com.facebook.orca.protocol.methods.SendViaChatHandler;
import com.facebook.orca.push.common.PushDeserialization;
import com.facebook.orca.push.mqtt.MqttConnectionManager;
import com.fasterxml.jackson.databind.ObjectMapper;

class MessagesModule$SendViaChatHandlerProvider extends AbstractProvider<SendViaChatHandler>
{
  private MessagesModule$SendViaChatHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public SendViaChatHandler a()
  {
    return new SendViaChatHandler(MessagesModule.a(this.a), (MqttConnectionManager)b(MqttConnectionManager.class), (PushDeserialization)b(PushDeserialization.class), (SendMessageParameterHelper)b(SendMessageParameterHelper.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.SendViaChatHandlerProvider
 * JD-Core Version:    0.6.0
 */