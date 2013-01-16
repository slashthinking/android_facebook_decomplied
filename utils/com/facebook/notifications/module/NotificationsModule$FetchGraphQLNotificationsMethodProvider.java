package com.facebook.notifications.module;

import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsMethod;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.story.GraphQLStoryHelper;

class NotificationsModule$FetchGraphQLNotificationsMethodProvider extends AbstractProvider<FetchGraphQLNotificationsMethod>
{
  private NotificationsModule$FetchGraphQLNotificationsMethodProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public FetchGraphQLNotificationsMethod a()
  {
    return new FetchGraphQLNotificationsMethod((GraphQLHelper)b(GraphQLHelper.class), (GraphQLStoryHelper)b(GraphQLStoryHelper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.FetchGraphQLNotificationsMethodProvider
 * JD-Core Version:    0.6.2
 */