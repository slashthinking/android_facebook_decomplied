package com.karmascience.gifts.views;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.orca.common.util.StringUtil;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.Sku;
import com.karmascience.gifts.controllers.ProductsManager;
import com.karmascience.gifts.ui.IViewManager;

public class iTunesRecommendationView extends KSViewController
  implements View.OnClickListener
{
  private final String a = s().getString("media_type");
  private Product b = null;
  private Sku c = null;
  private final iTunesRecommendationView.SearchRunner d = new iTunesRecommendationView.SearchRunner(this, null);
  private ListView e;
  private TextView f;
  private EditText g;
  private iTunesRecommendationView.ResultsAdapter h;

  public iTunesRecommendationView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
  }

  private void a(String paramString)
  {
    String str1;
    if (StringUtil.a(paramString))
    {
      this.e.setAdapter(this.h);
      this.e.setOnItemClickListener(this.h);
      int i = s().getInt("header_res_id");
      if (i > 0)
      {
        str1 = g().getResources().getString(i);
        TextView localTextView = this.f;
        String str2 = null;
        if (str1 != null)
          str2 = str1.toUpperCase();
        localTextView.setText(str2);
      }
    }
    while (true)
    {
      return;
      str1 = null;
      break;
      this.e.setAdapter(null);
      this.e.setOnItemClickListener(null);
      this.d.a(paramString);
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(2130903252, paramViewGroup, false);
    this.e = ((ListView)localView1.findViewById(2131297025));
    View localView2 = localView1.findViewById(2131296479);
    this.e.setEmptyView(localView2);
    View localView3 = paramLayoutInflater.inflate(2130903256, this.e, false);
    this.f = ((TextView)localView3.findViewById(2131297029));
    int i = s().getInt("header_res_id");
    String str1;
    TextView localTextView;
    if (i > 0)
    {
      str1 = g().getResources().getString(i);
      localTextView = this.f;
      if (str1 == null)
        break label204;
    }
    label204: for (String str2 = str1.toUpperCase(); ; str2 = null)
    {
      localTextView.setText(str2);
      this.e.addHeaderView(localView3, null, false);
      localView1.findViewById(2131297023).setOnClickListener(this);
      this.g = ((EditText)localView1.findViewById(2131297024));
      int j = s().getInt("search_hint_res_id");
      this.g.setHint(j);
      this.g.addTextChangedListener(new iTunesRecommendationView.1(this));
      return localView1;
      str1 = null;
      break;
    }
  }

  public void a(View paramView, Bundle paramBundle)
  {
    ProductsManager localProductsManager = r();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.a;
    localProductsManager.a(arrayOfString, 50, new iTunesRecommendationView.2(this));
  }

  public String b()
  {
    return g().getString(2131362229);
  }

  public void c()
  {
    Bundle localBundle = CommonViewUtils.a(12);
    localBundle.putParcelable("product_parcelable", this.b);
    localBundle.putParcelable("sku_parcelable", this.c);
    b(localBundle);
    n().c("Skipped iTunes Recommendation").a("page_identifier", d()).a();
  }

  public String d()
  {
    return "iTunes Recommendation";
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131297023)
      this.g.setText("");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.iTunesRecommendationView
 * JD-Core Version:    0.6.0
 */