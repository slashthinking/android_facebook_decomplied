package com.facebook.friends.service;

import android.os.Bundle;
import com.facebook.friends.protocol.BlockUserMethod;
import com.facebook.friends.protocol.BlockUserMethod.Params;
import com.facebook.friends.protocol.CancelFriendRequestMethod;
import com.facebook.friends.protocol.CancelFriendRequestMethod.Params;
import com.facebook.friends.protocol.FetchFriendRequestsMethod;
import com.facebook.friends.protocol.FetchFriendRequestsMethod.Result;
import com.facebook.friends.protocol.FetchFriendingPossibilitiesParams;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowMethod;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowMethod.Result;
import com.facebook.friends.protocol.IgnoreFriendSuggestionMethod;
import com.facebook.friends.protocol.IgnoreFriendSuggestionMethod.Params;
import com.facebook.friends.protocol.RemoveFriendMethod;
import com.facebook.friends.protocol.RemoveFriendMethod.Params;
import com.facebook.friends.protocol.RespondToFriendRequestMethod;
import com.facebook.friends.protocol.RespondToFriendRequestMethod.Params;
import com.facebook.friends.protocol.SendFriendRequestMethod;
import com.facebook.friends.protocol.SendFriendRequestMethod.Params;
import com.facebook.friends.protocol.SubscribeToProfileMethod;
import com.facebook.friends.protocol.SubscribeToProfileMethod.Params;
import com.facebook.friends.protocol.UnsubscribeFromProfileMethod;
import com.facebook.friends.protocol.UnsubscribeFromProfileMethod.Params;
import com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod;
import com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod.Params;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import javax.inject.Provider;

