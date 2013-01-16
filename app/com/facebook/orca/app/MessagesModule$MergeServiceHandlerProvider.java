package com.facebook.orca.app;

import com.facebook.contacts.data.DbFetchContactHandler;
import com.facebook.login.ContextAwareAuthTokenStringSupplier;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.annotations.IsMergeThreadsEnabled;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.merge.MergeServiceHandler;
import java.util.concurrent.ExecutorService;

class MessagesModule$MergeServiceHandlerProvider extends AbstractProvider<MergeServiceHandler>
{
  private MessagesModule$MergeServiceHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public MergeServiceHandler a()
  {
    return new MergeServiceHandler((ExecutorService)b(ExecutorService.class, DefaultExecutorService.class), (ContextAwareAuthTokenStringSupplier)b(ContextAwareAuthTokenStringSupplier.class), (DbFetchContactHandler)b(DbFetchContactHandler.class), a(Boolean.class, IsMergeThreadsEnabled.class), a(Boolean.class, IsClientSmsEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MergeServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */