package com.facebook.katana.platform;

import android.os.Bundle;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.ErrorCodeUtil;
import com.facebook.orca.server.OperationResult;
import java.util.ArrayList;
import java.util.List;

public class AuthorizeAppResults
{
  public static Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("com.facebook.platform.status.ERROR_TYPE", "PermissionDenied");
    localBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "The user denied the app");
    return localBundle;
  }

  public static Bundle a(ErrorCode paramErrorCode, Throwable paramThrowable)
  {
    String str1;
    String str2;
    String str3;
    switch (AuthorizeAppResults.1.a[paramErrorCode.ordinal()])
    {
    default:
      str1 = "ApplicationError";
      str2 = paramThrowable.getMessage();
      if (!(paramThrowable instanceof ServiceException))
        break;
      str3 = ((ServiceException)paramThrowable).b().g().getString("originalExceptionMessage");
      if (str3 == null)
        break;
    case 1:
    case 2:
    }
    while (true)
    {
      return a(str1, str3);
      str1 = "NetworkError";
      break;
      str1 = "UnknownError";
      break;
      str3 = str2;
    }
  }

  public static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("com.facebook.platform.status.ERROR_TYPE", "UserCanceled");
    localBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", paramString);
    return localBundle;
  }

  public static Bundle a(String paramString, long paramLong, List<String> paramList)
  {
    Bundle localBundle = new Bundle();
    if ((paramList instanceof ArrayList));
    for (ArrayList localArrayList = (ArrayList)paramList; ; localArrayList = new ArrayList(paramList))
    {
      localBundle.putString("com.facebook.platform.extra.ACCESS_TOKEN", paramString);
      localBundle.putLong("com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", paramLong);
      localBundle.putStringArrayList("com.facebook.platform.extra.PERMISSIONS", localArrayList);
      return localBundle;
    }
  }

  public static Bundle a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("com.facebook.platform.status.ERROR_TYPE", paramString1);
    localBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", paramString2);
    return localBundle;
  }

  public static Bundle a(Throwable paramThrowable)
  {
    return a(ErrorCodeUtil.b(paramThrowable), paramThrowable);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.AuthorizeAppResults
 * JD-Core Version:    0.6.0
 */