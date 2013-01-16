package com.google.common.base;

import java.io.Serializable;

class Predicates$NotPredicate<T>
  implements Predicate<T>, Serializable
{
  private static final long serialVersionUID;
  final Predicate<T> predicate;

  Predicates$NotPredicate(Predicate<T> paramPredicate)
  {
    this.predicate = ((Predicate)Preconditions.checkNotNull(paramPredicate));
  }

  public boolean apply(T paramT)
  {
    if (!this.predicate.apply(paramT));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean equals(Object paramObject)
  {
    NotPredicate localNotPredicate;
    if ((paramObject instanceof NotPredicate))
      localNotPredicate = (NotPredicate)paramObject;
    for (boolean bool = this.predicate.equals(localNotPredicate.predicate); ; bool = false)
      return bool;
  }

  public int hashCode()
  {
    return 0xFFFFFFFF ^ this.predicate.hashCode();
  }

  public String toString()
  {
    return "Not(" + this.predicate.toString() + ")";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Predicates.NotPredicate
 * JD-Core Version:    0.6.2
 */