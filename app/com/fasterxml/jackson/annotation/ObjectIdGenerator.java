package com.fasterxml.jackson.annotation;

public abstract class ObjectIdGenerator<T>
{
  public abstract boolean canUseFor(ObjectIdGenerator<?> paramObjectIdGenerator);

  public abstract ObjectIdGenerator<T> forScope(Class<?> paramClass);

  public abstract T generateId(Object paramObject);

  public abstract Class<?> getScope();

  public abstract ObjectIdGenerator.IdKey key(Object paramObject);

  public abstract ObjectIdGenerator<T> newForSerialization(Object paramObject);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.ObjectIdGenerator
 * JD-Core Version:    0.6.0
 */