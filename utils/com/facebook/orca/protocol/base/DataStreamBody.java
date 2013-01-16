package com.facebook.orca.protocol.base;

import com.google.common.io.ByteStreams;
import com.google.common.io.Closeables;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

public class DataStreamBody extends ContentBody
{
  private final File a;

  public DataStreamBody(File paramFile, String paramString1, String paramString2)
  {
    super(paramString1, (int)paramFile.length(), paramString2);
    this.a = paramFile;
  }

  public void a(OutputStream paramOutputStream)
  {
    FileInputStream localFileInputStream = new FileInputStream(this.a);
    try
    {
      ByteStreams.a(localFileInputStream, paramOutputStream);
      return;
    }
    finally
    {
      Closeables.a(localFileInputStream);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.DataStreamBody
 * JD-Core Version:    0.6.2
 */