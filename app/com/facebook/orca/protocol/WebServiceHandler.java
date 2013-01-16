package com.facebook.orca.protocol;

import android.os.Bundle;
import android.util.Pair;
import com.facebook.analytics.HoneyAnalyticsUploadHandler;
import com.facebook.base.GatekeeperSetProvider;
import com.facebook.orca.appconfig.AppConfig;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.media.MediaResource.Type;
import com.facebook.orca.protocol.base.BatchOperation;
import com.facebook.orca.protocol.base.BatchOperation.Builder;
import com.facebook.orca.protocol.base.BatchRunner;
import com.facebook.orca.protocol.base.SimulatedBatchRunner;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.AddMembersMethod;
import com.facebook.orca.protocol.methods.ChatGetVisibilityMethod;
import com.facebook.orca.protocol.methods.ChatSetVisibilityMethod;
import com.facebook.orca.protocol.methods.ConfirmPhoneAndRegisterPartialAccountMethod;
import com.facebook.orca.protocol.methods.ConfirmPhoneMethod;
import com.facebook.orca.protocol.methods.CreateThreadMethod;
import com.facebook.orca.protocol.methods.CreateThreadMethod.Params;
import com.facebook.orca.protocol.methods.DeleteMessagesMethod;
import com.facebook.orca.protocol.methods.DeleteThreadMethod;
import com.facebook.orca.protocol.methods.FetchAppConfigMethod;
import com.facebook.orca.protocol.methods.FetchGatekeepersMethod;
import com.facebook.orca.protocol.methods.FetchMessageMethod;
import com.facebook.orca.protocol.methods.FetchMoreMessagesMethod;
import com.facebook.orca.protocol.methods.FetchMoreThreadsMethod;
import com.facebook.orca.protocol.methods.FetchRolloutsMethod;
import com.facebook.orca.protocol.methods.FetchThreadListMethod;
import com.facebook.orca.protocol.methods.FetchThreadMethod;
import com.facebook.orca.protocol.methods.GetMeUserMethod;
import com.facebook.orca.protocol.methods.GraphUserPostMethod;
import com.facebook.orca.protocol.methods.LookupUserMethod;
import com.facebook.orca.protocol.methods.MarkFolderSeenMethod;
import com.facebook.orca.protocol.methods.MarkThreadMethod;
import com.facebook.orca.protocol.methods.PushTraceInfoConfirmationMethod;
import com.facebook.orca.protocol.methods.RemoveMemberMethod;
import com.facebook.orca.protocol.methods.RequestSmsConfirmationCodeMethod;
import com.facebook.orca.protocol.methods.SendMessageMethod;
import com.facebook.orca.protocol.methods.SendMessageMethod.Params;
import com.facebook.orca.protocol.methods.SendViaChatHandler;
import com.facebook.orca.protocol.methods.SetThreadImageMethod;
import com.facebook.orca.protocol.methods.SetThreadMuteUntilMethod;
import com.facebook.orca.protocol.methods.SetThreadNameMethod;
import com.facebook.orca.protocol.methods.SetUserSettingsMethod;
import com.facebook.orca.protocol.methods.UploadShareMethod;
import com.facebook.orca.protocol.methods.UserValidateRegistrationDataMethod;
import com.facebook.orca.rollout.OrcaRolloutManager;
import com.facebook.orca.server.AbstractOrcaServiceHandlerFilter;
import com.facebook.orca.server.AddMembersParams;
import com.facebook.orca.server.ConfirmPhoneAndRegisterPartialAccountParams;
import com.facebook.orca.server.ConfirmPhoneAndRegisterPartialAccountResult;
import com.facebook.orca.server.ConfirmPhoneParams;
import com.facebook.orca.server.CreateThreadParams;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.DeleteMessagesParams;
import com.facebook.orca.server.DeleteThreadParams;
import com.facebook.orca.server.FetchGatekeepersParams;
import com.facebook.orca.server.FetchGatekeepersParams.Session;
import com.facebook.orca.server.FetchMessageResult;
import com.facebook.orca.server.FetchMoreMessagesParams;
import com.facebook.orca.server.FetchMoreMessagesResult;
import com.facebook.orca.server.FetchMoreThreadsParams;
import com.facebook.orca.server.FetchMoreThreadsResult;
import com.facebook.orca.server.FetchMultipleThreadsParams;
import com.facebook.orca.server.FetchMultipleThreadsResult;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadListResult;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FetchThreadParamsBuilder;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.GetMeUserResult;
import com.facebook.orca.server.MarkThreadParams;
import com.facebook.orca.server.MarkThreadParams.Mark;
import com.facebook.orca.server.ModifyThreadParams;
import com.facebook.orca.server.NewMessageResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.RemoveMemberParams;
import com.facebook.orca.server.RequestSmsConfirmationCodeParams;
import com.facebook.orca.server.SetSettingsParams;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.server.UserValidateRegistrationDataParams;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.facebook.zero.ZeroTokenManager;
import com.facebook.zero.protocol.methods.FetchZeroTokenMethod;
import com.facebook.zero.protocol.methods.FetchZeroTokenResult;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;
import javax.inject.Provider;

