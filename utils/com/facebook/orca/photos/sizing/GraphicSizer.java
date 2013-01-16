package com.facebook.orca.photos.sizing;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class GraphicSizer
  implements GraphicOp
{
  private final GraphicOpConstraints a;
  private final int b;
  private final int c;
  private List<GraphicOp> d;
  private int e;
  private int f;

  public GraphicSizer(GraphicOpConstraints paramGraphicOpConstraints, int paramInt1, int paramInt2)
  {
    this.a = paramGraphicOpConstraints;
    this.b = paramInt1;
    this.c = paramInt2;
    a(paramInt1, paramInt2);
  }

  private void a(int paramInt1, int paramInt2)
  {
    this.d = Lists.a();
    Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
    a(this.d, localRect);
    b(this.d, localRect);
    this.e = localRect.width();
    this.f = localRect.height();
  }

  private void a(List<GraphicOp> paramList, Rect paramRect)
  {
    if ((this.a.g()) && (paramRect.width() <= this.a.e()) && (paramRect.height() <= this.a.f()) && (paramRect.width() >= this.a.c()) && (paramRect.height() >= this.a.d()));
    do
    {
      return;
      if (this.a.b() != null)
      {
        CropRegionRectConstraints localCropRegionRectConstraints = this.a.b();
        CropRectGraphicOp localCropRectGraphicOp = new CropRectGraphicOp(localCropRegionRectConstraints.a(), localCropRegionRectConstraints.b());
        localCropRectGraphicOp.a(paramRect);
        paramList.add(localCropRectGraphicOp);
      }
    }
    while (this.a.a() == null);
    CropRegionConstraints localCropRegionConstraints = this.a.a();
    if (paramRect.width() > paramRect.height())
    {
      float f4 = localCropRegionConstraints.a();
      float f5 = localCropRegionConstraints.b();
      float f6 = localCropRegionConstraints.c();
      if (localCropRegionConstraints.d() != null);
      for (CropRegionGraphicOp.CropType localCropType2 = localCropRegionConstraints.d(); ; localCropType2 = CropRegionGraphicOp.CropType.CENTER)
      {
        CropRegionGraphicOp localCropRegionGraphicOp2 = new CropRegionGraphicOp(f4, f5, f6, localCropType2, this.a.c(), this.a.d());
        localCropRegionGraphicOp2.a(paramRect);
        paramList.add(localCropRegionGraphicOp2);
        break;
      }
    }
    float f1 = localCropRegionConstraints.a();
    float f2 = localCropRegionConstraints.b();
    float f3 = localCropRegionConstraints.c();
    if (localCropRegionConstraints.d() != null);
    for (CropRegionGraphicOp.CropType localCropType1 = localCropRegionConstraints.d(); ; localCropType1 = CropRegionGraphicOp.CropType.TOP_OR_LEFT)
    {
      CropRegionGraphicOp localCropRegionGraphicOp1 = new CropRegionGraphicOp(f1, f2, f3, localCropType1, this.a.c(), this.a.d());
      localCropRegionGraphicOp1.a(paramRect);
      paramList.add(localCropRegionGraphicOp1);
      break;
    }
  }

  private void b(List<GraphicOp> paramList, Rect paramRect)
  {
    if ((paramRect.width() > this.a.e()) && (paramRect.height() > this.a.f()))
    {
      ScaleGraphicOp localScaleGraphicOp = new ScaleGraphicOp(this.a.e(), this.a.f());
      localScaleGraphicOp.a(paramRect);
      paramList.add(localScaleGraphicOp);
    }
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
      paramBitmap = ((GraphicOp)localIterator.next()).a(paramBitmap);
    return paramBitmap;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.sizing.GraphicSizer
 * JD-Core Version:    0.6.2
 */