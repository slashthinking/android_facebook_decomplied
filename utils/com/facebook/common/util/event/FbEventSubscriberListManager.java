package com.facebook.common.util.event;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

public class FbEventSubscriberListManager
{
  private List<FbEventSubscriber> a;

  public void a(FbEventBus paramFbEventBus)
  {
    if (this.a != null)
    {
      Preconditions.checkNotNull(paramFbEventBus);
      int i = this.a.size();
      for (int j = 0; j < i; j++)
        paramFbEventBus.a((FbEventSubscriber)this.a.get(j));
    }
  }

  public boolean a(FbEventSubscriber paramFbEventSubscriber)
  {
    if (this.a == null)
      this.a = Lists.a();
    int i = this.a.size();
    int j = 0;
    boolean bool;
    if (j < i)
    {
      Object localObject = this.a.get(j);
      bool = false;
      if (localObject != paramFbEventSubscriber);
    }
    while (true)
    {
      return bool;
      j++;
      break;
      bool = this.a.add(paramFbEventSubscriber);
    }
  }

  public void b(FbEventBus paramFbEventBus)
  {
    if (this.a != null)
    {
      Preconditions.checkNotNull(paramFbEventBus);
      int i = this.a.size();
      for (int j = 0; j < i; j++)
        paramFbEventBus.b((FbEventSubscriber)this.a.get(j));
    }
  }

  public boolean b(FbEventSubscriber paramFbEventSubscriber)
  {
    List localList = this.a;
    boolean bool = false;
    if (localList == null)
      return bool;
    int i = this.a.size();
    for (int j = 0; ; j++)
    {
      bool = false;
      if (j >= i)
        break;
      if (this.a.get(j) == paramFbEventSubscriber)
      {
        this.a.remove(j);
        bool = true;
        break;
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.event.FbEventSubscriberListManager
 * JD-Core Version:    0.6.2
 */