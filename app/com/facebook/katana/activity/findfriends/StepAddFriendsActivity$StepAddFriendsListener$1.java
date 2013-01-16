package com.facebook.katana.activity.findfriends;

import com.facebook.katana.model.FacebookPhonebookContactUser;
import com.facebook.katana.view.findfriends.FriendCandidate;
import java.util.Comparator;

class StepAddFriendsActivity$StepAddFriendsListener$1
  implements Comparator<FriendCandidate>
{
  public int a(FriendCandidate paramFriendCandidate1, FriendCandidate paramFriendCandidate2)
  {
    return (int)(paramFriendCandidate1.a.ordinal - paramFriendCandidate2.a.ordinal);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepAddFriendsActivity.StepAddFriendsListener.1
 * JD-Core Version:    0.6.0
 */