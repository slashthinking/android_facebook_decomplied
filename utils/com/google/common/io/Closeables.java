package com.google.common.io;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Closeables
{
  private static final Logger a = Logger.getLogger(Closeables.class.getName());

  public static void a(Closeable paramCloseable)
  {
    try
    {
      a(paramCloseable, true);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        a.log(Level.SEVERE, "IOException should not have been thrown.", localIOException);
    }
  }

  public static void a(Closeable paramCloseable, boolean paramBoolean)
  {
    if (paramCloseable == null);
    while (true)
    {
      return;
      try
      {
        paramCloseable.close();
      }
      catch (IOException localIOException)
      {
        if (paramBoolean)
        {
          a.log(Level.WARNING, "IOException thrown while closing Closeable.", localIOException);
          continue;
        }
        throw localIOException;
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.io.Closeables
 * JD-Core Version:    0.6.2
 */