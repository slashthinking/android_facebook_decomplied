package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.location.CoordinatesDeserializer;
import com.facebook.orca.protocol.methods.AttachmentDeserializer;
import com.facebook.orca.protocol.methods.MessageDeserializer;
import com.facebook.orca.protocol.methods.ParticipantInfoDeserializer;
import com.facebook.orca.protocol.methods.ShareDeserializer;
import com.facebook.orca.protocol.methods.SourceDeserializer;

class MessagesModule$MessageDeserializerProvider extends AbstractProvider<MessageDeserializer>
{
  private MessagesModule$MessageDeserializerProvider(MessagesModule paramMessagesModule)
  {
  }

  public MessageDeserializer a()
  {
    return new MessageDeserializer((ParticipantInfoDeserializer)b(ParticipantInfoDeserializer.class), (ShareDeserializer)b(ShareDeserializer.class), (AttachmentDeserializer)b(AttachmentDeserializer.class), (CoordinatesDeserializer)b(CoordinatesDeserializer.class), (SourceDeserializer)b(SourceDeserializer.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MessageDeserializerProvider
 * JD-Core Version:    0.6.0
 */