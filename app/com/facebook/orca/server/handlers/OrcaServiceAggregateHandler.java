package com.facebook.orca.server.handlers;

import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class OrcaServiceAggregateHandler
  implements OrcaServiceHandler
{
  private final ImmutableMap<String, OrcaServiceHandler> a;

  public OrcaServiceAggregateHandler(Map<String, OrcaServiceHandler> paramMap)
  {
    this.a = ImmutableMap.a(paramMap);
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    OrcaServiceHandler localOrcaServiceHandler = (OrcaServiceHandler)this.a.get(str);
    if (localOrcaServiceHandler == null);
    for (OperationResult localOperationResult = OperationResult.a(ErrorCode.ORCA_SERVICE_UNKNOWN_OPERATION, "Unknown operation type " + str); ; localOperationResult = localOrcaServiceHandler.a(paramOperationParams))
      return localOperationResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.handlers.OrcaServiceAggregateHandler
 * JD-Core Version:    0.6.0
 */