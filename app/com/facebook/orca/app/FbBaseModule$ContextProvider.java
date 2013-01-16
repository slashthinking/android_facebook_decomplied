package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.inject.ContextScope;
import com.facebook.orca.inject.ProvisioningException;
import com.facebook.orca.inject.ReflectionProviderPassThrough;
import com.facebook.orca.inject.SingletonProvider;
import com.facebook.orca.inject.ThreadLocalProvider;

class FbBaseModule$ContextProvider extends AbstractProvider<Context>
{
  private FbBaseModule$ContextProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public Context a()
  {
    if (SingletonProvider.a())
      throw new ProvisioningException("Should not call getContext in singleton creation. Can lead to memory leaks.");
    if (ReflectionProviderPassThrough.a())
      throw new ProvisioningException("Should not call getContext in provider creation. Can lead to memory leaks.");
    if (ThreadLocalProvider.a())
      throw new ProvisioningException("Should not call getContext in thread local creation. Can lead to memory leaks.");
    return FbBaseModule.a(this.a).getContext();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.ContextProvider
 * JD-Core Version:    0.6.0
 */