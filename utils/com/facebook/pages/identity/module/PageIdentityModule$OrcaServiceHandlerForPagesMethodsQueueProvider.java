package com.facebook.pages.identity.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.pages.identity.service.PageIdentityServiceHandler;

class PageIdentityModule$OrcaServiceHandlerForPagesMethodsQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private PageIdentityModule$OrcaServiceHandlerForPagesMethodsQueueProvider(PageIdentityModule paramPageIdentityModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(PageIdentityServiceHandler.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.module.PageIdentityModule.OrcaServiceHandlerForPagesMethodsQueueProvider
 * JD-Core Version:    0.6.2
 */