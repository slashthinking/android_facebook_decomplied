package com.facebook.katana;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;

class RequestsAdapter$OnClick
  implements View.OnClickListener
{
  RequestsAdapter.FriendRequest a;
  boolean b;

  public RequestsAdapter$OnClick(RequestsAdapter paramRequestsAdapter, RequestsAdapter.FriendRequest paramFriendRequest, boolean paramBoolean)
  {
    this.a = paramFriendRequest;
    this.b = paramBoolean;
  }

  public void onClick(View paramView)
  {
    if (this.b)
      this.c.a = true;
    RequestsAdapter.FriendRequest localFriendRequest = this.a;
    if (this.b);
    for (RequestsAdapter.RequestState localRequestState = RequestsAdapter.RequestState.RESPONSE_CONFIRMING; ; localRequestState = RequestsAdapter.RequestState.RESPONSE_IGNORING)
    {
      localFriendRequest.a(localRequestState);
      RequestsAdapter.d(this.c).a(RequestsAdapter.c(this.c), this.a.b.mUserId, this.b);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.RequestsAdapter.OnClick
 * JD-Core Version:    0.6.0
 */