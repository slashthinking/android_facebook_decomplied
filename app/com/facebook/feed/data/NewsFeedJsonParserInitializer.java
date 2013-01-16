package com.facebook.feed.data;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.module.GraphQLJacksonInitializer;
import com.facebook.orca.app.INeedInit;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class NewsFeedJsonParserInitializer
  implements INeedInit
{
  private final ObjectMapper a;
  private final GraphQLHelper b;
  private final Context c;

  public NewsFeedJsonParserInitializer(Context paramContext, ObjectMapper paramObjectMapper, GraphQLHelper paramGraphQLHelper)
  {
    this.c = paramContext;
    this.a = paramObjectMapper;
    this.b = paramGraphQLHelper;
  }

  public void i_()
  {
    new GraphQLJacksonInitializer(this.a).i_();
    try
    {
      JsonParser localJsonParser1 = new JsonFactory().createJsonParser(this.c.getResources().getString(2131362155));
      localJsonParser1.setCodec(this.a);
      JsonParser localJsonParser2 = this.b.a("fetch_news_feed", 2, localJsonParser1);
      localJsonParser2.setCodec(this.a);
      localJsonParser2.readValueAs(FeedHomeStories.class);
      label78: return;
    }
    catch (Exception localException)
    {
      break label78;
    }
    catch (IOException localIOException)
    {
      break label78;
    }
    catch (JsonParseException localJsonParseException)
    {
      break label78;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.NewsFeedJsonParserInitializer
 * JD-Core Version:    0.6.0
 */