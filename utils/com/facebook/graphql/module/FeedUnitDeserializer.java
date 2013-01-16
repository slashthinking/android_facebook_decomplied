package com.facebook.graphql.module;

import com.facebook.graphql.model.CelebrationsFeedUnit;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.LifeEventFeedUnit;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.Postprocessable;
import com.facebook.graphql.model.RecommendedApplicationsFeedUnit;
import com.facebook.graphql.model.UnknownFeedUnit;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FeedUnitDeserializer extends StdDeserializer<FeedUnit>
{
  private static final String a = FeedUnitDeserializer.class.getSimpleName();

  public FeedUnitDeserializer()
  {
    super(FeedUnit.class);
  }

  public FeedUnit a(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    ObjectMapper localObjectMapper = (ObjectMapper)paramJsonParser.getCodec();
    ObjectNode localObjectNode = (ObjectNode)paramJsonParser.readValueAsTree();
    JsonNode localJsonNode1 = localObjectNode.get("__type__");
    JsonNode localJsonNode2;
    if (localJsonNode1 != null)
    {
      localJsonNode2 = localJsonNode1.get("name");
      if (localJsonNode2 == null);
    }
    for (String str = localJsonNode2.asText(); ; str = null)
    {
      FeedUnit localFeedUnit;
      if (str == null)
        localFeedUnit = null;
      label263: 
      while (true)
      {
        return localFeedUnit;
        if (str.equalsIgnoreCase("Story"))
          localFeedUnit = (FeedUnit)localObjectMapper.treeToValue(localObjectNode, FeedStory.class);
        while (true)
        {
          if (!(localFeedUnit instanceof Postprocessable))
            break label263;
          ((Postprocessable)localFeedUnit).p();
          break;
          if (str.equalsIgnoreCase(PagesYouMayLikeFeedUnit.class.getSimpleName()))
            localFeedUnit = (FeedUnit)localObjectMapper.treeToValue(localObjectNode, PagesYouMayLikeFeedUnit.class);
          else if (str.equalsIgnoreCase(PeopleYouMayKnowFeedUnit.class.getSimpleName()))
            localFeedUnit = (FeedUnit)localObjectMapper.treeToValue(localObjectNode, PeopleYouMayKnowFeedUnit.class);
          else if (str.equalsIgnoreCase(CelebrationsFeedUnit.class.getSimpleName()))
            localFeedUnit = (FeedUnit)localObjectMapper.treeToValue(localObjectNode, CelebrationsFeedUnit.class);
          else if (str.equalsIgnoreCase(RecommendedApplicationsFeedUnit.class.getSimpleName()))
            localFeedUnit = (FeedUnit)localObjectMapper.treeToValue(localObjectNode, RecommendedApplicationsFeedUnit.class);
          else if (str.equalsIgnoreCase("LifeEventUnit"))
            localFeedUnit = (FeedUnit)localObjectMapper.treeToValue(localObjectNode, LifeEventFeedUnit.class);
          else
            localFeedUnit = (FeedUnit)localObjectMapper.treeToValue(localObjectNode, UnknownFeedUnit.class);
        }
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.module.FeedUnitDeserializer
 * JD-Core Version:    0.6.2
 */