package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.GraphUserPostMethod;

class MessagesModule$GraphUserPostMethodProvider extends AbstractProvider<GraphUserPostMethod>
{
  private MessagesModule$GraphUserPostMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public GraphUserPostMethod a()
  {
    return new GraphUserPostMethod();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.GraphUserPostMethodProvider
 * JD-Core Version:    0.6.0
 */