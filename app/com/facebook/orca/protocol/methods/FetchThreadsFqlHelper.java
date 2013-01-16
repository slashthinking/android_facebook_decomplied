package com.facebook.orca.protocol.methods;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.FolderType;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserSerialization;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Provider;

public class FetchThreadsFqlHelper
{
  private final ThreadSummaryDeserializer a;
  private final UserFqlHelper b;
  private final UserSerialization c;
  private final MessageDeserializer d;
  private final Provider<Boolean> e;
  private final Provider<Boolean> f;

  public FetchThreadsFqlHelper(ThreadSummaryDeserializer paramThreadSummaryDeserializer, UserFqlHelper paramUserFqlHelper, UserSerialization paramUserSerialization, MessageDeserializer paramMessageDeserializer, Provider<Boolean> paramProvider1, Provider<Boolean> paramProvider2)
  {
    this.a = paramThreadSummaryDeserializer;
    this.b = paramUserFqlHelper;
    this.c = paramUserSerialization;
    this.d = paramMessageDeserializer;
    this.e = paramProvider1;
    this.f = paramProvider2;
  }

  FetchThreadsFqlHelper.MessagesResult a(FqlResultHelper paramFqlResultHelper, int paramInt)
  {
    if (paramInt == 0);
    JsonNode localJsonNode1;
    JsonNode localJsonNode2;
    for (FetchThreadsFqlHelper.MessagesResult localMessagesResult = new FetchThreadsFqlHelper.MessagesResult(ImmutableList.d(), 0); ; localMessagesResult = new FetchThreadsFqlHelper.MessagesResult(this.d.a(localJsonNode1, localJsonNode2, paramInt), localJsonNode1.size() + localJsonNode2.size()))
    {
      return localMessagesResult;
      localJsonNode1 = paramFqlResultHelper.a("messages");
      if (localJsonNode1 == null)
        throw new Exception("Invalid api response - missing messages");
      localJsonNode2 = paramFqlResultHelper.a("actions");
      if (localJsonNode2 != null)
        continue;
      throw new Exception("Invalid api response - missing actions");
    }
  }

  FetchThreadsFqlHelper.ThreadsResult a(FqlResultHelper paramFqlResultHelper, boolean paramBoolean, int paramInt)
  {
    JsonNode localJsonNode1 = paramFqlResultHelper.a("threads");
    if (localJsonNode1 == null)
      throw new Exception("Invalid api response - missing threads");
    JsonNode localJsonNode2 = paramFqlResultHelper.a("users");
    JsonNode localJsonNode3 = paramFqlResultHelper.a("participant_profiles");
    JsonNode localJsonNode4 = paramFqlResultHelper.a("object_participant_profiles");
    if (localJsonNode2 == null)
      throw new Exception("Invalid api response - missing users");
    if (localJsonNode3 == null)
      throw new Exception("Invalid api response - missing participant_profiles");
    if (localJsonNode4 == null)
      throw new Exception("Invalid api response - missing object_participant_profiles");
    ImmutableList.Builder localBuilder1 = ImmutableList.e();
    ImmutableList.Builder localBuilder2 = ImmutableList.e();
    ImmutableList.Builder localBuilder3 = ImmutableList.e();
    long l = -1L;
    int i = 0;
    if ((i < localJsonNode1.size()) && (i < paramInt))
    {
      JsonNode localJsonNode7 = localJsonNode1.get(i);
      this.a.a((ObjectNode)localJsonNode7, localJsonNode4);
      l = Math.max(JSONUtil.c(localJsonNode7.get("action_id")), l);
      String str;
      if (paramBoolean)
        if ("deleted".equals(JSONUtil.b(localJsonNode7.get("sync_change_type"))))
        {
          boolean bool = localJsonNode7.get("archived").booleanValue();
          str = JSONUtil.b(localJsonNode7.get("thread_id"));
          if (bool)
            localBuilder3.b(str);
        }
      while (true)
      {
        i++;
        break;
        localBuilder2.b(str);
        continue;
        localBuilder1.b(this.a.a(localJsonNode7));
        continue;
        localBuilder1.b(this.a.a(localJsonNode7));
      }
    }
    ImmutableList localImmutableList1 = localBuilder1.b();
    ImmutableList localImmutableList2 = localBuilder2.b();
    ImmutableList localImmutableList3 = localBuilder3.b();
    JsonNode localJsonNode5 = this.b.a(new JsonNode[] { localJsonNode3, localJsonNode4 });
    JsonNode localJsonNode6 = this.b.a(localJsonNode2, localJsonNode5);
    return new FetchThreadsFqlHelper.ThreadsResult(localImmutableList1, localImmutableList2, localImmutableList3, this.c.a(User.Type.FACEBOOK, localJsonNode6), localJsonNode1.size(), l);
  }

