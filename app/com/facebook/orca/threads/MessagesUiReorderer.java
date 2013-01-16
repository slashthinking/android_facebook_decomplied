package com.facebook.orca.threads;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.merge.MergingUtil.MessageByDateComparator;
import com.facebook.orca.users.User;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Provider;

public class MessagesUiReorderer
{
  private static final Class<?> a = MessagesUiReorderer.class;
  private final Provider<User> b;
  private final Clock c;

  public MessagesUiReorderer(Provider<User> paramProvider, Clock paramClock)
  {
    this.b = paramProvider;
    this.c = paramClock;
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

  private void a(MessagesCollection paramMessagesCollection1, MessagesCollection paramMessagesCollection2)
  {
    if (!BLog.b(2));
    while (true)
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("  Before Messages:\n");
      a(localStringBuilder, paramMessagesCollection1, 8);
      localStringBuilder.append("  After Messages:\n");
      a(localStringBuilder, paramMessagesCollection2, 8);
      BLog.a(a, localStringBuilder.toString());
    }
  }

  private void a(StringBuilder paramStringBuilder, MessagesCollection paramMessagesCollection, int paramInt)
  {
    if ((paramMessagesCollection == null) || (paramMessagesCollection.e()))
      paramStringBuilder.append("    none\n");
    while (true)
    {
      return;
      for (int i = 0; (i < paramInt) && (i < paramMessagesCollection.f()); i++)
      {
        Message localMessage = paramMessagesCollection.a(i);
        paramStringBuilder.append("   ").append(localMessage).append("\n");
      }
    }
  }

  private boolean b(Message paramMessage)
  {
    ParticipantInfo localParticipantInfo = paramMessage.f();
    User localUser = (User)this.b.b();
    if ((localUser != null) && (localParticipantInfo.e() != null) && (Objects.equal(localUser.c(), localParticipantInfo.e())));
    for (int i = 1; ; i = 0)
      return i;
  }

  public MessagesCollection a(MessagesCollection paramMessagesCollection)
  {
    long l = this.c.a();
    ImmutableList localImmutableList = paramMessagesCollection.b();
    int i = -1;
    int j = 0;
    int k = 0;
    boolean bool;
    if (k < localImmutableList.size())
    {
      Message localMessage3 = (Message)localImmutableList.get(k);
      bool = b(localMessage3);
      if ((l - localMessage3.c() <= 1800000L) || ((i != -1) && (bool) && (j != 0)));
    }
    else
    {
      if (i != -1)
        break label114;
    }
    label114: label253: 
    while (true)
    {
      return paramMessagesCollection;
      int i1 = k + 1;
      j = bool;
      i = k;
      k = i1;
      break;
      Message localMessage1 = (Message)localImmutableList.get(0);
      int m = 1;
      Object localObject = localMessage1;
      Message localMessage2;
      if (m <= i)
      {
        localMessage2 = (Message)localImmutableList.get(m);
        if (a((Message)localObject) >= a(localMessage2));
      }
      for (int n = 1; ; n = 0)
      {
        if (n == 0)
          break label253;
        ArrayList localArrayList = Lists.a(localImmutableList);
        Collections.sort(localArrayList.subList(0, i + 1), new MergingUtil.MessageByDateComparator());
        MessagesCollection localMessagesCollection = new MessagesCollection(paramMessagesCollection.a(), ImmutableList.a(localArrayList), paramMessagesCollection.d());
        a(paramMessagesCollection, localMessagesCollection);
        paramMessagesCollection = localMessagesCollection;
        break;
        m++;
        localObject = localMessage2;
        break label132;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.MessagesUiReorderer
 * JD-Core Version:    0.6.0
 */