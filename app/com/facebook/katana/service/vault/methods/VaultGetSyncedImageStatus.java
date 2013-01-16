package com.facebook.katana.service.vault.methods;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class VaultGetSyncedImageStatus
  implements JMStaticKeysDictDestination
{

  @JMAutogen.InferredType(jsonFieldName="deleted")
  public final boolean mDeleted = false;

  @JMAutogen.InferredType(jsonFieldName="id")
  public final long mFbid = 0L;

  @JMAutogen.InferredType(jsonFieldName="height")
  public final int mHeight = 0;

  @JMAutogen.InferredType(jsonFieldName="width")
  public final int mWidth = 0;

  public boolean equals(Object paramObject)
  {
    VaultGetSyncedImageStatus localVaultGetSyncedImageStatus = (VaultGetSyncedImageStatus)paramObject;
    if ((localVaultGetSyncedImageStatus.mFbid == this.mFbid) && (localVaultGetSyncedImageStatus.mDeleted == this.mDeleted) && (localVaultGetSyncedImageStatus.mWidth == this.mWidth) && (localVaultGetSyncedImageStatus.mHeight == this.mHeight));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatus
 * JD-Core Version:    0.6.0
 */