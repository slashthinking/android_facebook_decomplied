package com.google.common.base;

import java.io.Serializable;

class Functions$ConstantFunction<E>
  implements Function<Object, E>, Serializable
{
  private static final long serialVersionUID;
  private final E value;

  public Functions$ConstantFunction(E paramE)
  {
    this.value = paramE;
  }

  public E apply(Object paramObject)
  {
    return this.value;
  }

  public boolean equals(Object paramObject)
  {
    ConstantFunction localConstantFunction;
    if ((paramObject instanceof ConstantFunction))
      localConstantFunction = (ConstantFunction)paramObject;
    for (boolean bool = Objects.equal(this.value, localConstantFunction.value); ; bool = false)
      return bool;
  }

  public int hashCode()
  {
    if (this.value == null);
    for (int i = 0; ; i = this.value.hashCode())
      return i;
  }

  public String toString()
  {
    return "constant(" + this.value + ")";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Functions.ConstantFunction
 * JD-Core Version:    0.6.2
 */