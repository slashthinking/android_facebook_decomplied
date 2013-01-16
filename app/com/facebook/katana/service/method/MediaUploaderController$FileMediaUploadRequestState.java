package com.facebook.katana.service.method;

import com.facebook.katana.model.MediaItem;

class MediaUploaderController$FileMediaUploadRequestState extends MediaUploaderController.BaseMediaUploadRequestState
{
  private String i;
  private int j;

  public MediaUploaderController$FileMediaUploadRequestState(MediaUploaderController.VaultMediaUploadRequestState paramVaultMediaUploadRequestState)
  {
    super(paramVaultMediaUploadRequestState.e());
    this.i = paramVaultMediaUploadRequestState.e().b();
    this.j = MediaUploaderController.a();
    this.d = paramVaultMediaUploadRequestState.d();
  }

  public MediaUploaderController$FileMediaUploadRequestState(String paramString, int paramInt, MediaItem paramMediaItem, MediaUploaderController.MediaUploadRequest paramMediaUploadRequest)
  {
    super(paramMediaItem);
    this.i = paramString;
    this.j = paramInt;
    this.d = paramMediaUploadRequest;
  }

  public String g()
  {
    return this.i;
  }

  public int h()
  {
    return this.j;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaUploaderController.FileMediaUploadRequestState
 * JD-Core Version:    0.6.0
 */