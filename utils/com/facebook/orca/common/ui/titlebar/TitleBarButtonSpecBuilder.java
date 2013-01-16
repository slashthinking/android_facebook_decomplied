package com.facebook.orca.common.ui.titlebar;

import android.graphics.drawable.Drawable;

public class TitleBarButtonSpecBuilder
{
  private int a;
  private Drawable b;
  private boolean c;
  private boolean d;
  private boolean e;
  private String f;
  private String g;
  private int h = -1;

  public int a()
  {
    return this.a;
  }

  public TitleBarButtonSpecBuilder a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }

  public TitleBarButtonSpecBuilder a(Drawable paramDrawable)
  {
    this.b = paramDrawable;
    return this;
  }

  public TitleBarButtonSpecBuilder a(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public Drawable b()
  {
    return this.b;
  }

  public TitleBarButtonSpecBuilder b(int paramInt)
  {
    this.h = paramInt;
    return this;
  }

  public TitleBarButtonSpecBuilder b(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public boolean c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.d;
  }

  public boolean e()
  {
    return this.e;
  }

  public String f()
  {
    return this.f;
  }

  public int g()
  {
    return this.h;
  }

  public String h()
  {
    return this.g;
  }

  public TitleBarButtonSpec i()
  {
    return new TitleBarButtonSpec(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder
 * JD-Core Version:    0.6.2
 */