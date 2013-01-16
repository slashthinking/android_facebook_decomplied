package com.facebook.katana.activity.profilelist;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsSubModuleActivity;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.service.method.FqlGetProfile;
import com.facebook.katana.ui.SectionedListView;
import com.facebook.katana.util.IntentUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import java.util.List;

public class GroupMemberMultiSelectorActivity extends ProfileListActivity
  implements AnalyticsSubModuleActivity, NotNewNavEnabled
{
  private String A;
  protected List<FacebookProfile> t;
  protected ImageView u;
  protected TextView v;
  protected String y;
  protected long z = -1L;

  private void a(String paramString)
  {
    FqlGetProfile.a(this, this.z, paramString);
  }

  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      findViewById(2131296644).setVisibility(8);
      findViewById(2131296645).setVisibility(0);
      return;
    }
    TextView localTextView = (TextView)findViewById(2131296644);
    if ((this.A == null) || (TextUtils.isEmpty(this.A)))
      localTextView.setText(2131362947);
    while (true)
    {
      localTextView.setVisibility(0);
      findViewById(2131296645).setVisibility(8);
      break;
      localTextView.setText(2131362948);
    }
  }

  private void p()
  {
    setContentView(2130903542);
    ((SectionedListView)m()).setSectionedListAdapter(this.B);
    q();
    a(TitleBarButtonSpec.newBuilder().b(getString(2131362910)).i());
    this.v = ((TextView)findViewById(2131297813));
    this.v.setText(this.y);
    this.v.setHint(2131362945);
    this.v.addTextChangedListener(new GroupMemberMultiSelectorActivity.1(this));
    this.u = ((ImageView)findViewById(2131297814));
    this.u.setOnClickListener(new GroupMemberMultiSelectorActivity.2(this));
  }

  private void q()
  {
    ((TextView)findViewById(2131296644)).setText(2131362947);
  }

  public String a()
  {
    return FB4A_AnalyticEntities.v;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.n = AppSession.a(this, true);
    if (this.n == null);
    while (true)
    {
      return;
      this.t = IntentUtils.a(getIntent().getParcelableArrayExtra("full_profiles"));
      this.B = new SelectableProfileListDynamicAdapter(this, this.n.j(), this.t);
      this.o = new GroupMemberMultiSelectorActivity.GroupMemberListListener(this);
      p();
      this.v.requestFocus();
      if (this.t == null)
        continue;
      ((SelectableProfileListDynamicAdapter)this.B).a(this.t);
    }
  }

  public void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    ((SelectableProfileListDynamicAdapter)this.B).a(paramInt, paramView);
  }

  public String i()
  {
    return getString(2131363013);
  }

  public void onResume()
  {
    super.onResume();
    this.n = AppSession.a(this, true);
    if (this.n == null);
    while (true)
    {
      return;
      this.n.a(this.o);
      this.z = getIntent().getLongExtra("group_id", -1L);
      d(false);
      v();
    }
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("full_profiles", IntentUtils.a(this.t));
    setResult(-1, localIntent);
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupMemberMultiSelectorActivity
 * JD-Core Version:    0.6.0
 */