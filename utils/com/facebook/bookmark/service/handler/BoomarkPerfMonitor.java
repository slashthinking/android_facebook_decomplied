package com.facebook.bookmark.service.handler;

import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;

public class BoomarkPerfMonitor
  implements OrcaServiceHandler.Filter
{
  private final PerformanceLogger a;

  public BoomarkPerfMonitor(PerformanceLogger paramPerformanceLogger)
  {
    this.a = paramPerformanceLogger;
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    this.a.a(paramOperationParams.a());
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    this.a.b(paramOperationParams.a());
    return localOperationResult;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.handler.BoomarkPerfMonitor
 * JD-Core Version:    0.6.2
 */