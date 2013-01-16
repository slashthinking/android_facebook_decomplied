package com.facebook.orca.sms;

import com.facebook.analytics.AnalyticsDbProperties;
import com.facebook.analytics.AnalyticsPropertyUtil;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.database.DbParticipantsSerialization;
import com.facebook.orca.database.ThreadsDatabaseSupplier;
import javax.inject.Provider;

public class MmsSmsLogExternalMessagesLogic
{
  private static final Class<?> a = MmsSmsLogExternalMessagesLogic.class;
  private final ThreadsDatabaseSupplier b;
  private final Provider<Boolean> c;
  private final DataCache d;
  private final DbParticipantsSerialization e;
  private final AnalyticsPropertyUtil f;
  private final Clock g;

  public MmsSmsLogExternalMessagesLogic(DataCache paramDataCache, Provider<Boolean> paramProvider, ThreadsDatabaseSupplier paramThreadsDatabaseSupplier, DbParticipantsSerialization paramDbParticipantsSerialization, AnalyticsPropertyUtil paramAnalyticsPropertyUtil, Clock paramClock)
  {
    this.d = paramDataCache;
    this.c = paramProvider;
    this.b = paramThreadsDatabaseSupplier;
    this.e = paramDbParticipantsSerialization;
    this.f = paramAnalyticsPropertyUtil;
    this.g = paramClock;
  }

