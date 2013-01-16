package com.facebook.orca.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.app.OrcaDataManager;
import com.facebook.orca.appconfig.AppConfig;
import com.facebook.orca.appconfig.AppConfigSerialization;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.compose.MessageDraft;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.prefs.ConfigPrefKeys;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.server.AbstractOrcaServiceHandlerFilter;
import com.facebook.orca.server.AddMembersParams;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.DeleteMessagesParams;
import com.facebook.orca.server.DeleteThreadParams;
import com.facebook.orca.server.DeliveredReceiptParams;
import com.facebook.orca.server.FetchMoreMessagesParams;
import com.facebook.orca.server.FetchMoreMessagesResult;
import com.facebook.orca.server.FetchMoreThreadsParams;
import com.facebook.orca.server.FetchMoreThreadsResult;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadListParamsBuilder;
import com.facebook.orca.server.FetchThreadListResult;
import com.facebook.orca.server.FetchThreadListResultBuilder;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FetchThreadParamsBuilder;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.MarkThreadParams;
import com.facebook.orca.server.NewMessageResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OperationResultUtil;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.ReadReceiptParams;
import com.facebook.orca.server.ReceiptResult;
import com.facebook.orca.server.RemoveMemberParams;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.Message.ChannelSource;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.MessagesCollectionMerger;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Provider;

public class DbServiceHandler extends AbstractOrcaServiceHandlerFilter
{
  private Class<?> a = DbServiceHandler.class;
  private final String b = "messenger_client_sms_android";
  private final OrcaActivityBroadcaster c;
  private final DataCache d;
  private final DbFetchThreadsHandler e;
  private final DbFetchThreadHandler f;
  private final DbInsertThreadsHandler g;
  private final DbInsertThreadUsersHandler h;
  private final DbSendHandler i;
  private final DbThreadsPropertyUtil j;
  private final ThreadsDatabaseSupplier k;
  private final OrcaSharedPreferences l;
  private final AppConfigSerialization m;
  private final MessagesCollectionMerger n;
  private final OrcaDataManager o;
  private final DbCache p;
  private final Provider<Boolean> q;

  DbServiceHandler(OrcaActivityBroadcaster paramOrcaActivityBroadcaster, DataCache paramDataCache, DbFetchThreadsHandler paramDbFetchThreadsHandler, DbFetchThreadHandler paramDbFetchThreadHandler, DbInsertThreadsHandler paramDbInsertThreadsHandler, DbInsertThreadUsersHandler paramDbInsertThreadUsersHandler, DbSendHandler paramDbSendHandler, DbThreadsPropertyUtil paramDbThreadsPropertyUtil, ThreadsDatabaseSupplier paramThreadsDatabaseSupplier, OrcaSharedPreferences paramOrcaSharedPreferences, AppConfigSerialization paramAppConfigSerialization, MessagesCollectionMerger paramMessagesCollectionMerger, OrcaDataManager paramOrcaDataManager, DbCache paramDbCache, Provider<Boolean> paramProvider)
  {
    super("DbServiceHandler");
    this.c = paramOrcaActivityBroadcaster;
    this.d = paramDataCache;
    this.e = paramDbFetchThreadsHandler;
    this.f = paramDbFetchThreadHandler;
    this.g = paramDbInsertThreadsHandler;
    this.h = paramDbInsertThreadUsersHandler;
    this.i = paramDbSendHandler;
    this.j = paramDbThreadsPropertyUtil;
    this.k = paramThreadsDatabaseSupplier;
    this.l = paramOrcaSharedPreferences;
    this.m = paramAppConfigSerialization;
    this.n = paramMessagesCollectionMerger;
    this.o = paramOrcaDataManager;
    this.p = paramDbCache;
    this.q = paramProvider;
  }

