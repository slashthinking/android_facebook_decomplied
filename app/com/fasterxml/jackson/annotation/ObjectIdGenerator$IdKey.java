package com.fasterxml.jackson.annotation;

public final class ObjectIdGenerator$IdKey
{
  private final int hashCode;
  private final Object key;
  private final Class<?> scope;
  private final Class<?> type;

  public ObjectIdGenerator$IdKey(Class<?> paramClass1, Class<?> paramClass2, Object paramObject)
  {
    this.type = paramClass1;
    this.scope = paramClass2;
    this.key = paramObject;
    int i = paramObject.hashCode() + paramClass1.getName().hashCode();
    if (paramClass2 != null)
      i ^= paramClass2.getName().hashCode();
    this.hashCode = i;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (paramObject == this);
    while (true)
    {
      return i;
      if (paramObject == null)
      {
        i = 0;
        continue;
      }
      if (paramObject.getClass() != getClass())
      {
        i = 0;
        continue;
      }
      IdKey localIdKey = (IdKey)paramObject;
      if ((localIdKey.key.equals(this.key)) && (localIdKey.type == this.type) && (localIdKey.scope == this.scope))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    return this.hashCode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey
 * JD-Core Version:    0.6.0
 */