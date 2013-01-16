package com.facebook.orca.sms;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android_src.provider.Telephony.MmsSms;
import android_src.provider.Telephony.Threads;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipantBuilder;
import com.facebook.orca.threads.ThreadSnippetUtil;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadSummaryBuilder;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

public class MmsSmsContentResolverHandler
{
  private static final Class<?> a = MmsSmsContentResolverHandler.class;
  private static String[] j = { "COUNT(*) AS num_threads", "SUM(read) AS read_count", "MAX(date) AS latest_message_time" };
  private final Context b;
  private final SmsContentResolverHandler c;
  private final MmsContentResolverHandler d;
  private final CallLogContentResolverHandler e;
  private final MmsSmsUserUtils f;
  private final OrcaSharedPreferences g;
  private final ThreadSnippetUtil h;
  private final Provider<Boolean> i;

  public MmsSmsContentResolverHandler(Context paramContext, SmsContentResolverHandler paramSmsContentResolverHandler, MmsContentResolverHandler paramMmsContentResolverHandler, CallLogContentResolverHandler paramCallLogContentResolverHandler, MmsSmsUserUtils paramMmsSmsUserUtils, OrcaSharedPreferences paramOrcaSharedPreferences, ThreadSnippetUtil paramThreadSnippetUtil, Provider<Boolean> paramProvider)
  {
    this.b = paramContext;
    this.c = paramSmsContentResolverHandler;
    this.d = paramMmsContentResolverHandler;
    this.e = paramCallLogContentResolverHandler;
    this.f = paramMmsSmsUserUtils;
    this.g = paramOrcaSharedPreferences;
    this.h = paramThreadSnippetUtil;
    this.i = paramProvider;
  }

  private ImmutableList<Message> a(int paramInt, ImmutableList<Message>[] paramArrayOfImmutableList)
  {
    ImmutableList localImmutableList;
    if (paramArrayOfImmutableList.length == 0)
    {
      localImmutableList = ImmutableList.d();
      return localImmutableList;
    }
    ImmutableList.Builder localBuilder = ImmutableList.e();
    int k = 0;
    int[] arrayOfInt = new int[paramArrayOfImmutableList.length];
    int m = 0;
    label60: Object localObject1;
    int i4;
    int i1;
    while (m < paramArrayOfImmutableList.length)
    {
      k += paramArrayOfImmutableList[m].size();
      arrayOfInt[m] = 0;
      m++;
      continue;
      localBuilder.b(localObject1);
      i4 = n + 1;
      arrayOfInt[i1] = (1 + arrayOfInt[i1]);
    }
    for (int n = i4; ; n = 0)
    {
      int i2;
      label116: Message localMessage;
      label155: Object localObject2;
      int i3;
      if (((n < paramInt) || (paramInt == -1)) && (n < k))
      {
        localObject1 = null;
        i1 = -1;
        i2 = 0;
        if (i2 < paramArrayOfImmutableList.length)
        {
          if (arrayOfInt[i2] >= paramArrayOfImmutableList[i2].size())
            break label201;
          localMessage = (Message)paramArrayOfImmutableList[i2].get(arrayOfInt[i2]);
          if ((localObject1 != null) && ((localMessage == null) || (localMessage.c() <= localObject1.c())))
            break label216;
          localObject2 = localMessage;
          i3 = i2;
        }
      }
      while (true)
      {
        i2++;
        localObject1 = localObject2;
        i1 = i3;
        break label116;
        break label60;
        label201: localMessage = null;
        break label155;
        localImmutableList = localBuilder.b();
        break;
        label216: i3 = i1;
        localObject2 = localObject1;
      }
    }
  }

