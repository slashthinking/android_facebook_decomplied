package com.facebook.orca.threadview;

import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessageDeliveredReadStateDisplayUtil
{
  private static final WtfToken a = new WtfToken();
  private static final Class<?> b = MessageDeliveredReadStateDisplayUtil.class;
  private final DataCache c;

  public MessageDeliveredReadStateDisplayUtil(DataCache paramDataCache)
  {
    this.c = paramDataCache;
  }

  private long a(Message paramMessage)
  {
    long l;
    if ((paramMessage.d()) && (paramMessage.e() < paramMessage.c()))
      l = paramMessage.e();
    while (true)
    {
      return l;
      l = paramMessage.c();
    }
  }

  private MessageDeliveredReadInfo a(Set<ThreadParticipant> paramSet1, Set<ThreadParticipant> paramSet2, Set<ThreadParticipant> paramSet3, Message paramMessage, ThreadSummary paramThreadSummary)
  {
    return b(paramSet1, paramSet2, paramSet3, paramMessage, paramThreadSummary);
  }

  private void a(String paramString, MessageDeliveredReadInfo paramMessageDeliveredReadInfo, ThreadParticipant paramThreadParticipant, Message paramMessage, ThreadSummary paramThreadSummary, UserKey paramUserKey, Set<ThreadParticipant> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    localStringBuilder.append("logMessageDeliveredReadInfo\n");
    localStringBuilder.append(paramString).append("\n");
    if (paramMessageDeliveredReadInfo != null)
    {
      localStringBuilder.append("type: ").append(paramMessageDeliveredReadInfo.d()).append('\n');
      localStringBuilder.append("receiptTimestampMs: ").append(paramMessageDeliveredReadInfo.e()).append('\n');
      if (paramMessageDeliveredReadInfo.c() != null)
        localStringBuilder.append("deliveree: ").append(paramMessageDeliveredReadInfo.c()).append('\n');
      if (paramMessageDeliveredReadInfo.b() != null)
        localStringBuilder.append("sender: ").append(paramMessageDeliveredReadInfo.b()).append('\n');
      if (paramMessageDeliveredReadInfo.a() != null)
      {
        localStringBuilder.append("readers:\n");
        Iterator localIterator2 = paramMessageDeliveredReadInfo.a().iterator();
        while (localIterator2.hasNext())
          localStringBuilder.append((RowReceiptParticipant)localIterator2.next()).append('\n');
      }
    }
    if (paramThreadParticipant != null)
      localStringBuilder.append("threadParticipant: ").append(paramThreadParticipant).append('\n');
    if (paramMessage != null)
    {
      localStringBuilder.append("message: ").append(paramMessage).append('\n');
      localStringBuilder.append("message sender: ").append(paramMessage.f()).append('\n');
      localStringBuilder.append("getSentOrServerTimestamp: ").append(a(paramMessage)).append('\n');
    }
    if (paramThreadSummary != null)
      localStringBuilder.append("threadSummary: ").append(paramThreadSummary).append('\n');
    if (paramUserKey != null)
      localStringBuilder.append("meUserKey: ").append(paramUserKey).append('\n');
    if (paramSet != null)
    {
      localStringBuilder.append("readThreadParticipants:\n");
      Iterator localIterator1 = paramSet.iterator();
      while (localIterator1.hasNext())
        localStringBuilder.append((ThreadParticipant)localIterator1.next()).append('\n');
    }
    BLog.a(a, b, localStringBuilder.toString());
  }

  private boolean a(Message paramMessage, ThreadParticipant paramThreadParticipant)
  {
    if ((d(paramMessage, paramThreadParticipant)) || (c(paramMessage, paramThreadParticipant)) || (b(paramMessage, paramThreadParticipant)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean a(Message paramMessage, ThreadParticipant paramThreadParticipant, ThreadSummary paramThreadSummary)
  {
    if ((a(paramMessage, paramThreadParticipant)) && (!paramThreadSummary.g()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean a(UserKey paramUserKey, ThreadParticipant paramThreadParticipant)
  {
    if ((paramThreadParticipant.b()) && (paramThreadParticipant.d().equals(paramUserKey)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private MessageDeliveredReadInfo b(Set<ThreadParticipant> paramSet1, Set<ThreadParticipant> paramSet2, Set<ThreadParticipant> paramSet3, Message paramMessage, ThreadSummary paramThreadSummary)
  {
    UserKey localUserKey = this.c.b();
    MessageDeliveredReadInfo localMessageDeliveredReadInfo;
    if (localUserKey == null)
      localMessageDeliveredReadInfo = null;
    while (true)
    {
      return localMessageDeliveredReadInfo;
      localMessageDeliveredReadInfo = null;
      Iterator localIterator1 = paramSet1.iterator();
      while (localIterator1.hasNext())
      {
        ThreadParticipant localThreadParticipant2 = (ThreadParticipant)localIterator1.next();
        if (a(localUserKey, localThreadParticipant2))
        {
          localIterator1.remove();
          continue;
        }
        if (a(paramMessage, localThreadParticipant2, paramThreadSummary))
        {
          if ((localMessageDeliveredReadInfo != null) && (localMessageDeliveredReadInfo.d() != MessageDeliveredReadInfo.Type.READER))
            a("isMessageSentByThreadParticipantInGroup", localMessageDeliveredReadInfo, localThreadParticipant2, paramMessage, paramThreadSummary, localUserKey, paramSet1);
          if ((localMessageDeliveredReadInfo == null) || (localMessageDeliveredReadInfo.d() == MessageDeliveredReadInfo.Type.READER));
          for (boolean bool3 = true; ; bool3 = false)
          {
            Preconditions.checkState(bool3, "messageDeliveredReadInfo should be null or of type READER");
            localIterator1.remove();
            paramSet2.remove(localThreadParticipant2);
            break;
          }
        }
        if (b(paramMessage, localThreadParticipant2, paramThreadSummary))
        {
          if (localMessageDeliveredReadInfo != null)
            a("isMessageSentByThreadParticipantInCanonical", localMessageDeliveredReadInfo, localThreadParticipant2, paramMessage, paramThreadSummary, localUserKey, paramSet1);
          if (localMessageDeliveredReadInfo == null);
          for (boolean bool2 = true; ; bool2 = false)
          {
            Preconditions.checkState(bool2, "messageDeliveredReadInfo should be null");
            localIterator1.remove();
            paramSet2.remove(localThreadParticipant2);
            localMessageDeliveredReadInfo = MessageDeliveredReadInfo.a(localThreadParticipant2.a());
            break;
          }
        }
        if (!e(paramMessage, localThreadParticipant2))
          continue;
        if ((localMessageDeliveredReadInfo != null) && (localMessageDeliveredReadInfo.d() != MessageDeliveredReadInfo.Type.READER))
          a("isMessageReadByThreadParticipant", localMessageDeliveredReadInfo, localThreadParticipant2, paramMessage, paramThreadSummary, localUserKey, paramSet1);
        if ((localMessageDeliveredReadInfo == null) || (localMessageDeliveredReadInfo.d() == MessageDeliveredReadInfo.Type.READER));
        for (boolean bool1 = true; ; bool1 = false)
        {
          Preconditions.checkState(bool1, "messageDeliveredReadInfo should be null or of type READER");
          localIterator1.remove();
          paramSet2.remove(localThreadParticipant2);
          if (localMessageDeliveredReadInfo == null)
            localMessageDeliveredReadInfo = MessageDeliveredReadInfo.a(localThreadParticipant2.i());
          localMessageDeliveredReadInfo.a(new RowReceiptParticipant(localThreadParticipant2.a(), localThreadParticipant2.i()));
          break;
        }
      }
      if (paramThreadSummary.g())
        continue;
      Iterator localIterator2 = paramSet3.iterator();
      while (localIterator2.hasNext())
      {
        ThreadParticipant localThreadParticipant1 = (ThreadParticipant)localIterator2.next();
        if (a(localUserKey, localThreadParticipant1))
        {
          localIterator2.remove();
          continue;
        }
        if (!c(paramMessage, localThreadParticipant1, paramThreadSummary))
          continue;
        localIterator2.remove();
        if (localMessageDeliveredReadInfo != null)
          continue;
        localMessageDeliveredReadInfo = MessageDeliveredReadInfo.a(localThreadParticipant1.a());
      }
    }
  }

  private boolean b(Message paramMessage, ThreadParticipant paramThreadParticipant)
  {
    ParticipantInfo localParticipantInfo = paramMessage.f();
    if ((!paramThreadParticipant.b()) && (paramThreadParticipant.c()) && (!localParticipantInfo.b()) && (localParticipantInfo.c()) && (Objects.equal(localParticipantInfo.e(), paramThreadParticipant.d())));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean b(Message paramMessage, ThreadParticipant paramThreadParticipant, ThreadSummary paramThreadSummary)
  {
    if ((a(paramMessage, paramThreadParticipant)) && (paramThreadSummary.g()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean c(Message paramMessage, ThreadParticipant paramThreadParticipant)
  {
    ParticipantInfo localParticipantInfo = paramMessage.f();
    if ((!paramThreadParticipant.b()) && (!StringUtil.a(paramThreadParticipant.e())) && (!localParticipantInfo.b()) && (!StringUtil.a(localParticipantInfo.a())) && (Objects.equal(localParticipantInfo.a(), paramThreadParticipant.e())));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean c(Message paramMessage, ThreadParticipant paramThreadParticipant, ThreadSummary paramThreadSummary)
  {
    if ((paramThreadParticipant.b()) && (Objects.equal(paramMessage.f().e(), paramThreadParticipant.d())) && (!paramThreadSummary.g()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean d(Message paramMessage, ThreadParticipant paramThreadParticipant)
  {
    if ((paramThreadParticipant.b()) && (Objects.equal(paramMessage.f().e(), paramThreadParticipant.d())));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean e(Message paramMessage, ThreadParticipant paramThreadParticipant)
  {
    if ((paramThreadParticipant.b()) && (paramThreadParticipant.i() >= a(paramMessage)) && (!Objects.equal(paramMessage.f().e(), paramThreadParticipant.d())) && (!paramMessage.a().startsWith("sent")));
    for (int i = 1; ; i = 0)
      return i;
  }

  public Map<String, MessageDeliveredReadInfo> a(MessagesCollection paramMessagesCollection, ThreadSummary paramThreadSummary)
  {
    HashSet localHashSet1 = Sets.a(paramThreadSummary.i());
    HashSet localHashSet2 = Sets.a(paramThreadSummary.i());
    HashSet localHashSet3 = Sets.a(paramThreadSummary.i());
    HashMap localHashMap = Maps.a();
    Iterator localIterator = paramMessagesCollection.b().iterator();
    while (localIterator.hasNext())
    {
      Message localMessage = (Message)localIterator.next();
      if (localMessage.q())
        continue;
      MessageDeliveredReadInfo localMessageDeliveredReadInfo = a(localHashSet1, localHashSet2, localHashSet3, localMessage, paramThreadSummary);
      if (localMessageDeliveredReadInfo == null)
        continue;
      localHashMap.put(localMessage.a(), localMessageDeliveredReadInfo);
    }
    return localHashMap;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.MessageDeliveredReadStateDisplayUtil
 * JD-Core Version:    0.6.0
 */