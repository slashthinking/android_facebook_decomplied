package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;

public class SourceDeserializer
{
  public String a(JsonNode paramJsonNode)
  {
    int i = 0;
    String str2;
    String str1;
    if (i < paramJsonNode.size())
    {
      str2 = JSONUtil.b(paramJsonNode.get(i));
      if (str2.equals("messenger"))
        str1 = str2;
    }
    while (true)
    {
      return str1;
      if (str2.startsWith("source:"))
      {
        str1 = str2.substring("source:".length());
        continue;
      }
      i++;
      break;
      str1 = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.SourceDeserializer
 * JD-Core Version:    0.6.0
 */