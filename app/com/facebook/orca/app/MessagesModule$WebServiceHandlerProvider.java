package com.facebook.orca.app;

import com.facebook.analytics.HoneyAnalyticsUploadHandler;
import com.facebook.base.GatekeeperSetProvider;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.WebServiceHandler;
import com.facebook.orca.protocol.base.BatchRunner;
import com.facebook.orca.protocol.base.SimulatedBatchRunner;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.AddMembersMethod;
import com.facebook.orca.protocol.methods.ChatGetVisibilityMethod;
import com.facebook.orca.protocol.methods.ChatSetVisibilityMethod;
import com.facebook.orca.protocol.methods.ConfirmPhoneAndRegisterPartialAccountMethod;
import com.facebook.orca.protocol.methods.ConfirmPhoneMethod;
import com.facebook.orca.protocol.methods.CreateThreadMethod;
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
import com.facebook.orca.protocol.methods.OrcaSessionlessGateKeeperSetProvider;
import com.facebook.orca.protocol.methods.PushTraceInfoConfirmationMethod;
import com.facebook.orca.protocol.methods.RemoveMemberMethod;
import com.facebook.orca.protocol.methods.RequestSmsConfirmationCodeMethod;
import com.facebook.orca.protocol.methods.SendMessageMethod;
import com.facebook.orca.protocol.methods.SendViaChatHandler;
import com.facebook.orca.protocol.methods.SetThreadImageMethod;
import com.facebook.orca.protocol.methods.SetThreadMuteUntilMethod;
import com.facebook.orca.protocol.methods.SetThreadNameMethod;
import com.facebook.orca.protocol.methods.SetUserSettingsMethod;
import com.facebook.orca.protocol.methods.UploadShareMethod;
import com.facebook.orca.protocol.methods.UserValidateRegistrationDataMethod;
import com.facebook.orca.rollout.OrcaRolloutManager;
import com.facebook.zero.ZeroTokenManager;
import com.facebook.zero.protocol.methods.FetchZeroTokenMethod;

class MessagesModule$WebServiceHandlerProvider extends AbstractProvider<WebServiceHandler>
{
  private MessagesModule$WebServiceHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public WebServiceHandler a()
  {
    return new WebServiceHandler(a(SingleMethodRunner.class), a(BatchRunner.class), a(SimulatedBatchRunner.class), (MeUserAuthDataStore)b(MeUserAuthDataStore.class), (GatekeeperSetProvider)b(OrcaSessionlessGateKeeperSetProvider.class), (UserValidateRegistrationDataMethod)b(UserValidateRegistrationDataMethod.class), (ConfirmPhoneAndRegisterPartialAccountMethod)b(ConfirmPhoneAndRegisterPartialAccountMethod.class), (GraphUserPostMethod)b(GraphUserPostMethod.class), (LookupUserMethod)b(LookupUserMethod.class), (FetchThreadListMethod)b(FetchThreadListMethod.class), (FetchMoreThreadsMethod)b(FetchMoreThreadsMethod.class), (FetchThreadMethod)b(FetchThreadMethod.class), (GetMeUserMethod)b(GetMeUserMethod.class), (SendMessageMethod)b(SendMessageMethod.class), (FetchMoreMessagesMethod)b(FetchMoreMessagesMethod.class), (FetchMessageMethod)b(FetchMessageMethod.class), (AddMembersMethod)b(AddMembersMethod.class), (CreateThreadMethod)b(CreateThreadMethod.class), (UploadShareMethod)b(UploadShareMethod.class), (RemoveMemberMethod)b(RemoveMemberMethod.class), (MarkThreadMethod)b(MarkThreadMethod.class), (DeleteThreadMethod)b(DeleteThreadMethod.class), (DeleteMessagesMethod)b(DeleteMessagesMethod.class), (SetThreadNameMethod)b(SetThreadNameMethod.class), (SetThreadImageMethod)b(SetThreadImageMethod.class), (MarkFolderSeenMethod)b(MarkFolderSeenMethod.class), (RequestSmsConfirmationCodeMethod)b(RequestSmsConfirmationCodeMethod.class), (ConfirmPhoneMethod)b(ConfirmPhoneMethod.class), (SetThreadMuteUntilMethod)b(SetThreadMuteUntilMethod.class), (FetchAppConfigMethod)b(FetchAppConfigMethod.class), (SendViaChatHandler)b(SendViaChatHandler.class), (SetUserSettingsMethod)b(SetUserSettingsMethod.class), (FetchGatekeepersMethod)b(FetchGatekeepersMethod.class), (FetchRolloutsMethod)b(FetchRolloutsMethod.class), (HoneyAnalyticsUploadHandler)b(HoneyAnalyticsUploadHandler.class), (ChatSetVisibilityMethod)b(ChatSetVisibilityMethod.class), (ChatGetVisibilityMethod)b(ChatGetVisibilityMethod.class), (PushTraceInfoConfirmationMethod)b(PushTraceInfoConfirmationMethod.class), (OrcaRolloutManager)b(OrcaRolloutManager.class), (ZeroTokenManager)b(ZeroTokenManager.class), (FetchZeroTokenMethod)b(FetchZeroTokenMethod.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.WebServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */