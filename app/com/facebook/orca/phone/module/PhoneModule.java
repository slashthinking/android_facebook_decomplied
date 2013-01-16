package com.facebook.orca.phone.module;

import com.facebook.orca.annotations.IsIncallOutgoingEnabled;
import com.facebook.orca.annotations.IsIncallPermitted;
import com.facebook.orca.annotations.IsIncallPossible;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.phone.IsIncallOutgoingEnabledProvider;
import com.facebook.orca.phone.IsIncallPermittedProvider;
import com.facebook.orca.phone.IsIncallPossibleProvider;
import com.facebook.orca.phone.TelephonyReceiverWakeLockHolder;

public class PhoneModule extends AbstractModule
{
  protected void a()
  {
    a(TelephonyReceiverWakeLockHolder.class).a(new PhoneModule.TelephonyReceiverWakeLockHolderProvider(this, null)).a();
    a(Boolean.class).a(IsIncallOutgoingEnabled.class).c(IsIncallOutgoingEnabledProvider.class);
    a(Boolean.class).a(IsIncallPermitted.class).c(IsIncallPermittedProvider.class);
    a(Boolean.class).a(IsIncallPossible.class).c(IsIncallPossibleProvider.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.module.PhoneModule
 * JD-Core Version:    0.6.0
 */