package com.facebook.orca.intents;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.creation.CreateThreadActivity;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FetchThreadParamsBuilder;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threadview.ThreadViewActivity;
import com.facebook.orca.threadview.ThreadViewUtil;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserFbidIdentifier;
import com.facebook.orca.users.UserKey;
import com.facebook.orca.users.UserWithIdentifier;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Objects;

public class CanonicalThreadHandler extends FbFragmentActivity
  implements AnalyticsActivity
{
  private DataCache n;
  private OrcaServiceFragment o;
  private EmptyListViewItem p;
  private ThreadViewUtil q;
  private UserKey r;

  private void a(ServiceException paramServiceException)
  {
    ErrorDialogBuilder.a(this).a(2131362339).a(this).a(paramServiceException).a();
  }

  private void a(OperationResult paramOperationResult)
  {
    FetchThreadResult localFetchThreadResult = (FetchThreadResult)paramOperationResult.h();
    User localUser = localFetchThreadResult.d();
    ThreadSummary localThreadSummary = localFetchThreadResult.a();
    if (localThreadSummary != null)
    {
      boolean bool = getIntent().getBooleanExtra("focus_compose", false);
      Intent localIntent2 = new Intent(this, ThreadViewActivity.class);
      localIntent2.putExtra("thread_id", localThreadSummary.a());
      localIntent2.putExtra("focus_compose", bool);
      startActivity(localIntent2);
      finish();
    }
    while (true)
    {
      return;
      if (localUser != null)
      {
        Intent localIntent1 = new Intent(this, CreateThreadActivity.class);
        if (Objects.equal(localUser.D(), "page"))
          localIntent1.putExtra("disableContactPicker", true);
        UserFbidIdentifier localUserFbidIdentifier = localUser.h();
        if (localUserFbidIdentifier == null)
          if (localUser.n() != null)
            localIntent1.putExtra("to", new UserWithIdentifier(localUser, localUser.n()));
        while (true)
        {
          localIntent1.putExtra("focus_compose", true);
          startActivity(localIntent1);
          finish();
          break;
          localIntent1.putExtra("to", new UserWithIdentifier(localUser, localUserFbidIdentifier));
        }
      }
      ErrorDialogBuilder.a(this).a(2131362339).a(this).a();
    }
  }

  public String a()
  {
    return "canonical_thread_handler";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903354);
    FbInjector localFbInjector = C();
    this.n = ((DataCache)localFbInjector.a(DataCache.class));
    this.p = ((EmptyListViewItem)f(2131296894));
    this.q = ((ThreadViewUtil)localFbInjector.a(ThreadViewUtil.class));
    Intent localIntent1 = getIntent();
    this.r = UserKey.a(localIntent1.getStringExtra("user_key"));
    if (this.r == null)
      finish();
    while (true)
    {
      return;
      this.o = OrcaServiceFragment.a(this, "fetchCanonicalThread");
      this.o.a(new CanonicalThreadHandler.1(this));
      this.p.setMessage(getString(2131362418));
      this.p.a(true);
      ThreadSummary localThreadSummary = this.n.c(this.r);
      if (localThreadSummary == null)
        continue;
      boolean bool = localIntent1.getBooleanExtra("focus_compose", false);
      Intent localIntent2 = new Intent(this, ThreadViewActivity.class);
      localIntent2.putExtra("thread_id", localThreadSummary.a());
      localIntent2.putExtra("focus_compose", bool);
      startActivity(localIntent2);
      finish();
    }
  }

  protected void onResume()
  {
    super.onResume();
    if (!this.o.a())
    {
      FetchThreadParams localFetchThreadParams = new FetchThreadParamsBuilder().a(DataFreshnessParam.STALE_DATA_OKAY).a(ThreadCriteria.a(this.r)).h();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchThreadParams", localFetchThreadParams);
      this.o.a("fetch_thread", localBundle);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.intents.CanonicalThreadHandler
 * JD-Core Version:    0.6.0
 */