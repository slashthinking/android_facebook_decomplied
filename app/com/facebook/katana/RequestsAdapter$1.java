package com.facebook.katana;

import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.ProfileImage;
import com.facebook.katana.binding.ProfileImagesCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class RequestsAdapter$1 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, long paramLong, boolean paramBoolean)
  {
    RequestsAdapter.FriendRequest localFriendRequest = (RequestsAdapter.FriendRequest)RequestsAdapter.a(this.a).get(Long.valueOf(paramLong));
    RequestsAdapter.RequestState localRequestState;
    if ((paramBoolean) && (localFriendRequest != null))
      if (localFriendRequest.a() == RequestsAdapter.RequestState.RESPONSE_CONFIRMING)
      {
        localRequestState = RequestsAdapter.RequestState.RESPONSE_CONFIRMED;
        localFriendRequest.a(localRequestState);
      }
    while (true)
    {
      return;
      localRequestState = RequestsAdapter.RequestState.RESPONSE_IGNORED;
      break;
      Toaster.a(RequestsAdapter.c(this.a), 2131363142);
      if (localFriendRequest == null)
        continue;
      localFriendRequest.a(RequestsAdapter.RequestState.NOT_RESPONDED);
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, ProfileImage paramProfileImage, ProfileImagesCache paramProfileImagesCache)
  {
    if (paramProfileImage != null)
    {
      RequestsAdapter.FriendRequest localFriendRequest = (RequestsAdapter.FriendRequest)RequestsAdapter.a(this.a).get(Long.valueOf(paramProfileImage.a));
      if (localFriendRequest != null)
        localFriendRequest.a(paramProfileImage.c());
    }
  }

  public void b(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, Map<Long, List<Long>> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator1 = paramMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Long localLong = (Long)localIterator1.next();
        RequestsAdapter.FriendRequest localFriendRequest2 = (RequestsAdapter.FriendRequest)RequestsAdapter.a(this.a).get(localLong);
        if (localFriendRequest2 == null)
          continue;
        localFriendRequest2.a(((List)paramMap.get(localLong)).size());
      }
      Iterator localIterator2 = RequestsAdapter.b(this.a).iterator();
      while (localIterator2.hasNext())
      {
        RequestsAdapter.FriendRequest localFriendRequest1 = (RequestsAdapter.FriendRequest)localIterator2.next();
        if (localFriendRequest1.c != -1)
          continue;
        localFriendRequest1.a(0);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.RequestsAdapter.1
 * JD-Core Version:    0.6.0
 */