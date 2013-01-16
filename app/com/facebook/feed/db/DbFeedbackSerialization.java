package com.facebook.feed.db;

import com.facebook.feed.cache.FastJsonNodeParser;
import com.facebook.graphql.model.FeedStoryComments;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.FeedStoryReshares;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackBuilder;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.debug.BLog;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import java.io.IOException;

public class DbFeedbackSerialization
{
  private static Class<DbFeedbackSerialization> a = DbFeedbackSerialization.class;
  private FastJsonNodeParser b;

  public DbFeedbackSerialization(FastJsonNodeParser paramFastJsonNodeParser)
  {
    this.b = paramFastJsonNodeParser;
  }

  Feedback a(String paramString)
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
        String str1 = JSONUtil.b(localJsonNode.get("id"));
        String str2 = JSONUtil.b(localJsonNode.get("legacy_api_post_id"));
        if ((Strings.isNullOrEmpty(str2)) && (Strings.isNullOrEmpty(str1)))
        {
          localObject = null;
          continue;
        }
        Feedback localFeedback = new FeedbackBuilder().b(str1).a(str2).a(JSONUtil.f(localJsonNode.get("can_viewer_like"))).b(JSONUtil.f(localJsonNode.get("can_viwerer_comment"))).c(JSONUtil.f(localJsonNode.get("does_viewer_like"))).a(new FeedStoryComments(JSONUtil.d(localJsonNode.get("comment_count")))).a(new FeedStoryLikers(JSONUtil.d(localJsonNode.get("liker_count")))).a(new FeedStoryReshares(JSONUtil.d(localJsonNode.get("reshare_count")))).a(JSONUtil.c(localJsonNode.get("fetch_time"))).n();
        localObject = localFeedback;
      }
      catch (IOException localIOException)
      {
        BLog.d(a, "Parsing error when read feedback from disk cache.", localIOException);
        localObject = null;
      }
      catch (JsonParseException localJsonParseException)
      {
        label204: break label204;
      }
    }
  }

  String a(Feedback paramFeedback)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("id", paramFeedback.id);
    localObjectNode.put("legacy_api_post_id", paramFeedback.legacyApiPostId);
    localObjectNode.put("can_viewer_like", paramFeedback.canViewerLike);
    localObjectNode.put("can_viwerer_comment", paramFeedback.canViewerComment);
    localObjectNode.put("does_viewer_like", paramFeedback.doesViewerLike);
    localObjectNode.put("comment_count", paramFeedback.b());
    localObjectNode.put("liker_count", paramFeedback.a());
    localObjectNode.put("reshare_count", paramFeedback.c());
    localObjectNode.put("fetch_time", paramFeedback.getFetchTimeMs());
    return localObjectNode.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.DbFeedbackSerialization
 * JD-Core Version:    0.6.0
 */