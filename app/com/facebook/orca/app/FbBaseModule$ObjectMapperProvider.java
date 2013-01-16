package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

class FbBaseModule$ObjectMapperProvider extends AbstractProvider<ObjectMapper>
{
  public ObjectMapper a()
  {
    ObjectMapper localObjectMapper = new ObjectMapper((JsonFactory)b(JsonFactory.class));
    localObjectMapper.registerModule(new GuavaModule());
    return localObjectMapper;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.ObjectMapperProvider
 * JD-Core Version:    0.6.0
 */