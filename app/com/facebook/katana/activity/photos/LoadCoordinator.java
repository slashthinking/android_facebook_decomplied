package com.facebook.katana.activity.photos;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class LoadCoordinator
{
  private final int a;
  private List<Set<Long>> b = Lists.a();

  public LoadCoordinator(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("groupSize must be greater than 0 " + paramInt);
    this.a = paramInt;
  }

  private int a(int paramInt)
  {
    return paramInt / this.a;
  }

  public List<Set<Long>> a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1)
      throw new IllegalArgumentException("posFist must be less that posLast got " + paramInt1 + ", " + paramInt2);
    ArrayList localArrayList = Lists.a();
    for (int i = a(paramInt1); i <= a(paramInt2); i++)
    {
      if (i >= this.b.size())
        continue;
      localArrayList.add(this.b.get(i));
    }
    return localArrayList;
  }

  public void a(List<Long> paramList)
  {
    ArrayList localArrayList = Lists.a();
    int i = 0;
    int j = this.a;
    while (i < Math.min(j, paramList.size()))
    {
      localArrayList.add(Collections.unmodifiableSet(Sets.a(paramList.subList(i, Math.min(j, paramList.size())))));
      i += this.a;
      j += this.a;
    }
    this.b = localArrayList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.photos.LoadCoordinator
 * JD-Core Version:    0.6.0
 */