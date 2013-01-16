package com.facebook.graphql.module;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.orca.app.INeedInit;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class GraphQLJacksonInitializer
  implements INeedInit
{
  private ObjectMapper a;

  public GraphQLJacksonInitializer(ObjectMapper paramObjectMapper)
  {
    this.a = paramObjectMapper;
  }

  public void i_()
  {
    SimpleModule localSimpleModule = new SimpleModule("GraphQLDeserializationModule", new Version(1, 0, 0, null, null, null));
    localSimpleModule.addDeserializer(FeedUnit.class, new FeedUnitDeserializer());
    this.a.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    this.a.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.NONE);
    this.a.registerModule(localSimpleModule);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.module.GraphQLJacksonInitializer
 * JD-Core Version:    0.6.2
 */