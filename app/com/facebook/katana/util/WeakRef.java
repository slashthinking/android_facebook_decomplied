package com.facebook.katana.util;

import java.lang.ref.WeakReference;

public class WeakRef<T> extends WeakReference<T>
{
  public WeakRef(T paramT)
  {
    super(paramT);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    if (paramObject != null)
    {
      boolean bool2 = paramObject instanceof WeakRef;
      bool1 = false;
      if (bool2)
        break label19;
    }
    while (true)
    {
      return bool1;
      label19: WeakRef localWeakRef = (WeakRef)paramObject;
      Object localObject1 = get();
      Object localObject2 = localWeakRef.get();
      bool1 = false;
      if (localObject1 == null)
        continue;
      bool1 = false;
      if (localObject2 == null)
        continue;
      bool1 = localObject1.equals(localObject2);
    }
  }

  public int hashCode()
  {
    Object localObject = get();
    if (localObject != null);
    for (int i = localObject.hashCode(); ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.WeakRef
 * JD-Core Version:    0.6.0
 */