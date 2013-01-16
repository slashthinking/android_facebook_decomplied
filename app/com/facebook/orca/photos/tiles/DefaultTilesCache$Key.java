package com.facebook.orca.photos.tiles;

public class DefaultTilesCache$Key
{
  private final DefaultTilesCache.Type a;
  private final int b;
  private final int c;
  private final int d;

  public DefaultTilesCache$Key(DefaultTilesCache.Type paramType, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramType;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
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
      Key localKey = (Key)paramObject;
      if (this.b != localKey.b)
      {
        i = 0;
        continue;
      }
      if (this.c != localKey.c)
      {
        i = 0;
        continue;
      }
      if (this.d != localKey.d)
      {
        i = 0;
        continue;
      }
      if (this.a == localKey.a)
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * this.a.hashCode() + this.b) + this.c) + this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.tiles.DefaultTilesCache.Key
 * JD-Core Version:    0.6.0
 */