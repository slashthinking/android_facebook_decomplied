package com.facebook.orca.threadview;

import com.facebook.orca.debug.BLog;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PendingSendsDeduper
{
  private static final String a = PendingSendsDeduper.class.getSimpleName();

  public ImmutableList<Message> a(MessagesCollection paramMessagesCollection, List<Message> paramList)
  {
    if (paramList.isEmpty());
    ImmutableList.Builder localBuilder;
    for (ImmutableList localImmutableList = ImmutableList.d(); ; localImmutableList = localBuilder.b())
    {
      return localImmutableList;
      HashSet localHashSet = Sets.a();
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
        localHashSet.add(((Message)localIterator1.next()).t());
      Iterator localIterator2 = paramMessagesCollection.b().iterator();
      while (localIterator2.hasNext())
      {
        Message localMessage2 = (Message)localIterator2.next();
        if ((!localMessage2.u()) || (!localHashSet.contains(localMessage2.t())))
          continue;
        BLog.a(a, "Deduped message %s", new Object[] { localMessage2 });
        localHashSet.remove(localMessage2.t());
      }
      localBuilder = ImmutableList.e();
      Iterator localIterator3 = paramList.iterator();
      while (localIterator3.hasNext())
      {
        Message localMessage1 = (Message)localIterator3.next();
        if (!localHashSet.contains(localMessage1.t()))
          continue;
        localBuilder.b(localMessage1);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.PendingSendsDeduper
 * JD-Core Version:    0.6.0
 */