package com.facebook.orca.ops;

import android.content.Context;
import android.os.Bundle;
import com.facebook.orca.activity.DisposableContext;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.google.common.base.Preconditions;

public class OrcaServiceOperationFactory
{
  private final Context a;
  private final OrcaServiceRegistry b;
  private final AndroidThreadUtil c;

  public OrcaServiceOperationFactory(Context paramContext, OrcaServiceRegistry paramOrcaServiceRegistry, AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.a = paramContext;
    this.b = paramOrcaServiceRegistry;
    this.c = paramAndroidThreadUtil;
  }

  public OrcaServiceOperationFactory.OrcaServiceOperation a(String paramString, Bundle paramBundle)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramBundle);
    OrcaServiceOperationFactory.OrcaServiceOperation localOrcaServiceOperation = new OrcaServiceOperationFactory.OrcaServiceOperation(paramString, paramBundle, this.a, this.b, this.c);
    if ((this.a instanceof DisposableContext))
      ((DisposableContext)this.a).a(OrcaServiceOperationFactory.OrcaServiceOperation.a(localOrcaServiceOperation));
    return localOrcaServiceOperation;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.OrcaServiceOperationFactory
 * JD-Core Version:    0.6.0
 */