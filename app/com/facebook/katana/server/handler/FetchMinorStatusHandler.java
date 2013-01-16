package com.facebook.katana.server.handler;

import android.os.Bundle;
import com.facebook.katana.server.protocol.FetchMinorStatusMethod;
import com.facebook.katana.server.protocol.FetchMinorStatusMethod.Params;
import com.facebook.katana.server.utils.ParcelableBoolean;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import javax.inject.Provider;

public class FetchMinorStatusHandler
  implements OrcaServiceHandler
{
  private final Provider<SingleMethodRunner> a;
  private final FetchMinorStatusMethod b;

  public FetchMinorStatusHandler(Provider<SingleMethodRunner> paramProvider, FetchMinorStatusMethod paramFetchMinorStatusMethod)
  {
    this.a = paramProvider;
    this.b = paramFetchMinorStatusMethod;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    FetchMinorStatusMethod.Params localParams = (FetchMinorStatusMethod.Params)paramOperationParams.b().getParcelable("fetch_minor_status");
    return OperationResult.a(new ParcelableBoolean(((Boolean)((SingleMethodRunner)this.a.b()).a(this.b, localParams)).booleanValue()));
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    return b(paramOperationParams);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.handler.FetchMinorStatusHandler
 * JD-Core Version:    0.6.0
 */