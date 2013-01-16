package com.facebook.katana.activity.profilelist;

import android.os.AsyncTask;
import com.facebook.debug.Assert;
import com.facebook.ipc.model.FacebookProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ProfileListDynamicAdapter$SortProfilesTask extends AsyncTask<List<? extends FacebookProfile>, Integer, List<? extends FacebookProfile>>
{
  private ProfileListDynamicAdapter$SortProfilesTask(ProfileListDynamicAdapter paramProfileListDynamicAdapter)
  {
  }

  protected List<? extends FacebookProfile> a(List<? extends FacebookProfile>[] paramArrayOfList)
  {
    Assert.a(1, paramArrayOfList.length);
    ProfileListDynamicAdapter.SortProfilesTask.1 local1 = new ProfileListDynamicAdapter.SortProfilesTask.1(this);
    ArrayList localArrayList = new ArrayList(paramArrayOfList[0]);
    Collections.sort(localArrayList, local1);
    return localArrayList;
  }

  protected void a(List<? extends FacebookProfile> paramList)
  {
    this.a.d = paramList;
    this.a.j();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.ProfileListDynamicAdapter.SortProfilesTask
 * JD-Core Version:    0.6.0
 */