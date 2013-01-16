package com.facebook.orca.threads;

import com.facebook.orca.debug.BLog;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

public class MessagesCollectionMerger
{
  private static final Class<?> a = MessagesCollectionMerger.class;

  private MessagesCollection a(MessagesCollection paramMessagesCollection1, MessagesCollection paramMessagesCollection2, boolean paramBoolean)
  {
    Class localClass = a;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(paramMessagesCollection1.f());
    arrayOfObject1[1] = Integer.valueOf(paramMessagesCollection2.f());
    BLog.a(localClass, "MERGE: %d new, %d old", arrayOfObject1);
    if (!Objects.equal(paramMessagesCollection1.a(), paramMessagesCollection2.a()))
      throw new IllegalArgumentException("Message Collections with different thread ids");
    if ((paramMessagesCollection1.e()) && (paramMessagesCollection2.e()));
    while (true)
    {
      return paramMessagesCollection1;
      if (paramMessagesCollection1.e())
      {
        paramMessagesCollection1 = paramMessagesCollection2;
        continue;
      }
      if (paramMessagesCollection2.e())
        continue;
      if (d(paramMessagesCollection1, paramMessagesCollection2))
        break;
      paramMessagesCollection1 = paramMessagesCollection2;
    }
    int i = -1 + paramMessagesCollection1.f();
    Message localMessage1 = paramMessagesCollection1.a(i);
    MessagesCollectionMerger.MessageMap localMessageMap1 = new MessagesCollectionMerger.MessageMap(null);
    MessagesCollectionMerger.MessageMap localMessageMap2 = new MessagesCollectionMerger.MessageMap(null);
    Iterator localIterator1 = paramMessagesCollection1.b().iterator();
    while (localIterator1.hasNext())
      localMessageMap1.a((Message)localIterator1.next());
    Iterator localIterator2 = paramMessagesCollection2.b().iterator();
    Message localMessage6;
    do
    {
      if (!localIterator2.hasNext())
        break;
      localMessage6 = (Message)localIterator2.next();
      localMessageMap2.a(localMessage6);
    }
    while (!a(localMessage6, localMessage1));
    for (int j = 1; ; j = 0)
    {
      int k;
      int m;
      int n;
      int i1;
      ImmutableList.Builder localBuilder;
      MessagesCollectionMerger.MessageMap localMessageMap3;
      if (j == 0)
      {
        a("MERGE: couldn't find sync point", new Object[0]);
        if (paramBoolean)
          break;
        k = 0;
        m = 0;
        n = paramMessagesCollection1.f();
        i1 = paramMessagesCollection2.f();
        localBuilder = ImmutableList.e();
        localMessageMap3 = new MessagesCollectionMerger.MessageMap(null);
      }
      label291: Message localMessage3;
      Message localMessage4;
      while (true)
      {
        if ((k >= n) || (m >= i1))
          break label785;
        localMessage3 = paramMessagesCollection1.a(k);
        localMessage4 = paramMessagesCollection2.a(m);
        if (localMessageMap3.b(localMessage3))
        {
          k++;
          continue;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = localMessage1.a();
          a("MERGE: found sync point (%s)", arrayOfObject2);
          break;
        }
        if (!localMessageMap3.b(localMessage4))
          break label378;
        m++;
      }
      label378: if (a(localMessage3, localMessage4))
      {
        Object[] arrayOfObject11 = new Object[1];
        arrayOfObject11[0] = localMessage3.a();
        a("MERGE: inserting matching element (%s)", arrayOfObject11);
        if (b(localMessage4, localMessage3))
          localBuilder.b(localMessage4);
        while (true)
        {
          k++;
          m++;
          break;
          localBuilder.b(localMessage3);
        }
      }
      if (localMessageMap2.b(localMessage3))
      {
        Message localMessage5 = localMessageMap2.c(localMessage3);
        if ((localMessage3.c() > localMessage5.c()) || ((!localMessage3.v()) && (localMessage5.v())))
        {
          Object[] arrayOfObject6 = new Object[1];
          arrayOfObject6[0] = localMessage3.a();
          a("MERGE: Inserting new element (%s) and discarding old", arrayOfObject6);
          localBuilder.b(localMessage3);
          localMessageMap3.a(localMessage3);
          localMessageMap2.d(localMessage5);
        }
      }
      for (int i2 = k + 1; ; i2 = k)
      {
        k = i2;
        break label291;
        Object[] arrayOfObject7 = new Object[1];
        arrayOfObject7[0] = localMessage3.a();
        a("MERGE: Iterating old to find message matching (%s)", arrayOfObject7);
        if ((a(localMessage3, localMessage4)) || (m >= i1))
          continue;
        localMessage4 = paramMessagesCollection2.a(m);
        if ((localMessageMap1.b(localMessage4)) && (!b(localMessage4, localMessage3)))
        {
          localMessageMap2.d(localMessage4);
          Object[] arrayOfObject10 = new Object[1];
          arrayOfObject10[0] = localMessage4.a();
          a("MERGE: Not inserting old element (%s)", arrayOfObject10);
        }
        while (true)
        {
          m++;
          break;
          if (localMessageMap3.b(localMessage4))
          {
            localMessageMap2.d(localMessage4);
            Object[] arrayOfObject9 = new Object[1];
            arrayOfObject9[0] = localMessage4.a();
            a("MERGE: Not inserting old element (%s)", arrayOfObject9);
            continue;
          }
          Object[] arrayOfObject8 = new Object[1];
          arrayOfObject8[0] = localMessage4.a();
          a("MERGE: Inserting missing old element (%s)", arrayOfObject8);
          localBuilder.b(localMessage4);
          localMessageMap3.a(localMessage4);
        }
        Object[] arrayOfObject5 = new Object[1];
        arrayOfObject5[0] = localMessage3.a();
        a("MERGE: Inserting new element (%s)", arrayOfObject5);
        localBuilder.b(localMessage3);
        localMessageMap3.a(localMessage3);
        k++;
        break label291;
        label785: if (m < i1)
        {
          Message localMessage2 = paramMessagesCollection2.a(m);
          if (localMessageMap3.b(localMessage2))
          {
            Object[] arrayOfObject4 = new Object[1];
            arrayOfObject4[0] = localMessage2.a();
            a("MERGE: Not inserting old element (%s)", arrayOfObject4);
          }
          while (true)
          {
            m++;
            break;
            Object[] arrayOfObject3 = new Object[1];
            arrayOfObject3[0] = localMessage2.a();
            a("MERGE: inserting old element (%s)", arrayOfObject3);
            localBuilder.b(localMessage2);
            localMessageMap3.a(localMessage2);
          }
        }
        paramMessagesCollection1 = new MessagesCollection(paramMessagesCollection1.a(), localBuilder.b(), paramMessagesCollection2.d());
        break;
      }
    }
  }

