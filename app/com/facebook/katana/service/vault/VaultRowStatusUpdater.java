package com.facebook.katana.service.vault;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.katana.features.vault.VaultConstants;
import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatus;
import com.facebook.katana.util.ImageUtil;
import com.facebook.katana.util.ImageUtils.Dimension;
import com.facebook.orca.common.util.StringUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VaultRowStatusUpdater
{
  private static final String a = VaultRowStatusUpdater.class.getSimpleName();
  private final VaultLocalImageFetcher b;
  private final ImageUtil c;
  private final FbErrorReporter d;

  public VaultRowStatusUpdater(VaultLocalImageFetcher paramVaultLocalImageFetcher, ImageUtil paramImageUtil, FbErrorReporter paramFbErrorReporter)
  {
    this.b = paramVaultLocalImageFetcher;
    this.c = paramImageUtil;
    this.d = ((FbErrorReporter)Preconditions.checkNotNull(paramFbErrorReporter));
  }

  public List<VaultImageProviderRow> a(List<VaultImageProviderRow> paramList, Map<String, VaultGetSyncedImageStatus> paramMap)
  {
    ArrayList localArrayList = Lists.a();
    for (int i = 0; i < paramList.size(); i++)
    {
      VaultImageProviderRow localVaultImageProviderRow = (VaultImageProviderRow)paramList.get(i);
      VaultGetSyncedImageStatus localVaultGetSyncedImageStatus = (VaultGetSyncedImageStatus)paramMap.get(localVaultImageProviderRow.a);
      if ((localVaultGetSyncedImageStatus == null) || (!localVaultGetSyncedImageStatus.mDeleted))
        continue;
      paramList.remove(i);
      localArrayList.add(localVaultImageProviderRow);
    }
    return localArrayList;
  }

  public Map<String, VaultImageProviderRow> a(Map<String, VaultImageProviderRow> paramMap, Map<String, VaultGetSyncedImageStatus> paramMap1)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      VaultImageProviderRow localVaultImageProviderRow = (VaultImageProviderRow)localEntry.getValue();
      VaultGetSyncedImageStatus localVaultGetSyncedImageStatus = (VaultGetSyncedImageStatus)paramMap1.get(str1);
      if (localVaultGetSyncedImageStatus != null)
      {
        if (!localVaultGetSyncedImageStatus.mDeleted)
          break label134;
        localVaultImageProviderRow.f = 7;
      }
      while (true)
      {
        localVaultImageProviderRow.b = localVaultGetSyncedImageStatus.mFbid;
        String str2 = a;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localVaultImageProviderRow.toString();
        Log.d(str2, StringUtil.a("restoring/updating vault table row: %s", arrayOfObject));
        break;
        label134: if ((localVaultGetSyncedImageStatus.mHeight >= VaultConstants.b) || (localVaultGetSyncedImageStatus.mWidth >= VaultConstants.b))
        {
          localVaultImageProviderRow.f = 1;
          continue;
        }
        if ((localVaultGetSyncedImageStatus.mHeight > 0) && (localVaultGetSyncedImageStatus.mWidth > 0))
        {
          String str3 = this.b.a(str1);
          if (str3 == null)
            continue;
          ImageUtils.Dimension localDimension = this.c.a(str3);
          if ((localVaultGetSyncedImageStatus.mHeight == localDimension.a) && (localVaultGetSyncedImageStatus.mWidth == localDimension.b))
          {
            localVaultImageProviderRow.f = 1;
            continue;
          }
          localVaultImageProviderRow.f = 0;
          continue;
        }
        Log.e(a, "Image found on server but has 0 width or 0 height");
        this.d.a("Unexpected server image state", "Image found on server but has 0px width or 0px height");
        localVaultImageProviderRow.f = 4;
      }
    }
    return paramMap;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultRowStatusUpdater
 * JD-Core Version:    0.6.0
 */