package com.facebook.katana.activity.media;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.util.StringUtils;
import java.util.List;

public class ViewVideoActivity extends BaseFacebookActivity
{
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    String str = getIntent().getStringExtra("href");
    if (str != null)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      Uri localUri = Uri.parse(str);
      if (StringUtils.a(localUri.getScheme(), "https"))
        localUri = localUri.buildUpon().scheme("http").build();
      localIntent.setDataAndType(localUri, "video/*");
      if (getPackageManager().queryIntentActivities(localIntent, 0).size() > 0)
        startActivity(localIntent);
    }
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.ViewVideoActivity
 * JD-Core Version:    0.6.0
 */