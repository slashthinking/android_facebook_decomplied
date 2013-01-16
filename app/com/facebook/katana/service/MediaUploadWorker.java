package com.facebook.katana.service;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.binding.AppSession;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MediaUploadWorker
{
  private static Map<Integer, String> d = new HashMap();
  private final Context a;
  private final AppSession b;
  private final MediaUploadWorker.DbOpenHelper c;

  MediaUploadWorker(Context paramContext, AppSession paramAppSession)
  {
    this.a = paramContext;
    this.b = paramAppSession;
    this.c = new MediaUploadWorker.DbOpenHelper(this, this.a);
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 < 0)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt1 == 0)
        continue;
      int j = c(paramInt1);
      if (System.currentTimeMillis() / 1000L - paramInt2 >= j)
        continue;
      i = 0;
    }
  }

  // ERROR //
  private String b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/facebook/katana/service/MediaUploadWorker:c	Lcom/facebook/katana/service/MediaUploadWorker$DbOpenHelper;
    //   4: invokevirtual 54	com/facebook/katana/service/MediaUploadWorker$DbOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 7
    //   9: iconst_4
    //   10: anewarray 4	java/lang/Object
    //   13: astore 8
    //   15: aload 8
    //   17: iconst_0
    //   18: ldc 56
    //   20: aastore
    //   21: aload 8
    //   23: iconst_1
    //   24: ldc 58
    //   26: aastore
    //   27: aload 8
    //   29: iconst_2
    //   30: ldc 60
    //   32: aastore
    //   33: aload 8
    //   35: iconst_3
    //   36: iload_1
    //   37: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aastore
    //   41: aload 7
    //   43: ldc 68
    //   45: aload 8
    //   47: invokestatic 73	com/facebook/orca/common/util/StringLocaleUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   50: aconst_null
    //   51: invokevirtual 79	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore 9
    //   56: aload 9
    //   58: astore_3
    //   59: aload_3
    //   60: invokeinterface 85 1 0
    //   65: istore 11
    //   67: aconst_null
    //   68: astore 6
    //   70: iload 11
    //   72: ifeq +23 -> 95
    //   75: aload_3
    //   76: aload_3
    //   77: ldc 56
    //   79: invokeinterface 89 2 0
    //   84: invokeinterface 92 2 0
    //   89: astore 12
    //   91: aload 12
    //   93: astore 6
    //   95: aload_3
    //   96: ifnull +9 -> 105
    //   99: aload_3
    //   100: invokeinterface 95 1 0
    //   105: aload 6
    //   107: areturn
    //   108: astore 5
    //   110: aconst_null
    //   111: astore_3
    //   112: aconst_null
    //   113: astore 6
    //   115: aload_3
    //   116: ifnull -11 -> 105
    //   119: aload_3
    //   120: invokeinterface 95 1 0
    //   125: aconst_null
    //   126: astore 6
    //   128: goto -23 -> 105
    //   131: astore_2
    //   132: aconst_null
    //   133: astore_3
    //   134: aload_2
    //   135: astore 4
    //   137: aload_3
    //   138: ifnull +9 -> 147
    //   141: aload_3
    //   142: invokeinterface 95 1 0
    //   147: aload 4
    //   149: athrow
    //   150: astore 4
    //   152: goto -15 -> 137
    //   155: astore 10
    //   157: goto -45 -> 112
    //
    // Exception table:
    //   from	to	target	type
    //   0	56	108	android/database/sqlite/SQLiteException
    //   0	56	131	finally
    //   59	91	150	finally
    //   59	91	155	android/database/sqlite/SQLiteException
  }

  private int c(int paramInt)
  {
    return (int)Math.pow(2.0D, 2 * Math.min(paramInt, 3));
  }

  private boolean d()
  {
    int i = d.size();
    int j = 0;
    if (i == 0)
      return j;
    Iterator localIterator = d.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        break label85;
      String str = (String)((Map.Entry)localIterator.next()).getValue();
      if (this.b.a(str))
      {
        j = 1;
        break;
      }
      localIterator.remove();
    }
    label85: if (d.size() > 0);
    for (int k = 1; ; k = 0)
    {
      j = k;
      break;
    }
  }

  public void a()
  {
    this.c.close();
  }

  public void a(int paramInt)
  {
    try
    {
      if (d.containsKey(Integer.valueOf(paramInt)))
        d.remove(Integer.valueOf(paramInt));
      Cursor localCursor2 = this.c.getWritableDatabase().query("pendingphotos", new String[] { "filename" }, "_id = " + paramInt, null, null, null, null);
      localCursor1 = localCursor2;
      try
      {
        boolean bool = localCursor1.moveToFirst();
        if (bool);
        try
        {
          this.c.getWritableDatabase().delete("pendingphotos", "_id = " + paramInt, null);
          if (localCursor1 != null)
            localCursor1.close();
          return;
        }
        catch (SQLiteException localSQLiteException)
        {
          while (true)
            ErrorReporting.a("PhotoUploadThread", "error removing in photo upload db", localSQLiteException);
        }
      }
      finally
      {
      }
      if (localCursor1 != null)
        localCursor1.close();
      throw localObject1;
    }
    finally
    {
      Cursor localCursor1 = null;
    }
  }

  public void a(int paramInt, String paramString)
  {
    a(paramInt);
  }

  public void a(Intent paramIntent)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("filename", paramIntent.getStringExtra("uri"));
    localContentValues.put("title", paramIntent.getStringExtra("subject"));
    localContentValues.put("caption", paramIntent.getStringExtra("description"));
    localContentValues.put("profileId", Long.valueOf(paramIntent.getLongExtra("profile_id", -1L)));
    localContentValues.put("target_id", Long.valueOf(paramIntent.getLongExtra("extra_status_target_id", -1L)));
    localContentValues.put("tags", paramIntent.getStringExtra("tags"));
    localContentValues.put("privacy", paramIntent.getStringExtra("extra_status_privacy"));
    localContentValues.put("retry_attempt", Integer.valueOf(0));
    localContentValues.put("retry_time", Long.valueOf(System.currentTimeMillis() / 1000L));
    localContentValues.put("logging_id", paramIntent.getStringExtra("camera_session_id"));
    localContentValues.put("type", MediaUploadWorker.Type.VIDEO.toString());
    localContentValues.put("place", Long.valueOf(paramIntent.getLongExtra("extra_place", -1L)));
    try
    {
      this.c.getWritableDatabase().insertOrThrow("pendingphotos", null, localContentValues);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
        ErrorReporting.a("error adding video upload to db", localSQLiteException.getMessage(), localSQLiteException);
    }
  }

  public boolean a(int paramInt, Class<?> paramClass)
  {
    int i = 0;
    b(paramInt);
    if (FileNotFoundException.class == paramClass)
      a(paramInt);
    while (true)
    {
      return i;
      if ((paramClass == null) || (IOException.class == paramClass))
      {
        try
        {
          SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
          Object[] arrayOfObject = new Object[7];
          arrayOfObject[0] = "pendingphotos";
          arrayOfObject[1] = "retry_attempt";
          arrayOfObject[2] = "retry_attempt";
          arrayOfObject[3] = "retry_time";
          arrayOfObject[4] = Long.valueOf(System.currentTimeMillis() / 1000L);
          arrayOfObject[5] = "_id";
          arrayOfObject[6] = Integer.valueOf(paramInt);
          localSQLiteDatabase.execSQL(StringLocaleUtil.a("UPDATE %s SET %s = %s + 1, %s = %d WHERE %s = %d", arrayOfObject));
          i = 1;
        }
        catch (SQLiteException localSQLiteException)
        {
          ErrorReporting.a("PhotoUploadThread", "error marking photo upload failed", localSQLiteException);
          a(paramInt);
          i = 0;
        }
        continue;
      }
      a(paramInt);
      i = 0;
    }
  }

  public void b()
  {
    try
    {
      this.c.getWritableDatabase().delete("pendingphotos", null, null);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
        ErrorReporting.a("PhotoUploadThread", "error clearing photo upload db", localSQLiteException);
    }
  }

  public void b(Intent paramIntent)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("albumId", paramIntent.getStringExtra("aid"));
    localContentValues.put("caption", paramIntent.getStringExtra("caption"));
    localContentValues.put("filename", paramIntent.getStringExtra("uri"));
    localContentValues.put("profileId", Long.valueOf(paramIntent.getLongExtra("profile_id", -1L)));
    localContentValues.put("checkinId", Long.valueOf(paramIntent.getLongExtra("checkin_id", -1L)));
    int i;
    if (paramIntent.getBooleanExtra("extra_photo_publish", false))
      i = 1;
    while (true)
    {
      localContentValues.put("publish", Integer.valueOf(i));
      localContentValues.put("tags", paramIntent.getStringExtra("tags"));
      localContentValues.put("place", Long.valueOf(paramIntent.getLongExtra("extra_place", -1L)));
      localContentValues.put("target_id", Long.valueOf(paramIntent.getLongExtra("extra_status_target_id", -1L)));
      localContentValues.put("privacy", paramIntent.getStringExtra("extra_status_privacy"));
      localContentValues.put("retry_attempt", Integer.valueOf(0));
      localContentValues.put("retry_time", Long.valueOf(System.currentTimeMillis() / 1000L));
      localContentValues.put("logging_id", paramIntent.getStringExtra("camera_session_id"));
      localContentValues.put("type", MediaUploadWorker.Type.PHOTO.toString());
      try
      {
        this.c.getWritableDatabase().insertOrThrow("pendingphotos", null, localContentValues);
        return;
        i = 0;
      }
      catch (SQLiteException localSQLiteException)
      {
        while (true)
          ErrorReporting.a("error adding photo upload to db", localSQLiteException.getMessage(), localSQLiteException);
      }
    }
  }

  // ERROR //
  public int c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 320	com/facebook/katana/service/MediaUploadWorker:d	()Z
    //   4: ifeq +7 -> 11
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_2
    //   10: ireturn
    //   11: aconst_null
    //   12: astore_1
    //   13: iconst_0
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 35	com/facebook/katana/service/MediaUploadWorker:c	Lcom/facebook/katana/service/MediaUploadWorker$DbOpenHelper;
    //   19: invokevirtual 54	com/facebook/katana/service/MediaUploadWorker$DbOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore 6
    //   24: iconst_5
    //   25: anewarray 4	java/lang/Object
    //   28: astore 7
    //   30: aload 7
    //   32: iconst_0
    //   33: ldc 251
    //   35: aastore
    //   36: aload 7
    //   38: iconst_1
    //   39: iconst_3
    //   40: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: aastore
    //   44: aload 7
    //   46: iconst_2
    //   47: ldc_w 256
    //   50: aastore
    //   51: aload 7
    //   53: iconst_3
    //   54: invokestatic 45	java/lang/System:currentTimeMillis	()J
    //   57: ldc2_w 46
    //   60: ldiv
    //   61: ldc2_w 321
    //   64: lsub
    //   65: invokestatic 236	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   68: aastore
    //   69: aload 7
    //   71: iconst_4
    //   72: ldc_w 256
    //   75: aastore
    //   76: aload 6
    //   78: ldc_w 324
    //   81: aload 7
    //   83: invokestatic 73	com/facebook/orca/common/util/StringLocaleUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: aconst_null
    //   87: invokevirtual 79	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore 8
    //   92: aload 8
    //   94: astore 4
    //   96: aload 4
    //   98: invokeinterface 85 1 0
    //   103: ifeq +822 -> 925
    //   106: aload 4
    //   108: ldc 251
    //   110: invokeinterface 89 2 0
    //   115: istore 13
    //   117: aload 4
    //   119: iload 13
    //   121: invokeinterface 327 2 0
    //   126: istore 14
    //   128: aload 4
    //   130: ldc_w 256
    //   133: invokeinterface 89 2 0
    //   138: istore 15
    //   140: aload_0
    //   141: iload 14
    //   143: aload 4
    //   145: iload 15
    //   147: invokeinterface 327 2 0
    //   152: invokespecial 329	com/facebook/katana/service/MediaUploadWorker:a	(II)Z
    //   155: ifeq +723 -> 878
    //   158: aload 4
    //   160: ldc_w 260
    //   163: invokeinterface 89 2 0
    //   168: istore 18
    //   170: aload 4
    //   172: iload 18
    //   174: invokeinterface 92 2 0
    //   179: invokestatic 332	com/facebook/katana/service/MediaUploadWorker$Type:valueOf	(Ljava/lang/String;)Lcom/facebook/katana/service/MediaUploadWorker$Type;
    //   182: astore 19
    //   184: getstatic 337	com/facebook/katana/service/MediaUploadWorker$1:a	[I
    //   187: aload 19
    //   189: invokevirtual 340	com/facebook/katana/service/MediaUploadWorker$Type:ordinal	()I
    //   192: iaload
    //   193: tableswitch	default:+23 -> 216, 1:+373->566, 2:+578->771
    //   217: getfield 28	com/facebook/katana/service/MediaUploadWorker:b	Lcom/facebook/katana/binding/AppSession;
    //   220: astore 50
    //   222: aload_0
    //   223: getfield 26	com/facebook/katana/service/MediaUploadWorker:a	Landroid/content/Context;
    //   226: astore 51
    //   228: aload 4
    //   230: ldc 60
    //   232: invokeinterface 89 2 0
    //   237: istore 52
    //   239: aload 4
    //   241: iload 52
    //   243: invokeinterface 327 2 0
    //   248: istore 53
    //   250: aload 4
    //   252: ldc_w 299
    //   255: invokeinterface 89 2 0
    //   260: istore 54
    //   262: aload 4
    //   264: iload 54
    //   266: invokeinterface 92 2 0
    //   271: astore 55
    //   273: aload 4
    //   275: ldc 219
    //   277: invokeinterface 89 2 0
    //   282: istore 56
    //   284: aload 4
    //   286: iload 56
    //   288: invokeinterface 92 2 0
    //   293: astore 57
    //   295: aload 4
    //   297: ldc 158
    //   299: invokeinterface 89 2 0
    //   304: istore 58
    //   306: aload 4
    //   308: iload 58
    //   310: invokeinterface 92 2 0
    //   315: astore 59
    //   317: aload 4
    //   319: ldc 223
    //   321: invokeinterface 89 2 0
    //   326: istore 60
    //   328: aload 4
    //   330: iload 60
    //   332: invokeinterface 344 2 0
    //   337: lstore 61
    //   339: aload 4
    //   341: ldc_w 303
    //   344: invokeinterface 89 2 0
    //   349: istore 63
    //   351: aload 4
    //   353: iload 63
    //   355: invokeinterface 344 2 0
    //   360: lstore 64
    //   362: aload 4
    //   364: ldc_w 313
    //   367: invokeinterface 89 2 0
    //   372: istore 66
    //   374: aload 4
    //   376: iload 66
    //   378: invokeinterface 327 2 0
    //   383: iconst_1
    //   384: if_icmplt +712 -> 1096
    //   387: iconst_1
    //   388: istore 67
    //   390: aload 4
    //   392: ldc_w 269
    //   395: invokeinterface 89 2 0
    //   400: istore 68
    //   402: aload 4
    //   404: iload 68
    //   406: invokeinterface 344 2 0
    //   411: lstore 69
    //   413: aload 4
    //   415: ldc 245
    //   417: invokeinterface 89 2 0
    //   422: istore 71
    //   424: aload 4
    //   426: iload 71
    //   428: invokeinterface 92 2 0
    //   433: astore 72
    //   435: aload 4
    //   437: ldc 241
    //   439: invokeinterface 89 2 0
    //   444: istore 73
    //   446: aload 4
    //   448: iload 73
    //   450: invokeinterface 344 2 0
    //   455: lstore 74
    //   457: aload 4
    //   459: ldc 247
    //   461: invokeinterface 89 2 0
    //   466: istore 76
    //   468: aload 50
    //   470: aload 51
    //   472: iload 53
    //   474: aload 55
    //   476: aload 57
    //   478: aload 59
    //   480: lload 61
    //   482: lload 64
    //   484: iload 67
    //   486: lload 69
    //   488: aload 72
    //   490: lload 74
    //   492: aload 4
    //   494: iload 76
    //   496: invokeinterface 92 2 0
    //   501: iconst_1
    //   502: iconst_1
    //   503: aconst_null
    //   504: invokevirtual 347	com/facebook/katana/binding/AppSession:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZJLjava/lang/String;JLjava/lang/String;IILjava/lang/String;)Ljava/lang/String;
    //   507: astore 28
    //   509: getstatic 22	com/facebook/katana/service/MediaUploadWorker:d	Ljava/util/Map;
    //   512: astore 29
    //   514: aload 4
    //   516: ldc 60
    //   518: invokeinterface 89 2 0
    //   523: istore 30
    //   525: aload 29
    //   527: aload 4
    //   529: iload 30
    //   531: invokeinterface 327 2 0
    //   536: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   539: aload 28
    //   541: invokeinterface 350 3 0
    //   546: pop
    //   547: iconst_0
    //   548: istore_2
    //   549: aload 4
    //   551: ifnull -542 -> 9
    //   554: aload 4
    //   556: invokeinterface 95 1 0
    //   561: iconst_0
    //   562: istore_2
    //   563: goto -554 -> 9
    //   566: aload 4
    //   568: ldc 215
    //   570: invokeinterface 89 2 0
    //   575: istore 32
    //   577: aload 4
    //   579: iload 32
    //   581: invokeinterface 92 2 0
    //   586: astore 33
    //   588: aload 4
    //   590: ldc 219
    //   592: invokeinterface 89 2 0
    //   597: istore 34
    //   599: aload 4
    //   601: iload 34
    //   603: invokeinterface 92 2 0
    //   608: astore 35
    //   610: aload 4
    //   612: ldc 158
    //   614: invokeinterface 89 2 0
    //   619: istore 36
    //   621: aload 4
    //   623: iload 36
    //   625: invokeinterface 92 2 0
    //   630: astore 37
    //   632: aload 4
    //   634: ldc 241
    //   636: invokeinterface 89 2 0
    //   641: istore 38
    //   643: aload 4
    //   645: iload 38
    //   647: invokeinterface 344 2 0
    //   652: lstore 39
    //   654: aload 4
    //   656: ldc 60
    //   658: invokeinterface 89 2 0
    //   663: istore 41
    //   665: aload 4
    //   667: iload 41
    //   669: invokeinterface 327 2 0
    //   674: istore 42
    //   676: aload 4
    //   678: ldc 247
    //   680: invokeinterface 89 2 0
    //   685: istore 43
    //   687: aload 4
    //   689: iload 43
    //   691: invokeinterface 92 2 0
    //   696: astore 44
    //   698: aload 4
    //   700: ldc 245
    //   702: invokeinterface 89 2 0
    //   707: istore 45
    //   709: aload 4
    //   711: iload 45
    //   713: invokeinterface 92 2 0
    //   718: astore 46
    //   720: aload 4
    //   722: ldc_w 269
    //   725: invokeinterface 89 2 0
    //   730: istore 47
    //   732: aload 4
    //   734: iload 47
    //   736: invokeinterface 344 2 0
    //   741: lstore 48
    //   743: aload_0
    //   744: getfield 26	com/facebook/katana/service/MediaUploadWorker:a	Landroid/content/Context;
    //   747: aload 33
    //   749: aload 35
    //   751: aload 37
    //   753: lload 39
    //   755: iload 42
    //   757: aload 44
    //   759: aload 46
    //   761: lload 48
    //   763: invokestatic 355	com/facebook/katana/service/method/VideoUpload:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   766: astore 28
    //   768: goto -259 -> 509
    //   771: aload 4
    //   773: ldc 241
    //   775: invokeinterface 89 2 0
    //   780: istore 20
    //   782: aload 4
    //   784: iload 20
    //   786: invokeinterface 344 2 0
    //   791: lstore 21
    //   793: aload 4
    //   795: ldc 158
    //   797: invokeinterface 89 2 0
    //   802: istore 23
    //   804: aload 4
    //   806: iload 23
    //   808: invokeinterface 92 2 0
    //   813: astore 24
    //   815: aload 4
    //   817: ldc 60
    //   819: invokeinterface 89 2 0
    //   824: istore 25
    //   826: aload 4
    //   828: iload 25
    //   830: invokeinterface 327 2 0
    //   835: istore 26
    //   837: new 357	com/facebook/ipc/katana/model/FacebookPlace
    //   840: dup
    //   841: lload 21
    //   843: aconst_null
    //   844: aconst_null
    //   845: dconst_0
    //   846: dconst_0
    //   847: iconst_0
    //   848: aconst_null
    //   849: invokespecial 360	com/facebook/ipc/katana/model/FacebookPlace:<init>	(JLjava/lang/String;Ljava/lang/String;DDILjava/lang/String;)V
    //   852: astore 27
    //   854: aload_0
    //   855: getfield 28	com/facebook/katana/service/MediaUploadWorker:b	Lcom/facebook/katana/binding/AppSession;
    //   858: aload_0
    //   859: getfield 26	com/facebook/katana/service/MediaUploadWorker:a	Landroid/content/Context;
    //   862: iload 26
    //   864: lload 21
    //   866: aload 24
    //   868: aload 27
    //   870: invokevirtual 363	com/facebook/katana/binding/AppSession:a	(Landroid/content/Context;IJLjava/lang/String;Lcom/facebook/ipc/katana/model/FacebookPlace;)Ljava/lang/String;
    //   873: astore 28
    //   875: goto -366 -> 509
    //   878: aload 4
    //   880: ldc 251
    //   882: invokeinterface 89 2 0
    //   887: istore 16
    //   889: aload_0
    //   890: aload 4
    //   892: iload 16
    //   894: invokeinterface 327 2 0
    //   899: invokespecial 39	com/facebook/katana/service/MediaUploadWorker:c	(I)I
    //   902: istore 17
    //   904: iload 17
    //   906: ifle -810 -> 96
    //   909: iload 17
    //   911: iload_2
    //   912: if_icmplt +7 -> 919
    //   915: iload_2
    //   916: ifne -820 -> 96
    //   919: iload 17
    //   921: istore_2
    //   922: goto -826 -> 96
    //   925: aload 4
    //   927: ifnull +10 -> 937
    //   930: aload 4
    //   932: invokeinterface 95 1 0
    //   937: iload_2
    //   938: ifgt -929 -> 9
    //   941: aload_0
    //   942: getfield 35	com/facebook/katana/service/MediaUploadWorker:c	Lcom/facebook/katana/service/MediaUploadWorker$DbOpenHelper;
    //   945: invokevirtual 54	com/facebook/katana/service/MediaUploadWorker$DbOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   948: astore 10
    //   950: iconst_4
    //   951: anewarray 4	java/lang/Object
    //   954: astore 11
    //   956: aload 11
    //   958: iconst_0
    //   959: ldc 251
    //   961: aastore
    //   962: aload 11
    //   964: iconst_1
    //   965: iconst_3
    //   966: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   969: aastore
    //   970: aload 11
    //   972: iconst_2
    //   973: ldc_w 256
    //   976: aastore
    //   977: aload 11
    //   979: iconst_3
    //   980: invokestatic 45	java/lang/System:currentTimeMillis	()J
    //   983: ldc2_w 46
    //   986: ldiv
    //   987: ldc2_w 321
    //   990: lsub
    //   991: invokestatic 236	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   994: aastore
    //   995: aload 10
    //   997: ldc_w 365
    //   1000: aload 11
    //   1002: invokestatic 73	com/facebook/orca/common/util/StringLocaleUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1005: aconst_null
    //   1006: invokevirtual 79	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   1009: pop
    //   1010: iconst_0
    //   1011: istore_2
    //   1012: goto -1003 -> 9
    //   1015: astore 5
    //   1017: ldc 187
    //   1019: ldc_w 367
    //   1022: aload 5
    //   1024: invokestatic 194	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1027: iconst_0
    //   1028: istore_2
    //   1029: aload_1
    //   1030: ifnull -1021 -> 9
    //   1033: aload_1
    //   1034: invokeinterface 95 1 0
    //   1039: iconst_0
    //   1040: istore_2
    //   1041: goto -1032 -> 9
    //   1044: astore_3
    //   1045: aconst_null
    //   1046: astore 4
    //   1048: aload 4
    //   1050: ifnull +10 -> 1060
    //   1053: aload 4
    //   1055: invokeinterface 95 1 0
    //   1060: aload_3
    //   1061: athrow
    //   1062: astore 9
    //   1064: ldc 187
    //   1066: ldc_w 369
    //   1069: aload 9
    //   1071: invokestatic 194	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1074: goto -64 -> 1010
    //   1077: astore_3
    //   1078: goto -30 -> 1048
    //   1081: astore_3
    //   1082: aload_1
    //   1083: astore 4
    //   1085: goto -37 -> 1048
    //   1088: astore 5
    //   1090: aload 4
    //   1092: astore_1
    //   1093: goto -76 -> 1017
    //   1096: iconst_0
    //   1097: istore 67
    //   1099: goto -709 -> 390
    //
    // Exception table:
    //   from	to	target	type
    //   15	92	1015	android/database/sqlite/SQLiteException
    //   15	92	1044	finally
    //   941	1010	1062	android/database/sqlite/SQLiteException
    //   96	547	1077	finally
    //   566	904	1077	finally
    //   1017	1027	1081	finally
    //   96	547	1088	android/database/sqlite/SQLiteException
    //   566	904	1088	android/database/sqlite/SQLiteException
  }

  public void c(Intent paramIntent)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("filename", paramIntent.getStringExtra("uri"));
    localContentValues.put("target_id", Long.valueOf(paramIntent.getLongExtra("profile_id", -1L)));
    localContentValues.put("retry_attempt", Integer.valueOf(0));
    localContentValues.put("retry_time", Long.valueOf(System.currentTimeMillis() / 1000L));
    localContentValues.put("type", MediaUploadWorker.Type.PLACES_SUGGESTION.toString());
    try
    {
      this.c.getWritableDatabase().insertOrThrow("pendingphotos", null, localContentValues);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
        ErrorReporting.a("error adding places picture upload to db", localSQLiteException.getMessage(), localSQLiteException);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.MediaUploadWorker
 * JD-Core Version:    0.6.0
 */