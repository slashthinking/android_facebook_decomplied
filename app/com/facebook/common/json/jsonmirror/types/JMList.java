package com.facebook.common.json.jsonmirror.types;

import com.facebook.common.json.jsonmirror.JMFatalException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class JMList extends JMBase
{
  protected final Set<JMBase> g;
  public final int h;
  public final int i;

  public JMList(Set<JMBase> paramSet)
  {
    this(paramSet, 0, 0);
  }

  public JMList(Set<JMBase> paramSet, int paramInt1, int paramInt2)
  {
    Iterator localIterator = paramSet.iterator();
    int j = 0;
    int k = 0;
    int m = 0;
    JMBase localJMBase;
    int n;
    int i1;
    int i2;
    if (localIterator.hasNext())
    {
      localJMBase = (JMBase)localIterator.next();
      if ((localJMBase instanceof JMList))
      {
        int i4 = k + 1;
        n = j;
        i1 = i4;
        i2 = m;
      }
    }
    while (true)
    {
      m = i2;
      k = i1;
      j = n;
      break;
      if (((localJMBase instanceof JMDict)) || ((localJMBase instanceof JMSimpleDict)))
      {
        n = j + 1;
        i1 = k;
        i2 = m;
        continue;
      }
      if ((localJMBase instanceof JMString))
      {
        int i3 = m + 1;
        n = j;
        i1 = k;
        i2 = i3;
        continue;
        if (k > 1)
          throw new JMFatalException("We don't handle multiple types of child lists in the same list.");
        if (j > 1)
          throw new JMFatalException("We don't handle multiple types of child dictionaries in the same list.");
        if (m > 1)
          throw new JMFatalException("We don't handle multiple types of strings in the same list.");
        this.g = paramSet;
        this.h = paramInt1;
        this.i = paramInt2;
        return;
      }
      n = j;
      i1 = k;
      i2 = m;
    }
  }

  public Set<JMBase> a()
  {
    return Collections.unmodifiableSet(this.g);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.types.JMList
 * JD-Core Version:    0.6.0
 */