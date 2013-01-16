package com.facebook.orca.app;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.orca.cache.ArchiveThreadManager;
import com.facebook.orca.cache.SpamThreadManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threadlist.ThreadListAdapter;

class MessagesModule$ThreadListAdapterProvider extends AbstractProvider<ThreadListAdapter>
{
  private MessagesModule$ThreadListAdapterProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadListAdapter a()
  {
    return new ThreadListAdapter((Context)b(Context.class), (ArchiveThreadManager)b(ArchiveThreadManager.class), (SpamThreadManager)b(SpamThreadManager.class), (LayoutInflater)b(LayoutInflater.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadListAdapterProvider
 * JD-Core Version:    0.6.0
 */