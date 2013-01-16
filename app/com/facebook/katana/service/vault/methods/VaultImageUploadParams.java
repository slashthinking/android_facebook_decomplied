package com.facebook.katana.service.vault.methods;

import android.util.Pair;
import com.facebook.katana.provider.VaultImageProvider;
import com.facebook.orca.protocol.base.CountingOutputStreamWithProgress.ProgressListener;
import java.io.File;

public class VaultImageUploadParams
{
  private final File a;
  private final String b;
  private final String c;
  private final long d;
  private final CountingOutputStreamWithProgress.ProgressListener e;

  public VaultImageUploadParams(File paramFile, String paramString1, String paramString2, long paramLong, CountingOutputStreamWithProgress.ProgressListener paramProgressListener)
  {
    this.a = paramFile;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramLong;
    this.e = paramProgressListener;
  }

  public File a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public long d()
  {
    return this.d;
  }

  public CountingOutputStreamWithProgress.ProgressListener e()
  {
    return this.e;
  }

  public String f()
  {
    return Integer.toString((int)(((Long)VaultImageProvider.a(this.b).second).longValue() / 1000L));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultImageUploadParams
 * JD-Core Version:    0.6.0
 */