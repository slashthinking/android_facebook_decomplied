package com.facebook.orca.sms;

import android.content.Context;
import com.facebook.orca.annotations.IsCallLogEnabled;
import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.annotations.IsClientSmsPermitted;
import com.facebook.orca.annotations.IsClientSmsPossible;
import com.facebook.orca.annotations.IsSmsNotifyEnabled;
import com.facebook.orca.annotations.IsSmsOnlyModeEnabled;
import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.sms.observe.ExternalSmsOperationsHandler;
import com.facebook.orca.sms.observe.ExternalSmsOperationsObserver;

public class MmsSmsModule extends AbstractModule
{
  private final Context a;

  public MmsSmsModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    a(MmsSmsServiceHandler.class).a(new MmsSmsModule.MmsSmsServiceHandlerProvider(this, null));
    a(MmsSmsFetchThreadsHandler.class).a(new MmsSmsModule.MmsSmsFetchThreadsHandlerProvider(this, null));
    a(MmsSmsFetchThreadHandler.class).a(new MmsSmsModule.MmsSmsFetchThreadHandlerProvider(this, null));
    a(MmsSmsContentResolverHandler.class).a(new MmsSmsModule.MmsSmsContentResolverHandlerProvider(this, null));
    a(MmsSmsUserUtils.class).a(new MmsSmsModule.MmsSmsUserUtilsProvider(this, null));
    a(MmsSmsSendMessageHandler.class).a(new MmsSmsModule.MmsSmsSendMessageHandlerProvider(this, null));
    a(MmsSmsLogger.class).a(new MmsSmsModule.MmsSmsLoggerProvider(this, null)).a();
    a(CallLogContentResolverHandler.class).a(new MmsSmsModule.CallLogContentResolverHandlerProvider(this, null));
    a(MmsContentResolverHandler.class).a(new MmsSmsModule.MmsContentResolverHandlerProvider(this, null));
    a(MmsSendMessageHandler.class).a(new MmsSmsModule.MmsSendMessageHandlerProvider(this, null));
    a(MmsReceiverWakeLockHolder.class).a(new MmsSmsModule.MmsReceiverWakeLockHolderProvider(this, null)).a();
    a(MmsTransactionStateReceiverWakeLockHolder.class).a(new MmsSmsModule.MmsTransactionStateReceiverWakeLockHolderProvider(this, null)).a();
    a(SmsContentResolverHandler.class).a(new MmsSmsModule.SmsContentResolverHandlerProvider(this, null));
    a(SmsSendMessageHandler.class).a(new MmsSmsModule.SmsSendMessageHandlerProvider(this, null));
    a(SmsReceiverWakeLockHolder.class).a(new MmsSmsModule.SmsReceiverWakeLockHolderProvider(this, null)).a();
    a(ExternalSmsOperationsObserver.class).a(new MmsSmsModule.SmsSentObserverProvider(this, null)).a();
    a(ExternalSmsOperationsHandler.class).a(new MmsSmsModule.ExternalSmsOperationsHandlerProvider(this, null)).a();
    a(MmsSmsLogExternalMessagesLogic.class).a(new MmsSmsModule.MmsSmsLogExternalMessagesLogicProvider(this, null)).a();
    a(Boolean.class).a(IsClientSmsEnabled.class).c(IsClientSmsEnabledProvider.class);
    a(Boolean.class).a(IsSmsOnlyModeEnabled.class).c(IsSmsOnlyModeEnabledProvider.class);
    a(Boolean.class).a(IsSmsNotifyEnabled.class).c(IsSmsNotifyEnabledProvider.class);
    a(Boolean.class).a(IsClientSmsPermitted.class).c(IsClientSmsPermittedProvider.class);
    a(Boolean.class).a(IsClientSmsPossible.class).c(IsClientSmsPossibleProvider.class);
    a(Boolean.class).a(IsCallLogEnabled.class).c(IsCallLogEnabledProvider.class);
    a(MmsSmsInitializer.class).a(new MmsSmsModule.MmsSmsInitializerProvider(this, null));
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(MmsSmsInitializer.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule
 * JD-Core Version:    0.6.0
 */