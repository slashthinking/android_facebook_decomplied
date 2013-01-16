package com.facebook.orca.server;

import android.os.Bundle;
import android.util.Log;
import com.facebook.orca.common.base.ExceptionWithExtraData;
import com.facebook.orca.common.http.ProtocolExceptions;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.protocol.base.ApiException;

public class ErrorCodeUtil
{
  public static ErrorCode a(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof ServiceException));
    for (ErrorCode localErrorCode = ((ServiceException)paramThrowable).a(); ; localErrorCode = b(paramThrowable))
      return localErrorCode;
  }

  public static ErrorCode b(Throwable paramThrowable)
  {
    ErrorCode localErrorCode;
    if (ProtocolExceptions.a(paramThrowable))
      localErrorCode = ErrorCode.HTTP_400_AUTHENTICATION;
    while (true)
    {
      return localErrorCode;
      if (ProtocolExceptions.b(paramThrowable))
      {
        localErrorCode = ErrorCode.HTTP_400_OTHER;
        continue;
      }
      if (ProtocolExceptions.c(paramThrowable))
      {
        localErrorCode = ErrorCode.HTTP_500_CLASS;
        continue;
      }
      if ((paramThrowable instanceof ApiException))
      {
        localErrorCode = ErrorCode.API_ERROR;
        continue;
      }
      if (ProtocolExceptions.d(paramThrowable))
      {
        localErrorCode = ErrorCode.CONNECTION_FAILURE;
        continue;
      }
      localErrorCode = ErrorCode.OTHER;
    }
  }

  public static Bundle c(Throwable paramThrowable)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("originalExceptionMessage", paramThrowable.getMessage());
    localBundle.putString("originalExceptionStack", Log.getStackTraceString(paramThrowable));
    if ((paramThrowable instanceof ExceptionWithExtraData))
      localBundle.putParcelable("result", ((ExceptionWithExtraData)paramThrowable).a());
    return localBundle;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ErrorCodeUtil
 * JD-Core Version:    0.6.0
 */