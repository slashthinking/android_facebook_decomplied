package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.CreateThreadMethod;
import com.facebook.orca.protocol.methods.PickedUserUtils;
import com.facebook.orca.protocol.methods.SendMessageParameterHelper;

class MessagesModule$CreateThreadMethodProvider extends AbstractProvider<CreateThreadMethod>
{
  private MessagesModule$CreateThreadMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public CreateThreadMethod a()
  {
    return new CreateThreadMethod((PickedUserUtils)b(PickedUserUtils.class), (SendMessageParameterHelper)b(SendMessageParameterHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.CreateThreadMethodProvider
 * JD-Core Version:    0.6.0
 */