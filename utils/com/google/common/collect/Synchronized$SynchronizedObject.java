package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Synchronized$SynchronizedObject
  implements Serializable
{
  private static final long serialVersionUID;
  final Object delegate;
  final Object mutex;

  Synchronized$SynchronizedObject(Object paramObject1, Object paramObject2)
  {
    this.delegate = Preconditions.checkNotNull(paramObject1);
    if (paramObject2 == null)
      paramObject2 = this;
    this.mutex = paramObject2;
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    synchronized (this.mutex)
    {
      paramObjectOutputStream.defaultWriteObject();
      return;
    }
  }

  Object c()
  {
    return this.delegate;
  }

  public String toString()
  {
    synchronized (this.mutex)
    {
      String str = this.delegate.toString();
      return str;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedObject
 * JD-Core Version:    0.6.2
 */