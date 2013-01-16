package com.facebook.orca.app;

import com.facebook.orca.database.DbAttachmentSerialization;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class MessagesModule$DbAttachmentSerializationProvider extends AbstractProvider<DbAttachmentSerialization>
{
  private MessagesModule$DbAttachmentSerializationProvider(MessagesModule paramMessagesModule)
  {
  }

  public DbAttachmentSerialization a()
  {
    return new DbAttachmentSerialization((ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DbAttachmentSerializationProvider
 * JD-Core Version:    0.6.0
 */