  private ImmutableList<FetchMmsSmsThreadSummaryResult> a(ImmutableList<FetchMmsSmsThreadSummaryResult> paramImmutableList1, ImmutableList<FetchMmsSmsThreadSummaryResult> paramImmutableList2)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    int k = 0;
    int m = 0;
    while ((m < paramImmutableList1.size()) || (k < paramImmutableList2.size()))
    {
      if (m == paramImmutableList1.size())
      {
        localBuilder.b(paramImmutableList2.get(k));
        k++;
        continue;
      }
      if (k == paramImmutableList2.size())
      {
        localBuilder.b(paramImmutableList1.get(m));
        m++;
        continue;
      }
      FetchMmsSmsThreadSummaryResult localFetchMmsSmsThreadSummaryResult = (FetchMmsSmsThreadSummaryResult)paramImmutableList1.get(m);
      int i1;
      int n;
      if (((FetchMmsSmsThreadSummaryResult)paramImmutableList2.get(k)).c() < localFetchMmsSmsThreadSummaryResult.c())
      {
        localBuilder.b(paramImmutableList1.get(m));
        i1 = m + 1;
        n = k;
      }
      while (true)
      {
        k = n;
        m = i1;
        break;
        localBuilder.b(paramImmutableList2.get(k));
        n = k + 1;
        i1 = m;
      }
    }
    return localBuilder.b();
  }

  private ImmutableList<FetchMmsSmsThreadSummaryResult> a(ImmutableList<FetchMmsSmsThreadSummaryResult> paramImmutableList1, ImmutableList<FetchMmsSmsThreadSummaryResult> paramImmutableList2, int paramInt)
  {
    PeekingIterator localPeekingIterator1 = Iterators.g(paramImmutableList1.b());
    PeekingIterator localPeekingIterator2 = Iterators.g(paramImmutableList2.b());
    int k = 0;
    int m = 0;
    while ((m + k < paramInt) && ((localPeekingIterator1.hasNext()) || (localPeekingIterator2.hasNext())))
    {
      if (!localPeekingIterator1.hasNext())
      {
        localPeekingIterator2.next();
        k++;
        continue;
      }
      if (!localPeekingIterator2.hasNext())
      {
        localPeekingIterator1.next();
        m++;
        continue;
      }
      if (((FetchMmsSmsThreadSummaryResult)localPeekingIterator2.a()).c() < ((FetchMmsSmsThreadSummaryResult)localPeekingIterator1.a()).c())
      {
        localPeekingIterator1.next();
        m++;
        continue;
      }
      localPeekingIterator2.next();
      k++;
    }
    ImmutableList localImmutableList1 = paramImmutableList1.a(0, m);
    ImmutableList localImmutableList2 = paramImmutableList2.a(0, k);
    return a(localImmutableList1, this.d.a(localImmutableList2));
  }

  private ImmutableList<ThreadSummary> a(List<FetchMmsSmsThreadSummaryResult> paramList, ImmutableMultimap<Long, User> paramImmutableMultimap)
  {
    ArrayList localArrayList1 = Lists.a();
    Iterator localIterator1 = paramList.iterator();
    long l1 = 9223372036854775807L;
    if (localIterator1.hasNext())
    {
      FetchMmsSmsThreadSummaryResult localFetchMmsSmsThreadSummaryResult2 = (FetchMmsSmsThreadSummaryResult)localIterator1.next();
      if (localFetchMmsSmsThreadSummaryResult2.c() < l1);
      for (boolean bool2 = true; ; bool2 = false)
      {
        Preconditions.checkArgument(bool2);
        l1 = localFetchMmsSmsThreadSummaryResult2.c();
        if (paramImmutableMultimap.c(Long.valueOf(localFetchMmsSmsThreadSummaryResult2.a())) == null)
          break;
        localArrayList1.add(localFetchMmsSmsThreadSummaryResult2);
        break;
      }
    }
    ParticipantInfo localParticipantInfo1 = this.f.a();
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator2 = localArrayList1.iterator();
    FetchMmsSmsThreadSummaryResult localFetchMmsSmsThreadSummaryResult1;
    long l2;
    long l3;
    ArrayList localArrayList2;
    boolean bool1;
    UserKey localUserKey1;
    if (localIterator2.hasNext())
    {
      localFetchMmsSmsThreadSummaryResult1 = (FetchMmsSmsThreadSummaryResult)localIterator2.next();
      l2 = localFetchMmsSmsThreadSummaryResult1.a();
      l3 = 1000000L * localFetchMmsSmsThreadSummaryResult1.c();
      localArrayList2 = Lists.a();
      Iterator localIterator3 = paramImmutableMultimap.c(Long.valueOf(l2)).iterator();
      while (localIterator3.hasNext())
      {
        User localUser = (User)localIterator3.next();
        localArrayList2.add(this.f.a(localUser));
      }
      if (localArrayList2.size() != 1)
        break label470;
      UserKey localUserKey2 = ((ParticipantInfo)localArrayList2.get(0)).e();
      bool1 = true;
      localUserKey1 = localUserKey2;
    }
    while (true)
    {
      localArrayList2.add(localParticipantInfo1);
      ArrayList localArrayList3 = Lists.a();
      Iterator localIterator4 = localArrayList2.iterator();
      while (localIterator4.hasNext())
      {
        ParticipantInfo localParticipantInfo2 = (ParticipantInfo)localIterator4.next();
        localArrayList3.add(new ThreadParticipantBuilder().a(MessagingIdUtil.a(l2)).a(localParticipantInfo2).f());
      }
      Object localObject = localFetchMmsSmsThreadSummaryResult1.e();
      String str = localFetchMmsSmsThreadSummaryResult1.f();
      if (!StringUtil.a((String)localObject));
      while (true)
      {
        localBuilder.b(new ThreadSummaryBuilder().a(MessagingIdUtil.a(l2)).c(l3).a(l3).b(l3).d(localFetchMmsSmsThreadSummaryResult1.c()).a(localArrayList3).a(bool1).a(localUserKey1).c((String)localObject).a(localFetchMmsSmsThreadSummaryResult1.g()).c(true).b(localFetchMmsSmsThreadSummaryResult1.d()).a(FolderName.d).d(true).y());
        break;
        localObject = str;
      }
      return localBuilder.b();
      label470: localUserKey1 = null;
      bool1 = false;
    }
  }

  private ImmutableMultimap<Long, User> a(Collection<Long> paramCollection)
  {
    ImmutableMultimap localImmutableMultimap = b(paramCollection);
    Map localMap = c(localImmutableMultimap.p());
    HashMap localHashMap = Maps.a();
    Iterator localIterator1 = localMap.keySet().iterator();
    while (localIterator1.hasNext())
    {
      long l3 = ((Long)localIterator1.next()).longValue();
      String str = (String)localMap.get(Long.valueOf(l3));
      User localUser = this.f.a(str);
      localHashMap.put(Long.valueOf(l3), localUser);
    }
    ImmutableMultimap.Builder localBuilder = ImmutableMultimap.j();
    Iterator localIterator2 = localImmutableMultimap.l().iterator();
    while (localIterator2.hasNext())
    {
      long l1 = ((Long)localIterator2.next()).longValue();
      Iterator localIterator3 = localImmutableMultimap.c(Long.valueOf(l1)).iterator();
      while (localIterator3.hasNext())
      {
        long l2 = ((Long)localIterator3.next()).longValue();
        if (!localHashMap.containsKey(Long.valueOf(l2)))
          continue;
        localBuilder.a(Long.valueOf(l1), localHashMap.get(Long.valueOf(l2)));
      }
    }
    return localBuilder.a();
  }

  private ImmutableMultimap<Long, Long> b(Collection<Long> paramCollection)
  {
    ImmutableMultimap localImmutableMultimap;
    if (paramCollection.isEmpty())
      localImmutableMultimap = ImmutableMultimap.c();
    while (true)
    {
      return localImmutableMultimap;
      ImmutableMultimap.Builder localBuilder = ImmutableMultimap.j();
      String[] arrayOfString1 = { "_id", "recipient_ids" };
      String str1 = "_id IN " + SqlUtil.a(paramCollection);
      Uri localUri = Telephony.MmsSms.b.buildUpon().appendQueryParameter("simple", "true").build();
      Cursor localCursor = this.b.getContentResolver().query(localUri, arrayOfString1, str1, null, "date DESC");
      try
      {
        int k = localCursor.getColumnIndex("_id");
        int m = localCursor.getColumnIndex("recipient_ids");
        while (localCursor.moveToNext())
        {
          long l = localCursor.getLong(k);
          for (String str2 : localCursor.getString(m).split(" "))
          {
            if (StringUtil.a(str2))
              continue;
            localBuilder.a(Long.valueOf(l), Long.valueOf(Long.parseLong(str2)));
          }
        }
        localCursor.close();
        localImmutableMultimap = localBuilder.a();
      }
      finally
      {
        localCursor.close();
      }
    }
  }

  private Map<Long, String> c(Collection<Long> paramCollection)
  {
    HashMap localHashMap1 = Maps.a();
    if (paramCollection.isEmpty());
    for (HashMap localHashMap2 = localHashMap1; ; localHashMap2 = localHashMap1)
    {
      return localHashMap2;
      String[] arrayOfString = { "_id", "address" };
      String str1 = "_id IN " + SqlUtil.a(paramCollection);
      Uri localUri = Uri.withAppendedPath(Telephony.MmsSms.a, "canonical-addresses");
      Cursor localCursor = this.b.getContentResolver().query(localUri, arrayOfString, str1, null, null);
      try
      {
        int k = localCursor.getColumnIndex("address");
        int m = localCursor.getColumnIndex("_id");
        if (localCursor.moveToNext())
        {
          long l = localCursor.getLong(m);
          String str2 = localCursor.getString(k);
          localHashMap1.put(Long.valueOf(l), str2);
        }
      }
      finally
      {
        localCursor.close();
      }
    }
  }

  private ImmutableList<User> e(long paramLong)
  {
    return ImmutableList.a(a(ImmutableList.a(Long.valueOf(paramLong))).p());
  }

  FetchMmsSmsThreadListResult a(FetchMmsSmsThreadListParams paramFetchMmsSmsThreadListParams)
  {
    ImmutableList localImmutableList1 = this.c.a(paramFetchMmsSmsThreadListParams);
    ImmutableList localImmutableList2 = this.d.a(paramFetchMmsSmsThreadListParams);
    ImmutableList localImmutableList3 = a(localImmutableList1, localImmutableList2, paramFetchMmsSmsThreadListParams.a());
    if (localImmutableList1.size() + localImmutableList2.size() <= paramFetchMmsSmsThreadListParams.a());
    ArrayList localArrayList;
    for (boolean bool = true; ; bool = false)
    {
      localArrayList = Lists.a();
      Iterator localIterator = localImmutableList3.iterator();
      while (localIterator.hasNext())
        localArrayList.add(Long.valueOf(((FetchMmsSmsThreadSummaryResult)localIterator.next()).a()));
    }
    ImmutableMultimap localImmutableMultimap = a(localArrayList);
    return new FetchMmsSmsThreadListResult(new ThreadsCollection(a(localImmutableList3, localImmutableMultimap), bool), ImmutableList.a(localImmutableMultimap.p()));
  }

  FetchMmsSmsThreadResult a(long paramLong)
  {
    ImmutableList localImmutableList = a(ImmutableList.a(Long.valueOf(paramLong)));
    if (localImmutableList.size() > 0);
    for (FetchMmsSmsThreadResult localFetchMmsSmsThreadResult = (FetchMmsSmsThreadResult)localImmutableList.get(0); ; localFetchMmsSmsThreadResult = new FetchMmsSmsThreadResult(null, ImmutableList.d()))
      return localFetchMmsSmsThreadResult;
  }

  FetchMmsSmsThreadResult a(String paramString)
  {
    return a(b(paramString));
  }

  FolderCounts a()
  {
    Uri localUri = Telephony.MmsSms.b.buildUpon().appendQueryParameter("simple", "true").build();
    Cursor localCursor = this.b.getContentResolver().query(localUri, j, null, null, null);
    while (true)
    {
      try
      {
        if (!localCursor.moveToNext())
          break label177;
        int n = localCursor.getInt(localCursor.getColumnIndex("num_threads")) - localCursor.getInt(localCursor.getColumnIndex("read_count"));
        long l4 = localCursor.getLong(localCursor.getColumnIndex("latest_message_time"));
        l1 = l4;
        k = n;
        localCursor.close();
        long l2 = this.g.a(MessagesPrefKeys.e, -1L);
        long l3 = 1000000L * l1;
        if (l2 < l1)
        {
          m = 1;
          return new FolderCounts(k, m, l2, l3);
        }
      }
      finally
      {
        localCursor.close();
      }
      int m = 0;
      continue;
      label177: long l1 = -1L;
      int k = 0;
    }
  }

  MessagesCollection a(FetchMmsSmsMessagesParams paramFetchMmsSmsMessagesParams)
  {
    String str = MessagingIdUtil.a(paramFetchMmsSmsMessagesParams.a());
    MessagesCollection localMessagesCollection;
    if (paramFetchMmsSmsMessagesParams.b() == 0)
    {
      localMessagesCollection = new MessagesCollection(str, ImmutableList.d(), false);
      return localMessagesCollection;
    }
    ImmutableList localImmutableList1 = e(paramFetchMmsSmsMessagesParams.a());
    ImmutableList localImmutableList2 = this.c.a(paramFetchMmsSmsMessagesParams);
    ImmutableList localImmutableList3 = this.d.a(paramFetchMmsSmsMessagesParams);
    ImmutableList localImmutableList4 = this.c.b(localImmutableList2);
    ImmutableList localImmutableList5 = this.d.b(localImmutableList3);
    ImmutableList localImmutableList6 = ImmutableList.d();
    ImmutableList localImmutableList7 = ImmutableList.d();
    ImmutableList localImmutableList9;
    ImmutableList localImmutableList8;
    if ((((Boolean)this.i.b()).booleanValue()) && (localImmutableList1.size() == 1))
    {
      localImmutableList9 = this.e.a(paramFetchMmsSmsMessagesParams, localImmutableList1);
      localImmutableList8 = this.e.a(localImmutableList9, str);
    }
    while (true)
    {
      ImmutableList localImmutableList10 = a(paramFetchMmsSmsMessagesParams.b(), new ImmutableList[] { localImmutableList4, localImmutableList5, localImmutableList8 });
      if (localImmutableList2.size() + localImmutableList3.size() + localImmutableList9.size() < paramFetchMmsSmsMessagesParams.b());
      for (boolean bool = true; ; bool = false)
      {
        localMessagesCollection = new MessagesCollection(str, localImmutableList10, bool);
        break;
      }
      localImmutableList8 = localImmutableList7;
      localImmutableList9 = localImmutableList6;
    }
  }

  ImmutableList<FetchMmsSmsThreadResult> a(List<Long> paramList)
  {
    ImmutableList localImmutableList1 = a(this.c.a(paramList), this.d.a(paramList), paramList.size());
    ImmutableMultimap localImmutableMultimap = a(paramList);
    ImmutableList localImmutableList2 = a(localImmutableList1, localImmutableMultimap);
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = localImmutableList2.iterator();
    while (localIterator.hasNext())
    {
      ThreadSummary localThreadSummary = (ThreadSummary)localIterator.next();
      localBuilder.b(new FetchMmsSmsThreadResult(localThreadSummary, ImmutableList.a(localImmutableMultimap.c(Long.valueOf(MessagingIdUtil.c(localThreadSummary.a()))))));
    }
    return localBuilder.b();
  }

  public long b(String paramString)
  {
    HashSet localHashSet = Sets.a(new String[] { paramString });
    return Telephony.Threads.a(this.b, localHashSet);
  }

  public Message b(long paramLong)
  {
    return a(FetchMmsSmsMessagesParams.a(paramLong, 1, -1L)).c();
  }

  public Set<Long> b()
  {
    HashSet localHashSet = Sets.a();
    Uri localUri = Telephony.MmsSms.b.buildUpon().appendQueryParameter("simple", "true").build();
    Cursor localCursor = this.b.getContentResolver().query(localUri, new String[] { "_id" }, "read=0", null, null);
    try
    {
      if (localCursor.moveToNext())
        localHashSet.add(Long.valueOf(localCursor.getLong(0)));
    }
    finally
    {
      localCursor.close();
    }
    if (localHashSet.size() != 0)
    {
      this.d.a(localHashSet);
      this.c.a(localHashSet);
    }
    return localHashSet;
  }

  void c(long paramLong)
  {
    Uri localUri = ContentUris.withAppendedId(Telephony.MmsSms.b, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("read", Integer.valueOf(1));
    this.b.getContentResolver().update(localUri, localContentValues, null, null);
  }

  void c(String paramString)
  {
    if (MessagingIdUtil.h(paramString))
      this.c.b(MessagingIdUtil.d(paramString));
    while (true)
    {
      return;
      if (!MessagingIdUtil.i(paramString))
        break;
      this.d.b(MessagingIdUtil.e(paramString));
    }
    throw new Exception("Message id is not an Mms or Sms id");
  }

  void d(long paramLong)
  {
    Uri localUri = ContentUris.withAppendedId(Telephony.MmsSms.b, paramLong);
    this.b.getContentResolver().delete(localUri, null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsContentResolverHandler
 * JD-Core Version:    0.6.0
 */