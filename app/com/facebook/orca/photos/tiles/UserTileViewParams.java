package com.facebook.orca.photos.tiles;

import com.facebook.contacts.models.ContactPicCropInfoGenerator;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.contacts.models.ContactUserKey;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.users.PicCropInfo;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;

public final class UserTileViewParams
{
  private static final Class<?> a = UserTileViewParams.class;
  private final UserTileViewParams.Type b;
  private final PicCropInfo c;
  private final UserKey d;

  private UserTileViewParams(UserTileViewParams.Type paramType, PicCropInfo paramPicCropInfo, UserKey paramUserKey)
  {
    this.b = paramType;
    this.c = paramPicCropInfo;
    this.d = paramUserKey;
  }

  public static UserTileViewParams a(ContactSummary paramContactSummary, ContactPicCropInfoGenerator paramContactPicCropInfoGenerator)
  {
    UserTileViewParams localUserTileViewParams;
    if (paramContactSummary.getBigPictureUrl() != null)
      localUserTileViewParams = a(paramContactPicCropInfoGenerator.b(paramContactSummary));
    while (true)
    {
      return localUserTileViewParams;
      if (paramContactSummary.getSmallPictureUrl() != null)
      {
        localUserTileViewParams = a(paramContactPicCropInfoGenerator.a(paramContactSummary));
        continue;
      }
      localUserTileViewParams = a(ContactUserKey.a(paramContactSummary));
    }
  }

  public static UserTileViewParams a(ThreadParticipant paramThreadParticipant)
  {
    return a(paramThreadParticipant.d());
  }

  public static UserTileViewParams a(PicCropInfo paramPicCropInfo)
  {
    return a(paramPicCropInfo, null);
  }

  public static UserTileViewParams a(PicCropInfo paramPicCropInfo, UserKey paramUserKey)
  {
    return new UserTileViewParams(UserTileViewParams.Type.PIC_CROP_INFO, paramPicCropInfo, paramUserKey);
  }

  public static UserTileViewParams a(User paramUser)
  {
    PicCropInfo localPicCropInfo = paramUser.r();
    if (localPicCropInfo != null)
      BLog.b(a, "Using pic crop info for user (" + paramUser + "): " + localPicCropInfo);
    for (UserTileViewParams localUserTileViewParams = a(localPicCropInfo, paramUser.c()); ; localUserTileViewParams = a(paramUser.c()))
    {
      return localUserTileViewParams;
      BLog.b(a, "Using user key for user (" + paramUser + "): " + localPicCropInfo);
    }
  }

  public static UserTileViewParams a(UserKey paramUserKey)
  {
    return new UserTileViewParams(UserTileViewParams.Type.USER_KEY, null, paramUserKey);
  }

  public UserTileViewParams.Type a()
  {
    return this.b;
  }

  public PicCropInfo b()
  {
    return this.c;
  }

  public UserKey c()
  {
    return this.d;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      UserTileViewParams localUserTileViewParams = (UserTileViewParams)paramObject;
      if (!a().equals(localUserTileViewParams.a()))
      {
        i = 0;
        continue;
      }
      if (!Objects.equal(b(), localUserTileViewParams.b()))
      {
        i = 0;
        continue;
      }
      if (Objects.equal(c(), localUserTileViewParams.c()))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = a();
    arrayOfObject[1] = b();
    arrayOfObject[2] = c();
    return Objects.hashCode(arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.tiles.UserTileViewParams
 * JD-Core Version:    0.6.0
 */