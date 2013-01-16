package com.facebook.katana;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.GitHashUtil;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.orca.annotations.AuthNotRequired;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@AuthNotRequired
public class HtmlAboutActivity extends BaseFacebookActivity
{
  public void a(Bundle paramBundle)
  {
    requestWindowFeature(3);
    super.a(paramBundle);
    setContentView(2130903243);
    setFeatureDrawableResource(3, 2130838331);
    WebView localWebView = (WebView)findViewById(2131297007);
    localWebView.setWebViewClient(new HtmlAboutActivity.1(this));
    try
    {
      PackageInfo localPackageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
      String str1 = c(2131099648);
      String str3;
      if ((BuildConstants.a()) || (FacebookAffiliation.b()))
      {
        str2 = localPackageInfo.versionName + "/" + String.valueOf(localPackageInfo.versionCode);
        str3 = GitHashUtil.a(this);
        if (str3.length() <= 0);
      }
      for (String str2 = str2 + " (" + str3 + ")"; ; str2 = localPackageInfo.versionName)
      {
        localWebView.loadDataWithBaseURL(null, str1.replaceFirst("[0-9]+.[0-9]+.[0-9]+", str2), "text/html", "utf-8", null);
        findViewById(2131297008).setOnClickListener(new HtmlAboutActivity.2(this));
        findViewById(2131297009).setOnClickListener(new HtmlAboutActivity.3(this));
        return;
      }
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    throw new RuntimeException(localNameNotFoundException);
  }

  public String c(int paramInt)
  {
    InputStream localInputStream = getResources().openRawResource(paramInt);
    String str = CharStreams.a(new InputStreamReader(localInputStream, Charsets.UTF_8));
    localInputStream.close();
    return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.HtmlAboutActivity
 * JD-Core Version:    0.6.0
 */