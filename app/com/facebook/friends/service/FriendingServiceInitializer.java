package com.facebook.friends.service;

import com.facebook.orca.app.INeedInit;
import com.facebook.orca.server.OrcaServiceRegistry;

public class FriendingServiceInitializer
  implements INeedInit
{
  private final OrcaServiceRegistry a;

  public FriendingServiceInitializer(OrcaServiceRegistry paramOrcaServiceRegistry)
  {
    this.a = paramOrcaServiceRegistry;
  }

  public void i_()
  {
    this.a.a(FriendingQueue.class, FriendingService.class);
    this.a.a("respond_to_friend_request", FriendingQueue.class);
    this.a.a("fetch_people_you_may_know", FriendingQueue.class);
    this.a.a("send_friend_request", FriendingQueue.class);
    this.a.a("cancel_friend_request", FriendingQueue.class);
    this.a.a("remove_friend", FriendingQueue.class);
    this.a.a("update_people_you_may_know_history", FriendingQueue.class);
    this.a.a("subscribe_to_profile", FriendingQueue.class);
    this.a.a("unsubscribe_from_profile", FriendingQueue.class);
    this.a.a("block_user", FriendingQueue.class);
    this.a.a("fetch_friend_requests", FriendingQueue.class);
    this.a.a("ignore_friend_suggestion", FriendingQueue.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.service.FriendingServiceInitializer
 * JD-Core Version:    0.6.0
 */