package com.facebook.katana.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.katana.model.FacebookUser;

public class FacebookUserPersistent extends FacebookUser
{
  private String mHashCode;

  public FacebookUserPersistent()
  {
  }

  public FacebookUserPersistent(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramLong, paramString1, paramString2, paramString3, paramString4);
  }

  public static FacebookUserPersistent a(Context paramContext, long paramLong)
  {
    Uri localUri = Uri.withAppendedPath(ConnectionsContract.e, String.valueOf(paramLong));
    Cursor localCursor = paramContext.getContentResolver().query(localUri, FacebookUserPersistent.FriendsQuery.a, null, null, null);
    if (localCursor.moveToFirst());
    for (FacebookUserPersistent localFacebookUserPersistent = new FacebookUserPersistent(localCursor.getLong(localCursor.getColumnIndex("user_id")), localCursor.getString(localCursor.getColumnIndex("first_name")), localCursor.getString(localCursor.getColumnIndex("last_name")), localCursor.getString(localCursor.getColumnIndex("display_name")), localCursor.getString(localCursor.getColumnIndex("user_image_url"))); ; localFacebookUserPersistent = null)
    {
      localCursor.close();
      return localFacebookUserPersistent;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookUserPersistent
 * JD-Core Version:    0.6.0
 */