  // ERROR //
  private MmsSmsLogExternalMessagesLogic.MmsSmsLogExternalCounts a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/facebook/orca/sms/MmsSmsLogExternalMessagesLogic:b	Lcom/facebook/orca/database/ThreadsDatabaseSupplier;
    //   4: invokevirtual 48	com/facebook/orca/database/ThreadsDatabaseSupplier:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_3
    //   8: iconst_1
    //   9: anewarray 50	java/lang/String
    //   12: astore 4
    //   14: aload 4
    //   16: iconst_0
    //   17: lload_1
    //   18: invokestatic 56	java/lang/Long:toString	(J)Ljava/lang/String;
    //   21: aastore
    //   22: aload_3
    //   23: ldc 58
    //   25: aload 4
    //   27: invokevirtual 64	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore 5
    //   32: iconst_0
    //   33: istore 6
    //   35: iconst_0
    //   36: istore 7
    //   38: iconst_0
    //   39: istore 8
    //   41: iconst_0
    //   42: istore 9
    //   44: lload_1
    //   45: lstore 10
    //   47: aload 5
    //   49: invokeinterface 70 1 0
    //   54: ifeq +151 -> 205
    //   57: aload 5
    //   59: iconst_0
    //   60: invokeinterface 74 2 0
    //   65: astore 19
    //   67: aload 19
    //   69: invokestatic 80	com/facebook/orca/threads/MessagingIdUtil:i	(Ljava/lang/String;)Z
    //   72: ifne +11 -> 83
    //   75: aload 19
    //   77: invokestatic 83	com/facebook/orca/threads/MessagingIdUtil:h	(Ljava/lang/String;)Z
    //   80: ifeq -33 -> 47
    //   83: aload_0
    //   84: getfield 36	com/facebook/orca/sms/MmsSmsLogExternalMessagesLogic:e	Lcom/facebook/orca/database/DbParticipantsSerialization;
    //   87: aload 5
    //   89: iconst_1
    //   90: invokeinterface 74 2 0
    //   95: invokevirtual 88	com/facebook/orca/database/DbParticipantsSerialization:a	(Ljava/lang/String;)Lcom/facebook/orca/threads/ParticipantInfo;
    //   98: astore 20
    //   100: aload 5
    //   102: iconst_2
    //   103: invokeinterface 92 2 0
    //   108: lstore 21
    //   110: aload_0
    //   111: getfield 30	com/facebook/orca/sms/MmsSmsLogExternalMessagesLogic:d	Lcom/facebook/orca/cache/DataCache;
    //   114: invokevirtual 97	com/facebook/orca/cache/DataCache:a	()Lcom/facebook/orca/users/User;
    //   117: ifnull +47 -> 164
    //   120: aload_0
    //   121: getfield 30	com/facebook/orca/sms/MmsSmsLogExternalMessagesLogic:d	Lcom/facebook/orca/cache/DataCache;
    //   124: invokevirtual 97	com/facebook/orca/cache/DataCache:a	()Lcom/facebook/orca/users/User;
    //   127: invokevirtual 102	com/facebook/orca/users/User:c	()Lcom/facebook/orca/users/UserKey;
    //   130: aload 20
    //   132: invokevirtual 106	com/facebook/orca/threads/ParticipantInfo:e	()Lcom/facebook/orca/users/UserKey;
    //   135: invokestatic 112	com/google/common/base/Objects:equal	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   138: ifeq +26 -> 164
    //   141: aload 19
    //   143: invokestatic 80	com/facebook/orca/threads/MessagingIdUtil:i	(Ljava/lang/String;)Z
    //   146: ifeq +140 -> 286
    //   149: iinc 6 1
    //   152: lload 10
    //   154: lload 21
    //   156: invokestatic 118	java/lang/Math:max	(JJ)J
    //   159: lstore 10
    //   161: goto -114 -> 47
    //   164: aload 20
    //   166: invokevirtual 120	com/facebook/orca/threads/ParticipantInfo:c	()Z
    //   169: ifeq -122 -> 47
    //   172: aload 19
    //   174: invokestatic 80	com/facebook/orca/threads/MessagingIdUtil:i	(Ljava/lang/String;)Z
    //   177: ifeq +22 -> 199
    //   180: iinc 8 1
    //   183: lload 10
    //   185: lload 21
    //   187: invokestatic 118	java/lang/Math:max	(JJ)J
    //   190: lstore 23
    //   192: lload 23
    //   194: lstore 10
    //   196: goto -149 -> 47
    //   199: iinc 9 1
    //   202: goto -19 -> 183
    //   205: aload 5
    //   207: invokeinterface 123 1 0
    //   212: iload 9
    //   214: istore 14
    //   216: iload 8
    //   218: istore 18
    //   220: iload 6
    //   222: istore 16
    //   224: iload 18
    //   226: istore 17
    //   228: new 125	com/facebook/orca/sms/MmsSmsLogExternalMessagesLogic$MmsSmsLogExternalCounts
    //   231: dup
    //   232: iload 16
    //   234: iload 7
    //   236: iload 17
    //   238: iload 14
    //   240: lload 10
    //   242: invokespecial 128	com/facebook/orca/sms/MmsSmsLogExternalMessagesLogic$MmsSmsLogExternalCounts:<init>	(IIIIJ)V
    //   245: areturn
    //   246: astore 13
    //   248: iload 9
    //   250: istore 14
    //   252: iload 8
    //   254: istore 15
    //   256: iload 6
    //   258: istore 16
    //   260: iload 15
    //   262: istore 17
    //   264: aload 5
    //   266: invokeinterface 123 1 0
    //   271: goto -43 -> 228
    //   274: astore 12
    //   276: aload 5
    //   278: invokeinterface 123 1 0
    //   283: aload 12
    //   285: athrow
    //   286: iinc 7 1
    //   289: goto -137 -> 152
    //
    // Exception table:
    //   from	to	target	type
    //   47	192	246	java/io/IOException
    //   47	192	274	finally
  }

  private boolean c()
  {
    if (this.f.a(AnalyticsDbProperties.h, -1L) == -1L);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean a()
  {
    if ((this.d.a() != null) && (((Boolean)this.c.b()).booleanValue()));
    for (int i = 1; ; i = 0)
      return i;
  }

  MmsSmsLogExternalMessagesLogic.MmsSmsLogExternalCounts b()
  {
    MmsSmsLogExternalMessagesLogic.MmsSmsLogExternalCounts localMmsSmsLogExternalCounts;
    if (c())
    {
      this.f.b(AnalyticsDbProperties.h, this.g.a());
      localMmsSmsLogExternalCounts = MmsSmsLogExternalMessagesLogic.MmsSmsLogExternalCounts.f;
    }
    while (true)
    {
      return localMmsSmsLogExternalCounts;
      localMmsSmsLogExternalCounts = a(this.f.a(AnalyticsDbProperties.h, 0L));
      this.f.b(AnalyticsDbProperties.h, Math.max(localMmsSmsLogExternalCounts.e, this.g.a() - 86400000L));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsLogExternalMessagesLogic
 * JD-Core Version:    0.6.0
 */