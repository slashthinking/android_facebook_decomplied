package com.facebook.feed.protocol;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.model.NewsFeedType;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.Application;
import com.facebook.graphql.GraphQl.CelebrationsFeedUnit;
import com.facebook.graphql.GraphQl.CelebrationsFeedUnitItem;
import com.facebook.graphql.GraphQl.Image;
import com.facebook.graphql.GraphQl.MutualFriendsConnection;
import com.facebook.graphql.GraphQl.NewsFeedConnection;
import com.facebook.graphql.GraphQl.NewsFeedEdge;
import com.facebook.graphql.GraphQl.Page;
import com.facebook.graphql.GraphQl.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.GraphQl.PagesYouMayLikeFeedUnitItem;
import com.facebook.graphql.GraphQl.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.GraphQl.PeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.GraphQl.RecommendedApplicationsFeedUnit;
import com.facebook.graphql.GraphQl.RecommendedApplicationsFeedUnitItem;
import com.facebook.graphql.GraphQl.SponsoredData;
import com.facebook.graphql.GraphQl.TextWithEntities;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryApplication.ApplicationField;
import com.facebook.graphql.GraphQlQueryCelebrationsFeedUnit.CelebrationsFeedUnitField;
import com.facebook.graphql.GraphQlQueryCelebrationsFeedUnitItem;
import com.facebook.graphql.GraphQlQueryCelebrationsFeedUnitItem.CelebrationsFeedUnitItemField;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryFeedUnitImpl;
import com.facebook.graphql.GraphQlQueryImage;
import com.facebook.graphql.GraphQlQueryImage.CallOnImage;
import com.facebook.graphql.GraphQlQueryMutualFriendsConnection.MutualFriendsConnectionField;
import com.facebook.graphql.GraphQlQueryNewsFeedConnection;
import com.facebook.graphql.GraphQlQueryNewsFeedConnection.CallOnNewsFeedConnection;
import com.facebook.graphql.GraphQlQueryNewsFeedConnection.NewsFeedConnectionField;
import com.facebook.graphql.GraphQlQueryNewsFeedEdge.NewsFeedEdgeField;
import com.facebook.graphql.GraphQlQueryPage.PageField;
import com.facebook.graphql.GraphQlQueryPagesYouMayLikeFeedUnit.PagesYouMayLikeFeedUnitField;
import com.facebook.graphql.GraphQlQueryPagesYouMayLikeFeedUnitItem;
import com.facebook.graphql.GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryPeopleYouMayKnowFeedUnit.PeopleYouMayKnowFeedUnitField;
import com.facebook.graphql.GraphQlQueryPeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.GraphQlQueryPeopleYouMayKnowFeedUnitItem.PeopleYouMayKnowFeedUnitItemField;
import com.facebook.graphql.GraphQlQueryRecommendedApplicationsFeedUnit.RecommendedApplicationsFeedUnitField;
import com.facebook.graphql.GraphQlQueryRecommendedApplicationsFeedUnitItem;
import com.facebook.graphql.GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField;
import com.facebook.graphql.GraphQlQueryRootCallActor;
import com.facebook.graphql.GraphQlQuerySponsoredData.SponsoredDataField;
import com.facebook.graphql.GraphQlQueryTextWithEntities;
import com.facebook.graphql.GraphQlQueryTextWithEntities.TextWithEntitiesField;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.GraphQlUtil;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.common.GraphQlNewsFeedDefaults;
import com.facebook.graphql.model.CelebrationsFeedUnit;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.RecommendedApplicationsFeedUnit;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FetchNewsFeedMethod
  implements ApiMethod<FetchNewsFeedParams, FetchNewsFeedResult>
{
  private static final GraphQlQueryParam a = GraphQlQueryParam.a("orderby_home_story_param");
  private static final GraphQlQueryParam b = GraphQlQueryParam.a("view_mode_param");
  private static final GraphQlQueryParam c = GraphQlQueryParam.a("storytype_home_story_param");
  private static final GraphQlQueryParam d = GraphQlQueryParam.a("before_home_story_param");
  private static final GraphQlQueryParam e = GraphQlQueryParam.a("after_home_story_param");
  private static final GraphQlQueryParam f = GraphQlQueryParam.a("first_home_story_param");
  private static final GraphQlQueryParam g = GraphQlQueryParam.a("pymk_size_param");
  private static final GraphQlQueryParam h = GraphQlQueryParam.a("pyml_size_param");
  private static final GraphQlQueryParam i = GraphQlQueryParam.a("celebrations_profile_pic_size_param");
  private static final GraphQlQueryPeopleYouMayKnowFeedUnit.PeopleYouMayKnowFeedUnitField j;
  private static final GraphQlQueryPagesYouMayLikeFeedUnit.PagesYouMayLikeFeedUnitField k;
  private static final GraphQlQueryPagesYouMayLikeFeedUnit.PagesYouMayLikeFeedUnitField l;
  private static final GraphQlQueryCelebrationsFeedUnit.CelebrationsFeedUnitField m;
  private static final GraphQlQueryCelebrationsFeedUnit.CelebrationsFeedUnitField n;
  private static final GraphQlQueryRecommendedApplicationsFeedUnit.RecommendedApplicationsFeedUnitField o;
  private static final GraphQlQuery p;
  private static final Map<Class<?>, Class<?>> q;
  private final GraphQLStoryHelper r;
  private final GraphQLHelper s;
  private final UserInteractionController t;
  private final OrcaSharedPreferences u;
  private final FbErrorReporter v;
  private final Clock w;

  static
  {
    GraphQlQueryPeopleYouMayKnowFeedUnitItem.PeopleYouMayKnowFeedUnitItemField[] arrayOfPeopleYouMayKnowFeedUnitItemField = new GraphQlQueryPeopleYouMayKnowFeedUnitItem.PeopleYouMayKnowFeedUnitItemField[2];
    GraphQlQueryUser.UserField[] arrayOfUserField1 = new GraphQlQueryUser.UserField[4];
    arrayOfUserField1[0] = GraphQl.User.a;
    arrayOfUserField1[1] = GraphQl.User.c;
    GraphQlQueryMutualFriendsConnection.MutualFriendsConnectionField[] arrayOfMutualFriendsConnectionField = new GraphQlQueryMutualFriendsConnection.MutualFriendsConnectionField[1];
    arrayOfMutualFriendsConnectionField[0] = GraphQl.MutualFriendsConnection.a;
    arrayOfUserField1[2] = GraphQl.User.a(GraphQl.MutualFriendsConnection.a(arrayOfMutualFriendsConnectionField));
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage1 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage1[0] = GraphQl.Image.a(g, g);
    arrayOfUserField1[3] = GraphQl.User.a(GraphQl.Image.a(arrayOfCallOnImage1).a(GraphQlQueryDefaults.c));
    arrayOfPeopleYouMayKnowFeedUnitItemField[0] = GraphQl.PeopleYouMayKnowFeedUnitItem.a(GraphQl.User.a(arrayOfUserField1));
    arrayOfPeopleYouMayKnowFeedUnitItemField[1] = GraphQl.PeopleYouMayKnowFeedUnitItem.a;
    j = GraphQl.PeopleYouMayKnowFeedUnit.a(GraphQl.PeopleYouMayKnowFeedUnitItem.a(arrayOfPeopleYouMayKnowFeedUnitItemField).a("pymk_items"));
    GraphQlQueryTextWithEntities.TextWithEntitiesField[] arrayOfTextWithEntitiesField1 = new GraphQlQueryTextWithEntities.TextWithEntitiesField[1];
    arrayOfTextWithEntitiesField1[0] = GraphQl.TextWithEntities.a;
    k = GraphQl.PagesYouMayLikeFeedUnit.a(GraphQl.TextWithEntities.a(arrayOfTextWithEntitiesField1).a("pyml_title"));
    GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField[] arrayOfPagesYouMayLikeFeedUnitItemField = new GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField[4];
    GraphQlQueryPage.PageField[] arrayOfPageField = new GraphQlQueryPage.PageField[3];
    arrayOfPageField[0] = GraphQl.Page.a;
    arrayOfPageField[1] = GraphQl.Page.c;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage2 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage2[0] = GraphQl.Image.a(h, h);
    arrayOfPageField[2] = GraphQl.Page.a(GraphQl.Image.a(arrayOfCallOnImage2).a(GraphQlQueryDefaults.c));
    arrayOfPagesYouMayLikeFeedUnitItemField[0] = GraphQl.PagesYouMayLikeFeedUnitItem.a(GraphQl.Page.a(arrayOfPageField));
    arrayOfPagesYouMayLikeFeedUnitItemField[1] = GraphQl.PagesYouMayLikeFeedUnitItem.a(GraphQlNewsFeedDefaults.i);
    GraphQlQuerySponsoredData.SponsoredDataField[] arrayOfSponsoredDataField1 = new GraphQlQuerySponsoredData.SponsoredDataField[2];
    arrayOfSponsoredDataField1[0] = GraphQl.SponsoredData.a;
    arrayOfSponsoredDataField1[1] = GraphQl.SponsoredData.b;
    arrayOfPagesYouMayLikeFeedUnitItemField[2] = GraphQl.PagesYouMayLikeFeedUnitItem.a(GraphQl.SponsoredData.a(arrayOfSponsoredDataField1));
    arrayOfPagesYouMayLikeFeedUnitItemField[3] = GraphQl.PagesYouMayLikeFeedUnitItem.a;
    l = GraphQl.PagesYouMayLikeFeedUnit.a(GraphQl.PagesYouMayLikeFeedUnitItem.a(arrayOfPagesYouMayLikeFeedUnitItemField).a("pyml_items"));
    GraphQlQueryCelebrationsFeedUnitItem.CelebrationsFeedUnitItemField[] arrayOfCelebrationsFeedUnitItemField = new GraphQlQueryCelebrationsFeedUnitItem.CelebrationsFeedUnitItemField[2];
    GraphQlQueryUser.UserField[] arrayOfUserField2 = new GraphQlQueryUser.UserField[4];
    arrayOfUserField2[0] = GraphQl.User.a;
    arrayOfUserField2[1] = GraphQl.User.c;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage3 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage3[0] = GraphQl.Image.a(i, i);
    arrayOfUserField2[2] = GraphQl.User.a(GraphQl.Image.a(arrayOfCallOnImage3).a(GraphQlQueryDefaults.c));
    arrayOfUserField2[3] = GraphQl.User.p;
    arrayOfCelebrationsFeedUnitItemField[0] = GraphQl.CelebrationsFeedUnitItem.a(GraphQl.User.a(arrayOfUserField2));
    arrayOfCelebrationsFeedUnitItemField[1] = GraphQl.CelebrationsFeedUnitItem.a(GraphQlQueryDefaults.a);
    m = GraphQl.CelebrationsFeedUnit.a(GraphQl.CelebrationsFeedUnitItem.a(arrayOfCelebrationsFeedUnitItemField).a("celebs_items"));
    GraphQlQueryTextWithEntities.TextWithEntitiesField[] arrayOfTextWithEntitiesField2 = new GraphQlQueryTextWithEntities.TextWithEntitiesField[1];
    arrayOfTextWithEntitiesField2[0] = GraphQl.TextWithEntities.a;
    n = GraphQl.CelebrationsFeedUnit.a(GraphQl.TextWithEntities.a(arrayOfTextWithEntitiesField2).a("celebs_title"));
    GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField[] arrayOfRecommendedApplicationsFeedUnitItemField = new GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField[6];
    GraphQlQueryApplication.ApplicationField[] arrayOfApplicationField = new GraphQlQueryApplication.ApplicationField[7];
    arrayOfApplicationField[0] = GraphQl.Application.j;
    arrayOfApplicationField[1] = GraphQl.Application.n;
    arrayOfApplicationField[2] = GraphQl.Application.b(GraphQlQueryDefaults.a);
    arrayOfApplicationField[3] = GraphQl.Application.a(GraphQlQueryDefaults.a);
    arrayOfApplicationField[4] = GraphQl.Application.c;
    arrayOfApplicationField[5] = GraphQl.Application.b;
    arrayOfApplicationField[6] = GraphQl.Application.a(GraphQlQueryDefaults.l);
    arrayOfRecommendedApplicationsFeedUnitItemField[0] = GraphQl.RecommendedApplicationsFeedUnitItem.a(GraphQl.Application.a(arrayOfApplicationField));
    arrayOfRecommendedApplicationsFeedUnitItemField[1] = GraphQl.RecommendedApplicationsFeedUnitItem.a(GraphQlQueryDefaults.d);
    arrayOfRecommendedApplicationsFeedUnitItemField[2] = GraphQl.RecommendedApplicationsFeedUnitItem.a(GraphQlQueryDefaults.a);
    arrayOfRecommendedApplicationsFeedUnitItemField[3] = GraphQl.RecommendedApplicationsFeedUnitItem.b(GraphQlQueryDefaults.d);
    GraphQlQuerySponsoredData.SponsoredDataField[] arrayOfSponsoredDataField2 = new GraphQlQuerySponsoredData.SponsoredDataField[3];
    arrayOfSponsoredDataField2[0] = GraphQl.SponsoredData.a;
    arrayOfSponsoredDataField2[1] = GraphQl.SponsoredData.c;
    arrayOfSponsoredDataField2[2] = GraphQl.SponsoredData.b;
    arrayOfRecommendedApplicationsFeedUnitItemField[4] = GraphQl.RecommendedApplicationsFeedUnitItem.a(GraphQl.SponsoredData.a(arrayOfSponsoredDataField2));
    arrayOfRecommendedApplicationsFeedUnitItemField[5] = GraphQl.RecommendedApplicationsFeedUnitItem.a;
    o = GraphQl.RecommendedApplicationsFeedUnit.a(GraphQl.RecommendedApplicationsFeedUnitItem.a(arrayOfRecommendedApplicationsFeedUnitItemField).a("apps_items"));
    GraphQlQueryRootCallActor localGraphQlQueryRootCallActor = GraphQl.a();
    GraphQlQueryUser.UserField[] arrayOfUserField3 = new GraphQlQueryUser.UserField[1];
    GraphQlQueryNewsFeedConnection.CallOnNewsFeedConnection[] arrayOfCallOnNewsFeedConnection = new GraphQlQueryNewsFeedConnection.CallOnNewsFeedConnection[7];
    arrayOfCallOnNewsFeedConnection[0] = GraphQl.NewsFeedConnection.a("android");
    arrayOfCallOnNewsFeedConnection[1] = GraphQl.NewsFeedConnection.f(b);
    arrayOfCallOnNewsFeedConnection[2] = GraphQl.NewsFeedConnection.d(a);
    arrayOfCallOnNewsFeedConnection[3] = GraphQl.NewsFeedConnection.e(c);
    arrayOfCallOnNewsFeedConnection[4] = GraphQl.NewsFeedConnection.b(d);
    arrayOfCallOnNewsFeedConnection[5] = GraphQl.NewsFeedConnection.a(e);
    arrayOfCallOnNewsFeedConnection[6] = GraphQl.NewsFeedConnection.c(f);
    GraphQlQueryNewsFeedConnection localGraphQlQueryNewsFeedConnection = GraphQl.NewsFeedConnection.a(arrayOfCallOnNewsFeedConnection);
    GraphQlQueryNewsFeedConnection.NewsFeedConnectionField[] arrayOfNewsFeedConnectionField = new GraphQlQueryNewsFeedConnection.NewsFeedConnectionField[2];
    GraphQlQueryNewsFeedEdge.NewsFeedEdgeField[] arrayOfNewsFeedEdgeField = new GraphQlQueryNewsFeedEdge.NewsFeedEdgeField[3];
    arrayOfNewsFeedEdgeField[0] = GraphQl.NewsFeedEdge.b;
    arrayOfNewsFeedEdgeField[1] = GraphQl.NewsFeedEdge.c;
    arrayOfNewsFeedEdgeField[2] = GraphQl.NewsFeedEdge.a(((GraphQlQueryFeedUnitImpl)GraphQlNewsFeedDefaults.C.get(2)).b(j).b(k).b(l).b(n).b(m).b(o));
    arrayOfNewsFeedConnectionField[0] = GraphQl.NewsFeedConnection.a(GraphQl.NewsFeedEdge.a(arrayOfNewsFeedEdgeField));
    arrayOfNewsFeedConnectionField[1] = GraphQl.NewsFeedConnection.a(GraphQlQueryDefaults.k);
    arrayOfUserField3[0] = GraphQl.User.a(localGraphQlQueryNewsFeedConnection.a(arrayOfNewsFeedConnectionField));
    p = localGraphQlQueryRootCallActor.a(GraphQl.User.a(arrayOfUserField3));
    q = ImmutableMap.k().b(PeopleYouMayKnowFeedUnit.class, FetchNewsFeedMethod.PeopleYouMayKnowFeedUnitMixIn.class).b(PagesYouMayLikeFeedUnit.class, FetchNewsFeedMethod.PagesYouMayLikeFeedUnitMixIn.class).b(CelebrationsFeedUnit.class, FetchNewsFeedMethod.CelebrationsFeedUnitMixIn.class).b(RecommendedApplicationsFeedUnit.class, FetchNewsFeedMethod.RecommendedApplicationsFeedUnitMixIn.class).b();
  }

  public FetchNewsFeedMethod(GraphQLStoryHelper paramGraphQLStoryHelper, GraphQLHelper paramGraphQLHelper, UserInteractionController paramUserInteractionController, OrcaSharedPreferences paramOrcaSharedPreferences, FbErrorReporter paramFbErrorReporter, Clock paramClock)
  {
    this.r = paramGraphQLStoryHelper;
    this.s = paramGraphQLHelper;
    this.t = paramUserInteractionController;
    this.u = paramOrcaSharedPreferences;
    this.v = paramFbErrorReporter;
    this.w = paramClock;
  }

  private String b(FetchNewsFeedParams paramFetchNewsFeedParams)
  {
    FetchNewsFeedParams.ViewMode localViewMode = paramFetchNewsFeedParams.g();
    if (this.u.a(FeedPrefKeys.H, false))
    {
      localViewMode = FetchNewsFeedParams.ViewMode.FREEZE;
      this.u.b().a(FeedPrefKeys.H, false).a();
    }
    ImmutableMap localImmutableMap = ImmutableMap.k().b(GraphQlQueryDefaults.e, this.r.a()).b(g, this.r.c()).b(h, this.r.d()).b(b, localViewMode.gqlModeName).b(i, this.r.e()).b(a, paramFetchNewsFeedParams.f().value).b(c, GraphQLStoryHelper.f()).b(d, GraphQlUtil.b(paramFetchNewsFeedParams.c())).b(e, GraphQlUtil.b(paramFetchNewsFeedParams.d())).b(f, String.valueOf(paramFetchNewsFeedParams.b())).b();
    return p.a(localImmutableMap);
  }

  public FetchNewsFeedResult a(FetchNewsFeedParams paramFetchNewsFeedParams, ApiResponse paramApiResponse)
  {
    JsonParser localJsonParser = this.s.a("fetch_news_feed", 2, paramApiResponse.d());
    this.t.c();
    ObjectMapper localObjectMapper = (ObjectMapper)localJsonParser.getCodec();
    Iterator localIterator1 = q.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Class localClass = localObjectMapper.findMixInClassFor((Class)localEntry.getKey());
      if ((localClass == null) || (localClass == localEntry.getValue()));
      for (boolean bool = true; ; bool = false)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ((Class)localEntry.getKey()).getName();
        Preconditions.checkState(bool, "Class '%s' already has a mixin.", arrayOfObject);
        localObjectMapper.addMixInAnnotations((Class)localEntry.getKey(), (Class)localEntry.getValue());
        break;
      }
    }
    FeedHomeStories localFeedHomeStories;
    try
    {
      localFeedHomeStories = (FeedHomeStories)localJsonParser.readValueAs(FeedHomeStories.class);
      Iterator localIterator3 = q.keySet().iterator();
      if (localIterator3.hasNext())
        localObjectMapper.addMixInAnnotations((Class)localIterator3.next(), null);
    }
    finally
    {
      Iterator localIterator2 = q.keySet().iterator();
      while (localIterator2.hasNext())
        localObjectMapper.addMixInAnnotations((Class)localIterator2.next(), null);
    }
    FbErrorReporter localFbErrorReporter = this.v;
    if (localFeedHomeStories.feedUnitEdges == null);
    long l1;
    for (int i1 = 0; ; i1 = localFeedHomeStories.feedUnitEdges.size())
    {
      FeedUtils.a(localFbErrorReporter, "fetch_feed_server_failure", paramFetchNewsFeedParams, i1, false, false);
      l1 = this.w.a();
      this.u.b().a(FeedPrefKeys.E, l1).a();
      if (localFeedHomeStories.feedUnitEdges == null)
        break;
      Iterator localIterator4 = localFeedHomeStories.feedUnitEdges.iterator();
      while (localIterator4.hasNext())
      {
        FeedUnitEdge localFeedUnitEdge = (FeedUnitEdge)localIterator4.next();
        if (localFeedUnitEdge.b() == null)
          continue;
        localFeedUnitEdge.b().setFetchTimeMs(l1);
      }
    }
    return new FetchNewsFeedResult(new FetchNewsFeedParamsBuilder().a(paramFetchNewsFeedParams).c(), localFeedHomeStories, DataFreshnessResult.FROM_SERVER, l1);
  }

  public ApiRequest a(FetchNewsFeedParams paramFetchNewsFeedParams)
  {
    this.u.b().a(FeedPrefKeys.D, paramFetchNewsFeedParams.f().value).a();
    return this.s.a("fetch_news_feed", b(paramFetchNewsFeedParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchNewsFeedMethod
 * JD-Core Version:    0.6.0
 */