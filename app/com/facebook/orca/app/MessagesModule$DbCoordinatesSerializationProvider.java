package com.facebook.orca.app;

import com.facebook.orca.database.DbCoordinatesSerialization;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class MessagesModule$DbCoordinatesSerializationProvider extends AbstractProvider<DbCoordinatesSerialization>
{
  private MessagesModule$DbCoordinatesSerializationProvider(MessagesModule paramMessagesModule)
  {
  }

  public DbCoordinatesSerialization a()
  {
    return new DbCoordinatesSerialization((ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DbCoordinatesSerializationProvider
 * JD-Core Version:    0.6.0
 */