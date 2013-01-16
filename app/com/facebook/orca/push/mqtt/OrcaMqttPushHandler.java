package com.facebook.orca.push.mqtt;

import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.orca.cache.DeliveredReadReceiptManager;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.fbwebrtc.WebrtcManager;
import com.facebook.orca.mqtt.MqttQOSLevel;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.push.PushHandler;
import com.facebook.orca.push.PushSource;
import com.facebook.orca.push.c2dm.C2DMRegistrar;
import com.facebook.orca.push.c2dm.PushTokenHolder;
import com.facebook.orca.push.common.PushDeserialization;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OrcaMqttPushHandler
  implements MqttPushHandler
{
  private static final Class<?> a = OrcaMqttPushHandler.class;
  private final Set<PushHandler> b;
  private final PushDeserialization c;
  private final DeliveredReadReceiptManager d;
  private final PresenceManager e;
  private final MqttConnectionManager f;
  private final C2DMRegistrar g;
  private final PushTokenHolder h;
  private final ReliabilityAnalyticsLogger i;
  private final ObjectMapper j;
  private final WebrtcManager k;

  public OrcaMqttPushHandler(Set<PushHandler> paramSet, PushDeserialization paramPushDeserialization, DeliveredReadReceiptManager paramDeliveredReadReceiptManager, PresenceManager paramPresenceManager, MqttConnectionManager paramMqttConnectionManager, C2DMRegistrar paramC2DMRegistrar, PushTokenHolder paramPushTokenHolder, ReliabilityAnalyticsLogger paramReliabilityAnalyticsLogger, ObjectMapper paramObjectMapper, WebrtcManager paramWebrtcManager)
  {
    this.b = paramSet;
    this.c = paramPushDeserialization;
    this.d = paramDeliveredReadReceiptManager;
    this.e = paramPresenceManager;
    this.f = paramMqttConnectionManager;
    this.g = paramC2DMRegistrar;
    this.h = paramPushTokenHolder;
    this.i = paramReliabilityAnalyticsLogger;
    this.j = paramObjectMapper;
    this.k = paramWebrtcManager;
  }

  private String a(Message paramMessage)
  {
    String str1 = paramMessage.f().d();
    String str2 = paramMessage.h();
    if ((StringUtil.a(str1)) || (StringUtil.a(str2)));
    for (String str3 = null; ; str3 = str1 + ": " + str2)
    {
      return str3;
      if (str2.length() <= 120)
        continue;
      str2 = str2.substring(0, 120);
    }
  }

  private void a(PushSource paramPushSource)
  {
    this.i.a("", "", paramPushSource.toString(), "invalid_payload");
  }

  private void a(JsonNode paramJsonNode)
  {
    String str1 = JSONUtil.b(paramJsonNode.get("type"));
    if ("message".equals(str1))
    {
      Message localMessage = this.c.a(paramJsonNode);
      if (localMessage != null)
      {
        String str3 = localMessage.b();
        String str4 = a(localMessage);
        this.e.a(localMessage);
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
          ((PushHandler)localIterator.next()).a(str4, str3, localMessage, PushSource.MQTT);
      }
      a(PushSource.MQTT);
    }
    while (true)
    {
      return;
      if ("typ".equals(str1))
      {
        String str2 = JSONUtil.b(paramJsonNode.get("sender_fbid"));
        int m = JSONUtil.d(paramJsonNode.get("state"));
        this.e.a(new UserKey(User.Type.FACEBOOK, str2), m);
        continue;
      }
    }
  }

  private void a(String paramString)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("registration_id", paramString);
    String str = PushSource.C2DM_OVER_MQTT.toString();
    this.i.a("messaging_push_notif_" + str, "mqtt_other_token", localHashMap, null, null);
  }

  private void b(JsonNode paramJsonNode)
  {
    boolean bool = Objects.equal("full", JSONUtil.b(paramJsonNode.get("list_type")));
    JsonNode localJsonNode1 = paramJsonNode.get("list");
    HashMap localHashMap = Maps.a();
    Iterator localIterator = localJsonNode1.iterator();
    while (localIterator.hasNext())
    {
      JsonNode localJsonNode2 = (JsonNode)localIterator.next();
      String str = Long.toString(JSONUtil.c(localJsonNode2.get("u")));
      int m = JSONUtil.d(localJsonNode2.get("p"));
      localHashMap.put(new UserKey(User.Type.FACEBOOK, str), Integer.valueOf(m));
    }
    this.e.a(localHashMap, bool);
  }

  private void c(JsonNode paramJsonNode)
  {
    String str1 = JSONUtil.b(paramJsonNode.get("event"));
    if ("delivery_receipt".equals(str1))
    {
      String str4 = JSONUtil.b(paramJsonNode.get("from_fbid"));
      String str5 = JSONUtil.b(paramJsonNode.get("mid"));
      String str6 = JSONUtil.b(paramJsonNode.get("tid"));
      BLog.a(a, "Received delivery_receipt from " + str4);
      UserKey localUserKey2 = new UserKey(User.Type.FACEBOOK, str4);
      this.d.a(localUserKey2, str6, str5);
    }
    while (true)
    {
      return;
      if ("read_receipt".equals(str1))
      {
        String str2 = JSONUtil.b(paramJsonNode.get("reader_fbid"));
        long l = JSONUtil.c(paramJsonNode.get("timestamp"));
        String str3 = JSONUtil.b(paramJsonNode.get("tid"));
        BLog.a(a, "Received read_recept from " + str2);
        UserKey localUserKey1 = new UserKey(User.Type.FACEBOOK, str2);
        this.d.a(localUserKey1, str3, l);
        continue;
      }
    }
  }

  private void d(JsonNode paramJsonNode)
  {
    String str1 = JSONUtil.b(paramJsonNode.get("message"));
    JsonNode localJsonNode = paramJsonNode.get("params");
    String str2 = JSONUtil.b(paramJsonNode.get("token"));
    if (!Objects.equal(str2, this.h.a()))
    {
      BLog.b(a, "Ignoring MQTT push for other token");
      a(str2);
    }
    while (true)
    {
      return;
      BLog.b(a, "Received MQTT push");
      String str3 = JSONUtil.b(paramJsonNode.get("async_job"));
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("async_job", str3);
      this.f.a("/send_push_notification_ack", localObjectNode, MqttQOSLevel.FIRE_AND_FORGET);
      if (!"pushnot".equals(JSONUtil.b(paramJsonNode.get("type"))))
        continue;
      String str4 = JSONUtil.b(paramJsonNode.get("notif_type"));
      if ((!"msg".equals(str4)) && (!"orca_message".equals(str4)))
        continue;
      Message localMessage = this.c.a(str1, localJsonNode);
      if (localMessage != null)
      {
        String str5 = localMessage.b();
        this.e.a(localMessage);
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
          ((PushHandler)localIterator.next()).a(str1, str5, localMessage, PushSource.C2DM_OVER_MQTT);
        continue;
      }
      a(PushSource.C2DM_OVER_MQTT);
    }
  }

  private void e(JsonNode paramJsonNode)
  {
    if (!this.k.b());
    while (true)
    {
      return;
      Long localLong = Long.valueOf(JSONUtil.c(paramJsonNode.get("from")));
      String str = JSONUtil.b(paramJsonNode.get("payload"));
      this.k.a(localLong.longValue(), str);
    }
  }

  private void f(JsonNode paramJsonNode)
  {
    if (!this.k.b());
    while (true)
    {
      return;
      Long localLong = Long.valueOf(JSONUtil.c(paramJsonNode.get("id")));
      String str = JSONUtil.b(paramJsonNode.get("errStr"));
      int m = JSONUtil.d(paramJsonNode.get("errno"));
      this.k.a(localLong.longValue(), str, m);
    }
  }

  public void a(String paramString1, String paramString2)
  {
    JsonNode localJsonNode;
    try
    {
      localJsonNode = this.j.readTree(paramString2);
      if (BLog.b(2))
        BLog.a(a, "Publish:\n" + localJsonNode.toString());
      if (("/orca_message_notifications".equals(paramString1)) || ("/orca_typing_notifications".equals(paramString1)))
      {
        a(localJsonNode);
        return;
      }
      if ("/orca_presence".equals(paramString1))
        b(localJsonNode);
    }
    catch (IOException localIOException)
    {
      BLog.c(a, "IOException", localIOException);
    }
    if ("/messaging_events".equals(paramString1))
      c(localJsonNode);
    else if ("/push_notification".equals(paramString1))
      d(localJsonNode);
    else if ("/webrtc".equals(paramString1))
      e(localJsonNode);
    else if ("/webrtc_response".equals(paramString1))
      f(localJsonNode);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.OrcaMqttPushHandler
 * JD-Core Version:    0.6.0
 */