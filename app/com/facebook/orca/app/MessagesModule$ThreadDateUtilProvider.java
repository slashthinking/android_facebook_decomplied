package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threads.ThreadDateUtil;

class MessagesModule$ThreadDateUtilProvider extends AbstractProvider<ThreadDateUtil>
{
  private MessagesModule$ThreadDateUtilProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadDateUtil a()
  {
    return new ThreadDateUtil(MessagesModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadDateUtilProvider
 * JD-Core Version:    0.6.0
 */