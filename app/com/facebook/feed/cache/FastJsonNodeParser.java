package com.facebook.feed.cache;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FastJsonNodeParser
{
  private final JsonFactory a;

  public FastJsonNodeParser(JsonFactory paramJsonFactory)
  {
    this.a = paramJsonFactory;
  }

  public JsonNode a(String paramString)
  {
    JsonParser localJsonParser = this.a.createJsonParser(paramString);
    ObjectNode localObjectNode = JsonNodeFactory.instance.objectNode();
    if (localJsonParser.nextToken() != JsonToken.START_OBJECT)
      throw new JsonParseException("Can't find object start location", localJsonParser.getCurrentLocation());
    while (localJsonParser.nextToken() != JsonToken.END_OBJECT)
    {
      String str = localJsonParser.getCurrentName();
      localJsonParser.nextToken();
      localObjectNode.put(str, localJsonParser.getText());
    }
    localJsonParser.close();
    return localObjectNode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FastJsonNodeParser
 * JD-Core Version:    0.6.0
 */