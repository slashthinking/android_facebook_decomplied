package com.facebook.feed.db;

import com.facebook.feed.cache.FastJsonNodeParser;
import com.facebook.feed.cache.FeedStoryPartial;
import com.facebook.feed.cache.FeedStoryPartial.Builder;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.debug.BLog;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import java.io.IOException;

public class DbFeedStoryPartialSerialization
{
  private static Class<DbFeedStoryPartialSerialization> a = DbFeedStoryPartialSerialization.class;
  private FastJsonNodeParser b;

  public DbFeedStoryPartialSerialization(FastJsonNodeParser paramFastJsonNodeParser)
  {
    this.b = paramFastJsonNodeParser;
  }

  FeedStoryPartial a(String paramString)
  {
    Object localObject;
    if (paramString == null)
      localObject = null;
    while (true)
    {
      return localObject;
      try
      {
        JsonNode localJsonNode = this.b.a(paramString);
        String str = JSONUtil.b(localJsonNode.get("cache_id"));
        if (Strings.isNullOrEmpty(str))
        {
          localObject = null;
          continue;
        }
        long l = JSONUtil.c(localJsonNode.get("fetch_time_ms"));
        boolean bool = JSONUtil.f(localJsonNode.get("impressions_logged"));
        FeedStoryPartial localFeedStoryPartial = new FeedStoryPartial.Builder().a(str).a(l).a(bool).a();
        localObject = localFeedStoryPartial;
      }
      catch (IOException localIOException)
      {
        BLog.d(a, "Parsing error when reading feed story partial from disk cache.", localIOException);
        localObject = null;
      }
      catch (JsonParseException localJsonParseException)
      {
        label101: break label101;
      }
    }
  }

  String a(FeedStoryPartial paramFeedStoryPartial)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("cache_id", paramFeedStoryPartial.c);
    localObjectNode.put("fetch_time_ms", paramFeedStoryPartial.d);
    localObjectNode.put("type", FeedStoryPartial.a);
    localObjectNode.put("impressions_logged", paramFeedStoryPartial.b);
    return localObjectNode.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.DbFeedStoryPartialSerialization
 * JD-Core Version:    0.6.0
 */