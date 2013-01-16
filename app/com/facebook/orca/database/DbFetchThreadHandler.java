package com.facebook.orca.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.facebook.orca.common.util.SqlQueryBuilder;
import com.facebook.orca.common.util.SqlQueryBuilder.AndExpression;
import com.facebook.orca.common.util.SqlQueryBuilder.Expression;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMoreMessagesResult;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessageBuilder;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadSummaryBuilder;
import com.facebook.orca.users.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class DbFetchThreadHandler
{
  private static final String[] l = { "thread_id", "action_id", "refetch_action_id", "last_visible_action_id", "name", "participants", "former_participants", "object_participants", "senders", "single_recipient_thread", "single_recipient_user_key", "snippet", "snippet_sender", "admin_snippet", "timestamp_ms", "unread", "pic_hash", "can_reply_to", "pic", "is_subscribed", "last_fetch_time_ms", "folder", "draft" };
  private static final String[] m = { "msg_id" };
  private static final String[] n = { "thread_id", "msg_id", "action_id", "subject", "text", "sender", "timestamp_ms", "timestamp_sent_ms", "msg_type", "affected_users", "local_attachments", "attachments", "shares", "coordinates", "offline_threading_id", "source", "is_non_authoritative", "pending_send_media_attachment", "handled_internally_time" };
  private final ThreadsDatabaseSupplier a;
  private final DbThreadsPropertyUtil b;
  private final DbFetchThreadUsersHandler c;
  private final DbParticipantsSerialization d;
  private final DbAttachmentSerialization e;
  private final DbSharesSerialization f;
  private final DbCoordinatesSerialization g;
  private final DbMediaResourceSerialization h;
  private final DbDraftSerialization i;
  private final DbMessageCache j;
  private final DbClock k;

  DbFetchThreadHandler(ThreadsDatabaseSupplier paramThreadsDatabaseSupplier, DbThreadsPropertyUtil paramDbThreadsPropertyUtil, DbFetchThreadUsersHandler paramDbFetchThreadUsersHandler, DbParticipantsSerialization paramDbParticipantsSerialization, DbAttachmentSerialization paramDbAttachmentSerialization, DbSharesSerialization paramDbSharesSerialization, DbCoordinatesSerialization paramDbCoordinatesSerialization, DbMediaResourceSerialization paramDbMediaResourceSerialization, DbDraftSerialization paramDbDraftSerialization, DbMessageCache paramDbMessageCache, DbClock paramDbClock)
  {
    this.a = paramThreadsDatabaseSupplier;
    this.b = paramDbThreadsPropertyUtil;
    this.c = paramDbFetchThreadUsersHandler;
    this.d = paramDbParticipantsSerialization;
    this.e = paramDbAttachmentSerialization;
    this.f = paramDbSharesSerialization;
    this.g = paramDbCoordinatesSerialization;
    this.h = paramDbMediaResourceSerialization;
    this.i = paramDbDraftSerialization;
    this.j = paramDbMessageCache;
    this.k = paramDbClock;
  }

  private String a(UserKey paramUserKey)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.b();
    String[] arrayOfString1 = { "thread_id" };
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramUserKey.c();
    Cursor localCursor = localSQLiteDatabase.query("threads", arrayOfString1, "single_recipient_user_key=?", arrayOfString2, null, null, null);
    try
    {
      boolean bool = localCursor.moveToNext();
      Object localObject2 = null;
      if (bool)
      {
        String str = localCursor.getString(0);
        localObject2 = str;
      }
      return localObject2;
    }
    finally
    {
      localCursor.close();
    }
    throw localObject1;
  }

  private LinkedHashMap<String, Message> a(SqlQueryBuilder.Expression paramExpression, String paramString, int paramInt)
  {
    Tracer localTracer = Tracer.a("DbFetchThreadHandler.doMessagesQuery");
    SQLiteDatabase localSQLiteDatabase = this.a.b();
    localSQLiteDatabase.beginTransaction();
    LinkedHashMap localLinkedHashMap;
    HashSet localHashSet;
    Cursor localCursor1;
    try
    {
      localLinkedHashMap = Maps.b();
      localHashSet = Sets.a();
      String str1 = paramExpression.a();
      String[] arrayOfString = paramExpression.b();
      localCursor1 = localSQLiteDatabase.query("messages", m, str1, arrayOfString, null, null, paramString, Integer.toString(paramInt));
    }
    finally
    {
      try
      {
        String str4;
        Message localMessage2;
        do
        {
          if (!localCursor1.moveToNext())
            break;
          str4 = localCursor1.getString(0);
          localMessage2 = this.j.a(str4);
          localLinkedHashMap.put(str4, localMessage2);
        }
        while (localMessage2 != null);
        localHashSet.add(str4);
      }
      finally
      {
        localCursor1.close();
      }
      localSQLiteDatabase.endTransaction();
      localTracer.a();
    }
    localCursor1.close();
    String str2 = "msg_id IN " + SqlUtil.b(localHashSet);
    Cursor localCursor2 = localSQLiteDatabase.query("messages", n, str2, null, null, null, null);
    while (true)
    {
      try
      {
        int i1 = localCursor2.getColumnIndex("thread_id");
        int i2 = localCursor2.getColumnIndex("msg_id");
        int i3 = localCursor2.getColumnIndex("action_id");
        int i4 = localCursor2.getColumnIndex("subject");
        int i5 = localCursor2.getColumnIndex("text");
        int i6 = localCursor2.getColumnIndex("sender");
        int i7 = localCursor2.getColumnIndex("timestamp_ms");
        int i8 = localCursor2.getColumnIndex("timestamp_sent_ms");
        int i9 = localCursor2.getColumnIndex("msg_type");
        int i10 = localCursor2.getColumnIndex("affected_users");
        int i11 = localCursor2.getColumnIndex("local_attachments");
        int i12 = localCursor2.getColumnIndex("attachments");
        int i13 = localCursor2.getColumnIndex("shares");
        int i14 = localCursor2.getColumnIndex("coordinates");
        int i15 = localCursor2.getColumnIndex("offline_threading_id");
        int i16 = localCursor2.getColumnIndex("source");
        int i17 = localCursor2.getColumnIndex("is_non_authoritative");
        int i18 = localCursor2.getColumnIndex("pending_send_media_attachment");
        int i19 = localCursor2.getColumnIndex("handled_internally_time");
        if (!localCursor2.moveToNext())
          continue;
        String str3 = localCursor2.getString(i2);
        if ((localCursor2.isNull(i17)) || (localCursor2.getInt(i17) == 0))
          break label802;
        bool = true;
        long l1 = localCursor2.getLong(i19);
        Message localMessage1 = new MessageBuilder().a(str3).b(localCursor2.getString(i1)).c(localCursor2.getLong(i3)).c(localCursor2.getString(i4)).d(localCursor2.getString(i5)).a(this.d.a(localCursor2.getString(i6))).a(localCursor2.getLong(i7)).b(localCursor2.getLong(i8)).a(localCursor2.getInt(i9)).d(this.d.b(localCursor2.getString(i10))).a(this.h.a(localCursor2.getString(i11))).b(this.e.a(localCursor2.getString(i12))).c(this.f.a(localCursor2.getString(i13))).a(this.g.a(localCursor2.getString(i14))).e(localCursor2.getString(i15)).f(localCursor2.getString(i16)).a(bool).e(this.h.a(localCursor2.getString(i18))).d(l1).v();
        localLinkedHashMap.put(localMessage1.a(), localMessage1);
        this.j.a(localMessage1);
      }
      finally
      {
        localCursor2.close();
      }
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      localTracer.a();
      return localLinkedHashMap;
      label802: boolean bool = false;
    }
  }

  private LinkedHashMap<String, Message> b(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a();
    localAndExpression.a(SqlQueryBuilder.a("thread_id", paramString));
    if (paramLong1 != -1L)
      localAndExpression.a(SqlQueryBuilder.e("timestamp_ms", Long.toString(paramLong1)));
    if (paramLong2 != -1L)
      localAndExpression.a(SqlQueryBuilder.c("timestamp_ms", Long.toString(paramLong2)));
    return a(localAndExpression, "timestamp_ms DESC", paramInt);
  }

  private DbFetchThreadHandler.ThreadSummaryResult d(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.b();
    Cursor localCursor1 = localSQLiteDatabase.query("threads", l, "thread_id=?", new String[] { paramString }, null, null, null);
    while (true)
    {
      long l2;
      DbFetchThreadHandler.ThreadSummaryResult localThreadSummaryResult;
      long l3;
      try
      {
        int i1 = localCursor1.getColumnIndexOrThrow("thread_id");
        int i2 = localCursor1.getColumnIndexOrThrow("action_id");
        int i3 = localCursor1.getColumnIndexOrThrow("refetch_action_id");
        int i4 = localCursor1.getColumnIndexOrThrow("last_visible_action_id");
        int i5 = localCursor1.getColumnIndexOrThrow("name");
        int i6 = localCursor1.getColumnIndexOrThrow("participants");
        int i7 = localCursor1.getColumnIndexOrThrow("former_participants");
        int i8 = localCursor1.getColumnIndexOrThrow("object_participants");
        int i9 = localCursor1.getColumnIndexOrThrow("senders");
        int i10 = localCursor1.getColumnIndexOrThrow("single_recipient_thread");
        int i11 = localCursor1.getColumnIndexOrThrow("snippet");
        int i12 = localCursor1.getColumnIndexOrThrow("snippet_sender");
        int i13 = localCursor1.getColumnIndexOrThrow("admin_snippet");
        int i14 = localCursor1.getColumnIndexOrThrow("timestamp_ms");
        int i15 = localCursor1.getColumnIndexOrThrow("unread");
        int i16 = localCursor1.getColumnIndexOrThrow("pic_hash");
        int i17 = localCursor1.getColumnIndexOrThrow("can_reply_to");
        int i18 = localCursor1.getColumnIndexOrThrow("pic");
        int i19 = localCursor1.getColumnIndexOrThrow("single_recipient_user_key");
        int i20 = localCursor1.getColumnIndexOrThrow("last_fetch_time_ms");
        int i21 = localCursor1.getColumnIndexOrThrow("is_subscribed");
        int i22 = localCursor1.getColumnIndexOrThrow("folder");
        int i23 = localCursor1.getColumnIndexOrThrow("draft");
        if (!localCursor1.moveToNext())
          break label915;
        ThreadSummaryBuilder localThreadSummaryBuilder1 = new ThreadSummaryBuilder();
        localThreadSummaryBuilder1.a(localCursor1.getString(i1));
        localThreadSummaryBuilder1.c(localCursor1.getLong(i2));
        localThreadSummaryBuilder1.a(localCursor1.getLong(i3));
        localThreadSummaryBuilder1.b(localCursor1.getLong(i4));
        if (localCursor1.isNull(i5))
          continue;
        localThreadSummaryBuilder1.b(localCursor1.getString(i5));
        localThreadSummaryBuilder1.a(this.d.c(localCursor1.getString(i6)));
        localThreadSummaryBuilder1.b(this.d.c(localCursor1.getString(i7)));
        localThreadSummaryBuilder1.c(this.d.b(localCursor1.getString(i8)));
        localThreadSummaryBuilder1.d(this.d.b(localCursor1.getString(i9)));
        localThreadSummaryBuilder1.a(this.d.a(localCursor1.getString(i12)));
        if (localCursor1.getInt(i10) == 0)
          continue;
        boolean bool1 = true;
        localThreadSummaryBuilder1.a(bool1);
        localThreadSummaryBuilder1.c(localCursor1.getString(i11));
        localThreadSummaryBuilder1.d(localCursor1.getString(i13));
        localThreadSummaryBuilder1.d(localCursor1.getLong(i14));
        if (localCursor1.getInt(i15) == 0)
          continue;
        boolean bool2 = true;
        localThreadSummaryBuilder1.b(bool2);
        localThreadSummaryBuilder1.e(StringUtil.c(localCursor1.getString(i16)));
        if (localCursor1.getInt(i17) == 0)
          continue;
        boolean bool3 = true;
        localThreadSummaryBuilder1.c(bool3);
        if (localCursor1.isNull(i18))
          continue;
        localThreadSummaryBuilder1.a(Uri.parse(localCursor1.getString(i18)));
        localThreadSummaryBuilder1.a(UserKey.a(localCursor1.getString(i19)));
        if (localCursor1.getInt(i21) == 0)
          continue;
        boolean bool4 = true;
        localThreadSummaryBuilder1.d(bool4);
        localThreadSummaryBuilder1.a(FolderName.a(localCursor1.getString(i22)));
        localThreadSummaryBuilder1.a(this.i.a(localCursor1.getString(i23)));
        long l1 = localCursor1.getLong(i20);
        l2 = l1;
        localThreadSummaryBuilder2 = localThreadSummaryBuilder1;
        localCursor1.close();
        if (localThreadSummaryBuilder2 == null)
        {
          return localThreadSummaryResult;
          bool1 = false;
          continue;
          bool2 = false;
          continue;
          bool3 = false;
          continue;
          bool4 = false;
        }
      }
      finally
      {
        localCursor1.close();
      }
      SqlQueryBuilder.Expression[] arrayOfExpression = new SqlQueryBuilder.Expression[3];
      arrayOfExpression[0] = SqlQueryBuilder.a("thread_id", paramString);
      arrayOfExpression[1] = SqlQueryBuilder.a("msg_type", Integer.toString(901));
      arrayOfExpression[2] = SqlQueryBuilder.d("timestamp_ms", Long.toString(l3 - 86400000L));
      SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a(arrayOfExpression);
      Cursor localCursor2 = localSQLiteDatabase.query(true, "messages", new String[] { "thread_id" }, localAndExpression.a(), localAndExpression.b(), "thread_id", null, null, null);
      label915: 
      try
      {
        if (localCursor2.moveToNext())
          localThreadSummaryBuilder2.e(true);
        localCursor2.close();
        localThreadSummaryResult = new DbFetchThreadHandler.ThreadSummaryResult(localThreadSummaryBuilder2.y(), l2);
      }
      finally
      {
        localCursor2.close();
      }
      ThreadSummaryBuilder localThreadSummaryBuilder2 = null;
    }
  }

  FetchMoreMessagesResult a(UserKey paramUserKey, long paramLong1, long paramLong2, int paramInt)
  {
    String str = a(paramUserKey);
    if (str != null);
    for (FetchMoreMessagesResult localFetchMoreMessagesResult = a(str, paramLong1, paramLong2, paramInt); ; localFetchMoreMessagesResult = FetchMoreMessagesResult.a)
      return localFetchMoreMessagesResult;
  }

  FetchMoreMessagesResult a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    LinkedHashMap localLinkedHashMap = b(paramString, paramLong1, paramLong2, paramInt);
    boolean bool1 = localLinkedHashMap.containsKey(paramString);
    boolean bool2 = false;
    if (bool1)
    {
      bool2 = true;
      localLinkedHashMap.remove(paramString);
    }
    MessagesCollection localMessagesCollection = new MessagesCollection(paramString, ImmutableList.a(localLinkedHashMap.values()), bool2);
    return new FetchMoreMessagesResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, localMessagesCollection, -1L);
  }

  FetchThreadResult a(UserKey paramUserKey, int paramInt)
  {
    String str = a(paramUserKey);
    if (str != null);
    for (FetchThreadResult localFetchThreadResult = a(str, paramInt); ; localFetchThreadResult = FetchThreadResult.a)
      return localFetchThreadResult;
  }

  FetchThreadResult a(String paramString, int paramInt)
  {
    long l1 = -1L;
    DbFetchThreadHandler.ThreadSummaryResult localThreadSummaryResult = d(paramString);
    if (localThreadSummaryResult == null);
    ThreadSummary localThreadSummary;
    LinkedHashMap localLinkedHashMap;
    ImmutableList localImmutableList;
    Object localObject;
    MessagesCollection localMessagesCollection;
    for (FetchThreadResult localFetchThreadResult = FetchThreadResult.a; ; localFetchThreadResult = new FetchThreadResult((DataFreshnessResult)localObject, localThreadSummary, localMessagesCollection, localImmutableList, null, localThreadSummaryResult.b))
    {
      return localFetchThreadResult;
      localThreadSummary = localThreadSummaryResult.a;
      localLinkedHashMap = b(paramString, l1, l1, paramInt);
      HashSet localHashSet = Sets.a();
      Iterator localIterator1 = localThreadSummary.i().iterator();
      while (localIterator1.hasNext())
        localHashSet.add(((ThreadParticipant)localIterator1.next()).d());
      Iterator localIterator2 = localThreadSummary.A().iterator();
      while (localIterator2.hasNext())
        localHashSet.add(((ThreadParticipant)localIterator2.next()).d());
      localImmutableList = this.c.a(localHashSet);
      if (localThreadSummary.d() != 0L)
        break;
      localObject = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
      boolean bool1 = localLinkedHashMap.containsKey(paramString);
      boolean bool2 = false;
      if (bool1)
      {
        bool2 = true;
        localLinkedHashMap.remove(paramString);
      }
      localMessagesCollection = new MessagesCollection(localThreadSummary.a(), ImmutableList.a(localLinkedHashMap.values()), bool2);
      Iterator localIterator4 = localMessagesCollection.b().iterator();
      if (!localIterator4.hasNext())
        continue;
      Message localMessage1 = (Message)localIterator4.next();
      this.k.a(localMessage1.c());
    }
    Iterator localIterator3 = localLinkedHashMap.values().iterator();
    while (localIterator3.hasNext())
    {
      Message localMessage2 = (Message)localIterator3.next();
      if (localMessage2.v())
        continue;
      l1 = localMessage2.p();
    }
    if (l1 == localThreadSummary.d());
    for (DataFreshnessResult localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE; ; localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_STALE)
    {
      localObject = localDataFreshnessResult;
      break;
    }
  }

  Message a(String paramString)
  {
    Message localMessage = this.j.a(paramString);
    if (localMessage != null);
    while (true)
    {
      return localMessage;
      localMessage = (Message)a(SqlQueryBuilder.a("msg_id", paramString), null, 1).get(paramString);
    }
  }

  Message b(String paramString)
  {
    LinkedHashMap localLinkedHashMap = a(SqlQueryBuilder.a("offline_threading_id", paramString), null, 1);
    boolean bool = localLinkedHashMap.isEmpty();
    Message localMessage = null;
    if (bool);
    while (true)
    {
      return localMessage;
      localMessage = (Message)localLinkedHashMap.values().iterator().next();
    }
  }

  Message c(String paramString)
  {
    SqlQueryBuilder.Expression[] arrayOfExpression = new SqlQueryBuilder.Expression[2];
    arrayOfExpression[0] = SqlQueryBuilder.a("msg_type", Integer.toString(900));
    arrayOfExpression[1] = SqlQueryBuilder.a("thread_id", paramString);
    LinkedHashMap localLinkedHashMap = a(SqlQueryBuilder.a(arrayOfExpression), "timestamp_sent_ms", 1);
    if (localLinkedHashMap.isEmpty());
    for (Message localMessage = null; ; localMessage = (Message)localLinkedHashMap.values().iterator().next())
      return localMessage;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbFetchThreadHandler
 * JD-Core Version:    0.6.0
 */