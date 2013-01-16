package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.threads.TitanAttachmentInfo;
import com.facebook.orca.threads.TitanAttachmentInfo.ImageData;
import com.facebook.orca.threads.TitanAttachmentInfoBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

public class AttachmentDeserializer
{
  ImmutableList<TitanAttachmentInfo> a(JsonNode paramJsonNode)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramJsonNode.fieldNames();
    while (localIterator.hasNext())
    {
      JsonNode localJsonNode1 = paramJsonNode.get((String)localIterator.next());
      TitanAttachmentInfoBuilder localTitanAttachmentInfoBuilder = new TitanAttachmentInfoBuilder().a(JSONUtil.b(localJsonNode1.get("id"))).a(JSONUtil.d(localJsonNode1.get("type"))).b(JSONUtil.b(localJsonNode1.get("mime_type"))).c(JSONUtil.b(localJsonNode1.get("filename"))).b(JSONUtil.d(localJsonNode1.get("file_size")));
      if (localJsonNode1.has("image_data"))
      {
        JsonNode localJsonNode2 = localJsonNode1.get("image_data");
        localTitanAttachmentInfoBuilder.a(new TitanAttachmentInfo.ImageData(JSONUtil.d(localJsonNode2.get("width")), JSONUtil.d(localJsonNode2.get("height"))));
      }
      localBuilder.b(localTitanAttachmentInfoBuilder.g());
    }
    return localBuilder.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.AttachmentDeserializer
 * JD-Core Version:    0.6.0
 */