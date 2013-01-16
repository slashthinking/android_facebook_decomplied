package com.facebook.katana;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.RawContacts;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;

public class RemoveRawContactsService extends IntentService
{
  private String a;

  public RemoveRawContactsService()
  {
    super("RemoveRawContactsService");
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    if (this.a != null)
    {
      Uri localUri = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.a).appendQueryParameter("account_type", "com.facebook.auth.login").appendQueryParameter("caller_is_syncadapter", "true").build();
      getContentResolver().delete(localUri, null, null);
    }
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    AppSession localAppSession = AppSession.a(this, false);
    if (localAppSession != null)
      this.a = localAppSession.b().username;
    super.onStart(paramIntent, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.RemoveRawContactsService
 * JD-Core Version:    0.6.0
 */