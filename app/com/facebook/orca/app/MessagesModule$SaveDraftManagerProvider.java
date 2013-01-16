package com.facebook.orca.app;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.cache.SaveDraftManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;

class MessagesModule$SaveDraftManagerProvider extends AbstractProvider<SaveDraftManager>
{
  private MessagesModule$SaveDraftManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public SaveDraftManager a()
  {
    return new SaveDraftManager(a(OrcaServiceOperation.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.SaveDraftManagerProvider
 * JD-Core Version:    0.6.0
 */