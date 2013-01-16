package com.facebook.notifications.protocol;

import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.Icon;
import com.facebook.graphql.GraphQl.NotificationStoriesConnection;
import com.facebook.graphql.GraphQl.NotificationStoriesDelta;
import com.facebook.graphql.GraphQl.NotificationStoriesDeltaConnection;
import com.facebook.graphql.GraphQl.NotificationStoriesDeltaEdge;
import com.facebook.graphql.GraphQl.NotificationStoriesEdge;
import com.facebook.graphql.GraphQl.Story;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryIcon.IconField;
import com.facebook.graphql.GraphQlQueryNotificationStoriesConnection;
import com.facebook.graphql.GraphQlQueryNotificationStoriesConnection.CallOnNotificationStoriesConnection;
import com.facebook.graphql.GraphQlQueryNotificationStoriesConnection.NotificationStoriesConnectionField;
import com.facebook.graphql.GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField;
import com.facebook.graphql.GraphQlQueryNotificationStoriesDeltaConnection;
import com.facebook.graphql.GraphQlQueryNotificationStoriesDeltaConnection.CallOnNotificationStoriesDeltaConnection;
import com.facebook.graphql.GraphQlQueryNotificationStoriesDeltaConnection.NotificationStoriesDeltaConnectionField;
import com.facebook.graphql.GraphQlQueryNotificationStoriesDeltaEdge.NotificationStoriesDeltaEdgeField;
import com.facebook.graphql.GraphQlQueryNotificationStoriesEdge.NotificationStoriesEdgeField;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRootCallActor;
import com.facebook.graphql.GraphQlQueryStory;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.GraphQlUtil;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.common.GraphQlNewsFeedDefaults;
import com.facebook.notifications.model.NotificationStories;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public class FetchGraphQLNotificationsMethod
  implements ApiMethod<FetchGraphQLNotificationsParams, FetchGraphQLNotificationsResult>
{
  private static final GraphQlQueryParam a = GraphQlQueryParam.a("before_notification_stories");
  private static final GraphQlQueryParam b = GraphQlQueryParam.a("after_notification_stories");
  private static final GraphQlQueryParam c = GraphQlQueryParam.a("first_notification_stories");
  private static final GraphQlQueryParam d = GraphQlQueryParam.a("notification_stories_cache_IDs");
  private static final GraphQlQueryStory h;
  private static final GraphQlQueryNotificationStoriesDeltaConnection i = localGraphQlQueryNotificationStoriesDeltaConnection.a(arrayOfNotificationStoriesDeltaConnectionField);
  private final GraphQLHelper e;
  private final GraphQLStoryHelper f;
  private final GraphQlQuery g;

  static
  {
    GraphQlQueryStory localGraphQlQueryStory = (GraphQlQueryStory)GraphQlNewsFeedDefaults.D.get(2);
    GraphQlQueryIcon.IconField[] arrayOfIconField = new GraphQlQueryIcon.IconField[1];
    arrayOfIconField[0] = GraphQl.Icon.b;
    h = localGraphQlQueryStory.a(GraphQl.Story.a(GraphQl.Icon.a(arrayOfIconField))).a(GraphQl.Story.i).a(GraphQl.Story.b);
    GraphQlQueryNotificationStoriesDeltaConnection.CallOnNotificationStoriesDeltaConnection[] arrayOfCallOnNotificationStoriesDeltaConnection = new GraphQlQueryNotificationStoriesDeltaConnection.CallOnNotificationStoriesDeltaConnection[1];
    arrayOfCallOnNotificationStoriesDeltaConnection[0] = GraphQl.NotificationStoriesDeltaConnection.a(d);
    GraphQlQueryNotificationStoriesDeltaConnection localGraphQlQueryNotificationStoriesDeltaConnection = GraphQl.NotificationStoriesDeltaConnection.a(arrayOfCallOnNotificationStoriesDeltaConnection);
    GraphQlQueryNotificationStoriesDeltaConnection.NotificationStoriesDeltaConnectionField[] arrayOfNotificationStoriesDeltaConnectionField = new GraphQlQueryNotificationStoriesDeltaConnection.NotificationStoriesDeltaConnectionField[1];
    GraphQlQueryNotificationStoriesDeltaEdge.NotificationStoriesDeltaEdgeField[] arrayOfNotificationStoriesDeltaEdgeField = new GraphQlQueryNotificationStoriesDeltaEdge.NotificationStoriesDeltaEdgeField[2];
    GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField[] arrayOfNotificationStoriesDeltaField = new GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField[4];
    arrayOfNotificationStoriesDeltaField[0] = GraphQl.NotificationStoriesDelta.a;
    arrayOfNotificationStoriesDeltaField[1] = GraphQl.NotificationStoriesDelta.c;
    arrayOfNotificationStoriesDeltaField[2] = GraphQl.NotificationStoriesDelta.d;
    arrayOfNotificationStoriesDeltaField[3] = GraphQl.NotificationStoriesDelta.a(h);
    arrayOfNotificationStoriesDeltaEdgeField[0] = GraphQl.NotificationStoriesDeltaEdge.a(GraphQl.NotificationStoriesDelta.a(arrayOfNotificationStoriesDeltaField));
    arrayOfNotificationStoriesDeltaEdgeField[1] = GraphQl.NotificationStoriesDeltaEdge.a;
    arrayOfNotificationStoriesDeltaConnectionField[0] = GraphQl.NotificationStoriesDeltaConnection.a(GraphQl.NotificationStoriesDeltaEdge.a(arrayOfNotificationStoriesDeltaEdgeField));
  }

  public FetchGraphQLNotificationsMethod(GraphQLHelper paramGraphQLHelper, GraphQLStoryHelper paramGraphQLStoryHelper)
  {
    this(paramGraphQLHelper, paramGraphQLStoryHelper, h);
  }

  FetchGraphQLNotificationsMethod(GraphQLHelper paramGraphQLHelper, GraphQLStoryHelper paramGraphQLStoryHelper, GraphQlQueryStory paramGraphQlQueryStory)
  {
    this.e = paramGraphQLHelper;
    this.f = paramGraphQLStoryHelper;
    GraphQlQueryRootCallActor localGraphQlQueryRootCallActor = GraphQl.a();
    GraphQlQueryUser.UserField[] arrayOfUserField = new GraphQlQueryUser.UserField[1];
    GraphQlQueryNotificationStoriesConnection.CallOnNotificationStoriesConnection[] arrayOfCallOnNotificationStoriesConnection = new GraphQlQueryNotificationStoriesConnection.CallOnNotificationStoriesConnection[3];
    arrayOfCallOnNotificationStoriesConnection[0] = GraphQl.NotificationStoriesConnection.b(a);
    arrayOfCallOnNotificationStoriesConnection[1] = GraphQl.NotificationStoriesConnection.a(b);
    arrayOfCallOnNotificationStoriesConnection[2] = GraphQl.NotificationStoriesConnection.c(c);
    GraphQlQueryNotificationStoriesConnection localGraphQlQueryNotificationStoriesConnection = GraphQl.NotificationStoriesConnection.a(arrayOfCallOnNotificationStoriesConnection);
    GraphQlQueryNotificationStoriesConnection.NotificationStoriesConnectionField[] arrayOfNotificationStoriesConnectionField = new GraphQlQueryNotificationStoriesConnection.NotificationStoriesConnectionField[2];
    GraphQlQueryNotificationStoriesEdge.NotificationStoriesEdgeField[] arrayOfNotificationStoriesEdgeField = new GraphQlQueryNotificationStoriesEdge.NotificationStoriesEdgeField[2];
    arrayOfNotificationStoriesEdgeField[0] = GraphQl.NotificationStoriesEdge.a(paramGraphQlQueryStory);
    arrayOfNotificationStoriesEdgeField[1] = GraphQl.NotificationStoriesEdge.a;
    arrayOfNotificationStoriesConnectionField[0] = GraphQl.NotificationStoriesConnection.a(GraphQl.NotificationStoriesEdge.a(arrayOfNotificationStoriesEdgeField));
    arrayOfNotificationStoriesConnectionField[1] = GraphQl.NotificationStoriesConnection.a(i);
    arrayOfUserField[0] = GraphQl.User.a(localGraphQlQueryNotificationStoriesConnection.a(arrayOfNotificationStoriesConnectionField));
    this.g = localGraphQlQueryRootCallActor.a(GraphQl.User.a(arrayOfUserField));
  }

  public FetchGraphQLNotificationsResult a(FetchGraphQLNotificationsParams paramFetchGraphQLNotificationsParams, ApiResponse paramApiResponse)
  {
    JsonParser localJsonParser = this.e.a("fetch_notifications", 2, paramApiResponse.d());
    return new FetchGraphQLNotificationsResult((NotificationStories)((ObjectMapper)localJsonParser.getCodec()).readValue(localJsonParser, NotificationStories.class), paramFetchGraphQLNotificationsParams.e(), DataFreshnessResult.FROM_SERVER, System.currentTimeMillis());
  }

  public ApiRequest a(FetchGraphQLNotificationsParams paramFetchGraphQLNotificationsParams)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.k().b(GraphQlQueryDefaults.e, this.f.a()).b(a, GraphQlUtil.b(paramFetchGraphQLNotificationsParams.d())).b(b, GraphQlUtil.b(paramFetchGraphQLNotificationsParams.c()));
    GraphQlQueryParam localGraphQlQueryParam = c;
    if (paramFetchGraphQLNotificationsParams.b() == -1);
    for (String str1 = "null"; ; str1 = String.valueOf(paramFetchGraphQLNotificationsParams.b()))
    {
      ImmutableMap localImmutableMap = localBuilder.b(localGraphQlQueryParam, str1).b(d, Joiner.on(",").join(paramFetchGraphQLNotificationsParams.f())).b();
      String str2 = this.g.a(localImmutableMap);
      return this.e.a("fetch_notifications", str2);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.FetchGraphQLNotificationsMethod
 * JD-Core Version:    0.6.2
 */