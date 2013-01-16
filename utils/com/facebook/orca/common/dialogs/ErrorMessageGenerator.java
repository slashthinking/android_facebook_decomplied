package com.facebook.orca.common.dialogs;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.protocol.base.ApiErrorResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;
import com.google.common.collect.ImmutableMap;

public class ErrorMessageGenerator
{
  private static final String a = ErrorMessageGenerator.class.getSimpleName();
  private static final ImmutableMap<Integer, Integer> d = ImmutableMap.a(Integer.valueOf(506), Integer.valueOf(2131362199), Integer.valueOf(1610007), Integer.valueOf(2131362200));
  private final Context b;
  private final FbErrorReporter c;

  public ErrorMessageGenerator(Context paramContext, FbErrorReporter paramFbErrorReporter)
  {
    this.b = paramContext;
    this.c = paramFbErrorReporter;
  }

  public String a(int paramInt)
  {
    if (!d.containsKey(Integer.valueOf(paramInt)))
      this.c.a(a, "No error message for error code " + paramInt, true);
    for (String str = null; ; str = this.b.getString(((Integer)d.get(Integer.valueOf(paramInt))).intValue()))
      return str;
  }

  public String a(ServiceException paramServiceException, boolean paramBoolean1, boolean paramBoolean2)
  {
    ErrorCode localErrorCode = paramServiceException.a();
    String str2;
    String str1;
    if (localErrorCode == ErrorCode.API_ERROR)
    {
      ApiErrorResult localApiErrorResult = (ApiErrorResult)paramServiceException.b().h();
      str2 = null;
      if (paramBoolean1)
        str2 = a(localApiErrorResult.a());
      if (str2 != null)
        break label110;
      str1 = localApiErrorResult.b();
    }
    while (true)
    {
      if ((str1 == null) && (paramBoolean2))
        str1 = this.b.getString(2131362196);
      return str1;
      if (localErrorCode == ErrorCode.CONNECTION_FAILURE)
      {
        str1 = this.b.getResources().getString(2131362197);
      }
      else
      {
        str1 = null;
        continue;
        label110: str1 = str2;
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.dialogs.ErrorMessageGenerator
 * JD-Core Version:    0.6.2
 */