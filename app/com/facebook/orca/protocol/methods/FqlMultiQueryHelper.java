package com.facebook.orca.protocol.methods;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FqlMultiQueryHelper
{
  private Map<String, String> a = Maps.a();

  public JsonNode a()
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localObjectNode.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localObjectNode;
  }

  public void a(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FqlMultiQueryHelper
 * JD-Core Version:    0.6.0
 */