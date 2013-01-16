package com.facebook.katana.friendrequests;

import com.facebook.friends.FriendingServiceModule;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;

public class FriendingModule extends AbstractModule
{
  protected void a()
  {
    a(new FriendingServiceModule());
    a(FriendRequestView.class).a(new FriendingModule.FriendRequestViewProvider(this, null));
    a(PersonYouMayKnowView.class).a(new FriendingModule.PersonYouMayKnowViewProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendingModule
 * JD-Core Version:    0.6.0
 */