package com.facebook.katana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.katana.activity.BaseFacebookActivity;

public class AppCenterMobileCanvasActivity extends BaseFacebookActivity
{
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903059);
    AppCenterMobileCanvasActivity.MobileCanvasFragment localMobileCanvasFragment = new AppCenterMobileCanvasActivity.MobileCanvasFragment(null);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("mobile_page");
    boolean bool = localIntent.getBooleanExtra("faceweb_modal", false);
    Bundle localBundle = new Bundle();
    localBundle.putString("mobile_page", str);
    localBundle.putBoolean("faceweb_modal", bool);
    localMobileCanvasFragment.f(localBundle);
    g().a().b(2131296394, localMobileCanvasFragment, "chromed:content:fragment:tag").a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.AppCenterMobileCanvasActivity
 * JD-Core Version:    0.6.0
 */