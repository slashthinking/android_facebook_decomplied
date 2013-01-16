package com.fasterxml.jackson.annotation;

abstract class ObjectIdGenerators$Base<T> extends ObjectIdGenerator<T>
{
  protected final Class<?> _scope;

  protected ObjectIdGenerators$Base(Class<?> paramClass)
  {
    this._scope = paramClass;
  }

  public boolean canUseFor(ObjectIdGenerator<?> paramObjectIdGenerator)
  {
    if ((paramObjectIdGenerator.getClass() == getClass()) && (paramObjectIdGenerator.getScope() == this._scope));
    for (int i = 1; ; i = 0)
      return i;
  }

  public abstract T generateId(Object paramObject);

  public final Class<?> getScope()
  {
    return this._scope;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.ObjectIdGenerators.Base
 * JD-Core Version:    0.6.0
 */