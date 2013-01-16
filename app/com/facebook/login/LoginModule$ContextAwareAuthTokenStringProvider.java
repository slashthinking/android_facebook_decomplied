package com.facebook.login;

import com.facebook.orca.inject.AbstractProvider;

class LoginModule$ContextAwareAuthTokenStringProvider extends AbstractProvider<String>
{
  public String a()
  {
    return ((ContextAwareAuthTokenStringSupplier)b(ContextAwareAuthTokenStringSupplier.class)).b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.login.LoginModule.ContextAwareAuthTokenStringProvider
 * JD-Core Version:    0.6.0
 */