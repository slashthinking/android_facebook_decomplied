package com.facebook.katana.activity.findfriends;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.katana.view.findfriends.FriendCandidate;

class StepAddFriendsActivity$4
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((FriendCandidate)StepAddFriendsActivity.c(this.a).getItem(paramInt)).c();
    StepAddFriendsActivity.e(this.a);
    StepAddFriendsActivity.c(this.a).notifyDataSetChanged();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepAddFriendsActivity.4
 * JD-Core Version:    0.6.0
 */