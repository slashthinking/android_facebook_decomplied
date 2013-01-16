package com.google.common.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class MoreExecutors
{
  public static ListeningExecutorService a()
  {
    return new MoreExecutors.SameThreadExecutorService(null);
  }

  public static ListeningExecutorService a(ExecutorService paramExecutorService)
  {
    Object localObject;
    if ((paramExecutorService instanceof ListeningExecutorService))
      localObject = (ListeningExecutorService)paramExecutorService;
    while (true)
    {
      return localObject;
      if ((paramExecutorService instanceof ScheduledExecutorService))
        localObject = new MoreExecutors.ScheduledListeningDecorator((ScheduledExecutorService)paramExecutorService);
      else
        localObject = new MoreExecutors.ListeningDecorator(paramExecutorService);
    }
  }

  public static ListeningScheduledExecutorService a(ScheduledExecutorService paramScheduledExecutorService)
  {
    if ((paramScheduledExecutorService instanceof ListeningScheduledExecutorService));
    for (Object localObject = (ListeningScheduledExecutorService)paramScheduledExecutorService; ; localObject = new MoreExecutors.ScheduledListeningDecorator(paramScheduledExecutorService))
      return localObject;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.MoreExecutors
 * JD-Core Version:    0.6.2
 */