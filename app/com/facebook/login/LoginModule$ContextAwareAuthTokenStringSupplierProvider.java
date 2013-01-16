package com.facebook.login;

import com.facebook.annotations.AuthTokenString;
import com.facebook.orca.inject.AbstractProvider;

class LoginModule$ContextAwareAuthTokenStringSupplierProvider extends AbstractProvider<ContextAwareAuthTokenStringSupplier>
{
  public ContextAwareAuthTokenStringSupplier a()
  {
    return new ContextAwareAuthTokenStringSupplier(a(String.class, AuthTokenString.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.login.LoginModule.ContextAwareAuthTokenStringSupplierProvider
 * JD-Core Version:    0.6.0
 */