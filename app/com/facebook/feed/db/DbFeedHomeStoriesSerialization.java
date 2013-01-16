package com.facebook.feed.db;

import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.util.Log;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.orca.app.UserInteractionController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import java.io.IOException;

public class DbFeedHomeStoriesSerialization
{
  private static final Class<?> a = DbFeedHomeStoriesSerialization.class;
  private final ObjectMapper b;
  private final UserInteractionController c;
  private final PerformanceLogger d;

  public DbFeedHomeStoriesSerialization(ObjectMapper paramObjectMapper, UserInteractionController paramUserInteractionController, PerformanceLogger paramPerformanceLogger)
  {
    this.b = ((ObjectMapper)Preconditions.checkNotNull(paramObjectMapper));
    this.c = ((UserInteractionController)Preconditions.checkNotNull(paramUserInteractionController));
    this.d = paramPerformanceLogger;
  }

  FeedHomeStories a(String paramString)
  {
    FeedHomeStories localFeedHomeStories;
    if (paramString == null)
      localFeedHomeStories = null;
    while (true)
    {
      return localFeedHomeStories;
      try
      {
        this.d.a("NNFDbDeserializeStories");
        this.c.c();
        JsonParser localJsonParser = FBJsonFactory.a.createJsonParser(paramString);
        localJsonParser.setCodec(this.b);
        localFeedHomeStories = (FeedHomeStories)localJsonParser.readValueAs(FeedHomeStories.class);
        this.d.b("NNFDbDeserializeStories");
      }
      catch (JsonParseException localJsonParseException)
      {
        this.d.b("NNFDbDeserializeStories");
        Log.b(a, "Parsing error when read stories from disk cache. Model classes changed recently?  Caused By:\n" + localJsonParseException.toString());
        localFeedHomeStories = null;
      }
      catch (IOException localIOException)
      {
        label66: break label66;
      }
    }
  }

  String a(FeedHomeStories paramFeedHomeStories)
  {
    try
    {
      this.c.c();
      String str2 = this.b.writeValueAsString(paramFeedHomeStories);
      str1 = str2;
      return str1;
    }
    catch (IOException localIOException)
    {
      while (true)
        String str1 = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.DbFeedHomeStoriesSerialization
 * JD-Core Version:    0.6.0
 */