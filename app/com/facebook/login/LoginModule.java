package com.facebook.login;

import com.facebook.annotations.AuthTokenString;
import com.facebook.annotations.ContextAwareAuthTokenString;
import com.facebook.annotations.IsMeUserAnEmployee;
import com.facebook.annotations.IsMeUserFb4aDeveloper;
import com.facebook.annotations.IsMeUserTrustedTester;
import com.facebook.common.util.TriState;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.RequiredBindingThrowingProvider;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class LoginModule extends AbstractModule
{
  protected void a()
  {
    a(Integer.class).a(MeUserId.class).a(RequiredBindingThrowingProvider.a(Integer.class, MeUserId.class));
    a(String.class).a(AuthTokenString.class).a(RequiredBindingThrowingProvider.a(String.class, AuthTokenString.class));
    a(TriState.class).a(IsMeUserAnEmployee.class).a(TriState.UNSET);
    a(TriState.class).a(IsMeUserFb4aDeveloper.class).a(TriState.UNSET);
    a(TriState.class).a(IsMeUserTrustedTester.class).a(TriState.UNSET);
    a(ContextAwareAuthTokenStringSupplier.class).a(new LoginModule.ContextAwareAuthTokenStringSupplierProvider(null)).a();
    a(String.class).a(ContextAwareAuthTokenString.class).a(new LoginModule.ContextAwareAuthTokenStringProvider(null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.login.LoginModule
 * JD-Core Version:    0.6.0
 */