package com.facebook.orca.app;

public class AppInitCompleteInitializer
  implements INeedInit
{
  private static final Class<?> a = AppInitCompleteInitializer.class;
  private final AppInitLock b;

  public AppInitCompleteInitializer(AppInitLock paramAppInitLock)
  {
    this.b = paramAppInitLock;
  }

  public void i_()
  {
    this.b.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.AppInitCompleteInitializer
 * JD-Core Version:    0.6.0
 */