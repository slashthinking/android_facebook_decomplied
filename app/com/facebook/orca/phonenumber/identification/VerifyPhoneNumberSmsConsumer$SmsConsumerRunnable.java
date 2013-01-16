package com.facebook.orca.phonenumber.identification;

class VerifyPhoneNumberSmsConsumer$SmsConsumerRunnable
  implements Runnable
{
  String a;

  public VerifyPhoneNumberSmsConsumer$SmsConsumerRunnable(VerifyPhoneNumberSmsConsumer paramVerifyPhoneNumberSmsConsumer, String paramString)
  {
    this.a = paramString;
  }

  public void run()
  {
    VerifyPhoneNumberSmsConsumer.a(this.b, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phonenumber.identification.VerifyPhoneNumberSmsConsumer.SmsConsumerRunnable
 * JD-Core Version:    0.6.0
 */