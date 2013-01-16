package com.facebook.common.util;

import android.content.Context;
import android.os.StatFs;
import com.google.common.base.Stopwatch;
import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StatFsHelper
{
  private Context a;
  private String b;
  private StatFs c;
  private Stopwatch d;
  private final Lock e = new ReentrantLock();

  public StatFsHelper(Context paramContext)
  {
    this.a = paramContext;
    this.b = this.a.getCacheDir().getAbsolutePath();
    this.c = new StatFs(this.b);
    this.d = new Stopwatch();
    this.d.reset().start();
  }

  private void a()
  {
    if (this.e.tryLock());
    try
    {
      if (this.d.elapsedMillis() > 600000L)
        b();
      return;
    }
    finally
    {
      this.e.unlock();
    }
    throw localObject;
  }

  private void b()
  {
    this.c.restat(this.b);
    this.d.reset().start();
  }

  public boolean a(long paramLong)
  {
    a();
    boolean bool = this.c.getBlockSize() * this.c.getAvailableBlocks() < paramLong;
    int i = 0;
    if (bool)
      i = 1;
    return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.StatFsHelper
 * JD-Core Version:    0.6.0
 */