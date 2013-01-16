package com.facebook.appcenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.analytics.AnalyticsSubModuleActivity;
import com.facebook.appcenter.app.AppCenterDataManager;
import com.facebook.appcenter.data.AppCenterCategoryCollection;
import com.facebook.appcenter.ui.AppBrowseFragment;
import com.facebook.appcenter.util.logging.AppCenterAnalyticEntities;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;

public class AppCenterBrowseActivity extends FbFragmentActivity
  implements AnalyticsSubModuleActivity
{
  private AppCenterDataManager n;
  private int o;

  public String a()
  {
    return AppCenterAnalyticEntities.a;
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903211);
    this.n = ((AppCenterDataManager)C().a(AppCenterDataManager.class));
    Preconditions.checkNotNull(this.n);
    Intent localIntent = getIntent();
    Preconditions.checkNotNull(localIntent);
    AppCenterCategoryCollection localAppCenterCategoryCollection = (AppCenterCategoryCollection)C().a(AppCenterCategoryCollection.class);
    Preconditions.checkNotNull(localAppCenterCategoryCollection);
    int i = localIntent.getIntExtra("category_index", 0);
    Preconditions.checkPositionIndex(i, localAppCenterCategoryCollection.a());
    this.o = this.n.b();
    Preconditions.checkPositionIndex(this.o, localAppCenterCategoryCollection.a());
    this.n.a(i);
    String str = localIntent.getStringExtra(AppBrowseFragment.a);
    g().a().b(2131296394, AppBrowseFragment.a(str, i), "chromed:content:fragment:tag").a();
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    this.n.a(this.o);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.activity.AppCenterBrowseActivity
 * JD-Core Version:    0.6.0
 */