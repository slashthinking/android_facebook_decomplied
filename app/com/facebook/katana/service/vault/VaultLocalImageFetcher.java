package com.facebook.katana.service.vault;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.activity.media.MediaItemFactory;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.provider.VaultImageProvider;
import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.katana.service.vault.methods.VaultBlacklistedSyncPathsGet;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VaultLocalImageFetcher
{
  private static final String a = VaultLocalImageFetcher.class.getSimpleName();
  private final Context b;

  public VaultLocalImageFetcher(Context paramContext)
  {
    this.b = paramContext;
  }

  private long a(VaultLocalImageFetcher.TIMESTAMP paramTIMESTAMP)
  {
    String str1;
    long l;
    if (paramTIMESTAMP == VaultLocalImageFetcher.TIMESTAMP.MAX)
    {
      str1 = "DESC";
      String str2 = StringUtil.a("%s %s LIMIT 1", new Object[] { "datetaken", str1 });
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "datetaken";
      arrayOfObject[1] = Integer.valueOf(0);
      String str3 = StringUtil.a("%s > %d", arrayOfObject);
      ArrayList localArrayList = Lists.a();
      String str4 = a(str3, localArrayList);
      Cursor localCursor = this.b.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, str4, (String[])localArrayList.toArray(new String[localArrayList.size()]), str2);
      if ((localCursor == null) || (!localCursor.moveToFirst()))
        break label161;
      l = localCursor.getLong(localCursor.getColumnIndex("datetaken"));
      localCursor.close();
    }
    while (true)
    {
      return l;
      str1 = "ASC";
      break;
      label161: l = 0L;
    }
  }

  private String a(String paramString, List<String> paramList)
  {
    return a(paramString, paramList, VaultBlacklistedSyncPathsGet.b(this.b));
  }

  public static String a(String paramString, List<String> paramList1, List<String> paramList2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramList2 == null) || (paramList2.isEmpty()));
    while (true)
    {
      return paramString;
      Iterator localIterator = paramList2.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localStringBuffer.length() > 0)
          localStringBuffer.append(StringUtil.a(" AND ", new Object[0]));
        localStringBuffer.append(StringUtil.a("(lower(%s) NOT LIKE lower(?))", new Object[] { "_data" }));
        paramList1.add(str + "%");
      }
      if (localStringBuffer.length() <= 0)
        continue;
      if ((paramString == null) || (TextUtils.isEmpty(paramString)))
      {
        paramString = localStringBuffer.toString();
        continue;
      }
      paramString = StringLocaleUtil.a("(%s) AND (%s)", new Object[] { paramString, localStringBuffer });
    }
  }

  private StringBuffer a(Set<String> paramSet, List<String> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = VaultImageProvider.a((String)localIterator.next());
      String str = (String)localPair.first;
      Long localLong = (Long)localPair.second;
      if (localStringBuffer.length() > 0)
        localStringBuffer.append(StringUtil.a(" or ", new Object[0]));
      localStringBuffer.append(StringUtil.a("(%s = ?", new Object[] { "_display_name" }));
      paramList.add(str);
      localStringBuffer.append(StringUtil.a(" and %s = ?)", new Object[] { "datetaken" }));
      paramList.add("" + localLong);
    }
    return localStringBuffer;
  }

  private Map<String, MediaItem> a(Cursor paramCursor, Map<String, Long> paramMap)
  {
    HashMap localHashMap = new HashMap();
    while (paramCursor.moveToNext())
    {
      String str1 = paramCursor.getString(5);
      if (str1 == null)
        continue;
      String str2 = paramCursor.getString(1);
      if (str2 == null)
        continue;
      String str3 = paramCursor.getString(3);
      if ((str3 == null) || (str3.startsWith("*/")))
      {
        str3 = MediaItemFactory.a(str2);
        if (str3 == null)
          continue;
      }
      long l1 = paramCursor.getLong(4);
      String str4 = VaultImageProvider.a(str1, l1);
      long l2;
      if (paramMap.containsKey(str4))
        l2 = ((Long)paramMap.get(str4)).longValue();
      while (true)
      {
        localHashMap.put(str4, new PhotoItem(paramCursor.getLong(0), str2, str1, str3, l1, paramCursor.getInt(2), l2, null, null));
        break;
        l2 = -1L;
      }
    }
    paramCursor.close();
    return localHashMap;
  }

  private Map<String, MediaItem> a(Map<String, Long> paramMap, String paramString, List<String> paramList)
  {
    Object localObject;
    if (paramMap == null)
      localObject = Maps.a();
    while (true)
    {
      return localObject;
      String[] arrayOfString = { "_id", "_data", "orientation", "mime_type", "datetaken", "_display_name" };
      String str = a(paramString, paramList);
      Cursor localCursor = this.b.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrayOfString, str, (String[])paramList.toArray(new String[paramList.size()]), "date_modified DESC");
      if (localCursor == null)
      {
        localObject = Maps.a();
        continue;
      }
      localObject = a(localCursor, paramMap);
    }
  }

  private boolean c(String paramString)
  {
    boolean bool = true;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = bool;
    BitmapFactory.decodeFile(paramString, localOptions);
    if ((localOptions.outWidth >= 100) && (localOptions.outHeight >= 100));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  private boolean d(String paramString)
  {
    if (new File(paramString).length() == 0L);
    for (int i = 1; ; i = 0)
      return i;
  }

  public int a()
  {
    String[] arrayOfString = { "COUNT(*)" };
    ArrayList localArrayList = Lists.a();
    String str = a("", localArrayList);
    Cursor localCursor = this.b.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrayOfString, str, (String[])localArrayList.toArray(new String[localArrayList.size()]), null);
    int i;
    if ((localCursor != null) && (localCursor.moveToFirst()))
    {
      i = localCursor.getInt(0);
      localCursor.close();
    }
    while (true)
    {
      return i;
      i = 0;
    }
  }

  public String a(String paramString)
  {
    String[] arrayOfString1 = { "_data", "_display_name", "datetaken" };
    Pair localPair = VaultImageProvider.a(paramString);
    Object localObject1 = null;
    if (localPair == null);
    while (true)
    {
      return localObject1;
      String str1 = (String)localPair.first;
      long l = ((Long)localPair.second).longValue();
      String str2 = StringLocaleUtil.a("%s = ? AND %s = ?", new Object[] { "_display_name", "datetaken" });
      String[] arrayOfString2 = new String[2];
      arrayOfString2[0] = str1;
      arrayOfString2[1] = Long.toString(l);
      Cursor localCursor = this.b.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrayOfString1, str2, arrayOfString2, null);
      localObject1 = null;
      if (localCursor == null)
        continue;
      try
      {
        if (localCursor.moveToNext())
        {
          String str3 = localCursor.getString(localCursor.getColumnIndex("_data"));
          localObject1 = str3;
          localCursor.close();
          continue;
        }
        localCursor.close();
        localObject1 = null;
      }
      finally
      {
        localCursor.close();
      }
    }
  }

  public Map<String, MediaItem> a(long paramLong)
  {
    Map localMap = ((VaultTable)FbInjector.a(this.b).a(VaultTable.class)).b(paramLong);
    String str = StringLocaleUtil.a("%s >= ?", new Object[] { "datetaken" });
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.toString(paramLong));
    return a(localMap, str, localArrayList);
  }

  public Map<String, VaultImageProviderRow> a(long paramLong, int paramInt1, VaultLocalImageFetcher.SearchConstraint paramSearchConstraint, int paramInt2)
  {
    // Byte code:
    //   0: iconst_4
    //   1: anewarray 78	java/lang/String
    //   4: dup
    //   5: iconst_0
    //   6: ldc_w 269
    //   9: aastore
    //   10: dup
    //   11: iconst_1
    //   12: ldc 149
    //   14: aastore
    //   15: dup
    //   16: iconst_2
    //   17: ldc 201
    //   19: aastore
    //   20: dup
    //   21: iconst_3
    //   22: ldc 37
    //   24: aastore
    //   25: astore 6
    //   27: invokestatic 55	com/google/common/collect/Lists:a	()Ljava/util/ArrayList;
    //   30: astore 7
    //   32: getstatic 340	com/facebook/katana/service/vault/VaultLocalImageFetcher$1:a	[I
    //   35: aload 4
    //   37: invokevirtual 345	com/facebook/katana/service/vault/VaultLocalImageFetcher$SearchConstraint:ordinal	()I
    //   40: iaload
    //   41: tableswitch	default:+23 -> 64, 1:+52->93, 2:+330->371
    //   65: aconst_null
    //   66: dup_x2
    //   67: iconst_1
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload 4
    //   75: aastore
    //   76: invokestatic 42	com/facebook/orca/common/util/StringUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   79: ldc 205
    //   81: iconst_1
    //   82: invokestatic 352	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   85: invokestatic 358	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   88: astore 15
    //   90: aload 15
    //   92: areturn
    //   93: ldc_w 360
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: ldc 37
    //   104: aastore
    //   105: invokestatic 175	com/facebook/orca/common/util/StringLocaleUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   108: astore 8
    //   110: aload 7
    //   112: lload_1
    //   113: invokestatic 313	java/lang/Long:toString	(J)Ljava/lang/String;
    //   116: invokeinterface 164 2 0
    //   121: pop
    //   122: aload_0
    //   123: aload 8
    //   125: aload 7
    //   127: invokespecial 58	com/facebook/katana/service/vault/VaultLocalImageFetcher:a	(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;
    //   130: astore 10
    //   132: iconst_2
    //   133: anewarray 4	java/lang/Object
    //   136: astore 11
    //   138: aload 11
    //   140: iconst_0
    //   141: ldc 37
    //   143: aastore
    //   144: aload 11
    //   146: iconst_1
    //   147: iload_3
    //   148: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: aastore
    //   152: ldc_w 362
    //   155: aload 11
    //   157: invokestatic 42	com/facebook/orca/common/util/StringUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: astore 12
    //   162: invokestatic 365	com/google/common/collect/Maps:b	()Ljava/util/LinkedHashMap;
    //   165: astore 13
    //   167: aload_0
    //   168: getfield 24	com/facebook/katana/service/vault/VaultLocalImageFetcher:b	Landroid/content/Context;
    //   171: invokevirtual 64	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   174: getstatic 70	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   177: aload 6
    //   179: aload 10
    //   181: aload 7
    //   183: aload 7
    //   185: invokeinterface 76 1 0
    //   190: anewarray 78	java/lang/String
    //   193: invokeinterface 82 2 0
    //   198: checkcast 84	[Ljava/lang/String;
    //   201: aload 12
    //   203: invokevirtual 90	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   206: astore 14
    //   208: aload 14
    //   210: ifnull +200 -> 410
    //   213: aload 14
    //   215: ldc 201
    //   217: invokeinterface 100 2 0
    //   222: istore 17
    //   224: aload 14
    //   226: ldc 37
    //   228: invokeinterface 100 2 0
    //   233: istore 18
    //   235: aload 14
    //   237: ldc 149
    //   239: invokeinterface 100 2 0
    //   244: istore 19
    //   246: aload 14
    //   248: invokeinterface 215 1 0
    //   253: ifeq +150 -> 403
    //   256: aload 14
    //   258: iload 19
    //   260: invokeinterface 219 2 0
    //   265: astore 20
    //   267: aload 14
    //   269: iload 17
    //   271: invokeinterface 219 2 0
    //   276: ifnull -30 -> 246
    //   279: aload_0
    //   280: aload 20
    //   282: invokespecial 367	com/facebook/katana/service/vault/VaultLocalImageFetcher:c	(Ljava/lang/String;)Z
    //   285: ifeq -39 -> 246
    //   288: aload_0
    //   289: aload 20
    //   291: invokespecial 369	com/facebook/katana/service/vault/VaultLocalImageFetcher:d	(Ljava/lang/String;)Z
    //   294: ifne -48 -> 246
    //   297: aload 14
    //   299: iload 17
    //   301: invokeinterface 219 2 0
    //   306: aload 14
    //   308: iload 18
    //   310: invokeinterface 104 2 0
    //   315: invokestatic 233	com/facebook/katana/provider/VaultImageProvider:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   318: astore 21
    //   320: aload 13
    //   322: aload 21
    //   324: new 371	com/facebook/katana/provider/VaultImageProviderRow
    //   327: dup
    //   328: aload 21
    //   330: lconst_0
    //   331: aload 14
    //   333: iload 18
    //   335: invokeinterface 104 2 0
    //   340: lconst_0
    //   341: iconst_0
    //   342: iload 5
    //   344: iconst_0
    //   345: iconst_0
    //   346: lconst_0
    //   347: invokespecial 374	com/facebook/katana/provider/VaultImageProviderRow:<init>	(Ljava/lang/String;JJJIIIIJ)V
    //   350: invokeinterface 375 3 0
    //   355: pop
    //   356: goto -110 -> 246
    //   359: astore 16
    //   361: aload 14
    //   363: invokeinterface 107 1 0
    //   368: aload 16
    //   370: athrow
    //   371: ldc_w 328
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: ldc 37
    //   382: aastore
    //   383: invokestatic 175	com/facebook/orca/common/util/StringLocaleUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   386: astore 8
    //   388: aload 7
    //   390: lload_1
    //   391: invokestatic 313	java/lang/Long:toString	(J)Ljava/lang/String;
    //   394: invokeinterface 164 2 0
    //   399: pop
    //   400: goto -278 -> 122
    //   403: aload 14
    //   405: invokeinterface 107 1 0
    //   410: aload 13
    //   412: astore 15
    //   414: goto -324 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   213	356	359	finally
  }

  public Map<String, MediaItem> a(Set<String> paramSet)
  {
    Preconditions.checkNotNull(paramSet);
    Map localMap = ((VaultTable)FbInjector.a(this.b).a(VaultTable.class)).b(paramSet);
    ArrayList localArrayList = new ArrayList();
    String str = null;
    if (paramSet != null)
      str = a(paramSet, localArrayList).toString();
    return a(localMap, str, localArrayList);
  }

  public MediaItem b(String paramString)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(paramString);
    Map localMap = a(localHashSet);
    if (localMap != null);
    for (MediaItem localMediaItem = (MediaItem)localMap.values().iterator().next(); ; localMediaItem = null)
      return localMediaItem;
  }

  public boolean b()
  {
    if (c() == 0L);
    for (int i = 1; ; i = 0)
      return i;
  }

  public long c()
  {
    return a(VaultLocalImageFetcher.TIMESTAMP.MIN);
  }

  public Map<String, MediaItem> d()
  {
    return a(Maps.a(), null, new ArrayList());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultLocalImageFetcher
 * JD-Core Version:    0.6.0
 */