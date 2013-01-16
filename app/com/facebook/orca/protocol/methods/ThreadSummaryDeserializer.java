package com.facebook.orca.protocol.methods;

import android.net.Uri;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantBuilder;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadSummaryBuilder;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ThreadSummaryDeserializer
{
  private final ParticipantInfoDeserializer a;

  public ThreadSummaryDeserializer(ParticipantInfoDeserializer paramParticipantInfoDeserializer)
  {
    this.a = paramParticipantInfoDeserializer;
  }

  private ImmutableList<ThreadParticipant> a(JsonNode paramJsonNode1, JsonNode paramJsonNode2, String paramString)
  {
    return a(paramJsonNode1, paramJsonNode2, paramString, null);
  }

  private ImmutableList<ThreadParticipant> a(JsonNode paramJsonNode1, JsonNode paramJsonNode2, String paramString, Map<String, Long> paramMap)
  {
    HashSet localHashSet = Sets.a();
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramJsonNode1.iterator();
    while (localIterator.hasNext())
    {
      ThreadParticipant localThreadParticipant = b((JsonNode)localIterator.next(), paramJsonNode2, paramString, paramMap);
      if ((!localThreadParticipant.d().d()) || (localHashSet.contains(localThreadParticipant.d())))
        continue;
      localHashSet.add(localThreadParticipant.d());
      localBuilder.b(localThreadParticipant);
    }
    return localBuilder.b();
  }

  private ThreadParticipant b(JsonNode paramJsonNode1, JsonNode paramJsonNode2, String paramString, Map<String, Long> paramMap)
  {
    ParticipantInfo localParticipantInfo = this.a.b(paramJsonNode1);
    if (paramJsonNode2.has(localParticipantInfo.a()));
    for (NotificationSetting localNotificationSetting = NotificationSetting.b(JSONUtil.c(paramJsonNode2.get(localParticipantInfo.a()))); ; localNotificationSetting = NotificationSetting.a)
    {
      ThreadParticipantBuilder localThreadParticipantBuilder = new ThreadParticipantBuilder();
      localThreadParticipantBuilder.a(paramString).a(localParticipantInfo).a(localNotificationSetting);
      if ((paramMap != null) && (localParticipantInfo.e() != null))
      {
        Long localLong = (Long)paramMap.get(localParticipantInfo.e().c());
        if (localLong != null)
          localThreadParticipantBuilder.a(localLong.longValue());
      }
      return localThreadParticipantBuilder.f();
    }
  }

  public ThreadSummary a(JsonNode paramJsonNode)
  {
    ThreadSummaryBuilder localThreadSummaryBuilder = new ThreadSummaryBuilder();
    String str1 = JSONUtil.b(paramJsonNode.get("thread_id"));
    localThreadSummaryBuilder.a(str1);
    long l1 = JSONUtil.c(paramJsonNode.get("timestamp"));
    long l2 = JSONUtil.c(paramJsonNode.get("action_id"));
    localThreadSummaryBuilder.c(l2);
    localThreadSummaryBuilder.d(l1);
    if (paramJsonNode.has("snippet"))
      localThreadSummaryBuilder.c(JSONUtil.b(paramJsonNode.get("snippet")));
    if (JSONUtil.b(paramJsonNode.get("refetch_action_id")) != null)
    {
      localThreadSummaryBuilder.a(JSONUtil.c(paramJsonNode.get("refetch_action_id")));
      if (JSONUtil.b(paramJsonNode.get("last_visible_add_action_id")) == null)
        break label328;
      localThreadSummaryBuilder.b(JSONUtil.c(paramJsonNode.get("last_visible_add_action_id")));
      label135: localThreadSummaryBuilder.b(paramJsonNode.get("unread").booleanValue());
      if ((!paramJsonNode.has("mute")) || (!paramJsonNode.get("mute").isObject()))
        break label338;
    }
    HashMap localHashMap;
    label328: label338: for (Object localObject1 = paramJsonNode.get("mute"); ; localObject1 = NullNode.instance)
    {
      if (JSONUtil.a(paramJsonNode.get("pic_hash")))
        localThreadSummaryBuilder.e(JSONUtil.b(paramJsonNode.get("pic_hash")));
      JsonNode localJsonNode1 = paramJsonNode.get("read_receipts");
      localObject2 = null;
      if (localJsonNode1 == null)
        break label350;
      localHashMap = Maps.a(localJsonNode1.size());
      Iterator localIterator = localJsonNode1.iterator();
      while (localIterator.hasNext())
      {
        JsonNode localJsonNode2 = (JsonNode)localIterator.next();
        String str4 = JSONUtil.b(localJsonNode2.get("uid"));
        UserKey localUserKey = new UserKey(User.Type.FACEBOOK, str4);
        long l3 = JSONUtil.c(localJsonNode2.get("time"));
        localHashMap.put(localUserKey.c(), Long.valueOf(l3));
      }
      localThreadSummaryBuilder.a(l2);
      break;
      localThreadSummaryBuilder.b(l2);
      break label135;
    }
    Object localObject2 = localHashMap;
    label350: ImmutableList localImmutableList1 = a(paramJsonNode.get("participants"), (JsonNode)localObject1, str1, localObject2);
    ImmutableList localImmutableList2 = a(paramJsonNode.get("former_participants"), (JsonNode)localObject1, str1);
    ImmutableList localImmutableList3 = this.a.a(paramJsonNode.get("object_participants"));
    localThreadSummaryBuilder.a(localImmutableList1);
    localThreadSummaryBuilder.b(localImmutableList2);
    localThreadSummaryBuilder.c(localImmutableList3);
    localThreadSummaryBuilder.d(this.a.a(paramJsonNode.get("senders")));
    String str2 = JSONUtil.b(paramJsonNode.get("single_recipient"));
    boolean bool1;
    boolean bool3;
    boolean bool4;
    if (str2 != null)
    {
      bool1 = true;
      localThreadSummaryBuilder.a(bool1);
      if (str2 != null)
        localThreadSummaryBuilder.a(new UserKey(User.Type.FACEBOOK, str2));
      if (JSONUtil.a(paramJsonNode.get("pic")))
        localThreadSummaryBuilder.a(Uri.parse(JSONUtil.b(paramJsonNode.get("pic"))));
      String str3 = JSONUtil.b(paramJsonNode.get("name"));
      if (!StringUtil.a(str3))
        localThreadSummaryBuilder.b(str3);
      boolean bool2 = paramJsonNode.get("is_subscribed").booleanValue();
      localThreadSummaryBuilder.d(bool2);
      if (JSONUtil.a(paramJsonNode.get("snippet_sender")))
        localThreadSummaryBuilder.a(this.a.b(paramJsonNode.get("snippet_sender")));
      if (JSONUtil.a(paramJsonNode.get("admin_snippet")))
        localThreadSummaryBuilder.d(JSONUtil.b(paramJsonNode.get("admin_snippet")));
      bool3 = paramJsonNode.get("can_reply").booleanValue();
      if (!bool2)
        bool3 = false;
      int i = localImmutableList3.size();
      bool4 = false;
      if (i <= 0)
        break label706;
    }
    while (true)
    {
      localThreadSummaryBuilder.c(bool4);
      if (JSONUtil.a(paramJsonNode.get("folder")))
        localThreadSummaryBuilder.a(FolderName.a(JSONUtil.b(paramJsonNode.get("folder"))));
      return localThreadSummaryBuilder.y();
      bool1 = false;
      break;
      label706: bool4 = bool3;
    }
  }

  public void a(ObjectNode paramObjectNode, JsonNode paramJsonNode)
  {
    JsonNode localJsonNode1 = paramObjectNode.get("object_participants");
    int i = 0;
    int j = localJsonNode1.size();
    String str = null;
    if (i < j)
    {
      JsonNode localJsonNode3 = localJsonNode1.get(i);
      if (JSONUtil.d(localJsonNode3.get("object_address_type")) == 2)
        str = JSONUtil.b(localJsonNode3.get("id"));
    }
    else
    {
      if (str != null)
        break label74;
      label66: return;
      break label80;
    }
    while (true)
    {
      i++;
      break;
      label74: Iterator localIterator = paramJsonNode.iterator();
      label80: if (!localIterator.hasNext())
        continue;
      JsonNode localJsonNode2 = (JsonNode)localIterator.next();
      if (!Objects.equal(JSONUtil.b(localJsonNode2.get("id")), str))
        break label66;
      paramObjectNode.put("name", localJsonNode2.get("name"));
      paramObjectNode.put("pic", localJsonNode2.get("pic_big"));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.ThreadSummaryDeserializer
 * JD-Core Version:    0.6.0
 */