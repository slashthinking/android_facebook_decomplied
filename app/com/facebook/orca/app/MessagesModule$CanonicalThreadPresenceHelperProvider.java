package com.facebook.orca.app;

import android.content.res.Resources;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.users.CanonicalThreadPresenceHelper;
import com.facebook.orca.users.LastActiveHelper;

class MessagesModule$CanonicalThreadPresenceHelperProvider extends AbstractProvider<CanonicalThreadPresenceHelper>
{
  private MessagesModule$CanonicalThreadPresenceHelperProvider(MessagesModule paramMessagesModule)
  {
  }

  public CanonicalThreadPresenceHelper a()
  {
    return new CanonicalThreadPresenceHelper((ThreadParticipantUtils)b(ThreadParticipantUtils.class), (PresenceManager)b(PresenceManager.class), (DataCache)b(DataCache.class), (ThreadDisplayCache)b(ThreadDisplayCache.class), (LastActiveHelper)b(LastActiveHelper.class), (Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.CanonicalThreadPresenceHelperProvider
 * JD-Core Version:    0.6.0
 */