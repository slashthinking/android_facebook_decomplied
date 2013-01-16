package com.facebook.feed.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.TimelineSection;
import com.facebook.graphql.GraphQl.TimelineSectionsConnection;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRootCallActor;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.GraphQlQueryTimelineSection.TimelineSectionField;
import com.facebook.graphql.GraphQlQueryTimelineSectionsConnection;
import com.facebook.graphql.GraphQlQueryTimelineSectionsConnection.CallOnTimelineSectionsConnection;
import com.facebook.graphql.GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField;
import com.facebook.graphql.GraphQlQueryUser;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.GraphQlUtil;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.model.Timeline;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableMap;

public class FetchTimelineSectionListMethod
  implements ApiMethod<FetchTimelineSectionListParams, Timeline>
{
  private static final GraphQlQueryParam a = GraphQlQueryParam.a("timeline_filter");
  private static final GraphQlQueryUser b;
  private Resources c;
  private GraphQLHelper d;

  static
  {
    GraphQlQueryUser.UserField[] arrayOfUserField = new GraphQlQueryUser.UserField[1];
    GraphQlQueryTimelineSectionsConnection.CallOnTimelineSectionsConnection[] arrayOfCallOnTimelineSectionsConnection = new GraphQlQueryTimelineSectionsConnection.CallOnTimelineSectionsConnection[1];
    arrayOfCallOnTimelineSectionsConnection[0] = GraphQl.TimelineSectionsConnection.a(a);
    GraphQlQueryTimelineSectionsConnection localGraphQlQueryTimelineSectionsConnection = GraphQl.TimelineSectionsConnection.a(arrayOfCallOnTimelineSectionsConnection);
    GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField[] arrayOfTimelineSectionsConnectionField = new GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField[1];
    GraphQlQueryTimelineSection.TimelineSectionField[] arrayOfTimelineSectionField = new GraphQlQueryTimelineSection.TimelineSectionField[2];
    arrayOfTimelineSectionField[0] = GraphQl.TimelineSection.c;
    arrayOfTimelineSectionField[1] = GraphQl.TimelineSection.a;
    arrayOfTimelineSectionsConnectionField[0] = GraphQl.TimelineSectionsConnection.a(GraphQl.TimelineSection.a(arrayOfTimelineSectionField));
    arrayOfUserField[0] = GraphQl.User.a(localGraphQlQueryTimelineSectionsConnection.a(arrayOfTimelineSectionsConnectionField));
    b = GraphQl.User.a(arrayOfUserField);
  }

  public FetchTimelineSectionListMethod(Resources paramResources, GraphQLHelper paramGraphQLHelper)
  {
    this.c = paramResources;
    this.d = paramGraphQLHelper;
  }

  public Timeline a(FetchTimelineSectionListParams paramFetchTimelineSectionListParams, ApiResponse paramApiResponse)
  {
    Timeline localTimeline = (Timeline)this.d.a("fetch_timeline_section_list", 2, paramApiResponse.d()).readValueAs(Timeline.class);
    if (localTimeline == null)
      throw new Exception("Invalid JSON result");
    return localTimeline;
  }

  public ApiRequest a(FetchTimelineSectionListParams paramFetchTimelineSectionListParams)
  {
    ImmutableMap localImmutableMap = ImmutableMap.a(a, GraphQlUtil.c(paramFetchTimelineSectionListParams.b()));
    if (paramFetchTimelineSectionListParams.a().equals(""));
    String[] arrayOfString;
    for (GraphQlQuery localGraphQlQuery = GraphQl.a().a(b); ; localGraphQlQuery = GraphQl.a(arrayOfString).a(b))
    {
      return this.d.a("fetch_timeline_section_list", localGraphQlQuery.a(localImmutableMap));
      arrayOfString = new String[1];
      arrayOfString[0] = paramFetchTimelineSectionListParams.a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchTimelineSectionListMethod
 * JD-Core Version:    0.6.0
 */