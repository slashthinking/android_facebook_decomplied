package com.facebook.orca.push.c2dm;

import android.os.Bundle;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import javax.inject.Provider;

public class C2DMRegistrationHandler
  implements OrcaServiceHandler
{
  private final RegisterPushTokenMethod a;
  private final UnregisterPushTokenMethod b;
  private final Provider<SingleMethodRunner> c;

  public C2DMRegistrationHandler(RegisterPushTokenMethod paramRegisterPushTokenMethod, UnregisterPushTokenMethod paramUnregisterPushTokenMethod, Provider<SingleMethodRunner> paramProvider)
  {
    this.a = paramRegisterPushTokenMethod;
    this.b = paramUnregisterPushTokenMethod;
    this.c = paramProvider;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    RegisterPushTokenParams localRegisterPushTokenParams = (RegisterPushTokenParams)paramOperationParams.b().getParcelable("registerPushTokenParams");
    return OperationResult.a((RegisterPushTokenResult)((SingleMethodRunner)this.c.b()).a(this.a, localRegisterPushTokenParams));
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    UnregisterPushTokenParams localUnregisterPushTokenParams = (UnregisterPushTokenParams)paramOperationParams.b().getParcelable("unregisterPushTokenParams");
    ((SingleMethodRunner)this.c.b()).a(this.b, localUnregisterPushTokenParams);
    return OperationResult.b();
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    if ("register_push".equals(str));
    for (OperationResult localOperationResult = b(paramOperationParams); ; localOperationResult = c(paramOperationParams))
    {
      return localOperationResult;
      if (!"unregister_push".equals(str))
        break;
    }
    throw new Exception("Unknown type");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMRegistrationHandler
 * JD-Core Version:    0.6.0
 */