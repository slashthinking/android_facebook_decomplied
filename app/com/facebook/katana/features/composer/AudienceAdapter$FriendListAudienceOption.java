package com.facebook.katana.features.composer;

import com.facebook.katana.model.FriendList;

public class AudienceAdapter$FriendListAudienceOption
  implements AudienceOption
{
  final FriendList a;

  public AudienceAdapter$FriendListAudienceOption(AudienceAdapter paramAudienceAdapter, FriendList paramFriendList)
  {
    this.a = paramFriendList;
  }

  public int a()
  {
    return 2130837546;
  }

  public String b()
  {
    return this.a.name;
  }

  public AudienceOption.Type c()
  {
    return AudienceOption.Type.FRIEND_LIST;
  }

  public FriendList d()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.AudienceAdapter.FriendListAudienceOption
 * JD-Core Version:    0.6.0
 */