package com.facebook.katana.service.vault;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.provider.VaultImageProvider;
import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VaultTable
{
  private static final String a = VaultTable.class.getSimpleName();
  private final Context b;
  private final VaultLocalImageFetcher c;
  private final VaultRowStatusUpdater d;
  private final VaultImageStatusFetcher e;
  private final ContentResolver f;

  public VaultTable(Context paramContext, ContentResolver paramContentResolver, VaultLocalImageFetcher paramVaultLocalImageFetcher, VaultRowStatusUpdater paramVaultRowStatusUpdater, VaultImageStatusFetcher paramVaultImageStatusFetcher)
  {
    this.b = paramContext;
    this.f = paramContentResolver;
    this.c = paramVaultLocalImageFetcher;
    this.d = paramVaultRowStatusUpdater;
    this.e = paramVaultImageStatusFetcher;
  }

  private List<VaultImageProviderRow> a(Cursor paramCursor)
  {
    ArrayList localArrayList = Lists.b(paramCursor.getCount());
    if (paramCursor != null)
      try
      {
        if (paramCursor.moveToNext())
          localArrayList.add(new VaultImageProviderRow(paramCursor));
      }
      finally
      {
        paramCursor.close();
      }
    if (Log.a("vault", 2))
      Log.e(a, "getResultsFromCursor: " + localArrayList.toString());
    return localArrayList;
  }

  private List<VaultImageProviderRow> a(VaultTable.UpgradeStatus paramUpgradeStatus, int paramInt, VaultTable.AttemptStatus paramAttemptStatus, VaultTable.TimeConstraint paramTimeConstraint, long paramLong)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = Lists.a();
      return localObject;
    }
    ArrayList localArrayList = Lists.a();
    String str1 = StringUtil.a("%s = ?", new Object[] { "upload_state" });
    label105: String str3;
    label235: String str4;
    if (paramUpgradeStatus != VaultTable.UpgradeStatus.UPGRADE_ONLY)
    {
      localArrayList.add(Integer.toString(4));
      if (paramUpgradeStatus == VaultTable.UpgradeStatus.ALL)
      {
        str1 = str1 + StringUtil.a(" or %s = ?", new Object[] { "upload_state" });
        localArrayList.add(Integer.toString(0));
      }
      if (paramAttemptStatus == VaultTable.AttemptStatus.RETRY_WITH_HARD_FAILURES)
      {
        str1 = str1 + StringUtil.a(" or %s = ?", new Object[] { "upload_state" });
        localArrayList.add(Integer.toString(6));
      }
      String str2 = StringUtil.a("(%s) and (%s = ?)", new Object[] { str1, "queue_state" });
      localArrayList.add(Integer.toString(0));
      if (paramAttemptStatus != VaultTable.AttemptStatus.RETRY_SOFT_FAILURES_ONLY)
        break label388;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = "failure_count";
      arrayOfObject2[1] = "failure_count";
      arrayOfObject2[2] = Integer.valueOf(8);
      str3 = StringUtil.a("%s > 0 and %s < %d", arrayOfObject2);
      str4 = StringUtil.a("(%s) and (%s)", new Object[] { str2, str3 });
      if (paramTimeConstraint != VaultTable.TimeConstraint.OLD_PHOTOS)
        break label433;
      str4 = StringUtil.a("(%s) and (%s < ?)", new Object[] { str4, "date_taken" });
      localArrayList.add(Long.toString(paramLong));
    }
    while (true)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = "date_taken";
      arrayOfObject1[1] = Integer.valueOf(paramInt);
      String str5 = StringUtil.a("%s DESC LIMIT %d", arrayOfObject1);
      localObject = a(this.f.query(VaultImageProvider.a, VaultImageProvider.b, str4, (String[])localArrayList.toArray(new String[localArrayList.size()]), str5));
      break;
      localArrayList.add(Integer.toString(0));
      break label105;
      label388: if (paramAttemptStatus == VaultTable.AttemptStatus.RETRY_WITH_HARD_FAILURES)
      {
        str3 = StringUtil.a("%s > 0", new Object[] { "failure_count" });
        break label235;
      }
      str3 = StringUtil.a("%s = 0", new Object[] { "failure_count" });
      break label235;
      label433: if (paramTimeConstraint != VaultTable.TimeConstraint.NEW_PHOTOS)
        continue;
      str4 = StringUtil.a("(%s) and (%s >= ?)", new Object[] { str4, "date_taken" });
      localArrayList.add(Long.toString(paramLong));
    }
  }

  private Map<String, Long> a(String paramString, List paramList)
  {
    HashMap localHashMap = null;
    String[] arrayOfString = { "image_hash", "image_fbid" };
    Cursor localCursor = this.b.getContentResolver().query(VaultImageProvider.a, arrayOfString, paramString, (String[])(String[])paramList.toArray(new String[paramList.size()]), null);
    if (localCursor == null)
      ErrorReporting.a("get_fbids_for_hashes_no_cursor", "no vault cursor", true);
    while (true)
    {
      return localHashMap;
      localHashMap = Maps.a();
      while (localCursor.moveToNext())
        localHashMap.put(localCursor.getString(0), Long.valueOf(localCursor.getLong(1)));
      localCursor.close();
    }
  }

  private Set<String> a(Map<String, VaultImageProviderRow> paramMap)
  {
    Map localMap1 = this.e.a(paramMap.keySet(), UserValuesManager.g(this.b));
    Map localMap2 = this.d.a(paramMap, localMap1);
    ContentValues[] arrayOfContentValues = new ContentValues[localMap2.size()];
    Iterator localIterator = localMap2.values().iterator();
    int k;
    for (int i = 0; localIterator.hasNext(); i = k)
    {
      VaultImageProviderRow localVaultImageProviderRow = (VaultImageProviderRow)localIterator.next();
      k = i + 1;
      arrayOfContentValues[i] = localVaultImageProviderRow.c();
    }
    int j = this.f.bulkInsert(VaultImageProvider.a, arrayOfContentValues);
    String str = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(j);
    Log.d(str, StringUtil.a("added %d new rows to VaultTable", arrayOfObject));
    return localMap2.keySet();
  }

  private long b(int paramInt)
  {
    String str1;
    if (paramInt == 1)
      str1 = "DESC";
    while (true)
    {
      String str2 = StringUtil.a("%s %s", new Object[] { "date_taken", str1 });
      Cursor localCursor = this.f.query(VaultImageProvider.a, null, null, null, str2);
      try
      {
        if (localCursor.moveToNext())
        {
          long l2 = localCursor.getLong(localCursor.getColumnIndex("date_taken"));
          l1 = l2;
          return l1;
          str1 = "ASC";
          continue;
        }
        localCursor.close();
        long l1 = 0L;
      }
      finally
      {
        localCursor.close();
      }
    }
  }

  private long e()
  {
    String str1 = StringUtil.a("%s DESC LIMIT 1", new Object[] { "date_taken" });
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = "upload_state";
    arrayOfObject[1] = Integer.valueOf(4);
    arrayOfObject[2] = "queue_state";
    arrayOfObject[3] = Integer.valueOf(0);
    String str2 = StringUtil.a("%s != %d AND %s = %d", arrayOfObject);
    Cursor localCursor = this.f.query(VaultImageProvider.a, new String[] { "date_taken" }, str2, null, str1);
    long l = 0L;
    if (localCursor != null)
    {
      if (localCursor.moveToFirst())
        l = localCursor.getLong(localCursor.getColumnIndex("date_taken"));
      localCursor.close();
    }
    return l;
  }

  private String f()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = "upload_state";
    arrayOfObject[1] = Integer.valueOf(0);
    arrayOfObject[2] = Integer.valueOf(1);
    arrayOfObject[3] = Integer.valueOf(4);
    arrayOfObject[4] = Integer.valueOf(5);
    arrayOfObject[5] = Integer.valueOf(6);
    return StringUtil.a("%s IN (%d, %d, %d, %d, %d)", arrayOfObject).toString();
  }

  private long g()
  {
    long l = b(2);
    if (l != 0L);
    while (true)
    {
      return l;
      l = UserValuesManager.m(this.b);
    }
  }

  private void h()
  {
    Log.d(a, "--------------- Dumping VaultTable --------------");
    String str = StringUtil.a("%s DESC", new Object[] { "date_taken" });
    Cursor localCursor = this.f.query(VaultImageProvider.a, null, null, null, str);
    try
    {
      if (localCursor.moveToNext())
      {
        VaultImageProviderRow localVaultImageProviderRow = new VaultImageProviderRow(localCursor);
        Log.d(a, localVaultImageProviderRow.toString());
      }
    }
    finally
    {
      localCursor.close();
    }
    Log.d(a, "-------------------------------------------------");
  }

  public int a(long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("queue_state", Integer.valueOf(0));
    String str = StringUtil.a("%s < ? AND %s = ?", new Object[] { "last_attempt", "queue_state" });
    ArrayList localArrayList = Lists.a();
    localArrayList.add(Long.toString(System.currentTimeMillis() - paramLong));
    localArrayList.add(Integer.toString(1));
    int i = this.f.update(VaultImageProvider.a, localContentValues, str, (String[])localArrayList.toArray(new String[localArrayList.size()]));
    Log.d(a, "reseting queue flags for # rows: " + i);
    return i;
  }

  public VaultImageProviderRow a(String paramString)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(paramString);
    List localList = a(localHashSet);
    if ((localList != null) && (localList.size() > 0));
    for (VaultImageProviderRow localVaultImageProviderRow = (VaultImageProviderRow)localList.iterator().next(); ; localVaultImageProviderRow = null)
      return localVaultImageProviderRow;
  }

  public VaultTable.SyncableRows a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList1 = Lists.a();
    ArrayList localArrayList2 = Lists.a();
    ArrayList localArrayList3 = Lists.a();
    long l = e();
    List localList = a(VaultTable.UpgradeStatus.NO_UPGRADES, paramInt, VaultTable.AttemptStatus.FIRST, VaultTable.TimeConstraint.NONE, 0L);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      VaultImageProviderRow localVaultImageProviderRow = (VaultImageProviderRow)localIterator.next();
      if (localVaultImageProviderRow.c >= l)
      {
        localArrayList1.add(localVaultImageProviderRow);
        continue;
      }
      localArrayList2.add(localVaultImageProviderRow);
    }
    if ((paramBoolean) && (localList.size() < paramInt));
    for (Object localObject = a(VaultTable.UpgradeStatus.UPGRADE_ONLY, paramInt - localList.size(), VaultTable.AttemptStatus.FIRST, VaultTable.TimeConstraint.NONE, 0L); ; localObject = localArrayList3)
    {
      String str = a;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(localArrayList1.size());
      arrayOfObject[1] = Integer.valueOf(localArrayList2.size());
      arrayOfObject[2] = Integer.valueOf(((List)localObject).size());
      Log.e(str, StringUtil.a("getAllSyncabledRows: new: %d, old: %d, upgrade: %d", arrayOfObject));
      localArrayList2.addAll((Collection)localObject);
      return new VaultTable.SyncableRows(this, localArrayList1, localArrayList2);
    }
  }

  public StringBuffer a(Set<String> paramSet, List<String> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramSet != null) && (paramSet.size() > 0))
    {
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localStringBuffer.length() > 0)
          localStringBuffer.append(StringUtil.a(" or ", new Object[0]));
        localStringBuffer.append(StringUtil.a("%s = ?", new Object[] { "image_hash" }));
        paramList.add(str);
      }
    }
    return localStringBuffer;
  }

  public List<VaultImageProviderRow> a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    VaultTable.AttemptStatus localAttemptStatus;
    if (paramBoolean2)
    {
      localAttemptStatus = VaultTable.AttemptStatus.RETRY_WITH_HARD_FAILURES;
      if (!paramBoolean1)
        break label40;
    }
    label40: for (VaultTable.UpgradeStatus localUpgradeStatus = VaultTable.UpgradeStatus.ALL; ; localUpgradeStatus = VaultTable.UpgradeStatus.NO_UPGRADES)
    {
      return a(localUpgradeStatus, paramInt, localAttemptStatus, VaultTable.TimeConstraint.NONE, 0L);
      localAttemptStatus = VaultTable.AttemptStatus.RETRY_SOFT_FAILURES_ONLY;
      break;
    }
  }

  public List<VaultImageProviderRow> a(long paramLong, int paramInt, boolean paramBoolean)
  {
    String str1 = StringUtil.a("%s DESC", new Object[] { "date_taken" });
    String str2 = StringLocaleUtil.a("%s >= ?", new Object[] { "date_taken" });
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.toString(paramLong));
    String str3 = StringUtil.a("(%s) and (%s)", new Object[] { str2, f() });
    List localList1 = a(this.f.query(VaultImageProvider.a, null, str3, (String[])(String[])localArrayList.toArray(new String[localArrayList.size()]), str1));
    HashSet localHashSet;
    Iterator localIterator;
    if (paramBoolean)
    {
      localHashSet = Sets.a();
      localIterator = localList1.iterator();
    }
    int j;
    for (int i = 0; ; i = j)
    {
      if (localIterator.hasNext())
      {
        localHashSet.add(((VaultImageProviderRow)localIterator.next()).a);
        j = i + 1;
        if (j < paramInt)
          continue;
      }
      Map localMap = this.e.a(localHashSet, UserValuesManager.g(this.b));
      List localList2 = this.d.a(localList1, localMap);
      if (localList2.size() > 0)
        a(localList2);
      return localList1;
    }
  }

  public List<VaultImageProviderRow> a(Set<String> paramSet)
  {
    ArrayList localArrayList = Lists.a();
    StringBuffer localStringBuffer = a(paramSet, localArrayList);
    int i = localStringBuffer.length();
    Cursor localCursor = null;
    if (i > 0)
    {
      String str1 = StringUtil.a("%s DESC", new Object[] { "date_taken" });
      String str2 = StringUtil.a("%s", new Object[] { localStringBuffer });
      localCursor = this.f.query(VaultImageProvider.a, null, str2, (String[])localArrayList.toArray(new String[localArrayList.size()]), str1);
    }
    return a(localCursor);
  }

  public Map<String, VaultImageProviderRow> a(long paramLong, int paramInt1, VaultLocalImageFetcher.SearchConstraint paramSearchConstraint, int paramInt2)
  {
    String[] arrayOfString = { "image_hash" };
    String str1;
    if (paramSearchConstraint == VaultLocalImageFetcher.SearchConstraint.BEFORE)
      str1 = "%s <= %d";
    HashSet localHashSet;
    while (true)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = "date_taken";
      arrayOfObject1[1] = Long.valueOf(paramLong);
      String str2 = StringUtil.a(str1, arrayOfObject1);
      Cursor localCursor = this.b.getContentResolver().query(VaultImageProvider.a, arrayOfString, str2, null, null);
      localHashSet = new HashSet();
      if (localCursor == null)
        break;
      try
      {
        do
          if (!localCursor.moveToNext())
            break;
        while ((localCursor == null) || (localCursor.getString(0) == null));
        localHashSet.add(localCursor.getString(0));
      }
      finally
      {
        localCursor.close();
      }
      continue;
      localCursor.close();
    }
    Map localMap = this.c.a(paramLong, paramInt1, paramSearchConstraint, paramInt2);
    int i = localMap.size();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
      localMap.remove((String)localIterator.next());
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = Integer.valueOf(i);
    arrayOfObject2[1] = Integer.valueOf(localHashSet.size());
    arrayOfObject2[2] = Integer.valueOf(localMap.size());
    Log.e(StringUtil.a("localImages: %d, vaultTableRows: %d, rowsToAdd: %d", arrayOfObject2));
    return localMap;
  }

  public Set<String> a()
  {
    d();
    return a(20);
  }

  public Set<String> a(int paramInt)
  {
    long l = UserValuesManager.l(this.b);
    if (l == 0L)
      l = System.currentTimeMillis();
    Set localSet = a(a(l, paramInt, VaultLocalImageFetcher.SearchConstraint.BEFORE, 4));
    UserValuesManager.d(this.b, g());
    return localSet;
  }

  public void a(VaultImageProviderRow paramVaultImageProviderRow)
  {
    paramVaultImageProviderRow.h = 1;
    paramVaultImageProviderRow.i = System.currentTimeMillis();
    ContentValues localContentValues = paramVaultImageProviderRow.c();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramVaultImageProviderRow.a;
    this.f.update(VaultImageProvider.a, localContentValues, StringUtil.a("%s = ?", new Object[] { "image_hash" }), arrayOfString);
  }

  public void a(List<VaultImageProviderRow> paramList)
  {
    if (paramList.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder("?");
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = ((VaultImageProviderRow)paramList.get(0)).a;
      ArrayList localArrayList = Lists.a(arrayOfString1);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        VaultImageProviderRow localVaultImageProviderRow = (VaultImageProviderRow)localIterator.next();
        localStringBuilder.append(",?");
        localArrayList.add(localVaultImageProviderRow.a);
      }
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "image_hash";
      arrayOfObject[1] = localStringBuilder.toString();
      String str = StringUtil.a("%s IN (%s)", arrayOfObject);
      String[] arrayOfString2 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
      this.f.delete(VaultImageProvider.a, str, arrayOfString2);
    }
  }

  public int b(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("queue_state", Integer.valueOf(0));
    return this.f.update(Uri.parse(VaultImageProvider.a + "/" + Uri.encode(paramString)), localContentValues, null, null);
  }

  public Map<String, Long> b(long paramLong)
  {
    String str = StringLocaleUtil.a("%s >= ?", new Object[] { "date_taken" });
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.toString(paramLong));
    return a(str, localArrayList);
  }

  public Map<String, Long> b(Set<String> paramSet)
  {
    ArrayList localArrayList = new ArrayList();
    String str = null;
    if (paramSet != null)
      str = a(paramSet, localArrayList).toString();
    return a(str, localArrayList);
  }

  public Set<String> b()
  {
    Object localObject;
    if (UserValuesManager.g(this.b) == 0L)
    {
      ErrorReporting.a("vault_table_refresh missing device_oid", "", true);
      localObject = new HashSet();
    }
    while (true)
    {
      return localObject;
      long l = UserValuesManager.l(this.b);
      localObject = Collections.emptySet();
      if (l != 0L)
      {
        Map localMap = a(g(), 1000, VaultLocalImageFetcher.SearchConstraint.AFTER, 4);
        String str = a;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(localMap.size());
        Log.d(str, StringUtil.a("Fetched %d new images from MediaStore", arrayOfObject));
        localObject = a(localMap);
        UserValuesManager.d(this.b, g());
      }
      if (!Log.a(a, 2))
        continue;
      h();
    }
  }

  public boolean c()
  {
    int i = 1;
    long l = UserValuesManager.l(this.b);
    int j;
    if (l == 0L)
    {
      if (this.c.a() > 0);
      for (j = i; ; j = 0)
        return j;
    }
    if (a(l, 6, VaultLocalImageFetcher.SearchConstraint.BEFORE, 4).size() > 0);
    while (true)
    {
      j = i;
      break;
      i = 0;
    }
  }

  public void d()
  {
    int i = this.f.delete(VaultImageProvider.a, "", null);
    String str = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(i);
    Log.d(str, StringUtil.a("clearing vault table, removed %d rows.", arrayOfObject));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultTable
 * JD-Core Version:    0.6.0
 */