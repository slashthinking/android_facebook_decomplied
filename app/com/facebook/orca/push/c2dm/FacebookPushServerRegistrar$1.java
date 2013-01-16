package com.facebook.orca.push.c2dm;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.protocol.base.ApiErrorResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;

class FacebookPushServerRegistrar$1 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    FacebookPushServerRegistrar.a(this.b);
    StringBuilder localStringBuilder = new StringBuilder("failed");
    localStringBuilder.append('_').append(paramServiceException.a().toString());
    ApiErrorResult localApiErrorResult = (ApiErrorResult)paramServiceException.b().h();
    if (localApiErrorResult != null)
      localStringBuilder.append('_').append(localApiErrorResult.a());
    this.b.a(localStringBuilder.toString());
  }

  public void a(OperationResult paramOperationResult)
  {
    this.b.a(paramOperationResult, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.FacebookPushServerRegistrar.1
 * JD-Core Version:    0.6.0
 */