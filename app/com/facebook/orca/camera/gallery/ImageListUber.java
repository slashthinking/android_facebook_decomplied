package com.facebook.orca.camera.gallery;

import android.net.Uri;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ImageListUber
  implements IImageList
{
  private static final Class<?> a = ImageListUber.class;
  private final IImageList[] b;
  private final PriorityQueue<ImageListUber.MergeSlot> c;
  private long[] d;
  private int e;
  private int[] f;
  private int g;

  public ImageListUber(IImageList[] paramArrayOfIImageList, int paramInt)
  {
    this.b = ((IImageList[])paramArrayOfIImageList.clone());
    if (paramInt == 1);
    for (Object localObject = new ImageListUber.AscendingComparator(null); ; localObject = new ImageListUber.DescendingComparator(null))
    {
      this.c = new PriorityQueue(4, (Comparator)localObject);
      this.d = new long[16];
      this.e = 0;
      this.f = new int[this.b.length];
      this.g = -1;
      this.c.clear();
      int i = this.b.length;
      for (int j = 0; j < i; j++)
      {
        ImageListUber.MergeSlot localMergeSlot = new ImageListUber.MergeSlot(this.b[j], j);
        if (!localMergeSlot.a())
          continue;
        this.c.add(localMergeSlot);
      }
    }
  }

  private ImageListUber.MergeSlot c()
  {
    ImageListUber.MergeSlot localMergeSlot = (ImageListUber.MergeSlot)this.c.poll();
    if (localMergeSlot == null)
      localMergeSlot = null;
    while (true)
    {
      return localMergeSlot;
      if (localMergeSlot.a == this.g)
      {
        int j = -1 + this.e;
        long[] arrayOfLong3 = this.d;
        arrayOfLong3[j] = (1L + arrayOfLong3[j]);
        continue;
      }
      this.g = localMergeSlot.a;
      if (this.d.length == this.e)
      {
        long[] arrayOfLong2 = new long[2 * this.e];
        System.arraycopy(this.d, 0, arrayOfLong2, 0, this.e);
        this.d = arrayOfLong2;
      }
      long[] arrayOfLong1 = this.d;
      int i = this.e;
      this.e = (i + 1);
      arrayOfLong1[i] = (1L | this.g << 32);
    }
  }

  public IImage a(int paramInt)
  {
    int i = 0;
    if ((paramInt < 0) || (paramInt > b()))
      throw new IndexOutOfBoundsException("index " + paramInt + " out of range max is " + b());
    Arrays.fill(this.f, 0);
    int j = this.e;
    int k = 0;
    int m;
    int n;
    IImage localIImage;
    if (k < j)
    {
      long l = this.d[k];
      m = (int)(0xFFFFFFFF & l);
      n = (int)(l >> 32);
      if (i + m > paramInt)
      {
        int i2 = this.f[n] + (paramInt - i);
        localIImage = this.b[n].a(i2);
      }
    }
    while (true)
    {
      return localIImage;
      int i1 = i + m;
      int[] arrayOfInt = this.f;
      arrayOfInt[n] = (m + arrayOfInt[n]);
      k++;
      i = i1;
      break;
      Object localObject;
      do
      {
        if (((ImageListUber.MergeSlot)localObject).a())
          this.c.add(localObject);
        i++;
        localObject = c();
        if (localObject != null)
          continue;
        localIImage = null;
        break;
      }
      while (i != paramInt);
      localIImage = ((ImageListUber.MergeSlot)localObject).c;
      if (!((ImageListUber.MergeSlot)localObject).a())
        continue;
      this.c.add(localObject);
    }
  }

  public IImage a(Uri paramUri)
  {
    IImageList[] arrayOfIImageList = this.b;
    int i = arrayOfIImageList.length;
    int j = 0;
    IImage localIImage;
    if (j < i)
    {
      localIImage = arrayOfIImageList[j].a(paramUri);
      if (localIImage == null);
    }
    while (true)
    {
      return localIImage;
      j++;
      break;
      localIImage = null;
    }
  }

  public void a()
  {
    int i = 0;
    int j = this.b.length;
    while (i < j)
    {
      this.b[i].a();
      i++;
    }
  }

  public int b()
  {
    int i = 0;
    IImageList[] arrayOfIImageList = this.b;
    int j = arrayOfIImageList.length;
    int k = 0;
    while (i < j)
    {
      k += arrayOfIImageList[i].b();
      i++;
    }
    return k;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.gallery.ImageListUber
 * JD-Core Version:    0.6.0
 */