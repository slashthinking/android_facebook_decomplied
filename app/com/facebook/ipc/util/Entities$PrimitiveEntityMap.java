package com.facebook.ipc.util;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

class Entities$PrimitiveEntityMap
  implements Entities.EntityMap
{
  private Map<String, Integer> a = new HashMap();
  private SparseArray<String> b = new SparseArray();

  public int a(String paramString)
  {
    Object localObject = this.a.get(paramString);
    if (localObject == null);
    for (int i = -1; ; i = ((Integer)localObject).intValue())
      return i;
  }

  public void a(String paramString, int paramInt)
  {
    this.a.put(paramString, new Integer(paramInt));
    this.b.put(paramInt, paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.util.Entities.PrimitiveEntityMap
 * JD-Core Version:    0.6.0
 */