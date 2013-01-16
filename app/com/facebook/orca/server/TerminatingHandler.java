package com.facebook.orca.server;

public class TerminatingHandler
  implements OrcaServiceHandler
{
  public FutureOperationResult b(OperationParams paramOperationParams)
  {
    throw new IllegalStateException("Unhandled type: " + paramOperationParams.a());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.TerminatingHandler
 * JD-Core Version:    0.6.0
 */