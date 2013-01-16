package com.facebook.katana.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.common.util.FileUtils;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.ipc.pages.PagesContract;
import com.facebook.orca.inject.FbInjector;
import java.io.File;
import java.util.ArrayList;

public class FacebookDatabaseHelper extends SQLiteOpenHelper
{
  private static FacebookDatabaseHelper.DatabaseUpdater A;
  private static FacebookDatabaseHelper.DatabaseUpdater B;
  private static FacebookDatabaseHelper.DatabaseUpdater C;
  private static FacebookDatabaseHelper a;
  private static FacebookDatabaseHelper.DatabaseUpdater g = new FacebookDatabaseHelper.1("recreateUserValuesTables");
  private static FacebookDatabaseHelper.DatabaseUpdater h = new FacebookDatabaseHelper.2("recreateNotificationsTables");
  private static FacebookDatabaseHelper.DatabaseUpdater i = new FacebookDatabaseHelper.3("recreateGQLNotificationsTables");
  private static FacebookDatabaseHelper.DatabaseUpdater j = new FacebookDatabaseHelper.4("recreatePushNotificationsTables");
  private static FacebookDatabaseHelper.DatabaseUpdater k = new FacebookDatabaseHelper.5("recreateVaultImagesTables");
  private static FacebookDatabaseHelper.DatabaseUpdater l = new FacebookDatabaseHelper.6("recreateLocalCropInfoTables");
  private static FacebookDatabaseHelper.DatabaseUpdater m = new FacebookDatabaseHelper.7("recreateLocalPhotoTagTables");
  private static FacebookDatabaseHelper.DatabaseUpdater n = new FacebookDatabaseHelper.8("recreateLocalPhotoFaceboxTables");
  private static FacebookDatabaseHelper.DatabaseUpdater o = new FacebookDatabaseHelper.9("recreateDetectedPhotosTables");
  private static FacebookDatabaseHelper.DatabaseUpdater p = new FacebookDatabaseHelper.10("recreateUserStatusTables");
  private static FacebookDatabaseHelper.DatabaseUpdater q = new FacebookDatabaseHelper.11("recreateObservedContactsTables");
  private static FacebookDatabaseHelper.DatabaseUpdater r = new FacebookDatabaseHelper.12("recreateConnectionTables");
  private static FacebookDatabaseHelper.DatabaseUpdater s = new FacebookDatabaseHelper.13("recreateActionLogTables");
  private static FacebookDatabaseHelper.DatabaseUpdater t = new FacebookDatabaseHelper.14("recreatePagesTables");
  private static FacebookDatabaseHelper.DatabaseUpdater u = new FacebookDatabaseHelper.15("recreateCacheTables");
  private static FacebookDatabaseHelper.DatabaseUpdater v = new FacebookDatabaseHelper.16("recreatePhotosTables");
  private static FacebookDatabaseHelper.DatabaseUpdater w = new FacebookDatabaseHelper.17("recreateLoggingTables");
  private static FacebookDatabaseHelper.DatabaseUpdater x = new FacebookDatabaseHelper.18("recreateKeyValueTables");
  private static FacebookDatabaseHelper.DatabaseUpdater y = new FacebookDatabaseHelper.19("migrateFriendsTable");
  private static FacebookDatabaseHelper.DatabaseUpdater z = new FacebookDatabaseHelper.20("forceFriendsSync");
  private final ArrayList<String> b = new ArrayList();
  private boolean c = false;
  private final int d = 2500;
  private final int e = 5000;
  private final Context f;

  static
  {
    A = new FacebookDatabaseHelper.21("invalidateUriMap");
    B = new FacebookDatabaseHelper.22("killChatTables");
    C = new FacebookDatabaseHelper.23("killMailboxTables");
  }

  private FacebookDatabaseHelper(Context paramContext)
  {
    super(paramContext, "fb.db", null, 95);
    this.f = paramContext;
  }

