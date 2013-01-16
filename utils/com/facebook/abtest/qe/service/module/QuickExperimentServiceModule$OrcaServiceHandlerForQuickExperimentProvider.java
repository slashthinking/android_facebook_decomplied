package com.facebook.abtest.qe.service.module;

import com.facebook.abtest.qe.service.QuickExperimentDbServiceHandler;
import com.facebook.abtest.qe.service.QuickExperimentSyncServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.FilterChainLink;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;

class QuickExperimentServiceModule$OrcaServiceHandlerForQuickExperimentProvider extends AbstractProvider<OrcaServiceHandler>
{
  private QuickExperimentServiceModule$OrcaServiceHandlerForQuickExperimentProvider(QuickExperimentServiceModule paramQuickExperimentServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return new FilterChainLink((OrcaServiceHandler.Filter)b(QuickExperimentDbServiceHandler.class), (OrcaServiceHandler)b(QuickExperimentSyncServiceHandler.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.service.module.QuickExperimentServiceModule.OrcaServiceHandlerForQuickExperimentProvider
 * JD-Core Version:    0.6.2
 */