  private FetchThreadResult a(FetchThreadParams paramFetchThreadParams, FetchThreadResult paramFetchThreadResult, OrcaServiceHandler paramOrcaServiceHandler)
  {
    ThreadSummary localThreadSummary = paramFetchThreadResult.a();
    MessagesCollection localMessagesCollection = paramFetchThreadResult.b();
    if ((localThreadSummary == null) || (localMessagesCollection == null) || (localMessagesCollection.e()))
      paramFetchThreadResult = null;
    while (true)
    {
      return paramFetchThreadResult;
      if (paramFetchThreadParams.b() == DataFreshnessParam.STALE_DATA_OKAY)
        continue;
      try
      {
        c(paramFetchThreadParams, b(paramFetchThreadParams, paramFetchThreadResult, paramOrcaServiceHandler), paramOrcaServiceHandler);
        FetchThreadResult localFetchThreadResult = this.f.a(paramFetchThreadParams.a().a(), paramFetchThreadParams.f());
        paramFetchThreadResult = new FetchThreadResult(DataFreshnessResult.FROM_SERVER, localFetchThreadResult);
      }
      catch (IOException localIOException)
      {
        if (paramFetchThreadParams.c() != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA)
          paramFetchThreadResult = new FetchThreadResult(DataFreshnessResult.FROM_CACHE_HAD_SERVER_ERROR, paramFetchThreadResult.a(), paramFetchThreadResult.b(), paramFetchThreadResult.c(), paramFetchThreadResult.d(), paramFetchThreadResult.f());
      }
    }
    throw localIOException;
  }

  private void a(AppConfig paramAppConfig)
  {
    if (paramAppConfig == null);
    while (true)
    {
      return;
      OrcaSharedPreferences.Editor localEditor = this.l.b();
      localEditor.a(ConfigPrefKeys.c, this.m.a(paramAppConfig));
      localEditor.a(ConfigPrefKeys.b, System.currentTimeMillis());
      localEditor.a();
    }
  }

  private boolean a(Bundle paramBundle)
  {
    int i1;
    if (paramBundle == null)
      i1 = 0;
    while (true)
    {
      return i1;
      if ((((Boolean)this.q.b()).booleanValue()) && (!paramBundle.getBoolean("messenger_client_sms_android", false)))
      {
        i1 = 1;
        continue;
      }
      i1 = 0;
    }
  }

  private boolean a(DataFreshnessParam paramDataFreshnessParam, FetchThreadResult paramFetchThreadResult)
  {
    int i1 = 1;
    if (paramDataFreshnessParam == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
    while (true)
    {
      return i1;
      if (paramFetchThreadResult.e() != DataFreshnessResult.FROM_CACHE_UP_TO_DATE)
        continue;
      i1 = 0;
    }
  }

  private FetchThreadResult b(FetchThreadParams paramFetchThreadParams, FetchThreadResult paramFetchThreadResult, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (!a(paramFetchThreadParams.b(), paramFetchThreadResult))
      return paramFetchThreadResult;
    MessagesCollection localMessagesCollection1 = paramFetchThreadResult.b();
    Iterator localIterator = localMessagesCollection1.b().iterator();
    Message localMessage1;
    while (localIterator.hasNext())
    {
      Message localMessage2 = (Message)localIterator.next();
      if (localMessage2.v())
        continue;
      localMessage1 = localMessage2;
    }
    while (true)
      while (true)
      {
        long l1 = -1L;
        if (localMessage1 != null)
          l1 = localMessage1.c() - 1L;
        FetchThreadParams localFetchThreadParams = new FetchThreadParamsBuilder().a(paramFetchThreadParams).a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).b(l1).h();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("fetchThreadParams", localFetchThreadParams);
        FetchThreadResult localFetchThreadResult = (FetchThreadResult)paramOrcaServiceHandler.a(new OperationParams("fetch_thread", localBundle)).h();
        SQLiteDatabase localSQLiteDatabase = this.k.b();
        localSQLiteDatabase.beginTransaction();
        try
        {
          this.g.a(paramFetchThreadResult, localFetchThreadResult);
          this.h.a(localFetchThreadResult.c());
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          MessagesCollection localMessagesCollection2 = this.n.b(localFetchThreadResult.b(), localMessagesCollection1);
          paramFetchThreadResult = new FetchThreadResult(DataFreshnessResult.FROM_SERVER, localFetchThreadResult.a(), localMessagesCollection2, localFetchThreadResult.c(), null, System.currentTimeMillis());
        }
        finally
        {
          localSQLiteDatabase.endTransaction();
        }
      }
  }

