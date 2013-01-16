package com.facebook.orca.app;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threadview.ThreadMemberListAdapter;

class MessagesModule$ThreadMemberListAdapterProvider extends AbstractProvider<ThreadMemberListAdapter>
{
  private MessagesModule$ThreadMemberListAdapterProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadMemberListAdapter a()
  {
    return new ThreadMemberListAdapter((Context)b(Context.class), (LayoutInflater)b(LayoutInflater.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadMemberListAdapterProvider
 * JD-Core Version:    0.6.0
 */