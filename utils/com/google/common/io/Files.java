package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

public final class Files
{
  public static InputSupplier<FileInputStream> a(File paramFile)
  {
    Preconditions.checkNotNull(paramFile);
    return new Files.1(paramFile);
  }

  public static OutputSupplier<FileOutputStream> a(File paramFile, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramFile);
    return new Files.2(paramFile, paramBoolean);
  }

  public static String a(File paramFile, Charset paramCharset)
  {
    return new String(c(paramFile), paramCharset.name());
  }

  public static void a(InputSupplier<? extends InputStream> paramInputSupplier, File paramFile)
  {
    ByteStreams.a(paramInputSupplier, b(paramFile));
  }

  public static OutputSupplier<FileOutputStream> b(File paramFile)
  {
    return a(paramFile, false);
  }

  public static byte[] c(File paramFile)
  {
    boolean bool;
    byte[] arrayOfByte;
    if (paramFile.length() <= 2147483647L)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      if (paramFile.length() != 0L)
        break label41;
      arrayOfByte = ByteStreams.a(a(paramFile));
    }
    while (true)
    {
      return arrayOfByte;
      bool = false;
      break;
      label41: arrayOfByte = new byte[(int)paramFile.length()];
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      try
      {
        ByteStreams.a(localFileInputStream, arrayOfByte);
        Closeables.a(localFileInputStream, false);
      }
      finally
      {
        Closeables.a(localFileInputStream, true);
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.io.Files
 * JD-Core Version:    0.6.2
 */