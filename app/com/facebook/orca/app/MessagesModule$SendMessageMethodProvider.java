package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.SendMessageMethod;
import com.facebook.orca.protocol.methods.SendMessageParameterHelper;

class MessagesModule$SendMessageMethodProvider extends AbstractProvider<SendMessageMethod>
{
  private MessagesModule$SendMessageMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public SendMessageMethod a()
  {
    return new SendMessageMethod((SendMessageParameterHelper)b(SendMessageParameterHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.SendMessageMethodProvider
 * JD-Core Version:    0.6.0
 */