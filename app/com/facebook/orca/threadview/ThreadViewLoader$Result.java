package com.facebook.orca.threadview;

import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ThreadSummary;
import com.google.common.collect.ImmutableList;

public class ThreadViewLoader$Result
{
  public final ThreadSummary a;
  public final MessagesCollection b;
  public final ImmutableList<Message> c;

  public ThreadViewLoader$Result(ThreadSummary paramThreadSummary, MessagesCollection paramMessagesCollection, ImmutableList<Message> paramImmutableList)
  {
    this.a = paramThreadSummary;
    this.b = paramMessagesCollection;
    this.c = paramImmutableList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewLoader.Result
 * JD-Core Version:    0.6.0
 */