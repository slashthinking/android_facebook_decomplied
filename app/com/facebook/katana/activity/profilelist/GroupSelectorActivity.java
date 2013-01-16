package com.facebook.katana.activity.profilelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookGroup;
import com.facebook.katana.service.method.FqlGetGroups;
import com.facebook.katana.ui.SectionedListView;

public class GroupSelectorActivity extends ProfileListActivity
  implements NotNewNavEnabled
{
  protected TextView t;
  protected ImageView u;

  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      findViewById(2131296644).setVisibility(8);
      findViewById(2131296645).setVisibility(0);
    }
    while (true)
    {
      c(paramBoolean);
      return;
      findViewById(2131296644).setVisibility(0);
      findViewById(2131296645).setVisibility(8);
    }
  }

  private void p()
  {
    ((TextView)findViewById(2131296644)).setText(2131362957);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903542);
    this.t = ((TextView)findViewById(2131297813));
    this.u = ((ImageView)findViewById(2131297814));
    this.t.addTextChangedListener(new GroupSelectorActivity.1(this));
    this.t.requestFocus();
    this.n = AppSession.a(this, true);
    this.B = new GroupSelectorAdapter(this, this.n.j());
    ((SectionedListView)m()).setSectionedListAdapter(this.B);
    p();
    this.o = new GroupSelectorActivity.GroupSelectorListener(this);
    ((SectionedListView)m()).setFastScrollEnabled(false);
  }

  public void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent();
    FacebookGroup localFacebookGroup = (FacebookGroup)this.B.e(paramInt);
    localIntent.putExtra("extra_target_profile", localFacebookGroup.mId);
    localIntent.putExtra("extra_target_name", localFacebookGroup.mDisplayName);
    setResult(-1, localIntent);
    finish();
  }

  public String i()
  {
    return getString(2131362955);
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
    FqlGetGroups.a(this);
    d(true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupSelectorActivity
 * JD-Core Version:    0.6.0
 */