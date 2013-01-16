package com.facebook.katana.activity.profilelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsSubModuleActivity;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.ui.SectionedListView;
import com.facebook.katana.util.IntentUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import java.util.Set;

public class FriendMultiSelectorActivity extends ProfileListActivity
  implements AnalyticsSubModuleActivity, NotNewNavEnabled
{
  protected String A;
  private final String C = FriendMultiSelectorActivity.class.getSimpleName();
  protected FriendMultiSelectorActivity.QueryHandler t;
  protected Set<Long> u;
  protected int v;
  protected ImageView y;
  protected TextView z;

  private void a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      this.v = (paramInt | this.v);
      if (this.v == 0)
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
      this.v &= (paramInt ^ 0xFFFFFFFF);
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
    a(TitleBarButtonSpec.newBuilder().b(getString(2131362910)).i());
    this.z = ((TextView)findViewById(2131297813));
    this.z.setText(this.A);
    this.z.addTextChangedListener(new FriendMultiSelectorActivity.1(this));
    this.y = ((ImageView)findViewById(2131297814));
    this.y.setOnClickListener(new FriendMultiSelectorActivity.2(this));
  }

  private void q()
  {
    ((TextView)findViewById(2131296644)).setText(2131362941);
  }

  public String a()
  {
    return FB4A_AnalyticEntities.u;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.n = AppSession.a(this, true);
    this.u = IntentUtils.a(getIntent().getLongArrayExtra("profiles"));
    this.B = new SelectableProfileListNaiveCursorAdapter(this, this.n.j(), null, this.u);
    this.t = new FriendMultiSelectorActivity.QueryHandler(this, this);
    this.o = new FriendMultiSelectorActivity.FriendMultiSelectorAppSessionListener(this);
    p();
    this.z.requestFocus();
  }

  public void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    ((SelectableProfileListNaiveCursorAdapter)this.B).a(paramInt, paramView);
  }

  public String i()
  {
    return getString(2131363012);
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

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("profiles", IntentUtils.a(this.u));
    setResult(-1, localIntent);
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.FriendMultiSelectorActivity
 * JD-Core Version:    0.6.0
 */