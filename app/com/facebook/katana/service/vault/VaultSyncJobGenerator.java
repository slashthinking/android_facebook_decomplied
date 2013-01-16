package com.facebook.katana.service.vault;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.util.Log;
import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VaultSyncJobGenerator
{
  private static final Class<?> a = VaultSyncJobGenerator.class;
  private final Context b;
  private final VaultTable c;

  public VaultSyncJobGenerator(Context paramContext, VaultTable paramVaultTable)
  {
    this.b = paramContext;
    this.c = paramVaultTable;
  }

  private int a(int paramInt, boolean paramBoolean)
  {
    boolean bool = VaultHelpers.d(this.b);
    List localList = this.c.a(paramInt, bool, paramBoolean);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(localList.size());
    Log.e(StringUtil.a("vault table returned %d retry rows", arrayOfObject));
    a(localList, 3, 2);
    return localList.size();
  }

  private void a(List<VaultImageProviderRow> paramList, int paramInt1, int paramInt2)
  {
    if (paramList.size() > 0)
    {
      Intent localIntent = new Intent(this.b, VaultSyncJobProcessor.class);
      ArrayList localArrayList = Lists.a();
      ((VaultNotificationManager)FbInjector.a(this.b).a(VaultNotificationManager.class)).a(paramList);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        VaultImageProviderRow localVaultImageProviderRow = (VaultImageProviderRow)localIterator.next();
        this.c.a(localVaultImageProviderRow);
        localArrayList.add(localVaultImageProviderRow);
        if (paramInt2 == 2)
        {
          Class localClass2 = a;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = localVaultImageProviderRow.a;
          Log.d(localClass2, StringUtil.a("Appending sync job for hash: %s", arrayOfObject2));
          continue;
        }
        Class localClass1 = a;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localVaultImageProviderRow.a;
        Log.d(localClass1, StringUtil.a("Prepending sync job for hash: %s", arrayOfObject1));
      }
      localIntent.putExtra("queuing_type", paramInt2);
      localIntent.putParcelableArrayListExtra("queuing_objects", localArrayList);
      localIntent.putExtra("sync_reason", paramInt1);
      this.b.startService(localIntent);
    }
  }

  public int a(int paramInt)
  {
    return a(paramInt, false);
  }

  public int a(int paramInt1, int paramInt2)
  {
    boolean bool = VaultHelpers.d(this.b);
    VaultTable.SyncableRows localSyncableRows = this.c.a(paramInt1, bool);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(localSyncableRows.a.size());
    arrayOfObject[1] = Integer.valueOf(localSyncableRows.b.size());
    Log.e(StringUtil.a("vault table returned %d new rows and %d old rows", arrayOfObject));
    a(localSyncableRows.a, paramInt2, 1);
    a(localSyncableRows.b, paramInt2, 2);
    return localSyncableRows.a.size() + localSyncableRows.b.size();
  }

  public int a(Set<String> paramSet, int paramInt)
  {
    VaultHelpers.d(this.b);
    List localList = this.c.a(paramSet);
    a(localList, paramInt, 1);
    return localList.size();
  }

  public int b(int paramInt)
  {
    return a(paramInt, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultSyncJobGenerator
 * JD-Core Version:    0.6.0
 */