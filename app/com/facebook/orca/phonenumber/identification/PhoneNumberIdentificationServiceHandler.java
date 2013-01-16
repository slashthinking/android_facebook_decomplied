package com.facebook.orca.phonenumber.identification;

import android.os.Bundle;
import android.os.Handler;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.RequestSmsConfirmationCodeMethod;
import com.facebook.orca.server.FutureOperationResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.RequestSmsConfirmationCodeParams;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Random;
import javax.inject.Provider;

public class PhoneNumberIdentificationServiceHandler
  implements OrcaServiceHandler
{
  private final Provider<SingleMethodRunner> a;
  private final RequestSmsConfirmationCodeMethod b;
  private final VerifyPhoneNumberSmsConsumer c;

  public PhoneNumberIdentificationServiceHandler(Provider<SingleMethodRunner> paramProvider, RequestSmsConfirmationCodeMethod paramRequestSmsConfirmationCodeMethod, VerifyPhoneNumberSmsConsumer paramVerifyPhoneNumberSmsConsumer)
  {
    this.a = paramProvider;
    this.b = paramRequestSmsConfirmationCodeMethod;
    this.c = paramVerifyPhoneNumberSmsConsumer;
  }

  private String a()
  {
    return Integer.toString(10000 + new Random().nextInt(89999));
  }

  private void a(VerifyPhoneNumberParams paramVerifyPhoneNumberParams, String paramString1, String paramString2, String paramString3)
  {
    RequestSmsConfirmationCodeParams localRequestSmsConfirmationCodeParams = new RequestSmsConfirmationCodeParams(paramVerifyPhoneNumberParams.b(), paramVerifyPhoneNumberParams.a(), paramString1, paramString2, paramString3);
    ((SingleMethodRunner)this.a.b()).a(this.b, localRequestSmsConfirmationCodeParams);
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    Bundle localBundle = paramOperationParams.b();
    VerifyPhoneNumberParams localVerifyPhoneNumberParams = (VerifyPhoneNumberParams)localBundle.getParcelable("verifyPhoneNumberParams");
    String str1 = localBundle.getString("flow");
    String str2 = localBundle.getString("reg_instance");
    String str3 = a();
    SettableFuture localSettableFuture = SettableFuture.c();
    FutureOperationResult localFutureOperationResult = new FutureOperationResult(localSettableFuture);
    Futures.a(this.c.a(new Handler(), str3), new PhoneNumberIdentificationServiceHandler.1(this, localSettableFuture));
    try
    {
      a(localVerifyPhoneNumberParams, str3, str1, str2);
      return localFutureOperationResult;
    }
    catch (Exception localException)
    {
      this.c.a();
    }
    throw localException;
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    Bundle localBundle = paramOperationParams.b();
    a((VerifyPhoneNumberParams)localBundle.getParcelable("verifyPhoneNumberParams"), null, localBundle.getString("flow"), localBundle.getString("reg_instance"));
    return OperationResult.b();
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    if ("verify_phone_number".equals(str));
    for (OperationResult localOperationResult = b(paramOperationParams); ; localOperationResult = c(paramOperationParams))
    {
      return localOperationResult;
      if (!"verify_phone_number_manual".equals(str))
        break;
    }
    throw new IllegalArgumentException("Unknown operation type: " + str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phonenumber.identification.PhoneNumberIdentificationServiceHandler
 * JD-Core Version:    0.6.0
 */