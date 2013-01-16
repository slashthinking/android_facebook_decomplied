package com.facebook.orca.inject;

import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.google.inject.Key;
import javax.inject.Provider;

public class ProvisioningDebugStackProvider<T>
  implements Provider<T>
{
  private final Key<T> a;
  private final Provider<T> b;

  public ProvisioningDebugStackProvider(Key<T> paramKey, Provider<T> paramProvider)
  {
    this.a = paramKey;
    this.b = paramProvider;
  }

  public T b()
  {
    ProvisioningDebugStack.a(ProvisioningDebugStack.StackType.INSTANCE_GET, this.a);
    if (BLog.b(2));
    for (Tracer localTracer = Tracer.a("Provider.get " + this.a); ; localTracer = null)
      try
      {
        Object localObject2 = this.b.b();
        return localObject2;
      }
      finally
      {
        if (localTracer != null)
          localTracer.a(10L);
        ProvisioningDebugStack.a();
      }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ProvisioningDebugStackProvider
 * JD-Core Version:    0.6.0
 */