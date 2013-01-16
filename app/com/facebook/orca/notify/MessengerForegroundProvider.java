package com.facebook.orca.notify;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.content.SecureContentProvider;
import com.facebook.orca.annotations.MessagesForegroundProviderAuthority;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.threadview.ThreadViewUtil;
import com.facebook.orca.users.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class MessengerForegroundProvider extends SecureContentProvider
{
  public static final Integer a = Integer.valueOf(1);
  public static final Integer b = Integer.valueOf(0);
  private static final Class<?> f = MessengerForegroundProvider.class;
  private ObjectMapper c;
  private boolean d;
  private String e;

  private String a()
  {
    b();
    AppInitLockHelper.a(getContext());
    if (this.e == null)
      this.e = ((String)FbInjector.a(getContext()).a(String.class, MessagesForegroundProviderAuthority.class));
    return this.e;
  }

  private void b()
  {
    monitorenter;
    try
    {
      boolean bool = this.d;
      if (bool);
      while (true)
      {
        return;
        this.c = ((ObjectMapper)FbInjector.a(getContext()).a(ObjectMapper.class));
        this.d = true;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new RuntimeException("update should not be called on this content provider");
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new RuntimeException("delete should not be called on this content provider");
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    MatrixCursor localMatrixCursor1 = new MatrixCursor(new String[] { "fg", "displays_inapp_notif" });
    b();
    AppInitLockHelper.a(getContext());
    FbInjector localFbInjector = FbInjector.a(getContext());
    ThreadViewUtil localThreadViewUtil = (ThreadViewUtil)localFbInjector.a(ThreadViewUtil.class);
    InAppMessagingNotificationHandler localInAppMessagingNotificationHandler = (InAppMessagingNotificationHandler)localFbInjector.a(InAppMessagingNotificationHandler.class);
    OrcaForegroundActivityListener localOrcaForegroundActivityListener = (OrcaForegroundActivityListener)localFbInjector.a(OrcaForegroundActivityListener.class);
    MeUserAuthDataStore localMeUserAuthDataStore = (MeUserAuthDataStore)localFbInjector.a(MeUserAuthDataStore.class);
    Integer localInteger1 = b;
    Integer localInteger2 = b;
    MatrixCursor localMatrixCursor2;
    try
    {
      String str1 = localMeUserAuthDataStore.g().b();
      JsonNode localJsonNode = this.c.readTree(paramString1);
      String str2 = localJsonNode.get("userId").textValue();
      str3 = localJsonNode.get("threadId").textValue();
      BLog.b(f, "Querying notification state for user: " + str2 + " thread: " + str3);
      Activity localActivity = localOrcaForegroundActivityListener.a();
      if ((str3 == null) || (str2 == null) || (!str2.equals(str1)) || (localActivity == null))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = b;
        arrayOfObject[1] = b;
        localMatrixCursor1.addRow(arrayOfObject);
        localMatrixCursor2 = localMatrixCursor1;
      }
      else if (str3.equals(localThreadViewUtil.a(localActivity)))
      {
        localInteger5 = a;
      }
    }
    catch (IOException localIOException1)
    {
      while (true)
      {
        try
        {
          String str3;
          if (!localInAppMessagingNotificationHandler.b(str3))
            continue;
          localInteger4 = a;
          Object localObject = localInteger5;
          localMatrixCursor1.addRow(new Object[] { localObject, localInteger4 });
          BLog.b(f, "replying with thread in Foreground = " + localObject + ", displays in app notification = " + localInteger4);
          localMatrixCursor2 = localMatrixCursor1;
          break;
          localIOException1 = localIOException1;
          localInteger3 = localInteger1;
          localObject = localInteger3;
          localInteger4 = localInteger2;
          continue;
        }
        catch (IOException localIOException2)
        {
          Integer localInteger3 = localInteger5;
          continue;
          Integer localInteger4 = localInteger2;
          continue;
        }
        Integer localInteger5 = localInteger1;
      }
    }
    return (Cursor)localMatrixCursor2;
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    throw new RuntimeException("insert should not be called on this content provider");
  }

  protected String a(Uri paramUri)
  {
    return "vnd.android.cursor.dir/" + a();
  }

  public boolean onCreate()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.MessengerForegroundProvider
 * JD-Core Version:    0.6.0
 */