package com.facebook.appcenter.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.facebook.appcenter.activity.AppCenterBrowseActivity;
import com.facebook.appcenter.app.AppCenterDataManager;
import com.facebook.appcenter.cache.AppCategoryCache;
import com.facebook.appcenter.data.AppCenterCategoryCollection;
import com.facebook.appcenter.graphql.model.AppCenterCategory;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;

class AppBrowseCategoryFilterView$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != AppBrowseCategoryFilterView.b(this.a).b())
    {
      Intent localIntent = new Intent(AppBrowseCategoryFilterView.c(this.a), AppCenterBrowseActivity.class);
      String str1 = AppBrowseCategoryFilterView.d(this.a).a(paramInt).name;
      AppBrowseCategoryFilterView.a(this.a, str1);
      AppCategoryCache localAppCategoryCache = (AppCategoryCache)AppBrowseCategoryFilterView.e(this.a).a(AppCategoryCache.class);
      Preconditions.checkNotNull(localAppCategoryCache);
      String str2 = localAppCategoryCache.a(AppBrowseCategoryFilterView.d(this.a).a(paramInt).label);
      localIntent.putExtra("category_index", paramInt);
      localIntent.putExtra(AppBrowseFragment.a, str2);
      AppBrowseCategoryFilterView.c(this.a).startActivity(localIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppBrowseCategoryFilterView.2
 * JD-Core Version:    0.6.0
 */