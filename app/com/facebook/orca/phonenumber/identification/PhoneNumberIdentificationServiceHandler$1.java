package com.facebook.orca.phonenumber.identification;

import com.facebook.orca.debug.BLog;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;

class PhoneNumberIdentificationServiceHandler$1
  implements FutureCallback<String>
{
  public void a(String paramString)
  {
    BLog.c("orca:PhoneNumberIdentificationServiceHandler", "Phone number verification Successful Code:" + paramString);
    VerifyPhoneNumberResult localVerifyPhoneNumberResult = new VerifyPhoneNumberResult(paramString);
    this.a.a_(OperationResult.a(localVerifyPhoneNumberResult));
  }

  public void a(Throwable paramThrowable)
  {
    BLog.c("orca:PhoneNumberIdentificationServiceHandler", "Phone number confirmation failure" + paramThrowable.getMessage());
    this.a.a_(paramThrowable);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phonenumber.identification.PhoneNumberIdentificationServiceHandler.1
 * JD-Core Version:    0.6.0
 */