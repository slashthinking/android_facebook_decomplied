package com.facebook.orca.media;

import com.google.common.base.Preconditions;
import com.google.common.io.InputSupplier;
import java.io.InputStream;

class MediaCache$MyInputSupplier
  implements InputSupplier<InputStream>
{
  private final InputStream a;
  private boolean b;

  private MediaCache$MyInputSupplier(InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }

  public InputStream a()
  {
    boolean bool = true;
    try
    {
      if (!this.b)
      {
        Preconditions.checkState(bool);
        this.b = true;
        InputStream localInputStream = this.a;
        return localInputStream;
      }
      bool = false;
    }
    finally
    {
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaCache.MyInputSupplier
 * JD-Core Version:    0.6.2
 */