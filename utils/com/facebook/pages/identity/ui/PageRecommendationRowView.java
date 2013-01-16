package com.facebook.pages.identity.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import com.facebook.content.SecureContextHelper;
import com.facebook.friends.FriendshipStatus;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PageRecommendation;
import com.facebook.graphql.model.PageStarRatersEdge;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;
import com.facebook.uri.FbUriIntentHandler;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;
import com.google.common.base.Preconditions;

public class PageRecommendationRowView extends CustomRelativeLayout
{
  private static final Class<?> a = PageRecommendationRowView.class;
  private static PageRecommendationRowView.OnFriendRatingClickedListener b = null;
  private final PageIdentityAnalytics c;
  private final UrlImage d;
  private final TextView e;
  private final TextView f;
  private final int g;
  private RatingBar h;
  private RatingBar i;
  private PageRecommendation j;
  private FbUriIntentHandler k;
  private SecureContextHelper l;
  private String m = null;

  public PageRecommendationRowView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageRecommendationRowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PageRecommendationRowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903464);
    this.c = ((PageIdentityAnalytics)getInjector().a(PageIdentityAnalytics.class));
    this.k = ((FbUriIntentHandler)getInjector().a(FbUriIntentHandler.class));
    this.l = ((SecureContextHelper)getInjector().a(SecureContextHelper.class));
    this.g = ((Resources)getInjector().a(Resources.class)).getColor(2131165216);
    this.d = ((UrlImage)findViewById(2131297619));
    this.e = ((TextView)findViewById(2131297621));
    this.f = ((TextView)findViewById(2131297622));
    this.h = ((RatingBar)findViewById(2131296960));
    this.i = ((RatingBar)findViewById(2131296961));
  }

  public static void setOnFriendRatingClickedListener(PageRecommendationRowView.OnFriendRatingClickedListener paramOnFriendRatingClickedListener)
  {
    b = paramOnFriendRatingClickedListener;
  }

  public void a()
  {
    this.c.g(this.m);
    String str = StringLocaleUtil.a("fb://localpage/recommendation", new Object[0]);
    Intent localIntent = this.k.a(getContext(), str);
    if (localIntent == null)
    {
      BLog.e(a, "Failed resolved nearby subcategory uri");
      throw new RuntimeException("Missing binding for nearby subcategory URI");
    }
    localIntent.putExtra("android.intent.extra.SUBJECT", this.j);
    this.l.a(localIntent, getContext());
  }

  public void a(PageRecommendation paramPageRecommendation)
  {
    Preconditions.checkNotNull(paramPageRecommendation.creator);
    boolean bool = FriendshipStatus.ARE_FRIENDS.toGqlString().equals(paramPageRecommendation.creator.friendshipStatus);
    this.j = paramPageRecommendation;
    if (paramPageRecommendation.creator.profilePicture != null)
      this.d.setImageParams(Uri.parse(paramPageRecommendation.creator.profilePicture.uri));
    if (paramPageRecommendation.pageRating > 0)
      if (bool)
      {
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.h.setRating(paramPageRecommendation.pageRating);
      }
    while (true)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramPageRecommendation.creator.name);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(paramPageRecommendation.value.text);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, paramPageRecommendation.creator.name.length(), 18);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.g), 0, paramPageRecommendation.creator.name.length(), 18);
      this.e.setText(localSpannableStringBuilder);
      String str = DefaultTimeFormatUtil.a(getContext(), TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000L * paramPageRecommendation.creationTime);
      this.f.setText(str);
      setOnClickListener(new PageRecommendationRowView.2(this));
      return;
      this.i.setVisibility(0);
      this.h.setVisibility(8);
      this.i.setRating(paramPageRecommendation.pageRating);
      continue;
      this.h.setVisibility(8);
      this.i.setVisibility(8);
    }
  }

  public void a(PageStarRatersEdge paramPageStarRatersEdge)
  {
    Preconditions.checkNotNull(paramPageStarRatersEdge.rater);
    if (paramPageStarRatersEdge.rater.profilePicture != null)
      this.d.setImageParams(Uri.parse(paramPageStarRatersEdge.rater.profilePicture.uri));
    if (paramPageStarRatersEdge.rating > 0)
    {
      this.h.setVisibility(0);
      this.h.setRating(paramPageStarRatersEdge.rating);
    }
    while (true)
    {
      this.e.setTypeface(null, 1);
      this.e.setTextColor(this.g);
      this.e.setText(paramPageStarRatersEdge.rater.name);
      this.f.setVisibility(8);
      setOnClickListener(new PageRecommendationRowView.1(this, paramPageStarRatersEdge));
      return;
      this.h.setVisibility(8);
    }
  }

  public PageRecommendation getRecommendation()
  {
    return this.j;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageRecommendationRowView
 * JD-Core Version:    0.6.2
 */