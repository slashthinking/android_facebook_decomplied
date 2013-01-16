package com.facebook.katana.activity.profilelist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.ui.SectionedListView;
import java.util.List;

public class TaggedUsersActivity extends ProfileListActivity
{
  protected List<FacebookProfile> t;

  private void i()
  {
    ((TextView)findViewById(2131296644)).setText(2131362941);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903541);
    this.n = AppSession.a(this, true);
    this.t = getIntent().getParcelableArrayListExtra("profiles");
    this.B = new ProfileListDynamicAdapter(this, this.n.j());
    ((ProfileListDynamicAdapter)this.B).a(this.t);
    ((SectionedListView)m()).setSectionedListAdapter(this.B);
    i();
    this.o = new ProfileListActivity.ProfileListListener(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.TaggedUsersActivity
 * JD-Core Version:    0.6.0
 */