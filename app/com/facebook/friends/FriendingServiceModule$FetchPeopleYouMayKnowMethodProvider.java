package com.facebook.friends;

import android.content.res.Resources;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;

class FriendingServiceModule$FetchPeopleYouMayKnowMethodProvider extends AbstractProvider<FetchPeopleYouMayKnowMethod>
{
  private FriendingServiceModule$FetchPeopleYouMayKnowMethodProvider(FriendingServiceModule paramFriendingServiceModule)
  {
  }

  public FetchPeopleYouMayKnowMethod a()
  {
    return new FetchPeopleYouMayKnowMethod((Resources)b(Resources.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendingServiceModule.FetchPeopleYouMayKnowMethodProvider
 * JD-Core Version:    0.6.0
 */