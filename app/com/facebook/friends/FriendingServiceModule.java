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
import com.facebook.friends.service.FriendingQueue;
import com.facebook.friends.service.FriendingServiceHandler;
import com.facebook.friends.service.FriendingServiceInitializer;
import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class FriendingServiceModule extends AbstractModule
{
  private void a(Class<? extends Annotation> paramClass, Provider<? extends OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    a(RespondToFriendRequestMethod.class).a(new FriendingServiceModule.RespondToFriendRequestMethodProvider(this, null));
    a(FetchPeopleYouMayKnowMethod.class).a(new FriendingServiceModule.FetchPeopleYouMayKnowMethodProvider(this, null));
    a(SendFriendRequestMethod.class).a(new FriendingServiceModule.SendFriendRequestMethodProvider(this, null));
    a(CancelFriendRequestMethod.class).a(new FriendingServiceModule.CancelFriendRequestMethodProvider(this, null));
    a(RemoveFriendMethod.class).a(new FriendingServiceModule.RemoveFriendMethodProvider(this, null));
    a(SubscribeToProfileMethod.class).a(new FriendingServiceModule.SubscribeToProfileMethodProvider(this, null));
    a(UnsubscribeFromProfileMethod.class).a(new FriendingServiceModule.UnsubscribeFromProfileMethodProvider(this, null));
    a(BlockUserMethod.class).a(new FriendingServiceModule.BlockUserMethodProvider(this, null));
    a(FetchFriendRequestsMethod.class).a(new FriendingServiceModule.FetchFriendRequestsMethodProvider(this, null));
    a(IgnoreFriendSuggestionMethod.class).a(new FriendingServiceModule.IgnoreFriendSuggestionMethodProvider(this, null));
    a(FriendingServiceHandler.class).a(new FriendingServiceModule.FriendsServiceHandlerProvider(this, null));
    a(FriendingClient.class).a(new FriendingServiceModule.FriendingInterfaceProvider(this, null));
    a(FriendingQueue.class, new FriendingServiceModule.FriendsServiceHandlerProvider(this, null));
    a(FriendingServiceInitializer.class).a(new FriendingServiceModule.FriendsServiceInitializerProvider(this, null));
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(FriendingServiceInitializer.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendingServiceModule
 * JD-Core Version:    0.6.0
 */