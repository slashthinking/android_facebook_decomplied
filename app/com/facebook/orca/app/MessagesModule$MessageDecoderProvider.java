package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.mqtt.serialization.MessageDecoder;
import com.facebook.orca.mqtt.serialization.MessageFactory;

class MessagesModule$MessageDecoderProvider extends AbstractProvider<MessageDecoder>
{
  private MessagesModule$MessageDecoderProvider(MessagesModule paramMessagesModule)
  {
  }

  public MessageDecoder a()
  {
    return new MessageDecoder((MessageFactory)b(MessageFactory.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MessageDecoderProvider
 * JD-Core Version:    0.6.0
 */