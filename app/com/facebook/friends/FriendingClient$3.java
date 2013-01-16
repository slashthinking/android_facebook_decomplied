package com.facebook.friends;

import com.facebook.friends.model.PersonYouMayKnow;
import com.google.common.base.Function;

class FriendingClient$3
  implements Function<PersonYouMayKnow, String>
{
  public String a(PersonYouMayKnow paramPersonYouMayKnow)
  {
    return String.valueOf(paramPersonYouMayKnow.userId);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendingClient.3
 * JD-Core Version:    0.6.0
 */