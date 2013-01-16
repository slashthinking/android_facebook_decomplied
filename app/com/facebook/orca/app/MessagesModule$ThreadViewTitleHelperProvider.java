package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threadview.ThreadViewTitleHelper;

class MessagesModule$ThreadViewTitleHelperProvider extends AbstractProvider<ThreadViewTitleHelper>
{
  private MessagesModule$ThreadViewTitleHelperProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadViewTitleHelper a()
  {
    return new ThreadViewTitleHelper((Context)b(Context.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadViewTitleHelperProvider
 * JD-Core Version:    0.6.0
 */