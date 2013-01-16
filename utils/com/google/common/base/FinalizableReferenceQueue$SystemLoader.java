package com.google.common.base;

import java.util.logging.Logger;

class FinalizableReferenceQueue$SystemLoader
  implements FinalizableReferenceQueue.FinalizerLoader
{
  public Class<?> loadFinalizer()
  {
    try
    {
      localClassLoader = ClassLoader.getSystemClassLoader();
      localObject = null;
      if (localClassLoader == null);
    }
    catch (SecurityException localSecurityException)
    {
      try
      {
        ClassLoader localClassLoader;
        Class localClass = localClassLoader.loadClass("com.google.common.base.internal.Finalizer");
        for (localObject = localClass; ; localObject = null)
        {
          return localObject;
          localSecurityException = localSecurityException;
          FinalizableReferenceQueue.access$000().info("Not allowed to access system class loader.");
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        while (true)
          Object localObject = null;
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.FinalizableReferenceQueue.SystemLoader
 * JD-Core Version:    0.6.2
 */