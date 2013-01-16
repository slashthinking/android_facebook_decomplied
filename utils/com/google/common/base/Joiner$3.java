package com.google.common.base;

import java.util.AbstractList;

final class Joiner$3 extends AbstractList<Object>
{
  Joiner$3(Object[] paramArrayOfObject, Object paramObject1, Object paramObject2)
  {
  }

  public Object get(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = this.val$rest[(paramInt - 2)];
    case 0:
    case 1:
    }
    while (true)
    {
      return localObject;
      localObject = this.val$first;
      continue;
      localObject = this.val$second;
    }
  }

  public int size()
  {
    return 2 + this.val$rest.length;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Joiner.3
 * JD-Core Version:    0.6.2
 */