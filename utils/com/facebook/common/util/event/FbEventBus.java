package com.facebook.common.util.event;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FbEventBus<T extends FbEventSubscriber, E extends FbEvent>
{
  private final Map<Class<E>, List<WeakReference<T>>> a = Maps.a();

  public void a(E paramE)
  {
    try
    {
      Map localMap = this.a;
      if (localMap == null);
      while (true)
      {
        return;
        a(paramE.getClass());
        List localList = (List)this.a.get(paramE.getClass());
        if (localList != null)
        {
          int i = localList.size();
          for (int j = 0; j < i; j++)
            ((FbEventSubscriber)((WeakReference)localList.get(j)).get()).a(paramE);
        }
      }
    }
    finally
    {
    }
  }

  void a(Class paramClass)
  {
    List localList = (List)this.a.get(paramClass);
    if (localList != null)
      for (int i = -1 + localList.size(); i >= 0; i--)
        if (((WeakReference)localList.get(i)).get() == null)
          localList.remove(i);
  }

  public boolean a(T paramT)
  {
    boolean bool2;
    if (paramT == null)
    {
      bool2 = false;
      return bool2;
    }
    while (true)
    {
      int j;
      try
      {
        Class localClass = paramT.a();
        a(localClass);
        if (this.a.get(localClass) == null)
        {
          ArrayList localArrayList = Lists.a();
          this.a.put(localClass, localArrayList);
        }
        List localList = (List)this.a.get(localClass);
        int i = localList.size();
        j = 0;
        if (j < i)
        {
          if (((WeakReference)localList.get(j)).get() != paramT)
            continue;
          bool2 = false;
          break;
        }
        boolean bool1 = localList.add(new WeakReference(paramT));
        bool2 = bool1;
      }
      finally
      {
      }
    }
  }

  public boolean b(T paramT)
  {
    boolean bool;
    if (paramT == null)
      bool = false;
    while (true)
    {
      return bool;
      try
      {
        a(paramT.a());
        List localList = (List)this.a.get(paramT.a());
        if (localList == null)
        {
          bool = false;
          continue;
        }
        int i = localList.size();
        for (int j = 0; ; j++)
        {
          if (j >= i)
            break label106;
          if (((WeakReference)localList.get(j)).get() == paramT)
          {
            localList.remove(j);
            bool = true;
            break;
          }
        }
        label106: bool = false;
      }
      finally
      {
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.event.FbEventBus
 * JD-Core Version:    0.6.2
 */