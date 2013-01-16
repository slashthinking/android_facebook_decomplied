package com.facebook.orca.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.facebook.orca.common.util.SqlQueryBuilder;
import com.facebook.orca.common.util.SqlQueryBuilder.AndExpression;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.compose.MessageDraft;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.DeleteMessagesParams;
import com.facebook.orca.server.DeleteThreadParams;
import com.facebook.orca.server.DeliveredReceiptParams;
import com.facebook.orca.server.FetchMoreMessagesResult;
import com.facebook.orca.server.FetchMoreThreadsResult;
import com.facebook.orca.server.FetchThreadListResult;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.MarkThreadParams;
import com.facebook.orca.server.MarkThreadParams.Mark;
import com.facebook.orca.server.NewMessageResult;
import com.facebook.orca.server.ReadReceiptParams;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.Message.ChannelSource;
import com.facebook.orca.threads.MessageBuilder;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.MessagesCollectionMerger;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantBuilder;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadSummaryBuilder;
import com.facebook.orca.threads.ThreadSummaryStitching;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import javax.inject.Provider;

class DbInsertThreadsHandler
{
  private final Class<?> a = DbInsertThreadsHandler.class;
  private final ThreadsDatabaseSupplier b;
  private final DbThreadsPropertyUtil c;
  private final DbFetchThreadHandler d;
  private final DbParticipantsSerialization e;
  private final DbAttachmentSerialization f;
  private final DbSharesSerialization g;
  private final DbCoordinatesSerialization h;
  private final DbMediaResourceSerialization i;
  private final DbDraftSerialization j;
  private final MessagesCollectionMerger k;
  private final Provider<User> l;
  private final ThreadSummaryStitching m;

  DbInsertThreadsHandler(ThreadsDatabaseSupplier paramThreadsDatabaseSupplier, DbThreadsPropertyUtil paramDbThreadsPropertyUtil, DbFetchThreadHandler paramDbFetchThreadHandler, DbParticipantsSerialization paramDbParticipantsSerialization, DbAttachmentSerialization paramDbAttachmentSerialization, DbSharesSerialization paramDbSharesSerialization, DbCoordinatesSerialization paramDbCoordinatesSerialization, DbMediaResourceSerialization paramDbMediaResourceSerialization, DbDraftSerialization paramDbDraftSerialization, MessagesCollectionMerger paramMessagesCollectionMerger, Provider<User> paramProvider, ThreadSummaryStitching paramThreadSummaryStitching)
  {
    this.b = paramThreadsDatabaseSupplier;
    this.c = paramDbThreadsPropertyUtil;
    this.d = paramDbFetchThreadHandler;
    this.e = paramDbParticipantsSerialization;
    this.f = paramDbAttachmentSerialization;
    this.g = paramDbSharesSerialization;
    this.h = paramDbCoordinatesSerialization;
    this.i = paramDbMediaResourceSerialization;
    this.j = paramDbDraftSerialization;
    this.k = paramMessagesCollectionMerger;
    this.l = paramProvider;
    this.m = paramThreadSummaryStitching;
  }

  private ThreadParticipant a(ThreadParticipant paramThreadParticipant, boolean paramBoolean, long paramLong, String paramString)
  {
    ThreadParticipantBuilder localThreadParticipantBuilder = new ThreadParticipantBuilder();
    localThreadParticipantBuilder.a(paramThreadParticipant);
    if (paramBoolean)
      localThreadParticipantBuilder.a(paramLong);
    while (true)
    {
      return localThreadParticipantBuilder.f();
      localThreadParticipantBuilder.b(paramString);
    }
  }

  private ThreadSummary a(ThreadSummary paramThreadSummary1, ThreadSummary paramThreadSummary2)
  {
    MessageDraft localMessageDraft = paramThreadSummary2.y();
    if (localMessageDraft == null);
    while (true)
    {
      return paramThreadSummary1;
      ThreadSummaryBuilder localThreadSummaryBuilder = new ThreadSummaryBuilder().a(paramThreadSummary1);
      localThreadSummaryBuilder.a(localMessageDraft);
      paramThreadSummary1 = localThreadSummaryBuilder.y();
    }
  }

