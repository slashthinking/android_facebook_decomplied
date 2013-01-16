package com.facebook.katana.friendrequests;

import android.content.Context;
import com.facebook.orca.inject.AbstractProvider;

class FriendingModule$FriendRequestViewProvider extends AbstractProvider<FriendRequestView>
{
  private FriendingModule$FriendRequestViewProvider(FriendingModule paramFriendingModule)
  {
  }

  public FriendRequestView a()
  {
    return new FriendRequestView((Context)b(Context.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendingModule.FriendRequestViewProvider
 * JD-Core Version:    0.6.0
 */