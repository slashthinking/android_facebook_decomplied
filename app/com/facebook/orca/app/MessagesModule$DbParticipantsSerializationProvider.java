package com.facebook.orca.app;

import com.facebook.orca.database.DbParticipantsSerialization;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class MessagesModule$DbParticipantsSerializationProvider extends AbstractProvider<DbParticipantsSerialization>
{
  private MessagesModule$DbParticipantsSerializationProvider(MessagesModule paramMessagesModule)
  {
  }

  public DbParticipantsSerialization a()
  {
    return new DbParticipantsSerialization((ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DbParticipantsSerializationProvider
 * JD-Core Version:    0.6.0
 */