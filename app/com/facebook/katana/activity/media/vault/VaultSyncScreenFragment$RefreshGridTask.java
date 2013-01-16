package com.facebook.katana.activity.media.vault;

import android.os.AsyncTask;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.katana.service.vault.VaultLocalImageFetcher;
import com.facebook.katana.service.vault.VaultTable;
import com.facebook.photos.photogallery.photos.VaultLocalPhoto;
import com.facebook.photos.photogallery.photos.VaultPhoto;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

class VaultSyncScreenFragment$RefreshGridTask extends AsyncTask<Void, Void, List<VaultPhoto>>
{
  private final boolean b;

  public VaultSyncScreenFragment$RefreshGridTask(VaultSyncScreenFragment paramVaultSyncScreenFragment)
  {
    this.b = false;
  }

  public VaultSyncScreenFragment$RefreshGridTask(VaultSyncScreenFragment paramVaultSyncScreenFragment, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public int a()
  {
    TimeZone localTimeZone1 = TimeZone.getDefault();
    TimeZone localTimeZone2 = TimeZone.getTimeZone("GMT");
    Date localDate = new Date();
    if (localTimeZone1.inDaylightTime(localDate));
    for (int i = localTimeZone1.getDSTSavings(); ; i = 0)
    {
      boolean bool = localTimeZone2.inDaylightTime(localDate);
      int j = 0;
      if (bool)
        j = localTimeZone2.getDSTSavings();
      return j + localTimeZone2.getRawOffset() - localTimeZone1.getRawOffset() - i;
    }
  }

  protected List<VaultPhoto> a(Void[] paramArrayOfVoid)
  {
    ArrayList localArrayList1 = Lists.a();
    long l = UserValuesManager.l(VaultSyncScreenFragment.h(this.a));
    List localList = VaultSyncScreenFragment.g(this.a).a(l, 50, this.b);
    Map localMap = VaultSyncScreenFragment.i(this.a).a(l);
    ArrayList localArrayList2 = Lists.a();
    VaultSyncScreenFragment.a(this.a, new HashSet());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      VaultImageProviderRow localVaultImageProviderRow = (VaultImageProviderRow)localIterator.next();
      MediaItem localMediaItem = (MediaItem)localMap.get(localVaultImageProviderRow.a);
      if ((localMediaItem != null) && (new File(localMediaItem.b()).exists()))
      {
        if (localVaultImageProviderRow.f != 4)
          continue;
        localArrayList1.add(new VaultLocalPhoto(0L, localMediaItem.b(), 0, localMediaItem.d() + a(), localVaultImageProviderRow.a));
        VaultSyncScreenFragment.j(this.a).add(localVaultImageProviderRow.a);
        continue;
      }
      localArrayList2.add(localVaultImageProviderRow);
    }
    if (localArrayList2.size() > 0)
      VaultSyncScreenFragment.g(this.a).a(localArrayList2);
    return localArrayList1;
  }

  protected void a(List<VaultPhoto> paramList)
  {
    VaultSyncScreenFragment.f(this.a).a(paramList);
    VaultSyncScreenFragment.a(this.a).d();
    VaultSyncScreenFragment.a(this.a).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenFragment.RefreshGridTask
 * JD-Core Version:    0.6.0
 */