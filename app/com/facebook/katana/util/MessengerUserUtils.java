package com.facebook.katana.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.TriState;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.notify.MessengerLoggedInUserProvider;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MessengerUserUtils
{
  private static final Class<?> a = MessengerUserUtils.class;

  public static MessengerUserUtils.UserStatus a(Context paramContext, String paramString)
  {
    BLog.b(a, "Checking Messenger to see if user %d is the push notification receiver", new Object[] { paramString });
    TriState localTriState1 = TriState.UNSET;
    Object localObject1;
    boolean bool3;
    label153: boolean bool6;
    label193: TriState localTriState2;
    boolean bool5;
    try
    {
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("userId", paramString);
      Cursor localCursor = paramContext.getContentResolver().query(Uri.parse("content://com.facebook.orca.notify.MessengerLoggedInUserProvider/logged_in_user"), null, localObjectNode.toString(), null, null);
      if (localCursor != null)
      {
        localObject1 = localTriState1;
        bool3 = false;
        boolean bool4 = false;
        try
        {
          if (localCursor.moveToNext())
          {
            int i = localCursor.getInt(0);
            int j = MessengerLoggedInUserProvider.b.intValue();
            if (i <= j)
              break label153;
          }
          for (bool4 = true; bool4; bool4 = false)
          {
            bool3 = true;
            localCursor.close();
            bool2 = bool4;
            bool1 = bool3;
            localUserStatus = new MessengerUserUtils.UserStatus(bool2, bool1, (TriState)localObject1);
            return localUserStatus;
          }
          if (localCursor.getColumnCount() >= 2)
          {
            if (localCursor.getInt(1) <= MessengerLoggedInUserProvider.b.intValue())
              break label350;
            bool6 = true;
            break label332;
            if (localCursor.getColumnCount() >= 3)
            {
              if (localCursor.getInt(2) > MessengerLoggedInUserProvider.b.intValue())
              {
                localTriState2 = TriState.YES;
                break label339;
              }
              localTriState2 = TriState.NO;
            }
          }
        }
        finally
        {
          localCursor.close();
        }
      }
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
      {
        BLog.b(a, "Caught exception checking orca pref", localSecurityException);
        localUserStatus = new MessengerUserUtils.UserStatus(false, false, TriState.UNSET);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        ErrorReporting.a("MESSENGER_LOGGED_IN_USER_PROVIDER", "Exception in MessengerLoggedInUserProvider", localException);
        MessengerUserUtils.UserStatus localUserStatus = new MessengerUserUtils.UserStatus(false, false, TriState.UNSET);
        continue;
        bool3 = bool5;
        continue;
        bool5 = bool3;
        continue;
        localObject1 = localTriState1;
        boolean bool1 = false;
        boolean bool2 = false;
      }
    }
    while (true)
    {
      label332: bool5 = bool6;
      break label193;
      label339: localObject1 = localTriState2;
      bool3 = bool5;
      break;
      label350: bool6 = false;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.MessengerUserUtils
 * JD-Core Version:    0.6.0
 */