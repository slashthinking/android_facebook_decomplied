package com.facebook.orca.app;

import android.support.v4.content.LocalBroadcastManager;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.contacts.upload.ContactsUploadRunner;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MessagesModule$ContactsUploadRunnerProvider extends AbstractProvider<ContactsUploadRunner>
{
  private MessagesModule$ContactsUploadRunnerProvider(MessagesModule paramMessagesModule)
  {
  }

  public ContactsUploadRunner a()
  {
    return new ContactsUploadRunner((OrcaServiceOperation)b(OrcaServiceOperation.class, FromApplication.class), (LocalBroadcastManager)b(LocalBroadcastManager.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (AnalyticsLogger)b(AnalyticsLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ContactsUploadRunnerProvider
 * JD-Core Version:    0.6.0
 */