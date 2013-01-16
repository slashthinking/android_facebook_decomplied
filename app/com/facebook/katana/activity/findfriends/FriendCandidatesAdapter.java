package com.facebook.katana.activity.findfriends;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.katana.model.FacebookPhonebookContactUser;
import com.facebook.katana.util.BitmapCache;
import com.facebook.katana.view.findfriends.FriendCandidate;
import java.util.List;

public class FriendCandidatesAdapter extends ArrayAdapter<FriendCandidate>
{
  private StepAddFriendsActivity a;
  private int b;
  private int c;
  private List<FriendCandidate> d = null;
  private BitmapCache e = null;

  public FriendCandidatesAdapter(StepAddFriendsActivity paramStepAddFriendsActivity, int paramInt, List<FriendCandidate> paramList)
  {
    super(paramStepAddFriendsActivity, paramInt, paramList);
    this.b = paramInt;
    this.a = paramStepAddFriendsActivity;
    this.d = paramList;
    this.e = new BitmapCache((int)(0.5F * (1048576 * ((ActivityManager)paramStepAddFriendsActivity.getSystemService("activity")).getMemoryClass())));
  }

  public void a()
  {
    this.e.a();
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(Bitmap paramBitmap, FriendCandidate paramFriendCandidate)
  {
    this.e.a(Long.valueOf(paramFriendCandidate.a.userId), paramBitmap);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FriendCandidatesAdapter.FriendCandidateHolder localFriendCandidateHolder1;
    Bitmap localBitmap;
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(this.b, paramViewGroup, false);
      FriendCandidatesAdapter.FriendCandidateHolder localFriendCandidateHolder2 = new FriendCandidatesAdapter.FriendCandidateHolder();
      localFriendCandidateHolder2.a = ((ImageView)paramView.findViewById(2131296836));
      localFriendCandidateHolder2.b = ((TextView)paramView.findViewById(2131296841));
      localFriendCandidateHolder2.c = paramView.findViewById(2131296842);
      localFriendCandidateHolder2.d = paramView.findViewById(2131296837);
      localFriendCandidateHolder2.e = paramView.findViewById(2131296839);
      paramView.setTag(localFriendCandidateHolder2);
      localFriendCandidateHolder1 = localFriendCandidateHolder2;
      FriendCandidate localFriendCandidate = (FriendCandidate)this.d.get(paramInt);
      localBitmap = (Bitmap)this.e.a(Long.valueOf(localFriendCandidate.a.userId));
      localFriendCandidateHolder1.b.setText(localFriendCandidate.b);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.c));
      if (!localFriendCandidate.d())
        break label249;
      localFriendCandidateHolder1.d.setVisibility(4);
      localFriendCandidateHolder1.e.setVisibility(0);
      label194: if (localBitmap != null)
        break label270;
      localFriendCandidateHolder1.c.setVisibility(0);
      localFriendCandidateHolder1.a.setImageBitmap(null);
      if (localFriendCandidate.e() == null)
        this.a.a(localFriendCandidate);
    }
    while (true)
    {
      return paramView;
      localFriendCandidateHolder1 = (FriendCandidatesAdapter.FriendCandidateHolder)paramView.getTag();
      break;
      label249: localFriendCandidateHolder1.d.setVisibility(0);
      localFriendCandidateHolder1.e.setVisibility(4);
      break label194;
      label270: localFriendCandidateHolder1.c.setVisibility(4);
      localFriendCandidateHolder1.a.setImageBitmap(localBitmap);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.FriendCandidatesAdapter
 * JD-Core Version:    0.6.0
 */