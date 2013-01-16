package com.facebook.katana.activity.profilelist;

import com.facebook.ipc.model.FacebookProfile;
import java.util.Comparator;

class ProfileListDynamicAdapter$SortProfilesTask$1
  implements Comparator<FacebookProfile>
{
  public int a(FacebookProfile paramFacebookProfile1, FacebookProfile paramFacebookProfile2)
  {
    return paramFacebookProfile1.mDisplayName.compareTo(paramFacebookProfile2.mDisplayName);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.ProfileListDynamicAdapter.SortProfilesTask.1
 * JD-Core Version:    0.6.0
 */