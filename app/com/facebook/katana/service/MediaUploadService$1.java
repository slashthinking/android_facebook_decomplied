package com.facebook.katana.service;

import android.content.Context;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.FacebookVideoUploadResponse;
import com.facebook.orca.common.util.StringLocaleUtil;

class MediaUploadService$1 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, int paramInt2, FacebookPhoto paramFacebookPhoto, String paramString3, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramInt1 == 200)
    {
      MediaUploadService.a(MediaUploadService.a(this.a), paramInt2, paramFacebookPhoto.a());
      return;
    }
    Context localContext = MediaUploadService.a(this.a);
    if (paramException != null);
    for (Class localClass = paramException.getClass(); ; localClass = null)
    {
      MediaUploadService.a(localContext, paramInt2, localClass);
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      arrayOfObject[2] = Integer.valueOf(paramInt1);
      arrayOfObject[3] = paramString2;
      ErrorReporting.a("api photo upload failure", StringLocaleUtil.a("Failed photo upload (reqID=%s, uploadId=%d, errorCode=%d, reason=%s)", arrayOfObject), paramException);
      break;
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, FacebookVideoUploadResponse paramFacebookVideoUploadResponse, String paramString3, int paramInt2)
  {
    if (paramInt1 == 200)
    {
      MediaUploadService.a(MediaUploadService.a(this.a), paramInt2, paramFacebookVideoUploadResponse.vid);
      return;
    }
    Context localContext = MediaUploadService.a(this.a);
    if (paramException != null);
    for (Class localClass = paramException.getClass(); ; localClass = null)
    {
      MediaUploadService.a(localContext, paramInt2, localClass);
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      arrayOfObject[2] = Integer.valueOf(paramInt1);
      arrayOfObject[3] = paramString2;
      arrayOfObject[4] = paramException;
      ErrorReporting.a("api video upload failure", StringLocaleUtil.a("Failed video upload (reqID=%s, uploadId=%d, errorCode=%d, reason=%s, exception=%s)", arrayOfObject));
      break;
    }
  }

  public void b(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, int paramInt2)
  {
    if (paramInt1 == 200)
      MediaUploadService.a(MediaUploadService.a(this.a), paramInt2, null);
    while (true)
    {
      return;
      Context localContext = MediaUploadService.a(this.a);
      Class localClass = null;
      if (paramException != null)
        localClass = paramException.getClass();
      MediaUploadService.a(localContext, paramInt2, localClass);
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      arrayOfObject[2] = Integer.valueOf(paramInt1);
      arrayOfObject[3] = paramString2;
      ErrorReporting.a("api places picture suggestion upload failure", StringLocaleUtil.a("Failed photo upload (reqID=%s, uploadId=%d, errorCode=%d, reason=%s)", arrayOfObject), paramException);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.MediaUploadService.1
 * JD-Core Version:    0.6.0
 */