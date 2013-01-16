package com.google.common.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

class FinalizableReferenceQueue$DecoupledLoader
  implements FinalizableReferenceQueue.FinalizerLoader
{
  URL getBaseUrl()
  {
    String str1 = "com.google.common.base.internal.Finalizer".replace('.', '/') + ".class";
    URL localURL = getClass().getClassLoader().getResource(str1);
    if (localURL == null)
      throw new FileNotFoundException(str1);
    String str2 = localURL.toString();
    if (!str2.endsWith(str1))
      throw new IOException("Unsupported path style: " + str2);
    return new URL(localURL, str2.substring(0, str2.length() - str1.length()));
  }

  public Class<?> loadFinalizer()
  {
    try
    {
      Class localClass2 = newLoader(getBaseUrl()).loadClass("com.google.common.base.internal.Finalizer");
      localClass1 = localClass2;
      return localClass1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        FinalizableReferenceQueue.access$000().log(Level.WARNING, "Could not load Finalizer in its own class loader.Loading Finalizer in the current class loader instead. As a result, you will not be ableto garbage collect this class loader. To support reclaiming this class loader, eitherresolve the underlying issue, or move Google Collections to your system class path.", localException);
        Class localClass1 = null;
      }
    }
  }

  URLClassLoader newLoader(URL paramURL)
  {
    return new URLClassLoader(new URL[] { paramURL });
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.FinalizableReferenceQueue.DecoupledLoader
 * JD-Core Version:    0.6.2
 */