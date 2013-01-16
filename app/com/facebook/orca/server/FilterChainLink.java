package com.facebook.orca.server;

public class FilterChainLink
  implements OrcaServiceHandler
{
  private final OrcaServiceHandler.Filter a;
  private final OrcaServiceHandler b;

  public FilterChainLink(OrcaServiceHandler.Filter paramFilter, OrcaServiceHandler paramOrcaServiceHandler)
  {
    this.a = paramFilter;
    this.b = paramOrcaServiceHandler;
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    return this.a.a(paramOperationParams, this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FilterChainLink
 * JD-Core Version:    0.6.0
 */