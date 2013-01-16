package com.facebook.orca.app;

import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.users.User;

class MessagesModule$ThreadParticipantUtilsProvider extends AbstractProvider<ThreadParticipantUtils>
{
  private MessagesModule$ThreadParticipantUtilsProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadParticipantUtils a()
  {
    return new ThreadParticipantUtils(a(User.class, MeUser.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadParticipantUtilsProvider
 * JD-Core Version:    0.6.0
 */