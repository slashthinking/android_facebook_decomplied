package com.facebook.orca.app;

import android.content.res.Resources;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threads.ThreadSnippetUtil;

class MessagesModule$ThreadSnippetUtilProvider extends AbstractProvider<ThreadSnippetUtil>
{
  private MessagesModule$ThreadSnippetUtilProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadSnippetUtil a()
  {
    return new ThreadSnippetUtil((Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadSnippetUtilProvider
 * JD-Core Version:    0.6.0
 */