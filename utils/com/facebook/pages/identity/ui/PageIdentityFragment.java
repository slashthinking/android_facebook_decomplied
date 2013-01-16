package com.facebook.pages.identity.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;
import com.facebook.pages.identity.data.PageIdentityData;
import com.facebook.pages.identity.fetcher.PageIdentityDataFetcher;
import com.facebook.pages.identity.ui.about.PageAboutFragment;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;

public class PageIdentityFragment extends OrcaFragment
{
  private FbErrorReporter Y;
  private Location Z;
  private PageIdentityHeaderView a;
  private String aa = null;
  private PageAboutFragment b;
  private PageIdentityDataFetcher c;
  private PageIdentityData d;
  private PageIdentityAnalytics e;
  private long f;
  private int g;
  private Display h;
  private AndroidThreadUtil i;

  private void b()
  {
    int j = Math.max(this.h.getWidth(), this.h.getHeight());
    ListenableFuture localListenableFuture = this.c.a(this.f, j);
    this.i.a(localListenableFuture, new PageIdentityFragment.1(this));
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903222, paramViewGroup, false);
    this.a = ((PageIdentityHeaderView)localView.findViewById(2131296954));
    this.b = ((PageAboutFragment)K().a(2131296955));
    return localView;
  }

  public void a()
  {
    if (this.d != null)
    {
      this.a.setPageData(this.d);
      this.b.a(this.d, this.Z, this.aa);
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.f = n().getIntent().getLongExtra("com.facebook.katana.profile.id", -1L);
    if (this.f > 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Invalid page id: " + this.f);
      this.g = q().getConfiguration().orientation;
      this.c = ((PageIdentityDataFetcher)Q().a(PageIdentityDataFetcher.class));
      this.h = ((WindowManager)Q().a(WindowManager.class)).getDefaultDisplay();
      this.i = ((AndroidThreadUtil)Q().a(AndroidThreadUtil.class));
      this.Y = ((FbErrorReporter)Q().a(FbErrorReporter.class));
      Bundle localBundle = n().getIntent().getExtras();
      if (localBundle.containsKey("current_location"))
        this.Z = ((Location)localBundle.getParcelable("current_location"));
      if (localBundle.containsKey("session_id"))
        this.aa = localBundle.getString("session_id");
      this.d = ((PageIdentityData)localBundle.getParcelable("page_data"));
      b();
      return;
    }
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.e = ((PageIdentityAnalytics)Q().a(PageIdentityAnalytics.class));
    a();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.g != paramConfiguration.orientation)
    {
      this.g = paramConfiguration.orientation;
      a();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageIdentityFragment
 * JD-Core Version:    0.6.2
 */