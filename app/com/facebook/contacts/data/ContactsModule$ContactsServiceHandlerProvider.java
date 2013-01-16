package com.facebook.contacts.data;

import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.protocol.BlockContactMethod;
import com.facebook.contacts.protocol.BulkContactsDeleteMethod;
import com.facebook.contacts.protocol.CreateContactClaimMethod;
import com.facebook.contacts.protocol.DeleteContactClaimMethod;
import com.facebook.contacts.protocol.FetchAllContactsMethod;
import com.facebook.contacts.protocol.FetchContactMethod;
import com.facebook.contacts.protocol.FetchDeltaContactsMethod;
import com.facebook.contacts.service.AddressBookContactFetcher;
import com.facebook.contacts.service.ContactsServiceHandler;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.database.AddressBookPeriodicRunner;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class ContactsModule$ContactsServiceHandlerProvider extends AbstractProvider<ContactsServiceHandler>
{
  private ContactsModule$ContactsServiceHandlerProvider(ContactsModule paramContactsModule)
  {
  }

  public ContactsServiceHandler a()
  {
    return new ContactsServiceHandler(a(SingleMethodRunner.class), (FetchAllContactsMethod)b(FetchAllContactsMethod.class), (FetchDeltaContactsMethod)b(FetchDeltaContactsMethod.class), (FetchContactMethod)b(FetchContactMethod.class), (BulkContactsDeleteMethod)b(BulkContactsDeleteMethod.class), (BlockContactMethod)b(BlockContactMethod.class), (CreateContactClaimMethod)b(CreateContactClaimMethod.class), (DeleteContactClaimMethod)b(DeleteContactClaimMethod.class), (AddressBookPeriodicRunner)b(AddressBookPeriodicRunner.class), (AddressBookContactFetcher)b(AddressBookContactFetcher.class), (DataCache)b(DataCache.class), (ContactsCache)b(ContactsCache.class), (DbFetchContactHandler)b(DbFetchContactHandler.class), (DbInsertContactHandler)b(DbInsertContactHandler.class), (ContactsDatabaseSupplier)b(ContactsDatabaseSupplier.class), (OrcaActivityBroadcaster)b(OrcaActivityBroadcaster.class), (DbContactsPropertyUtil)b(DbContactsPropertyUtil.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactsModule.ContactsServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */