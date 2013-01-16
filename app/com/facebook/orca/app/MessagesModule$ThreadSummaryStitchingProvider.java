package com.facebook.orca.app;

import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threads.ThreadSnippetUtil;
import com.facebook.orca.threads.ThreadSummaryStitching;
import com.facebook.orca.users.User;

class MessagesModule$ThreadSummaryStitchingProvider extends AbstractProvider<ThreadSummaryStitching>
{
  private MessagesModule$ThreadSummaryStitchingProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadSummaryStitching a()
  {
    return new ThreadSummaryStitching(a(User.class, MeUser.class), (ThreadSnippetUtil)b(ThreadSnippetUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadSummaryStitchingProvider
 * JD-Core Version:    0.6.0
 */