  private void b(Bundle paramBundle)
  {
    if (paramBundle == null);
    while (true)
    {
      return;
      OrcaSharedPreferences.Editor localEditor = this.l.b();
      localEditor.a(GkPrefKeys.d, System.currentTimeMillis());
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.a(GkPrefKeys.a(str), paramBundle.getBoolean(str));
      }
      localEditor.a();
    }
  }

  private FetchThreadResult c(FetchThreadParams paramFetchThreadParams, FetchThreadResult paramFetchThreadResult, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (paramFetchThreadResult.b().d());
    while (true)
    {
      return paramFetchThreadResult;
      ThreadSummary localThreadSummary = paramFetchThreadResult.a();
      MessagesCollection localMessagesCollection1 = paramFetchThreadResult.b();
      String str = paramFetchThreadParams.a().a();
      int i1 = paramFetchThreadParams.f() - localMessagesCollection1.f();
      if (i1 <= 0)
        continue;
      Message localMessage = localMessagesCollection1.a(-1 + localMessagesCollection1.f());
      FetchMoreMessagesParams localFetchMoreMessagesParams = new FetchMoreMessagesParams(ThreadCriteria.a(str), 0L, localMessage.c(), i1 + 1);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchMoreMessagesParams", localFetchMoreMessagesParams);
      FetchMoreMessagesResult localFetchMoreMessagesResult = (FetchMoreMessagesResult)paramOrcaServiceHandler.a(new OperationParams("fetch_more_messages", localBundle)).h();
      this.g.a(str, paramFetchThreadResult, localFetchMoreMessagesResult);
      MessagesCollection localMessagesCollection2 = localFetchMoreMessagesResult.a();
      MessagesCollection localMessagesCollection3 = this.n.b(localMessagesCollection1, localMessagesCollection2);
      paramFetchThreadResult = new FetchThreadResult(DataFreshnessResult.FROM_SERVER, localThreadSummary, localMessagesCollection3, paramFetchThreadResult.c(), null, System.currentTimeMillis());
    }
  }

  private void c(Bundle paramBundle)
  {
    if (paramBundle == null);
    while (true)
    {
      return;
      OrcaSharedPreferences.Editor localEditor = this.l.b();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.a(ConfigPrefKeys.a(str), paramBundle.getString(str));
      }
      localEditor.a();
    }
  }

  protected OperationResult c(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.a();
    FetchThreadListParams localFetchThreadListParams1 = (FetchThreadListParams)paramOperationParams.b().getParcelable("fetchThreadListParams");
    DataFreshnessParam localDataFreshnessParam = localFetchThreadListParams1.a();
    Tracer localTracer1 = Tracer.a("DbServiceHandler.handleFetchThreadList");
    while (true)
    {
      OperationResult localOperationResult1;
      try
      {
        FetchThreadListResult localFetchThreadListResult1 = this.e.a(localFetchThreadListParams1);
        switch (DbServiceHandler.1.a[localDataFreshnessParam.ordinal()])
        {
        case 1:
          if (i1 == 0)
            continue;
          OperationResult localOperationResult2 = OperationResult.a(localFetchThreadListResult1);
          localObject3 = localOperationResult2;
          localTracer1.a();
          return localObject3;
          if (localFetchThreadListResult1.e() == DataFreshnessResult.NO_DATA)
            break label408;
          i1 = 1;
          break;
        case 3:
          if (localFetchThreadListResult1.e() != DataFreshnessResult.FROM_CACHE_UP_TO_DATE)
            break label420;
          i1 = 1;
          continue;
          long l1 = localFetchThreadListResult1.k();
          boolean bool = l1 < 0L;
          i2 = 0;
          if (!bool)
            continue;
          i2 = 1;
          FetchThreadListParamsBuilder localFetchThreadListParamsBuilder = FetchThreadListParams.newBuilder().a(localFetchThreadListParams1).a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).a(localFetchThreadListParams1.b());
          if (i2 == 0)
            break label426;
          l2 = l1;
          localFetchThreadListParams2 = localFetchThreadListParamsBuilder.a(l2).f();
          Bundle localBundle = new Bundle();
          localBundle.putParcelable("fetchThreadListParams", localFetchThreadListParams2);
          localOperationResult1 = paramOrcaServiceHandler.a(new OperationParams(str, localBundle));
          localFetchThreadListResult2 = (FetchThreadListResult)localOperationResult1.h();
          localTracer2 = Tracer.a("DbServiceHandler.handleFetchThreadList#insertData");
          localSQLiteDatabase = this.k.b();
          localSQLiteDatabase.beginTransaction();
        default:
        case 2:
        }
      }
      finally
      {
        try
        {
          int i2;
          FetchThreadListParams localFetchThreadListParams2;
          FetchThreadListResult localFetchThreadListResult2;
          this.g.a(localFetchThreadListResult2);
          this.h.a(localFetchThreadListResult2.c());
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          localTracer2.a();
          if ((i2 != 0) || (localFetchThreadListParams2.b() == FolderName.d))
          {
            FetchThreadListResult localFetchThreadListResult3 = this.e.a(localFetchThreadListParams1);
            localObject3 = OperationResult.a(FetchThreadListResult.newBuilder().a(localFetchThreadListResult3).a(localFetchThreadListResult2.i()).o());
          }
        }
        finally
        {
          Tracer localTracer2;
          SQLiteDatabase localSQLiteDatabase;
          localSQLiteDatabase.endTransaction();
          localTracer2.a();
        }
      }
      Object localObject3 = localOperationResult1;
      continue;
      int i1 = 0;
      continue;
      label408: i1 = 0;
      continue;
      i1 = 1;
      continue;
      label420: i1 = 0;
      continue;
      label426: long l2 = -1L;
    }
  }

  protected OperationResult d(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchMoreThreadsParams localFetchMoreThreadsParams = (FetchMoreThreadsParams)paramOperationParams.b().getParcelable("fetchMoreThreadsParams");
    FetchMoreThreadsResult localFetchMoreThreadsResult1 = this.e.a(localFetchMoreThreadsParams);
    Object localObject;
    if ((localFetchMoreThreadsResult1.b().c()) || (localFetchMoreThreadsResult1.b().e() == localFetchMoreThreadsParams.c()))
      localObject = OperationResult.a(localFetchMoreThreadsResult1);
    while (true)
    {
      return localObject;
      OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      FetchMoreThreadsResult localFetchMoreThreadsResult2 = (FetchMoreThreadsResult)localOperationResult.h();
      this.g.a(localFetchMoreThreadsResult2);
      if (localFetchMoreThreadsParams.a() == FolderName.d)
      {
        localObject = OperationResult.a(this.e.a(localFetchMoreThreadsParams));
        continue;
      }
      localObject = localOperationResult;
    }
  }

  protected OperationResult e(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    this.i.a();
    FetchThreadParams localFetchThreadParams = (FetchThreadParams)paramOperationParams.b().getParcelable("fetchThreadParams");
    DataFreshnessParam localDataFreshnessParam = localFetchThreadParams.b();
    int i1 = localFetchThreadParams.f();
    ThreadCriteria localThreadCriteria = localFetchThreadParams.a();
    Tracer localTracer = Tracer.a("DbServiceHandler.handleFetchThread");
    FetchThreadResult localFetchThreadResult1;
    OperationResult localOperationResult1;
    while (true)
    {
      try
      {
        if (localThreadCriteria.a() == null)
          continue;
        localFetchThreadResult1 = this.f.a(localThreadCriteria.a(), i1);
        if (localDataFreshnessParam == DataFreshnessParam.DO_NOT_CHECK_SERVER)
        {
          OperationResult localOperationResult2 = OperationResult.a(localFetchThreadResult1);
          localOperationResult1 = localOperationResult2;
          return localOperationResult1;
          if (localThreadCriteria.b() == null)
            continue;
          localFetchThreadResult1 = this.f.a(localThreadCriteria.b(), i1);
          continue;
          throw new IllegalArgumentException("No threadid or userkey specified for thread fetch");
        }
      }
      finally
      {
        localTracer.a();
      }
      FetchThreadResult localFetchThreadResult2 = a(localFetchThreadParams, localFetchThreadResult1, paramOrcaServiceHandler);
      if (localFetchThreadResult2 == null)
        break;
      localOperationResult1 = OperationResult.a(localFetchThreadResult2);
    }
    FetchThreadResult localFetchThreadResult3 = (FetchThreadResult)paramOrcaServiceHandler.a(paramOperationParams).h();
    SQLiteDatabase localSQLiteDatabase = this.k.b();
    localSQLiteDatabase.beginTransaction();
    while (true)
    {
      FetchThreadResult localFetchThreadResult4;
      try
      {
        if (localFetchThreadResult3.a() == null)
          continue;
        this.g.a(localFetchThreadResult1, localFetchThreadResult3);
        if (localFetchThreadResult3.c() == null)
          continue;
        this.h.a(localFetchThreadResult3.c());
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        if (localFetchThreadResult3.a() == null)
          continue;
        String str = localFetchThreadResult3.a().a();
        FetchThreadResult localFetchThreadResult5 = this.f.a(str, i1);
        localObject3 = new FetchThreadResult(DataFreshnessResult.FROM_SERVER, localFetchThreadResult5);
        localOperationResult1 = OperationResult.a((Parcelable)localObject3);
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      Object localObject3 = localFetchThreadResult4;
    }
  }

  protected OperationResult f(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    this.i.a();
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    FetchThreadResult localFetchThreadResult = (FetchThreadResult)localOperationResult.h();
    SQLiteDatabase localSQLiteDatabase = this.k.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      this.g.a(localFetchThreadResult);
      this.h.a(localFetchThreadResult.c());
      localSQLiteDatabase.setTransactionSuccessful();
      return localOperationResult;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  protected OperationResult g(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    this.i.a();
    Message localMessage = (Message)paramOperationParams.b().getParcelable("outgoingMessage");
    this.g.a(localMessage);
    this.g.a(localMessage.b(), null);
    return OperationResult.b();
  }

  protected OperationResult h(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    ((AddMembersParams)paramOperationParams.b().getParcelable("addMembersParams"));
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    FetchThreadResult localFetchThreadResult = (FetchThreadResult)localOperationResult.h();
    this.g.a(localFetchThreadResult);
    this.h.a(localFetchThreadResult.c());
    return localOperationResult;
  }

  protected OperationResult i(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    ((RemoveMemberParams)paramOperationParams.b().getParcelable("removeMemberParams"));
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    this.d.a().b();
    FetchThreadResult localFetchThreadResult = (FetchThreadResult)localOperationResult.h();
    SQLiteDatabase localSQLiteDatabase = this.k.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      this.g.a(localFetchThreadResult);
      this.h.a(localFetchThreadResult.c());
      localSQLiteDatabase.setTransactionSuccessful();
      return localOperationResult;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  protected OperationResult j(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    MarkThreadParams localMarkThreadParams = (MarkThreadParams)paramOperationParams.b().getParcelable("markThreadParams");
    this.g.a(localMarkThreadParams);
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  protected OperationResult k(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    ReadReceiptParams localReadReceiptParams = (ReadReceiptParams)paramOperationParams.b().getParcelable("readReceiptParams");
    this.g.a(localReadReceiptParams);
    FetchThreadResult localFetchThreadResult = this.f.a(localReadReceiptParams.b(), 0);
    return OperationResult.a(new ReceiptResult(localFetchThreadResult.e(), localFetchThreadResult.a(), localFetchThreadResult.f()));
  }

  protected OperationResult l(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    DeliveredReceiptParams localDeliveredReceiptParams = (DeliveredReceiptParams)paramOperationParams.b().getParcelable("deliveredReceiptParms");
    this.g.a(localDeliveredReceiptParams);
    FetchThreadResult localFetchThreadResult = this.f.a(localDeliveredReceiptParams.b(), 0);
    return OperationResult.a(new ReceiptResult(localFetchThreadResult.e(), localFetchThreadResult.a(), localFetchThreadResult.f()));
  }

  protected OperationResult m(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    DeleteThreadParams localDeleteThreadParams = (DeleteThreadParams)paramOperationParams.b().getParcelable("deleteThreadParams");
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    this.g.a(localDeleteThreadParams);
    return localOperationResult;
  }

  protected OperationResult n(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    DeleteMessagesParams localDeleteMessagesParams1 = (DeleteMessagesParams)paramOperationParams.b().getParcelable("deleteMessagesParams");
    ImmutableSet.Builder localBuilder = ImmutableSet.e();
    Iterator localIterator = localDeleteMessagesParams1.b().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!MessagingIdUtil.f(str)) && (!MessagingIdUtil.h(str)) && (!MessagingIdUtil.i(str)))
        continue;
      localBuilder.b(str);
    }
    ImmutableSet localImmutableSet = localBuilder.b();
    OperationResult localOperationResult1;
    OperationResult localOperationResult2;
    if (!localImmutableSet.isEmpty())
    {
      DeleteMessagesParams localDeleteMessagesParams2 = new DeleteMessagesParams(localDeleteMessagesParams1.a(), localImmutableSet);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("deleteMessagesParams", localDeleteMessagesParams2);
      localOperationResult1 = paramOrcaServiceHandler.a(new OperationParams("delete_messages", localBundle));
      localOperationResult2 = OperationResultUtil.a(localOperationResult1, "message_offline_threading_ids", Maps.a(this.g.a(localDeleteMessagesParams1)));
      FetchMoreMessagesResult localFetchMoreMessagesResult = this.f.a(localDeleteMessagesParams1.a(), -1L, -1L, 1);
      if ((localFetchMoreMessagesResult.a() == null) || (!localFetchMoreMessagesResult.a().e()))
        break label257;
      this.g.a(new DeleteThreadParams(localDeleteMessagesParams1.a()));
    }
    label257: for (OperationResult localOperationResult3 = OperationResultUtil.a(localOperationResult2, "delete_thread", Boolean.valueOf(true)); ; localOperationResult3 = localOperationResult2)
    {
      return localOperationResult3;
      localOperationResult1 = OperationResult.b();
      break;
    }
  }

  protected OperationResult o(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    paramOperationParams.b();
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    FetchThreadResult localFetchThreadResult = (FetchThreadResult)localOperationResult.h();
    SQLiteDatabase localSQLiteDatabase = this.k.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      this.g.a(localFetchThreadResult);
      this.h.a(localFetchThreadResult.c());
      localSQLiteDatabase.setTransactionSuccessful();
      return localOperationResult;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  protected OperationResult p(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Bundle localBundle = paramOperationParams.b();
    String str = localBundle.getString("threadId");
    MessageDraft localMessageDraft = (MessageDraft)localBundle.getParcelable("draft");
    this.g.a(str, localMessageDraft);
    return OperationResult.b();
  }

  protected OperationResult r(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Message localMessage = (Message)paramOperationParams.b().getParcelable("message");
    FolderName localFolderName = FolderName.b;
    if ((Message.ChannelSource.SMS.equals(localMessage.x())) || (Message.ChannelSource.MMS.equals(localMessage.x())))
      localFolderName = FolderName.d;
    DbThreadPropertyKey localDbThreadPropertyKey = DbProperties.c(localFolderName);
    this.j.b(localDbThreadPropertyKey, true);
    NewMessageResult localNewMessageResult = new NewMessageResult(DataFreshnessResult.FROM_SERVER, localMessage.b(), localMessage, null, System.currentTimeMillis());
    return OperationResult.a(this.g.a(localNewMessageResult));
  }

  protected OperationResult s(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult1 = paramOrcaServiceHandler.a(paramOperationParams);
    a((AppConfig)localOperationResult1.h());
    Bundle localBundle = (Bundle)localOperationResult1.b("gateKeepers");
    if (a(localBundle))
      this.o.g();
    for (OperationResult localOperationResult2 = OperationResultUtil.a(localOperationResult1, "clearSmsCache", Boolean.valueOf(true)); ; localOperationResult2 = localOperationResult1)
    {
      boolean bool = ((Boolean)this.q.b()).booleanValue();
      b(localBundle);
      if (((Boolean)this.q.b()).booleanValue() != bool)
        this.c.a();
      c((Bundle)localOperationResult2.b("rollouts"));
      return localOperationResult2;
    }
  }

  protected OperationResult v(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchMoreMessagesParams localFetchMoreMessagesParams = (FetchMoreMessagesParams)paramOperationParams.b().getParcelable("fetchMoreMessagesParams");
    ThreadCriteria localThreadCriteria = localFetchMoreMessagesParams.a();
    localFetchMoreMessagesParams.b();
    long l1 = localFetchMoreMessagesParams.b();
    long l2 = localFetchMoreMessagesParams.c();
    int i1 = localFetchMoreMessagesParams.d();
    Tracer localTracer = Tracer.a("DbServiceHandler.handleFetchThread");
    while (true)
    {
      FetchMoreMessagesResult localFetchMoreMessagesResult1;
      try
      {
        if (localThreadCriteria.a() == null)
          continue;
        localFetchMoreMessagesResult1 = this.f.a(localThreadCriteria.a(), l1, l2, i1);
        MessagesCollection localMessagesCollection = localFetchMoreMessagesResult1.a();
        if ((localFetchMoreMessagesResult1 != FetchMoreMessagesResult.a) && ((localMessagesCollection.b().size() == i1) || (localMessagesCollection.d())))
        {
          OperationResult localOperationResult2 = OperationResult.a(localFetchMoreMessagesResult1);
          localObject2 = localOperationResult2;
          return localObject2;
          if (localThreadCriteria.b() == null)
            continue;
          localFetchMoreMessagesResult1 = this.f.a(localThreadCriteria.b(), l1, l2, i1);
          continue;
          throw new IllegalArgumentException("No threadid or userkey specified for more messages fetch");
        }
      }
      finally
      {
        localTracer.a();
      }
      OperationResult localOperationResult1 = paramOrcaServiceHandler.a(paramOperationParams);
      FetchMoreMessagesResult localFetchMoreMessagesResult2 = (FetchMoreMessagesResult)localOperationResult1.h();
      this.g.a(localFetchMoreMessagesResult1, localFetchMoreMessagesResult2);
      localTracer.a();
      Object localObject2 = localOperationResult1;
    }
  }

  protected OperationResult w(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    a((AppConfig)localOperationResult.b("appConfig"));
    b((Bundle)localOperationResult.b("gateKeepers"));
    c((Bundle)localOperationResult.b("rollouts"));
    return localOperationResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbServiceHandler
 * JD-Core Version:    0.6.0
 */