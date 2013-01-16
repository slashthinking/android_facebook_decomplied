package com.facebook.orca.database;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.threads.TitanAttachmentInfo;
import com.facebook.orca.threads.TitanAttachmentInfo.ImageData;
import com.facebook.orca.threads.TitanAttachmentInfoBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;

public class DbAttachmentSerialization
{
  private final ObjectMapper a;

  public DbAttachmentSerialization(ObjectMapper paramObjectMapper)
  {
    this.a = paramObjectMapper;
  }

  ImmutableList<TitanAttachmentInfo> a(String paramString)
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
        TitanAttachmentInfoBuilder localTitanAttachmentInfoBuilder = new TitanAttachmentInfoBuilder().a(JSONUtil.b(localJsonNode.get("id"))).a(JSONUtil.d(localJsonNode.get("type"))).b(JSONUtil.b(localJsonNode.get("mime_type"))).c(JSONUtil.b(localJsonNode.get("filename"))).b(JSONUtil.d(localJsonNode.get("file_size")));
        if ((localJsonNode.has("image_data_width")) && (localJsonNode.has("image_data_height")))
          localTitanAttachmentInfoBuilder.a(new TitanAttachmentInfo.ImageData(JSONUtil.d(localJsonNode.get("image_data_width")), JSONUtil.d(localJsonNode.get("image_data_height"))));
        localBuilder.b(localTitanAttachmentInfoBuilder.g());
      }
    }
  }

  String a(List<TitanAttachmentInfo> paramList)
  {
    if (paramList == null);
    ArrayNode localArrayNode;
    for (String str = null; ; str = localArrayNode.toString())
    {
      return str;
      localArrayNode = new ArrayNode(JsonNodeFactory.instance);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        TitanAttachmentInfo localTitanAttachmentInfo = (TitanAttachmentInfo)localIterator.next();
        ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
        localObjectNode.put("id", localTitanAttachmentInfo.a());
        localObjectNode.put("type", localTitanAttachmentInfo.b());
        localObjectNode.put("mime_type", localTitanAttachmentInfo.c());
        localObjectNode.put("filename", localTitanAttachmentInfo.d());
        localObjectNode.put("file_size", localTitanAttachmentInfo.e());
        if (localTitanAttachmentInfo.f() != null)
        {
          localObjectNode.put("image_data_width", localTitanAttachmentInfo.f().a());
          localObjectNode.put("image_data_height", localTitanAttachmentInfo.f().b());
        }
        localArrayNode.add(localObjectNode);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbAttachmentSerialization
 * JD-Core Version:    0.6.0
 */