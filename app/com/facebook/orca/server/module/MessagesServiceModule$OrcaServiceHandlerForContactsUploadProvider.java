package com.facebook.orca.server.module;

import com.facebook.orca.contacts.upload.ContactsUploadServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandler;

class MessagesServiceModule$OrcaServiceHandlerForContactsUploadProvider extends AbstractProvider<OrcaServiceHandler>
{
  private MessagesServiceModule$OrcaServiceHandlerForContactsUploadProvider(MessagesServiceModule paramMessagesServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(ContactsUploadServiceHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.module.MessagesServiceModule.OrcaServiceHandlerForContactsUploadProvider
 * JD-Core Version:    0.6.0
 */