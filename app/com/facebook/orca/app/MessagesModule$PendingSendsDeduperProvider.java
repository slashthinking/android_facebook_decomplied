package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threadview.PendingSendsDeduper;

class MessagesModule$PendingSendsDeduperProvider extends AbstractProvider<PendingSendsDeduper>
{
  private MessagesModule$PendingSendsDeduperProvider(MessagesModule paramMessagesModule)
  {
  }

  public PendingSendsDeduper a()
  {
    return new PendingSendsDeduper();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.PendingSendsDeduperProvider
 * JD-Core Version:    0.6.0
 */