package com.facebook.orca.notify;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.content.SecureContentProvider;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.push.c2dm.PushTokenHolder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.inject.Provider;

public class MessengerLoggedInUserProvider extends SecureContentProvider
{
  public static final Integer a = new Integer(1);
  public static final Integer b = new Integer(0);
  private ObjectMapper c;
  private boolean d;

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
    b();
    MatrixCursor localMatrixCursor = new MatrixCursor(new String[] { "li", "push_receiver", "oli" });
    AppInitLockHelper.a(getContext());
    FbInjector localFbInjector = FbInjector.a(getContext());
    Provider localProvider = localFbInjector.b(String.class, MeUserId.class);
    PushTokenHolder localPushTokenHolder = (PushTokenHolder)localFbInjector.a(PushTokenHolder.class);
    String str1 = (String)localProvider.b();
    try
    {
      str2 = this.c.readTree(paramString1).get("userId").textValue();
      if (str2 != null)
      {
        boolean bool3 = str2.equals(str1);
        if (bool3)
        {
          i1 = 1;
          if (str2 == null);
        }
      }
    }
    catch (IOException localIOException3)
    {
      while (true)
      {
        try
        {
          boolean bool2 = str2.equals(localPushTokenHolder.h());
          if (bool2)
          {
            i2 = 1;
            if (str1 == null)
              continue;
          }
        }
        catch (IOException localIOException3)
        {
          try
          {
            String str2;
            boolean bool1 = str1.equals(str2);
            if (bool1)
              continue;
            n = 1;
            int m = i2;
            int k = i1;
            Object[] arrayOfObject = new Object[3];
            if (k == 0)
              continue;
            Integer localInteger1 = a;
            arrayOfObject[0] = localInteger1;
            if (m == 0)
              continue;
            Integer localInteger2 = a;
            arrayOfObject[1] = localInteger2;
            if (n == 0)
              continue;
            Integer localInteger3 = a;
            arrayOfObject[2] = localInteger3;
            localMatrixCursor.addRow(arrayOfObject);
            return localMatrixCursor;
            localIOException1 = localIOException1;
            i = 0;
            j = 0;
            k = j;
            m = i;
            n = 0;
            continue;
            localInteger1 = b;
            continue;
            localInteger2 = b;
            continue;
            localInteger3 = b;
            continue;
            localIOException3 = localIOException3;
            j = i1;
            i = 0;
            continue;
          }
          catch (IOException localIOException2)
          {
            int i = i2;
            int j = i1;
            continue;
          }
          int n = 0;
          continue;
        }
        int i2 = 0;
        continue;
        int i1 = 0;
      }
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    throw new RuntimeException("insert should not be called on this content provider");
  }

  String a()
  {
    return "content://com.facebook.orca.notify.MessengerLoggedInUserProvider/logged_in_user";
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
 * Qualified Name:     com.facebook.orca.notify.MessengerLoggedInUserProvider
 * JD-Core Version:    0.6.0
 */