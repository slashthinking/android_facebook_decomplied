package com.facebook.katana;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.util.ApplicationUtils;

class RequestsAdapter$FriendRequest$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ApplicationUtils.a(RequestsAdapter.c(this.a.f), this.a.b.mUserId, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.RequestsAdapter.FriendRequest.1
 * JD-Core Version:    0.6.0
 */