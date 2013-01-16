package com.facebook.orca.app;

import com.facebook.contacts.data.DbContactsPropertyUtil;
import com.facebook.contacts.data.DbInsertContactHandler;
import com.facebook.contacts.protocol.FetchContactsMethod;
import com.facebook.contacts.protocol.UploadBulkContactsMethod;
import com.facebook.orca.contacts.upload.ContactsUploadServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.users.PhoneUserIterator;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

class MessagesModule$ContactsUploadServiceHandlerProvider extends AbstractProvider<ContactsUploadServiceHandler>
{
  private MessagesModule$ContactsUploadServiceHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public ContactsUploadServiceHandler a()
  {
    return new ContactsUploadServiceHandler(a(PhoneUserIterator.class), a(SingleMethodRunner.class), (UploadBulkContactsMethod)b(UploadBulkContactsMethod.class), (FetchContactsMethod)b(FetchContactsMethod.class), (DbInsertContactHandler)b(DbInsertContactHandler.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (DbContactsPropertyUtil)b(DbContactsPropertyUtil.class), (PhoneNumberUtil)b(PhoneNumberUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ContactsUploadServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */