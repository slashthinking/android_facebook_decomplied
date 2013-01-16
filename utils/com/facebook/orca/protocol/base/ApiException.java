package com.facebook.orca.protocol.base;

import com.facebook.orca.common.base.ExceptionWithExtraData;
import java.io.IOException;

public class ApiException extends IOException
  implements ExceptionWithExtraData
{
  private final ApiErrorResult result;

  public ApiException(ApiErrorResult paramApiErrorResult)
  {
    super(paramApiErrorResult.b());
    this.result = paramApiErrorResult;
  }

  public ApiErrorResult b()
  {
    return this.result;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ApiException
 * JD-Core Version:    0.6.2
 */