package com.facebook.orca.inject;

import android.content.Context;
import com.facebook.base.PropertyBag;
import javax.inject.Provider;

class ContextScopedProvider<T>
  implements Provider<T>
{
  private final ContextScope a;
  private final Provider<T> b;

  ContextScopedProvider(ContextScope paramContextScope, Provider<T> paramProvider)
  {
    this.a = paramContextScope;
    this.b = paramProvider;
  }

  public T b()
  {
    Context localContext = this.a.getContext();
    if (localContext == null)
      throw new ProvisioningException("Called context scoped provider outside of context scope");
    if (!(localContext instanceof PropertyBag))
      throw new ProvisioningException("Context must support PropertyBag interface");
    PropertyBag localPropertyBag = (PropertyBag)localContext;
    monitorenter;
    try
    {
      Object localObject2 = localPropertyBag.a(this);
      if (localObject2 == null)
      {
        localObject2 = this.b.b();
        localPropertyBag.a(this, localObject2);
      }
      Object localObject3 = localObject2;
      monitorexit;
      return localObject3;
    }
    finally
    {
      localObject1 = finally;
      monitorexit;
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ContextScopedProvider
 * JD-Core Version:    0.6.0
 */