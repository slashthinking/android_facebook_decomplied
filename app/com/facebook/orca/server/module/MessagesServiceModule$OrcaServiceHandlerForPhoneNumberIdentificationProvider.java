package com.facebook.orca.server.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.phonenumber.identification.PhoneNumberIdentificationServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler;

class MessagesServiceModule$OrcaServiceHandlerForPhoneNumberIdentificationProvider extends AbstractProvider<OrcaServiceHandler>
{
  private MessagesServiceModule$OrcaServiceHandlerForPhoneNumberIdentificationProvider(MessagesServiceModule paramMessagesServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(PhoneNumberIdentificationServiceHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.module.MessagesServiceModule.OrcaServiceHandlerForPhoneNumberIdentificationProvider
 * JD-Core Version:    0.6.0
 */