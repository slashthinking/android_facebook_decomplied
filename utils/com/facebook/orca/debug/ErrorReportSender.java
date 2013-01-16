package com.facebook.orca.debug;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.orca.protocol.base.ApiErrorResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;

public class ErrorReportSender
{
  private final Context a;

  public ErrorReportSender(Context paramContext)
  {
    this.a = paramContext;
  }

  public void a(OperationResult paramOperationResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ErrorCode localErrorCode = paramOperationResult.d();
    localStringBuilder.append("Error Code: ").append(localErrorCode.toString()).append("\n");
    localStringBuilder.append("Error Description: ").append(paramOperationResult.e()).append("\n");
    localStringBuilder.append("\n");
    if (localErrorCode == ErrorCode.API_ERROR)
    {
      localStringBuilder.append("API Error:\n");
      localStringBuilder.append(((ApiErrorResult)paramOperationResult.h()).b());
      localStringBuilder.append("\n\n");
    }
    Bundle localBundle = paramOperationResult.j();
    if (localBundle.containsKey("originalExceptionMessage"))
    {
      localStringBuilder.append("Original Exception:");
      localStringBuilder.append(localBundle.getString("originalExceptionMessage"));
      localStringBuilder.append("\n");
      if (localBundle.containsKey("originalExceptionStack"))
      {
        localStringBuilder.append(localBundle.getString("originalExceptionStack"));
        localStringBuilder.append("\n\n");
      }
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/html");
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { "orca-crashes@lists.facebook.com" });
    localIntent.putExtra("android.intent.extra.SUBJECT", "Android Error Report");
    localIntent.putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
    this.a.startActivity(Intent.createChooser(localIntent, "Email Report"));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.ErrorReportSender
 * JD-Core Version:    0.6.2
 */