public class FriendingServiceHandler
  implements OrcaServiceHandler
{
  private final Provider<SingleMethodRunner> a;
  private final RespondToFriendRequestMethod b;
  private final FetchPeopleYouMayKnowMethod c;
  private final SendFriendRequestMethod d;
  private final CancelFriendRequestMethod e;
  private final RemoveFriendMethod f;
  private final UpdatePeopleYouMayKnowHistoryMethod g;
  private final SubscribeToProfileMethod h;
  private final UnsubscribeFromProfileMethod i;
  private final BlockUserMethod j;
  private final FetchFriendRequestsMethod k;
  private final IgnoreFriendSuggestionMethod l;

  public FriendingServiceHandler(Provider<SingleMethodRunner> paramProvider, RespondToFriendRequestMethod paramRespondToFriendRequestMethod, FetchPeopleYouMayKnowMethod paramFetchPeopleYouMayKnowMethod, SendFriendRequestMethod paramSendFriendRequestMethod, CancelFriendRequestMethod paramCancelFriendRequestMethod, RemoveFriendMethod paramRemoveFriendMethod, UpdatePeopleYouMayKnowHistoryMethod paramUpdatePeopleYouMayKnowHistoryMethod, SubscribeToProfileMethod paramSubscribeToProfileMethod, UnsubscribeFromProfileMethod paramUnsubscribeFromProfileMethod, BlockUserMethod paramBlockUserMethod, FetchFriendRequestsMethod paramFetchFriendRequestsMethod, IgnoreFriendSuggestionMethod paramIgnoreFriendSuggestionMethod)
  {
    this.a = paramProvider;
    this.b = paramRespondToFriendRequestMethod;
    this.c = paramFetchPeopleYouMayKnowMethod;
    this.d = paramSendFriendRequestMethod;
    this.e = paramCancelFriendRequestMethod;
    this.f = paramRemoveFriendMethod;
    this.g = paramUpdatePeopleYouMayKnowHistoryMethod;
    this.h = paramSubscribeToProfileMethod;
    this.i = paramUnsubscribeFromProfileMethod;
    this.j = paramBlockUserMethod;
    this.k = paramFetchFriendRequestsMethod;
    this.l = paramIgnoreFriendSuggestionMethod;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    SendFriendRequestMethod.Params localParams = (SendFriendRequestMethod.Params)paramOperationParams.b().getParcelable("sendFriendRequest");
    ((SingleMethodRunner)this.a.b()).a(this.d, localParams);
    return OperationResult.b();
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    CancelFriendRequestMethod.Params localParams = (CancelFriendRequestMethod.Params)paramOperationParams.b().getParcelable("cancelFriendRequest");
    ((SingleMethodRunner)this.a.b()).a(this.e, localParams);
    return OperationResult.b();
  }

  private OperationResult d(OperationParams paramOperationParams)
  {
    FetchFriendingPossibilitiesParams localFetchFriendingPossibilitiesParams = (FetchFriendingPossibilitiesParams)paramOperationParams.b().getParcelable("fetchPeopleYouMayKnow");
    return OperationResult.a((FetchPeopleYouMayKnowMethod.Result)((SingleMethodRunner)this.a.b()).a(this.c, localFetchFriendingPossibilitiesParams));
  }

  private OperationResult e(OperationParams paramOperationParams)
  {
    RespondToFriendRequestMethod.Params localParams = (RespondToFriendRequestMethod.Params)paramOperationParams.b().getParcelable("respondToFriendRequest");
    ((SingleMethodRunner)this.a.b()).a(this.b, localParams);
    return OperationResult.b();
  }

  private OperationResult f(OperationParams paramOperationParams)
  {
    RemoveFriendMethod.Params localParams = (RemoveFriendMethod.Params)paramOperationParams.b().getParcelable("removeFriend");
    ((SingleMethodRunner)this.a.b()).a(this.f, localParams);
    return OperationResult.b();
  }

  private OperationResult g(OperationParams paramOperationParams)
  {
    UpdatePeopleYouMayKnowHistoryMethod.Params localParams = (UpdatePeopleYouMayKnowHistoryMethod.Params)paramOperationParams.b().getParcelable("updatePeopleYouMayKnowHistory");
    ((SingleMethodRunner)this.a.b()).a(this.g, localParams);
    return OperationResult.b();
  }

  private OperationResult h(OperationParams paramOperationParams)
  {
    SubscribeToProfileMethod.Params localParams = (SubscribeToProfileMethod.Params)paramOperationParams.b().getParcelable("subscribeToProfile");
    ((SingleMethodRunner)this.a.b()).a(this.h, localParams);
    return OperationResult.b();
  }

  private OperationResult i(OperationParams paramOperationParams)
  {
    UnsubscribeFromProfileMethod.Params localParams = (UnsubscribeFromProfileMethod.Params)paramOperationParams.b().getParcelable("unsubscribeFromProfile");
    ((SingleMethodRunner)this.a.b()).a(this.i, localParams);
    return OperationResult.b();
  }

  private OperationResult j(OperationParams paramOperationParams)
  {
    BlockUserMethod.Params localParams = (BlockUserMethod.Params)paramOperationParams.b().getParcelable("blockUser");
    ((SingleMethodRunner)this.a.b()).a(this.j, localParams);
    return OperationResult.b();
  }

  private OperationResult k(OperationParams paramOperationParams)
  {
    FetchFriendingPossibilitiesParams localFetchFriendingPossibilitiesParams = (FetchFriendingPossibilitiesParams)paramOperationParams.b().getParcelable("fetchFriendRequests");
    return OperationResult.a((FetchFriendRequestsMethod.Result)((SingleMethodRunner)this.a.b()).a(this.k, localFetchFriendingPossibilitiesParams));
  }

  private OperationResult l(OperationParams paramOperationParams)
  {
    IgnoreFriendSuggestionMethod.Params localParams = (IgnoreFriendSuggestionMethod.Params)paramOperationParams.b().getParcelable("ignoreFriendSuggestion");
    ((SingleMethodRunner)this.a.b()).a(this.l, localParams);
    return OperationResult.b();
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    OperationResult localOperationResult;
    if ("respond_to_friend_request".equals(str))
      localOperationResult = e(paramOperationParams);
    while (true)
    {
      return localOperationResult;
      if ("fetch_people_you_may_know".equals(str))
      {
        localOperationResult = d(paramOperationParams);
        continue;
      }
      if ("send_friend_request".equals(str))
      {
        localOperationResult = b(paramOperationParams);
        continue;
      }
      if ("cancel_friend_request".equals(str))
      {
        localOperationResult = c(paramOperationParams);
        continue;
      }
      if ("remove_friend".equals(str))
      {
        localOperationResult = f(paramOperationParams);
        continue;
      }
      if ("update_people_you_may_know_history".equals(str))
      {
        localOperationResult = g(paramOperationParams);
        continue;
      }
      if ("subscribe_to_profile".equals(str))
      {
        localOperationResult = h(paramOperationParams);
        continue;
      }
      if ("unsubscribe_from_profile".equals(str))
      {
        localOperationResult = i(paramOperationParams);
        continue;
      }
      if ("block_user".equals(str))
      {
        localOperationResult = j(paramOperationParams);
        continue;
      }
      if ("fetch_friend_requests".equals(str))
      {
        localOperationResult = k(paramOperationParams);
        continue;
      }
      if (!"ignore_friend_suggestion".equals(str))
        break;
      localOperationResult = l(paramOperationParams);
    }
    throw new Exception("Unknown type");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.service.FriendingServiceHandler
 * JD-Core Version:    0.6.0
 */