package com.facebook.orca.app;

import com.facebook.orca.database.DbMediaResourceSerialization;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class MessagesModule$DbMediaResourceSerializationProvider extends AbstractProvider<DbMediaResourceSerialization>
{
  private MessagesModule$DbMediaResourceSerializationProvider(MessagesModule paramMessagesModule)
  {
  }

  public DbMediaResourceSerialization a()
  {
    return new DbMediaResourceSerialization((ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DbMediaResourceSerializationProvider
 * JD-Core Version:    0.6.0
 */