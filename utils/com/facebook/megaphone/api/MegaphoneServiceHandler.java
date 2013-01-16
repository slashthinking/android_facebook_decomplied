package com.facebook.megaphone.api;

import android.os.Bundle;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import javax.inject.Provider;

public class MegaphoneServiceHandler
  implements OrcaServiceHandler
{
  private final Provider<SingleMethodRunner> a;
  private final FetchMegaphoneMethod b;
  private final LogMegaphoneMethod c;

  public MegaphoneServiceHandler(Provider<SingleMethodRunner> paramProvider, FetchMegaphoneMethod paramFetchMegaphoneMethod, LogMegaphoneMethod paramLogMegaphoneMethod)
  {
    this.a = paramProvider;
    this.b = paramFetchMegaphoneMethod;
    this.c = paramLogMegaphoneMethod;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    FetchMegaphoneParams localFetchMegaphoneParams = (FetchMegaphoneParams)paramOperationParams.b().getParcelable("fetchMegaphoneParams");
    return OperationResult.a((FetchMegaphoneResult)((SingleMethodRunner)this.a.b()).a(this.b, localFetchMegaphoneParams));
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    LogMegaphoneParams localLogMegaphoneParams = (LogMegaphoneParams)paramOperationParams.b().getParcelable("logMegaphoneParams");
    ((Void)((SingleMethodRunner)this.a.b()).a(this.c, localLogMegaphoneParams));
    return OperationResult.b();
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    if ("fetch_megaphone".equals(str));
    for (OperationResult localOperationResult = b(paramOperationParams); ; localOperationResult = c(paramOperationParams))
    {
      return localOperationResult;
      if (!"log_megaphone".equals(str))
        break;
    }
    throw new RuntimeException(str);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.api.MegaphoneServiceHandler
 * JD-Core Version:    0.6.2
 */