package com.facebook.contacts.data;

import com.facebook.contacts.service.ContactsServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandler;

class ContactsModule$OrcaServiceHandlerForContactsQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private ContactsModule$OrcaServiceHandlerForContactsQueueProvider(ContactsModule paramContactsModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(ContactsServiceHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.OrcaServiceHandlerForContactsQueueProvider
 * JD-Core Version:    0.6.0
 */