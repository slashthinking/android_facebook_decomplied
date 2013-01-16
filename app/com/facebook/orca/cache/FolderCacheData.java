package com.facebook.orca.cache;

import com.facebook.common.collect.MapWithSecondaryOrdering;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.ThreadSummary;

public class FolderCacheData
{
  private final FolderName a;
  private final MapWithSecondaryOrdering<String, ThreadSummary> b;
  private boolean c;
  private boolean d;
  private boolean e;
  private long f = -1L;
  private FolderCounts g;

  FolderCacheData(FolderName paramFolderName)
  {
    this.a = paramFolderName;
    this.b = new MapWithSecondaryOrdering(new FolderCacheData.ThreadSummaryByDateComparator(null));
  }

  public MapWithSecondaryOrdering<String, ThreadSummary> a()
  {
    return this.b;
  }

  public void a(long paramLong)
  {
    this.f = paramLong;
  }

  public void a(FolderCounts paramFolderCounts)
  {
    this.g = paramFolderCounts;
  }

  public void a(ThreadSummary paramThreadSummary)
  {
    this.b.put(paramThreadSummary.a(), paramThreadSummary);
  }

  public void a(String paramString)
  {
    this.b.remove(paramString);
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public boolean b()
  {
    return this.c;
  }

  public boolean b(String paramString)
  {
    if (this.b.get(paramString) != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public boolean c()
  {
    return this.d;
  }

  public boolean d()
  {
    return this.e;
  }

  public long e()
  {
    return this.f;
  }

  public FolderCounts f()
  {
    return this.g;
  }

  public void g()
  {
    this.b.clear();
  }

  public void h()
  {
    this.b.clear();
    this.d = false;
    this.f = -1L;
    this.e = false;
    this.g = null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.FolderCacheData
 * JD-Core Version:    0.6.0
 */