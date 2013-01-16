package com.facebook.appcenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.analytics.AnalyticsSubModuleActivity;
import com.facebook.appcenter.ui.AppDetailFragment;
import com.facebook.appcenter.util.logging.AppCenterAnalyticEntities;
import com.facebook.orca.activity.FbFragmentActivity;

public class AppCenterDetailActivity extends FbFragmentActivity
  implements AnalyticsSubModuleActivity
{
  public String a()
  {
    return AppCenterAnalyticEntities.b;
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903211);
    String str = getIntent().getStringExtra("id");
    g().a().b(2131296394, AppDetailFragment.a(str), "chromed:content:fragment:tag").a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.activity.AppCenterDetailActivity
 * JD-Core Version:    0.6.0
 */