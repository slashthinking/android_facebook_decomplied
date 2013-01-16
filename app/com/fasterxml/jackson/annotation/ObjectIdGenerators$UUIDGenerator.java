package com.fasterxml.jackson.annotation;

import java.util.UUID;

public final class ObjectIdGenerators$UUIDGenerator extends ObjectIdGenerators.Base<UUID>
{
  public ObjectIdGenerators$UUIDGenerator()
  {
    this(Object.class);
  }

  private ObjectIdGenerators$UUIDGenerator(Class<?> paramClass)
  {
    super(Object.class);
  }

  public boolean canUseFor(ObjectIdGenerator<?> paramObjectIdGenerator)
  {
    if (paramObjectIdGenerator.getClass() == getClass());
    for (int i = 1; ; i = 0)
      return i;
  }

  public ObjectIdGenerator<UUID> forScope(Class<?> paramClass)
  {
    return this;
  }

  public UUID generateId(Object paramObject)
  {
    return UUID.randomUUID();
  }

  public ObjectIdGenerator.IdKey key(Object paramObject)
  {
    return new ObjectIdGenerator.IdKey(getClass(), null, paramObject);
  }

  public ObjectIdGenerator<UUID> newForSerialization(Object paramObject)
  {
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator
 * JD-Core Version:    0.6.0
 */