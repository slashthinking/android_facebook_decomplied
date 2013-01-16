package com.facebook.katana.activity.profilelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.ui.SectionedListView;
import java.util.HashSet;

public class FriendSingleSelectorActivity extends ProfileListActivity
  implements NotNewNavEnabled
{
  private boolean A;
  protected FriendSingleSelectorActivity.QueryHandler t;
  protected int u;
  protected ImageView v;
  protected TextView y;
  protected String z;

  private void a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      this.u = (paramInt | this.u);
      if (this.u == 0)
        break label64;
      i = 1;
      label23: if (i == 0)
        break label69;
      findViewById(2131296644).setVisibility(8);
      findViewById(2131296645).setVisibility(0);
    }
    while (true)
    {
      return;
      this.u &= (paramInt ^ 0xFFFFFFFF);
      break;
      label64: i = 0;
      break label23;
      label69: findViewById(2131296644).setVisibility(0);
      findViewById(2131296645).setVisibility(8);
    }
  }

  private void p()
  {
    setContentView(2130903542);
    ((SectionedListView)m()).setSectionedListAdapter(this.B);
    q();
    this.y = ((TextView)findViewById(2131297813));
    this.y.setText(this.z);
    this.y.addTextChangedListener(new FriendSingleSelectorActivity.3(this));
    this.v = ((ImageView)findViewById(2131297814));
    this.v.setOnClickListener(new FriendSingleSelectorActivity.4(this));
  }

  private void q()
  {
    ((TextView)findViewById(2131296644)).setText(2131362941);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.n = AppSession.a(this, true);
    HashSet localHashSet = new HashSet();
    this.B = new FriendSingleSelectorActivity.1(this, this, this.n.j(), null, localHashSet);
    this.t = new FriendSingleSelectorActivity.QueryHandler(this, this);
    this.o = new FriendSingleSelectorActivity.FriendSingleSelectorAppSessionListener(this);
    p();
    this.y.requestFocus();
    View localView = findViewById(2131297812);
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new FriendSingleSelectorActivity.2(this, localView));
  }

  public void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent();
    FacebookProfile localFacebookProfile = (FacebookProfile)((SelectableProfileListNaiveCursorAdapter)this.B).e(paramInt);
    localIntent.putExtra("extra_target_profile", localFacebookProfile.mId);
    localIntent.putExtra("extra_keyboard_showing_target", this.A);
    localIntent.putExtra("extra_target_name", localFacebookProfile.mDisplayName);
    setResult(-1, localIntent);
    finish();
  }

  public String i()
  {
    return getString(2131363187);
  }

  public void onBackPressed()
  {
    setResult(0);
    finish();
  }

  public void onPause()
  {
    super.onPause();
    this.n = AppSession.a(this, true);
    this.n.b(this.o);
  }

  public void onResume()
  {
    super.onResume();
    this.n = AppSession.a(this, true);
    this.n.a(this.o);
    if (((SelectableProfileListNaiveCursorAdapter)this.B).e() == null)
    {
      a(1, true);
      this.t.startQuery(1, null, ConnectionsContract.d, ProfileListNaiveCursorAdapter.FriendsQuery.a, "display_name IS NOT NULL AND LENGTH(display_name) > 0", null, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.FriendSingleSelectorActivity
 * JD-Core Version:    0.6.0
 */