package com.facebook.orca.protocol.base;

import java.io.File;
import java.io.OutputStream;

public class ProgressDataStreamBody extends DataStreamBody
{
  private final CountingOutputStreamWithProgress.ProgressListener a;

  public ProgressDataStreamBody(File paramFile, String paramString1, String paramString2, CountingOutputStreamWithProgress.ProgressListener paramProgressListener)
  {
    super(paramFile, paramString1, paramString2);
    this.a = paramProgressListener;
  }

  public void a(OutputStream paramOutputStream)
  {
    super.a(new CountingOutputStreamWithProgress(paramOutputStream, this.a));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ProgressDataStreamBody
 * JD-Core Version:    0.6.2
 */