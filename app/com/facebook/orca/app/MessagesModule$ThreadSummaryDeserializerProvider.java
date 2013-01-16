package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.ParticipantInfoDeserializer;
import com.facebook.orca.protocol.methods.ThreadSummaryDeserializer;

class MessagesModule$ThreadSummaryDeserializerProvider extends AbstractProvider<ThreadSummaryDeserializer>
{
  private MessagesModule$ThreadSummaryDeserializerProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadSummaryDeserializer a()
  {
    return new ThreadSummaryDeserializer((ParticipantInfoDeserializer)b(ParticipantInfoDeserializer.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadSummaryDeserializerProvider
 * JD-Core Version:    0.6.0
 */