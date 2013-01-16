package com.karmascience.gifts.views;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.widget.UrlImage;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.Sku;
import com.karmascience.gifts.content.model.iTunesContent;
import com.karmascience.gifts.content.model.iTunesContentResults;
import com.karmascience.gifts.controllers.ProductsManager;
import com.karmascience.gifts.ui.IViewManager;
import com.karmascience.gifts.widget.QuadOptionSelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class iTunesSkuSelectionView extends KSViewController
{
  private static final Map<String, Integer> a = new iTunesSkuSelectionView.1();
  private static final Map<String, Integer> b = new iTunesSkuSelectionView.2();
  private Product c = null;
  private LinearLayout d;
  private QuadOptionSelector e;
  private final View.OnClickListener f = new iTunesSkuSelectionView.3(this);

  public iTunesSkuSelectionView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
    this.c = ((Product)paramBundle.getParcelable("product_parcelable"));
  }

  private void E()
  {
    this.d.removeAllViews();
    LayoutInflater localLayoutInflater = (LayoutInflater)g().getSystemService("layout_inflater");
    String str1 = g().getResources().getString(2131362298);
    String str2 = g().getResources().getString(2131362301);
    String str3 = g().getResources().getString(2131362299);
    String str4 = g().getResources().getString(2131362300);
    String str5 = g().getResources().getString(2131362302);
    String str6 = g().getResources().getString(2131362304);
    String str7 = g().getResources().getString(2131362303);
    String str8 = g().getResources().getString(2131362305);
    View localView1 = a(localLayoutInflater, this.d, str1, "album", false);
    this.d.addView(localView1);
    View localView2 = localLayoutInflater.inflate(2130903258, this.d, false);
    this.d.addView(localView2);
    View localView3 = a(localLayoutInflater, this.d, str7, "song", false);
    this.d.addView(localView3);
    View localView4 = localLayoutInflater.inflate(2130903258, this.d, false);
    this.d.addView(localView4);
    View localView5 = a(localLayoutInflater, this.d, str3, "movie", false);
    this.d.addView(localView5);
    View localView6 = localLayoutInflater.inflate(2130903258, this.d, false);
    this.d.addView(localView6);
    View localView7 = a(localLayoutInflater, this.d, str4, "tv_season", false);
    this.d.addView(localView7);
    View localView8 = localLayoutInflater.inflate(2130903258, this.d, false);
    this.d.addView(localView8);
    View localView9 = a(localLayoutInflater, this.d, str2, "ios_app", false);
    this.d.addView(localView9);
    View localView10 = localLayoutInflater.inflate(2130903258, this.d, false);
    this.d.addView(localView10);
    View localView11 = a(localLayoutInflater, this.d, str5, "ebook", false);
    this.d.addView(localView11);
    View localView12 = localLayoutInflater.inflate(2130903258, this.d, false);
    this.d.addView(localView12);
    View localView13 = a(localLayoutInflater, this.d, str6, "mac_app", false);
    this.d.addView(localView13);
    View localView14 = localLayoutInflater.inflate(2130903258, this.d, false);
    this.d.addView(localView14);
    View localView15 = a(localLayoutInflater, this.d, str8, "_SKIP_", true);
    this.d.addView(localView15);
  }

  private View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, String paramString1, String paramString2, boolean paramBoolean)
  {
    View localView = paramLayoutInflater.inflate(2130903259, paramViewGroup, false);
    localView.setTag(paramString2);
    localView.setOnClickListener(this.f);
    ((TextView)localView.findViewById(2131297036)).setText(paramString1);
    UrlImage localUrlImage = (UrlImage)localView.findViewById(2131297035);
    if (paramBoolean)
      localUrlImage.setVisibility(8);
    return localView;
  }

  private static void a(LinearLayout paramLinearLayout, int paramInt, List<iTunesContent> paramList)
  {
    if ((paramList != null) && (paramInt >= 0) && (paramInt < paramLinearLayout.getChildCount()))
    {
      iTunesContent localiTunesContent = (iTunesContent)paramList.get(0);
      ((UrlImage)paramLinearLayout.getChildAt(paramInt).findViewById(2131297035)).setImageParams(Uri.parse(localiTunesContent.d()));
    }
  }

  private void a(iTunesContentResults paramiTunesContentResults)
  {
    a(this.d, 0, paramiTunesContentResults.a());
    a(this.d, 2, paramiTunesContentResults.f());
    a(this.d, 4, paramiTunesContentResults.b());
    a(this.d, 6, paramiTunesContentResults.c());
    a(this.d, 8, paramiTunesContentResults.d());
    a(this.d, 10, paramiTunesContentResults.g());
    a(this.d, 12, paramiTunesContentResults.e());
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(2130903257, paramViewGroup, false);
    View localView2 = localView1.findViewById(2131297030);
    TextView localTextView1 = (TextView)localView2.findViewById(2131297576);
    TextView localTextView2 = (TextView)localView2.findViewById(2131297726);
    localTextView1.setText(this.c.c());
    localTextView2.setText(this.c.d());
    this.d = ((LinearLayout)localView1.findViewById(2131297034));
    this.e = ((QuadOptionSelector)localView1.findViewById(2131297032));
    this.e.setOnOptionSelectedListener(new iTunesSkuSelectionView.4(this));
    List localList = this.c.a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localList.iterator();
    while (localIterator1.hasNext())
    {
      Sku localSku = (Sku)localIterator1.next();
      localArrayList.add(new iTunesSkuSelectionView.SkuPricePair(this, localSku.d(), localSku.c(), null));
    }
    Collections.sort(localArrayList);
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      iTunesSkuSelectionView.SkuPricePair localSkuPricePair = (iTunesSkuSelectionView.SkuPricePair)localIterator2.next();
      this.e.a(CommonViewUtils.b(localSkuPricePair.a), localSkuPricePair.b);
    }
    E();
    return localView1;
  }

  public void a(View paramView, Bundle paramBundle)
  {
    String[] arrayOfString = { "album", "ios_app", "movie", "tv_season", "ebook", "mac_app", "song" };
    r().a(arrayOfString, 1, new iTunesSkuSelectionView.5(this));
  }

  public String b()
  {
    return g().getString(2131362228);
  }

  public void c()
  {
    Bundle localBundle = CommonViewUtils.a(12);
    String str = (String)this.e.getCurrentSelection();
    Sku localSku = this.c.a(str);
    localBundle.putParcelable("product_parcelable", this.c);
    localBundle.putParcelable("sku_parcelable", localSku);
    b(localBundle);
    n().c("Skipped iTunes Recommendation").a("page_identifier", d()).a();
  }

  public String d()
  {
    return "iTunes SKU Selection";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.iTunesSkuSelectionView
 * JD-Core Version:    0.6.0
 */