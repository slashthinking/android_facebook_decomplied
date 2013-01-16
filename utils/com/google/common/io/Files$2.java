package com.google.common.io;

import java.io.File;
import java.io.FileOutputStream;

final class Files$2
  implements OutputSupplier<FileOutputStream>
{
  Files$2(File paramFile, boolean paramBoolean)
  {
  }

  public FileOutputStream a()
  {
    return new FileOutputStream(this.a, this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.io.Files.2
 * JD-Core Version:    0.6.2
 */