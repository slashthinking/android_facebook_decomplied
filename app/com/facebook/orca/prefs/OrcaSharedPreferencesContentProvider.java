package com.facebook.orca.prefs;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.content.SecureContentProvider;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class OrcaSharedPreferencesContentProvider extends SecureContentProvider
{
  private static final Class<?> a = OrcaSharedPreferencesContentProvider.class;
  private static final WtfToken b = new WtfToken();
  private static final ImmutableMap<String, String> c = ImmutableMap.k().b("_id", "_id").b("key", "key").b("value", "value").b("type", "type").b();
  private static ThreadLocal<OrcaSharedPreferencesContentProvider.PreferenceDbTransaction> d = new ThreadLocal();
  private PrefsMigrator e;
  private PrefsDbOpenHelper f;
  private OrcaSharedPreferencesContract g;
  private SQLiteDatabase h;
  private UriMatcher i;
  private boolean j;

  private OrcaSharedPreferencesContentProvider.PreferenceDbTransaction a()
  {
    OrcaSharedPreferencesContentProvider.PreferenceDbTransaction localPreferenceDbTransaction = (OrcaSharedPreferencesContentProvider.PreferenceDbTransaction)d.get();
    if (localPreferenceDbTransaction == null)
    {
      localPreferenceDbTransaction = new OrcaSharedPreferencesContentProvider.PreferenceDbTransaction(this);
      d.set(localPreferenceDbTransaction);
    }
    localPreferenceDbTransaction.c();
    return localPreferenceDbTransaction;
  }

  private void a(ContentValues paramContentValues, String paramString, Object paramObject)
  {
    int k = 1;
    paramContentValues.put("key", paramString);
    if ((paramObject instanceof String))
    {
      paramContentValues.put("type", Integer.valueOf(k));
      paramContentValues.put("value", (String)paramObject);
    }
    while (true)
    {
      return;
      if ((paramObject instanceof Boolean))
      {
        paramContentValues.put("type", Integer.valueOf(2));
        if (((Boolean)paramObject).booleanValue());
        while (true)
        {
          paramContentValues.put("value", Integer.valueOf(k));
          break;
          k = 0;
        }
      }
      if ((paramObject instanceof Integer))
      {
        paramContentValues.put("type", Integer.valueOf(3));
        paramContentValues.put("value", (Integer)paramObject);
        continue;
      }
      if ((paramObject instanceof Long))
      {
        paramContentValues.put("type", Integer.valueOf(4));
        paramContentValues.put("value", (Long)paramObject);
        continue;
      }
      if (!(paramObject instanceof Float))
        break;
      paramContentValues.put("type", Integer.valueOf(5));
      paramContentValues.put("value", (Float)paramObject);
    }
    throw new IllegalArgumentException("Unsupported type");
  }

  private void a(SortedMap<PrefKey, Object> paramSortedMap)
  {
    SortedMap localSortedMap = this.e.a(paramSortedMap);
    Tracer localTracer = Tracer.a("#migrate");
    this.h.beginTransaction();
    try
    {
      this.h.delete("preferences", null, null);
      ContentValues localContentValues = new ContentValues();
      Iterator localIterator = localSortedMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        PrefKey localPrefKey = (PrefKey)localEntry.getKey();
        Object localObject2 = localEntry.getValue();
        a(localContentValues, localPrefKey.a(), localObject2);
        this.h.replaceOrThrow("preferences", null, localContentValues);
      }
    }
    finally
    {
      this.h.endTransaction();
      localTracer.a();
    }
    this.h.setTransactionSuccessful();
    this.h.endTransaction();
    localTracer.a();
  }

  private int b(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (this.i.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 3:
    }
    if (paramString == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Selection not supported");
      String str = (String)paramUri.getPathSegments().get(2);
      int k = this.h.delete("preferences", "key=?", new String[] { str });
      ((OrcaSharedPreferencesContentProvider.PreferenceDbTransaction)d.get()).a(str);
      return k;
    }
  }

  private int b(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int k = 0;
    int m = paramArrayOfContentValues.length;
    int n = 0;
    while (k < m)
    {
      b(paramUri, paramArrayOfContentValues[k]);
      n++;
      k++;
    }
    return n;
  }

  private Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    int k = 1;
    if (this.i.match(paramUri) == k);
    while (true)
    {
      Preconditions.checkArgument(k);
      Preconditions.checkArgument(paramContentValues.containsKey("key"));
      long l = this.h.replaceOrThrow("preferences", "key", paramContentValues);
      if (l <= 0L)
        break;
      Uri localUri = Uri.withAppendedPath(this.g.d().a(), Long.valueOf(l).toString());
      ((OrcaSharedPreferencesContentProvider.PreferenceDbTransaction)d.get()).a(paramContentValues.getAsString("key"));
      return localUri;
      int m = 0;
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }

  private void b()
  {
    OrcaSharedPreferencesContentProvider.PreferenceDbTransaction localPreferenceDbTransaction = (OrcaSharedPreferencesContentProvider.PreferenceDbTransaction)d.get();
    try
    {
      localPreferenceDbTransaction.e();
      Intent localIntent;
      if ((localPreferenceDbTransaction.b() == 0) && (!localPreferenceDbTransaction.a().isEmpty()))
      {
        localIntent = new Intent(this.g.c());
        localIntent.putStringArrayListExtra("prefs", Lists.a(localPreferenceDbTransaction.a()));
        if (this.g.e() != null)
          break label96;
        getContext().sendBroadcast(localIntent);
      }
      while (true)
      {
        return;
        label96: getContext().sendBroadcast(localIntent, this.g.e());
      }
    }
    finally
    {
      if (localPreferenceDbTransaction.b() == 0)
        d.set(null);
    }
    throw localObject;
  }

  private void c()
  {
    monitorenter;
    try
    {
      boolean bool = this.j;
      if (bool);
      while (true)
      {
        return;
        Tracer localTracer1 = Tracer.a("OrcaSharedPreferencesContentProvider.ensureInitialized");
        FbInjector localFbInjector = FbInjector.a(getContext());
        this.e = ((PrefsMigrator)localFbInjector.a(PrefsMigrator.class));
        this.g = ((OrcaSharedPreferencesContract)localFbInjector.a(OrcaSharedPreferencesContract.class));
        String str = this.g.a();
        this.i = new UriMatcher(-1);
        this.i.addURI(str, "prefs", 1);
        this.i.addURI(str, "prefs/#", 2);
        this.i.addURI(str, "prefs/key/*", 3);
        e();
        this.h = this.f.getWritableDatabase();
        Tracer localTracer2 = Tracer.a("#maybeMigrate");
        SortedMap localSortedMap = d();
        if (this.e.a(localSortedMap))
          a(localSortedMap);
        localTracer2.a();
        this.j = true;
        localTracer1.a();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private SortedMap<PrefKey, Object> d()
  {
    TreeMap localTreeMap = Maps.d();
    String[] arrayOfString = { "key", "type", "value" };
    Cursor localCursor = this.h.query("preferences", arrayOfString, null, null, null, null, null);
    String str;
    try
    {
      while (localCursor.moveToNext())
      {
        str = localCursor.getString(0);
        switch (localCursor.getInt(1))
        {
        case 1:
          localTreeMap.put(new PrefKey(str), localCursor.getString(2));
        case 2:
        case 3:
        case 4:
        case 5:
        }
      }
    }
    finally
    {
      localCursor.close();
    }
    PrefKey localPrefKey = new PrefKey(str);
    if (localCursor.getInt(2) != 0);
    for (boolean bool = true; ; bool = false)
    {
      localTreeMap.put(localPrefKey, Boolean.valueOf(bool));
      break;
      localTreeMap.put(new PrefKey(str), Integer.valueOf(localCursor.getInt(2)));
      break;
      localTreeMap.put(new PrefKey(str), Long.valueOf(localCursor.getLong(2)));
      break;
      localTreeMap.put(new PrefKey(str), Float.valueOf(localCursor.getFloat(2)));
      break;
      localCursor.close();
      return localTreeMap;
      break;
    }
  }

  private void e()
  {
    monitorenter;
    try
    {
      PrefsDbOpenHelper localPrefsDbOpenHelper = this.f;
      if (localPrefsDbOpenHelper != null);
      while (true)
      {
        return;
        try
        {
          this.f = f();
        }
        catch (SQLiteException localSQLiteException)
        {
          BLog.a(b, a, "Possible prefs database corruption", localSQLiteException);
          getContext().deleteDatabase("prefs_db");
          this.f = f();
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private PrefsDbOpenHelper f()
  {
    Tracer localTracer = Tracer.a("initializePrefsDatabase");
    PrefsDbOpenHelper localPrefsDbOpenHelper = new PrefsDbOpenHelper(getContext());
    localPrefsDbOpenHelper.getWritableDatabase();
    localTracer.a();
    return localPrefsDbOpenHelper;
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    c();
    throw new IllegalArgumentException("Update not supported");
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    c();
    OrcaSharedPreferencesContentProvider.PreferenceDbTransaction localPreferenceDbTransaction = a();
    try
    {
      int k = b(paramUri, paramString, paramArrayOfString);
      localPreferenceDbTransaction.d();
      return k;
    }
    finally
    {
      b();
    }
    throw localObject;
  }

  protected int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    c();
    OrcaSharedPreferencesContentProvider.PreferenceDbTransaction localPreferenceDbTransaction = a();
    try
    {
      int k = b(paramUri, paramArrayOfContentValues);
      localPreferenceDbTransaction.d();
      return k;
    }
    finally
    {
      b();
    }
    throw localObject;
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    c();
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("preferences");
    localSQLiteQueryBuilder.setProjectionMap(c);
    switch (this.i.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 2:
      localSQLiteQueryBuilder.appendWhere("_id='" + DatabaseUtils.sqlEscapeString((String)paramUri.getPathSegments().get(1)) + "'");
    case 1:
      if (!TextUtils.isEmpty(paramString2))
        break;
    case 3:
    }
    for (String str = "key DESC"; ; str = paramString2)
    {
      return localSQLiteQueryBuilder.query(this.h, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str);
      localSQLiteQueryBuilder.appendWhere("key='" + DatabaseUtils.sqlEscapeString((String)paramUri.getPathSegments().get(2)) + "'");
      break;
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    c();
    OrcaSharedPreferencesContentProvider.PreferenceDbTransaction localPreferenceDbTransaction = a();
    try
    {
      Uri localUri = b(paramUri, paramContentValues);
      localPreferenceDbTransaction.d();
      return localUri;
    }
    finally
    {
      b();
    }
    throw localObject;
  }

  protected String a(Uri paramUri)
  {
    return null;
  }

  protected ContentProviderResult[] a(ArrayList<ContentProviderOperation> paramArrayList)
  {
    OrcaSharedPreferencesContentProvider.PreferenceDbTransaction localPreferenceDbTransaction = a();
    try
    {
      ContentProviderResult[] arrayOfContentProviderResult = super.a(paramArrayList);
      localPreferenceDbTransaction.d();
      return arrayOfContentProviderResult;
    }
    finally
    {
      b();
    }
    throw localObject;
  }

  public boolean onCreate()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesContentProvider
 * JD-Core Version:    0.6.0
 */