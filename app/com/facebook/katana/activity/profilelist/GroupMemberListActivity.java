package com.facebook.katana.activity.profilelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.service.method.FqlGetProfile;
import com.facebook.katana.ui.SectionedListView;
import com.facebook.katana.util.IntentUtils;

public class GroupMemberListActivity extends ProfileListActivity
{
  protected long t = -1L;

  private void i()
  {
    ((TextView)findViewById(2131296644)).setText(2131363083);
  }

  public void a(Bundle paramBundle)
  {
    this.s = true;
    super.a(paramBundle);
    setContentView(2130903242);
    this.n = AppSession.a(this, true);
    l();
    j();
    this.B = new ProfileListDynamicAdapter(this, this.n.j());
    ((SectionedListView)m()).setSectionedListAdapter(this.B);
    i();
    this.o = new GroupMemberListActivity.GroupMemberListListener(this);
  }

  public void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    FacebookProfile localFacebookProfile = (FacebookProfile)this.B.e(e(paramInt));
    Intent localIntent = IntentUtils.a(this, localFacebookProfile.mId);
    localIntent.putExtra("extra_user_display_name", localFacebookProfile.mDisplayName);
    localIntent.putExtra("extra_image_url", localFacebookProfile.mImageUrl);
    localIntent.putExtra("extra_user_type", 0);
    localIntent.putExtra("can_post", localFacebookProfile.mCanPost);
    startActivity(localIntent);
  }

  public void onResume()
  {
    super.onResume();
    this.n = AppSession.a(this, true);
    this.t = getIntent().getLongExtra("group_id", -1L);
    FqlGetProfile.b(this, this.t);
    v();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupMemberListActivity
 * JD-Core Version:    0.6.0
 */