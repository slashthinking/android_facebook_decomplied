package com.facebook.katana.service.method;

import com.facebook.katana.model.MediaItem;

class MediaUploaderController$VaultMediaUploadRequestState extends MediaUploaderController.BaseMediaUploadRequestState
{
  private long i;

  public MediaUploaderController$VaultMediaUploadRequestState(long paramLong, MediaItem paramMediaItem, MediaUploaderController.MediaUploadRequest paramMediaUploadRequest)
  {
    super(paramMediaItem);
    this.i = paramLong;
    this.d = paramMediaUploadRequest;
  }

  public long g()
  {
    return this.i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaUploaderController.VaultMediaUploadRequestState
 * JD-Core Version:    0.6.0
 */