package com.facebook.dex_tricks;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

class DexLibLoader$FileLocker
{
  private final File a;
  private FileOutputStream b;
  private FileLock c;

  private DexLibLoader$FileLocker(File paramFile)
  {
    this.a = paramFile;
  }

  static FileLocker a(File paramFile)
  {
    FileLocker localFileLocker = new FileLocker(paramFile);
    localFileLocker.b();
    return localFileLocker;
  }

  private void b()
  {
    this.b = new FileOutputStream(this.a);
    FileChannel localFileChannel = this.b.getChannel();
    while (true)
    {
      FileLock localFileLock = localFileChannel.tryLock();
      this.c = localFileLock;
      if (localFileLock != null)
        break;
      Thread.sleep(100L);
    }
  }

  void a()
  {
    this.c.release();
    this.b.close();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.dex_tricks.DexLibLoader.FileLocker
 * JD-Core Version:    0.6.0
 */