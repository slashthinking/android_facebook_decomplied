package com.facebook.timeline;

import android.content.res.Resources;
import com.facebook.friends.protocol.FetchFriendListsWithMemberMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;

class TimelineModule$FetchFriendListsWithMemberMethodProvider extends AbstractProvider<FetchFriendListsWithMemberMethod>
{
  private TimelineModule$FetchFriendListsWithMemberMethodProvider(TimelineModule paramTimelineModule)
  {
  }

  public FetchFriendListsWithMemberMethod a()
  {
    return new FetchFriendListsWithMemberMethod((Resources)b(Resources.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.FetchFriendListsWithMemberMethodProvider
 * JD-Core Version:    0.6.0
 */