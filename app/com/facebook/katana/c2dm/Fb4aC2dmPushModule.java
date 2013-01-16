package com.facebook.katana.c2dm;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.push.c2dm.C2DMPushHandler;

public class Fb4aC2dmPushModule extends AbstractModule
{
  protected void a()
  {
    a(FbandroidC2dmPushHandler.class).a(new Fb4aC2dmPushModule.FbandroidC2dmPushHandlerProvider(this, null)).a();
    c(C2DMPushHandler.class).a(FbandroidC2dmPushHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.c2dm.Fb4aC2dmPushModule
 * JD-Core Version:    0.6.0
 */