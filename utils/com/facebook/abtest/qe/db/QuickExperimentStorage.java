package com.facebook.abtest.qe.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.abtest.qe.data.QuickExperimentInfo;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class QuickExperimentStorage
{
  private static final Class<?> a = QuickExperimentStorage.class;
  private static final WtfToken b = new WtfToken();
  private static final String[] d = { "name", "groupName", "loggingEnabled", "locale", "customContentJSON" };
  private final QuickExperimentDbSupplier c;

  public QuickExperimentStorage(QuickExperimentDbSupplier paramQuickExperimentDbSupplier)
  {
    this.c = paramQuickExperimentDbSupplier;
  }

  private QuickExperimentInfo a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    String[] arrayOfString = { paramString };
    Cursor localCursor = paramSQLiteDatabase.query("experiments", d, "name=?", arrayOfString, null, null, null);
    try
    {
      int i = localCursor.getCount();
      Object localObject2 = null;
      if (i > 1)
        BLog.a(b, a, "Multiple entries for experiment " + paramString);
      if (localCursor.moveToNext())
      {
        String str1 = localCursor.getString(localCursor.getColumnIndex("name"));
        String str2 = localCursor.getString(localCursor.getColumnIndex("groupName"));
        if (localCursor.getInt(localCursor.getColumnIndex("loggingEnabled")) == 1);
        for (boolean bool = true; ; bool = false)
        {
          String str3 = localCursor.getString(localCursor.getColumnIndex("locale"));
          String str4 = localCursor.getString(localCursor.getColumnIndex("customContentJSON"));
          ImmutableMap localImmutableMap = ImmutableMap.j();
          if (str4 != null)
            localImmutableMap = b(str4);
          QuickExperimentInfo localQuickExperimentInfo = new QuickExperimentInfo(str1, str2, bool, str3, localImmutableMap);
          localObject2 = localQuickExperimentInfo;
          break;
        }
      }
      return localObject2;
    }
    finally
    {
      localCursor.close();
    }
  }

  private void a(SQLiteDatabase paramSQLiteDatabase, QuickExperimentInfo paramQuickExperimentInfo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", paramQuickExperimentInfo.a());
    localContentValues.put("groupName", paramQuickExperimentInfo.b());
    if (paramQuickExperimentInfo.c());
    for (int i = 1; ; i = 0)
    {
      localContentValues.put("loggingEnabled", Integer.valueOf(i));
      localContentValues.put("locale", paramQuickExperimentInfo.d());
      localContentValues.put("customContentJSON", a(paramQuickExperimentInfo.e()).a());
      paramSQLiteDatabase.replace("experiments", null, localContentValues);
      return;
    }
  }

  public QuickExperimentInfo a(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    QuickExperimentInfo localQuickExperimentInfo = a(this.c.b(), paramString);
    if (localQuickExperimentInfo != null);
    while (true)
    {
      return localQuickExperimentInfo;
      localQuickExperimentInfo = null;
    }
  }

  JSONObject a(ImmutableMap<String, String> paramImmutableMap)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramImmutableMap != null)
    {
      Iterator localIterator = paramImmutableMap.a().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localJSONObject.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return localJSONObject;
  }

  public void a(QuickExperimentInfo paramQuickExperimentInfo)
  {
    Preconditions.checkNotNull(paramQuickExperimentInfo);
    SQLiteDatabase localSQLiteDatabase = this.c.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      a(localSQLiteDatabase, paramQuickExperimentInfo);
      return;
    }
    finally
    {
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
    }
  }

  ImmutableMap<String, String> b(String paramString)
  {
    JSONParser localJSONParser = new JSONParser();
    try
    {
      JSONObject localJSONObject2 = (JSONObject)localJSONParser.a(paramString);
      localJSONObject1 = localJSONObject2;
      if (localJSONObject1 == null)
      {
        localImmutableMap = ImmutableMap.j();
        return localImmutableMap;
      }
    }
    catch (ParseException localParseException)
    {
      while (true)
      {
        BLog.d(a, "Error parsing " + paramString + ": " + localParseException);
        JSONObject localJSONObject1 = null;
        continue;
        ImmutableMap.Builder localBuilder = new ImmutableMap.Builder();
        try
        {
          Iterator localIterator = localJSONObject1.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = localIterator.next();
            localBuilder.b((String)localObject, (String)localJSONObject1.get(localObject));
          }
        }
        catch (ClassCastException localClassCastException)
        {
          localImmutableMap = ImmutableMap.j();
        }
        continue;
        ImmutableMap localImmutableMap = localBuilder.b();
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.db.QuickExperimentStorage
 * JD-Core Version:    0.6.2
 */