package com.facebook.orca.common.http;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SimulatedBatchRunner;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class OrcaHttpModule$SimulatedBatchRunnerProvider extends AbstractProvider<SimulatedBatchRunner>
{
  private OrcaHttpModule$SimulatedBatchRunnerProvider(OrcaHttpModule paramOrcaHttpModule)
  {
  }

  public SimulatedBatchRunner a()
  {
    return new SimulatedBatchRunner((SingleMethodRunner)b(SingleMethodRunner.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.SimulatedBatchRunnerProvider
 * JD-Core Version:    0.6.2
 */