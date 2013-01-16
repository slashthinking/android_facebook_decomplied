package com.facebook.katana.server.handler;

import android.os.Bundle;
import com.facebook.katana.server.protocol.UserSetContactInfoMethod;
import com.facebook.katana.server.protocol.UserSetContactInfoMethod.Params;
import com.facebook.katana.server.utils.ParcelableBoolean;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import javax.inject.Provider;

public class UserSetContactInfoServiceHandler
  implements OrcaServiceHandler
{
  private final Provider<SingleMethodRunner> a;
  private final UserSetContactInfoMethod b;

  public UserSetContactInfoServiceHandler(Provider<SingleMethodRunner> paramProvider, UserSetContactInfoMethod paramUserSetContactInfoMethod)
  {
    this.a = paramProvider;
    this.b = paramUserSetContactInfoMethod;
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    UserSetContactInfoMethod.Params localParams = (UserSetContactInfoMethod.Params)paramOperationParams.b().getParcelable("user_set_contact_info");
    return OperationResult.a(new ParcelableBoolean(((Boolean)((SingleMethodRunner)this.a.b()).a(this.b, localParams)).booleanValue()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.handler.UserSetContactInfoServiceHandler
 * JD-Core Version:    0.6.0
 */