package com.facebook.pages.identity.ui.about;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLAggregatedRange;
import com.facebook.graphql.model.GraphQLEntityRange;
import com.facebook.graphql.model.GraphQLProfileList;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PageFriendsHereNow;
import com.facebook.graphql.model.PageFriendsWhoLike;
import com.facebook.graphql.model.PageFriendsWhoVisited;
import com.facebook.graphql.model.PageRecommendation;
import com.facebook.graphql.model.PageStarRatersList;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;
import com.facebook.pages.identity.data.PageIdentityData;
import com.facebook.pages.identity.data.PageTopRecommendations;
import com.facebook.uri.FbUriIntentHandler;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

public class PageIdentitySocialContextCardView extends CustomFrameLayout
{
  private static final Class<?> a = PageAboutFragment.class;
  private PageIdentityAnalytics b;
  private FbUriIntentHandler c;
  private SecureContextHelper d;
  private String e = null;
  private final Resources f;
  private final int g;
  private final RatingBar h;
  private final TextView i;
  private final View j;
  private final PageIdentityLikesCheckinsCardUnitView k;
  private final View l;
  private final PageIdentityFriendsHereNowCardUnitView m;
  private final PageIdentityTopRecommendationsView n;
  private final View o;
  private final View p;
  private final View q;
  private final View r;
  private final TextView s;
  private final View t;
  private final View u;

