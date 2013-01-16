package com.facebook.analytics;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.util.StringUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CounterHistoricalData
{
  private static final Class<?> b = CounterHistoricalData.class;
  Map<String, Long> a;
  private final AnalyticsDatabaseSupplier c;

  public CounterHistoricalData(AnalyticsDatabaseSupplier paramAnalyticsDatabaseSupplier)
  {
    this.c = paramAnalyticsDatabaseSupplier;
  }

  private Long a(String paramString)
  {
    if (this.a == null)
      this.a = a();
    Long localLong = (Long)this.a.get(paramString);
    if (localLong == null)
    {
      localLong = Long.valueOf(b(paramString));
      if (localLong.longValue() > 0L)
        this.a.put(paramString, localLong);
    }
    return localLong;
  }

  // ERROR //
  private Map<String, Long> a()
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 55	java/lang/String
    //   4: dup
    //   5: iconst_0
    //   6: ldc 57
    //   8: aastore
    //   9: dup
    //   10: iconst_1
    //   11: ldc 59
    //   13: aastore
    //   14: astore_1
    //   15: aload_0
    //   16: getfield 22	com/facebook/analytics/CounterHistoricalData:c	Lcom/facebook/analytics/AnalyticsDatabaseSupplier;
    //   19: invokevirtual 64	com/facebook/analytics/AnalyticsDatabaseSupplier:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore_2
    //   23: invokestatic 69	com/google/common/collect/Maps:a	()Ljava/util/HashMap;
    //   26: astore_3
    //   27: aload_2
    //   28: iconst_1
    //   29: ldc 71
    //   31: aload_1
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 77	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore 7
    //   43: aload 7
    //   45: astore 5
    //   47: aload 5
    //   49: invokeinterface 83 1 0
    //   54: istore 8
    //   56: iload 8
    //   58: ifeq +39 -> 97
    //   61: aload_3
    //   62: aload 5
    //   64: iconst_1
    //   65: invokeinterface 87 2 0
    //   70: aload 5
    //   72: iconst_0
    //   73: invokeinterface 91 2 0
    //   78: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   81: invokevirtual 94	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   84: pop
    //   85: aload 5
    //   87: invokeinterface 97 1 0
    //   92: istore 8
    //   94: goto -38 -> 56
    //   97: aload 5
    //   99: invokeinterface 100 1 0
    //   104: iconst_0
    //   105: ifeq +9 -> 114
    //   108: aconst_null
    //   109: invokeinterface 100 1 0
    //   114: aload_3
    //   115: areturn
    //   116: astore 6
    //   118: aconst_null
    //   119: astore 5
    //   121: getstatic 16	com/facebook/analytics/CounterHistoricalData:b	Ljava/lang/Class;
    //   124: ldc 102
    //   126: aload 6
    //   128: invokestatic 108	com/facebook/orca/debug/BLog:e	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   131: aload 5
    //   133: ifnull -19 -> 114
    //   136: aload 5
    //   138: invokeinterface 100 1 0
    //   143: goto -29 -> 114
    //   146: astore 4
    //   148: aconst_null
    //   149: astore 5
    //   151: aload 5
    //   153: ifnull +10 -> 163
    //   156: aload 5
    //   158: invokeinterface 100 1 0
    //   163: aload 4
    //   165: athrow
    //   166: astore 4
    //   168: goto -17 -> 151
    //   171: astore 6
    //   173: goto -52 -> 121
    //
    // Exception table:
    //   from	to	target	type
    //   27	43	116	java/lang/Exception
    //   27	43	146	finally
    //   47	104	166	finally
    //   121	131	166	finally
    //   47	104	171	java/lang/Exception
  }

  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("time", Long.valueOf(paramLong1));
    localContentValues.put("counter", Long.valueOf(paramLong2));
    localContentValues.put("value", Long.valueOf(paramLong3));
    SQLiteDatabase localSQLiteDatabase = this.c.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      localSQLiteDatabase.insert("counter_values", null, localContentValues);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }

  private long b(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.c.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("name", paramString);
      long l = localSQLiteDatabase.insert("counter_names", null, localContentValues);
      localSQLiteDatabase.setTransactionSuccessful();
      return l;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }

  // ERROR //
  public java.util.List<android.util.Pair<String, Long>> a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 55	java/lang/String
    //   4: dup
    //   5: iconst_0
    //   6: ldc 59
    //   8: aastore
    //   9: dup
    //   10: iconst_1
    //   11: ldc 142
    //   13: aastore
    //   14: astore 5
    //   16: invokestatic 147	com/google/common/collect/ImmutableList:e	()Lcom/google/common/collect/ImmutableList$Builder;
    //   19: astore 6
    //   21: aload_0
    //   22: getfield 22	com/facebook/analytics/CounterHistoricalData:c	Lcom/facebook/analytics/AnalyticsDatabaseSupplier;
    //   25: invokevirtual 64	com/facebook/analytics/AnalyticsDatabaseSupplier:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   28: astore 7
    //   30: iconst_2
    //   31: anewarray 4	java/lang/Object
    //   34: astore 10
    //   36: aload 10
    //   38: iconst_0
    //   39: lload_1
    //   40: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   43: aastore
    //   44: aload 10
    //   46: iconst_1
    //   47: lload_3
    //   48: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: aastore
    //   52: aload 7
    //   54: ldc 149
    //   56: aload 5
    //   58: ldc 151
    //   60: aload 10
    //   62: invokestatic 156	com/facebook/orca/common/util/StringUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   65: aconst_null
    //   66: ldc 59
    //   68: aconst_null
    //   69: aconst_null
    //   70: invokevirtual 159	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore 11
    //   75: aload 11
    //   77: astore 9
    //   79: aload 9
    //   81: invokeinterface 83 1 0
    //   86: istore 12
    //   88: iload 12
    //   90: ifeq +51 -> 141
    //   93: aload 6
    //   95: new 161	android/util/Pair
    //   98: dup
    //   99: aload 9
    //   101: iconst_0
    //   102: invokeinterface 87 2 0
    //   107: aload 9
    //   109: iconst_1
    //   110: invokeinterface 91 2 0
    //   115: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   118: invokespecial 164	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   121: invokevirtual 169	com/google/common/collect/ImmutableList$Builder:b	(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;
    //   124: pop
    //   125: aload 9
    //   127: invokeinterface 97 1 0
    //   132: istore 14
    //   134: iload 14
    //   136: istore 12
    //   138: goto -50 -> 88
    //   141: aload 9
    //   143: ifnull +10 -> 153
    //   146: aload 9
    //   148: invokeinterface 100 1 0
    //   153: aload 6
    //   155: invokevirtual 172	com/google/common/collect/ImmutableList$Builder:b	()Lcom/google/common/collect/ImmutableList;
    //   158: areturn
    //   159: astore 8
    //   161: aconst_null
    //   162: astore 9
    //   164: aload 9
    //   166: ifnull +10 -> 176
    //   169: aload 9
    //   171: invokeinterface 100 1 0
    //   176: aload 8
    //   178: athrow
    //   179: astore 8
    //   181: goto -17 -> 164
    //
    // Exception table:
    //   from	to	target	type
    //   30	75	159	finally
    //   79	134	179	finally
  }

  public void a(long paramLong, String paramString, Map<String, Long> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Long)localEntry.getValue()).longValue() > 0L)
        a(paramLong, a(paramString + "." + (String)localEntry.getKey()).longValue(), ((Long)localEntry.getValue()).longValue());
    }
  }

  public int b(long paramLong1, long paramLong2)
  {
    SQLiteDatabase localSQLiteDatabase = this.c.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Long.valueOf(paramLong1);
      arrayOfObject[1] = Long.valueOf(paramLong2);
      int i = localSQLiteDatabase.delete("counter_values", StringUtil.a("(time>= %d) and (time< %d)", arrayOfObject), null);
      localSQLiteDatabase.setTransactionSuccessful();
      return i;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.CounterHistoricalData
 * JD-Core Version:    0.6.2
 */