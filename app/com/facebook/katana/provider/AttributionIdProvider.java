package com.facebook.katana.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.facebook.content.PublicContentProvider;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.katana.service.AttributionIdService;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import java.util.UUID;

public class AttributionIdProvider extends PublicContentProvider
{
  private OrcaSharedPreferences a = null;

  private static String a()
  {
    return UUID.randomUUID().toString();
  }

  private static void a(Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, AttributionIdService.class);
    localIntent.putExtra("attribution_id_name", paramString1);
    localIntent.putExtra("user_id", paramLong);
    localIntent.putExtra("auth_token", paramString2);
    paramContext.startService(localIntent);
  }

  private String b()
  {
    AppSession localAppSession = AppSession.b(getContext(), false);
    Object localObject1 = null;
    boolean bool;
    SharedPreferences.Editor localEditor;
    Object localObject2;
    if (localAppSession != null)
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
      localObject1 = localSharedPreferences.getString(FbandroidPrefKeys.i.a(), null);
      long l = localSharedPreferences.getLong(FbandroidPrefKeys.j.a(), 0L);
      bool = localSharedPreferences.getBoolean(FbandroidPrefKeys.k.a(), false);
      if (System.currentTimeMillis() > l + 3600000L)
      {
        localEditor = localSharedPreferences.edit();
        if (localObject1 != null)
          break label164;
        localObject2 = a();
        localEditor.putString(FbandroidPrefKeys.i.a(), (String)localObject2);
        localEditor.putBoolean(FbandroidPrefKeys.k.a(), false);
        localObject1 = localObject2;
      }
    }
    while (true)
    {
      localEditor.commit();
      a(getContext(), (String)localObject2, localAppSession.b().userId, localAppSession.b().oAuthToken);
      return localObject1;
      label164: if (bool)
      {
        localObject2 = a();
        continue;
      }
      localObject2 = localObject1;
    }
  }

  public int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException();
  }

  public int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException();
  }

  public Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    monitorenter;
    try
    {
      String str = b();
      MatrixCursor localMatrixCursor = new MatrixCursor(new String[] { "aid" });
      localMatrixCursor.addRow(new String[] { str });
      monitorexit;
      return localMatrixCursor;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException();
  }

  public String a(Uri paramUri)
  {
    throw new UnsupportedOperationException();
  }

  public boolean onCreate()
  {
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.AttributionIdProvider
 * JD-Core Version:    0.6.0
 */