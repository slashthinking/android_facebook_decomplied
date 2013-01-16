package com.facebook.orca.threadview;

import com.facebook.orca.threads.ThreadSummary;

public abstract interface ThreadViewLoader$Callback
{
  public abstract void a(ThreadSummary paramThreadSummary);

  public abstract void a(ThreadViewLoader.LoadType paramLoadType);

  public abstract void a(ThreadViewLoader.LoadType paramLoadType, ThreadViewLoader.Error paramError);

  public abstract void a(ThreadViewLoader.LoadType paramLoadType, ThreadViewLoader.Result paramResult);

  public abstract void b(ThreadViewLoader.LoadType paramLoadType);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewLoader.Callback
 * JD-Core Version:    0.6.0
 */