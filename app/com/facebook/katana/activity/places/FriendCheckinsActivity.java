package com.facebook.katana.activity.places;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.common.util.Log;
import com.facebook.ipc.katana.model.FacebookPage;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.activity.BaseFacebookListActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.activity.media.PhotoGalleryActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookCheckin;
import com.facebook.katana.model.FacebookCheckinDetails;
import com.facebook.katana.ui.SectionedListView;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;

public class FriendCheckinsActivity extends BaseFacebookListActivity
  implements AdapterView.OnItemClickListener, AnalyticsActivity
{
  private static final Class<?> n = FriendCheckinsActivity.class;
  private static final String o = n.getSimpleName();
  private AppSession p;
  private FriendCheckinsAdapter q;
  private AppSessionListener r;
  private boolean s;
  private boolean t;
  private String u;

  private void d(boolean paramBoolean)
  {
    TextView localTextView = (TextView)findViewById(2131296644);
    if (this.s)
    {
      localTextView.setText(2131363322);
      a(TitleBarButtonSpec.newBuilder().b(2130837692).i());
      t().a(this.t);
      if (!this.t)
        break label82;
      findViewById(2131296645).setVisibility(0);
      localTextView.setVisibility(8);
    }
    while (true)
    {
      return;
      localTextView.setText(2131362935);
      break;
      label82: if (paramBoolean)
        continue;
      findViewById(2131296645).setVisibility(8);
      localTextView.setVisibility(0);
    }
  }

  private void j()
  {
    setContentView(2130903229);
    k();
    SectionedListView localSectionedListView = (SectionedListView)m();
    localSectionedListView.setDividerHeight(0);
    localSectionedListView.setSectionedListAdapter(this.q);
    localSectionedListView.setEmptyView(findViewById(16908292));
    localSectionedListView.setOnItemClickListener(this);
  }

  private void k()
  {
    d(false);
  }

  public String a()
  {
    return FB4A_AnalyticEntities.g;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.p = AppSession.b(this, true);
    this.q = new FriendCheckinsAdapter(this, this.p.k());
    this.r = new FriendCheckinsActivity.FriendCheckinsListener(this, null);
    j();
  }

  void i()
  {
    this.t = true;
    d(false);
    this.p.g(this);
    v();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    paramMenu.add(0, 2, 0, 2131363208).setIcon(2130838829);
    return true;
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    FacebookCheckin localFacebookCheckin = (FacebookCheckin)this.q.e(paramInt);
    if (localFacebookCheckin.a().b() != null)
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(localFacebookCheckin.a().a().a().mUrl)));
    while (true)
    {
      return;
      if (localFacebookCheckin.a().mType.equals("photo"))
      {
        startActivity(PhotoGalleryActivity.a(this, localFacebookCheckin.a().mCheckinId));
        continue;
      }
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localFacebookCheckin.c();
      startActivity(IntentUriHandler.a(this, StringLocaleUtil.a("fb://post/%s", arrayOfObject)));
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2:
    }
    for (boolean bool = super.onOptionsItemSelected(paramMenuItem); ; bool = true)
    {
      return bool;
      i();
    }
  }

  protected void onPause()
  {
    super.onPause();
    if ((this.p != null) && (this.r != null))
      this.p.b(this.r);
    if (this.q != null)
      this.q.f();
  }

  protected void onResume()
  {
    super.onResume();
    this.p = AppSession.b(this, true);
    if (this.p == null)
    {
      Log.a(o, "Invalid session");
      finish();
    }
    while (true)
    {
      return;
      this.p.a(this.r);
      Boolean localBoolean = Gatekeeper.a(this, "places");
      if ((localBoolean != null) && (localBoolean.booleanValue() == true))
      {
        this.s = true;
        i();
        this.q.e();
        continue;
      }
      this.s = false;
      this.t = false;
      d(false);
    }
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("extra_is_checkin", true);
    a(null, localBundle, Integer.valueOf(10), -1L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.FriendCheckinsActivity
 * JD-Core Version:    0.6.0
 */