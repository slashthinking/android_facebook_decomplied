package com.facebook.orca.cache;

import android.os.Bundle;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.app.OrcaDataManager;
import com.facebook.orca.appconfig.AppConfig;
import com.facebook.orca.compose.MessageDraft;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.notify.OrcaNotificationManager;
import com.facebook.orca.prefs.GlobalNotificationPrefsSynchronizer;
import com.facebook.orca.prefs.ThreadNotificationPrefsSynchronizer;
import com.facebook.orca.server.AbstractOrcaServiceHandlerFilter;
import com.facebook.orca.server.AddMembersParams;
import com.facebook.orca.server.CreateThreadParams;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.DeleteMessagesParams;
import com.facebook.orca.server.DeleteThreadParams;
import com.facebook.orca.server.FetchMoreThreadsResult;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadListParamsBuilder;
import com.facebook.orca.server.FetchThreadListResult;
import com.facebook.orca.server.FetchThreadListResultBuilder;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FetchThreadParamsBuilder;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.MarkThreadParams;
import com.facebook.orca.server.MarkThreadParams.Mark;
import com.facebook.orca.server.NewMessageResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.ReceiptResult;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CacheServiceHandler extends AbstractOrcaServiceHandlerFilter
{
  private static final Class<?> a = CacheServiceHandler.class;
  private final ThreadsCache b;
  private final DataCache c;
  private final ThreadDisplayCache d;
  private final AppConfigCache e;
  private final OrcaActivityBroadcaster f;
  private final OrcaNotificationManager g;
  private final ThreadNotificationPrefsSynchronizer h;
  private final GlobalNotificationPrefsSynchronizer i;
  private final DeliveredReadReceiptManager j;
  private final ChatVisibilityCache k;
  private final SendMessageManager l;
  private final OrcaDataManager m;
  private OperationResult n = null;

  public CacheServiceHandler(ThreadsCache paramThreadsCache, DataCache paramDataCache, ThreadDisplayCache paramThreadDisplayCache, AppConfigCache paramAppConfigCache, OrcaActivityBroadcaster paramOrcaActivityBroadcaster, OrcaNotificationManager paramOrcaNotificationManager, ThreadNotificationPrefsSynchronizer paramThreadNotificationPrefsSynchronizer, GlobalNotificationPrefsSynchronizer paramGlobalNotificationPrefsSynchronizer, DeliveredReadReceiptManager paramDeliveredReadReceiptManager, ChatVisibilityCache paramChatVisibilityCache, OrcaDataManager paramOrcaDataManager, SendMessageManager paramSendMessageManager)
  {
    super("CacheServiceHandler");
    this.b = paramThreadsCache;
    this.c = paramDataCache;
    this.d = paramThreadDisplayCache;
    this.e = paramAppConfigCache;
    this.f = paramOrcaActivityBroadcaster;
    this.g = paramOrcaNotificationManager;
    this.h = paramThreadNotificationPrefsSynchronizer;
    this.i = paramGlobalNotificationPrefsSynchronizer;
    this.j = paramDeliveredReadReceiptManager;
    this.k = paramChatVisibilityCache;
    this.m = paramOrcaDataManager;
    this.l = paramSendMessageManager;
  }

  private void a(FetchMoreThreadsResult paramFetchMoreThreadsResult)
  {
    this.b.a(paramFetchMoreThreadsResult.a(), paramFetchMoreThreadsResult.b(), paramFetchMoreThreadsResult.f());
    ImmutableMap localImmutableMap = paramFetchMoreThreadsResult.d();
    if (localImmutableMap != null)
    {
      Iterator localIterator = localImmutableMap.c().iterator();
      while (localIterator.hasNext())
        a((FetchMoreThreadsResult)localIterator.next());
    }
  }

  private void a(FetchThreadListResult paramFetchThreadListResult)
  {
    FolderName localFolderName = paramFetchThreadListResult.a();
    this.b.a(localFolderName, paramFetchThreadListResult.h());
    this.b.a(localFolderName, paramFetchThreadListResult.b(), paramFetchThreadListResult.f(), false);
    ImmutableMap localImmutableMap = paramFetchThreadListResult.m();
    if (localImmutableMap != null)
    {
      Iterator localIterator = localImmutableMap.c().iterator();
      while (localIterator.hasNext())
        a((FetchThreadListResult)localIterator.next());
    }
  }

  private void a(FolderName paramFolderName, long paramLong)
  {
    FolderCounts localFolderCounts1 = this.b.d(paramFolderName);
    if (localFolderCounts1 != null)
    {
      FolderCounts localFolderCounts2 = new FolderCounts(localFolderCounts1.a(), 0, paramLong, localFolderCounts1.d());
      this.b.a(paramFolderName, localFolderCounts2);
    }
  }

  private void a(String paramString, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (this.b.a(paramString) != null);
    while (true)
    {
      return;
      FetchThreadParams localFetchThreadParams = new FetchThreadParamsBuilder().a(DataFreshnessParam.DO_NOT_CHECK_SERVER).a(ThreadCriteria.a(paramString)).a(50).h();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchThreadParams", localFetchThreadParams);
      e(new OperationParams("fetch_thread", localBundle), paramOrcaServiceHandler);
    }
  }

  protected OperationResult b(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    if (this.n == null)
      this.n = paramOrcaServiceHandler.a(paramOperationParams);
    return this.n;
  }

  protected OperationResult c(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Bundle localBundle = paramOperationParams.b();
    FetchThreadListParams localFetchThreadListParams = (FetchThreadListParams)localBundle.getParcelable("fetchThreadListParams");
    FolderName localFolderName = localFetchThreadListParams.b();
    BLog.a(a, "handleFetchThreadList with freshness=" + localFetchThreadListParams.a().toString());
    DataFreshnessParam localDataFreshnessParam = this.c.a(localFolderName, localFetchThreadListParams.a());
    if (localDataFreshnessParam != localFetchThreadListParams.a())
    {
      localBundle.putParcelable("fetchThreadListParams", FetchThreadListParams.newBuilder().a(localFetchThreadListParams).a(localDataFreshnessParam).f());
      BLog.a(a, "handleFetchThreadList upgraded to " + localDataFreshnessParam);
    }
    boolean bool;
    ThreadsCollection localThreadsCollection;
    DataFreshnessResult localDataFreshnessResult;
    label239: FolderCounts localFolderCounts;
    ImmutableList localImmutableList3;
    switch (CacheServiceHandler.1.a[localDataFreshnessParam.ordinal()])
    {
    default:
      bool = false;
      BLog.a(a, "handleFetchThreadList canServeFromCache=" + bool);
      if (bool)
      {
        localThreadsCollection = this.b.c(localFolderName);
        ImmutableList localImmutableList2 = ImmutableList.a(this.b.d());
        if (!this.b.b(localFolderName))
          break;
        localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
        localFolderCounts = this.b.d(localFolderName);
        localImmutableList3 = ImmutableList.a(localImmutableList2);
      }
    case 1:
    case 2:
    case 3:
    }
    OperationResult localOperationResult;
    for (Object localObject = OperationResult.a(FetchThreadListResult.newBuilder().a(localDataFreshnessResult).a(localFolderName).a(localThreadsCollection).a(localImmutableList3).a(localFolderCounts).o()); ; localObject = localOperationResult)
    {
      return localObject;
      bool = this.b.a(localFolderName);
      break;
      bool = this.b.b(localFolderName);
      break;
      localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_STALE;
      break label239;
      localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      FetchThreadListResult localFetchThreadListResult = (FetchThreadListResult)localOperationResult.h();
      localFetchThreadListResult.b();
      ImmutableList localImmutableList1 = localFetchThreadListResult.c();
      this.b.a(localImmutableList1);
      a(localFetchThreadListResult);
      this.g.a(localFetchThreadListResult.h());
      this.d.a();
      this.h.a();
      if (localFetchThreadListResult.i() == null)
        continue;
      this.i.a(localFetchThreadListResult.i());
    }
  }

  protected OperationResult d(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    FetchMoreThreadsResult localFetchMoreThreadsResult = (FetchMoreThreadsResult)localOperationResult.h();
    this.b.a(localFetchMoreThreadsResult.c());
    a(localFetchMoreThreadsResult);
    this.d.a();
    return localOperationResult;
  }

  protected OperationResult e(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Bundle localBundle = paramOperationParams.b();
    FetchThreadParams localFetchThreadParams1 = (FetchThreadParams)localBundle.getParcelable("fetchThreadParams");
    ThreadCriteria localThreadCriteria = localFetchThreadParams1.a();
    Object localObject1 = localThreadCriteria.a();
    DataFreshnessParam localDataFreshnessParam = this.c.a(localThreadCriteria, localFetchThreadParams1.b());
    FetchThreadParams localFetchThreadParams2;
    if (localDataFreshnessParam != localFetchThreadParams1.b())
    {
      localFetchThreadParams2 = FetchThreadParams.newBuilder().a(localFetchThreadParams1).b(localFetchThreadParams1.b()).a(localDataFreshnessParam).h();
      localBundle.putParcelable("fetchThreadParams", localFetchThreadParams2);
    }
    while (true)
    {
      ThreadSummary localThreadSummary1;
      MessagesCollection localMessagesCollection;
      if (localObject1 != null)
      {
        localThreadSummary1 = this.b.a((String)localObject1);
        localMessagesCollection = this.b.b((String)localObject1);
      }
      while (true)
      {
        boolean bool;
        label155: FetchThreadParams localFetchThreadParams3;
        switch (CacheServiceHandler.1.a[localDataFreshnessParam.ordinal()])
        {
        default:
          bool = false;
          if (this.b.g((String)localObject1) <= this.b.h((String)localObject1))
            break;
          localFetchThreadParams3 = FetchThreadParams.newBuilder().a(localFetchThreadParams2).a(true).a(this.b.g((String)localObject1)).h();
          localBundle.putParcelable("fetchThreadParams", localFetchThreadParams3);
        case 1:
        case 2:
        case 3:
        }
        while (true)
        {
          ImmutableList.Builder localBuilder;
          DataFreshnessResult localDataFreshnessResult;
          if (bool)
          {
            localBuilder = ImmutableList.e();
            Iterator localIterator2 = localThreadSummary1.B().iterator();
            while (true)
              if (localIterator2.hasNext())
              {
                ThreadParticipant localThreadParticipant = (ThreadParticipant)localIterator2.next();
                localBuilder.b(this.b.b(localThreadParticipant.d()));
                continue;
                if (localThreadCriteria.b() != null)
                {
                  localThreadSummary1 = this.b.a(localThreadCriteria.b());
                  if (localThreadSummary1 == null)
                    break label660;
                  String str = localThreadSummary1.a();
                  localMessagesCollection = this.b.b(str);
                  localObject1 = str;
                  break;
                }
                throw new IllegalArgumentException("No threadid, userid, or phonenumber specified for thread fetch");
                if ((localThreadSummary1 != null) && (localMessagesCollection != null))
                {
                  bool = true;
                  break label155;
                }
                bool = false;
                break label155;
                bool = this.b.a((String)localObject1, localFetchThreadParams2.f());
                break label155;
              }
            if (this.b.d((String)localObject1))
              localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
          }
          OperationResult localOperationResult;
          for (Object localObject2 = OperationResult.a(new FetchThreadResult(localDataFreshnessResult, localThreadSummary1, localMessagesCollection, localBuilder.b(), null, -1L)); ; localObject2 = localOperationResult)
          {
            return localObject2;
            localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_STALE;
            break;
            localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
            FetchThreadResult localFetchThreadResult = (FetchThreadResult)localOperationResult.h();
            if (localFetchThreadResult.e() == DataFreshnessResult.NO_DATA)
              continue;
            ThreadSummary localThreadSummary2 = localFetchThreadResult.a();
            if (localFetchThreadResult.c() != null)
              this.b.a(localFetchThreadResult.c());
            this.d.a();
            if (localThreadSummary2 != null)
            {
              this.b.a(localThreadSummary2, localFetchThreadResult.f());
              if (localFetchThreadParams3.f() > 0)
                this.b.a(localFetchThreadResult.b());
              if (localThreadSummary2.g())
              {
                Iterator localIterator1 = localFetchThreadResult.b().b().iterator();
                while (localIterator1.hasNext())
                {
                  Message localMessage = (Message)localIterator1.next();
                  if (Objects.equal(localMessage.f().e(), this.c.b()))
                    continue;
                  this.d.a(localMessage.f().e(), localMessage.c());
                }
              }
              this.f.a((String)localObject1, localThreadSummary2.b());
            }
            this.h.a();
          }
          localFetchThreadParams3 = localFetchThreadParams2;
        }
        label660: localMessagesCollection = null;
      }
      localFetchThreadParams2 = localFetchThreadParams1;
    }
  }

  protected OperationResult f(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    ((CreateThreadParams)paramOperationParams.b().getParcelable("createThreadParams"));
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    FetchThreadResult localFetchThreadResult = (FetchThreadResult)localOperationResult.h();
    this.b.a(localFetchThreadResult.c());
    this.d.a();
    ThreadSummary localThreadSummary = localFetchThreadResult.a();
    this.b.a(localThreadSummary, localFetchThreadResult.f());
    this.b.b(localFetchThreadResult.b());
    return localOperationResult;
  }

  protected OperationResult g(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    Message localMessage = (Message)paramOperationParams.b().getParcelable("outgoingMessage");
    this.b.a(localMessage, null);
    ThreadSummary localThreadSummary = this.b.a(localMessage.b());
    if (localThreadSummary != null)
      this.b.a(localThreadSummary, null);
    return localOperationResult;
  }

  protected OperationResult h(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    ((AddMembersParams)paramOperationParams.b().getParcelable("addMembersParams"));
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    FetchThreadResult localFetchThreadResult = (FetchThreadResult)localOperationResult.h();
    ThreadSummary localThreadSummary = localFetchThreadResult.a();
    if (localThreadSummary != null)
    {
      this.b.a(localThreadSummary, localFetchThreadResult.f());
      this.b.a(localFetchThreadResult.c());
      this.d.a();
    }
    return localOperationResult;
  }

  protected OperationResult i(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    FetchThreadResult localFetchThreadResult = (FetchThreadResult)localOperationResult.h();
    this.b.a(localFetchThreadResult.a(), localFetchThreadResult.f());
    this.b.a(localFetchThreadResult.c());
    this.d.a();
    return localOperationResult;
  }

  protected OperationResult j(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    MarkThreadParams localMarkThreadParams = (MarkThreadParams)paramOperationParams.b().getParcelable("markThreadParams");
    String str = localMarkThreadParams.a();
    MarkThreadParams.Mark localMark = localMarkThreadParams.b();
    if ((localMark == MarkThreadParams.Mark.READ) && (localMarkThreadParams.c()))
      this.b.a(str, localMarkThreadParams.d());
    while (true)
    {
      return paramOrcaServiceHandler.a(paramOperationParams);
      if ((localMark == MarkThreadParams.Mark.ARCHIVED) && (localMarkThreadParams.c()))
      {
        this.b.c(str);
        this.f.d(str);
        continue;
      }
      if ((localMark != MarkThreadParams.Mark.SPAM) || (!localMarkThreadParams.c()))
        continue;
      this.b.c(str);
      this.f.d(str);
    }
  }

  protected OperationResult k(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    ReceiptResult localReceiptResult = (ReceiptResult)localOperationResult.h();
    ThreadSummary localThreadSummary = localReceiptResult.a();
    if (localThreadSummary != null)
    {
      this.b.a(localThreadSummary, localReceiptResult.f());
      this.f.b(localThreadSummary.a());
    }
    return localOperationResult;
  }

  protected OperationResult l(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    ReceiptResult localReceiptResult = (ReceiptResult)localOperationResult.h();
    ThreadSummary localThreadSummary = localReceiptResult.a();
    if (localThreadSummary != null)
    {
      this.b.a(localThreadSummary, localReceiptResult.f());
      this.f.b(localThreadSummary.a());
    }
    return localOperationResult;
  }

  protected OperationResult m(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    DeleteThreadParams localDeleteThreadParams = (DeleteThreadParams)paramOperationParams.b().getParcelable("deleteThreadParams");
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    String str = localDeleteThreadParams.a();
    this.b.c(str);
    this.f.d(str);
    return localOperationResult;
  }

  protected OperationResult n(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    DeleteMessagesParams localDeleteMessagesParams = (DeleteMessagesParams)paramOperationParams.b().getParcelable("deleteMessagesParams");
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    String str1 = localDeleteMessagesParams.a();
    ImmutableSet localImmutableSet = localDeleteMessagesParams.b();
    this.b.a(str1, localImmutableSet);
    Bundle localBundle = localOperationResult.j();
    if ((localBundle != null) && (localBundle.containsKey("message_offline_threading_ids")))
    {
      Iterator localIterator = ((HashMap)localBundle.getSerializable("message_offline_threading_ids")).values().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        this.l.a(str1, str2);
      }
    }
    if ((localBundle != null) && (localBundle.containsKey("delete_thread")) && (localBundle.getBoolean("delete_thread")))
    {
      this.b.c(str1);
      this.f.d(str1);
    }
    while (true)
    {
      return localOperationResult;
      this.f.b(str1);
      this.f.a(str1, localImmutableSet);
    }
  }

  protected OperationResult o(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    FetchThreadResult localFetchThreadResult = (FetchThreadResult)localOperationResult.h();
    this.b.a(localFetchThreadResult.a(), localFetchThreadResult.f());
    this.b.a(localFetchThreadResult.c());
    this.d.a();
    return localOperationResult;
  }

  protected OperationResult p(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    Bundle localBundle = paramOperationParams.b();
    String str = localBundle.getString("threadId");
    MessageDraft localMessageDraft = (MessageDraft)localBundle.getParcelable("draft");
    ThreadSummary localThreadSummary = this.b.a(str);
    if (localThreadSummary != null)
      this.b.a(localThreadSummary, localMessageDraft);
    return localOperationResult;
  }

  protected OperationResult q(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FolderName localFolderName = (FolderName)paramOperationParams.b().getParcelable("folderName");
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    long l1 = System.currentTimeMillis();
    a(localFolderName, l1);
    if (localFolderName == FolderName.e)
    {
      a(FolderName.b, l1);
      a(FolderName.d, l1);
    }
    return localOperationResult;
  }

  protected OperationResult r(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.b().getString("threadId");
    a(str, paramOrcaServiceHandler);
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    NewMessageResult localNewMessageResult = (NewMessageResult)localOperationResult.h();
    if (localNewMessageResult != null)
    {
      this.b.a(localNewMessageResult.b(), localNewMessageResult.c());
      Message localMessage = localNewMessageResult.b();
      this.d.a(localMessage);
      if (!Objects.equal(localMessage.f().e(), this.c.b()))
        this.d.a(localMessage.f().e(), localMessage.c());
      this.f.b(str);
      ThreadSummary localThreadSummary = this.b.a(str);
      if ((localThreadSummary != null) && (localThreadSummary.g()) && (localMessage.f().b()) && (!localMessage.f().e().equals(this.c.b())))
        this.j.a(localMessage);
    }
    return localOperationResult;
  }

  protected OperationResult s(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    AppConfig localAppConfig = (AppConfig)localOperationResult.h();
    if (localOperationResult.g().getBoolean("clearSmsCache", false))
      this.m.f();
    this.e.a(localAppConfig);
    return localOperationResult;
  }

  protected OperationResult t(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult;
    if (this.k.a())
      localOperationResult = OperationResult.a(Boolean.toString(this.k.b()));
    while (true)
    {
      return localOperationResult;
      localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      if (!localOperationResult.c())
        continue;
      this.k.a(Boolean.parseBoolean(localOperationResult.f()));
    }
  }

  protected OperationResult u(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    if (localOperationResult.c())
      this.k.a(Boolean.parseBoolean(localOperationResult.f()));
    return localOperationResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.CacheServiceHandler
 * JD-Core Version:    0.6.0
 */