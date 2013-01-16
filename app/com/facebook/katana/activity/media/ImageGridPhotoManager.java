package com.facebook.katana.activity.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.facebook.katana.model.MediaItem;
import com.google.common.collect.Lists;
import java.util.LinkedList;

public class ImageGridPhotoManager
  implements Handler.Callback
{
  private final LinkedList<BitmapHolder> a = Lists.b();
  private final LinkedList<BitmapHolder> b = Lists.b();
  private final LinkedList<BitmapHolder> c = Lists.b();
  private final Object d = new Object();
  private LruCache<String, BitmapHolder> e = new LruCache(500);
  private final int f = 6;
  private final int g = 16;
  private final int h = 21;
  private ImageLoadedCallback i = null;
  private GridImageLoader j;
  private ImageLoaderThread k = null;
  private Handler l = new Handler(this);
  private ImageGridAdapter<?> m;
  private int n = -1;
  private int o = -1;

  ImageGridPhotoManager(Context paramContext, GridImageLoader paramGridImageLoader)
  {
    this.j = paramGridImageLoader;
  }

  private void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.m.getCount()));
    while (true)
    {
      return;
      BitmapHolder localBitmapHolder = d((MediaItem)this.m.getItem(paramInt));
      if (localBitmapHolder.a())
        continue;
      this.b.addFirst(localBitmapHolder);
    }
  }

  private BitmapHolder d(MediaItem paramMediaItem)
  {
    BitmapHolder localBitmapHolder = (BitmapHolder)this.e.a(paramMediaItem.b());
    if (localBitmapHolder == null)
    {
      localBitmapHolder = new BitmapHolder(paramMediaItem);
      this.e.a(paramMediaItem.b(), localBitmapHolder);
    }
    return localBitmapHolder;
  }

  private void e()
  {
    if ((this.n == -1) || (this.o == -1));
    while (true)
    {
      return;
      synchronized (this.d)
      {
        this.b.clear();
        int i2;
        for (int i1 = 0; ; i1++)
        {
          i2 = 0;
          if (i1 >= 16)
            break;
          a(i1 + this.o);
        }
        while ((i2 < 6) && (i2 >= 0))
        {
          a(this.n - i2);
          i2++;
        }
        if (!this.b.isEmpty())
          this.d.notify();
      }
    }
  }

  private void f()
  {
    this.k.a(ImageLoaderThread.WorkerThreadState.STATE_RUN);
  }

  private void g()
  {
    if (this.k != null)
      this.k.a(ImageLoaderThread.WorkerThreadState.STATE_NO_PRELOAD);
  }

  private void h()
  {
    if (this.k != null)
      this.k.a(ImageLoaderThread.WorkerThreadState.STATE_STOP);
    synchronized (this.d)
    {
      this.d.notifyAll();
      this.k = null;
      return;
    }
  }

  private void i()
  {
    if (this.k == null)
    {
      this.k = new ImageGridPhotoManager.ImageLoaderThreadImpl(this, this.j);
      this.k.start();
    }
  }

  // ERROR //
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/facebook/katana/activity/media/ImageGridPhotoManager:c	Ljava/util/LinkedList;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 49	com/facebook/katana/activity/media/ImageGridPhotoManager:c	Ljava/util/LinkedList;
    //   11: invokevirtual 167	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   14: astore_3
    //   15: aload_3
    //   16: invokeinterface 172 1 0
    //   21: ifeq +56 -> 77
    //   24: aload_3
    //   25: invokeinterface 176 1 0
    //   30: checkcast 101	com/facebook/katana/activity/media/BitmapHolder
    //   33: astore 4
    //   35: aload_0
    //   36: getfield 66	com/facebook/katana/activity/media/ImageGridPhotoManager:i	Lcom/facebook/katana/activity/media/ImageLoadedCallback;
    //   39: ifnull -24 -> 15
    //   42: aload 4
    //   44: invokevirtual 104	com/facebook/katana/activity/media/BitmapHolder:a	()Z
    //   47: ifeq -32 -> 15
    //   50: aload_0
    //   51: getfield 66	com/facebook/katana/activity/media/ImageGridPhotoManager:i	Lcom/facebook/katana/activity/media/ImageLoadedCallback;
    //   54: aload 4
    //   56: invokevirtual 179	com/facebook/katana/activity/media/BitmapHolder:c	()Lcom/facebook/katana/model/MediaItem;
    //   59: aload 4
    //   61: invokevirtual 182	com/facebook/katana/activity/media/BitmapHolder:b	()Landroid/graphics/Bitmap;
    //   64: invokeinterface 187 3 0
    //   69: goto -54 -> 15
    //   72: astore_2
    //   73: aload_1
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    //   77: aload_0
    //   78: getfield 49	com/facebook/katana/activity/media/ImageGridPhotoManager:c	Ljava/util/LinkedList;
    //   81: invokevirtual 127	java/util/LinkedList:clear	()V
    //   84: aload_1
    //   85: monitorexit
    //   86: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	75	72	finally
    //   77	86	72	finally
  }

  void a()
  {
    h();
    this.j.a();
  }

  void a(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.o = paramInt2;
  }

  void a(ImageGridAdapter<?> paramImageGridAdapter)
  {
    this.m = paramImageGridAdapter;
  }

  void a(ImageLoadedCallback paramImageLoadedCallback)
  {
    this.i = paramImageLoadedCallback;
  }

  void a(MediaItem paramMediaItem)
  {
    d(paramMediaItem).a(null);
    c(paramMediaItem);
  }

  Bitmap b(MediaItem paramMediaItem)
  {
    return d(paramMediaItem).b();
  }

  void b()
  {
    i();
  }

  void c()
  {
    g();
  }

  void c(MediaItem paramMediaItem)
  {
    BitmapHolder localBitmapHolder = d(paramMediaItem);
    synchronized (this.d)
    {
      if (!this.a.contains(localBitmapHolder))
        this.a.addFirst(localBitmapHolder);
      if (this.a.size() > 21)
        this.a.removeLast();
      this.d.notify();
      i();
      return;
    }
  }

  void d()
  {
    f();
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return true;
      j();
      continue;
      e();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.ImageGridPhotoManager
 * JD-Core Version:    0.6.0
 */