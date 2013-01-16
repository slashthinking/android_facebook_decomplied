package com.facebook.orca.threadlist;

public enum ThreadListLoader$LoadType
{
  static
  {
    MORE_THREADS = new LoadType("MORE_THREADS", 1);
    LoadType[] arrayOfLoadType = new LoadType[2];
    arrayOfLoadType[0] = THREAD_LIST;
    arrayOfLoadType[1] = MORE_THREADS;
    $VALUES = arrayOfLoadType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListLoader.LoadType
 * JD-Core Version:    0.6.0
 */