public class WebServiceHandler extends AbstractOrcaServiceHandlerFilter
  implements OrcaServiceHandler
{
  private static final Class<?> a = WebServiceHandler.class;
  private final MarkFolderSeenMethod A;
  private final RequestSmsConfirmationCodeMethod B;
  private final ConfirmPhoneMethod C;
  private final SetThreadMuteUntilMethod D;
  private final FetchAppConfigMethod E;
  private final SendViaChatHandler F;
  private final SetUserSettingsMethod G;
  private final FetchGatekeepersMethod H;
  private final HoneyAnalyticsUploadHandler I;
  private final ChatSetVisibilityMethod J;
  private final ChatGetVisibilityMethod K;
  private final PushTraceInfoConfirmationMethod L;
  private final FetchRolloutsMethod M;
  private final OrcaRolloutManager N;
  private final ZeroTokenManager O;
  private final FetchZeroTokenMethod P;
  private final Provider<BatchRunner> b;
  private final Provider<SingleMethodRunner> c;
  private final Provider<SimulatedBatchRunner> d;
  private final MeUserAuthDataStore e;
  private final GatekeeperSetProvider f;
  private final UserValidateRegistrationDataMethod g;
  private final ConfirmPhoneAndRegisterPartialAccountMethod h;
  private final GraphUserPostMethod i;
  private final LookupUserMethod j;
  private final FetchThreadListMethod k;
  private final FetchMoreThreadsMethod l;
  private final FetchMessageMethod m;
  private final FetchThreadMethod n;
  private final GetMeUserMethod o;
  private final SendMessageMethod p;
  private final FetchMoreMessagesMethod q;
  private final AddMembersMethod r;
  private final CreateThreadMethod s;
  private final UploadShareMethod t;
  private final RemoveMemberMethod u;
  private final MarkThreadMethod v;
  private final DeleteThreadMethod w;
  private final DeleteMessagesMethod x;
  private final SetThreadNameMethod y;
  private final SetThreadImageMethod z;

  public WebServiceHandler(Provider<SingleMethodRunner> paramProvider, Provider<BatchRunner> paramProvider1, Provider<SimulatedBatchRunner> paramProvider2, MeUserAuthDataStore paramMeUserAuthDataStore, GatekeeperSetProvider paramGatekeeperSetProvider, UserValidateRegistrationDataMethod paramUserValidateRegistrationDataMethod, ConfirmPhoneAndRegisterPartialAccountMethod paramConfirmPhoneAndRegisterPartialAccountMethod, GraphUserPostMethod paramGraphUserPostMethod, LookupUserMethod paramLookupUserMethod, FetchThreadListMethod paramFetchThreadListMethod, FetchMoreThreadsMethod paramFetchMoreThreadsMethod, FetchThreadMethod paramFetchThreadMethod, GetMeUserMethod paramGetMeUserMethod, SendMessageMethod paramSendMessageMethod, FetchMoreMessagesMethod paramFetchMoreMessagesMethod, FetchMessageMethod paramFetchMessageMethod, AddMembersMethod paramAddMembersMethod, CreateThreadMethod paramCreateThreadMethod, UploadShareMethod paramUploadShareMethod, RemoveMemberMethod paramRemoveMemberMethod, MarkThreadMethod paramMarkThreadMethod, DeleteThreadMethod paramDeleteThreadMethod, DeleteMessagesMethod paramDeleteMessagesMethod, SetThreadNameMethod paramSetThreadNameMethod, SetThreadImageMethod paramSetThreadImageMethod, MarkFolderSeenMethod paramMarkFolderSeenMethod, RequestSmsConfirmationCodeMethod paramRequestSmsConfirmationCodeMethod, ConfirmPhoneMethod paramConfirmPhoneMethod, SetThreadMuteUntilMethod paramSetThreadMuteUntilMethod, FetchAppConfigMethod paramFetchAppConfigMethod, SendViaChatHandler paramSendViaChatHandler, SetUserSettingsMethod paramSetUserSettingsMethod, FetchGatekeepersMethod paramFetchGatekeepersMethod, FetchRolloutsMethod paramFetchRolloutsMethod, HoneyAnalyticsUploadHandler paramHoneyAnalyticsUploadHandler, ChatSetVisibilityMethod paramChatSetVisibilityMethod, ChatGetVisibilityMethod paramChatGetVisibilityMethod, PushTraceInfoConfirmationMethod paramPushTraceInfoConfirmationMethod, OrcaRolloutManager paramOrcaRolloutManager, ZeroTokenManager paramZeroTokenManager, FetchZeroTokenMethod paramFetchZeroTokenMethod)
  {
    super("WebServiceHandler");
    this.c = paramProvider;
    this.b = paramProvider1;
    this.d = paramProvider2;
    this.e = paramMeUserAuthDataStore;
    this.f = paramGatekeeperSetProvider;
    this.g = paramUserValidateRegistrationDataMethod;
    this.h = paramConfirmPhoneAndRegisterPartialAccountMethod;
    this.i = paramGraphUserPostMethod;
    this.j = paramLookupUserMethod;
    this.k = paramFetchThreadListMethod;
    this.l = paramFetchMoreThreadsMethod;
    this.m = paramFetchMessageMethod;
    this.n = paramFetchThreadMethod;
    this.o = paramGetMeUserMethod;
    this.p = paramSendMessageMethod;
    this.q = paramFetchMoreMessagesMethod;
    this.r = paramAddMembersMethod;
    this.s = paramCreateThreadMethod;
    this.t = paramUploadShareMethod;
    this.u = paramRemoveMemberMethod;
    this.v = paramMarkThreadMethod;
    this.w = paramDeleteThreadMethod;
    this.x = paramDeleteMessagesMethod;
    this.y = paramSetThreadNameMethod;
    this.z = paramSetThreadImageMethod;
    this.A = paramMarkFolderSeenMethod;
    this.B = paramRequestSmsConfirmationCodeMethod;
    this.C = paramConfirmPhoneMethod;
    this.D = paramSetThreadMuteUntilMethod;
    this.E = paramFetchAppConfigMethod;
    this.F = paramSendViaChatHandler;
    this.G = paramSetUserSettingsMethod;
    this.H = paramFetchGatekeepersMethod;
    this.M = paramFetchRolloutsMethod;
    this.I = paramHoneyAnalyticsUploadHandler;
    this.J = paramChatSetVisibilityMethod;
    this.K = paramChatGetVisibilityMethod;
    this.L = paramPushTraceInfoConfirmationMethod;
    this.N = paramOrcaRolloutManager;
    this.O = paramZeroTokenManager;
    this.P = paramFetchZeroTokenMethod;
  }

  private NewMessageResult a(Message paramMessage)
  {
    BatchRunner localBatchRunner = (BatchRunner)this.b.b();
    if (paramMessage.z())
    {
      MediaResource localMediaResource = (MediaResource)paramMessage.y().get(0);
      if (localMediaResource.b() == MediaResource.Type.VIDEO)
        localBatchRunner.a(BatchOperation.a(this.t, localMediaResource).a("attachment-upload").a());
    }
    for (String str = "{result=attachment-upload:$.id}"; ; str = null)
    {
      SendMessageMethod.Params localParams = new SendMessageMethod.Params(paramMessage, str);
      localBatchRunner.a(BatchOperation.a(this.p, localParams).a("send").a());
      localBatchRunner.a(BatchOperation.a(this.m, "{result=send:$.id}").a("fetch_sent").b("send").a());
      FetchMoreMessagesParams localFetchMoreMessagesParams = new FetchMoreMessagesParams(ThreadCriteria.a(paramMessage.b()), 0L, -1L, 2);
      localBatchRunner.a(BatchOperation.a(this.q, localFetchMoreMessagesParams).a("fetch").b("send").a());
      localBatchRunner.b("sendMessage");
      ((String)localBatchRunner.a("send"));
      FetchMessageResult localFetchMessageResult = (FetchMessageResult)localBatchRunner.a("fetch_sent");
      FetchMoreMessagesResult localFetchMoreMessagesResult = (FetchMoreMessagesResult)localBatchRunner.a("fetch");
      Message localMessage = localFetchMessageResult.a();
      MessagesCollection localMessagesCollection = localFetchMoreMessagesResult.a();
      Iterator localIterator = localMessagesCollection.b().iterator();
      do
        if (!localIterator.hasNext())
          break;
      while (!Objects.equal(((Message)localIterator.next()).a(), localMessage.a()));
      for (int i1 = 1; ; i1 = 0)
      {
        if (i1 == 0)
          localMessagesCollection = null;
        return new NewMessageResult(DataFreshnessResult.FROM_SERVER, localMessage.b(), localMessage, localMessagesCollection, System.currentTimeMillis());
      }
    }
  }

  protected OperationResult A(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchMultipleThreadsParams localFetchMultipleThreadsParams = (FetchMultipleThreadsParams)paramOperationParams.b().getParcelable("fetchMultipleThreadsParams");
    BatchRunner localBatchRunner = (BatchRunner)this.b.b();
    ImmutableList localImmutableList = localFetchMultipleThreadsParams.b();
    Iterator localIterator = localImmutableList.iterator();
    while (localIterator.hasNext())
    {
      FetchThreadParams localFetchThreadParams = (FetchThreadParams)localIterator.next();
      localBatchRunner.a(BatchOperation.a(this.n, localFetchThreadParams).a());
    }
    localBatchRunner.b("fetchMultipleThreads");
    ImmutableList.Builder localBuilder = ImmutableList.e();
    for (int i1 = 0; i1 < localImmutableList.size(); i1++)
      localBuilder.b((FetchThreadResult)localBatchRunner.a(i1));
    return OperationResult.a(new FetchMultipleThreadsResult(localBuilder.b()));
  }

  protected OperationResult B(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    RequestSmsConfirmationCodeParams localRequestSmsConfirmationCodeParams = (RequestSmsConfirmationCodeParams)paramOperationParams.b().getParcelable("requestSmsConfirmationCodeParams");
    ((SingleMethodRunner)this.c.b()).a(this.B, localRequestSmsConfirmationCodeParams);
    return OperationResult.b();
  }

  protected OperationResult C(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    ConfirmPhoneParams localConfirmPhoneParams = (ConfirmPhoneParams)paramOperationParams.b().getParcelable("confirmPhoneParams");
    BatchRunner localBatchRunner = (BatchRunner)this.d.b();
    localBatchRunner.a(BatchOperation.a(this.C, localConfirmPhoneParams).a("confirm-phone").a());
    localBatchRunner.a(BatchOperation.a(this.o, null).a("get-me-user").b("confirm-phone").a());
    localBatchRunner.b("confirmPhone");
    GetMeUserResult localGetMeUserResult = (GetMeUserResult)localBatchRunner.a(1);
    this.e.a(localGetMeUserResult.a());
    return OperationResult.b();
  }

  protected OperationResult D(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    SingleMethodRunner localSingleMethodRunner = (SingleMethodRunner)this.c.b();
    SetSettingsParams localSetSettingsParams = (SetSettingsParams)paramOperationParams.b().getParcelable("setSettingsParams");
    localSingleMethodRunner.a(this.G, localSetSettingsParams);
    return OperationResult.b();
  }

  protected OperationResult E(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    paramOperationParams.a();
    this.I.a();
    return OperationResult.b();
  }

  protected OperationResult F(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.b().getString("traceInfo");
    ((SingleMethodRunner)this.c.b()).a(this.L, str);
    return OperationResult.b();
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    Tracer localTracer = Tracer.a("WebServiceHandler");
    try
    {
      String str = paramOperationParams.a();
      if ("send".equals(str))
      {
        OperationResult localOperationResult = b(paramOperationParams);
        return localOperationResult;
      }
      throw new IllegalArgumentException("Unknown operation type: " + str);
    }
    finally
    {
      localTracer.a(10L);
    }
    throw localObject;
  }

  protected OperationResult b(OperationParams paramOperationParams)
  {
    Bundle localBundle = paramOperationParams.b();
    Message localMessage = (Message)localBundle.getParcelable("outgoingMessage");
    UserKey localUserKey = UserKey.a(localBundle.getString("userKeyInCanonicalThread"));
    if (this.F.a(localMessage));
    while (true)
    {
      try
      {
        OperationResult localOperationResult2 = OperationResult.a(this.F.a(localMessage, localUserKey));
        localOperationResult1 = localOperationResult2;
        return localOperationResult1;
      }
      catch (Exception localException)
      {
        BLog.c(a, localException.getMessage());
      }
      OperationResult localOperationResult1 = OperationResult.a(a(localMessage));
    }
  }

  protected OperationResult b(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchGatekeepersParams localFetchGatekeepersParams = new FetchGatekeepersParams(this.f, FetchGatekeepersParams.Session.IS_SESSIONLESS);
    return OperationResult.a((Bundle)((SingleMethodRunner)this.c.b()).a(this.H, localFetchGatekeepersParams));
  }

  protected OperationResult c(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchThreadListParams localFetchThreadListParams = (FetchThreadListParams)paramOperationParams.b().getParcelable("fetchThreadListParams");
    return OperationResult.a((FetchThreadListResult)((SingleMethodRunner)this.c.b()).a(this.k, localFetchThreadListParams));
  }

  protected OperationResult d(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchMoreThreadsParams localFetchMoreThreadsParams = (FetchMoreThreadsParams)paramOperationParams.b().getParcelable("fetchMoreThreadsParams");
    return OperationResult.a((FetchMoreThreadsResult)((SingleMethodRunner)this.c.b()).a(this.l, localFetchMoreThreadsParams));
  }

  protected OperationResult e(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchThreadParams localFetchThreadParams = (FetchThreadParams)paramOperationParams.b().getParcelable("fetchThreadParams");
    BatchRunner localBatchRunner = (BatchRunner)this.b.b();
    if (localFetchThreadParams.d())
    {
      MarkThreadParams localMarkThreadParams = new MarkThreadParams(localFetchThreadParams.a().a(), MarkThreadParams.Mark.READ, true, localFetchThreadParams.e());
      localBatchRunner.a(BatchOperation.a(this.v, localMarkThreadParams).a("update-last-read").a());
    }
    BatchOperation.Builder localBuilder = BatchOperation.a(this.n, localFetchThreadParams).a("fetch-thread");
    if (localFetchThreadParams.d());
    for (String str = "update-last-read"; ; str = null)
    {
      localBatchRunner.a(localBuilder.b(str).a());
      localBatchRunner.b("fetchThread");
      return OperationResult.a((FetchThreadResult)localBatchRunner.a("fetch-thread"));
    }
  }

  protected OperationResult f(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    CreateThreadParams localCreateThreadParams = (CreateThreadParams)paramOperationParams.b().getParcelable("createThreadParams");
    Message localMessage = localCreateThreadParams.a();
    BatchRunner localBatchRunner = (BatchRunner)this.b.b();
    if (localMessage.z())
    {
      MediaResource localMediaResource = (MediaResource)localMessage.y().get(0);
      if (localMediaResource.b() == MediaResource.Type.VIDEO)
        localBatchRunner.a(BatchOperation.a(this.t, localMediaResource).a("attachment-upload").a());
    }
    for (String str = "{result=attachment-upload:$.id}"; ; str = null)
    {
      CreateThreadMethod.Params localParams = new CreateThreadMethod.Params(localCreateThreadParams, str);
      localBatchRunner.a(BatchOperation.a(this.s, localParams).a("create-thread").a());
      FetchThreadParams localFetchThreadParams = new FetchThreadParamsBuilder().a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).a(ThreadCriteria.a("{result=create-thread:$.tid}")).a(3).h();
      localBatchRunner.a(BatchOperation.a(this.n, localFetchThreadParams).a("fetch-thread").b("create-thread").a());
      localBatchRunner.b("createThread");
      return OperationResult.a((FetchThreadResult)localBatchRunner.a("fetch-thread"));
    }
  }

  protected OperationResult h(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    AddMembersParams localAddMembersParams = (AddMembersParams)paramOperationParams.b().getParcelable("addMembersParams");
    BatchRunner localBatchRunner = (BatchRunner)this.b.b();
    localBatchRunner.a(BatchOperation.a(this.r, localAddMembersParams).a("add-members").a());
    FetchThreadParams localFetchThreadParams = new FetchThreadParamsBuilder().a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).a(ThreadCriteria.a(localAddMembersParams.a())).a(2).h();
    localBatchRunner.a(BatchOperation.a(this.n, localFetchThreadParams).a("fetch").b("add-members").a());
    localBatchRunner.b("addMembers");
    return OperationResult.a((FetchThreadResult)localBatchRunner.a(1));
  }

  protected OperationResult i(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    RemoveMemberParams localRemoveMemberParams = (RemoveMemberParams)paramOperationParams.b().getParcelable("removeMemberParams");
    BatchRunner localBatchRunner = (BatchRunner)this.b.b();
    localBatchRunner.a(BatchOperation.a(this.u, localRemoveMemberParams).a("remove-members").a());
    FetchThreadParams localFetchThreadParams = new FetchThreadParamsBuilder().a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).a(ThreadCriteria.a(localRemoveMemberParams.a())).a(2).h();
    localBatchRunner.a(BatchOperation.a(this.n, localFetchThreadParams).a("fetch").b("remove-members").a());
    localBatchRunner.b("removeMember");
    return OperationResult.a((FetchThreadResult)localBatchRunner.a(1));
  }

  protected OperationResult j(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    MarkThreadParams localMarkThreadParams = (MarkThreadParams)paramOperationParams.b().getParcelable("markThreadParams");
    ((SingleMethodRunner)this.c.b()).a(this.v, localMarkThreadParams);
    return OperationResult.b();
  }

  protected OperationResult m(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    DeleteThreadParams localDeleteThreadParams = (DeleteThreadParams)paramOperationParams.b().getParcelable("deleteThreadParams");
    ((SingleMethodRunner)this.c.b()).a(this.w, localDeleteThreadParams);
    return OperationResult.b();
  }

  protected OperationResult n(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    DeleteMessagesParams localDeleteMessagesParams = (DeleteMessagesParams)paramOperationParams.b().getParcelable("deleteMessagesParams");
    ((SingleMethodRunner)this.c.b()).a(this.x, localDeleteMessagesParams);
    return OperationResult.b();
  }

  protected OperationResult o(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    ModifyThreadParams localModifyThreadParams = (ModifyThreadParams)paramOperationParams.b().getParcelable("modifyThreadParams");
    BatchRunner localBatchRunner = (BatchRunner)this.d.b();
    boolean bool = localModifyThreadParams.b();
    String str = null;
    if (bool)
    {
      localBatchRunner.a(BatchOperation.a(this.y, localModifyThreadParams).a("setThreadName").a());
      str = "setThreadName";
    }
    if (localModifyThreadParams.d())
    {
      localBatchRunner.a(BatchOperation.a(this.z, localModifyThreadParams).a("setThreadImage").b(str).a());
      str = "setThreadImage";
    }
    if (localModifyThreadParams.f())
    {
      localBatchRunner.a(BatchOperation.a(this.D, localModifyThreadParams).a("muteThread").b(str).a());
      str = "muteThread";
    }
    FetchThreadParams localFetchThreadParams = new FetchThreadParamsBuilder().a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).a(ThreadCriteria.a(localModifyThreadParams.a())).a(2).h();
    localBatchRunner.a(BatchOperation.a(this.n, localFetchThreadParams).a("fetch").b(str).a());
    localBatchRunner.b("modifyThread");
    return OperationResult.a((FetchThreadResult)localBatchRunner.a(1));
  }

  protected OperationResult q(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    ((SingleMethodRunner)this.c.b()).a(this.A, null);
    return OperationResult.b();
  }

  protected OperationResult s(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    BatchRunner localBatchRunner = (BatchRunner)this.b.b();
    localBatchRunner.a(BatchOperation.a(this.E, null).a("appConfig").a());
    localBatchRunner.a(BatchOperation.a(this.H, null).a("gk").a());
    if (this.N.c())
      localBatchRunner.a(BatchOperation.a(this.M, null).a("rollouts").a());
    localBatchRunner.b("handleGetAppInfo");
    AppConfig localAppConfig = (AppConfig)localBatchRunner.a("appConfig");
    Bundle localBundle1 = (Bundle)localBatchRunner.a("gk");
    Bundle localBundle2 = (Bundle)localBatchRunner.a("rollouts");
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = Pair.create("gateKeepers", localBundle1);
    arrayOfPair[1] = Pair.create("rollouts", localBundle2);
    return OperationResult.a(localAppConfig, arrayOfPair);
  }

  protected OperationResult t(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    paramOperationParams.b();
    return OperationResult.a(Boolean.toString(((Boolean)((SingleMethodRunner)this.c.b()).a(this.K, null)).booleanValue()));
  }

  protected OperationResult u(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Boolean localBoolean = Boolean.valueOf(paramOperationParams.b().getBoolean("chatSetVisibilityParams"));
    ((Boolean)((SingleMethodRunner)this.c.b()).a(this.J, localBoolean));
    return OperationResult.a(Boolean.toString(localBoolean.booleanValue()));
  }

  protected OperationResult v(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchMoreMessagesParams localFetchMoreMessagesParams = (FetchMoreMessagesParams)paramOperationParams.b().getParcelable("fetchMoreMessagesParams");
    return OperationResult.a((FetchMoreMessagesResult)((SingleMethodRunner)this.c.b()).a(this.q, localFetchMoreMessagesParams));
  }

  protected OperationResult w(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    BatchRunner localBatchRunner = (BatchRunner)this.b.b();
    localBatchRunner.a(BatchOperation.a(this.o, null).a("user").a());
    localBatchRunner.a(BatchOperation.a(this.E, null).a("appConfig").a());
    localBatchRunner.a(BatchOperation.a(this.H, null).a("gk").a());
    if (this.N.c())
      localBatchRunner.a(BatchOperation.a(this.M, null).a("rollouts").a());
    localBatchRunner.b("handleLogin");
    GetMeUserResult localGetMeUserResult = (GetMeUserResult)localBatchRunner.a("user");
    this.e.a(localGetMeUserResult.a());
    AppConfig localAppConfig = (AppConfig)localBatchRunner.a("appConfig");
    Bundle localBundle1 = (Bundle)localBatchRunner.a("gk");
    Bundle localBundle2 = (Bundle)localBatchRunner.a("rollouts");
    if ((localBundle1 != null) && (localBundle1.getBoolean("messenger_zero_rating", false)))
      this.O.a((FetchZeroTokenResult)((SingleMethodRunner)this.c.b()).a(this.P, this.O.c()));
    Pair[] arrayOfPair = new Pair[3];
    arrayOfPair[0] = Pair.create("appConfig", localAppConfig);
    arrayOfPair[1] = Pair.create("gateKeepers", localBundle1);
    arrayOfPair[2] = Pair.create("rollouts", localBundle2);
    return OperationResult.a(localGetMeUserResult, arrayOfPair);
  }

  protected OperationResult x(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Bundle localBundle = paramOperationParams.b();
    UserValidateRegistrationDataParams localUserValidateRegistrationDataParams = new UserValidateRegistrationDataParams(localBundle.getString("firstName"), localBundle.getString("lastName"), localBundle.getString("email"), localBundle.getString("phone"), localBundle.getString("countryCode"), localBundle.getString("password"), localBundle.getString("gender"), localBundle.getString("birthday"));
    ((SingleMethodRunner)this.c.b()).a(this.g, localUserValidateRegistrationDataParams);
    return OperationResult.b();
  }

  protected OperationResult y(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Bundle localBundle = paramOperationParams.b();
    ConfirmPhoneAndRegisterPartialAccountParams localConfirmPhoneAndRegisterPartialAccountParams = new ConfirmPhoneAndRegisterPartialAccountParams(localBundle.getString("phone"), localBundle.getString("countryCode"), localBundle.getString("confirmationCode"), localBundle.getString("fullName"), localBundle.getString("firstName"), localBundle.getString("lastName"));
    return OperationResult.a((ConfirmPhoneAndRegisterPartialAccountResult)((SingleMethodRunner)this.c.b()).a(this.h, localConfirmPhoneAndRegisterPartialAccountParams));
  }

  protected OperationResult z(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Bundle localBundle = paramOperationParams.b();
    return OperationResult.a((User)((SingleMethodRunner)this.c.b()).a(this.j, localBundle.getString("uid")));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.WebServiceHandler
 * JD-Core Version:    0.6.0
 */