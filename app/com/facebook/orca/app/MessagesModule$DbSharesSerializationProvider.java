package com.facebook.orca.app;

import com.facebook.orca.database.DbSharesSerialization;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class MessagesModule$DbSharesSerializationProvider extends AbstractProvider<DbSharesSerialization>
{
  private MessagesModule$DbSharesSerializationProvider(MessagesModule paramMessagesModule)
  {
  }

  public DbSharesSerialization a()
  {
    return new DbSharesSerialization((ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DbSharesSerializationProvider
 * JD-Core Version:    0.6.0
 */