  private Map<String, String> a(Set<String> paramSet)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    Map localMap = c(paramSet);
    localSQLiteDatabase.delete("messages", "msg_id IN " + SqlUtil.b(paramSet), null);
    return localMap;
  }

  private void a(FolderName paramFolderName)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramFolderName.b();
      localSQLiteDatabase.delete("folders", "folder=?", arrayOfString);
      this.c.c(DbProperties.b);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (SQLException localSQLException)
    {
      BLog.d(this.a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  private void a(FolderName paramFolderName, ThreadsCollection paramThreadsCollection)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    Iterator localIterator = paramThreadsCollection.b().iterator();
    while (localIterator.hasNext())
    {
      ThreadSummary localThreadSummary = (ThreadSummary)localIterator.next();
      ContentValues localContentValues2 = new ContentValues();
      localContentValues2.put("folder", paramFolderName.b());
      localContentValues2.put("thread_id", localThreadSummary.a());
      localContentValues2.put("timestamp_ms", Long.valueOf(localThreadSummary.k()));
      localSQLiteDatabase.replaceOrThrow("folders", "", localContentValues2);
    }
    if (paramThreadsCollection.c())
    {
      ContentValues localContentValues1 = new ContentValues();
      localContentValues1.put("folder", paramFolderName.b());
      localContentValues1.put("thread_id", DbFolders.a(paramFolderName));
      localContentValues1.put("timestamp_ms", Integer.valueOf(0));
      localSQLiteDatabase.replaceOrThrow("folders", "", localContentValues1);
    }
  }

  private void a(FolderName paramFolderName, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramFolderName.b();
    arrayOfString[1] = paramString;
    localSQLiteDatabase.delete("folders", "folder=? AND thread_id=?", arrayOfString);
  }

  private void a(Message paramMessage, boolean paramBoolean)
  {
    a(new MessagesCollection(paramMessage.b(), ImmutableList.a(paramMessage), false), paramBoolean);
  }

  private void a(MessagesCollection paramMessagesCollection)
  {
    a(paramMessagesCollection, false);
  }

  private void a(MessagesCollection paramMessagesCollection, boolean paramBoolean)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    HashSet localHashSet1;
    HashSet localHashSet2;
    HashSet localHashSet3;
    HashSet localHashSet4;
    HashSet localHashSet5;
    while (true)
    {
      Message localMessage2;
      try
      {
        localHashSet1 = Sets.a();
        localHashSet2 = Sets.a();
        localHashSet3 = Sets.a();
        localHashSet4 = Sets.a();
        localHashSet5 = Sets.a();
        Iterator localIterator1 = paramMessagesCollection.b().iterator();
        if (!localIterator1.hasNext())
          break;
        localMessage2 = (Message)localIterator1.next();
        localHashSet5.add(localMessage2.a());
        if (!localMessage2.v())
          continue;
        localHashSet1.add(localMessage2.a());
        if (localMessage2.u())
        {
          localHashSet2.add(localMessage2.t());
          if (!c(localMessage2))
            continue;
          localHashSet3.add(localMessage2.t());
          continue;
        }
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      if (!c(localMessage2))
        continue;
      localHashSet4.add(localMessage2.a());
    }
    Map localMap1 = c(localHashSet4);
    localHashSet3.addAll(localMap1.values());
    Map localMap2 = d(localHashSet3);
    Map localMap3 = e(localHashSet3);
    Map localMap4 = b(localHashSet5);
    if (!localHashSet2.isEmpty())
    {
      String str = "offline_threading_id IN " + SqlUtil.b(localHashSet2);
      BLog.a(this.a, "Deleting messsages WHERE %s", new Object[] { str });
      localSQLiteDatabase.delete("messages", str, null);
    }
    Set localSet = f(localHashSet1);
    Iterator localIterator2 = paramMessagesCollection.b().iterator();
    while (true)
      if (localIterator2.hasNext())
      {
        Object localObject2 = (Message)localIterator2.next();
        boolean bool = localMap3.containsKey(((Message)localObject2).t());
        if (bool);
        try
        {
          List localList = this.i.a((String)localMap3.get(((Message)localObject2).t()));
          Message localMessage1 = new MessageBuilder().a((Message)localObject2).e(localList).v();
          localObject2 = localMessage1;
          if (localSet.contains(((Message)localObject2).a()))
            continue;
          if ((!((Message)localObject2).u()) && (localMap1.containsKey(((Message)localObject2).a())))
            localObject2 = new MessageBuilder().a((Message)localObject2).e((String)localMap1.get(((Message)localObject2).a())).v();
          if ((((Message)localObject2).e() == 0L) && (((Message)localObject2).u()) && (localMap2.containsKey(((Message)localObject2).t())))
            localObject2 = new MessageBuilder().a((Message)localObject2).b(((Long)localMap2.get(((Message)localObject2).t())).longValue()).v();
          if (localMap4.containsKey(((Message)localObject2).a()))
            localObject2 = new MessageBuilder().a((Message)localObject2).d(((Long)localMap4.get(((Message)localObject2).a())).longValue()).v();
          b((Message)localObject2, paramBoolean);
        }
        catch (IOException localIOException)
        {
          while (true)
            BLog.a(this.a, "Preserving of the prior pendingSetnAttachment failed");
        }
      }
    if (paramMessagesCollection.d())
      b(g(paramMessagesCollection.a()), paramBoolean);
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }

  private void a(ThreadSummary paramThreadSummary)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("folder", paramThreadSummary.x().b());
    localContentValues.put("timestamp_ms", Long.valueOf(paramThreadSummary.k()));
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramThreadSummary.a();
    localSQLiteDatabase.update("folders", localContentValues, "thread_id=?", arrayOfString);
  }

  private void a(ThreadSummary paramThreadSummary, long paramLong)
  {
    ThreadSummary localThreadSummary = b(paramThreadSummary);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("thread_id", localThreadSummary.a());
    localContentValues.put("action_id", Long.valueOf(localThreadSummary.b()));
    localContentValues.put("refetch_action_id", Long.valueOf(localThreadSummary.c()));
    localContentValues.put("last_visible_action_id", Long.valueOf(localThreadSummary.d()));
    if (localThreadSummary.e())
      localContentValues.put("name", localThreadSummary.f());
    if (localThreadSummary.q())
      localContentValues.put("pic_hash", localThreadSummary.p());
    if (localThreadSummary.s())
      localContentValues.put("pic", localThreadSummary.r().toString());
    localContentValues.put("participants", this.e.b(localThreadSummary.i()));
    localContentValues.put("former_participants", this.e.b(localThreadSummary.A()));
    localContentValues.put("object_participants", this.e.a(localThreadSummary.j()));
    localContentValues.put("senders", this.e.a(localThreadSummary.l()));
    if (localThreadSummary.g());
    for (int n = 1; ; n = 0)
    {
      localContentValues.put("single_recipient_thread", Integer.valueOf(n));
      if (localThreadSummary.g())
        localContentValues.put("single_recipient_user_key", localThreadSummary.h().c());
      localContentValues.put("snippet", localThreadSummary.m());
      localContentValues.put("snippet_sender", this.e.a(localThreadSummary.o()));
      localContentValues.put("admin_snippet", localThreadSummary.n());
      localContentValues.put("timestamp_ms", Long.valueOf(localThreadSummary.k()));
      localContentValues.put("last_fetch_time_ms", Long.valueOf(paramLong));
      localContentValues.put("unread", Boolean.valueOf(localThreadSummary.t()));
      localContentValues.put("can_reply_to", Boolean.valueOf(localThreadSummary.u()));
      localContentValues.put("is_subscribed", Boolean.valueOf(localThreadSummary.v()));
      localContentValues.put("folder", localThreadSummary.x().b());
      localContentValues.put("draft", this.j.a(localThreadSummary.y()));
      this.b.b().replaceOrThrow("threads", "", localContentValues);
      return;
    }
  }

  private void a(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("thread_id", paramString);
      localSQLiteDatabase.insert("archived_sms_mms_threads", "", localContentValues);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (SQLException localSQLException)
    {
      BLog.d(this.a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  private void a(String paramString, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("handled_internally_time", Long.valueOf(paramLong));
    localSQLiteDatabase.update("messages", localContentValues, "msg_id = ?", new String[] { paramString });
  }

  private void a(String paramString1, UserKey paramUserKey, boolean paramBoolean, long paramLong, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    FetchThreadResult localFetchThreadResult = this.d.a(paramString1, 0);
    if (localFetchThreadResult.e() == DataFreshnessResult.NO_DATA);
    while (true)
    {
      return;
      ArrayList localArrayList = Lists.a();
      Iterator localIterator = localFetchThreadResult.a().i().iterator();
      while (localIterator.hasNext())
      {
        ThreadParticipant localThreadParticipant = (ThreadParticipant)localIterator.next();
        if (localThreadParticipant.d().equals(paramUserKey))
        {
          localArrayList.add(a(localThreadParticipant, paramBoolean, paramLong, paramString2));
          continue;
        }
        localArrayList.add(localThreadParticipant);
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("participants", this.e.b(localArrayList));
      localSQLiteDatabase.update("threads", localContentValues, "thread_id=?", new String[] { paramString1 });
    }
  }

  private ThreadSummary b(ThreadSummary paramThreadSummary)
  {
    FetchThreadResult localFetchThreadResult = this.d.a(paramThreadSummary.a(), 0);
    if (localFetchThreadResult.e() == DataFreshnessResult.NO_DATA);
    while (true)
    {
      return paramThreadSummary;
      ThreadSummary localThreadSummary = localFetchThreadResult.a();
      paramThreadSummary = a(b(paramThreadSummary, localThreadSummary), localThreadSummary);
    }
  }

  private ThreadSummary b(ThreadSummary paramThreadSummary1, ThreadSummary paramThreadSummary2)
  {
    HashMap localHashMap = Maps.a(paramThreadSummary2.i().size());
    Iterator localIterator1 = paramThreadSummary2.i().iterator();
    while (localIterator1.hasNext())
    {
      ThreadParticipant localThreadParticipant3 = (ThreadParticipant)localIterator1.next();
      localHashMap.put(localThreadParticipant3.d(), localThreadParticipant3);
    }
    ThreadSummaryBuilder localThreadSummaryBuilder = new ThreadSummaryBuilder().a(paramThreadSummary1);
    ArrayList localArrayList = Lists.c(localThreadSummaryBuilder.h().size());
    Iterator localIterator2 = localThreadSummaryBuilder.h().iterator();
    while (localIterator2.hasNext())
    {
      ThreadParticipant localThreadParticipant1 = (ThreadParticipant)localIterator2.next();
      ThreadParticipant localThreadParticipant2 = (ThreadParticipant)localHashMap.get(localThreadParticipant1.d());
      if (localThreadParticipant2 == null)
      {
        localArrayList.add(localThreadParticipant1);
        continue;
      }
      ThreadParticipantBuilder localThreadParticipantBuilder = new ThreadParticipantBuilder();
      localThreadParticipantBuilder.a(localThreadParticipant1);
      if (localThreadParticipantBuilder.d() < localThreadParticipant2.i())
        localThreadParticipantBuilder.a(localThreadParticipant2.i());
      localThreadParticipantBuilder.b(localThreadParticipant2.j());
      localArrayList.add(localThreadParticipantBuilder.f());
    }
    localThreadSummaryBuilder.a(localArrayList);
    return localThreadSummaryBuilder.y();
  }

  private Map<String, Long> b(Set<String> paramSet)
  {
    HashMap localHashMap1 = Maps.a();
    if (paramSet.isEmpty());
    for (HashMap localHashMap2 = localHashMap1; ; localHashMap2 = localHashMap1)
    {
      return localHashMap2;
      SQLiteDatabase localSQLiteDatabase = this.b.b();
      String[] arrayOfString = { "msg_id", "handled_internally_time" };
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = SqlUtil.b(paramSet);
      Cursor localCursor = localSQLiteDatabase.query("messages", arrayOfString, StringLocaleUtil.a("msg_id IN %s and handled_internally_time > 0", arrayOfObject), null, null, null, null);
      try
      {
        if (localCursor.moveToNext())
          localHashMap1.put(localCursor.getString(0), Long.valueOf(localCursor.getLong(1)));
      }
      finally
      {
        localCursor.close();
      }
    }
  }

  private void b(Message paramMessage)
  {
    a(new MessagesCollection(paramMessage.b(), ImmutableList.a(paramMessage), false));
  }

  private void b(Message paramMessage, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msg_id", paramMessage.a());
    localContentValues.put("thread_id", paramMessage.b());
    localContentValues.put("action_id", Long.valueOf(paramMessage.p()));
    if (paramMessage.g() != null)
      localContentValues.put("subject", paramMessage.g());
    if (paramMessage.h() != null)
      localContentValues.put("text", paramMessage.h());
    localContentValues.put("sender", this.e.a(paramMessage.f()));
    localContentValues.put("timestamp_ms", Long.valueOf(paramMessage.c()));
    localContentValues.put("msg_type", Integer.valueOf(paramMessage.r()));
    localContentValues.put("affected_users", this.e.a(paramMessage.s()));
    localContentValues.put("local_attachments", this.i.a(paramMessage.l()));
    localContentValues.put("attachments", this.f.a(paramMessage.m()));
    localContentValues.put("shares", this.g.a(paramMessage.n()));
    localContentValues.put("coordinates", this.h.a(paramMessage.k()));
    localContentValues.put("offline_threading_id", paramMessage.t());
    localContentValues.put("source", paramMessage.w());
    if (paramBoolean)
      localContentValues.put("is_non_authoritative", Boolean.valueOf(true));
    while (true)
    {
      if (paramMessage.z())
        localContentValues.put("pending_send_media_attachment", this.i.a(paramMessage.y()));
      if (paramMessage.e() != 0L)
        localContentValues.put("timestamp_sent_ms", Long.valueOf(paramMessage.e()));
      localContentValues.put("handled_internally_time", Long.valueOf(paramMessage.A()));
      this.b.b().replaceOrThrow("messages", "", localContentValues);
      BLog.a(this.a, "Inserted message: %s", new Object[] { paramMessage });
      return;
      localContentValues.put("is_non_authoritative", Boolean.valueOf(paramMessage.v()));
    }
  }

  private void b(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      localSQLiteDatabase.delete("archived_sms_mms_threads", "thread_id = ?", new String[] { paramString });
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (SQLException localSQLException)
    {
      BLog.d(this.a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  private void b(String paramString, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    LinkedHashMap localLinkedHashMap;
    Cursor localCursor;
    try
    {
      SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a();
      localAndExpression.a(SqlQueryBuilder.a("thread_id", paramString));
      localAndExpression.a(SqlQueryBuilder.a("msg_type", Integer.toString(900)));
      localLinkedHashMap = Maps.b();
      localCursor = localSQLiteDatabase.query("messages", new String[] { "msg_id", "timestamp_ms" }, localAndExpression.a(), localAndExpression.b(), null, null, "timestamp_ms");
    }
    finally
    {
      try
      {
        if (!localCursor.moveToNext())
          break label150;
        localLinkedHashMap.put(localCursor.getString(0), Long.valueOf(localCursor.getLong(1)));
      }
      finally
      {
        localCursor.close();
      }
      localSQLiteDatabase.endTransaction();
    }
    label150: localCursor.close();
    Iterator localIterator;
    long l2;
    if (!localLinkedHashMap.isEmpty())
    {
      long l1 = paramLong + 1L;
      localIterator = localLinkedHashMap.entrySet().iterator();
      l2 = l1;
    }
    while (true)
    {
      long l3;
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((Long)localEntry.getValue()).longValue() < l2)
        {
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("timestamp_ms", Long.valueOf(l2));
          String[] arrayOfString = new String[1];
          arrayOfString[0] = ((String)localEntry.getKey());
          localSQLiteDatabase.update("messages", localContentValues, "msg_id=?", arrayOfString);
          l3 = l2 + 1L;
        }
        else
        {
          l3 = 1L + ((Long)localEntry.getValue()).longValue();
        }
      }
      else
      {
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        return;
      }
      l2 = l3;
    }
  }

  private Map<String, String> c(Set<String> paramSet)
  {
    Object localObject1 = ImmutableMap.j();
    if (!paramSet.isEmpty())
    {
      HashMap localHashMap = Maps.a();
      String str = "msg_id IN " + SqlUtil.b(paramSet);
      Cursor localCursor = this.b.b().query("messages", new String[] { "msg_id", "offline_threading_id" }, str, null, null, null, null);
      try
      {
        while (localCursor.moveToNext())
        {
          if (localCursor.isNull(1))
            continue;
          localHashMap.put(localCursor.getString(0), localCursor.getString(1));
        }
      }
      finally
      {
        localCursor.close();
      }
      localObject1 = localHashMap;
    }
    return (Map<String, String>)localObject1;
  }

  private void c(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("thread_id", paramString);
      localSQLiteDatabase.insert("unread_mms_sms_threads", "", localContentValues);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (SQLException localSQLException)
    {
      BLog.d(this.a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  private boolean c(Message paramMessage)
  {
    ParticipantInfo localParticipantInfo = paramMessage.f();
    User localUser = (User)this.l.b();
    if ((localUser != null) && (Objects.equal(localUser.c(), localParticipantInfo.e())));
    for (int n = 1; ; n = 0)
      return n;
  }

  private Map<String, Long> d(Set<String> paramSet)
  {
    Object localObject1 = ImmutableMap.j();
    if (paramSet.isEmpty());
    while (true)
    {
      return localObject1;
      HashMap localHashMap = Maps.a();
      String str = "offline_threading_id IN " + SqlUtil.b(paramSet);
      Cursor localCursor = this.b.b().query("messages", new String[] { "offline_threading_id", "timestamp_sent_ms" }, str, null, null, null, null);
      try
      {
        while (localCursor.moveToNext())
        {
          if (localCursor.isNull(1))
            continue;
          localHashMap.put(localCursor.getString(0), Long.valueOf(localCursor.getLong(1)));
        }
      }
      finally
      {
        localCursor.close();
      }
      localObject1 = localHashMap;
    }
  }

  private void d(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      localSQLiteDatabase.delete("unread_mms_sms_threads", "thread_id = ?", new String[] { paramString });
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (SQLException localSQLException)
    {
      BLog.d(this.a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  private Map<String, String> e(Set<String> paramSet)
  {
    ImmutableMap.j();
    String str = "pending_send_media_attachment NOT NULL AND offline_threading_id IN " + SqlUtil.b(paramSet);
    Cursor localCursor = this.b.b().query("messages", new String[] { "offline_threading_id", "pending_send_media_attachment" }, str, null, null, null, null);
    HashMap localHashMap;
    try
    {
      localHashMap = Maps.a();
      if (localCursor.moveToNext())
        localHashMap.put(localCursor.getString(0), localCursor.getString(1));
    }
    finally
    {
      localCursor.close();
    }
    return localHashMap;
  }

  private void e(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      localSQLiteDatabase.delete("folders", "thread_id=?", new String[] { paramString });
      localSQLiteDatabase.delete("threads", "thread_id=?", new String[] { paramString });
      localSQLiteDatabase.delete("messages", "thread_id=?", new String[] { paramString });
      localSQLiteDatabase.delete("archived_sms_mms_threads", "thread_id=?", new String[] { paramString });
      this.c.b(DbProperties.a(paramString));
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (SQLException localSQLException)
    {
      BLog.d(this.a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  private Set<String> f(Set<String> paramSet)
  {
    Object localObject1 = ImmutableSet.d();
    if (paramSet.isEmpty());
    while (true)
    {
      return localObject1;
      HashSet localHashSet = Sets.a();
      String str = "msg_id IN " + SqlUtil.b(paramSet);
      Cursor localCursor = this.b.b().query("messages", new String[] { "msg_id" }, str, null, null, null, null);
      try
      {
        if (localCursor.moveToNext())
          localHashSet.add(localCursor.getString(0));
      }
      finally
      {
        localCursor.close();
      }
      localObject1 = localHashSet;
    }
  }

  private void f(String paramString)
  {
    this.b.b().delete("messages", "thread_id=?", new String[] { paramString });
  }

  private Message g(String paramString)
  {
    return new MessageBuilder().a(paramString).b(paramString).a(-1).a(0L).v();
  }

  NewMessageResult a(NewMessageResult paramNewMessageResult)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    while (true)
    {
      Message localMessage1;
      try
      {
        String str = paramNewMessageResult.a();
        localMessage1 = paramNewMessageResult.b();
        if (localMessage1 == null)
          return paramNewMessageResult;
        if (!MessagingIdUtil.g(str))
          continue;
        b(str);
        Message localMessage2 = this.d.a(localMessage1.a());
        if ((localMessage2 != null) || (!localMessage1.u()))
          continue;
        localMessage2 = this.d.b(localMessage1.t());
        if ((localMessage1.e() == 0L) && (localMessage2 != null) && (localMessage2.e() != 0L))
        {
          localMessage3 = new MessageBuilder().a(localMessage1).b(localMessage2.e()).v();
          Message.ChannelSource localChannelSource1 = localMessage3.x();
          Message.ChannelSource localChannelSource2 = Message.ChannelSource.C2DM;
          if ((localChannelSource1 != localChannelSource2) || (localMessage2 == null))
            continue;
          localSQLiteDatabase.endTransaction();
          paramNewMessageResult = null;
          continue;
          boolean bool1 = localMessage3.v();
          boolean bool2 = false;
          if (!bool1)
            continue;
          if (!bool2)
            continue;
          a(paramNewMessageResult.c());
          if (!c(localMessage3))
            continue;
          a(localMessage3.a(), System.currentTimeMillis());
          b(str, localMessage3.c());
          MessagesCollection localMessagesCollection2 = this.d.a(str, localMessage3.c(), -1L, 100).a();
          Message localMessage4 = this.d.a(localMessage3.a());
          paramNewMessageResult = new NewMessageResult(paramNewMessageResult.e(), str, localMessage4, localMessagesCollection2, paramNewMessageResult.f());
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          continue;
          MessagesCollection localMessagesCollection1 = paramNewMessageResult.c();
          bool2 = false;
          if (localMessagesCollection1 == null)
            continue;
          FetchThreadResult localFetchThreadResult1 = this.d.a(str, 5);
          bool2 = this.k.c(paramNewMessageResult.c(), localFetchThreadResult1.b());
          continue;
          a(localMessage3, true);
          FetchThreadResult localFetchThreadResult2 = this.d.a(str, 1);
          if (localFetchThreadResult2.a() == null)
            continue;
          ThreadSummary localThreadSummary = this.m.a(localFetchThreadResult2.a(), localMessage3);
          a(localThreadSummary);
          a(localThreadSummary, paramNewMessageResult.f());
          continue;
        }
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      Message localMessage3 = localMessage1;
    }
  }

  Map<String, String> a(DeleteMessagesParams paramDeleteMessagesParams)
  {
    return a(paramDeleteMessagesParams.b());
  }

  void a(DeleteThreadParams paramDeleteThreadParams)
  {
    e(paramDeleteThreadParams.a());
  }

  void a(DeliveredReceiptParams paramDeliveredReceiptParams)
  {
    a(paramDeliveredReceiptParams.b(), paramDeliveredReceiptParams.c(), false, 0L, paramDeliveredReceiptParams.a());
  }

  void a(FetchMoreMessagesResult paramFetchMoreMessagesResult1, FetchMoreMessagesResult paramFetchMoreMessagesResult2)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    if (paramFetchMoreMessagesResult1 != null);
    try
    {
      if ((paramFetchMoreMessagesResult1.e() != DataFreshnessResult.NO_DATA) && (!this.k.c(paramFetchMoreMessagesResult1.a(), paramFetchMoreMessagesResult2.a())))
        BLog.b(this.a, "Performance warning - can't add more messages");
      while (true)
      {
        return;
        a(paramFetchMoreMessagesResult2.a());
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
      }
    }
    catch (SQLException localSQLException)
    {
      BLog.d(this.a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  void a(FetchMoreThreadsResult paramFetchMoreThreadsResult)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      long l1 = paramFetchMoreThreadsResult.f();
      ThreadsCollection localThreadsCollection = paramFetchMoreThreadsResult.b();
      a(paramFetchMoreThreadsResult.a(), paramFetchMoreThreadsResult.b());
      Iterator localIterator = localThreadsCollection.b().iterator();
      while (localIterator.hasNext())
        a((ThreadSummary)localIterator.next(), l1);
    }
    catch (SQLException localSQLException)
    {
      BLog.d(this.a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }

  void a(FetchThreadListResult paramFetchThreadListResult)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    long l1;
    FolderName localFolderName;
    try
    {
      l1 = paramFetchThreadListResult.f();
      localFolderName = paramFetchThreadListResult.a();
      this.c.b(DbProperties.a(localFolderName), l1);
      this.c.b(DbProperties.b(localFolderName), paramFetchThreadListResult.k());
      this.c.b(DbProperties.c(localFolderName), false);
      if (!paramFetchThreadListResult.j())
        break label171;
      Iterator localIterator2 = paramFetchThreadListResult.d().iterator();
      while (localIterator2.hasNext())
        e((String)localIterator2.next());
    }
    catch (SQLException localSQLException)
    {
      BLog.d(this.a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    Iterator localIterator3 = paramFetchThreadListResult.g().iterator();
    while (localIterator3.hasNext())
    {
      a(localFolderName, (String)localIterator3.next());
      continue;
      label171: a(localFolderName);
    }
    a(localFolderName, paramFetchThreadListResult.h());
    a(localFolderName, paramFetchThreadListResult.b());
    Iterator localIterator1 = paramFetchThreadListResult.b().b().iterator();
    while (localIterator1.hasNext())
    {
      ThreadSummary localThreadSummary1 = (ThreadSummary)localIterator1.next();
      a(localThreadSummary1, l1);
      if (!paramFetchThreadListResult.j())
        continue;
      FetchThreadResult localFetchThreadResult = this.d.a(localThreadSummary1.a(), 0);
      if (localFetchThreadResult.e() == DataFreshnessResult.NO_DATA)
        continue;
      ThreadSummary localThreadSummary2 = localFetchThreadResult.a();
      if (localThreadSummary1.c() <= localThreadSummary2.c())
        continue;
      f(localThreadSummary1.a());
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }

  void a(FetchThreadResult paramFetchThreadResult)
  {
    FetchThreadResult localFetchThreadResult = this.d.a(paramFetchThreadResult.a().a(), 3);
    if (localFetchThreadResult.e() == DataFreshnessResult.NO_DATA)
      localFetchThreadResult = null;
    a(localFetchThreadResult, paramFetchThreadResult);
  }

  void a(FetchThreadResult paramFetchThreadResult1, FetchThreadResult paramFetchThreadResult2)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    while (true)
    {
      try
      {
        ThreadSummary localThreadSummary = paramFetchThreadResult2.a();
        String str = localThreadSummary.a();
        if ((paramFetchThreadResult1 == null) || (paramFetchThreadResult1.e() == DataFreshnessResult.NO_DATA) || (this.k.c(paramFetchThreadResult2.b(), paramFetchThreadResult1.b())))
          continue;
        BLog.b(this.a, "Performance warning - deleting old messages to avoid hole");
        localSQLiteDatabase.delete("messages", "thread_id=?", new String[] { str });
        a(localThreadSummary);
        a(localThreadSummary, paramFetchThreadResult2.f());
        a(paramFetchThreadResult2.b());
        Iterator localIterator = paramFetchThreadResult2.b().b().iterator();
        if (localIterator.hasNext())
        {
          Message localMessage = (Message)localIterator.next();
          if (!c(localMessage))
            continue;
          l1 = localMessage.c();
          if (l1 == -1L)
            continue;
          b(str, l1);
          this.c.b(DbProperties.a(str), localThreadSummary.b());
          localSQLiteDatabase.setTransactionSuccessful();
          return;
        }
      }
      catch (SQLException localSQLException)
      {
        BLog.d(this.a, "SQLException", localSQLException);
        throw localSQLException;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      long l1 = -1L;
    }
  }

  void a(MarkThreadParams paramMarkThreadParams)
  {
    boolean bool = true;
    String str = paramMarkThreadParams.a();
    MarkThreadParams.Mark localMark = paramMarkThreadParams.b();
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    while (true)
    {
      try
      {
        if (localMark == MarkThreadParams.Mark.READ)
        {
          ContentValues localContentValues = new ContentValues();
          if (paramMarkThreadParams.c())
            continue;
          localContentValues.put("unread", Boolean.valueOf(bool));
          localSQLiteDatabase.update("threads", localContentValues, "thread_id=?", new String[] { str });
          if (!MessagingIdUtil.g(str))
            continue;
          if (!paramMarkThreadParams.c())
            continue;
          d(str);
          localSQLiteDatabase.setTransactionSuccessful();
          return;
          bool = false;
          continue;
          c(str);
          continue;
        }
      }
      catch (SQLException localSQLException)
      {
        BLog.d(this.a, "SQLException", localSQLException);
        throw localSQLException;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      if ((localMark != MarkThreadParams.Mark.ARCHIVED) || (!paramMarkThreadParams.c()))
        continue;
      if (MessagingIdUtil.g(str))
      {
        a(str);
        continue;
      }
      a(FolderName.b, str);
    }
  }

  void a(ReadReceiptParams paramReadReceiptParams)
  {
    a(paramReadReceiptParams.b(), paramReadReceiptParams.c(), true, paramReadReceiptParams.a(), null);
  }

  void a(FolderName paramFolderName, FolderCounts paramFolderCounts)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("folder", paramFolderName.b());
    localContentValues.put("unread_count", Integer.valueOf(paramFolderCounts.a()));
    localContentValues.put("unseen_count", Integer.valueOf(paramFolderCounts.b()));
    localContentValues.put("last_seen_time", Long.valueOf(paramFolderCounts.c()));
    localContentValues.put("last_action_id", Long.valueOf(paramFolderCounts.d()));
    localSQLiteDatabase.replaceOrThrow("folder_counts", null, localContentValues);
  }

  void a(Message paramMessage)
  {
    b(paramMessage);
  }

  void a(String paramString, MessageDraft paramMessageDraft)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("draft", this.j.a(paramMessageDraft));
    localSQLiteDatabase.update("threads", localContentValues, "thread_id=?", new String[] { paramString });
  }

  void a(String paramString, FetchThreadResult paramFetchThreadResult, FetchMoreMessagesResult paramFetchMoreMessagesResult)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      if (!this.k.c(paramFetchThreadResult.b(), paramFetchMoreMessagesResult.a()))
        BLog.b(this.a, "Performance warning - can't add more messages");
      while (true)
      {
        return;
        a(paramFetchMoreMessagesResult.a());
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
      }
    }
    catch (SQLException localSQLException)
    {
      BLog.d(this.a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbInsertThreadsHandler
 * JD-Core Version:    0.6.0
 */