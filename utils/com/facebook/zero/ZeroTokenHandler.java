package com.facebook.zero;

import android.os.Bundle;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.zero.protocol.CarrierMccMnc;
import com.facebook.zero.protocol.methods.FetchZeroTokenMethod;
import com.facebook.zero.protocol.methods.FetchZeroTokenResult;
import com.facebook.zero.protocol.methods.ValidateZeroTokenMethod;
import com.facebook.zero.protocol.methods.ValidateZeroTokenMethod.Params;

public class ZeroTokenHandler
  implements OrcaServiceHandler
{
  private final FetchZeroTokenMethod a;
  private final ValidateZeroTokenMethod b;
  private final SingleMethodRunner c;

  public ZeroTokenHandler(SingleMethodRunner paramSingleMethodRunner, FetchZeroTokenMethod paramFetchZeroTokenMethod, ValidateZeroTokenMethod paramValidateZeroTokenMethod)
  {
    this.c = paramSingleMethodRunner;
    this.a = paramFetchZeroTokenMethod;
    this.b = paramValidateZeroTokenMethod;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    ValidateZeroTokenMethod.Params localParams = (ValidateZeroTokenMethod.Params)paramOperationParams.b().getParcelable("validateZeroTokenParams");
    return OperationResult.a(Boolean.toString(((Boolean)this.c.a(this.b, localParams)).booleanValue()));
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    CarrierMccMnc localCarrierMccMnc = (CarrierMccMnc)paramOperationParams.b().getParcelable("fetchZeroTokenParams");
    return OperationResult.a((FetchZeroTokenResult)this.c.a(this.a, localCarrierMccMnc));
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    if ("fetch_zero_token".equals(str));
    for (OperationResult localOperationResult = c(paramOperationParams); ; localOperationResult = b(paramOperationParams))
    {
      return localOperationResult;
      if (!"validate_zero_token".equals(str))
        break;
    }
    throw new Exception("unknown type: " + str);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.ZeroTokenHandler
 * JD-Core Version:    0.6.2
 */