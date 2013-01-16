package com.facebook.orca.photos.sizing;

import android.graphics.Bitmap;
import com.facebook.orca.images.UrlImageProcessor;

class GraphicSizerFactory$1 extends UrlImageProcessor
{
  private GraphicSizer d;

  GraphicSizerFactory$1(GraphicSizerFactory paramGraphicSizerFactory, GraphicOpConstraints paramGraphicOpConstraints)
  {
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    this.d = new GraphicSizer(this.b, paramBitmap.getWidth(), paramBitmap.getHeight());
    return this.d.a(paramBitmap);
  }

  public String a()
  {
    return this.b.h();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.sizing.GraphicSizerFactory.1
 * JD-Core Version:    0.6.2
 */