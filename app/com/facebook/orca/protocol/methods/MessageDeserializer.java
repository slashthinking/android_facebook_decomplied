package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.location.CoordinatesDeserializer;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessageBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import java.util.ArrayList;
import java.util.List;

public class MessageDeserializer
{
  private final ParticipantInfoDeserializer a;
  private final ShareDeserializer b;
  private final AttachmentDeserializer c;
  private final CoordinatesDeserializer d;
  private final SourceDeserializer e;

  public MessageDeserializer(ParticipantInfoDeserializer paramParticipantInfoDeserializer, ShareDeserializer paramShareDeserializer, AttachmentDeserializer paramAttachmentDeserializer, CoordinatesDeserializer paramCoordinatesDeserializer, SourceDeserializer paramSourceDeserializer)
  {
    this.a = paramParticipantInfoDeserializer;
    this.b = paramShareDeserializer;
    this.c = paramAttachmentDeserializer;
    this.d = paramCoordinatesDeserializer;
    this.e = paramSourceDeserializer;
  }

  private Message b(JsonNode paramJsonNode)
  {
    MessageBuilder localMessageBuilder = new MessageBuilder();
    long l = JSONUtil.c(paramJsonNode.get("action_id"));
    localMessageBuilder.a("a_" + Long.toString(l));
    localMessageBuilder.b(JSONUtil.b(paramJsonNode.get("thread_id")));
    localMessageBuilder.c(l);
    int i = JSONUtil.d(paramJsonNode.get("type"));
    if (i == 1)
      localMessageBuilder.a(1);
    while (true)
    {
      JsonNode localJsonNode = paramJsonNode.get("actor");
      localMessageBuilder.a(JSONUtil.c(paramJsonNode.get("timestamp")));
      localMessageBuilder.a(this.a.b(localJsonNode));
      localMessageBuilder.d(this.a.a(paramJsonNode.get("users")));
      localMessageBuilder.d(JSONUtil.b(paramJsonNode.get("body")));
      return localMessageBuilder.v();
      if (i == 2)
      {
        localMessageBuilder.a(2);
        continue;
      }
      localMessageBuilder.a(1000);
    }
  }

  public Message a(JsonNode paramJsonNode)
  {
    MessageBuilder localMessageBuilder = new MessageBuilder();
    localMessageBuilder.a(JSONUtil.b(paramJsonNode.get("message_id")));
    localMessageBuilder.b(JSONUtil.b(paramJsonNode.get("thread_id")));
    localMessageBuilder.d(JSONUtil.b(paramJsonNode.get("body")));
    localMessageBuilder.a(JSONUtil.c(paramJsonNode.get("timestamp")));
    localMessageBuilder.c(JSONUtil.c(paramJsonNode.get("action_id")));
    boolean bool1 = paramJsonNode.has("log_message");
    int i = 0;
    JsonNode localJsonNode2;
    if (bool1)
    {
      boolean bool2 = paramJsonNode.get("log_message").isObject();
      i = 0;
      if (bool2)
      {
        localJsonNode2 = paramJsonNode.get("log_message");
        if (!localJsonNode2.has("threadPic"))
          break label355;
        if (!localJsonNode2.get("threadPic").path("deleted").asBoolean(false))
          break label349;
        i = 7;
      }
    }
    while (true)
    {
      localMessageBuilder.a(i);
      JsonNode localJsonNode1 = paramJsonNode.get("sender");
      localMessageBuilder.a(this.a.b(localJsonNode1));
      if ((paramJsonNode.has("attachment_map")) && (paramJsonNode.get("attachment_map").isObject()))
        localMessageBuilder.b(this.c.a(paramJsonNode.get("attachment_map")));
      if ((paramJsonNode.has("share_map")) && (paramJsonNode.get("share_map").isObject()))
        localMessageBuilder.c(this.b.a(paramJsonNode.get("share_map")));
      if ((paramJsonNode.has("coordinates")) && (!paramJsonNode.get("coordinates").isNull()) && (paramJsonNode.get("coordinates").isObject()))
        localMessageBuilder.a(this.d.a(paramJsonNode.get("coordinates")));
      localMessageBuilder.e(JSONUtil.b(paramJsonNode.get("offline_threading_id")));
      localMessageBuilder.f(this.e.a(paramJsonNode.get("tags")));
      return localMessageBuilder.v();
      label349: i = 4;
      continue;
      label355: if (localJsonNode2.has("threadName"))
      {
        i = 3;
        continue;
      }
      boolean bool3 = localJsonNode2.has("videoCallLog");
      i = 0;
      if (!bool3)
        continue;
      if (localJsonNode2.get("videoCallLog").get("answered").asBoolean())
      {
        i = 5;
        continue;
      }
      i = 6;
    }
  }

  public ImmutableList<Message> a(JsonNode paramJsonNode1, JsonNode paramJsonNode2, int paramInt)
  {
    int i = 0;
    ArrayList localArrayList1 = Lists.a();
    for (int j = 0; j < paramJsonNode1.size(); j++)
      localArrayList1.add(a(paramJsonNode1.get(j)));
    ArrayList localArrayList2 = Lists.a();
    for (int k = 0; k < paramJsonNode2.size(); k++)
      localArrayList2.add(b(paramJsonNode2.get(k)));
    PeekingIterator localPeekingIterator1 = Iterators.g(localArrayList1.iterator());
    PeekingIterator localPeekingIterator2 = Iterators.g(localArrayList2.iterator());
    ImmutableList.Builder localBuilder = ImmutableList.e();
    while (((localPeekingIterator1.hasNext()) || (localPeekingIterator2.hasNext())) && (i < paramInt))
    {
      Message localMessage1;
      if (localPeekingIterator1.hasNext())
      {
        localMessage1 = (Message)localPeekingIterator1.a();
        label162: if (!localPeekingIterator2.hasNext())
          break label236;
      }
      label236: for (Message localMessage2 = (Message)localPeekingIterator2.a(); ; localMessage2 = null)
      {
        if ((localMessage1 == null) || (localMessage2 == null))
          break label264;
        if (localMessage1.c() <= localMessage2.c())
          break label242;
        localBuilder.b(localMessage1);
        localPeekingIterator1.next();
        i++;
        break;
        localMessage1 = null;
        break label162;
      }
      label242: localBuilder.b(localMessage2);
      localPeekingIterator2.next();
      i++;
      continue;
      label264: if (localMessage1 != null)
      {
        localBuilder.b(localMessage1);
        localPeekingIterator1.next();
        i++;
        continue;
      }
      if (localMessage2 == null)
        continue;
      localBuilder.b(localMessage2);
      localPeekingIterator2.next();
      i++;
    }
    return localBuilder.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.MessageDeserializer
 * JD-Core Version:    0.6.0
 */