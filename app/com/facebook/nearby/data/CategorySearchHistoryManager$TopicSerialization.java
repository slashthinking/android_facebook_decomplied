package com.facebook.nearby.data;

import com.facebook.nearby.model.NearbyTopic;
import com.facebook.orca.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class CategorySearchHistoryManager$TopicSerialization
{
  private final ObjectMapper a;

  public CategorySearchHistoryManager$TopicSerialization(ObjectMapper paramObjectMapper)
  {
    this.a = paramObjectMapper;
  }

  private static ArrayNode a(Set<Long> paramSet)
  {
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
      localArrayNode.add((Long)localIterator.next());
    return localArrayNode;
  }

  public ImmutableList<NearbyTopic> a(String paramString)
  {
    ImmutableList.Builder localBuilder = new ImmutableList.Builder();
    while (true)
    {
      String str;
      HashSet localHashSet;
      try
      {
        Iterator localIterator1 = this.a.readTree(paramString).iterator();
        if (!localIterator1.hasNext())
          break;
        JsonNode localJsonNode = (JsonNode)localIterator1.next();
        str = JSONUtil.a(localJsonNode.get("name"), null);
        localHashSet = Sets.a();
        Iterator localIterator2 = localJsonNode.get("ids").iterator();
        if (localIterator2.hasNext())
        {
          localHashSet.add(Long.valueOf(JSONUtil.a((JsonNode)localIterator2.next(), 0L)));
          continue;
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Unexpected serialization exception", localIOException);
      }
      localBuilder.b(new NearbyTopic(localHashSet, str));
    }
    return localBuilder.b();
  }

  public String a(List<NearbyTopic> paramList)
  {
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      NearbyTopic localNearbyTopic = (NearbyTopic)localIterator.next();
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("name", localNearbyTopic.a);
      localObjectNode.put("ids", a(localNearbyTopic.b));
      localArrayNode.add(localObjectNode);
    }
    return localArrayNode.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.data.CategorySearchHistoryManager.TopicSerialization
 * JD-Core Version:    0.6.0
 */