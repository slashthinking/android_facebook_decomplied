package com.facebook.pages.identity.ui.about;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPhoneNumber;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.maps.Locations;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;
import com.facebook.pages.identity.data.PageIdentityData;
import com.facebook.pages.identity.fetcher.PageIdentityDataFetcher;
import com.facebook.uri.FbUriIntentHandler;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.util.concurrent.ListenableFuture;

public class PageIdentityActionSheet extends CustomFrameLayout
{
  private static final Class<?> a = PageIdentityActionSheet.class;
  private final Button b;
  private final Button c;
  private final Button d;
  private final View e;
  private final View f;
  private final FbUriIntentHandler g;
  private final PageIdentityDataFetcher h;
  private final AndroidThreadUtil i;
  private final SecureContextHelper j;
  private final FbErrorReporter k;
  private final PageIdentityAnalytics l;
  private PageIdentityActionSheet.OnStartCheckinComposerListener m;
  private GraphQLPhoneNumber n;
  private PageIdentityData o;
  private String p = null;

  public PageIdentityActionSheet(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageIdentityActionSheet(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PageIdentityActionSheet(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903452);
    this.g = ((FbUriIntentHandler)getInjector().a(FbUriIntentHandler.class));
    this.h = ((PageIdentityDataFetcher)getInjector().a(PageIdentityDataFetcher.class));
    this.i = ((AndroidThreadUtil)getInjector().a(AndroidThreadUtil.class));
    this.j = ((SecureContextHelper)getInjector().a(SecureContextHelper.class));
    this.k = ((FbErrorReporter)getInjector().a(FbErrorReporter.class));
    this.l = ((PageIdentityAnalytics)getInjector().a(PageIdentityAnalytics.class));
    this.b = ((Button)findViewById(2131297587));
    this.c = ((Button)findViewById(2131297589));
    this.d = ((Button)findViewById(2131297591));
    this.e = findViewById(2131297588);
    this.f = findViewById(2131297590);
  }

  private static FacebookPlace a(PageIdentityData paramPageIdentityData)
  {
    return new FacebookPlace(paramPageIdentityData.a(), paramPageIdentityData.l(), "", paramPageIdentityData.k().latitude, paramPageIdentityData.k().longitude, -1, "");
  }

  private void a()
  {
    if (this.m != null)
    {
      Intent localIntent = this.g.a(getContext(), "fb://composer");
      if (localIntent == null)
      {
        BLog.e(a, "Failed resolving composer search uri");
        throw new RuntimeException("Missing binding for composer search URI");
      }
      Location localLocation = Locations.a(this.o.k().latitude, this.o.k().longitude);
      localIntent.putExtra("extra_is_checkin", true);
      localIntent.putExtra("tagged_place_location", localLocation);
      localIntent.putExtra("tagged_place_profile", a(this.o));
      this.m.b(localIntent);
    }
  }

  private void b()
  {
    Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.n.universalNumber));
    this.j.b(localIntent, getContext());
  }

  private void c()
  {
    boolean bool;
    if (!this.b.isSelected())
    {
      bool = true;
      if (!bool)
        break label76;
      this.l.b(this.p);
    }
    while (true)
    {
      this.b.setSelected(bool);
      ListenableFuture localListenableFuture = this.h.a(bool, this.o.a());
      this.i.a(localListenableFuture, new PageIdentityActionSheet.4(this, bool));
      return;
      bool = false;
      break;
      label76: this.l.c(this.p);
    }
  }

  public void setOnStartCheckingComposerListener(PageIdentityActionSheet.OnStartCheckinComposerListener paramOnStartCheckinComposerListener)
  {
    this.m = paramOnStartCheckinComposerListener;
  }

  public void setPageData(PageIdentityData paramPageIdentityData, String paramString)
  {
    this.o = paramPageIdentityData;
    this.p = paramString;
    this.b.setSelected(paramPageIdentityData.h());
    this.b.setOnClickListener(new PageIdentityActionSheet.1(this));
    this.d.setOnClickListener(new PageIdentityActionSheet.2(this));
    this.c.setOnClickListener(new PageIdentityActionSheet.3(this));
    this.n = paramPageIdentityData.q();
    if ((this.n != null) && (this.n.universalNumber != null))
    {
      this.e.setVisibility(0);
      if (!paramPageIdentityData.j())
        break label127;
      this.f.setVisibility(0);
    }
    while (true)
    {
      return;
      this.e.setVisibility(8);
      break;
      label127: this.f.setVisibility(8);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentityActionSheet
 * JD-Core Version:    0.6.2
 */