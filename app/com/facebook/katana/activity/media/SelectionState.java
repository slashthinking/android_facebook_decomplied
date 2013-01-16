package com.facebook.katana.activity.media;

import android.content.Context;
import com.facebook.common.util.Toaster;
import com.facebook.katana.model.MediaItem;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SelectionState
  implements Iterable<Long>
{
  private List<SelectionState.SelectionListener> a = Lists.a();
  private Set<Long> b = Sets.b();

  public SelectionState()
  {
  }

  public SelectionState(long[] paramArrayOfLong)
  {
    int i = paramArrayOfLong.length;
    for (int j = 0; j < i; j++)
    {
      long l = paramArrayOfLong[j];
      this.b.add(Long.valueOf(l));
    }
  }

  private void a(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((SelectionState.SelectionListener)localIterator.next()).a(paramLong, paramBoolean);
  }

  public void a()
  {
    ArrayList localArrayList = Lists.a(this.b);
    this.b.clear();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
      a(((Long)localIterator.next()).longValue(), false);
  }

  public void a(Context paramContext)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(30);
    Toaster.a(paramContext, paramContext.getString(2131363237, arrayOfObject));
  }

  public void a(SelectionState.SelectionListener paramSelectionListener)
  {
    this.a.add(paramSelectionListener);
  }

  public boolean a(MediaItem paramMediaItem)
  {
    boolean bool = true;
    if (b() < 30)
    {
      this.b.add(Long.valueOf(paramMediaItem.a()));
      a(paramMediaItem.a(), bool);
    }
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public int b()
  {
    return this.b.size();
  }

  public void b(SelectionState.SelectionListener paramSelectionListener)
  {
    this.a.remove(paramSelectionListener);
  }

  public void b(MediaItem paramMediaItem)
  {
    if (this.b.remove(Long.valueOf(paramMediaItem.a())))
      a(paramMediaItem.a(), false);
  }

  public boolean c(MediaItem paramMediaItem)
  {
    return this.b.contains(Long.valueOf(paramMediaItem.a()));
  }

  public long[] c()
  {
    long[] arrayOfLong = new long[this.b.size()];
    Iterator localIterator = this.b.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
      arrayOfLong[i] = ((Long)localIterator.next()).longValue();
    return arrayOfLong;
  }

  public Iterator<Long> iterator()
  {
    return Collections.unmodifiableSet(this.b).iterator();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.SelectionState
 * JD-Core Version:    0.6.0
 */