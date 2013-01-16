package com.facebook.orca.app;

import android.graphics.Rect;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.ObjectPoolBuilder;
import com.facebook.orca.common.util.ObjectPoolManager;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$ObjectPoolManagerProvider extends AbstractProvider<ObjectPoolManager>
{
  private FbBaseModule$ObjectPoolManagerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public ObjectPoolManager a()
  {
    ObjectPoolManager localObjectPoolManager = new ObjectPoolManager((Clock)b(SystemClock.class));
    localObjectPoolManager.a(Rect.class).a();
    return localObjectPoolManager;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.ObjectPoolManagerProvider
 * JD-Core Version:    0.6.0
 */