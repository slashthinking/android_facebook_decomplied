package com.facebook.orca.threadlist;

public abstract interface ThreadListLoader$Callback
{
  public abstract void a(ThreadListLoader.LoadType paramLoadType);

  public abstract void a(ThreadListLoader.LoadType paramLoadType, ThreadListLoader.Error paramError);

  public abstract void a(ThreadListLoader.LoadType paramLoadType, ThreadListLoader.Result paramResult);

  public abstract void b(ThreadListLoader.LoadType paramLoadType);

  public abstract void b(ThreadListLoader.LoadType paramLoadType, ThreadListLoader.Error paramError);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListLoader.Callback
 * JD-Core Version:    0.6.0
 */