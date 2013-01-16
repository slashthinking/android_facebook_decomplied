package com.google.common.base;

class FinalizableReferenceQueue$DirectLoader
  implements FinalizableReferenceQueue.FinalizerLoader
{
  public Class<?> loadFinalizer()
  {
    try
    {
      Class localClass = Class.forName("com.google.common.base.internal.Finalizer");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new AssertionError(localClassNotFoundException);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.FinalizableReferenceQueue.DirectLoader
 * JD-Core Version:    0.6.2
 */