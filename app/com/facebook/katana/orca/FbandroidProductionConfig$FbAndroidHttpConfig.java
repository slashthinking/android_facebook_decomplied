package com.facebook.katana.orca;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.net.HttpOperation;
import com.facebook.orca.config.PlatformAppHttpConfig;

class FbandroidProductionConfig$FbAndroidHttpConfig
  implements PlatformAppHttpConfig
{
  FbandroidProductionConfig$FbAndroidHttpConfig(FbandroidProductionConfig paramFbandroidProductionConfig)
  {
  }

  private Uri.Builder a(String paramString)
  {
    if (Constants.URL.a(FbandroidProductionConfig.a(this.a)));
    for (String str = "http://" + paramString + ".%s"; ; str = "https://" + paramString + ".%s")
      return Uri.parse(Constants.URL.a(FbandroidProductionConfig.a(this.a), str)).buildUpon();
  }

  public Uri.Builder a()
  {
    return a("api");
  }

  public Uri.Builder b()
  {
    return a("graph");
  }

  public String c()
  {
    return HttpOperation.c(FbandroidProductionConfig.a(this.a));
  }

  public String d()
  {
    return HttpOperation.b(FbandroidProductionConfig.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidProductionConfig.FbAndroidHttpConfig
 * JD-Core Version:    0.6.0
 */