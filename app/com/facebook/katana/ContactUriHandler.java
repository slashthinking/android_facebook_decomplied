package com.facebook.katana;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;

public class ContactUriHandler extends BaseFacebookActivity
{
  public static final Class<?> n = IntentUriHandler.class;

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Uri localUri = getIntent().getData();
    AppSession localAppSession = AppSession.a(this, true);
    long l1;
    Cursor localCursor;
    if (localAppSession != null)
    {
      l1 = localAppSession.b().userId;
      if ((localUri == null) || (!localUri.getScheme().equals("content")) || (!"com.android.contacts".equals(localUri.getAuthority())))
        break label198;
      ContentResolver localContentResolver = getContentResolver();
      if (!"vnd.android.cursor.item/vnd.facebook.profile".equals(getIntent().resolveType(localContentResolver)))
        break label198;
      localCursor = localContentResolver.query(localUri, new String[] { "data1" }, null, null, null);
      if (localCursor == null)
        break label191;
    }
    while (true)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          long l3 = localCursor.getLong(0);
          l2 = l3;
          if (localCursor == null)
            continue;
          localCursor.close();
          IntentUriHandler.b(this, "fb://profile/" + l2);
          finish();
          return;
        }
      }
      finally
      {
        if (localCursor == null)
          continue;
        localCursor.close();
      }
      label191: long l2 = l1;
      continue;
      label198: l2 = l1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ContactUriHandler
 * JD-Core Version:    0.6.0
 */