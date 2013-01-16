package com.karmascience.gifts.views;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.content.model.ProductCategories;
import com.karmascience.gifts.controllers.ProductsManager;
import com.karmascience.gifts.ui.IViewManager;

public class ProductsFilterView extends KSViewController
{
  private final ProductCategories a = r().a();
  private final String b = s().getString("selected_category_id");

  public ProductsFilterView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
  }

  private void a(String paramString)
  {
    AnalyticsWrapper.MetricsEvent localMetricsEvent = n().c("Clicked Category Filter");
    if (paramString != null);
    for (String str = paramString; ; str = "_ALL_")
    {
      localMetricsEvent.a("category_id", str).a();
      Bundle localBundle = CommonViewUtils.c(null);
      localBundle.putBoolean("apply_bundle", true);
      localBundle.putString("selected_category_id", paramString);
      b(localBundle);
      return;
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ListView localListView = (ListView)View.inflate(g(), 2130903515, null);
    View localView = LayoutInflater.from(g()).inflate(2130903516, localListView, false);
    ((TextView)localView.findViewById(2131297547)).setText(g().getString(2131362248));
    localListView.addHeaderView(localView, null, true);
    ProductsFilterView.FilterAdatper localFilterAdatper = new ProductsFilterView.FilterAdatper(this, this.a.a("descriptive"), this.b);
    localListView.setAdapter(localFilterAdatper);
    localListView.setOnItemClickListener(localFilterAdatper);
    localView.setOnClickListener(new ProductsFilterView.1(this));
    if (this.b == null)
      localView.findViewById(2131296427).setVisibility(0);
    return localListView;
  }

  public String d()
  {
    return "Product Filter";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductsFilterView
 * JD-Core Version:    0.6.0
 */