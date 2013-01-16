package com.facebook.orca.sms;

import android_src.mms.MmsException;
import com.facebook.orca.cache.ReadThreadManager;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.media.MediaResource.Type;
import com.facebook.orca.protocol.methods.PickedUserUtils;
import com.facebook.orca.server.CreateThreadParams;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.NewMessageResult;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.facebook.orca.users.UserPhoneNumber;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MmsSmsSendMessageHandler
{
  private static final Class<?> a = MmsSmsSendMessageHandler.class;
  private final PickedUserUtils b;
  private final ThreadParticipantUtils c;
  private final MmsSmsContentResolverHandler d;
  private final MmsSendMessageHandler e;
  private final SmsSendMessageHandler f;
  private final MmsSmsUserUtils g;
  private final MmsSmsLogger h;
  private final ReadThreadManager i;

  public MmsSmsSendMessageHandler(PickedUserUtils paramPickedUserUtils, ThreadParticipantUtils paramThreadParticipantUtils, MmsSmsContentResolverHandler paramMmsSmsContentResolverHandler, MmsSendMessageHandler paramMmsSendMessageHandler, SmsSendMessageHandler paramSmsSendMessageHandler, MmsSmsUserUtils paramMmsSmsUserUtils, MmsSmsLogger paramMmsSmsLogger, ReadThreadManager paramReadThreadManager)
  {
    this.b = paramPickedUserUtils;
    this.c = paramThreadParticipantUtils;
    this.d = paramMmsSmsContentResolverHandler;
    this.e = paramMmsSendMessageHandler;
    this.f = paramSmsSendMessageHandler;
    this.g = paramMmsSmsUserUtils;
    this.h = paramMmsSmsLogger;
    this.i = paramReadThreadManager;
  }

  private Message a(Message paramMessage, Set<String> paramSet)
  {
    int j = 1;
    Object localObject2;
    if ((!paramMessage.z()) && (paramSet.size() <= j))
    {
      if (paramSet.size() == j)
      {
        String str8 = (String)paramSet.iterator().next();
        localObject2 = this.f.a(paramMessage, str8);
        return localObject2;
      }
    }
    else
    {
      List localList1;
      try
      {
        Iterator localIterator = this.d.b().iterator();
        while (localIterator.hasNext())
        {
          String str7 = MessagingIdUtil.a(((Long)localIterator.next()).longValue());
          this.i.a(str7, -1L);
        }
      }
      finally
      {
        localList1 = paramMessage.y();
        if (localList1.size() <= 0)
          break label358;
      }
      MmsSmsLogger localMmsSmsLogger2 = this.h;
      String str2 = paramMessage.b();
      int m = paramSet.size();
      int n = localList1.size();
      String str3 = ((MediaResource)localList1.get(0)).b().name();
      if (0 != 0);
      boolean bool;
      while (true)
      {
        localMmsSmsLogger2.a(str2, m, n, str3, j);
        throw localObject1;
        Message localMessage = this.e.a(paramMessage, paramSet);
        List localList2 = paramMessage.y();
        if (localList2.size() > 0)
        {
          MmsSmsLogger localMmsSmsLogger4 = this.h;
          String str5 = paramMessage.b();
          int i2 = paramSet.size();
          int i3 = localList2.size();
          String str6 = ((MediaResource)localList2.get(0)).b().name();
          if (localMessage != null);
          while (true)
          {
            localMmsSmsLogger4.a(str5, i2, i3, str6, j);
            localObject2 = localMessage;
            break;
            bool = false;
          }
        }
        MmsSmsLogger localMmsSmsLogger3 = this.h;
        String str4 = paramMessage.b();
        int i1 = paramSet.size();
        if (localMessage != null);
        while (true)
        {
          localMmsSmsLogger3.a(str4, i1, bool);
          break;
          bool = false;
        }
        bool = false;
      }
      label358: MmsSmsLogger localMmsSmsLogger1 = this.h;
      String str1 = paramMessage.b();
      int k = paramSet.size();
      if (0 != 0);
      while (true)
      {
        localMmsSmsLogger1.a(str1, k, bool);
        break;
        bool = false;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Trying to send an Sms or Mms to an invalid set of participants: <");
    localStringBuilder.append(Joiner.on(" ").join(paramSet));
    localStringBuilder.append(">");
    throw new MmsException(localStringBuilder.toString());
  }

  public FetchThreadResult a(CreateThreadParams paramCreateThreadParams)
  {
    Message localMessage = paramCreateThreadParams.a();
    ImmutableList localImmutableList = paramCreateThreadParams.d();
    HashSet localHashSet = Sets.a();
    Iterator localIterator = localImmutableList.iterator();
    while (localIterator.hasNext())
    {
      UserWithIdentifier localUserWithIdentifier = (UserWithIdentifier)localIterator.next();
      localHashSet.add(this.b.a(localUserWithIdentifier).b());
    }
    long l = MessagingIdUtil.c(a(localMessage, localHashSet).b());
    FetchMmsSmsThreadResult localFetchMmsSmsThreadResult = this.d.a(l);
    FetchMmsSmsMessagesParams localFetchMmsSmsMessagesParams = FetchMmsSmsMessagesParams.a(l, 3, -1L);
    MessagesCollection localMessagesCollection = this.d.a(localFetchMmsSmsMessagesParams);
    int j = localHashSet.size();
    User localUser = null;
    if (j == 1)
      localUser = this.g.a((String)localHashSet.iterator().next());
    return new FetchThreadResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, localFetchMmsSmsThreadResult.a(), localMessagesCollection, localFetchMmsSmsThreadResult.b(), localUser, System.currentTimeMillis());
  }

  public NewMessageResult a(Message paramMessage)
  {
    long l = MessagingIdUtil.c(paramMessage.b());
    FetchMmsSmsThreadResult localFetchMmsSmsThreadResult = this.d.a(l);
    List localList = this.c.c(localFetchMmsSmsThreadResult.a());
    HashSet localHashSet = Sets.a();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localHashSet.add(((ThreadParticipant)localIterator.next()).d().b());
    Message localMessage = a(paramMessage, localHashSet);
    return new NewMessageResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, localMessage.b(), localMessage, null, System.currentTimeMillis());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsSendMessageHandler
 * JD-Core Version:    0.6.0
 */