package com.facebook.friends;

import android.content.Context;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.google.common.base.Preconditions;

class FriendingServiceModule$FriendingInterfaceProvider extends AbstractProvider<FriendingClient>
{
  private FriendingServiceModule$FriendingInterfaceProvider(FriendingServiceModule paramFriendingServiceModule)
  {
  }

  public FriendingClient a()
  {
    Context localContext = (Context)b(Context.class);
    Preconditions.checkState(localContext instanceof FbFragmentActivity, "FriendingClient requires an FbFragmentActivity as context to be injected");
    return new FriendingClient((FbFragmentActivity)localContext, (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendingServiceModule.FriendingInterfaceProvider
 * JD-Core Version:    0.6.0
 */