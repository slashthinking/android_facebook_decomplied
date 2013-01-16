package com.facebook.orca.server.handlers;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;

public class ApiMethodServiceHandler<PARAMS, RESULT>
  implements OrcaServiceHandler
{
  public static final ApiMethodServiceHandler.ParamGetter<Void> a = new ApiMethodServiceHandler.1();
  public static final ApiMethodServiceHandler.ResultConverter<Void> b = new ApiMethodServiceHandler.2();
  public static final ApiMethodServiceHandler.ResultConverter<String> c = new ApiMethodServiceHandler.3();
  public static final ApiMethodServiceHandler.ResultConverter<Parcelable> d = new ApiMethodServiceHandler.4();
  private final SingleMethodRunner e;
  private final ApiMethod<PARAMS, RESULT> f;
  private final ApiMethodServiceHandler.ParamGetter<? extends PARAMS> g;
  private final ApiMethodServiceHandler.ResultConverter<? super RESULT> h;

  public ApiMethodServiceHandler(SingleMethodRunner paramSingleMethodRunner, ApiMethod<PARAMS, RESULT> paramApiMethod, ApiMethodServiceHandler.ParamGetter<? extends PARAMS> paramParamGetter, ApiMethodServiceHandler.ResultConverter<? super RESULT> paramResultConverter)
  {
    this.e = paramSingleMethodRunner;
    this.f = paramApiMethod;
    this.g = paramParamGetter;
    this.h = paramResultConverter;
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    Bundle localBundle = paramOperationParams.b();
    Object localObject1 = this.g.b(localBundle);
    Object localObject2 = this.e.a(this.f, localObject1);
    return this.h.a(localObject2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.handlers.ApiMethodServiceHandler
 * JD-Core Version:    0.6.0
 */