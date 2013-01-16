package com.facebook.orca.common.async;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Queue;

class KeyedExecutor$TaskQueue
{
  final Object a;
  final Queue<KeyedExecutor.Task> b = Lists.b();
  ListenableFuture<?> c;

  KeyedExecutor$TaskQueue(Object paramObject)
  {
    this.a = paramObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.async.KeyedExecutor.TaskQueue
 * JD-Core Version:    0.6.0
 */