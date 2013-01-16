package com.facebook.orca.contacts.upload;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ContactsUploadRunner$1 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    BLog.e(ContactsUploadRunner.e(), "Contacts upload failed: " + paramServiceException);
    ContactsUploadRunner.b(this.a).a(new HoneyClientEvent("contacts_upload_failed").d(ContactsUploadRunner.a(this.a)));
    ContactsUploadState localContactsUploadState = ContactsUploadState.a(this.a.c(), paramServiceException);
    ContactsUploadRunner.a(this.a, localContactsUploadState);
  }

  public void a(OperationResult paramOperationResult)
  {
    BLog.b(ContactsUploadRunner.e(), "Contacts upload succeeded");
    ContactsUploadRunner.b(this.a).a(new HoneyClientEvent("contacts_upload_succeeded").d(ContactsUploadRunner.a(this.a)));
    ContactsUploadState localContactsUploadState = ContactsUploadState.a(this.a.c(), paramOperationResult);
    ContactsUploadRunner.a(this.a, localContactsUploadState);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.upload.ContactsUploadRunner.1
 * JD-Core Version:    0.6.0
 */