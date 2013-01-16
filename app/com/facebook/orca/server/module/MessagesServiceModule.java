package com.facebook.orca.server.module;

import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.zero.annotations.ZeroTokenQueue;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class MessagesServiceModule extends AbstractModule
{
  private void a(Class<? extends Annotation> paramClass, Provider<OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    a(ThreadsQueue.class, new MessagesServiceModule.OrcaServiceHandlerForThreadsQueueProvider(this, null));
    a(SendQueue.class, new MessagesServiceModule.OrcaServiceHandlerForSendQueueProvider(this, null));
    a(PushQueue.class, new MessagesServiceModule.OrcaServiceHandlerForThreadsQueueProvider(this, null));
    a(AddressBookQueue.class, new MessagesServiceModule.OrcaServiceHandlerForAddressBookProvider(this, null));
    a(LocationQueue.class, new MessagesServiceModule.OrcaServiceHandlerForLocationProvider(this, null));
    a(ImageSearchQueue.class, new MessagesServiceModule.OrcaServiceHandlerForImageSearchProvider(this, null));
    a(AnalyticsQueue.class, new MessagesServiceModule.OrcaServiceHandlerWithJustWebServiceProvider(this, null));
    a(ContactsUploadQueue.class, new MessagesServiceModule.OrcaServiceHandlerForContactsUploadProvider(this, null));
    a(ContactsInviteQueue.class, new MessagesServiceModule.OrcaServiceHandlerForContactsInviteProvider(this, null));
    a(PhoneNumberIdentificationQueue.class, new MessagesServiceModule.OrcaServiceHandlerForPhoneNumberIdentificationProvider(this, null));
    a(ZeroTokenQueue.class, new MessagesServiceModule.OrcaServiceHandlerForZeroTokenProvider(this, null));
    a(MessagesServicesInitializer.class).a(new MessagesServiceModule.MessagesServicesInitializerProvider(this, null));
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(MessagesServicesInitializer.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.module.MessagesServiceModule
 * JD-Core Version:    0.6.0
 */