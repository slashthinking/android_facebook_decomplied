package com.facebook.feed.protocol;

import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.AllPendingPostsConnection;
import com.facebook.graphql.GraphQl.TimelineSectionsConnection;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryAllPendingPostsConnection.AllPendingPostsConnectionField;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.GraphQlQueryTimelineSectionsConnection;
import com.facebook.graphql.GraphQlQueryTimelineSectionsConnection.CallOnTimelineSectionsConnection;
import com.facebook.graphql.GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.GraphQlUtil;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.graphql.model.Timeline;
import com.facebook.graphql.model.TimelineSection;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.List;

public class FetchTimelineFirstUnitsMethod
  implements ApiMethod<FetchTimelineFirstUnitsParams, GraphQueryResultEntry>
{
  private final GraphQLStoryHelper a;
  private final GraphQLHelper b;

  public FetchTimelineFirstUnitsMethod(GraphQLStoryHelper paramGraphQLStoryHelper, GraphQLHelper paramGraphQLHelper)
  {
    this.a = paramGraphQLStoryHelper;
    this.b = paramGraphQLHelper;
  }

  private static GraphQlQuery a(boolean paramBoolean)
  {
    GraphQlQueryRootCallNode localGraphQlQueryRootCallNode = GraphQl.a(FetchTimelineSectionMethod.a);
    GraphQlQueryUser.UserField[] arrayOfUserField = new GraphQlQueryUser.UserField[2];
    GraphQlQueryTimelineSectionsConnection.CallOnTimelineSectionsConnection[] arrayOfCallOnTimelineSectionsConnection = new GraphQlQueryTimelineSectionsConnection.CallOnTimelineSectionsConnection[1];
    arrayOfCallOnTimelineSectionsConnection[0] = GraphQl.TimelineSectionsConnection.a(1L);
    GraphQlQueryTimelineSectionsConnection localGraphQlQueryTimelineSectionsConnection = GraphQl.TimelineSectionsConnection.a(arrayOfCallOnTimelineSectionsConnection);
    GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField[] arrayOfTimelineSectionsConnectionField = new GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField[1];
    arrayOfTimelineSectionsConnectionField[0] = GraphQl.TimelineSectionsConnection.a(FetchTimelineSectionMethod.a(paramBoolean));
    arrayOfUserField[0] = GraphQl.User.a(localGraphQlQueryTimelineSectionsConnection.a(arrayOfTimelineSectionsConnectionField));
    GraphQlQueryAllPendingPostsConnection.AllPendingPostsConnectionField[] arrayOfAllPendingPostsConnectionField = new GraphQlQueryAllPendingPostsConnection.AllPendingPostsConnectionField[1];
    arrayOfAllPendingPostsConnectionField[0] = GraphQl.AllPendingPostsConnection.a;
    arrayOfUserField[1] = GraphQl.User.a(GraphQl.AllPendingPostsConnection.a(arrayOfAllPendingPostsConnectionField));
    return localGraphQlQueryRootCallNode.a(GraphQl.User.a(arrayOfUserField));
  }

  private String b(FetchTimelineFirstUnitsParams paramFetchTimelineFirstUnitsParams)
  {
    ImmutableMap localImmutableMap = ImmutableMap.a(GraphQlQueryDefaults.e, this.a.a(), FetchTimelineSectionMethod.a, String.valueOf(paramFetchTimelineFirstUnitsParams.a()), FetchTimelineSectionMethod.b, GraphQlUtil.b(""), FetchTimelineSectionMethod.c, GraphQlUtil.c(paramFetchTimelineFirstUnitsParams.c()));
    return a(paramFetchTimelineFirstUnitsParams.b()).a(localImmutableMap);
  }

  public GraphQueryResultEntry a(FetchTimelineFirstUnitsParams paramFetchTimelineFirstUnitsParams, ApiResponse paramApiResponse)
  {
    JsonParser localJsonParser = this.b.a("fetch_timeline_first_units", 1, paramApiResponse.d());
    GraphQueryResultEntry localGraphQueryResultEntry = (GraphQueryResultEntry)((ObjectMapper)localJsonParser.getCodec()).readValue(localJsonParser, GraphQueryResultEntry.class);
    if ((localGraphQueryResultEntry == null) || (localGraphQueryResultEntry.timeline == null) || (localGraphQueryResultEntry.timeline.sections == null) || (localGraphQueryResultEntry.timeline.sections.size() < 1))
      throw new Exception("Invalid JSON result");
    Iterator localIterator = localGraphQueryResultEntry.timeline.sections.iterator();
    while (localIterator.hasNext())
      FetchTimelineSectionMethod.a((TimelineSection)localIterator.next());
    return localGraphQueryResultEntry;
  }

  public ApiRequest a(FetchTimelineFirstUnitsParams paramFetchTimelineFirstUnitsParams)
  {
    return this.b.a("fetch_timeline_first_units", b(paramFetchTimelineFirstUnitsParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchTimelineFirstUnitsMethod
 * JD-Core Version:    0.6.0
 */