package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserFqlHelper
{
  public JsonNode a(JsonNode paramJsonNode1, JsonNode paramJsonNode2)
  {
    return a(paramJsonNode1, paramJsonNode2, null);
  }

  public JsonNode a(JsonNode paramJsonNode1, JsonNode paramJsonNode2, JsonNode paramJsonNode3)
  {
    HashMap localHashMap = Maps.a();
    for (int i = 0; i < paramJsonNode2.size(); i++)
    {
      JsonNode localJsonNode3 = paramJsonNode2.get(i);
      ObjectNode localObjectNode5 = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode5.put("uid", JSONUtil.b(localJsonNode3.get("id")));
      Iterator localIterator3 = localJsonNode3.fieldNames();
      while (localIterator3.hasNext())
      {
        String str2 = (String)localIterator3.next();
        localObjectNode5.put(str2, localJsonNode3.get(str2));
      }
      localHashMap.put(JSONUtil.b(localJsonNode3.get("id")), localObjectNode5);
    }
    int j = 0;
    JsonNode localJsonNode2;
    ObjectNode localObjectNode2;
    ObjectNode localObjectNode3;
    if (j < paramJsonNode1.size())
    {
      localJsonNode2 = paramJsonNode1.get(j);
      localObjectNode2 = (ObjectNode)localHashMap.get(JSONUtil.b(localJsonNode2.get("uid")));
      if (localObjectNode2 != null)
        break label407;
      localObjectNode3 = new ObjectNode(JsonNodeFactory.instance);
      localHashMap.put(JSONUtil.b(localObjectNode3.get("uid")), localObjectNode3);
    }
    label407: for (ObjectNode localObjectNode4 = localObjectNode3; ; localObjectNode4 = localObjectNode2)
    {
      Iterator localIterator2 = localJsonNode2.fieldNames();
      while (localIterator2.hasNext())
      {
        String str1 = (String)localIterator2.next();
        localObjectNode4.put(str1, localJsonNode2.get(str1));
      }
      j++;
      break;
      int k = 0;
      if (paramJsonNode3 != null)
        while (k < paramJsonNode3.size())
        {
          JsonNode localJsonNode1 = paramJsonNode3.get(k);
          ObjectNode localObjectNode1 = (ObjectNode)localHashMap.get(JSONUtil.b(localJsonNode1.get("uid2")));
          if ((localObjectNode1 != null) && (localJsonNode1.has("communication_rank")))
            localObjectNode1.put("rank", JSONUtil.e(localJsonNode1.get("communication_rank")));
          k++;
        }
      ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
      Iterator localIterator1 = localHashMap.values().iterator();
      while (localIterator1.hasNext())
        localArrayNode.add((ObjectNode)localIterator1.next());
      return localArrayNode;
    }
  }

  public JsonNode a(JsonNode[] paramArrayOfJsonNode)
  {
    Object localObject1;
    if (paramArrayOfJsonNode.length == 0)
      localObject1 = new ArrayNode(JsonNodeFactory.instance);
    label164: label171: label175: 
    while (true)
    {
      return localObject1;
      if (paramArrayOfJsonNode.length == 1)
      {
        localObject1 = paramArrayOfJsonNode[0];
        continue;
      }
      int i = paramArrayOfJsonNode.length;
      int j = 0;
      Object localObject3;
      for (Object localObject2 = null; ; localObject2 = localObject3)
      {
        if (j >= i)
          break label171;
        JsonNode localJsonNode2 = paramArrayOfJsonNode[j];
        if (localJsonNode2.size() <= 0)
          break label164;
        if (localObject2 != null)
          break;
        localObject3 = (ArrayNode)localJsonNode2;
        label72: j++;
      }
      for (localObject1 = null; ; localObject1 = localObject2)
      {
        if (localObject1 != null)
          break label175;
        ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
        int k = paramArrayOfJsonNode.length;
        for (int m = 0; m < k; m++)
        {
          JsonNode localJsonNode1 = paramArrayOfJsonNode[m];
          for (int n = 0; n < localJsonNode1.size(); n++)
            localArrayNode.add(localJsonNode1.get(n));
        }
        localObject1 = localArrayNode;
        break;
        localObject3 = localObject2;
        break label72;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.UserFqlHelper
 * JD-Core Version:    0.6.0
 */