package com.facebook.katana.activity.profilelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.service.method.FqlGetGroups;
import com.facebook.katana.ui.SectionedListView;
import com.facebook.katana.util.IntentUtils;

public class GroupListActivity extends ProfileListActivity
{
  private void d(boolean paramBoolean)
  {
    t().a(paramBoolean);
    c(paramBoolean);
  }

  private void i()
  {
    ((TextView)findViewById(2131296644)).setText(2131362957);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903541);
    this.n = AppSession.a(this, true);
    this.B = new GroupListAdapter(this, this.n.j());
    ((SectionedListView)m()).setSectionedListAdapter(this.B);
    i();
    this.o = new GroupListActivity.GroupsListListener(this);
  }

  public void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    FacebookProfile localFacebookProfile = (FacebookProfile)this.B.e(paramInt);
    Intent localIntent = IntentUtils.a(this, localFacebookProfile.mId);
    localIntent.putExtra("extra_user_display_name", localFacebookProfile.mDisplayName);
    localIntent.putExtra("extra_image_url", localFacebookProfile.mImageUrl);
    localIntent.putExtra("extra_user_type", 3);
    startActivity(localIntent);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    paramMenu.add(0, 2, 0, 2131363208).setIcon(2130838829);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    switch (paramMenuItem.getItemId())
    {
    default:
      bool = super.onOptionsItemSelected(paramMenuItem);
    case 2:
    }
    while (true)
    {
      return bool;
      FqlGetGroups.a(this);
      d(bool);
    }
  }

  public void onResume()
  {
    super.onResume();
    this.n = AppSession.a(this, true);
    FqlGetGroups.a(this);
    d(true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupListActivity
 * JD-Core Version:    0.6.0
 */