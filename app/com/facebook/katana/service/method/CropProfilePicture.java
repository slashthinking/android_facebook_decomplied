package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.photos.util.PhotoUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CropProfilePicture extends ApiMethod
  implements ApiMethodCallback
{
  public static final Class<?> a = CropProfilePicture.class;

  public CropProfilePicture(Context paramContext, Intent paramIntent, String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "POST", "photos.cropProfilePic", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("session_key", paramString1);
    this.e.put("call_id", Long.toString(System.currentTimeMillis()));
    this.e.put("owner_id", Long.toString(paramLong));
    this.e.put("photo_id", PhotoUtils.a(paramString2));
    this.e.put("x", Integer.toString(paramInt1));
    this.e.put("y", Integer.toString(paramInt2));
    this.e.put("width", Integer.toString(paramInt3));
    this.e.put("height", Integer.toString(paramInt4));
  }

  public static String a(Context paramContext, long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    CropProfilePicture localCropProfilePicture;
    for (String str = null; ; str = AppSession.a(paramContext, false).a(paramContext, localCropProfilePicture, 1001, 1001, null))
    {
      return str;
      localCropProfilePicture = new CropProfilePicture(paramContext, null, localAppSession.b().sessionKey, paramString, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, null);
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).f(paramAppSession, paramString1, paramInt, paramString2, paramException);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.CropProfilePicture
 * JD-Core Version:    0.6.0
 */