  User a(FqlResultHelper paramFqlResultHelper)
  {
    JsonNode localJsonNode1 = paramFqlResultHelper.a("canonical_thread_user");
    JsonNode localJsonNode2 = paramFqlResultHelper.a("canonical_thread_profile");
    if (localJsonNode1 == null)
      throw new Exception("Invalid api response - missing users");
    if (localJsonNode2 == null)
      throw new Exception("Invalid api response - missing participant_profiles");
    JsonNode localJsonNode3 = this.b.a(localJsonNode1, localJsonNode2);
    ImmutableList localImmutableList = this.c.a(User.Type.FACEBOOK, localJsonNode3);
    if (localImmutableList.size() > 1)
      throw new Exception("Invalid api response -- multiple users");
    if (localImmutableList.size() == 0)
      throw new Exception("Failed to find user");
    return (User)localImmutableList.get(0);
  }

  void a(FqlMultiQueryHelper paramFqlMultiQueryHelper)
  {
    paramFqlMultiQueryHelper.a("user_settings", "SELECT setting, value FROM user_settings WHERE project='messaging'");
  }

  void a(FqlMultiQueryHelper paramFqlMultiQueryHelper, FolderName paramFolderName)
  {
    paramFqlMultiQueryHelper.a("folder_counts", StringLocaleUtil.a("SELECT folder, unread_count, unseen_count, last_seen_time, total_threads, last_action_id FROM unified_message_count WHERE folder='%1$s'", new Object[] { paramFolderName }));
  }

  void a(FqlMultiQueryHelper paramFqlMultiQueryHelper, String paramString)
  {
    paramFqlMultiQueryHelper.a("canonical_thread_id", StringLocaleUtil.a("SELECT thread_id FROM unified_thread WHERE single_recipient = %1$s LIMIT 1", new Object[] { paramString }));
  }

  void a(FqlMultiQueryHelper paramFqlMultiQueryHelper, String paramString1, String paramString2, int paramInt)
  {
    b(paramFqlMultiQueryHelper, paramString1, paramString2, paramInt);
    c(paramFqlMultiQueryHelper, paramString1, paramString2, paramInt);
  }

  void a(FqlMultiQueryHelper paramFqlMultiQueryHelper, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    a(paramFqlMultiQueryHelper, paramString1, paramString2, paramInt, paramBoolean, false);
  }

  void a(FqlMultiQueryHelper paramFqlMultiQueryHelper, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1;
    int i;
    label40: String str2;
    label63: String str3;
    label81: StringBuilder localStringBuilder3;
    if (paramBoolean1)
    {
      str1 = "unified_thread_sync";
      if ((!((Boolean)this.e.b()).booleanValue()) || (!paramBoolean2) || (paramBoolean1))
        break label235;
      i = 1;
      StringBuilder localStringBuilder1 = new StringBuilder().append("SELECT thread_id, senders, participants, former_participants, object_participants, single_recipient, snippet, unread, action_id, last_visible_add_action_id, timestamp, name, pic_hash, mute, can_reply, snippet_sender, is_subscribed, admin_snippet, archived, folder");
      if (i == 0)
        break label241;
      str2 = ", read_receipts";
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
      if (!paramBoolean1)
        break label249;
      str3 = ", sync_change_type ";
      String str4 = str3 + " FROM %1$s WHERE %2$s ORDER BY %3$s LIMIT %4$d";
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = str1;
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = paramString2;
      arrayOfObject[3] = Integer.valueOf(paramInt);
      paramFqlMultiQueryHelper.a("threads", StringLocaleUtil.a(str4, arrayOfObject));
      paramFqlMultiQueryHelper.a("participant_profiles", "SELECT id, name, type, pic_big, pic_square, pic_crop FROM profile WHERE id in (SELECT participants.user_id FROM #threads)");
      paramFqlMultiQueryHelper.a("object_participant_profiles", "SELECT id, name, type, pic_big, pic_square, pic_crop FROM profile WHERE id in (SELECT object_participants.id FROM #threads)");
      localStringBuilder3 = new StringBuilder().append("SELECT uid, first_name, last_name");
      if (!((Boolean)this.f.b()).booleanValue())
        break label257;
    }
    label257: for (String str5 = " , last_active"; ; str5 = "")
    {
      paramFqlMultiQueryHelper.a("users", str5 + " FROM user WHERE uid IN " + "(SELECT participants.user_id FROM #threads)");
      return;
      str1 = "unified_thread";
      break;
      label235: i = 0;
      break label40;
      label241: str2 = "";
      break label63;
      label249: str3 = "";
      break label81;
    }
  }

