package com.facebook.analytics;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ValueNode;

class HoneyAnalyticsUploadHandler$RawJsonBlobNode extends ValueNode
{
  private final String b;

  public HoneyAnalyticsUploadHandler$RawJsonBlobNode(HoneyAnalyticsUploadHandler paramHoneyAnalyticsUploadHandler, String paramString)
  {
    this.b = paramString;
  }

  public String asText()
  {
    return this.b;
  }

  public JsonToken asToken()
  {
    return JsonToken.START_OBJECT;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isNull()
  {
    return false;
  }

  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonGenerator.writeRawValue(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.HoneyAnalyticsUploadHandler.RawJsonBlobNode
 * JD-Core Version:    0.6.2
 */