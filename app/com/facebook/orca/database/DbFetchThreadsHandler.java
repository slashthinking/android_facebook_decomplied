package com.facebook.orca.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.orca.common.util.SqlQueryBuilder;
import com.facebook.orca.common.util.SqlQueryBuilder.AndExpression;
import com.facebook.orca.common.util.SqlQueryBuilder.Expression;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMoreThreadsParams;
import com.facebook.orca.server.FetchMoreThreadsResult;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadListResult;
import com.facebook.orca.server.FetchThreadListResultBuilder;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadSummaryBuilder;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class DbFetchThreadsHandler
{
  private static final String[] g = { "t.thread_id", "t.action_id", "t.refetch_action_id", "t.last_visible_action_id", "t.name", "t.participants", "t.former_participants", "t.object_participants", "t.senders", "t.single_recipient_thread", "t.single_recipient_user_key", "t.snippet", "t.snippet_sender", "t.admin_snippet", "t.timestamp_ms", "t.unread", "t.pic_hash", "t.can_reply_to", "t.pic", "t.is_subscribed", "t.folder", "t.draft" };
  private static final String[] h = { "unread_count", "unseen_count", "last_seen_time", "last_action_id" };
  private final ThreadsDatabaseSupplier a;
  private final DbFetchThreadUsersHandler b;
  private final DbThreadsPropertyUtil c;
  private final DbParticipantsSerialization d;
  private final DbDraftSerialization e;
  private final DbClock f;

  DbFetchThreadsHandler(ThreadsDatabaseSupplier paramThreadsDatabaseSupplier, DbFetchThreadUsersHandler paramDbFetchThreadUsersHandler, DbThreadsPropertyUtil paramDbThreadsPropertyUtil, DbParticipantsSerialization paramDbParticipantsSerialization, DbDraftSerialization paramDbDraftSerialization, DbClock paramDbClock)
  {
    this.a = paramThreadsDatabaseSupplier;
    this.b = paramDbFetchThreadUsersHandler;
    this.c = paramDbThreadsPropertyUtil;
    this.d = paramDbParticipantsSerialization;
    this.e = paramDbDraftSerialization;
    this.f = paramDbClock;
  }

  private FolderCounts a(FolderName paramFolderName)
  {
    Tracer localTracer = Tracer.a("DbFetchThreadsHandler.getFolderCounts");
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramFolderName.b();
    String str = String.format("folder='%1$s'", arrayOfObject);
    Cursor localCursor = this.a.b().query("folder_counts", h, str, null, null, null, null);
    try
    {
      if (localCursor.moveToNext())
      {
        localFolderCounts = new FolderCounts(localCursor.getInt(0), localCursor.getInt(1), localCursor.getLong(2), localCursor.getLong(3));
        return localFolderCounts;
      }
      localCursor.close();
      localTracer.a();
      FolderCounts localFolderCounts = null;
    }
    finally
    {
      localCursor.close();
      localTracer.a();
    }
  }

  private ImmutableList<ThreadSummary> a(Collection<ThreadSummary> paramCollection, int paramInt)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramCollection.iterator();
    for (int i = 0; (localIterator.hasNext()) && (i < paramInt); i++)
      localBuilder.b(localIterator.next());
    return localBuilder.b();
  }

  private LinkedHashMap<String, ThreadSummary> a(FolderName paramFolderName, long paramLong, int paramInt)
  {
    Tracer localTracer = Tracer.a("DbFetchThreadsHandler.doThreadListQuery");
    LinkedHashMap localLinkedHashMap1 = b(paramFolderName, paramLong, paramInt);
    b(localLinkedHashMap1);
    c(localLinkedHashMap1);
    LinkedHashMap localLinkedHashMap2 = Maps.b();
    Iterator localIterator = localLinkedHashMap1.values().iterator();
    while (localIterator.hasNext())
    {
      ThreadSummaryBuilder localThreadSummaryBuilder = (ThreadSummaryBuilder)localIterator.next();
      localLinkedHashMap2.put(localThreadSummaryBuilder.a(), localThreadSummaryBuilder.y());
    }
    localTracer.a();
    return localLinkedHashMap2;
  }

  private Set<String> a()
  {
    HashSet localHashSet = Sets.a();
    Cursor localCursor = this.a.b().query(true, "archived_sms_mms_threads", new String[] { "thread_id" }, null, null, null, null, null, null);
    try
    {
      if (localCursor.moveToNext())
        localHashSet.add(localCursor.getString(0));
    }
    finally
    {
      localCursor.close();
    }
    return localHashSet;
  }

  private Set<UserKey> a(LinkedHashMap<String, ThreadSummary> paramLinkedHashMap)
  {
    HashSet localHashSet = Sets.a();
    Iterator localIterator1 = paramLinkedHashMap.values().iterator();
    while (localIterator1.hasNext())
    {
      ThreadSummary localThreadSummary = (ThreadSummary)localIterator1.next();
      Iterator localIterator2 = localThreadSummary.i().iterator();
      while (localIterator2.hasNext())
      {
        ThreadParticipant localThreadParticipant2 = (ThreadParticipant)localIterator2.next();
        if (localThreadParticipant2.d() == null)
          continue;
        localHashSet.add(localThreadParticipant2.d());
      }
      Iterator localIterator3 = localThreadSummary.A().iterator();
      while (localIterator3.hasNext())
      {
        ThreadParticipant localThreadParticipant1 = (ThreadParticipant)localIterator3.next();
        if (localThreadParticipant1.d() == null)
          continue;
        localHashSet.add(localThreadParticipant1.d());
      }
    }
    return localHashSet;
  }

  private LinkedHashMap<String, ThreadSummaryBuilder> b(FolderName paramFolderName, long paramLong, int paramInt)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("folders AS f INNER JOIN threads AS t ON f.thread_id = t.thread_id");
    SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a();
    localAndExpression.a(SqlQueryBuilder.a("f.folder", paramFolderName.b()));
    if (paramLong > 0L)
      localAndExpression.a(SqlQueryBuilder.c("f.timestamp_ms", Long.toString(paramLong)));
    if (paramFolderName.equals(FolderName.d))
      localAndExpression.a(SqlQueryBuilder.a("t.thread_id NOT IN " + SqlUtil.b(a())));
    SQLiteDatabase localSQLiteDatabase = this.a.b();
    LinkedHashMap localLinkedHashMap = Maps.b();
    Cursor localCursor = localSQLiteQueryBuilder.query(localSQLiteDatabase, g, localAndExpression.a(), localAndExpression.b(), null, null, "f.timestamp_ms DESC", Integer.toString(paramInt));
    while (true)
    {
      boolean bool1;
      try
      {
        int i = localCursor.getColumnIndexOrThrow("thread_id");
        int j = localCursor.getColumnIndexOrThrow("action_id");
        int k = localCursor.getColumnIndexOrThrow("refetch_action_id");
        int m = localCursor.getColumnIndexOrThrow("last_visible_action_id");
        int n = localCursor.getColumnIndexOrThrow("name");
        int i1 = localCursor.getColumnIndexOrThrow("participants");
        int i2 = localCursor.getColumnIndexOrThrow("former_participants");
        int i3 = localCursor.getColumnIndexOrThrow("object_participants");
        int i4 = localCursor.getColumnIndexOrThrow("senders");
        int i5 = localCursor.getColumnIndexOrThrow("single_recipient_thread");
        int i6 = localCursor.getColumnIndexOrThrow("snippet");
        int i7 = localCursor.getColumnIndexOrThrow("snippet_sender");
        int i8 = localCursor.getColumnIndexOrThrow("admin_snippet");
        int i9 = localCursor.getColumnIndexOrThrow("timestamp_ms");
        int i10 = localCursor.getColumnIndexOrThrow("unread");
        int i11 = localCursor.getColumnIndexOrThrow("pic_hash");
        int i12 = localCursor.getColumnIndexOrThrow("can_reply_to");
        int i13 = localCursor.getColumnIndexOrThrow("pic");
        int i14 = localCursor.getColumnIndexOrThrow("single_recipient_user_key");
        int i15 = localCursor.getColumnIndexOrThrow("is_subscribed");
        int i16 = localCursor.getColumnIndexOrThrow("folder");
        int i17 = localCursor.getColumnIndexOrThrow("draft");
        if (!localCursor.moveToNext())
          break;
        ThreadSummaryBuilder localThreadSummaryBuilder = new ThreadSummaryBuilder();
        String str = localCursor.getString(i);
        localThreadSummaryBuilder.a(str);
        localThreadSummaryBuilder.c(localCursor.getLong(j));
        localThreadSummaryBuilder.a(localCursor.getLong(k));
        localThreadSummaryBuilder.b(localCursor.getLong(m));
        if (localCursor.isNull(n))
          continue;
        localThreadSummaryBuilder.b(localCursor.getString(n));
        localThreadSummaryBuilder.a(this.d.c(localCursor.getString(i1)));
        localThreadSummaryBuilder.b(this.d.c(localCursor.getString(i2)));
        localThreadSummaryBuilder.c(this.d.b(localCursor.getString(i3)));
        localThreadSummaryBuilder.d(this.d.b(localCursor.getString(i4)));
        localThreadSummaryBuilder.a(this.d.a(localCursor.getString(i7)));
        if (localCursor.getInt(i5) == 0)
          continue;
        bool1 = true;
        localThreadSummaryBuilder.a(bool1);
        localThreadSummaryBuilder.c(localCursor.getString(i6));
        localThreadSummaryBuilder.d(localCursor.getString(i8));
        localThreadSummaryBuilder.d(localCursor.getLong(i9));
        if (localCursor.getInt(i10) == 0)
          break label905;
        bool2 = true;
        localThreadSummaryBuilder.b(bool2);
        localThreadSummaryBuilder.e(StringUtil.c(localCursor.getString(i11)));
        if (localCursor.getInt(i12) == 0)
          break label911;
        bool3 = true;
        localThreadSummaryBuilder.c(bool3);
        if (localCursor.isNull(i13))
          continue;
        localThreadSummaryBuilder.a(Uri.parse(localCursor.getString(i13)));
        localThreadSummaryBuilder.a(UserKey.a(localCursor.getString(i14)));
        if (localCursor.getInt(i15) == 0)
          break label917;
        bool4 = true;
        localThreadSummaryBuilder.d(bool4);
        localThreadSummaryBuilder.a(FolderName.a(localCursor.getString(i16)));
        localThreadSummaryBuilder.a(this.e.a(localCursor.getString(i17)));
        localLinkedHashMap.put(str, localThreadSummaryBuilder);
      }
      finally
      {
        localCursor.close();
      }
      continue;
      label905: boolean bool2 = false;
      continue;
      label911: boolean bool3 = false;
      continue;
      label917: boolean bool4 = false;
    }
    localCursor.close();
    return localLinkedHashMap;
  }

  private void b(LinkedHashMap<String, ThreadSummaryBuilder> paramLinkedHashMap)
  {
    long l = System.currentTimeMillis();
    SqlQueryBuilder.Expression[] arrayOfExpression = new SqlQueryBuilder.Expression[3];
    arrayOfExpression[0] = SqlQueryBuilder.a("thread_id IN " + SqlUtil.b(paramLinkedHashMap.keySet()));
    arrayOfExpression[1] = SqlQueryBuilder.a("msg_type", Integer.toString(901));
    arrayOfExpression[2] = SqlQueryBuilder.d("timestamp_ms", Long.toString(l - 86400000L));
    SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a(arrayOfExpression);
    Cursor localCursor = this.a.b().query(true, "messages", new String[] { "thread_id" }, localAndExpression.a(), localAndExpression.b(), "thread_id", null, null, null);
    try
    {
      if (localCursor.moveToNext())
        ((ThreadSummaryBuilder)paramLinkedHashMap.get(localCursor.getString(0))).e(true);
    }
    finally
    {
      localCursor.close();
    }
  }

  private void c(LinkedHashMap<String, ThreadSummaryBuilder> paramLinkedHashMap)
  {
    SqlQueryBuilder.Expression[] arrayOfExpression = new SqlQueryBuilder.Expression[1];
    arrayOfExpression[0] = SqlQueryBuilder.a("thread_id IN " + SqlUtil.b(paramLinkedHashMap.keySet()));
    SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a(arrayOfExpression);
    Cursor localCursor = this.a.b().query(true, "unread_mms_sms_threads", new String[] { "thread_id" }, localAndExpression.a(), localAndExpression.b(), "thread_id", null, null, null);
    try
    {
      if (localCursor.moveToNext())
        ((ThreadSummaryBuilder)paramLinkedHashMap.get(localCursor.getString(0))).b(true);
    }
    finally
    {
      localCursor.close();
    }
  }

  FetchMoreThreadsResult a(FetchMoreThreadsParams paramFetchMoreThreadsParams)
  {
    FolderName localFolderName = paramFetchMoreThreadsParams.a();
    long l = this.c.a(DbProperties.a(localFolderName), -1L);
    LinkedHashMap localLinkedHashMap = a(localFolderName, paramFetchMoreThreadsParams.b(), paramFetchMoreThreadsParams.c());
    String str = DbFolders.a(localFolderName);
    boolean bool1 = localLinkedHashMap.containsKey(str);
    boolean bool2 = false;
    if (bool1)
    {
      bool2 = true;
      localLinkedHashMap.remove(str);
    }
    ThreadsCollection localThreadsCollection = new ThreadsCollection(a(localLinkedHashMap.values(), paramFetchMoreThreadsParams.c()), bool2);
    Set localSet = a(localLinkedHashMap);
    ImmutableList localImmutableList = this.b.a(localSet);
    return new FetchMoreThreadsResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, localFolderName, localThreadsCollection, localImmutableList, l);
  }

  FetchThreadListResult a(FetchThreadListParams paramFetchThreadListParams)
  {
    boolean bool1 = true;
    Tracer localTracer = Tracer.a("DbFetchThreadsHandler.fetchThreadListFromDb");
    while (true)
    {
      try
      {
        FolderName localFolderName = paramFetchThreadListParams.b();
        long l1 = this.c.a(DbProperties.a(localFolderName), -1L);
        boolean bool2 = this.c.a(DbProperties.c(localFolderName), true);
        long l2 = this.c.a(DbProperties.b(localFolderName), -1L);
        if (l1 != -1L)
          continue;
        FetchThreadListResult localFetchThreadListResult2 = FetchThreadListResult.a(localFolderName);
        Object localObject2 = localFetchThreadListResult2;
        return localObject2;
        if (!bool2)
          continue;
        DataFreshnessResult localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_STALE;
        LinkedHashMap localLinkedHashMap = a(paramFetchThreadListParams.b(), -1L, 1 + paramFetchThreadListParams.d());
        Set localSet = a(localLinkedHashMap);
        ImmutableList localImmutableList1 = this.b.a(localSet);
        String str = DbFolders.a(localFolderName);
        if (localLinkedHashMap.containsKey(str))
        {
          localLinkedHashMap.remove(str);
          ImmutableList localImmutableList2 = a(localLinkedHashMap.values(), paramFetchThreadListParams.d());
          ThreadsCollection localThreadsCollection = new ThreadsCollection(localImmutableList2, bool1);
          FolderCounts localFolderCounts = a(paramFetchThreadListParams.b());
          if (localImmutableList2.isEmpty())
            continue;
          this.f.a(((ThreadSummary)localImmutableList2.get(0)).k());
          FetchThreadListResult localFetchThreadListResult1 = FetchThreadListResult.newBuilder().a(localDataFreshnessResult).a(localFolderName).a(localThreadsCollection).a(localImmutableList1).a(localFolderCounts).a(l1).b(l2).o();
          localObject2 = localFetchThreadListResult1;
          localTracer.a();
          continue;
          localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
          continue;
        }
      }
      finally
      {
        localTracer.a();
      }
      bool1 = false;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbFetchThreadsHandler
 * JD-Core Version:    0.6.0
 */