package com.facebook.pages.identity.ui.about;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.graphql.model.PageViewerVisitsList;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;
import com.facebook.orca.users.User;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;
import com.facebook.pages.identity.data.PageIdentityData;
import com.facebook.pages.identity.fetcher.PageIdentityDataFetcher;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.UrlImage;
import com.google.common.util.concurrent.ListenableFuture;

public class PageIdentityViewerRatingCardView extends CustomFrameLayout
{
  private static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("page_identity/");
  private static final PrefKey b = (PrefKey)a.c("nux/");
  private static final PrefKey c = (PrefKey)b.c("rating_nux_completed");
  private final RatingBar d;
  private final RatingBar e;
  private final UrlImage f;
  private final TextView g;
  private final TextView h;
  private final View i;
  private final View j;
  private final Resources k = (Resources)getInjector().a(Resources.class);
  private final PageIdentityAnalytics l = (PageIdentityAnalytics)getInjector().a(PageIdentityAnalytics.class);
  private final PageIdentityDataFetcher m;
  private final AndroidThreadUtil n;
  private final FbErrorReporter o;
  private final OrcaSharedPreferences p;
  private String q = ((MeUserAuthDataStore)getInjector().a(MeUserAuthDataStore.class)).g().b();
  private String r;
  private boolean s = false;
  private PageIdentityData t;

  public PageIdentityViewerRatingCardView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageIdentityViewerRatingCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PageIdentityViewerRatingCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903467);
    this.m = ((PageIdentityDataFetcher)getInjector().a(PageIdentityDataFetcher.class));
    this.n = ((AndroidThreadUtil)getInjector().a(AndroidThreadUtil.class));
    this.o = ((FbErrorReporter)getInjector().a(FbErrorReporter.class));
    this.p = ((OrcaSharedPreferences)getInjector().a(OrcaSharedPreferences.class));
    this.f = ((UrlImage)findViewById(2131297644));
    this.g = ((TextView)findViewById(2131297646));
    this.h = ((TextView)findViewById(2131297647));
    this.d = ((RatingBar)findViewById(2131297645));
    this.e = ((RatingBar)findViewById(2131297649));
    this.i = findViewById(2131297648);
    this.j = findViewById(2131297651);
    this.j.setOnClickListener(new PageIdentityViewerRatingCardView.1(this));
    findViewById(2131297650).setOnClickListener(new PageIdentityViewerRatingCardView.2(this));
  }

  private void a()
  {
    if (this.p.a(c, false));
    while (true)
    {
      return;
      b();
    }
  }

  private void a(int paramInt)
  {
    c();
    d();
    ListenableFuture localListenableFuture = this.m.a(paramInt, String.valueOf(this.t.a()));
    this.n.a(localListenableFuture, new PageIdentityViewerRatingCardView.4(this));
  }

  private void b()
  {
    if (this.j.getVisibility() != 0)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130968607);
      this.j.startAnimation(localAnimation);
      this.j.setVisibility(0);
    }
  }

  private void c()
  {
    if (this.j.getVisibility() == 0)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130968608);
      this.j.startAnimation(localAnimation);
      this.j.setVisibility(8);
    }
  }

  private void d()
  {
    this.p.b().a(c, true).a();
  }

  public void setCheckedInThisSession()
  {
    this.s = true;
  }

  public void setPageData(PageIdentityData paramPageIdentityData, String paramString)
  {
    this.t = paramPageIdentityData;
    this.r = paramString;
    Uri localUri = Uri.parse("http://graph.facebook.com/" + this.q + "/picture?type=square");
    this.f.setImageParams(localUri);
    String str;
    if ((this.s) && (paramPageIdentityData.x() == 0))
    {
      str = this.k.getString(2131361880);
      if (paramPageIdentityData.x() <= 0)
        break label199;
      this.d.setRating(paramPageIdentityData.x());
      this.g.setText(str);
      this.d.setVisibility(0);
      this.h.setVisibility(8);
      this.i.setVisibility(8);
    }
    while (true)
    {
      return;
      if (paramPageIdentityData.y() == null);
      for (int i1 = 0; ; i1 = paramPageIdentityData.y().count)
      {
        int i2 = Math.max(1, i1);
        Resources localResources = this.k;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(i2);
        str = localResources.getQuantityString(2131427336, i2, arrayOfObject);
        break;
      }
      label199: a();
      this.g.setText(str);
      this.d.setVisibility(8);
      this.h.setVisibility(0);
      this.i.setVisibility(0);
      this.e.setOnRatingBarChangeListener(new PageIdentityViewerRatingCardView.3(this));
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentityViewerRatingCardView
 * JD-Core Version:    0.6.2
 */