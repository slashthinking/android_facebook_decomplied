package com.facebook.katana.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.view.View;
import android.widget.QuickContactBadge;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.util.PlatformUtils;

public class PlatformFastTrack
{
  protected static Uri a(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    Uri localUri1 = ContactsContract.Data.CONTENT_URI;
    String[] arrayOfString1 = { "contact_id", "lookup" };
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = paramString;
    arrayOfString2[1] = String.valueOf(paramLong);
    Cursor localCursor = paramContentResolver.query(localUri1, arrayOfString1, "account_type='com.facebook.auth.login' AND account_name=? AND sourceid=?", arrayOfString2, null);
    if (localCursor != null);
    try
    {
      if (localCursor.moveToFirst())
      {
        Uri localUri3 = ContactsContract.Contacts.getLookupUri(localCursor.getLong(0), localCursor.getString(1));
        localUri2 = localUri3;
      }
      do
      {
        return localUri2;
        localUri2 = null;
      }
      while (localCursor == null);
      localCursor.close();
      Uri localUri2 = null;
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
  }

  public static void a(View paramView, String paramString, long paramLong, String[] paramArrayOfString)
  {
    QuickContactBadge localQuickContactBadge = (QuickContactBadge)paramView;
    localQuickContactBadge.assignContactUri(a(paramView.getContext().getContentResolver(), paramString, paramLong));
    if (paramArrayOfString.length > 0)
      localQuickContactBadge.setExcludeMimes(paramArrayOfString);
  }

  public static boolean a(Context paramContext)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    int i = 0;
    if (localAppSession == null);
    while (true)
    {
      return i;
      FacebookSessionInfo localFacebookSessionInfo = localAppSession.b();
      boolean bool1 = PlatformUtils.a(paramContext);
      i = 0;
      if (!bool1)
        continue;
      boolean bool2 = FacebookAuthenticationService.d(paramContext, localFacebookSessionInfo.username);
      i = 0;
      if (!bool2)
        continue;
      i = 1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformFastTrack
 * JD-Core Version:    0.6.0
 */