package com.facebook.friends;

import com.facebook.friends.protocol.BlockUserMethod;
import com.facebook.friends.protocol.CancelFriendRequestMethod;
import com.facebook.friends.protocol.FetchFriendRequestsMethod;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowMethod;
import com.facebook.friends.protocol.IgnoreFriendSuggestionMethod;
import com.facebook.friends.protocol.RemoveFriendMethod;
import com.facebook.friends.protocol.RespondToFriendRequestMethod;
import com.facebook.friends.protocol.SendFriendRequestMethod;
import com.facebook.friends.protocol.SubscribeToProfileMethod;
import com.facebook.friends.protocol.UnsubscribeFromProfileMethod;
import com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod;
import com.facebook.friends.service.FriendingServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class FriendingServiceModule$FriendsServiceHandlerProvider extends AbstractProvider<FriendingServiceHandler>
{
  private FriendingServiceModule$FriendsServiceHandlerProvider(FriendingServiceModule paramFriendingServiceModule)
  {
  }

  public FriendingServiceHandler a()
  {
    return new FriendingServiceHandler(a(SingleMethodRunner.class), (RespondToFriendRequestMethod)b(RespondToFriendRequestMethod.class), (FetchPeopleYouMayKnowMethod)b(FetchPeopleYouMayKnowMethod.class), (SendFriendRequestMethod)b(SendFriendRequestMethod.class), (CancelFriendRequestMethod)b(CancelFriendRequestMethod.class), (RemoveFriendMethod)b(RemoveFriendMethod.class), (UpdatePeopleYouMayKnowHistoryMethod)b(UpdatePeopleYouMayKnowHistoryMethod.class), (SubscribeToProfileMethod)b(SubscribeToProfileMethod.class), (UnsubscribeFromProfileMethod)b(UnsubscribeFromProfileMethod.class), (BlockUserMethod)b(BlockUserMethod.class), (FetchFriendRequestsMethod)b(FetchFriendRequestsMethod.class), (IgnoreFriendSuggestionMethod)b(IgnoreFriendSuggestionMethod.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendingServiceModule.FriendsServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */