package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.phonenumber.identification.VerifyPhoneNumberSmsConsumer;

class MessagesModule$VerifyPhoneNumberSmsConsumerProvider extends AbstractProvider<VerifyPhoneNumberSmsConsumer>
{
  private MessagesModule$VerifyPhoneNumberSmsConsumerProvider(MessagesModule paramMessagesModule)
  {
  }

  public VerifyPhoneNumberSmsConsumer a()
  {
    return new VerifyPhoneNumberSmsConsumer();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.VerifyPhoneNumberSmsConsumerProvider
 * JD-Core Version:    0.6.0
 */