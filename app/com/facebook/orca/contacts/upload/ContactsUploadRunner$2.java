package com.facebook.orca.contacts.upload;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceOperation.OnProgressListener;
import com.facebook.orca.server.OperationResult;

class ContactsUploadRunner$2 extends OrcaServiceOperation.OnProgressListener
{
  public void a(OperationResult paramOperationResult)
  {
    ContactsUploadState localContactsUploadState = (ContactsUploadState)paramOperationResult.h();
    ContactsUploadRunner.b(this.a).a(new HoneyClientEvent("contacts_upload_running").d(ContactsUploadRunner.a(this.a)).a("num_processed", localContactsUploadState.b()).a("num_matched", localContactsUploadState.c()).a("total", localContactsUploadState.d()));
    BLog.b(ContactsUploadRunner.e(), "Contacts upload state (" + localContactsUploadState + ")");
    ContactsUploadRunner.a(this.a, localContactsUploadState);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.upload.ContactsUploadRunner.2
 * JD-Core Version:    0.6.0
 */