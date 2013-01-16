package com.facebook.orca.app;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.orca.images.ImageSearchListAdapter;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$ImageSearchListAdapterProvider extends AbstractProvider<ImageSearchListAdapter>
{
  private MessagesModule$ImageSearchListAdapterProvider(MessagesModule paramMessagesModule)
  {
  }

  public ImageSearchListAdapter a()
  {
    return new ImageSearchListAdapter((Context)b(Context.class), (LayoutInflater)b(LayoutInflater.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ImageSearchListAdapterProvider
 * JD-Core Version:    0.6.0
 */