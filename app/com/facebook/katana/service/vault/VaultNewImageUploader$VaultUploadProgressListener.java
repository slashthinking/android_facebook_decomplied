package com.facebook.katana.service.vault;

import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.orca.protocol.base.CountingOutputStreamWithProgress.ProgressListener;

class VaultNewImageUploader$VaultUploadProgressListener
  implements CountingOutputStreamWithProgress.ProgressListener
{
  private int b = 0;
  private long c;
  private VaultImageProviderRow d;
  private VaultNotificationManager e;

  private VaultNewImageUploader$VaultUploadProgressListener(VaultNewImageUploader paramVaultNewImageUploader, long paramLong, VaultImageProviderRow paramVaultImageProviderRow, VaultNotificationManager paramVaultNotificationManager)
  {
    this.c = paramLong;
    this.d = paramVaultImageProviderRow;
    this.e = paramVaultNotificationManager;
  }

  public void a(long paramLong)
  {
    int i = (int)Math.floor(90.0D * paramLong / this.c);
    if (i != this.b)
    {
      this.b = i;
      if (this.b % 10 == 0)
        this.e.a(this.d, i);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultNewImageUploader.VaultUploadProgressListener
 * JD-Core Version:    0.6.0
 */