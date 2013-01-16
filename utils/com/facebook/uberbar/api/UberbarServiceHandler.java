package com.facebook.uberbar.api;

import android.os.Bundle;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.inject.Provider;

public class UberbarServiceHandler
  implements OrcaServiceHandler
{
  private final FetchUberbarResultMethod a;
  private final Provider<SingleMethodRunner> b;

  public UberbarServiceHandler(FetchUberbarResultMethod paramFetchUberbarResultMethod, Provider<SingleMethodRunner> paramProvider)
  {
    this.a = paramFetchUberbarResultMethod;
    this.b = paramProvider;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    FetchUberbarResultParams localFetchUberbarResultParams = (FetchUberbarResultParams)paramOperationParams.b().getParcelable("fetchQueryResultParams");
    SingleMethodRunner localSingleMethodRunner = (SingleMethodRunner)this.b.b();
    try
    {
      ArrayList localArrayList = Lists.a((Iterable)localSingleMethodRunner.a(this.a, localFetchUberbarResultParams));
      return OperationResult.a(localArrayList);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    if ("fetch_uberbar_result".equals(paramOperationParams.a()))
      return b(paramOperationParams);
    throw new Exception("Unknown type");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.api.UberbarServiceHandler
 * JD-Core Version:    0.6.2
 */