package com.facebook.orca.threadview;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.SortedSet;

class ThreadViewMessagesAdapterUpdater$ItemDeletionTracker
{
  private SortedSet<Integer> b = Sets.c();
  private SortedSet<Integer> c = Sets.c();

  private ThreadViewMessagesAdapterUpdater$ItemDeletionTracker(ThreadViewMessagesAdapterUpdater paramThreadViewMessagesAdapterUpdater)
  {
  }

  private int a(int paramInt, SortedSet<Integer> paramSortedSet, boolean paramBoolean)
  {
    Iterator localIterator = paramSortedSet.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      if (j < paramInt);
      for (int k = i + 1; ; k = i + 1)
      {
        i = k;
        break;
        if ((!paramBoolean) || (j > paramInt))
          break label74;
      }
    }
    label74: return i;
  }

  public void a(int paramInt)
  {
    this.b.add(Integer.valueOf(paramInt));
  }

  public void b(int paramInt)
  {
    this.c.add(Integer.valueOf(paramInt));
  }

  public int c(int paramInt)
  {
    return a(paramInt, this.b, false);
  }

  public int d(int paramInt)
  {
    return a(paramInt, this.c, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewMessagesAdapterUpdater.ItemDeletionTracker
 * JD-Core Version:    0.6.0
 */