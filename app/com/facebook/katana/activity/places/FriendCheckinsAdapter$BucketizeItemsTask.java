package com.facebook.katana.activity.places;

import android.os.AsyncTask;
import com.facebook.debug.Assert;
import com.facebook.katana.model.FacebookCheckin;
import java.util.List;

class FriendCheckinsAdapter$BucketizeItemsTask extends AsyncTask<List<FacebookCheckin>, Integer, List<FriendCheckinsAdapter.Group>>
{
  private FriendCheckinsAdapter$BucketizeItemsTask(FriendCheckinsAdapter paramFriendCheckinsAdapter)
  {
  }

  protected List<FriendCheckinsAdapter.Group> a(List<FacebookCheckin>[] paramArrayOfList)
  {
    Assert.a(1, paramArrayOfList.length);
    if (paramArrayOfList[0] == null);
    for (List localList = null; ; localList = FriendCheckinsAdapter.a(this.a, paramArrayOfList[0]))
      return localList;
  }

  protected void a(List<FriendCheckinsAdapter.Group> paramList)
  {
    FriendCheckinsAdapter.b(this.a, paramList);
    this.a.j();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.FriendCheckinsAdapter.BucketizeItemsTask
 * JD-Core Version:    0.6.0
 */