  public static FacebookDatabaseHelper a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (a != null);
      for (FacebookDatabaseHelper localFacebookDatabaseHelper = a; ; localFacebookDatabaseHelper = a)
      {
        return localFacebookDatabaseHelper;
        a = new FacebookDatabaseHelper(paramContext);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void a(String paramString)
  {
    monitorenter;
    try
    {
      this.b.add(paramString);
      if (this.c)
        a();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static void b(Context paramContext)
  {
    NotificationsContract localNotificationsContract = (NotificationsContract)FbInjector.a(paramContext).a(NotificationsContract.class);
    ContentResolver localContentResolver = paramContext.getContentResolver();
    localContentResolver.delete(UserStatusesProvider.a, null, null);
    localContentResolver.delete(ConnectionsContract.b, null, null);
    localContentResolver.delete(ConnectionsContract.l, null, null);
    localContentResolver.delete(PhotosProvider.a, null, null);
    localContentResolver.delete(PhotosProvider.e, null, null);
    localContentResolver.delete(PhotosProvider.i, null, null);
    localContentResolver.delete(localNotificationsContract.c, null, null);
    localContentResolver.delete(PagesContract.c, null, null);
    localContentResolver.delete(CacheProvider.a, null, null);
    localContentResolver.delete(VaultImageProvider.a, null, null);
    localContentResolver.delete(LocalPhotoTagProvider.a, null, null);
    localContentResolver.delete(LocalCropInfoProvider.a, null, null);
    localContentResolver.delete(LocalFaceboxProvider.a, null, null);
    localContentResolver.delete(DetectedPhotoProvider.a, null, null);
    FileUtils.a(paramContext.getFilesDir().getAbsolutePath());
  }

  private static void b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + paramString);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
        paramSQLiteDatabase.execSQL("DROP VIEW IF EXISTS " + paramString);
    }
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 218	com/facebook/katana/provider/FacebookDatabaseHelper:b	Ljava/util/ArrayList;
    //   6: invokevirtual 345	java/util/ArrayList:size	()I
    //   9: ifle +66 -> 75
    //   12: new 324	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   19: astore_2
    //   20: aload_0
    //   21: getfield 218	com/facebook/katana/provider/FacebookDatabaseHelper:b	Ljava/util/ArrayList;
    //   24: invokevirtual 349	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   27: astore_3
    //   28: aload_3
    //   29: invokeinterface 355 1 0
    //   34: ifeq +31 -> 65
    //   37: aload_2
    //   38: aload_3
    //   39: invokeinterface 359 1 0
    //   44: checkcast 361	java/lang/String
    //   47: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 363
    //   53: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: goto -29 -> 28
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    //   65: ldc_w 365
    //   68: aload_2
    //   69: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 370	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield 218	com/facebook/katana/provider/FacebookDatabaseHelper:b	Ljava/util/ArrayList;
    //   79: invokevirtual 373	java/util/ArrayList:clear	()V
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield 220	com/facebook/katana/provider/FacebookDatabaseHelper:c	Z
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //
    // Exception table:
    //   from	to	target	type
    //   2	63	60	finally
    //   65	89	60	finally
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    g.b(paramSQLiteDatabase);
    h.b(paramSQLiteDatabase);
    i.b(paramSQLiteDatabase);
    j.b(paramSQLiteDatabase);
    p.b(paramSQLiteDatabase);
    r.b(paramSQLiteDatabase);
    t.b(paramSQLiteDatabase);
    v.b(paramSQLiteDatabase);
    w.b(paramSQLiteDatabase);
    x.b(paramSQLiteDatabase);
    u.b(paramSQLiteDatabase);
    s.b(paramSQLiteDatabase);
    k.b(paramSQLiteDatabase);
    q.b(paramSQLiteDatabase);
    m.b(paramSQLiteDatabase);
    l.b(paramSQLiteDatabase);
    n.b(paramSQLiteDatabase);
    o.b(paramSQLiteDatabase);
  }

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    onCreate(paramSQLiteDatabase);
  }

  // ERROR //
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iload_2
    //   4: bipush 45
    //   6: if_icmpgt +37 -> 43
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 383	com/facebook/katana/provider/FacebookDatabaseHelper:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   14: invokestatic 390	android/os/SystemClock:elapsedRealtime	()J
    //   17: lstore 12
    //   19: aload_0
    //   20: getfield 226	com/facebook/katana/provider/FacebookDatabaseHelper:f	Landroid/content/Context;
    //   23: invokevirtual 311	android/content/Context:getFilesDir	()Ljava/io/File;
    //   26: invokevirtual 317	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   29: new 392	com/facebook/katana/provider/FacebookDatabaseHelper$24
    //   32: dup
    //   33: aload_0
    //   34: lload 12
    //   36: invokespecial 395	com/facebook/katana/provider/FacebookDatabaseHelper$24:<init>	(Lcom/facebook/katana/provider/FacebookDatabaseHelper;J)V
    //   39: invokestatic 398	com/facebook/common/util/FileUtils:a	(Ljava/lang/String;Lcom/facebook/common/util/FileUtils$deleteFilesCallback;)V
    //   42: return
    //   43: aconst_null
    //   44: astore 5
    //   46: new 400	java/util/LinkedHashSet
    //   49: dup
    //   50: invokespecial 401	java/util/LinkedHashSet:<init>	()V
    //   53: astore 6
    //   55: iconst_0
    //   56: istore 7
    //   58: iload_2
    //   59: bipush 48
    //   61: if_icmpgt +29 -> 90
    //   64: aload 6
    //   66: getstatic 129	com/facebook/katana/provider/FacebookDatabaseHelper:r	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   69: invokeinterface 404 2 0
    //   74: pop
    //   75: aload 6
    //   77: getstatic 115	com/facebook/katana/provider/FacebookDatabaseHelper:p	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   80: invokeinterface 404 2 0
    //   85: pop
    //   86: iload 4
    //   88: istore 7
    //   90: iload_2
    //   91: bipush 50
    //   93: if_icmpgt +789 -> 882
    //   96: aload 6
    //   98: getstatic 129	com/facebook/katana/provider/FacebookDatabaseHelper:r	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   101: invokeinterface 404 2 0
    //   106: pop
    //   107: iload_2
    //   108: bipush 52
    //   110: if_icmpgt +14 -> 124
    //   113: aload 6
    //   115: getstatic 164	com/facebook/katana/provider/FacebookDatabaseHelper:w	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   118: invokeinterface 404 2 0
    //   123: pop
    //   124: iload_2
    //   125: bipush 53
    //   127: if_icmpgt +14 -> 141
    //   130: aload 6
    //   132: getstatic 171	com/facebook/katana/provider/FacebookDatabaseHelper:x	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   135: invokeinterface 404 2 0
    //   140: pop
    //   141: iload_2
    //   142: bipush 56
    //   144: if_icmpgt +14 -> 158
    //   147: aload 6
    //   149: getstatic 59	com/facebook/katana/provider/FacebookDatabaseHelper:h	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   152: invokeinterface 404 2 0
    //   157: pop
    //   158: iload_2
    //   159: bipush 94
    //   161: if_icmpgt +14 -> 175
    //   164: aload 6
    //   166: getstatic 66	com/facebook/katana/provider/FacebookDatabaseHelper:i	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   169: invokeinterface 404 2 0
    //   174: pop
    //   175: iload_2
    //   176: bipush 58
    //   178: if_icmpgt +14 -> 192
    //   181: aload 6
    //   183: getstatic 143	com/facebook/katana/provider/FacebookDatabaseHelper:t	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   186: invokeinterface 404 2 0
    //   191: pop
    //   192: iload_2
    //   193: bipush 59
    //   195: if_icmpgt +14 -> 209
    //   198: aload 6
    //   200: getstatic 150	com/facebook/katana/provider/FacebookDatabaseHelper:u	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   203: invokeinterface 404 2 0
    //   208: pop
    //   209: iload_2
    //   210: bipush 60
    //   212: if_icmpgt +19 -> 231
    //   215: iload 4
    //   217: ifne +14 -> 231
    //   220: aload 6
    //   222: getstatic 178	com/facebook/katana/provider/FacebookDatabaseHelper:y	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   225: invokeinterface 404 2 0
    //   230: pop
    //   231: iload_2
    //   232: bipush 61
    //   234: if_icmpgt +14 -> 248
    //   237: aload 6
    //   239: getstatic 185	com/facebook/katana/provider/FacebookDatabaseHelper:z	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   242: invokeinterface 404 2 0
    //   247: pop
    //   248: iload_2
    //   249: bipush 62
    //   251: if_icmpgt +14 -> 265
    //   254: aload 6
    //   256: getstatic 157	com/facebook/katana/provider/FacebookDatabaseHelper:v	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   259: invokeinterface 404 2 0
    //   264: pop
    //   265: iload_2
    //   266: bipush 63
    //   268: if_icmpgt +14 -> 282
    //   271: aload 6
    //   273: getstatic 157	com/facebook/katana/provider/FacebookDatabaseHelper:v	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   276: invokeinterface 404 2 0
    //   281: pop
    //   282: iload_2
    //   283: bipush 64
    //   285: if_icmpgt +14 -> 299
    //   288: aload 6
    //   290: getstatic 157	com/facebook/katana/provider/FacebookDatabaseHelper:v	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   293: invokeinterface 404 2 0
    //   298: pop
    //   299: iload_2
    //   300: bipush 65
    //   302: if_icmpgt +14 -> 316
    //   305: aload 6
    //   307: getstatic 157	com/facebook/katana/provider/FacebookDatabaseHelper:v	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   310: invokeinterface 404 2 0
    //   315: pop
    //   316: iload_2
    //   317: bipush 66
    //   319: if_icmpgt +14 -> 333
    //   322: aload 6
    //   324: getstatic 192	com/facebook/katana/provider/FacebookDatabaseHelper:A	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   327: invokeinterface 404 2 0
    //   332: pop
    //   333: iload_2
    //   334: bipush 67
    //   336: if_icmpgt +14 -> 350
    //   339: aload 6
    //   341: getstatic 73	com/facebook/katana/provider/FacebookDatabaseHelper:j	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   344: invokeinterface 404 2 0
    //   349: pop
    //   350: iload_2
    //   351: bipush 68
    //   353: if_icmpgt +14 -> 367
    //   356: aload 6
    //   358: getstatic 136	com/facebook/katana/provider/FacebookDatabaseHelper:s	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   361: invokeinterface 404 2 0
    //   366: pop
    //   367: iload_2
    //   368: bipush 69
    //   370: if_icmpgt +14 -> 384
    //   373: aload 6
    //   375: getstatic 157	com/facebook/katana/provider/FacebookDatabaseHelper:v	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   378: invokeinterface 404 2 0
    //   383: pop
    //   384: iload_2
    //   385: bipush 83
    //   387: if_icmpgt +14 -> 401
    //   390: aload 6
    //   392: getstatic 80	com/facebook/katana/provider/FacebookDatabaseHelper:k	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   395: invokeinterface 404 2 0
    //   400: pop
    //   401: iload_2
    //   402: bipush 73
    //   404: if_icmpgt +14 -> 418
    //   407: aload 6
    //   409: getstatic 199	com/facebook/katana/provider/FacebookDatabaseHelper:B	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   412: invokeinterface 404 2 0
    //   417: pop
    //   418: iload_2
    //   419: bipush 80
    //   421: if_icmpgt +14 -> 435
    //   424: aload 6
    //   426: getstatic 206	com/facebook/katana/provider/FacebookDatabaseHelper:C	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   429: invokeinterface 404 2 0
    //   434: pop
    //   435: iload_2
    //   436: bipush 79
    //   438: if_icmpgt +14 -> 452
    //   441: aload 6
    //   443: getstatic 122	com/facebook/katana/provider/FacebookDatabaseHelper:q	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   446: invokeinterface 404 2 0
    //   451: pop
    //   452: iload_2
    //   453: bipush 84
    //   455: if_icmpgt +14 -> 469
    //   458: aload 6
    //   460: getstatic 94	com/facebook/katana/provider/FacebookDatabaseHelper:m	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   463: invokeinterface 404 2 0
    //   468: pop
    //   469: iload_2
    //   470: bipush 85
    //   472: if_icmpgt +14 -> 486
    //   475: aload 6
    //   477: getstatic 115	com/facebook/katana/provider/FacebookDatabaseHelper:p	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   480: invokeinterface 404 2 0
    //   485: pop
    //   486: iload_2
    //   487: bipush 90
    //   489: if_icmpgt +14 -> 503
    //   492: aload 6
    //   494: getstatic 59	com/facebook/katana/provider/FacebookDatabaseHelper:h	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   497: invokeinterface 404 2 0
    //   502: pop
    //   503: iload_2
    //   504: bipush 87
    //   506: if_icmpgt +14 -> 520
    //   509: aload 6
    //   511: getstatic 87	com/facebook/katana/provider/FacebookDatabaseHelper:l	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   514: invokeinterface 404 2 0
    //   519: pop
    //   520: iload_2
    //   521: bipush 88
    //   523: if_icmpgt +14 -> 537
    //   526: aload 6
    //   528: getstatic 101	com/facebook/katana/provider/FacebookDatabaseHelper:n	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   531: invokeinterface 404 2 0
    //   536: pop
    //   537: iload_2
    //   538: bipush 88
    //   540: if_icmpgt +14 -> 554
    //   543: aload 6
    //   545: getstatic 108	com/facebook/katana/provider/FacebookDatabaseHelper:o	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   548: invokeinterface 404 2 0
    //   553: pop
    //   554: iload_2
    //   555: bipush 89
    //   557: if_icmpgt +14 -> 571
    //   560: aload 6
    //   562: getstatic 157	com/facebook/katana/provider/FacebookDatabaseHelper:v	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   565: invokeinterface 404 2 0
    //   570: pop
    //   571: iload_2
    //   572: bipush 91
    //   574: if_icmpgt +14 -> 588
    //   577: aload 6
    //   579: getstatic 129	com/facebook/katana/provider/FacebookDatabaseHelper:r	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   582: invokeinterface 404 2 0
    //   587: pop
    //   588: iload_2
    //   589: bipush 92
    //   591: if_icmpgt +14 -> 605
    //   594: aload 6
    //   596: getstatic 59	com/facebook/katana/provider/FacebookDatabaseHelper:h	Lcom/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater;
    //   599: invokeinterface 404 2 0
    //   604: pop
    //   605: aload 6
    //   607: invokeinterface 405 1 0
    //   612: astore 14
    //   614: aload 14
    //   616: invokeinterface 355 1 0
    //   621: ifeq -607 -> 14
    //   624: aload 14
    //   626: invokeinterface 359 1 0
    //   631: checkcast 377	com/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater
    //   634: astore 16
    //   636: invokestatic 390	android/os/SystemClock:elapsedRealtime	()J
    //   639: lstore 17
    //   641: aload 16
    //   643: aload_1
    //   644: invokevirtual 379	com/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater:b	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   647: invokestatic 390	android/os/SystemClock:elapsedRealtime	()J
    //   650: lload 17
    //   652: lsub
    //   653: lstore 19
    //   655: lload 19
    //   657: ldc2_w 406
    //   660: lcmp
    //   661: ifle +66 -> 727
    //   664: aload_0
    //   665: new 324	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   672: ldc_w 409
    //   675: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: iload_2
    //   679: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   682: ldc_w 414
    //   685: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: aload 16
    //   690: invokevirtual 416	com/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater:a	()Ljava/lang/String;
    //   693: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 418
    //   699: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: lload 19
    //   704: invokevirtual 421	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   707: ldc_w 423
    //   710: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload 16
    //   715: invokevirtual 425	com/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater:b	()Ljava/lang/String;
    //   718: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokespecial 237	com/facebook/katana/provider/FacebookDatabaseHelper:a	(Ljava/lang/String;)V
    //   727: aload 16
    //   729: astore 5
    //   731: goto -117 -> 614
    //   734: astore 8
    //   736: aconst_null
    //   737: astore 9
    //   739: aload 8
    //   741: astore 10
    //   743: new 324	java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   750: ldc_w 427
    //   753: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: iload_2
    //   757: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   760: ldc_w 429
    //   763: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: astore 11
    //   771: aload 9
    //   773: ifnull +40 -> 813
    //   776: new 324	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   783: aload 11
    //   785: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: ldc_w 431
    //   791: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: aload 9
    //   796: invokevirtual 416	com/facebook/katana/provider/FacebookDatabaseHelper$DatabaseUpdater:a	()Ljava/lang/String;
    //   799: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: ldc_w 433
    //   805: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: astore 11
    //   813: aload_0
    //   814: new 324	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   821: aload 11
    //   823: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: ldc_w 431
    //   829: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: aload 10
    //   834: invokevirtual 436	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   837: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: ldc_w 433
    //   843: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokespecial 237	com/facebook/katana/provider/FacebookDatabaseHelper:a	(Ljava/lang/String;)V
    //   852: aload_0
    //   853: aload_1
    //   854: invokevirtual 383	com/facebook/katana/provider/FacebookDatabaseHelper:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   857: goto -843 -> 14
    //   860: astore 10
    //   862: aload 16
    //   864: astore 9
    //   866: goto -123 -> 743
    //   869: astore 15
    //   871: aload 5
    //   873: astore 9
    //   875: aload 15
    //   877: astore 10
    //   879: goto -136 -> 743
    //   882: iload 7
    //   884: istore 4
    //   886: goto -779 -> 107
    //
    // Exception table:
    //   from	to	target	type
    //   46	614	734	android/database/sqlite/SQLiteException
    //   636	727	860	android/database/sqlite/SQLiteException
    //   614	636	869	android/database/sqlite/SQLiteException
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper
 * JD-Core Version:    0.6.0
 */