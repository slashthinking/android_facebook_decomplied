package com.facebook.orca.server;

import java.util.Iterator;
import java.util.Set;

public class PreProcessingServiceHandler
  implements OrcaServiceHandler.Filter
{
  private final Set<OrcaServiceHandlerHook> a;

  public PreProcessingServiceHandler(Set<OrcaServiceHandlerHook> paramSet)
  {
    this.a = paramSet;
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((OrcaServiceHandlerHook)localIterator.next()).a();
    return localOperationResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.PreProcessingServiceHandler
 * JD-Core Version:    0.6.0
 */