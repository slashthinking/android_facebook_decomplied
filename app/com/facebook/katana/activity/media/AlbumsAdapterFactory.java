package com.facebook.katana.activity.media;

import android.content.Context;
import android.net.Uri;
import com.facebook.katana.binding.AppSession;

public class AlbumsAdapterFactory
{
  public AlbumsAdapter a(Context paramContext, Uri paramUri, String paramString1, String paramString2, AppSession paramAppSession)
  {
    return new AlbumsAdapter(paramContext, paramUri, paramString1, paramString2, paramAppSession);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.AlbumsAdapterFactory
 * JD-Core Version:    0.6.0
 */