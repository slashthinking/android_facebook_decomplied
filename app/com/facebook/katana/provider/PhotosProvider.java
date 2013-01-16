package com.facebook.katana.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.Log;
import com.facebook.content.SecureContentProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PhotosProvider extends SecureContentProvider
{
  public static final Uri a;
  public static final Uri b;
  public static final Uri c;
  public static final Uri d;
  public static final Uri e;
  public static final Uri f;
  public static final Uri g;
  public static final Uri h;
  public static final Uri i;
  private static final String[] j = { "filename" };
  private static final String[] k = { "filename" };
  private static final String l = BuildConstants.b() + ".provider.PhotosProvider";
  private static final String m = "content://" + l + "/" + "photos";
  private static final String n;
  private static final String o;
  private static final UriMatcher p;
  private static HashMap<String, String> q;
  private static final HashMap<String, String> r;
  private static HashMap<String, String> s;
  private FacebookDatabaseHelper t;

  static
  {
    a = Uri.parse(m);
    b = Uri.parse(m + "/pid");
    c = Uri.parse(m + "/aid");
    d = Uri.parse(m + "/fbid");
    n = "content://" + l + "/" + "albums";
    e = Uri.parse(n);
    f = Uri.parse(n + "/aid");
    g = Uri.parse(n + "/owner");
    h = Uri.parse(n + "/fbid");
    o = "content://" + l + "/" + "stream_photos";
    i = Uri.parse(o);
    p = new UriMatcher(-1);
    p.addURI(l, "photos", 1);
    p.addURI(l, "photos/#", 2);
    p.addURI(l, "photos/pid/*", 3);
    p.addURI(l, "photos/aid/*", 4);
    p.addURI(l, "photos/fbid/*", 5);
    p.addURI(l, "albums", 10);
    p.addURI(l, "albums/#", 11);
    p.addURI(l, "albums/aid/*", 12);
    p.addURI(l, "albums/owner/#", 13);
    p.addURI(l, "albums/fbid/*", 14);
    p.addURI(l, "stream_photos", 20);
    p.addURI(l, "stream_photos/#", 21);
    q = new HashMap();
    q.put("_id", "_id");
    q.put("pid", "pid");
    q.put("aid", "aid");
    q.put("owner", "owner");
    q.put("src", "src");
    q.put("src_big", "src_big");
    q.put("src_small", "src_small");
    q.put("caption", "caption");
    q.put("created", "created");
    q.put("position", "position");
    q.put("thumbnail", "thumbnail");
    q.put("filename", "filename");
    q.put("object_id", "object_id");
    q.put("can_tag", "can_tag");
    r = new HashMap();
    r.put("_id", "_id");
    r.put("aid", "aid");
    r.put("cover_pid", "cover_pid");
    r.put("cover_url", "cover_url");
    r.put("thumbnail", "thumbnail");
    r.put("owner", "owner");
    r.put("name", "name");
    r.put("created", "created");
    r.put("modified", "modified");
    r.put("description", "description");
    r.put("location", "location");
    r.put("size", "size");
    r.put("visibility", "visibility");
    r.put("type", "type");
    r.put("object_id", "object_id");
    r.put("pids", "pids");
    s = new HashMap();
    s.put("_id", "_id");
    s.put("url", "url");
    s.put("filename", "filename");
  }

  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "position ASC";
    return paramString;
  }

  public static void a(Context paramContext)
  {
    Log.e("PhotosProvider", "Reaping old photos");
    ContentResolver localContentResolver = paramContext.getContentResolver();
    String[] arrayOfString1 = { "_id", "filename" };
    Cursor localCursor = localContentResolver.query(Uri.parse(m), arrayOfString1, "filename IS NOT NULL", null, null);
    if (localCursor == null)
      Log.e("PhotosProvider", "reap failed: no cursor");
    while (true)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      while (localCursor.moveToNext())
      {
        File localFile = new File(localCursor.getString(1));
        if ((localFile.exists()) && (System.currentTimeMillis() - localFile.lastModified() <= 36000000L))
          continue;
        localArrayList.add(new Pair(Long.valueOf(localCursor.getLong(0)), localFile));
      }
      localCursor.close();
      Log.e("PhotosProvider", "Reaping deleting " + localArrayList.size() + " photos");
      if (localArrayList.size() <= 0)
        continue;
      try
      {
        SQLiteDatabase localSQLiteDatabase = FacebookDatabaseHelper.a(paramContext).getWritableDatabase();
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          ContentValues localContentValues = new ContentValues();
          localContentValues.putNull("filename");
          String[] arrayOfString2 = new String[1];
          arrayOfString2[0] = Long.toString(((Long)localPair.first).longValue());
          localSQLiteDatabase.update("photos", localContentValues, "_id = ?", arrayOfString2);
          ((File)localPair.second).delete();
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        Log.a("PhotosProvider", "SQL error deleting photos", localSQLiteException);
      }
    }
  }

  private static void a(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = paramSQLiteDatabase.query("stream_photos", j, paramString, paramArrayOfString, null, null, null);
    if (localCursor != null)
    {
      if (localCursor.moveToFirst())
        do
          new File(localCursor.getString(0)).delete();
        while (localCursor.moveToNext());
      localCursor.close();
    }
  }

  public static String[] a()
  {
    return new String[] { "photos", "albums", "stream_photos" };
  }

  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "modified DESC";
    return paramString;
  }

  private static void b(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = paramSQLiteDatabase.query("photos", k, paramString, paramArrayOfString, null, null, null);
    if (localCursor != null)
    {
      if (localCursor.moveToFirst())
        do
        {
          String str = localCursor.getString(0);
          if (str == null)
            continue;
          new File(str).delete();
        }
        while (localCursor.moveToNext());
      localCursor.close();
    }
  }

  public static String[] b()
  {
    return new String[] { "CREATE TABLE photos (_id INTEGER PRIMARY KEY,pid TEXT,aid TEXT,owner INT,src TEXT,src_big TEXT,src_small TEXT,caption TEXT,created INT,position INT,thumbnail BLOB,filename TEXT,object_id INTEGER,can_tag INTEGER);", "CREATE TABLE albums (_id INTEGER PRIMARY KEY,aid TEXT,cover_pid TEXT,cover_url TEXT,owner INT,name TEXT,created INT,modified INT,description TEXT,location TEXT,size INT,visibility TEXT,type TEXT,thumbnail BLOB,pids TEXT,object_id INT);", "CREATE TABLE stream_photos (_id INTEGER PRIMARY KEY,url TEXT,filename TEXT);", "CREATE INDEX photo_fbid_idx ON photos(object_id)", "CREATE INDEX album_fbid_idx ON albums(object_id)" };
  }

  private static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "url DESC";
    return paramString;
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.t.getWritableDatabase();
    int i1;
    switch (p.match(paramUri))
    {
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 14:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      i1 = localSQLiteDatabase.update("photos", paramContentValues, paramString, paramArrayOfString);
    case 2:
    case 3:
    case 4:
    case 10:
    case 11:
    case 12:
    case 13:
    case 20:
    case 21:
    }
    while (true)
    {
      if (i1 > 0)
        getContext().getContentResolver().notifyChange(paramUri, null);
      return i1;
      String str9 = (String)paramUri.getPathSegments().get(1);
      i1 = localSQLiteDatabase.update("photos", paramContentValues, "_id=" + str9, null);
      continue;
      String str8 = (String)paramUri.getPathSegments().get(2);
      i1 = localSQLiteDatabase.update("photos", paramContentValues, "pid=" + DatabaseUtils.sqlEscapeString(str8), null);
      continue;
      String str6 = (String)paramUri.getPathSegments().get(2);
      StringBuilder localStringBuilder2 = new StringBuilder().append("aid=").append(DatabaseUtils.sqlEscapeString(str6));
      if (!TextUtils.isEmpty(paramString));
      for (String str7 = " AND (" + paramString + ')'; ; str7 = "")
      {
        i1 = localSQLiteDatabase.update("photos", paramContentValues, str7, paramArrayOfString);
        break;
      }
      i1 = localSQLiteDatabase.update("albums", paramContentValues, paramString, paramArrayOfString);
      continue;
      String str5 = (String)paramUri.getPathSegments().get(1);
      i1 = localSQLiteDatabase.update("albums", paramContentValues, "_id=" + str5, null);
      continue;
      String str4 = (String)paramUri.getPathSegments().get(2);
      i1 = localSQLiteDatabase.update("albums", paramContentValues, "aid=" + DatabaseUtils.sqlEscapeString(str4), null);
      continue;
      String str2 = (String)paramUri.getPathSegments().get(2);
      StringBuilder localStringBuilder1 = new StringBuilder().append("owner=").append(str2);
      if (!TextUtils.isEmpty(paramString));
      for (String str3 = " AND (" + paramString + ')'; ; str3 = "")
      {
        i1 = localSQLiteDatabase.update("albums", paramContentValues, str3, paramArrayOfString);
        break;
      }
      i1 = localSQLiteDatabase.update("stream_photos", paramContentValues, paramString, paramArrayOfString);
      continue;
      String str1 = (String)paramUri.getPathSegments().get(1);
      i1 = localSQLiteDatabase.update("stream_photos", paramContentValues, "_id=" + str1, null);
    }
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.t.getWritableDatabase();
    int i1;
    switch (p.match(paramUri))
    {
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 14:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      i1 = localSQLiteDatabase.delete("photos", paramString, paramArrayOfString);
    case 2:
    case 3:
    case 4:
    case 10:
    case 11:
    case 12:
    case 13:
    case 20:
    case 21:
    }
    while (true)
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i1;
      String str12 = (String)paramUri.getPathSegments().get(1);
      String str13 = "_id=" + str12;
      b(localSQLiteDatabase, str13, null);
      i1 = localSQLiteDatabase.delete("photos", str13, null);
      continue;
      String str10 = (String)paramUri.getPathSegments().get(2);
      String str11 = "pid=" + DatabaseUtils.sqlEscapeString(str10);
      b(localSQLiteDatabase, str11, null);
      i1 = localSQLiteDatabase.delete("photos", str11, null);
      continue;
      String str7 = (String)paramUri.getPathSegments().get(2);
      StringBuilder localStringBuilder2 = new StringBuilder().append("aid=").append(DatabaseUtils.sqlEscapeString(str7));
      if (!TextUtils.isEmpty(paramString));
      for (String str8 = " AND (" + paramString + ')'; ; str8 = "")
      {
        String str9 = str8;
        b(localSQLiteDatabase, str9, paramArrayOfString);
        i1 = localSQLiteDatabase.delete("photos", str9, paramArrayOfString);
        break;
      }
      i1 = localSQLiteDatabase.delete("albums", paramString, paramArrayOfString);
      continue;
      String str6 = (String)paramUri.getPathSegments().get(1);
      i1 = localSQLiteDatabase.delete("albums", "_id=" + str6, null);
      continue;
      String str5 = (String)paramUri.getPathSegments().get(2);
      i1 = localSQLiteDatabase.delete("albums", "aid=" + DatabaseUtils.sqlEscapeString(str5), null);
      continue;
      String str3 = (String)paramUri.getPathSegments().get(2);
      StringBuilder localStringBuilder1 = new StringBuilder().append("owner=").append(str3);
      if (!TextUtils.isEmpty(paramString));
      for (String str4 = " AND (" + paramString + ')'; ; str4 = "")
      {
        i1 = localSQLiteDatabase.delete("albums", str4, paramArrayOfString);
        break;
      }
      a(localSQLiteDatabase, paramString, paramArrayOfString);
      i1 = localSQLiteDatabase.delete("stream_photos", paramString, paramArrayOfString);
      continue;
      String str1 = (String)paramUri.getPathSegments().get(1);
      String str2 = "_id=" + str1;
      a(localSQLiteDatabase, str2, null);
      i1 = localSQLiteDatabase.delete("stream_photos", str2, null);
    }
  }

  protected int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i1 = 0;
    SQLiteDatabase localSQLiteDatabase = this.t.getWritableDatabase();
    int i4;
    switch (p.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      i4 = 0;
    case 4:
      while (i1 < paramArrayOfContentValues.length)
      {
        if (localSQLiteDatabase.insert("photos", "pid", paramArrayOfContentValues[i1]) > 0L)
          i4++;
        i1++;
        continue;
        int i5 = 0;
        int i6 = 0;
        while (i5 < paramArrayOfContentValues.length)
        {
          paramArrayOfContentValues[i5].put("aid", (String)paramUri.getPathSegments().get(2));
          if (localSQLiteDatabase.insert("photos", "pid", paramArrayOfContentValues[i5]) > 0L)
            i6++;
          i5++;
        }
        i4 = i6;
      }
    case 10:
    case 13:
    }
    while (i4 > 0)
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i4;
      i4 = 0;
      while (i1 < paramArrayOfContentValues.length)
      {
        if (localSQLiteDatabase.insert("albums", "aid", paramArrayOfContentValues[i1]) > 0L)
          i4++;
        i1++;
      }
      int i2 = 0;
      int i3 = 0;
      while (i2 < paramArrayOfContentValues.length)
      {
        paramArrayOfContentValues[i2].put("owner", (String)paramUri.getPathSegments().get(2));
        if (localSQLiteDatabase.insert("albums", "aid", paramArrayOfContentValues[i2]) > 0L)
          i3++;
        i2++;
      }
      i4 = i3;
    }
    throw new SQLException("Failed to insert rows into " + paramUri);
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    String str;
    switch (p.match(paramUri))
    {
    case 6:
    case 7:
    case 8:
    case 9:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      localSQLiteQueryBuilder.setTables("photos");
      localSQLiteQueryBuilder.setProjectionMap(q);
      str = a(paramString2);
    case 2:
    case 3:
    case 4:
    case 5:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 20:
    case 21:
    }
    while (true)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.t.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
      localSQLiteQueryBuilder.setTables("photos");
      localSQLiteQueryBuilder.appendWhere("_id=" + (String)paramUri.getPathSegments().get(1));
      localSQLiteQueryBuilder.setProjectionMap(q);
      str = null;
      continue;
      localSQLiteQueryBuilder.setTables("photos");
      localSQLiteQueryBuilder.appendWhere("pid=" + DatabaseUtils.sqlEscapeString((String)paramUri.getPathSegments().get(2)));
      localSQLiteQueryBuilder.setProjectionMap(q);
      str = null;
      continue;
      localSQLiteQueryBuilder.setTables("photos");
      localSQLiteQueryBuilder.appendWhere("aid=" + DatabaseUtils.sqlEscapeString((String)paramUri.getPathSegments().get(2)));
      localSQLiteQueryBuilder.setProjectionMap(q);
      str = a(paramString2);
      continue;
      localSQLiteQueryBuilder.setTables("photos");
      localSQLiteQueryBuilder.appendWhere("object_id=" + DatabaseUtils.sqlEscapeString((String)paramUri.getPathSegments().get(2)));
      localSQLiteQueryBuilder.setProjectionMap(q);
      str = null;
      continue;
      localSQLiteQueryBuilder.setTables("albums");
      localSQLiteQueryBuilder.setProjectionMap(r);
      str = b(paramString2);
      continue;
      localSQLiteQueryBuilder.setTables("albums");
      localSQLiteQueryBuilder.appendWhere("_id=" + (String)paramUri.getPathSegments().get(1));
      localSQLiteQueryBuilder.setProjectionMap(r);
      str = null;
      continue;
      localSQLiteQueryBuilder.setTables("albums");
      localSQLiteQueryBuilder.appendWhere("aid=" + DatabaseUtils.sqlEscapeString((String)paramUri.getPathSegments().get(2)));
      localSQLiteQueryBuilder.setProjectionMap(r);
      str = null;
      continue;
      localSQLiteQueryBuilder.setTables("albums");
      localSQLiteQueryBuilder.appendWhere("owner=" + DatabaseUtils.sqlEscapeString((String)paramUri.getPathSegments().get(2)));
      localSQLiteQueryBuilder.setProjectionMap(r);
      str = b(paramString2);
      continue;
      localSQLiteQueryBuilder.setTables("albums");
      localSQLiteQueryBuilder.appendWhere("object_id=" + DatabaseUtils.sqlEscapeString((String)paramUri.getPathSegments().get(2)));
      localSQLiteQueryBuilder.setProjectionMap(r);
      str = null;
      continue;
      localSQLiteQueryBuilder.setTables("stream_photos");
      localSQLiteQueryBuilder.setProjectionMap(s);
      str = c(paramString2);
      continue;
      localSQLiteQueryBuilder.setTables("stream_photos");
      localSQLiteQueryBuilder.appendWhere("_id=" + (String)paramUri.getPathSegments().get(1));
      str = null;
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (paramContentValues != null);
    SQLiteDatabase localSQLiteDatabase;
    for (ContentValues localContentValues = new ContentValues(paramContentValues); ; localContentValues = new ContentValues())
    {
      localSQLiteDatabase = this.t.getWritableDatabase();
      switch (p.match(paramUri))
      {
      default:
        throw new IllegalArgumentException("Unknown URL " + paramUri);
      case 1:
      case 4:
      case 10:
      case 13:
      case 20:
      }
    }
    long l5 = localSQLiteDatabase.insert("photos", "pid", localContentValues);
    if (l5 > 0L)
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      Uri localUri = Uri.withAppendedPath(a, String.valueOf(l5));
      while (true)
      {
        return localUri;
        localContentValues.put("aid", (String)paramUri.getPathSegments().get(2));
        long l4 = localSQLiteDatabase.insert("photos", "pid", localContentValues);
        if (l4 <= 0L)
          break;
        getContext().getContentResolver().notifyChange(paramUri, null);
        localUri = Uri.withAppendedPath(a, String.valueOf(l4));
        continue;
        long l3 = localSQLiteDatabase.insert("albums", "aid", localContentValues);
        if (l3 <= 0L)
          break;
        getContext().getContentResolver().notifyChange(paramUri, null);
        localUri = Uri.withAppendedPath(e, String.valueOf(l3));
        continue;
        localContentValues.put("owner", (String)paramUri.getPathSegments().get(2));
        long l2 = localSQLiteDatabase.insert("albums", "aid", localContentValues);
        if (l2 <= 0L)
          break;
        getContext().getContentResolver().notifyChange(paramUri, null);
        localUri = Uri.withAppendedPath(e, String.valueOf(l2));
        continue;
        long l1 = localSQLiteDatabase.insert("stream_photos", "url", localContentValues);
        if (l1 <= 0L)
          break;
        getContext().getContentResolver().notifyChange(paramUri, null);
        localUri = Uri.withAppendedPath(i, String.valueOf(l1));
      }
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }

  protected String a(Uri paramUri)
  {
    String str;
    switch (p.match(paramUri))
    {
    case 6:
    case 7:
    case 8:
    case 9:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
      str = "vnd.android.cursor.item/vnd.facebook.katana.photos";
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 20:
    case 21:
    }
    while (true)
    {
      return str;
      str = "vnd.android.cursor.item/vnd.facebook.katana.albums";
      continue;
      str = "vnd.android.cursor.item/vnd.facebook.katana.stream_photos";
    }
  }

  public boolean onCreate()
  {
    this.t = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.PhotosProvider
 * JD-Core Version:    0.6.0
 */