package com.facebook.katana.activity.media;

import android.os.Handler;
import java.util.LinkedList;

class ImageGridPhotoManager$ImageLoaderThreadImpl extends Thread
  implements ImageLoaderThread
{
  private GridImageLoader b;
  private volatile ImageLoaderThread.WorkerThreadState c;

  public ImageGridPhotoManager$ImageLoaderThreadImpl(ImageGridPhotoManager paramImageGridPhotoManager, GridImageLoader paramGridImageLoader)
  {
    super("ImageLoaderThread");
    this.b = paramGridImageLoader;
  }

  public void a(ImageLoaderThread.WorkerThreadState paramWorkerThreadState)
  {
    this.c = paramWorkerThreadState;
  }

  public void run()
  {
    while (true)
    {
      Object localObject3;
      int i;
      if (this.c != ImageLoaderThread.WorkerThreadState.STATE_STOP)
        synchronized (ImageGridPhotoManager.a(this.a))
        {
          if (!ImageGridPhotoManager.b(this.a).isEmpty())
          {
            localObject3 = (BitmapHolder)ImageGridPhotoManager.b(this.a).removeFirst();
            i = 0;
            this.b.a((BitmapHolder)localObject3);
            if (this.c == ImageLoaderThread.WorkerThreadState.STATE_STOP)
              synchronized (ImageGridPhotoManager.a(this.a))
              {
                ImageGridPhotoManager.b(this.a).addFirst(localObject3);
              }
          }
          else if ((!ImageGridPhotoManager.c(this.a).isEmpty()) && (this.c != ImageLoaderThread.WorkerThreadState.STATE_NO_PRELOAD))
          {
            BitmapHolder localBitmapHolder = (BitmapHolder)ImageGridPhotoManager.c(this.a).removeFirst();
            localObject3 = localBitmapHolder;
            i = 1;
          }
        }
      try
      {
        if (ImageGridPhotoManager.b(this.a).isEmpty())
          ImageGridPhotoManager.d(this.a).sendEmptyMessage(2);
        ImageGridPhotoManager.a(this.a).wait();
        label193: monitorexit;
        continue;
        localObject2 = finally;
        monitorexit;
        throw localObject2;
        if ((!((BitmapHolder)localObject3).a()) || (i != 0))
          continue;
        synchronized (ImageGridPhotoManager.e(this.a))
        {
          ImageGridPhotoManager.e(this.a).addFirst(localObject3);
          ImageGridPhotoManager.d(this.a).sendEmptyMessage(1);
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label193;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.ImageGridPhotoManager.ImageLoaderThreadImpl
 * JD-Core Version:    0.6.0
 */