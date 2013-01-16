package com.google.common.base;

import java.io.Serializable;
import java.util.Collection;

class Predicates$InPredicate<T>
  implements Predicate<T>, Serializable
{
  private static final long serialVersionUID;
  private final Collection<?> target;

  private Predicates$InPredicate(Collection<?> paramCollection)
  {
    this.target = ((Collection)Preconditions.checkNotNull(paramCollection));
  }

  public boolean apply(T paramT)
  {
    try
    {
      boolean bool2 = this.target.contains(paramT);
      bool1 = bool2;
      return bool1;
    }
    catch (ClassCastException localClassCastException)
    {
      while (true)
        bool1 = false;
    }
    catch (NullPointerException localNullPointerException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  public boolean equals(Object paramObject)
  {
    InPredicate localInPredicate;
    if ((paramObject instanceof InPredicate))
      localInPredicate = (InPredicate)paramObject;
    for (boolean bool = this.target.equals(localInPredicate.target); ; bool = false)
      return bool;
  }

  public int hashCode()
  {
    return this.target.hashCode();
  }

  public String toString()
  {
    return "In(" + this.target + ")";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Predicates.InPredicate
 * JD-Core Version:    0.6.2
 */