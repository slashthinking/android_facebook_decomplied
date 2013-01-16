package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.phonenumber.identification.PhoneNumberIdentificationServiceHandler;
import com.facebook.orca.phonenumber.identification.VerifyPhoneNumberSmsConsumer;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.RequestSmsConfirmationCodeMethod;

class MessagesModule$PhoneNumberIdentificationServiceHandlerProvider extends AbstractProvider<PhoneNumberIdentificationServiceHandler>
{
  private MessagesModule$PhoneNumberIdentificationServiceHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public PhoneNumberIdentificationServiceHandler a()
  {
    return new PhoneNumberIdentificationServiceHandler(a(SingleMethodRunner.class), (RequestSmsConfirmationCodeMethod)b(RequestSmsConfirmationCodeMethod.class), (VerifyPhoneNumberSmsConsumer)b(VerifyPhoneNumberSmsConsumer.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.PhoneNumberIdentificationServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */