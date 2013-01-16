package com.facebook.orca.app;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threadview.MessageListAdapter;

class MessagesModule$MessageListAdapterProvider extends AbstractProvider<MessageListAdapter>
{
  private MessagesModule$MessageListAdapterProvider(MessagesModule paramMessagesModule)
  {
  }

  public MessageListAdapter a()
  {
    return new MessageListAdapter((Context)b(Context.class), (LayoutInflater)b(LayoutInflater.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MessageListAdapterProvider
 * JD-Core Version:    0.6.0
 */