package com.google.common.io;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ByteStreams
{
  public static long a(InputSupplier<? extends InputStream> paramInputSupplier, OutputSupplier<? extends OutputStream> paramOutputSupplier)
  {
    boolean bool = true;
    InputStream localInputStream = (InputStream)paramInputSupplier.b();
    try
    {
      OutputStream localOutputStream = (OutputStream)paramOutputSupplier.b();
      try
      {
        long l = a(localInputStream, localOutputStream);
        bool = false;
        Closeables.a(localOutputStream, false);
        Closeables.a(localInputStream, false);
        return l;
      }
      finally
      {
      }
    }
    finally
    {
      Closeables.a(localInputStream, bool);
    }
  }

  public static long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L; ; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return l;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }

  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    a(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (b(paramInputStream, paramArrayOfByte, paramInt1, paramInt2) != paramInt2)
      throw new EOFException();
  }

  public static byte[] a(InputSupplier<? extends InputStream> paramInputSupplier)
  {
    InputStream localInputStream = (InputStream)paramInputSupplier.b();
    try
    {
      byte[] arrayOfByte = a(localInputStream);
      Closeables.a(localInputStream, false);
      return arrayOfByte;
    }
    finally
    {
      Closeables.a(localInputStream, true);
    }
  }

  public static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }

  public static int b(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0)
      throw new IndexOutOfBoundsException("len is negative");
    int i = 0;
    while (true)
    {
      int j;
      if (i < paramInt2)
      {
        j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        if (j != -1);
      }
      else
      {
        return i;
      }
      i += j;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.io.ByteStreams
 * JD-Core Version:    0.6.2
 */