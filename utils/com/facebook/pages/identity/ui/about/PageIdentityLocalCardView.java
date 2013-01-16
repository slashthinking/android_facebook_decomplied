package com.facebook.pages.identity.ui.about;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.graphql.model.GraphQLAddress;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLTimeRange;
import com.facebook.maps.Locations;
import com.facebook.maps.MapsLocationUtils;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.LocationUtils;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;
import com.facebook.pages.identity.data.PageIdentityData;
import com.facebook.timeline.page.hours.PageHours;
import com.facebook.timeline.page.hours.PageHours.Status;
import com.facebook.timeline.page.hours.PageHoursRenderer;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.MapImage;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.TimeZone;

public class PageIdentityLocalCardView extends CustomFrameLayout
{
  private static final Class<?> a = PageIdentityLocalCardView.class;
  private final Resources b;
  private final SecureContextHelper c;
  private final IFeedIntentBuilder d;
  private final Clock e;
  private final PageHoursRenderer f;
  private final PageIdentityAnalytics g;
  private final int h;
  private final int i;
  private final View j;
  private final View k;
  private final TextView l;
  private final TextView m;
  private final TextView n;
  private final MapImage o;
  private final TextView p;
  private final MapsLocationUtils q;
  private final View r;
  private long s;
  private String t = null;

  public PageIdentityLocalCardView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageIdentityLocalCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PageIdentityLocalCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903461);
    FbInjector localFbInjector = getInjector();
    this.b = ((Resources)localFbInjector.a(Resources.class));
    this.c = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    this.d = ((IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class));
    this.e = ((Clock)localFbInjector.a(Clock.class));
    this.q = ((MapsLocationUtils)localFbInjector.a(MapsLocationUtils.class));
    this.f = new PageHoursRenderer();
    this.g = ((PageIdentityAnalytics)localFbInjector.a(PageIdentityAnalytics.class));
    this.h = this.b.getColor(2131165216);
    this.i = this.b.getColor(2131165219);
    this.j = findViewById(2131297609);
    this.k = findViewById(2131297612);
    this.l = ((TextView)findViewById(2131297613));
    this.m = ((TextView)findViewById(2131297614));
    this.n = ((TextView)findViewById(2131297615));
    this.o = ((MapImage)findViewById(2131297608));
    this.r = findViewById(2131297616);
    this.p = ((TextView)this.j.findViewById(2131297611));
    this.r.setOnClickListener(new PageIdentityLocalCardView.1(this));
  }

  private String a(GraphQLAddress paramGraphQLAddress, GraphQLLocation paramGraphQLLocation)
  {
    if ((paramGraphQLAddress != null) && (!StringUtil.a(paramGraphQLAddress.fullAddress)) && (!StringUtil.a(paramGraphQLAddress.street)));
    Object[] arrayOfObject;
    for (String str = paramGraphQLAddress.fullAddress; ; str = StringLocaleUtil.a("%f,%f", arrayOfObject))
    {
      return str;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = Double.valueOf(paramGraphQLLocation.latitude);
      arrayOfObject[1] = Double.valueOf(paramGraphQLLocation.longitude);
    }
  }

  private void a()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(this.s);
    String str = StringLocaleUtil.a("fb://page/%s/info", arrayOfObject);
    this.d.a(getContext(), str);
  }

  private void a(PageIdentityData paramPageIdentityData)
  {
    this.o.setOnClickListener(new PageIdentityLocalCardView.2(this, paramPageIdentityData));
  }

  private void a(PageIdentityData paramPageIdentityData, Location paramLocation1, Location paramLocation2)
  {
    if (paramLocation2 != null)
    {
      String str = this.q.a(paramLocation2, paramLocation1);
      this.p.setText(str);
    }
    while (true)
    {
      this.j.setOnClickListener(new PageIdentityLocalCardView.3(this, paramPageIdentityData));
      return;
      this.p.setVisibility(8);
    }
  }

  private void b(PageIdentityData paramPageIdentityData)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", LocationUtils.a(paramPageIdentityData.l(), paramPageIdentityData.k().latitude, paramPageIdentityData.k().longitude));
    this.c.b(localIntent, getContext());
  }

  private void c(PageIdentityData paramPageIdentityData)
  {
    String str = a(paramPageIdentityData.b(), paramPageIdentityData.k());
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.com/maps").buildUpon().appendQueryParameter("f", "d").appendQueryParameter("daddr", str).build());
    this.c.b(localIntent, getContext());
  }

  private void d(PageIdentityData paramPageIdentityData)
  {
    this.s = paramPageIdentityData.a();
    this.k.setOnClickListener(new PageIdentityLocalCardView.4(this));
    e(paramPageIdentityData);
    f(paramPageIdentityData);
  }

  private void e(PageIdentityData paramPageIdentityData)
  {
    List localList = paramPageIdentityData.i();
    GraphQLLocation localGraphQLLocation = paramPageIdentityData.k();
    TimeZone localTimeZone = TimeZone.getDefault();
    if ((localGraphQLLocation != null) && (localGraphQLLocation.a() != null))
    {
      localTimeZone = localGraphQLLocation.a();
      if ((localList != null) && (localList.size() != 0) && (localGraphQLLocation != null) && (localTimeZone != null))
        break label97;
      this.l.setTextColor(this.h);
      this.l.setText(2131361862);
      this.m.setVisibility(8);
    }
    while (true)
    {
      return;
      BLog.d(a, "Place has no timezone, using default one");
      break;
      label97: PageHours localPageHours = new PageHours(localList, localTimeZone, this.e);
      if (localPageHours.a() == PageHours.Status.OPEN)
        this.l.setTextColor(this.i);
      GraphQLTimeRange localGraphQLTimeRange;
      while (true)
      {
        localGraphQLTimeRange = localPageHours.c();
        if (localGraphQLTimeRange != null)
          break label183;
        this.l.setText(2131361861);
        this.m.setVisibility(8);
        break;
        this.l.setTextColor(this.h);
      }
      label183: Resources localResources = this.b;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.f.a(localGraphQLTimeRange.start);
      arrayOfObject[1] = this.f.a(localGraphQLTimeRange.end);
      String str = localResources.getString(2131361859, arrayOfObject);
      this.l.setText(2131361860);
      this.m.setText(str);
      this.m.setVisibility(0);
    }
  }

  private void f(PageIdentityData paramPageIdentityData)
  {
    String str = paramPageIdentityData.r();
    if (str != null)
    {
      this.n.setText(this.b.getString(2131361863, new Object[] { str }));
      this.n.setVisibility(0);
    }
    while (true)
    {
      return;
      this.n.setVisibility(8);
    }
  }

  public void setPageData(PageIdentityData paramPageIdentityData, Location paramLocation, String paramString)
  {
    Preconditions.checkNotNull(paramPageIdentityData);
    this.t = paramString;
    GraphQLLocation localGraphQLLocation = paramPageIdentityData.k();
    Preconditions.checkNotNull(localGraphQLLocation);
    Location localLocation = Locations.a(localGraphQLLocation.latitude, localGraphQLLocation.longitude);
    if ((this.o.getCenter() == null) || (localLocation.distanceTo(this.o.getCenter()) > 0.001F))
      this.o.setCenter(localLocation);
    a(paramPageIdentityData, localLocation, paramLocation);
    d(paramPageIdentityData);
    a(paramPageIdentityData);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentityLocalCardView
 * JD-Core Version:    0.6.2
 */