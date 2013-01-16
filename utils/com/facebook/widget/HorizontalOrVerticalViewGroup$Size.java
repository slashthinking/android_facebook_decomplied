package com.facebook.widget;

import com.google.common.base.Joiner;

class HorizontalOrVerticalViewGroup$Size
{
  public final int a;
  public final int b;

  public HorizontalOrVerticalViewGroup$Size(HorizontalOrVerticalViewGroup paramHorizontalOrVerticalViewGroup, int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public String toString()
  {
    return Joiner.on("x").join(Integer.valueOf(this.a), Integer.valueOf(this.b), new Object[0]);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.HorizontalOrVerticalViewGroup.Size
 * JD-Core Version:    0.6.2
 */