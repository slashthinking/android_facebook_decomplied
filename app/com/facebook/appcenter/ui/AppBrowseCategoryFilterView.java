package com.facebook.appcenter.ui;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticCounters;
import com.facebook.appcenter.app.AppCenterDataManager;
import com.facebook.appcenter.data.AppCenterCategoryCollection;
import com.facebook.appcenter.graphql.model.AppCenterCategory;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Preconditions;

public class AppBrowseCategoryFilterView extends CustomRelativeLayout
{
  private final Context a;
  private final RelativeLayout b;
  private final TextView c;
  private AppCenterCategoryCollection d;
  private final AlertDialog.Builder e;
  private final AppCenterDataManager f;

  public AppBrowseCategoryFilterView(Context paramContext)
  {
    this(paramContext, null);
  }

  public AppBrowseCategoryFilterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AppBrowseCategoryFilterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    setContentView(2130903205);
    this.b = ((RelativeLayout)b(2131296881));
    Preconditions.checkNotNull(this.b);
    this.c = ((TextView)b(2131296882));
    Preconditions.checkNotNull(this.c);
    FbInjector localFbInjector = getInjector();
    Preconditions.checkNotNull(localFbInjector);
    this.f = ((AppCenterDataManager)localFbInjector.a(AppCenterDataManager.class));
    this.e = new AlertDialog.Builder(paramContext);
    this.e.setTitle(this.a.getResources().getString(2131362043));
    this.b.setOnClickListener(new AppBrowseCategoryFilterView.1(this));
  }

  private void a(String paramString)
  {
    String str = "app_center_abp_filter_" + paramString;
    AnalyticCounters localAnalyticCounters = (AnalyticCounters)getInjector().a(AnalyticCounters.class);
    Preconditions.checkNotNull(localAnalyticCounters);
    if (localAnalyticCounters != null)
      localAnalyticCounters.a(str, 1L);
  }

  public void a(AppCenterCategoryCollection paramAppCenterCategoryCollection)
  {
    this.d = paramAppCenterCategoryCollection;
    int i = this.f.b();
    this.c.setText(this.d.a(i).label);
    this.e.setItems(this.d.b(), new AppBrowseCategoryFilterView.2(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppBrowseCategoryFilterView
 * JD-Core Version:    0.6.0
 */