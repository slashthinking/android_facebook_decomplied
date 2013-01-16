package com.facebook.orca.app;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.orca.common.ui.widgets.AnchorableToast;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$AnchorableToastProvider extends AbstractProvider<AnchorableToast>
{
  private MessagesModule$AnchorableToastProvider(MessagesModule paramMessagesModule)
  {
  }

  public AnchorableToast a()
  {
    return new AnchorableToast((Context)b(Context.class), (LayoutInflater)b(LayoutInflater.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.AnchorableToastProvider
 * JD-Core Version:    0.6.0
 */