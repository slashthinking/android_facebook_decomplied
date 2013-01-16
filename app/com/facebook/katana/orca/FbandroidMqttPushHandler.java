package com.facebook.katana.orca;

import com.facebook.common.util.Log;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.push.mqtt.MqttPushHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class FbandroidMqttPushHandler
  implements MqttPushHandler
{
  private final FbandroidPushHandler a;
  private final ObjectMapper b;

  public FbandroidMqttPushHandler(FbandroidPushHandler paramFbandroidPushHandler, ObjectMapper paramObjectMapper)
  {
    this.a = paramFbandroidPushHandler;
    this.b = paramObjectMapper;
  }

  private void a(JsonNode paramJsonNode)
  {
    this.a.a(0);
  }

  private void b(JsonNode paramJsonNode)
  {
    int i = JSONUtil.d(paramJsonNode.get("num_unseen"));
    int j = JSONUtil.d(paramJsonNode.get("num_unread"));
    this.a.b(j, i);
  }

  private void c(JsonNode paramJsonNode)
  {
    int i = JSONUtil.d(paramJsonNode.get("unseen"));
    int j = JSONUtil.d(paramJsonNode.get("unread"));
    this.a.a(j, i);
  }

  public void a(String paramString1, String paramString2)
  {
    JsonNode localJsonNode;
    try
    {
      localJsonNode = this.b.readTree(paramString2);
      if ("/push_notification".equals(paramString1))
        return;
      if ("/inbox".equals(paramString1))
        c(localJsonNode);
    }
    catch (IOException localIOException)
    {
      Log.c("IOException", localIOException);
    }
    if ("/mobile_requests_count".equals(paramString1))
      b(localJsonNode);
    else if ("/friend_requests_seen".equals(paramString1))
      a(localJsonNode);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMqttPushHandler
 * JD-Core Version:    0.6.0
 */