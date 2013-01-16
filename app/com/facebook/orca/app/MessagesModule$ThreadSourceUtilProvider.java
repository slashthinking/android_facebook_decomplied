package com.facebook.orca.app;

import android.content.res.Resources;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threads.ThreadSourceUtil;

class MessagesModule$ThreadSourceUtilProvider extends AbstractProvider<ThreadSourceUtil>
{
  private MessagesModule$ThreadSourceUtilProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadSourceUtil a()
  {
    return new ThreadSourceUtil((Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadSourceUtilProvider
 * JD-Core Version:    0.6.0
 */