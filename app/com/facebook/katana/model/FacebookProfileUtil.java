package com.facebook.katana.model;

import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.ipc.model.FacebookProfile;

public final class FacebookProfileUtil
{
  public static FacebookProfile a(FacebookUser paramFacebookUser)
  {
    return new FacebookProfile(paramFacebookUser.mUserId, paramFacebookUser.mDisplayName, paramFacebookUser.mImageUrl, 0, paramFacebookUser.mCanPost, paramFacebookUser.mCanPostKnown);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookProfileUtil
 * JD-Core Version:    0.6.0
 */