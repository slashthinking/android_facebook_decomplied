package com.facebook.orca.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.facebook.orca.debug.BLog;
import java.io.FileDescriptor;
import java.util.WeakHashMap;

public class BitmapManager
{
  private static final Class<?> a = BitmapManager.class;
  private static BitmapManager c = null;
  private final WeakHashMap<Thread, BitmapManager.ThreadStatus> b = new WeakHashMap();

  public static BitmapManager a()
  {
    monitorenter;
    try
    {
      if (c == null)
        c = new BitmapManager();
      BitmapManager localBitmapManager = c;
      monitorexit;
      return localBitmapManager;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private void a(Thread paramThread, BitmapFactory.Options paramOptions)
  {
    monitorenter;
    try
    {
      c(paramThread).b = paramOptions;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private BitmapManager.ThreadStatus c(Thread paramThread)
  {
    monitorenter;
    try
    {
      BitmapManager.ThreadStatus localThreadStatus = (BitmapManager.ThreadStatus)this.b.get(paramThread);
      if (localThreadStatus == null)
      {
        localThreadStatus = new BitmapManager.ThreadStatus(null);
        this.b.put(paramThread, localThreadStatus);
      }
      monitorexit;
      return localThreadStatus;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public Bitmap a(FileDescriptor paramFileDescriptor, BitmapFactory.Options paramOptions)
  {
    boolean bool = paramOptions.mCancel;
    Bitmap localBitmap = null;
    if (bool);
    while (true)
    {
      return localBitmap;
      Thread localThread = Thread.currentThread();
      if (!b(localThread))
      {
        BLog.b(a, "Thread " + localThread + " is not allowed to decode.");
        localBitmap = null;
        continue;
      }
      a(localThread, paramOptions);
      localBitmap = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, paramOptions);
      a(localThread);
    }
  }

  void a(Thread paramThread)
  {
    monitorenter;
    try
    {
      ((BitmapManager.ThreadStatus)this.b.get(paramThread)).b = null;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean b(Thread paramThread)
  {
    int i = 1;
    monitorenter;
    try
    {
      BitmapManager.ThreadStatus localThreadStatus = (BitmapManager.ThreadStatus)this.b.get(paramThread);
      if (localThreadStatus == null)
        return i;
      BitmapManager.State localState1 = localThreadStatus.a;
      BitmapManager.State localState2 = BitmapManager.State.CANCEL;
      if (localState1 != localState2);
      for (int j = i; ; j = 0)
      {
        i = j;
        break;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.BitmapManager
 * JD-Core Version:    0.6.0
 */