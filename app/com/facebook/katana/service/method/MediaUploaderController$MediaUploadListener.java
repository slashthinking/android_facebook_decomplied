package com.facebook.katana.service.method;

import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.MediaItem;
import java.util.List;

public abstract interface MediaUploaderController$MediaUploadListener
{
  public abstract void a(String paramString1, int paramInt1, String paramString2, FacebookPhoto paramFacebookPhoto, String paramString3, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean);

  public abstract void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, long paramLong1, long paramLong2);

  public abstract void a(List<MediaUploaderController.MediaUnpublishedPhoto> paramList, List<MediaItem> paramList1);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaUploaderController.MediaUploadListener
 * JD-Core Version:    0.6.0
 */