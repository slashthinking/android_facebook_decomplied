package com.facebook.orca.app;

import com.facebook.orca.database.DbDraftSerialization;
import com.facebook.orca.database.DbMediaResourceSerialization;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class MessagesModule$DbDraftSerializationProvider extends AbstractProvider<DbDraftSerialization>
{
  private MessagesModule$DbDraftSerializationProvider(MessagesModule paramMessagesModule)
  {
  }

  public DbDraftSerialization a()
  {
    return new DbDraftSerialization((DbMediaResourceSerialization)b(DbMediaResourceSerialization.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DbDraftSerializationProvider
 * JD-Core Version:    0.6.0
 */