  private static void a(String paramString, Object[] paramArrayOfObject)
  {
  }

  private boolean a(Message paramMessage1, Message paramMessage2)
  {
    int i = 1;
    if (Objects.equal(paramMessage1.a(), paramMessage2.a()));
    while (true)
    {
      return i;
      if ((paramMessage1.u()) && (paramMessage2.u()) && (Objects.equal(paramMessage1.t(), paramMessage2.t())))
        continue;
      i = 0;
    }
  }

  private boolean b(Message paramMessage1, Message paramMessage2)
  {
    if ((!paramMessage1.v()) && (paramMessage2.v()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean d(MessagesCollection paramMessagesCollection1, MessagesCollection paramMessagesCollection2)
  {
    UnmodifiableIterator localUnmodifiableIterator1 = paramMessagesCollection1.b().b();
    UnmodifiableIterator localUnmodifiableIterator2 = paramMessagesCollection2.b().b();
    Message localMessage1;
    Message localMessage2;
    do
    {
      if ((!localUnmodifiableIterator1.hasNext()) || (!localUnmodifiableIterator2.hasNext()))
        break;
      localMessage1 = (Message)localUnmodifiableIterator1.next();
      localMessage2 = (Message)localUnmodifiableIterator2.next();
    }
    while ((!localMessage1.v()) && (!localMessage2.v()) && (Objects.equal(localMessage1.a(), localMessage2.a())));
    for (boolean bool = true; ; bool = localUnmodifiableIterator1.hasNext())
      return bool;
  }

  public MessagesCollection a(MessagesCollection paramMessagesCollection1, MessagesCollection paramMessagesCollection2)
  {
    return a(paramMessagesCollection1, paramMessagesCollection2, false);
  }

  public MessagesCollection b(MessagesCollection paramMessagesCollection1, MessagesCollection paramMessagesCollection2)
  {
    return a(paramMessagesCollection1, paramMessagesCollection2, true);
  }

  public boolean c(MessagesCollection paramMessagesCollection1, MessagesCollection paramMessagesCollection2)
  {
    int i;
    if ((paramMessagesCollection1.e()) && (paramMessagesCollection2.e()))
      i = 1;
    while (true)
    {
      return i;
      if (paramMessagesCollection1.e())
      {
        i = 1;
        continue;
      }
      if (paramMessagesCollection2.e())
      {
        i = 1;
        continue;
      }
      Message localMessage = paramMessagesCollection1.a(-1 + paramMessagesCollection1.f());
      Iterator localIterator = paramMessagesCollection2.b().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          if (!Objects.equal(((Message)localIterator.next()).a(), localMessage.a()))
            continue;
          i = 1;
          break;
        }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.MessagesCollectionMerger
 * JD-Core Version:    0.6.0
 */