package com.facebook.orca.app;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.login.AbstractAuthComponent;
import java.util.Iterator;
import java.util.Set;

public class FbAppUserDataCleaner extends AbstractAuthComponent
{
  private final Class<?> a = FbAppUserDataCleaner.class;
  private final AndroidThreadUtil b;
  private final Set<IHaveUserData> c;

  public FbAppUserDataCleaner(AndroidThreadUtil paramAndroidThreadUtil, Set<IHaveUserData> paramSet)
  {
    this.b = paramAndroidThreadUtil;
    this.c = paramSet;
  }

  public void b()
  {
    this.b.b();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
      ((IHaveUserData)localIterator.next()).f();
    BLog.c(this.a, "User data is cleared successfully.");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbAppUserDataCleaner
 * JD-Core Version:    0.6.0
 */