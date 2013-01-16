package com.fasterxml.jackson.annotation;

public final class ObjectIdGenerators$IntSequenceGenerator extends ObjectIdGenerators.Base<Integer>
{
  protected int _nextValue;

  public ObjectIdGenerators$IntSequenceGenerator()
  {
    this(Object.class, -1);
  }

  public ObjectIdGenerators$IntSequenceGenerator(Class<?> paramClass, int paramInt)
  {
    super(paramClass);
    this._nextValue = paramInt;
  }

  public ObjectIdGenerator<Integer> forScope(Class<?> paramClass)
  {
    if (this._scope == paramClass);
    while (true)
    {
      return this;
      this = new IntSequenceGenerator(paramClass, this._nextValue);
    }
  }

  public Integer generateId(Object paramObject)
  {
    int i = this._nextValue;
    this._nextValue = (1 + this._nextValue);
    return Integer.valueOf(i);
  }

  protected int initialValue()
  {
    return 1;
  }

  public ObjectIdGenerator.IdKey key(Object paramObject)
  {
    return new ObjectIdGenerator.IdKey(getClass(), this._scope, paramObject);
  }

  public ObjectIdGenerator<Integer> newForSerialization(Object paramObject)
  {
    return new IntSequenceGenerator(this._scope, initialValue());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator
 * JD-Core Version:    0.6.0
 */