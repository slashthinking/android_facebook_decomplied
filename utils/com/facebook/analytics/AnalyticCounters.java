package com.facebook.analytics;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public final class AnalyticCounters
{
  private ConcurrentMap<String, Long> a = Maps.c();

  public static Map<String, Long> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      Iterator localIterator = new ObjectMapper().readTree(paramString).fields();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put(localEntry.getKey(), Long.valueOf(((JsonNode)localEntry.getValue()).longValue()));
      }
    }
    catch (JsonParseException localJsonParseException)
    {
      return localHashMap;
    }
    catch (IOException localIOException)
    {
      label80: break label80;
    }
  }

  public void a()
  {
    this.a.clear();
  }

  public void a(HoneyClientEvent paramHoneyClientEvent)
  {
    JsonNode localJsonNode = b();
    if (localJsonNode.size() > 0)
      paramHoneyClientEvent.a("analytic_counters", localJsonNode);
  }

  public void a(String paramString, long paramLong)
  {
    Long localLong1 = (Long)this.a.get(paramString);
    boolean bool;
    if (localLong1 == null)
      if ((Long)this.a.putIfAbsent(paramString, Long.valueOf(paramLong)) == null)
        bool = true;
    while (bool)
    {
      return;
      bool = false;
      continue;
      Long localLong2 = Long.valueOf(paramLong + localLong1.longValue());
      bool = this.a.replace(paramString, localLong1, localLong2);
    }
  }

  public JsonNode b()
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localObjectNode.put((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
    }
    return localObjectNode;
  }

  public void b(String paramString, long paramLong)
  {
    Long localLong = (Long)this.a.get(paramString);
    boolean bool;
    if (localLong == null)
      if ((Long)this.a.putIfAbsent(paramString, Long.valueOf(paramLong)) == null)
        bool = true;
    while (bool)
    {
      return;
      bool = false;
      continue;
      bool = this.a.replace(paramString, localLong, Long.valueOf(paramLong));
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticCounters
 * JD-Core Version:    0.6.2
 */