package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ThreadsCollection
  implements Parcelable
{
  public static final Parcelable.Creator<ThreadsCollection> CREATOR;
  private static final Class<?> a = ThreadsCollection.class;
  private static final WtfToken b = new WtfToken();
  private static final ThreadsCollection c = new ThreadsCollection(ImmutableList.d(), true);
  private final ImmutableList<ThreadSummary> d;
  private final boolean e;

  static
  {
    CREATOR = new ThreadsCollection.1();
  }

  private ThreadsCollection(Parcel paramParcel)
  {
    this.d = ImmutableList.a(paramParcel.readArrayList(ThreadSummary.class.getClassLoader()));
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.e = bool;
      return;
    }
  }

  public ThreadsCollection(ImmutableList<ThreadSummary> paramImmutableList, boolean paramBoolean)
  {
    this.d = paramImmutableList;
    this.e = paramBoolean;
    a(paramImmutableList);
  }

  public static ThreadsCollection a()
  {
    return c;
  }

  public static ThreadsCollection a(ThreadsCollection paramThreadsCollection1, ThreadsCollection paramThreadsCollection2)
  {
    if ((paramThreadsCollection1.d()) && (paramThreadsCollection2.d()));
    while (true)
    {
      return paramThreadsCollection1;
      if (paramThreadsCollection1.d())
      {
        paramThreadsCollection1 = paramThreadsCollection2;
        continue;
      }
      if (paramThreadsCollection2.d())
        continue;
      HashSet localHashSet = Sets.a();
      ImmutableList.Builder localBuilder = ImmutableList.e();
      Iterator localIterator1 = paramThreadsCollection1.b().iterator();
      while (localIterator1.hasNext())
      {
        ThreadSummary localThreadSummary2 = (ThreadSummary)localIterator1.next();
        localBuilder.b(localThreadSummary2);
        localHashSet.add(localThreadSummary2.a());
      }
      Iterator localIterator2 = paramThreadsCollection2.b().iterator();
      while (localIterator2.hasNext())
      {
        ThreadSummary localThreadSummary1 = (ThreadSummary)localIterator2.next();
        if (localHashSet.contains(localThreadSummary1.a()))
          continue;
        localBuilder.b(localThreadSummary1);
      }
      paramThreadsCollection1 = new ThreadsCollection(localBuilder.b(), paramThreadsCollection2.c());
    }
  }

  private static void a(ImmutableList<ThreadSummary> paramImmutableList)
  {
    Iterator localIterator = paramImmutableList.iterator();
    long l = 9223372036854775807L;
    while (true)
    {
      ThreadSummary localThreadSummary;
      if (localIterator.hasNext())
      {
        localThreadSummary = (ThreadSummary)localIterator.next();
        if (localThreadSummary.k() > l)
          BLog.a(b, a, "Threads were not in order");
      }
      else
      {
        return;
      }
      l = localThreadSummary.k();
    }
  }

  public ThreadSummary a(int paramInt)
  {
    return (ThreadSummary)this.d.get(paramInt);
  }

  public ImmutableList<ThreadSummary> b()
  {
    return this.d;
  }

  public boolean c()
  {
    return this.e;
  }

  public boolean d()
  {
    return this.d.isEmpty();
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return this.d.size();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.d);
    if (this.e);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadsCollection
 * JD-Core Version:    0.6.0
 */