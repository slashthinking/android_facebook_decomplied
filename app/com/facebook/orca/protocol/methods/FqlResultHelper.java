package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import java.util.Map;

public class FqlResultHelper
{
  private final Map<String, JsonNode> a;

  public FqlResultHelper(JsonNode paramJsonNode)
  {
    if ((!paramJsonNode.isArray()) && (paramJsonNode.get("data") != null))
      paramJsonNode = paramJsonNode.get("data");
    this.a = Maps.a();
    for (int i = 0; i < paramJsonNode.size(); i++)
    {
      JsonNode localJsonNode1 = paramJsonNode.get(i);
      String str = JSONUtil.b(localJsonNode1.get("name"));
      JsonNode localJsonNode2 = localJsonNode1.get("fql_result_set");
      this.a.put(str, localJsonNode2);
    }
  }

  public JsonNode a(String paramString)
  {
    return (JsonNode)this.a.get(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FqlResultHelper
 * JD-Core Version:    0.6.0
 */