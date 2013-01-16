package com.facebook.orca.database;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantBuilder;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;

public class DbParticipantsSerialization
{
  private final ObjectMapper a;

  public DbParticipantsSerialization(ObjectMapper paramObjectMapper)
  {
    this.a = paramObjectMapper;
  }

  private ParticipantInfo a(JsonNode paramJsonNode)
  {
    return new ParticipantInfo(UserKey.a(JSONUtil.b(paramJsonNode.path("user_key"))), JSONUtil.b(paramJsonNode.path("name")), JSONUtil.b(paramJsonNode.path("email")));
  }

  private JsonNode a(ThreadParticipant paramThreadParticipant)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("email", paramThreadParticipant.e());
    if (paramThreadParticipant.d() != null)
      localObjectNode.put("user_key", paramThreadParticipant.d().c());
    localObjectNode.put("name", paramThreadParticipant.f());
    if (paramThreadParticipant.h() != null)
      localObjectNode.put("mute", paramThreadParticipant.h().d());
    localObjectNode.put("lastReadReceiptTimestampMs", paramThreadParticipant.i());
    if (!StringUtil.a(paramThreadParticipant.j()))
      localObjectNode.put("lastDeliveredReceiptMsgId", paramThreadParticipant.j());
    return localObjectNode;
  }

  private ThreadParticipant b(JsonNode paramJsonNode)
  {
    ParticipantInfo localParticipantInfo = a(paramJsonNode);
    boolean bool = paramJsonNode.has("mute");
    NotificationSetting localNotificationSetting = null;
    if (bool)
      localNotificationSetting = NotificationSetting.b(JSONUtil.c(paramJsonNode.get("mute")));
    return new ThreadParticipantBuilder().a(localParticipantInfo).a(localNotificationSetting).a(JSONUtil.c(paramJsonNode.get("lastReadReceiptTimestampMs"))).b(JSONUtil.b(paramJsonNode.get("lastDeliveredReceiptMsgId"))).f();
  }

  private JsonNode b(ParticipantInfo paramParticipantInfo)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("email", paramParticipantInfo.a());
    if (paramParticipantInfo.e() != null)
      localObjectNode.put("user_key", paramParticipantInfo.e().c());
    localObjectNode.put("name", paramParticipantInfo.d());
    return localObjectNode;
  }

  public ParticipantInfo a(String paramString)
  {
    if (paramString == null);
    for (ParticipantInfo localParticipantInfo = null; ; localParticipantInfo = a(this.a.readTree(paramString)))
      return localParticipantInfo;
  }

  String a(ParticipantInfo paramParticipantInfo)
  {
    if (paramParticipantInfo == null);
    for (String str = null; ; str = b(paramParticipantInfo).toString())
      return str;
  }

  String a(List<ParticipantInfo> paramList)
  {
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayNode.add(b((ParticipantInfo)localIterator.next()));
    return localArrayNode.toString();
  }

  ImmutableList<ParticipantInfo> b(String paramString)
  {
    JsonNode localJsonNode = this.a.readTree(paramString);
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = localJsonNode.iterator();
    while (localIterator.hasNext())
      localBuilder.b(a((JsonNode)localIterator.next()));
    return localBuilder.b();
  }

  String b(List<ThreadParticipant> paramList)
  {
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayNode.add(a((ThreadParticipant)localIterator.next()));
    return localArrayNode.toString();
  }

  ImmutableList<ThreadParticipant> c(String paramString)
  {
    JsonNode localJsonNode = this.a.readTree(paramString);
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = localJsonNode.iterator();
    while (localIterator.hasNext())
      localBuilder.b(b((JsonNode)localIterator.next()));
    return localBuilder.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbParticipantsSerialization
 * JD-Core Version:    0.6.0
 */