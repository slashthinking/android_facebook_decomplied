package com.facebook.pages.identity.ui.about;

import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.composer.protocol.PostRecommendationParams;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfile.Builder;
import com.facebook.graphql.model.PageViewerVisitsList;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.User;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;
import com.facebook.pages.identity.data.PageIdentityData;
import com.facebook.uri.FbUriIntentHandler;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;

public class PageAboutFragment extends OrcaFragment
  implements PageIdentityActionSheet.OnStartCheckinComposerListener
{
  private static final Class<?> a = PageAboutFragment.class;
  private PageIdentityViewerRatingCardView Y;
  private PageIdentityData Z;
  private FrameLayout aa;
  private String ab;
  private FbUriIntentHandler b;
  private SecureContextHelper c;
  private OrcaServiceOperationFactory d;
  private MeUserAuthDataStore e;
  private PageIdentityAnalytics f;
  private PageIdentityActionSheet g;
  private PageIdentityLocalCardView h;
  private PageIdentitySocialContextCardView i;

  private GraphQLProfile a()
  {
    GraphQLProfile.Builder localBuilder = new GraphQLProfile.Builder();
    User localUser = this.e.g();
    GraphQLImage localGraphQLImage = new GraphQLImage("https://graph.facebook.com/" + localUser.b() + "/picture?type=square", 2131230735, 2131230735);
    localBuilder.b(localUser.b());
    localBuilder.a(localGraphQLImage);
    localBuilder.c(localUser.d().getDisplayName());
    return localBuilder.b();
  }

  private void a(long paramLong)
  {
    if (paramLong > 0L);
    Intent localIntent;
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(paramLong);
      String str = StringLocaleUtil.a("fb://localpage/recommendations/%s", arrayOfObject);
      localIntent = this.b.a(p(), str);
      if (localIntent != null)
        break;
      BLog.e(a, "Failed resolved nearby subcategory uri");
      throw new RuntimeException("Missing binding for nearby subcategory URI");
    }
    localIntent.putExtra("com.facebook.katana.profile.id", paramLong);
    this.c.a(localIntent, p());
  }

  private void a(PageIdentityData paramPageIdentityData)
  {
    Intent localIntent = this.b.a(p(), "fb://composer");
    if (localIntent == null)
      throw new RuntimeException("Missing binding for composer search URI");
    localIntent.putExtra("extra_is_recommendation", true);
    localIntent.putExtra("extra_enable_friend_tagging", false);
    localIntent.putExtra("extra_enable_photos", false);
    localIntent.putExtra("extra_enable_location", false);
    localIntent.putExtra("extra_target_page", paramPageIdentityData.a());
    localIntent.putExtra("extra_composer_hint_target", paramPageIdentityData.l());
    localIntent.putExtra("extra_composer_title_string", e(2131361873));
    this.c.a(localIntent, 2, this);
  }

  private void b()
  {
    int j = -1;
    if (this.Z != null)
      if ((this.Z.y() == null) || (this.Z.y().count <= 0))
        break label47;
    label47: for (j = 1; ; j = 0)
    {
      this.f.a(this.ab, j);
      return;
    }
  }

  private void b(PageIdentityData paramPageIdentityData)
  {
    this.Y.setCheckedInThisSession();
    this.Y.setPageData(paramPageIdentityData, this.ab);
    this.Y.setVisibility(0);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903220, paramViewGroup, false);
    this.e = ((MeUserAuthDataStore)FbInjector.a(p()).a(MeUserAuthDataStore.class));
    this.g = ((PageIdentityActionSheet)localView.findViewById(2131296947));
    this.g.setOnStartCheckingComposerListener(this);
    this.h = ((PageIdentityLocalCardView)localView.findViewById(2131296949));
    this.i = ((PageIdentitySocialContextCardView)localView.findViewById(2131296950));
    this.Y = ((PageIdentityViewerRatingCardView)localView.findViewById(2131296948));
    this.aa = ((FrameLayout)localView.findViewById(2131296951));
    return localView;
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
      switch (paramInt1)
      {
      default:
      case 1:
      case 2:
      }
    while (true)
    {
      return;
      b();
      b(this.Z);
      continue;
      PostRecommendationParams localPostRecommendationParams = (PostRecommendationParams)paramIntent.getParcelableExtra("postRecommendationParams");
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("postRecommendationParams", localPostRecommendationParams);
      ProgressDialog localProgressDialog = ProgressDialog.show(p(), e(2131361878), e(2131361877), true);
      Futures.a(this.d.a("post_recommendation", localBundle).d(), new PageAboutFragment.3(this, localProgressDialog, localPostRecommendationParams));
    }
  }

  public void a(PageIdentityData paramPageIdentityData, Location paramLocation, String paramString)
  {
    Preconditions.checkNotNull(paramPageIdentityData);
    this.Z = paramPageIdentityData;
    this.ab = paramString;
    this.g.setPageData(paramPageIdentityData, this.ab);
    this.aa.setOnClickListener(new PageAboutFragment.1(this, paramPageIdentityData));
    this.g.setPageData(paramPageIdentityData, this.ab);
    GraphQLLocation localGraphQLLocation = paramPageIdentityData.k();
    if ((localGraphQLLocation != null) && (localGraphQLLocation.latitude != 0.0D) && (localGraphQLLocation.longitude != 0.0D))
    {
      this.h.setVisibility(0);
      this.h.setPageData(paramPageIdentityData, paramLocation, this.ab);
      this.i.setPageData(paramPageIdentityData, this.ab);
      long l = paramPageIdentityData.a();
      this.i.setOnAllRecommendationsViewClickedListener(new PageAboutFragment.2(this, l));
      if ((paramPageIdentityData.y() == null) || (paramPageIdentityData.y().count <= 0))
        break label192;
      this.Y.setPageData(paramPageIdentityData, this.ab);
      this.Y.setVisibility(0);
    }
    while (true)
    {
      return;
      this.h.setVisibility(8);
      break;
      label192: this.Y.setVisibility(8);
    }
  }

  public void a(boolean paramBoolean)
  {
    Preconditions.checkNotNull(this.i);
    this.i.setIsLoading(paramBoolean);
  }

  public void b(Intent paramIntent)
  {
    this.c.a(paramIntent, 1, this);
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.b = ((FbUriIntentHandler)Q().a(FbUriIntentHandler.class));
    this.c = ((SecureContextHelper)Q().a(SecureContextHelper.class));
    this.d = ((OrcaServiceOperationFactory)Q().a(OrcaServiceOperationFactory.class));
    this.f = ((PageIdentityAnalytics)Q().a(PageIdentityAnalytics.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageAboutFragment
 * JD-Core Version:    0.6.2
 */