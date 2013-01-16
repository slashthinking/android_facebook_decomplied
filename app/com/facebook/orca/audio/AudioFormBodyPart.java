package com.facebook.orca.audio;

import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.apache.http.entity.mime.content.ContentBody;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class AudioFormBodyPart extends FormBodyPart
{
  private final String a;
  private final long b;

  public AudioFormBodyPart(String paramString, ContentBody paramContentBody, long paramLong)
  {
    this(paramString, paramContentBody, "fb_voice_message", paramLong);
  }

  public AudioFormBodyPart(String paramString1, ContentBody paramContentBody, String paramString2, long paramLong)
  {
    super(paramString1, paramContentBody);
    this.a = paramString2;
    this.b = paramLong;
  }

  public ObjectNode d()
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("type", this.a);
    localObjectNode.put("duration", this.b);
    return localObjectNode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioFormBodyPart
 * JD-Core Version:    0.6.0
 */