  public PageIdentitySocialContextCardView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageIdentitySocialContextCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PageIdentitySocialContextCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903465);
    this.b = ((PageIdentityAnalytics)getInjector().a(PageIdentityAnalytics.class));
    this.c = ((FbUriIntentHandler)getInjector().a(FbUriIntentHandler.class));
    this.d = ((SecureContextHelper)getInjector().a(SecureContextHelper.class));
    this.f = ((Resources)getInjector().a(Resources.class));
    this.g = this.f.getColor(2131165216);
    this.h = ((RatingBar)findViewById(2131297623));
    this.i = ((TextView)findViewById(2131297624));
    this.j = findViewById(2131297625);
    this.k = ((PageIdentityLikesCheckinsCardUnitView)findViewById(2131297626));
    this.l = findViewById(2131297627);
    this.m = ((PageIdentityFriendsHereNowCardUnitView)findViewById(2131297632));
    this.n = ((PageIdentityTopRecommendationsView)findViewById(2131297633));
    this.o = findViewById(2131297635);
    this.p = findViewById(2131297634);
    this.s = ((TextView)findViewById(2131297630));
    this.q = findViewById(2131297628);
    this.r = findViewById(2131297631);
    this.t = findViewById(2131297637);
    this.u = findViewById(2131297638);
  }

  private void a(int paramInt, double paramDouble)
  {
    if (paramDouble > 0.0D)
    {
      this.h.setRating((float)paramDouble);
      Resources localResources = this.f;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      String str = localResources.getQuantityString(2131427333, paramInt, arrayOfObject);
      this.i.setText(str);
      setRatingsSectionVisibility(0);
    }
    while (true)
    {
      return;
      setRatingsSectionVisibility(8);
    }
  }

  private void a(long paramLong, PageFriendsHereNow paramPageFriendsHereNow)
  {
    if (paramLong > 0L);
    Intent localIntent;
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(paramLong);
      String str = StringLocaleUtil.a("fb://localpage/friends/%s", arrayOfObject);
      localIntent = this.c.a(getContext(), str);
      if (localIntent != null)
        break;
      BLog.e(a, "Failed resolved nearby subcategory uri");
      throw new RuntimeException("Missing binding for nearby subcategory URI");
    }
    localIntent.putExtra("friends_here_now", paramPageFriendsHereNow);
    this.d.a(localIntent, getContext());
  }

  private void a(long paramLong, PageFriendsWhoLike paramPageFriendsWhoLike, PageFriendsWhoVisited paramPageFriendsWhoVisited)
  {
    if (paramLong > 0L);
    Intent localIntent;
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(paramLong);
      String str = StringLocaleUtil.a("fb://localpage/friends/%s", arrayOfObject);
      localIntent = this.c.a(getContext(), str);
      if (localIntent != null)
        break;
      BLog.e(a, "Failed resolved nearby subcategory uri");
      throw new RuntimeException("Missing binding for nearby subcategory URI");
    }
    if (paramPageFriendsWhoLike.friends.size() > 0)
      localIntent.putExtra("friends_who_like", paramPageFriendsWhoLike);
    if (paramPageFriendsWhoVisited.friends.size() > 0)
      localIntent.putExtra("friends_who_visited", paramPageFriendsWhoVisited);
    this.d.a(localIntent, getContext());
  }

  private void a(Spannable paramSpannable, int paramInt1, int paramInt2)
  {
    paramSpannable.setSpan(new ForegroundColorSpan(this.g), paramInt1, paramInt2, 18);
  }

  private void setFriendActivitySummary(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    Preconditions.checkNotNull(paramGraphQLTextWithEntities);
    Preconditions.checkNotNull(paramGraphQLTextWithEntities.text);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramGraphQLTextWithEntities.text);
    if (paramGraphQLTextWithEntities.ranges != null)
    {
      Iterator localIterator2 = paramGraphQLTextWithEntities.ranges.iterator();
      while (localIterator2.hasNext())
      {
        GraphQLEntityRange localGraphQLEntityRange = (GraphQLEntityRange)localIterator2.next();
        a(localSpannableStringBuilder, localGraphQLEntityRange.offset, localGraphQLEntityRange.offset + localGraphQLEntityRange.length);
      }
    }
    if (paramGraphQLTextWithEntities.aggregatedRanges != null)
    {
      Iterator localIterator1 = paramGraphQLTextWithEntities.aggregatedRanges.iterator();
      while (localIterator1.hasNext())
      {
        GraphQLAggregatedRange localGraphQLAggregatedRange = (GraphQLAggregatedRange)localIterator1.next();
        a(localSpannableStringBuilder, localGraphQLAggregatedRange.offset, localGraphQLAggregatedRange.offset + localGraphQLAggregatedRange.length);
      }
    }
    this.s.setText(localSpannableStringBuilder);
  }

  private void setRatingsSectionVisibility(int paramInt)
  {
    this.h.setVisibility(paramInt);
    this.i.setVisibility(paramInt);
    this.j.setVisibility(paramInt);
  }

  public void a(PageRecommendation paramPageRecommendation)
  {
    this.n.setVisibility(0);
    this.n.a(paramPageRecommendation);
  }

  public void setIsLoading(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 0; ; i1 = 8)
    {
      this.t.setVisibility(i1);
      this.u.setVisibility(i1);
      return;
    }
  }

  public void setOnAllRecommendationsViewClickedListener(PageIdentitySocialContextCardView.OnAllRecommendationsViewClickedListener paramOnAllRecommendationsViewClickedListener)
  {
    this.o.setOnClickListener(new PageIdentitySocialContextCardView.1(this, paramOnAllRecommendationsViewClickedListener));
  }

  public void setPageData(PageIdentityData paramPageIdentityData, String paramString)
  {
    Preconditions.checkNotNull(paramPageIdentityData);
    PageStarRatersList localPageStarRatersList = paramPageIdentityData.t();
    GraphQLProfileList localGraphQLProfileList1;
    int i1;
    label57: GraphQLProfileList localGraphQLProfileList2;
    int i2;
    if ((localPageStarRatersList != null) && (localPageStarRatersList.count > 0))
    {
      a(localPageStarRatersList.count, paramPageIdentityData.n());
      localGraphQLProfileList1 = paramPageIdentityData.o();
      PageIdentityLikesCheckinsCardUnitView localPageIdentityLikesCheckinsCardUnitView1 = this.k;
      if (localGraphQLProfileList1 != null)
        break label291;
      i1 = 0;
      localPageIdentityLikesCheckinsCardUnitView1.setLikesCount(i1);
      localGraphQLProfileList2 = paramPageIdentityData.p();
      PageIdentityLikesCheckinsCardUnitView localPageIdentityLikesCheckinsCardUnitView2 = this.k;
      if (localGraphQLProfileList2 != null)
        break label301;
      i2 = 0;
      label84: localPageIdentityLikesCheckinsCardUnitView2.setCheckinsCount(i2);
      this.k.setVisibility(0);
      this.l.setVisibility(0);
      GraphQLTextWithEntities localGraphQLTextWithEntities1 = paramPageIdentityData.w();
      if (localGraphQLTextWithEntities1 == null)
        break label311;
      setFriendActivitySummary(localGraphQLTextWithEntities1);
      this.q.setVisibility(0);
      this.r.setVisibility(0);
      label140: GraphQLTextWithEntities localGraphQLTextWithEntities2 = paramPageIdentityData.f();
      if ((localGraphQLTextWithEntities2 == null) || (localGraphQLTextWithEntities2.text == null) || (localGraphQLTextWithEntities2.ranges == null))
        break label332;
      this.m.setFriendsHereNowText(localGraphQLTextWithEntities2);
      this.m.setFriendsHereNow(paramPageIdentityData.e());
      this.m.setOnClickListener(new PageIdentitySocialContextCardView.2(this, paramPageIdentityData));
      this.m.setVisibility(0);
      label211: PageTopRecommendations localPageTopRecommendations = PageTopRecommendations.a(paramPageIdentityData.g(), paramPageIdentityData.m());
      if (!localPageTopRecommendations.a())
        break label344;
      this.n.setTopRecommendations(localPageTopRecommendations);
      this.n.setVisibility(0);
      this.o.setVisibility(0);
      this.p.setVisibility(0);
    }
    while (true)
    {
      this.q.setOnClickListener(new PageIdentitySocialContextCardView.3(this, paramPageIdentityData));
      return;
      setRatingsSectionVisibility(8);
      break;
      label291: i1 = localGraphQLProfileList1.count;
      break label57;
      label301: i2 = localGraphQLProfileList2.count;
      break label84;
      label311: this.q.setVisibility(8);
      this.r.setVisibility(8);
      break label140;
      label332: this.m.setVisibility(8);
      break label211;
      label344: this.n.setVisibility(8);
      this.o.setVisibility(8);
      this.p.setVisibility(8);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentitySocialContextCardView
 * JD-Core Version:    0.6.2
 */