package com.facebook.orca.app;

import com.facebook.orca.annotations.IsClientSmsPermitted;
import com.facebook.orca.annotations.IsContactsUploadPermitted;
import com.facebook.orca.annotations.IsPartialAccount;
import com.facebook.orca.contacts.upload.ContactsUploadRunner;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.nux.OrcaNuxManager;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.UiCounters;

class MessagesModule$OrcaNuxControllerProvider extends AbstractProvider<OrcaNuxManager>
{
  private MessagesModule$OrcaNuxControllerProvider(MessagesModule paramMessagesModule)
  {
  }

  public OrcaNuxManager a()
  {
    return new OrcaNuxManager((OrcaAppType)b(OrcaAppType.class), a(Boolean.class, IsClientSmsPermitted.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (UiCounters)b(UiCounters.class), a(Boolean.class, IsContactsUploadPermitted.class), a(Boolean.class, IsPartialAccount.class), (ContactsUploadRunner)b(ContactsUploadRunner.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.OrcaNuxControllerProvider
 * JD-Core Version:    0.6.0
 */