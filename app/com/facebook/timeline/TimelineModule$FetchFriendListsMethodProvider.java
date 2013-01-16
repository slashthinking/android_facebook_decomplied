package com.facebook.timeline;

import android.content.res.Resources;
import com.facebook.friends.protocol.FetchFriendListsMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;

class TimelineModule$FetchFriendListsMethodProvider extends AbstractProvider<FetchFriendListsMethod>
{
  private TimelineModule$FetchFriendListsMethodProvider(TimelineModule paramTimelineModule)
  {
  }

  public FetchFriendListsMethod a()
  {
    return new FetchFriendListsMethod((Resources)b(Resources.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.FetchFriendListsMethodProvider
 * JD-Core Version:    0.6.0
 */