package com.facebook.orca.threadview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.annotations.ForFacebookList;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.contacts.picker.ContactPickerFragment;
import com.facebook.orca.contacts.picker.ContactPickerFragment.Mode;
import com.facebook.orca.contacts.picker.ContactPickerListFilter;
import com.facebook.orca.contacts.picker.IContactPickerViewListAdapter;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.server.AddMembersParams;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserFbidIdentifier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddMembersActivity extends FbFragmentActivity
  implements AnalyticsActivity
{
  private static final Class<?> n = AddMembersActivity.class;
  private DataCache o;
  private PresenceManager p;
  private FragmentManager q;
  private InputMethodManager r;
  private ThreadViewTitleHelper s;
  private AnalyticsLogger t;
  private FbTitleBar u;
  private Button v;
  private ContactPickerFragment w;
  private ThreadSummary x;
  private OrcaServiceFragment y;

  private void j()
  {
    if (this.y.b() != OrcaServiceOperation.State.INIT);
    while (true)
    {
      return;
      ImmutableList localImmutableList = this.w.a();
      if (localImmutableList.isEmpty())
      {
        ErrorDialogBuilder.a(this).a(2131362339).b(2131362479).a();
        continue;
      }
      this.r.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
      AddMembersParams localAddMembersParams = new AddMembersParams(this.x.a(), localImmutableList);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("addMembersParams", localAddMembersParams);
      this.y.a("add_members", localBundle);
      this.t.a(new HoneyClientEvent("add_member").b("thread_id", this.x.a()).d(a()).f("add_person"));
    }
  }

  public String a()
  {
    return "add_members";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903310);
    FbInjector localFbInjector = C();
    this.o = ((DataCache)localFbInjector.a(DataCache.class));
    this.p = ((PresenceManager)localFbInjector.a(PresenceManager.class));
    this.q = ((FragmentManager)localFbInjector.a(FragmentManager.class));
    this.r = ((InputMethodManager)localFbInjector.a(InputMethodManager.class));
    this.s = ((ThreadViewTitleHelper)localFbInjector.a(ThreadViewTitleHelper.class));
    this.t = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    FbTitleBarUtil.a(this);
    this.u = ((FbTitleBar)f(2131296299));
    this.v = ((Button)f(2131297178));
    Display localDisplay = getWindow().getWindowManager().getDefaultDisplay();
    if (localDisplay.getWidth() > localDisplay.getHeight());
    String str = getIntent().getStringExtra("thread_id");
    this.x = this.o.b(str);
    if (this.x == null)
      finish();
    while (true)
    {
      return;
      this.s.a(this.u);
      this.s.a(this.x);
      this.w = ((ContactPickerFragment)this.q.a(2131297177));
      this.v.setOnClickListener(new AddMembersActivity.1(this));
      IContactPickerViewListAdapter localIContactPickerViewListAdapter = (IContactPickerViewListAdapter)localFbInjector.a(IContactPickerViewListAdapter.class, ForFacebookList.class);
      AddMembersActivity.2 local2 = new AddMembersActivity.2(this);
      localIContactPickerViewListAdapter.d().a(local2);
      this.w.a(localIContactPickerViewListAdapter);
      this.w.a(ContactPickerFragment.Mode.ADD_MEMBERS);
      this.w.a(getString(2131362522));
      ArrayList localArrayList = Lists.a();
      Iterator localIterator = this.x.i().iterator();
      while (localIterator.hasNext())
      {
        ThreadParticipant localThreadParticipant = (ThreadParticipant)localIterator.next();
        if (!localThreadParticipant.b())
          continue;
        User localUser = this.o.a(localThreadParticipant.d());
        if (localUser == null)
          continue;
        localArrayList.add(localUser.h().c());
      }
      this.w.a(ImmutableList.a(localArrayList));
      this.y = OrcaServiceFragment.a(this, "addMembersOperation");
      this.y.a(new AddMembersActivity.3(this));
      this.y.a(new DialogBasedProgressIndicator(this, 2131362480));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.AddMembersActivity
 * JD-Core Version:    0.6.0
 */