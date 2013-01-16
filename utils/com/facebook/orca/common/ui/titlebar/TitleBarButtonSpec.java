package com.facebook.orca.common.ui.titlebar;

import android.graphics.drawable.Drawable;

public class TitleBarButtonSpec
{
  private final int a;
  private final Drawable b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  private final String f;
  private final int g;
  private final String h;
  private boolean i;

  public TitleBarButtonSpec(TitleBarButtonSpecBuilder paramTitleBarButtonSpecBuilder)
  {
    this.a = paramTitleBarButtonSpecBuilder.a();
    this.b = paramTitleBarButtonSpecBuilder.b();
    this.c = paramTitleBarButtonSpecBuilder.c();
    this.d = paramTitleBarButtonSpecBuilder.d();
    this.e = paramTitleBarButtonSpecBuilder.e();
    this.f = paramTitleBarButtonSpecBuilder.f();
    this.g = paramTitleBarButtonSpecBuilder.g();
    this.h = paramTitleBarButtonSpecBuilder.h();
  }

  public static TitleBarButtonSpecBuilder newBuilder()
  {
    return new TitleBarButtonSpecBuilder();
  }

  public int a()
  {
    return this.a;
  }

  void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public Drawable b()
  {
    return this.b;
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
    return this.i;
  }

  public boolean f()
  {
    return this.e;
  }

  public String g()
  {
    return this.f;
  }

  public int h()
  {
    return this.g;
  }

  public String i()
  {
    return this.h;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec
 * JD-Core Version:    0.6.2
 */