package com.facebook.orca.database;

import android.net.Uri;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.media.MediaResource.Builder;
import com.facebook.orca.media.MediaResource.Type;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;

public class DbMediaResourceSerialization
{
  private final ObjectMapper a;

  public DbMediaResourceSerialization(ObjectMapper paramObjectMapper)
  {
    this.a = paramObjectMapper;
  }

  String a(List<MediaResource> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()));
    ArrayNode localArrayNode;
    for (String str = null; ; str = localArrayNode.toString())
    {
      return str;
      localArrayNode = new ArrayNode(JsonNodeFactory.instance);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MediaResource localMediaResource = (MediaResource)localIterator.next();
        ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
        localObjectNode.put("type", localMediaResource.b().name());
        localObjectNode.put("uri", localMediaResource.c().toString());
        localObjectNode.put("mimeType", localMediaResource.d());
        localObjectNode.put("fileName", localMediaResource.e());
        localObjectNode.put("duration", localMediaResource.f());
        localArrayNode.add(localObjectNode);
      }
    }
  }

  List<MediaResource> a(String paramString)
  {
    if (StringUtil.a(paramString));
    ImmutableList.Builder localBuilder;
    for (ImmutableList localImmutableList = ImmutableList.d(); ; localImmutableList = localBuilder.b())
    {
      return localImmutableList;
      localBuilder = ImmutableList.e();
      Iterator localIterator = this.a.readTree(paramString).iterator();
      while (localIterator.hasNext())
      {
        JsonNode localJsonNode = (JsonNode)localIterator.next();
        localBuilder.b(MediaResource.a().a(Uri.parse(JSONUtil.b(localJsonNode.get("uri")))).a(MediaResource.Type.valueOf(JSONUtil.b(localJsonNode.get("type")))).a(JSONUtil.b(localJsonNode.get("mimeType"))).b(JSONUtil.b(localJsonNode.get("fileName"))).a(JSONUtil.c(localJsonNode.get("duration"))).f());
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbMediaResourceSerialization
 * JD-Core Version:    0.6.0
 */