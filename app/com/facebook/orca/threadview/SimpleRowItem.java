package com.facebook.orca.threadview;

public final class SimpleRowItem extends RowItem
{
  private final int a;

  public SimpleRowItem(int paramInt)
  {
    this.a = paramInt;
  }

  public int a()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      SimpleRowItem localSimpleRowItem = (SimpleRowItem)paramObject;
      if (this.a == localSimpleRowItem.a)
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    return this.a;
  }

  public String toString()
  {
    return "SimpleRowItem{msgType=" + this.a + '}';
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.SimpleRowItem
 * JD-Core Version:    0.6.0
 */