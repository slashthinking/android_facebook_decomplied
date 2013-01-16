package com.facebook.katana.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.FileUtils;
import com.facebook.common.util.Tuple;
import com.facebook.content.SecureContentProvider;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.connections.ConnectionsContract.ConnectionType;
import com.facebook.ipc.connections.ConnectionsContract.Selectors;
import com.facebook.katana.binding.ProfileImage;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.platform.PlatformStorage;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.PlatformUtils;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class ConnectionsProvider extends SecureContentProvider
{
  static final String a;
  private static final String b;
  private static final HashMap<String, String> c;
  private static final HashMap<String, String> d;
  private static final HashMap<String, String> e;
  private static final Set<String> f;
  private static final UriMatcher g;
  private FacebookDatabaseHelper h;

  static
  {
    int i = 0;
    b = "CREATE TABLE connections (_id INTEGER PRIMARY KEY,user_id INT UNIQUE,display_name TEXT,connection_type INT NOT NULL DEFAULT " + ConnectionsContract.ConnectionType.USER.ordinal() + "," + "user_image_url" + " TEXT," + "user_image" + " BLOB," + "hash" + " INT);";
    Object[] arrayOfObject = new Object[20];
    arrayOfObject[0] = "friends";
    arrayOfObject[1] = "connections";
    arrayOfObject[2] = "friends_data";
    arrayOfObject[3] = Integer.valueOf(ConnectionsContract.ConnectionType.USER.ordinal());
    arrayOfObject[4] = "_id";
    arrayOfObject[5] = "user_id";
    arrayOfObject[6] = "display_name";
    arrayOfObject[7] = "connection_type";
    arrayOfObject[8] = "user_image_url";
    arrayOfObject[9] = "user_image";
    arrayOfObject[10] = "hash";
    arrayOfObject[11] = "first_name";
    arrayOfObject[12] = "last_name";
    arrayOfObject[13] = "cell";
    arrayOfObject[14] = "other";
    arrayOfObject[15] = "email";
    arrayOfObject[16] = "birthday_month";
    arrayOfObject[17] = "birthday_day";
    arrayOfObject[18] = "birthday_year";
    arrayOfObject[19] = "search_token";
    a = StringLocaleUtil.a("CREATE VIEW %1$s AS SELECT %2$s.%5$s AS %5$s, %2$s.%6$s AS %6$s, %2$s.%7$s AS %7$s, %2$s.%8$s AS %8$s, %2$s.%9$s AS %9$s, %2$s.%10$s AS %10$s, %2$s.%11$s AS %11$s, %3$s.%12$s AS %12$s, %3$s.%13$s AS %13$s, %3$s.%14$s AS %14$s, %3$s.%15$s AS %15$s, %3$s.%16$s AS %16$s, %3$s.%17$s AS %17$s, %3$s.%18$s AS %18$s, %3$s.%19$s AS %19$s, %3$s.%20$s AS %20$s FROM %2$s LEFT OUTER JOIN %3$s ON %2$s.%6$s=%3$s.%6$s WHERE %2$s.%8$s=%4$d;", arrayOfObject);
    g = new UriMatcher(-1);
    ConnectionsContract.Selectors[] arrayOfSelectors = ConnectionsContract.Selectors.values();
    int j = arrayOfSelectors.length;
    while (i < j)
    {
      ConnectionsContract.Selectors localSelectors = arrayOfSelectors[i];
      String str = localSelectors.category + localSelectors.uriSuffix + localSelectors.uriMatcherSuffix;
      g.addURI(ConnectionsContract.a, str, localSelectors.uriMatcherIndex());
      i++;
    }
    c = new ConnectionsProvider.1();
    d = new ConnectionsProvider.2();
    e = new ConnectionsProvider.3();
    f = new ConnectionsProvider.4();
  }

  // ERROR //
  public static com.facebook.ipc.model.FacebookProfile a(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_2
    //   3: anewarray 170	java/lang/String
    //   6: dup
    //   7: iconst_0
    //   8: ldc 85
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: ldc 49
    //   15: aastore
    //   16: astore 4
    //   18: aload_0
    //   19: invokevirtual 176	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: getstatic 179	com/facebook/ipc/connections/ConnectionsContract:e	Landroid/net/Uri;
    //   25: lload_1
    //   26: invokestatic 185	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   29: aload 4
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 191	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore 6
    //   39: aload 6
    //   41: invokeinterface 197 1 0
    //   46: ifeq +61 -> 107
    //   49: new 199	com/facebook/ipc/model/FacebookProfile
    //   52: dup
    //   53: lload_1
    //   54: aload 6
    //   56: aload 6
    //   58: ldc 85
    //   60: invokeinterface 203 2 0
    //   65: invokeinterface 207 2 0
    //   70: aload 6
    //   72: aload 6
    //   74: ldc 49
    //   76: invokeinterface 203 2 0
    //   81: invokeinterface 207 2 0
    //   86: iconst_0
    //   87: invokespecial 210	com/facebook/ipc/model/FacebookProfile:<init>	(JLjava/lang/String;Ljava/lang/String;I)V
    //   90: astore 7
    //   92: aload 6
    //   94: ifnull +10 -> 104
    //   97: aload 6
    //   99: invokeinterface 213 1 0
    //   104: aload 7
    //   106: areturn
    //   107: aload 6
    //   109: ifnull +10 -> 119
    //   112: aload 6
    //   114: invokeinterface 213 1 0
    //   119: aconst_null
    //   120: astore 7
    //   122: goto -18 -> 104
    //   125: astore 5
    //   127: aload_3
    //   128: ifnull +9 -> 137
    //   131: aload_3
    //   132: invokeinterface 213 1 0
    //   137: aload 5
    //   139: athrow
    //   140: astore 5
    //   142: aload 6
    //   144: astore_3
    //   145: goto -18 -> 127
    //
    // Exception table:
    //   from	to	target	type
    //   18	39	125	finally
    //   39	92	140	finally
  }

  public static ProfileImage a(Context paramContext, long paramLong, String paramString1, String paramString2)
  {
    Bitmap localBitmap = ImageUtils.a(paramString2, new BitmapFactory.Options());
    byte[] arrayOfByte = FileUtils.a(new File(paramString2));
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("user_image", arrayOfByte);
    localContentValues.put("user_image_url", paramString1);
    Uri localUri = ContentUris.withAppendedId(ConnectionsContract.c, paramLong);
    paramContext.getContentResolver().update(localUri, localContentValues, null, null);
    if (PlatformUtils.a(paramContext))
      PlatformStorage.a(paramContext, paramLong, arrayOfByte);
    return new ProfileImage(paramLong, paramString1, localBitmap);
  }

  private static RuntimeException a(RuntimeException paramRuntimeException, String paramString)
  {
    if ((FacebookAffiliation.b()) || (BuildConstants.a()));
    while (true)
    {
      return paramRuntimeException;
      paramRuntimeException = new IllegalArgumentException(paramString);
    }
  }

  public static String[] a()
  {
    return new String[] { "connections", "friends_data", "search_results" };
  }

  static String[] b()
  {
    return new String[] { "friends" };
  }

  public static String[] c()
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = b;
    arrayOfString[1] = "CREATE TABLE friends_data (_id INTEGER PRIMARY KEY,user_id INT UNIQUE,first_name TEXT,last_name TEXT,cell TEXT,other TEXT,email TEXT,birthday_month INT,birthday_day INT,birthday_year INT,search_token TEXT);";
    arrayOfString[2] = "CREATE TABLE search_results (_id INTEGER PRIMARY KEY,user_id INT,display_name TEXT,user_image_url TEXT);";
    arrayOfString[3] = a;
    return arrayOfString;
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.h.getWritableDatabase();
    int i = g.match(paramUri);
    String str1;
    int j;
    if ((i == ConnectionsContract.Selectors.CONNECTION_ID.uriMatcherIndex()) || (i == ConnectionsContract.Selectors.PAGE_ID.uriMatcherIndex()))
    {
      str1 = (String)paramUri.getPathSegments().get(2);
      try
      {
        Long.parseLong(str1);
        if (i == ConnectionsContract.Selectors.CONNECTION_ID.uriMatcherIndex())
        {
          if (!paramContentValues.containsKey("connection_type"))
            break label191;
          throw new IllegalArgumentException("connection updates should not touch the connection type column");
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        ErrorReporting.a("ConnectionsProvider", "URI must have a long argument: uri=" + paramUri, localNumberFormatException1);
        j = 0;
      }
    }
    label401: label673: label683: 
    while (true)
    {
      return j;
      if (i == ConnectionsContract.Selectors.PAGE_ID.uriMatcherIndex())
      {
        Integer localInteger1 = paramContentValues.getAsInteger("connection_type");
        if ((localInteger1 != null) && (localInteger1.intValue() != ConnectionsContract.ConnectionType.PAGE_ADMIN.ordinal()) && (localInteger1.intValue() != ConnectionsContract.ConnectionType.PAGE_FAN.ordinal()))
          throw new IllegalArgumentException("page updates must stay PAGE_ADMIN or PAGE_FAN");
      }
      label191: if (paramContentValues.size() != 0);
      for (j = localSQLiteDatabase.update("connections", paramContentValues, "user_id=" + str1, null); ; j = 0)
      {
        if (j <= 0)
          break label683;
        if (i == ConnectionsContract.Selectors.CONNECTION_ID.uriMatcherIndex())
        {
          getContext().getContentResolver().notifyChange(ConnectionsContract.b, null);
          getContext().getContentResolver().notifyChange(ConnectionsContract.d, null);
        }
        getContext().getContentResolver().notifyChange(ConnectionsContract.i, null);
        break;
        String str2;
        ContentValues localContentValues1;
        ContentValues localContentValues2;
        if (i == ConnectionsContract.Selectors.FRIEND_UID.uriMatcherIndex())
        {
          str2 = (String)paramUri.getPathSegments().get(2);
          try
          {
            Long.parseLong(str2);
            Integer localInteger2 = paramContentValues.getAsInteger("connection_type");
            if ((localInteger2 == null) || (localInteger2.intValue() == ConnectionsContract.ConnectionType.USER.ordinal()))
              break label401;
            throw new IllegalArgumentException("user updates must not change connection type");
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            ErrorReporting.a("NumberFormatException: URI must have a long argument", "uri " + paramUri + " must contain a long");
            j = 0;
          }
          break;
          Tuple localTuple = a(paramContentValues);
          localContentValues1 = (ContentValues)localTuple.a;
          localContentValues2 = (ContentValues)localTuple.b;
          localSQLiteDatabase.beginTransaction();
        }
        while (true)
        {
          try
          {
            if (localContentValues1.size() == 0)
              break label673;
            k = localSQLiteDatabase.update("connections", localContentValues1, "user_id=" + str2, null);
            int m = localContentValues2.size();
            int n = 0;
            if (m == 0)
              continue;
            n = localSQLiteDatabase.update("friends_data", localContentValues2, "user_id=" + str2, null);
            if ((k == 0) || (n != 0))
              continue;
            localContentValues2.put("user_id", Long.valueOf(Long.parseLong(str2)));
            localSQLiteDatabase.insert("friends_data", null, localContentValues2);
            j = n;
            localSQLiteDatabase.setTransactionSuccessful();
            localSQLiteDatabase.endTransaction();
            if ((k <= 0) && (j <= 0))
              continue;
            getContext().getContentResolver().notifyChange(ConnectionsContract.b, null);
            getContext().getContentResolver().notifyChange(ConnectionsContract.d, null);
            if (k <= j)
              break;
            j = k;
            break;
          }
          catch (RuntimeException localRuntimeException)
          {
            throw a(localRuntimeException, "Error on updating connections/friends");
          }
          finally
          {
            localSQLiteDatabase.endTransaction();
          }
          throw new IllegalArgumentException("Unknown URL " + paramUri);
          int k = 0;
        }
      }
    }
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.h.getWritableDatabase();
    int i = g.match(paramUri);
    if (i == ConnectionsContract.Selectors.CONNECTIONS_CONTENT.uriMatcherIndex())
      localSQLiteDatabase.beginTransaction();
    while (true)
    {
      int k;
      try
      {
        j = localSQLiteDatabase.delete("connections", paramString, paramArrayOfString);
        k = localSQLiteDatabase.delete("friends_data", paramString, paramArrayOfString);
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        if ((j <= 0) && (k <= 0))
          continue;
        getContext().getContentResolver().notifyChange(ConnectionsContract.b, null);
        getContext().getContentResolver().notifyChange(ConnectionsContract.d, null);
        getContext().getContentResolver().notifyChange(ConnectionsContract.i, null);
        if (j > k)
          return j;
      }
      catch (RuntimeException localRuntimeException)
      {
        throw a(localRuntimeException, "Error on deleting connections/friends");
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      int j = k;
      continue;
      if (i != ConnectionsContract.Selectors.SEARCH_CONTENT.uriMatcherIndex())
        break;
      j = localSQLiteDatabase.delete("search_results", paramString, paramArrayOfString);
      if (j <= 0)
        continue;
      getContext().getContentResolver().notifyChange(ConnectionsContract.l, null);
    }
    throw new IllegalArgumentException("Unknown URL " + paramUri);
  }

  protected int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = this.h.getWritableDatabase();
    int i = g.match(paramUri);
    Thread localThread = Thread.currentThread();
    if (i == ConnectionsContract.Selectors.FRIENDS_CONTENT.uriMatcherIndex())
      localSQLiteDatabase.beginTransaction();
    int i2;
    int i3;
    while (true)
    {
      int n;
      try
      {
        int i7 = paramArrayOfContentValues.length;
        int i8 = 0;
        int i9 = 0;
        n = 0;
        if (i8 >= i7)
          continue;
        ContentValues localContentValues3 = paramArrayOfContentValues[i8];
        if (!localThread.isInterrupted())
          continue;
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        if (n == 0)
          continue;
        getContext().getContentResolver().notifyChange(ConnectionsContract.b, null);
        getContext().getContentResolver().notifyChange(ConnectionsContract.d, null);
        if (i9 <= 0)
          continue;
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = Integer.valueOf(i9);
        ErrorReporting.a("Failed call to friendsInsert", StringLocaleUtil.a("Failed friendsInsert on %d rows", arrayOfObject4));
        return n;
        Uri localUri3 = a(localSQLiteDatabase, localContentValues3);
        if (localUri3 == null)
          continue;
        n++;
        i8++;
        continue;
        i9++;
        continue;
      }
      catch (RuntimeException localRuntimeException4)
      {
        throw a(localRuntimeException4, "Error in bulk insert friends");
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      if (i == ConnectionsContract.Selectors.PAGES_CONTENT.uriMatcherIndex())
      {
        localSQLiteDatabase.beginTransaction();
        try
        {
          int i4 = paramArrayOfContentValues.length;
          int i5 = 0;
          int i6 = 0;
          n = 0;
          ContentValues localContentValues2;
          if (i5 < i4)
          {
            localContentValues2 = paramArrayOfContentValues[i5];
            if (!localThread.isInterrupted());
          }
          else
          {
            localSQLiteDatabase.setTransactionSuccessful();
            localSQLiteDatabase.endTransaction();
            if (n != 0)
              getContext().getContentResolver().notifyChange(ConnectionsContract.l, null);
            if (i6 <= 0)
              continue;
            Object[] arrayOfObject3 = new Object[1];
            arrayOfObject3[0] = Integer.valueOf(i6);
            ErrorReporting.a("Failed call to pagesInsert", StringLocaleUtil.a("Failed pagesInsert on %d rows", arrayOfObject3));
            continue;
          }
          Uri localUri2 = b(localSQLiteDatabase, localContentValues2);
          if (localUri2 != null)
            n++;
          while (true)
          {
            i5++;
            break;
            i6++;
          }
        }
        catch (RuntimeException localRuntimeException3)
        {
          throw a(localRuntimeException3, "Error in bulk insert pages");
        }
        finally
        {
          localSQLiteDatabase.endTransaction();
        }
      }
      if (i == ConnectionsContract.Selectors.SEARCH_CONTENT.uriMatcherIndex())
      {
        localSQLiteDatabase.beginTransaction();
        try
        {
          int i1 = paramArrayOfContentValues.length;
          i2 = 0;
          i3 = 0;
          n = 0;
          if (i2 < i1)
          {
            if (localSQLiteDatabase.insert("search_results", "user_id", paramArrayOfContentValues[i2]) <= 0L)
              break label699;
            n++;
            break label693;
          }
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          if (n != 0)
            getContext().getContentResolver().notifyChange(ConnectionsContract.l, null);
          if (i3 <= 0)
            continue;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Integer.valueOf(i3);
          ErrorReporting.a("Failed insert into SEARCH_RESULTS_TABLE", StringLocaleUtil.a("Failed on %d rows", arrayOfObject2));
          continue;
        }
        catch (RuntimeException localRuntimeException2)
        {
          throw a(localRuntimeException2, "Error in bulk insert of search results");
        }
        finally
        {
          localSQLiteDatabase.endTransaction();
        }
      }
      if (i != ConnectionsContract.Selectors.CONNECTIONS_CONTENT.uriMatcherIndex())
        break;
      localSQLiteDatabase.beginTransaction();
      try
      {
        int j = paramArrayOfContentValues.length;
        int k = 0;
        int m = 0;
        n = 0;
        ContentValues localContentValues1;
        if (k < j)
        {
          localContentValues1 = paramArrayOfContentValues[k];
          if (!localThread.isInterrupted());
        }
        else
        {
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          if (n != 0)
            getContext().getContentResolver().notifyChange(ConnectionsContract.b, null);
          if (m <= 0)
            continue;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Integer.valueOf(m);
          ErrorReporting.a("Failed call to connectionsInsert", StringLocaleUtil.a("Failed connectionsInsert on %d rows", arrayOfObject1));
          continue;
        }
        Uri localUri1 = c(localSQLiteDatabase, localContentValues1);
        if (localUri1 != null)
          n++;
        while (true)
        {
          k++;
          break;
          m++;
        }
      }
      catch (RuntimeException localRuntimeException1)
      {
        throw a(localRuntimeException1, "Error in bulk insert connections");
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
    }
    throw new IllegalArgumentException("Unknown URL " + paramUri);
    while (true)
    {
      label693: i2++;
      break;
      label699: i3++;
    }
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    int i = g.match(paramUri);
    String str2;
    String str1;
    if (i == ConnectionsContract.Selectors.CONNECTIONS_CONTENT.uriMatcherIndex())
    {
      localSQLiteQueryBuilder.setTables("connections");
      localSQLiteQueryBuilder.setProjectionMap(c);
      str2 = "display_name ASC";
      str1 = null;
    }
    String str3;
    label64: HashMap localHashMap;
    GregorianCalendar localGregorianCalendar;
    int j;
    while (true)
      if (TextUtils.isEmpty(paramString2))
      {
        str3 = str2;
        Cursor localCursor = localSQLiteQueryBuilder.query(this.h.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str3, str1);
        localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
        return localCursor;
        if (i == ConnectionsContract.Selectors.CONNECTION_ID.uriMatcherIndex())
        {
          localSQLiteQueryBuilder.setTables("connections");
          localSQLiteQueryBuilder.appendWhere("user_id=" + (String)paramUri.getPathSegments().get(2));
          localSQLiteQueryBuilder.setProjectionMap(c);
          str2 = "display_name ASC";
          str1 = null;
          continue;
        }
        if (i == ConnectionsContract.Selectors.FRIENDS_CONTENT.uriMatcherIndex())
        {
          localSQLiteQueryBuilder.setTables("friends");
          localSQLiteQueryBuilder.setProjectionMap(d);
          str2 = "display_name ASC";
          str1 = null;
          continue;
        }
        if (i == ConnectionsContract.Selectors.FRIEND_UID.uriMatcherIndex())
        {
          localSQLiteQueryBuilder.setTables("friends");
          localSQLiteQueryBuilder.appendWhere("user_id=" + (String)paramUri.getPathSegments().get(2));
          localSQLiteQueryBuilder.setProjectionMap(d);
          str2 = "display_name ASC";
          str1 = null;
          continue;
        }
        if (i == ConnectionsContract.Selectors.FRIENDS_SEARCH.uriMatcherIndex())
        {
          String str5 = (String)paramUri.getPathSegments().get(2);
          localSQLiteQueryBuilder.setTables("friends");
          localSQLiteQueryBuilder.setProjectionMap(d);
          localSQLiteQueryBuilder.appendWhere("display_name LIKE ");
          localSQLiteQueryBuilder.appendWhereEscapeString("%" + str5 + "%");
          str1 = "15";
          str2 = "display_name ASC";
          continue;
        }
        if (i == ConnectionsContract.Selectors.FRIENDS_PREFIX_SEARCH.uriMatcherIndex())
        {
          StringTokenizer localStringTokenizer = new StringTokenizer((String)paramUri.getPathSegments().get(2));
          localSQLiteQueryBuilder.setTables("friends");
          localSQLiteQueryBuilder.setProjectionMap(d);
          localSQLiteQueryBuilder.appendWhere("search_token LIKE ");
          localSQLiteQueryBuilder.appendWhereEscapeString("% " + localStringTokenizer.nextToken() + "%");
          while (localStringTokenizer.hasMoreTokens())
          {
            localSQLiteQueryBuilder.appendWhere(" AND search_token LIKE ");
            localSQLiteQueryBuilder.appendWhereEscapeString("% " + localStringTokenizer.nextToken() + "%");
          }
          str1 = "15";
          str2 = "display_name ASC";
          continue;
        }
        if (i == ConnectionsContract.Selectors.FRIENDS_BIRTHDAYS.uriMatcherIndex())
        {
          localHashMap = new HashMap(d);
          localGregorianCalendar = new GregorianCalendar();
          if (localGregorianCalendar.get(2) > 1)
            break;
          if (localGregorianCalendar.isLeapYear(localGregorianCalendar.get(1)))
            break label1100;
          j = 1;
        }
      }
    while (true)
    {
      label602: if (j != 0)
        localHashMap.put("normalized_birthday_day", "CASE WHEN (friends.birthday_month=2 AND            friends.birthday_day=29) THEN 28      ELSE friends.birthday_day END AS normalized_birthday_day");
      while (true)
      {
        localSQLiteQueryBuilder.setTables("friends");
        localSQLiteQueryBuilder.appendWhere("birthday_month!=-1 AND birthday_day!=-1");
        localSQLiteQueryBuilder.setProjectionMap(localHashMap);
        str2 = "display_name ASC";
        str1 = null;
        break;
        if (localGregorianCalendar.isLeapYear(1 + localGregorianCalendar.get(1)))
          break label1100;
        j = 1;
        break label602;
        localHashMap.put("normalized_birthday_day", "birthday_day");
      }
      if (i == ConnectionsContract.Selectors.PAGES_CONTENT.uriMatcherIndex())
      {
        localSQLiteQueryBuilder.setTables("connections");
        localSQLiteQueryBuilder.setProjectionMap(c);
        Object[] arrayOfObject3 = new Object[3];
        arrayOfObject3[0] = "connection_type";
        arrayOfObject3[1] = Integer.valueOf(ConnectionsContract.ConnectionType.PAGE_ADMIN.ordinal());
        arrayOfObject3[2] = Integer.valueOf(ConnectionsContract.ConnectionType.PAGE_FAN.ordinal());
        localSQLiteQueryBuilder.appendWhere(StringLocaleUtil.a("(%1$s=%2$d OR %1$s=%3$d)", arrayOfObject3));
        str2 = "display_name ASC";
        str1 = null;
        break;
      }
      if (i == ConnectionsContract.Selectors.PAGE_ID.uriMatcherIndex())
      {
        localSQLiteQueryBuilder.setTables("connections");
        Object[] arrayOfObject2 = new Object[5];
        arrayOfObject2[0] = "user_id";
        arrayOfObject2[1] = paramUri.getPathSegments().get(2);
        arrayOfObject2[2] = "connection_type";
        arrayOfObject2[3] = Integer.valueOf(ConnectionsContract.ConnectionType.PAGE_ADMIN.ordinal());
        arrayOfObject2[4] = Integer.valueOf(ConnectionsContract.ConnectionType.PAGE_FAN.ordinal());
        localSQLiteQueryBuilder.appendWhere(StringLocaleUtil.a("%1$s=%2$s AND (%3$s=%4$d OR %3$s=%5$d)", arrayOfObject2));
        localSQLiteQueryBuilder.setProjectionMap(c);
        str2 = "display_name ASC";
        str1 = null;
        break;
      }
      if (i == ConnectionsContract.Selectors.PAGES_SEARCH.uriMatcherIndex())
      {
        String str4 = (String)paramUri.getPathSegments().get(2);
        localSQLiteQueryBuilder.setTables("connections");
        localSQLiteQueryBuilder.setProjectionMap(c);
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = "connection_type";
        arrayOfObject1[1] = Integer.valueOf(ConnectionsContract.ConnectionType.PAGE_ADMIN.ordinal());
        arrayOfObject1[2] = Integer.valueOf(ConnectionsContract.ConnectionType.PAGE_FAN.ordinal());
        localSQLiteQueryBuilder.appendWhere(StringLocaleUtil.a("(%1$s=%2$d OR %1$s=%3$d)", arrayOfObject1));
        localSQLiteQueryBuilder.appendWhere(" AND display_name LIKE ");
        localSQLiteQueryBuilder.appendWhereEscapeString(str4 + "%");
        str1 = "15";
        str2 = "display_name ASC";
        break;
      }
      if (i == ConnectionsContract.Selectors.SEARCH_CONTENT.uriMatcherIndex())
      {
        localSQLiteQueryBuilder.setTables("search_results");
        localSQLiteQueryBuilder.setProjectionMap(e);
        str2 = "_id ASC";
        str1 = null;
        break;
      }
      throw new IllegalArgumentException("Unknown URL " + paramUri);
      str3 = paramString2;
      break label64;
      label1100: j = 0;
    }
  }

  protected Uri a(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues)
  {
    if (!paramContentValues.containsKey("user_id"))
      throw new IllegalArgumentException("friends inserts must contain a uid");
    paramContentValues.put("connection_type", Integer.valueOf(ConnectionsContract.ConnectionType.USER.ordinal()));
    Tuple localTuple = a(paramContentValues);
    ContentValues localContentValues1 = (ContentValues)localTuple.a;
    ContentValues localContentValues2 = (ContentValues)localTuple.b;
    paramSQLiteDatabase.beginTransaction();
    while (true)
    {
      try
      {
        if ((localContentValues1.size() == 0) || (paramSQLiteDatabase.insert("connections", null, localContentValues1) <= 0L))
          break label169;
        i = 1;
        if ((localContentValues2.size() == 0) || (paramSQLiteDatabase.insert("friends_data", null, localContentValues2) <= 0L))
          continue;
        i = 1;
        paramSQLiteDatabase.setTransactionSuccessful();
        paramSQLiteDatabase.endTransaction();
        if (i != 0)
        {
          localUri = Uri.withAppendedPath(ConnectionsContract.e, paramContentValues.getAsString("user_id"));
          return localUri;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        throw a(localRuntimeException, "Error on inserting friends");
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      Uri localUri = null;
      continue;
      label169: int i = 0;
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = this.h.getWritableDatabase();
    int i = g.match(paramUri);
    Uri localUri;
    if (i == ConnectionsContract.Selectors.FRIENDS_CONTENT.uriMatcherIndex())
    {
      localUri = a(localSQLiteDatabase, paramContentValues);
      if (localUri == null)
        break label256;
      getContext().getContentResolver().notifyChange(ConnectionsContract.b, null);
      getContext().getContentResolver().notifyChange(ConnectionsContract.d, null);
    }
    while (true)
    {
      return localUri;
      if (i == ConnectionsContract.Selectors.PAGES_CONTENT.uriMatcherIndex())
      {
        localUri = b(localSQLiteDatabase, paramContentValues);
        if (localUri != null)
        {
          getContext().getContentResolver().notifyChange(ConnectionsContract.b, null);
          getContext().getContentResolver().notifyChange(ConnectionsContract.i, null);
          continue;
        }
      }
      else if (i == ConnectionsContract.Selectors.CONNECTIONS_CONTENT.uriMatcherIndex())
      {
        localUri = c(localSQLiteDatabase, paramContentValues);
        if (localUri != null)
        {
          getContext().getContentResolver().notifyChange(ConnectionsContract.b, null);
          continue;
        }
      }
      else
      {
        if (i == ConnectionsContract.Selectors.SEARCH_CONTENT.uriMatcherIndex())
        {
          long l = localSQLiteDatabase.insert("search_results", "display_name", paramContentValues);
          if (l > 0L)
            getContext().getContentResolver().notifyChange(ConnectionsContract.l, null);
          localUri = Uri.withAppendedPath(ConnectionsContract.l, String.valueOf(l));
          continue;
        }
        throw new IllegalArgumentException("Unknown URL " + paramUri);
      }
      label256: ErrorReporting.a("Single row insert failed", "Failed to insert row into " + paramUri);
      localUri = null;
    }
  }

  protected Tuple<ContentValues, ContentValues> a(ContentValues paramContentValues)
  {
    ContentValues localContentValues1 = new ContentValues(paramContentValues);
    ContentValues localContentValues2 = new ContentValues(paramContentValues);
    Iterator localIterator = paramContentValues.valueSet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)((Map.Entry)localIterator.next()).getKey();
      if (!c.containsKey(str))
        localContentValues1.remove(str);
      if (f.contains(str))
        continue;
      localContentValues2.remove(str);
    }
    return new Tuple(localContentValues1, localContentValues2);
  }

  protected String a(Uri paramUri)
  {
    if (g.match(paramUri) > 0)
      return "vnd.android.cursor.item/vnd.com.facebook.katana.provider.friends";
    throw new IllegalArgumentException("Unknown URL " + paramUri);
  }

  protected Uri b(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues)
  {
    if (!paramContentValues.containsKey("user_id"))
      throw new IllegalArgumentException("pages inserts must contain a id");
    Integer localInteger = paramContentValues.getAsInteger("connection_type");
    if (localInteger == null)
      throw new IllegalArgumentException("pages inserts must contain a connection type, and it must be an integer");
    if ((localInteger.intValue() != ConnectionsContract.ConnectionType.PAGE_ADMIN.ordinal()) && (localInteger.intValue() != ConnectionsContract.ConnectionType.PAGE_FAN.ordinal()))
      throw new IllegalArgumentException("pages inserts must be PAGE_ADMIN or PAGE_FAN");
    boolean bool = paramSQLiteDatabase.insert("connections", null, paramContentValues) < 0L;
    Uri localUri = null;
    if (bool)
      localUri = Uri.withAppendedPath(ConnectionsContract.j, paramContentValues.getAsString("user_id"));
    return localUri;
  }

  protected Uri c(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues)
  {
    if (!paramContentValues.containsKey("user_id"))
      throw new IllegalArgumentException("connections inserts must contain a id");
    if (paramContentValues.getAsInteger("connection_type") == null)
      throw new IllegalArgumentException("connections inserts must contain a connection type, and it must be an integer");
    boolean bool = paramSQLiteDatabase.insert("connections", null, paramContentValues) < 0L;
    Uri localUri = null;
    if (bool)
      localUri = Uri.withAppendedPath(ConnectionsContract.c, paramContentValues.getAsString("user_id"));
    return localUri;
  }

  public boolean onCreate()
  {
    this.h = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.ConnectionsProvider
 * JD-Core Version:    0.6.0
 */