  FetchThreadsFqlHelper.MessagesResult b(FqlResultHelper paramFqlResultHelper, int paramInt)
  {
    JsonNode localJsonNode = paramFqlResultHelper.a("messages");
    if (localJsonNode == null)
      throw new Exception("Invalid api response - missing messages");
    return new FetchThreadsFqlHelper.MessagesResult(this.d.a(localJsonNode, NullNode.getInstance(), paramInt), localJsonNode.size());
  }

  String b(FqlResultHelper paramFqlResultHelper)
  {
    JsonNode localJsonNode = paramFqlResultHelper.a("canonical_thread_id");
    if (localJsonNode == null)
      throw new Exception("Invalid api response - missing canonical thread id");
    if (localJsonNode.size() != 1)
      throw new Exception("Invalid api response - missing canonical thread id");
    return JSONUtil.b(localJsonNode.get(0).get("thread_id"));
  }

  void b(FqlMultiQueryHelper paramFqlMultiQueryHelper, String paramString)
  {
    paramFqlMultiQueryHelper.a("canonical_thread_profile", StringLocaleUtil.a("SELECT id, name, type, pic_big, pic_square, pic_crop FROM profile WHERE id = %1$s", new Object[] { paramString }));
    paramFqlMultiQueryHelper.a("canonical_thread_user", StringLocaleUtil.a("SELECT uid, first_name, last_name FROM user WHERE uid = %1$s", new Object[] { paramString }));
  }

  void b(FqlMultiQueryHelper paramFqlMultiQueryHelper, String paramString1, String paramString2, int paramInt)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramString2;
    arrayOfObject[2] = Integer.valueOf(paramInt);
    paramFqlMultiQueryHelper.a("messages", StringLocaleUtil.a("SELECT thread_id, message_id, action_id, body, sender, unread, recipients, timestamp, attachment_map, share_map, coordinates, log_message, offline_threading_id, tags FROM unified_message WHERE %1$s ORDER BY %2$s LIMIT %3$d", arrayOfObject));
  }

  FolderName c(FqlResultHelper paramFqlResultHelper)
  {
    JsonNode localJsonNode = paramFqlResultHelper.a("folder_counts");
    if (localJsonNode == null)
      throw new Exception("Invalid api response - missing folder");
    if (localJsonNode.size() != 1)
      throw new Exception("Invalid api response - missing folder");
    return FolderName.a(FolderType.a(JSONUtil.b(localJsonNode.get(0).get("folder"))));
  }

  void c(FqlMultiQueryHelper paramFqlMultiQueryHelper, String paramString1, String paramString2, int paramInt)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramString2;
    arrayOfObject[2] = Integer.valueOf(paramInt);
    paramFqlMultiQueryHelper.a("actions", StringLocaleUtil.a("SELECT thread_id, action_id, type, actor, users, timestamp, body FROM unified_thread_action WHERE %1$s ORDER BY %2$s LIMIT %3$d", arrayOfObject));
  }

  FolderCounts d(FqlResultHelper paramFqlResultHelper)
  {
    JsonNode localJsonNode1 = paramFqlResultHelper.a("folder_counts");
    if (localJsonNode1 == null)
      throw new Exception("Invalid api response - missing folder counts");
    if (localJsonNode1.size() != 1)
      throw new Exception("Invalid api response - missing folder counts");
    JsonNode localJsonNode2 = localJsonNode1.get(0);
    return new FolderCounts(JSONUtil.d(localJsonNode2.get("unread_count")), JSONUtil.d(localJsonNode2.get("unseen_count")), JSONUtil.c(localJsonNode2.get("last_seen_time")), JSONUtil.c(localJsonNode2.get("last_action_id")));
  }

  NotificationSetting e(FqlResultHelper paramFqlResultHelper)
  {
    JsonNode localJsonNode1 = paramFqlResultHelper.a("user_settings");
    if (localJsonNode1 == null)
      throw new Exception("Invalid api response - missing user settings");
    int i = 0;
    JsonNode localJsonNode2;
    if (i < localJsonNode1.size())
    {
      localJsonNode2 = localJsonNode1.get(i);
      if (!"mute_until".equals(JSONUtil.b(localJsonNode2.get("setting"))));
    }
    for (NotificationSetting localNotificationSetting = NotificationSetting.b(JSONUtil.c(localJsonNode2.get("value"))); ; localNotificationSetting = null)
    {
      return localNotificationSetting;
      i++;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchThreadsFqlHelper
 * JD-Core Version:    0.6.0
 */