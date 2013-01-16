package com.facebook.friends;

import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.friends.protocol.BlockUserMethod.Params;
import com.facebook.friends.protocol.CancelFriendRequestMethod.Params;
import com.facebook.friends.protocol.FetchFriendingPossibilitiesParams;
import com.facebook.friends.protocol.IgnoreFriendSuggestionMethod.Params;
import com.facebook.friends.protocol.RemoveFriendMethod.Params;
import com.facebook.friends.protocol.RespondToFriendRequestMethod.Params;
import com.facebook.friends.protocol.SendFriendRequestMethod.HowFound;
import com.facebook.friends.protocol.SendFriendRequestMethod.Params;
import com.facebook.friends.protocol.SendFriendRequestMethod.PeopleYouMayKnowLocation;
import com.facebook.friends.protocol.SubscribeToProfileMethod.Params;
import com.facebook.friends.protocol.UnsubscribeFromProfileMethod.Params;
import com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod.Event;
import com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod.Location;
import com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod.Params;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.List;

public class FriendingClient
{
  GraphQLPageInfo a;
  GraphQLPageInfo b;
  private final FbFragmentActivity c;
  private final OrcaServiceOperationFactory d;

  public FriendingClient(FbFragmentActivity paramFbFragmentActivity, OrcaServiceOperationFactory paramOrcaServiceOperationFactory)
  {
    this.c = paramFbFragmentActivity;
    this.d = paramOrcaServiceOperationFactory;
    c();
  }

  private String d()
  {
    monitorenter;
    try
    {
      String str = this.b.endCursor;
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private String e()
  {
    monitorenter;
    try
    {
      String str = this.a.endCursor;
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public ListenableFuture<List<FriendRequest>> a(int paramInt)
  {
    int i = this.c.getResources().getDimensionPixelSize(2131230744);
    String str = d();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("fetchFriendRequests", new FetchFriendingPossibilitiesParams(i, paramInt, str));
    return Futures.a(this.d.a("fetch_friend_requests", localBundle).d(), new FriendingClient.1(this));
  }

  public ListenableFuture<Void> a(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("cancelFriendRequest", new CancelFriendRequestMethod.Params(paramLong));
    return Futures.a(this.d.a("cancel_friend_request", localBundle).d(), Functions.constant(null));
  }

  public ListenableFuture<Void> a(long paramLong1, long paramLong2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("blockUser", new BlockUserMethod.Params(paramLong1, paramLong2));
    return Futures.a(this.d.a("block_user", localBundle).d(), Functions.constant(null));
  }

  public ListenableFuture<Void> a(long paramLong, FriendRequestResponse paramFriendRequestResponse, FriendRequestResponseRef paramFriendRequestResponseRef)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("respondToFriendRequest", new RespondToFriendRequestMethod.Params(paramFriendRequestResponse, paramLong, paramFriendRequestResponseRef));
    return Futures.a(this.d.a("respond_to_friend_request", localBundle).d(), Functions.constant(null));
  }

  public ListenableFuture<Void> a(long paramLong, SendFriendRequestMethod.HowFound paramHowFound, SendFriendRequestMethod.PeopleYouMayKnowLocation paramPeopleYouMayKnowLocation)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("sendFriendRequest", new SendFriendRequestMethod.Params(paramLong, paramHowFound, paramPeopleYouMayKnowLocation));
    return Futures.a(this.d.a("send_friend_request", localBundle).d(), Functions.constant(null));
  }

  public ListenableFuture<Void> a(List<PersonYouMayKnow> paramList)
  {
    Collection localCollection = Collections2.a(paramList, new FriendingClient.3(this));
    String str = "[" + Joiner.on(", ").join(localCollection) + "]";
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("updatePeopleYouMayKnowHistory", new UpdatePeopleYouMayKnowHistoryMethod.Params(str, UpdatePeopleYouMayKnowHistoryMethod.Event.IMPRESSION, UpdatePeopleYouMayKnowHistoryMethod.Location.JEWEL));
    return Futures.a(this.d.a("update_people_you_may_know_history", localBundle).d(), Functions.constant(null));
  }

  public boolean a()
  {
    monitorenter;
    try
    {
      boolean bool = this.b.hasNextPage;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public ListenableFuture<List<PersonYouMayKnow>> b(int paramInt)
  {
    int i = this.c.getResources().getDimensionPixelSize(2131230744);
    String str = e();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("fetchPeopleYouMayKnow", new FetchFriendingPossibilitiesParams(i, paramInt, str));
    return Futures.a(this.d.a("fetch_people_you_may_know", localBundle).d(), new FriendingClient.2(this));
  }

  public ListenableFuture<Void> b(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ignoreFriendSuggestion", new IgnoreFriendSuggestionMethod.Params(paramLong));
    return Futures.a(this.d.a("ignore_friend_suggestion", localBundle).d(), Functions.constant(null));
  }

  public boolean b()
  {
    monitorenter;
    try
    {
      boolean bool = this.a.hasNextPage;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public ListenableFuture<Void> c(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("removeFriend", new RemoveFriendMethod.Params(paramLong));
    return Futures.a(this.d.a("remove_friend", localBundle).d(), Functions.constant(null));
  }

  public void c()
  {
    monitorenter;
    try
    {
      this.a = new GraphQLPageInfo(null, null, false, true);
      this.b = new GraphQLPageInfo(null, null, false, true);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public ListenableFuture<Void> d(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("subscribeToProfile", new SubscribeToProfileMethod.Params(paramLong));
    return Futures.a(this.d.a("subscribe_to_profile", localBundle).d(), Functions.constant(null));
  }

  public ListenableFuture<Void> e(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("unsubscribeFromProfile", new UnsubscribeFromProfileMethod.Params(paramLong));
    return Futures.a(this.d.a("unsubscribe_from_profile", localBundle).d(), Functions.constant(null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendingClient
 * JD-Core Version:    0.6.0
 */