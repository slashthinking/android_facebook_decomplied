package com.facebook.katana.binding;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.katana.provider.CacheProvider;
import com.google.common.base.Preconditions;

public class MDSDatabaseOperationHandler<K, V>
{
  private static final String[] a = { "value", "timestamp" };
  private final ManagedDataStore.Client<K, V> b;
  private final ContentResolver c;

  public MDSDatabaseOperationHandler(ManagedDataStore.Client<K, V> paramClient, ContentResolver paramContentResolver)
  {
    this.b = ((ManagedDataStore.Client)Preconditions.checkNotNull(paramClient));
    this.c = ((ContentResolver)Preconditions.checkNotNull(paramContentResolver));
  }

  private String c()
  {
    return this.b.getDiskKeyPrefix() + ":";
  }

  private Uri d(K paramK)
  {
    return Uri.withAppendedPath(CacheProvider.b, Uri.encode(c(paramK)));
  }

  // ERROR //
  MDSDatabaseOperationHandler.DiskStoreEntry<V> a(K paramK)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 81	com/facebook/katana/binding/MDSDatabaseOperationHandler:d	(Ljava/lang/Object;)Landroid/net/Uri;
    //   5: astore_2
    //   6: aload_0
    //   7: getfield 40	com/facebook/katana/binding/MDSDatabaseOperationHandler:c	Landroid/content/ContentResolver;
    //   10: aload_2
    //   11: getstatic 22	com/facebook/katana/binding/MDSDatabaseOperationHandler:a	[Ljava/lang/String;
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: invokevirtual 85	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore_3
    //   21: aload_3
    //   22: ifnull +69 -> 91
    //   25: aload_3
    //   26: invokeinterface 91 1 0
    //   31: ifeq +60 -> 91
    //   34: aload_3
    //   35: iconst_0
    //   36: invokeinterface 95 2 0
    //   41: astore 7
    //   43: aload_3
    //   44: iconst_1
    //   45: invokeinterface 99 2 0
    //   50: lstore 8
    //   52: new 101	com/facebook/katana/binding/MDSDatabaseOperationHandler$DiskStoreEntry
    //   55: dup
    //   56: aload_0
    //   57: getfield 36	com/facebook/katana/binding/MDSDatabaseOperationHandler:b	Lcom/facebook/katana/binding/ManagedDataStore$Client;
    //   60: aload 7
    //   62: invokeinterface 105 2 0
    //   67: lload 8
    //   69: invokespecial 108	com/facebook/katana/binding/MDSDatabaseOperationHandler$DiskStoreEntry:<init>	(Ljava/lang/Object;J)V
    //   72: astore 10
    //   74: aload_3
    //   75: ifnull +9 -> 84
    //   78: aload_3
    //   79: invokeinterface 111 1 0
    //   84: aload 10
    //   86: astore 4
    //   88: aload 4
    //   90: areturn
    //   91: aconst_null
    //   92: astore 4
    //   94: aload_3
    //   95: ifnull -7 -> 88
    //   98: aload_3
    //   99: invokeinterface 111 1 0
    //   104: aconst_null
    //   105: astore 4
    //   107: goto -19 -> 88
    //   110: astore 6
    //   112: aconst_null
    //   113: astore 4
    //   115: aload_3
    //   116: ifnull -28 -> 88
    //   119: aload_3
    //   120: invokeinterface 111 1 0
    //   125: aconst_null
    //   126: astore 4
    //   128: goto -40 -> 88
    //   131: astore 5
    //   133: aload_3
    //   134: ifnull +9 -> 143
    //   137: aload_3
    //   138: invokeinterface 111 1 0
    //   143: aload 5
    //   145: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   25	74	110	com/facebook/katana/binding/ManagedDataStore$DeserializeException
    //   25	74	131	finally
  }

  void a()
  {
    Uri localUri = Uri.withAppendedPath(CacheProvider.c, Uri.encode(c()));
    this.c.delete(localUri, null, null);
  }

  void a(long paramLong)
  {
    Uri localUri = Uri.withAppendedPath(Uri.withAppendedPath(CacheProvider.d, Uri.encode(c())), String.valueOf(1000L * paramLong));
    this.c.delete(localUri, null, null);
  }

  void a(K paramK, String paramString, long paramLong)
  {
    Uri localUri = d(paramK);
    Cursor localCursor = this.c.query(localUri, new String[] { "_id" }, null, null, null);
    ContentValues localContentValues;
    if (localCursor != null)
    {
      boolean bool = localCursor.moveToFirst();
      localCursor.close();
      localContentValues = new ContentValues();
      localContentValues.put("value", paramString);
      localContentValues.put("timestamp", Long.valueOf(paramLong));
      if (!bool)
        break label99;
      this.c.update(localUri, localContentValues, null, null);
    }
    while (true)
    {
      return;
      label99: localContentValues.put("name", c(paramK));
      this.c.insert(CacheProvider.a, localContentValues);
    }
  }

  void b()
  {
    Uri localUri = Uri.withAppendedPath(CacheProvider.c, Uri.encode(c()));
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("timestamp", Long.valueOf(-1L));
    this.c.update(localUri, localContentValues, null, null);
  }

  void b(K paramK)
  {
    this.c.delete(d(paramK), null, null);
  }

  String c(K paramK)
  {
    return c() + this.b.getDiskKeySuffix(paramK);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.MDSDatabaseOperationHandler
 * JD-Core Version:    0.6.0
 */