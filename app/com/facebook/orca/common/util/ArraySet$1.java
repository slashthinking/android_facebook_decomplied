package com.facebook.orca.common.util;

import java.util.ArrayList;
import java.util.Iterator;

class ArraySet$1
  implements Iterator<T>
{
  int a = -1;

  public boolean hasNext()
  {
    if (1 + this.a < ArraySet.a(this.b).size());
    for (int i = 1; ; i = 0)
      return i;
  }

  public T next()
  {
    this.a = (1 + this.a);
    return ArraySet.a(this.b).get(this.a);
  }

  public void remove()
  {
    throw new UnsupportedOperationException("Remove not supported for this set iterator");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.ArraySet.1
 * JD-Core Version:    0.6.0
 */