package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threadview.ThreadViewUtil;

class MessagesModule$ThreadViewUtilProvider extends AbstractProvider<ThreadViewUtil>
{
  private MessagesModule$ThreadViewUtilProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadViewUtil a()
  {
    return new ThreadViewUtil();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadViewUtilProvider
 * JD-Core Version:    0.6.0
 */