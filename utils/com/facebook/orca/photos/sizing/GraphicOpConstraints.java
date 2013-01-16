package com.facebook.orca.photos.sizing;

import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.images.UrlImageProcessor;
import com.google.common.base.Joiner;

public class GraphicOpConstraints
{
  private final CropRegionConstraints a;
  private final CropRegionRectConstraints b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final boolean g;
  private final boolean h;
  private volatile String i;

  GraphicOpConstraints(GraphicOpConstraintsBuilder paramGraphicOpConstraintsBuilder)
  {
    this.a = paramGraphicOpConstraintsBuilder.e();
    this.b = paramGraphicOpConstraintsBuilder.f();
    this.c = paramGraphicOpConstraintsBuilder.a();
    this.d = paramGraphicOpConstraintsBuilder.b();
    this.e = paramGraphicOpConstraintsBuilder.c();
    this.f = paramGraphicOpConstraintsBuilder.d();
    this.g = paramGraphicOpConstraintsBuilder.g();
    this.h = paramGraphicOpConstraintsBuilder.h();
  }

  public CropRegionConstraints a()
  {
    return this.a;
  }

  public CropRegionRectConstraints b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }

  public int f()
  {
    return this.f;
  }

  public boolean g()
  {
    return this.h;
  }

  public String h()
  {
    String str1;
    if (this.g)
    {
      str1 = UrlImageProcessor.a;
      return str1;
    }
    Joiner localJoiner;
    String str2;
    label55: String str3;
    Object[] arrayOfObject;
    StringBuilder localStringBuilder2;
    if (this.i == null)
    {
      localJoiner = Joiner.on(":");
      StringBuilder localStringBuilder1 = new StringBuilder().append("(");
      if (this.a == null)
        break label210;
      str2 = this.a.e();
      str3 = str2 + ")";
      arrayOfObject = new Object[6];
      localStringBuilder2 = new StringBuilder().append("(");
      if (this.b == null)
        break label217;
    }
    label210: label217: for (String str4 = this.b.c(); ; str4 = "null")
    {
      arrayOfObject[0] = (str4 + ")");
      arrayOfObject[1] = Integer.valueOf(this.c);
      arrayOfObject[2] = Integer.valueOf(this.d);
      arrayOfObject[3] = Integer.valueOf(this.e);
      arrayOfObject[4] = Integer.valueOf(this.f);
      arrayOfObject[5] = Boolean.valueOf(this.h);
      this.i = Long.toString(StringUtil.e(localJoiner.join("3", str3, arrayOfObject)));
      str1 = this.i;
      break;
      str2 = "null";
      break label55;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.sizing.GraphicOpConstraints
 * JD-Core Version:    0.6.2
 */