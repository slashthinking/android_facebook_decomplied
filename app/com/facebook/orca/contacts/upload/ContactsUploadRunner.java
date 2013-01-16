package com.facebook.orca.contacts.upload;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.app.IHaveUserData;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.prefs.MessengerPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import javax.inject.Inject;

public class ContactsUploadRunner
  implements IHaveUserData
{
  private static final String a = ContactsUploadRunner.class.getName();
  private final OrcaServiceOperation b;
  private final LocalBroadcastManager c;
  private final OrcaSharedPreferences d;
  private final AnalyticsLogger e;
  private ContactsUploadState f;

  @Inject
  public ContactsUploadRunner(OrcaServiceOperation paramOrcaServiceOperation, LocalBroadcastManager paramLocalBroadcastManager, OrcaSharedPreferences paramOrcaSharedPreferences, AnalyticsLogger paramAnalyticsLogger)
  {
    this.b = paramOrcaServiceOperation;
    this.c = paramLocalBroadcastManager;
    this.d = paramOrcaSharedPreferences;
    this.e = paramAnalyticsLogger;
    if (this.d.a(MessengerPrefKeys.z, false))
      a(ContactsUploadState.g());
    while (true)
    {
      this.b.a(true);
      this.b.a(new ContactsUploadRunner.1(this));
      this.b.a(new ContactsUploadRunner.2(this));
      return;
      b();
    }
  }

  private void a(ContactsUploadState paramContactsUploadState)
  {
    monitorenter;
    try
    {
      this.f = paramContactsUploadState;
      monitorexit;
      if (paramContactsUploadState.a() == ContactsUploadState.Status.FAILED)
        this.d.b().a(MessengerPrefKeys.z, true).a();
      Intent localIntent = new Intent();
      localIntent.setAction("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED");
      localIntent.putExtra("state", paramContactsUploadState);
      this.c.a(localIntent);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private String g()
  {
    return "contacts_upload";
  }

  public void a()
  {
    monitorenter;
    try
    {
      if (d())
        BLog.a(a, "Already uploading, not uploading again");
      while (true)
      {
        return;
        Bundle localBundle = new Bundle();
        this.b.a("contacts_upload", localBundle);
        this.e.a(new HoneyClientEvent("contacts_upload_started").d(g()));
        a(ContactsUploadState.f());
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void b()
  {
    monitorenter;
    try
    {
      ContactsUploadState localContactsUploadState = c();
      if ((localContactsUploadState == null) || (localContactsUploadState.a() == ContactsUploadState.Status.SUCCEEDED) || (localContactsUploadState.a() == ContactsUploadState.Status.FAILED))
        a(ContactsUploadState.e());
      while (true)
      {
        if (this.d.a(MessengerPrefKeys.z, false))
        {
          BLog.b(a, "Clearing last upload failed state.");
          this.d.b().a(MessengerPrefKeys.z).a();
        }
        return;
        BLog.d(a, "Ignoring reset state request (current state: " + localContactsUploadState + ")");
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public ContactsUploadState c()
  {
    monitorenter;
    try
    {
      ContactsUploadState localContactsUploadState = this.f;
      monitorexit;
      return localContactsUploadState;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean d()
  {
    if (this.b.c() != OrcaServiceOperation.State.INIT);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void f()
  {
    BLog.b(a, "Clearing cached user data.");
    b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.upload.ContactsUploadRunner
 * JD-Core Version:    0.6.0
 */