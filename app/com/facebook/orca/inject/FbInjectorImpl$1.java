package com.facebook.orca.inject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.inject.Provider;

class FbInjectorImpl$1
  implements Provider<T>
{
  public T b()
  {
    try
    {
      Object localObject = this.a.newInstance((Object[])null);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new ProvisioningException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ProvisioningException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    throw new ProvisioningException(localInvocationTargetException);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.FbInjectorImpl.1
 * JD-Core Version:    0.6.0
 */