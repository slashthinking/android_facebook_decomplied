package com.facebook.orca.database;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.compose.MessageDraft;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;

public class DbDraftSerialization
{
  private final DbMediaResourceSerialization a;
  private final ObjectMapper b;

  public DbDraftSerialization(DbMediaResourceSerialization paramDbMediaResourceSerialization, ObjectMapper paramObjectMapper)
  {
    this.a = paramDbMediaResourceSerialization;
    this.b = paramObjectMapper;
  }

  MessageDraft a(String paramString)
  {
    MessageDraft localMessageDraft;
    if (StringUtil.a(paramString))
      localMessageDraft = null;
    while (true)
    {
      return localMessageDraft;
      JsonNode localJsonNode = this.b.readTree(paramString);
      String str1 = localJsonNode.get("text").textValue();
      boolean bool = localJsonNode.has("cursorPosition");
      int i = 0;
      if (bool)
        i = localJsonNode.get("cursorPosition").intValue();
      if (localJsonNode.has("attachmentData"))
      {
        String str2 = localJsonNode.get("attachmentData").textValue();
        localMessageDraft = new MessageDraft(str1, i, this.a.a(str2));
        continue;
      }
      localMessageDraft = new MessageDraft(str1, i);
    }
  }

  String a(MessageDraft paramMessageDraft)
  {
    if (paramMessageDraft == null);
    ObjectNode localObjectNode;
    for (String str = null; ; str = localObjectNode.toString())
    {
      return str;
      localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("text", paramMessageDraft.a());
      localObjectNode.put("cursorPosition", paramMessageDraft.b());
      if (paramMessageDraft.c().isEmpty())
        continue;
      localObjectNode.put("attachmentData", this.a.a(paramMessageDraft.c()));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbDraftSerialization
 * JD-Core Version:    0.6.0
 */