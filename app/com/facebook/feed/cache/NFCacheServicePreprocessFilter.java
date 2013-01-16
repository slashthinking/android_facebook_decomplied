package com.facebook.feed.cache;

import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;

public class NFCacheServicePreprocessFilter
  implements OrcaServiceHandler.Filter
{
  private static final Class<?> a = NFCacheServicePreprocessFilter.class;
  private final boolean b = false;

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    paramOperationParams.a();
    return paramOrcaServiceHandler.a(paramOperationParams);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.NFCacheServicePreprocessFilter
 * JD-Core Version:    0.6.0
 */