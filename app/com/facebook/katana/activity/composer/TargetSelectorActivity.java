package com.facebook.katana.activity.composer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.katana.activity.BaseFacebookListActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.activity.profilelist.FriendSingleSelectorActivity;
import com.facebook.katana.activity.profilelist.GroupSelectorActivity;
import com.facebook.katana.activity.profilelist.PageSelectorActivity;
import com.facebook.katana.features.composer.TargetAdapter;
import com.facebook.orca.inject.FbInjector;

public class TargetSelectorActivity extends BaseFacebookListActivity
  implements NotNewNavEnabled
{
  private void j()
  {
    setContentView(2130903577);
    TargetAdapter localTargetAdapter = (TargetAdapter)C().a(TargetAdapter.class);
    localTargetAdapter.a(getIntent().getIntExtra("post_target", 0));
    a(localTargetAdapter);
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    j();
  }

  protected void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    TargetSelectorActivity.Target localTarget = (TargetSelectorActivity.Target)n().getItem(paramInt);
    switch (TargetSelectorActivity.1.a[localTarget.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return;
      setResult(-1, new Intent().putExtra("post_target", localTarget.ordinal()));
      finish();
      continue;
      startActivityForResult(new Intent(this, FriendSingleSelectorActivity.class), localTarget.ordinal());
      continue;
      startActivityForResult(new Intent(this, GroupSelectorActivity.class), localTarget.ordinal());
      continue;
      startActivityForResult(new Intent(this, PageSelectorActivity.class), localTarget.ordinal());
    }
  }

  public String i()
  {
    return getString(2131362550);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null);
    for (Intent localIntent = new Intent(paramIntent); ; localIntent = new Intent())
    {
      localIntent.putExtra("post_target", paramInt1);
      setResult(paramInt2, localIntent);
      finish();
      return;
    }
  }

  public void onBackPressed()
  {
    setResult(0);
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.TargetSelectorActivity
 * JD-Core Version:    0.6.0
 */