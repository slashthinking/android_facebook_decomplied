package com.facebook.orca.threadlist;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadListParamsBuilder;
import com.facebook.orca.server.FetchThreadListResult;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.FolderType;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.widget.listview.EmptyListViewItem;
import javax.inject.Provider;

public class ThreadChooserDialog extends Dialog
{
  public static final String a = new String("NEW_THREAD");
  private final ThreadListAdapter b;
  private final DataCache c;
  private final OrcaServiceOperation d;
  private final Provider<FolderType> e;
  private String f;
  private ListView g;
  private EmptyListViewItem h;
  private ThreadsCollection i = ThreadsCollection.a();
  private ThreadChooserDialog.OnDialogFinishedListener j;
  private String k;

  public ThreadChooserDialog(Context paramContext, ThreadListAdapter paramThreadListAdapter, DataCache paramDataCache, OrcaServiceOperation paramOrcaServiceOperation, Provider<FolderType> paramProvider)
  {
    super(paramContext);
    this.b = paramThreadListAdapter;
    this.c = paramDataCache;
    this.d = paramOrcaServiceOperation;
    this.e = paramProvider;
  }

  private void a()
  {
    FolderName localFolderName = b();
    if (this.c.a(localFolderName))
    {
      this.i = this.c.b(localFolderName);
      c();
    }
    while (true)
    {
      return;
      a(DataFreshnessParam.STALE_DATA_OKAY);
    }
  }

  private void a(int paramInt)
  {
    Object localObject = this.b.getItem(paramInt);
    if (localObject == ThreadListAdapter.b)
      this.k = a;
    while (true)
    {
      dismiss();
      return;
      if (!(localObject instanceof ThreadSummary))
        continue;
      this.k = ((ThreadSummary)localObject).a();
    }
  }

  private void a(ServiceException paramServiceException)
  {
    this.h.setMessage(null);
    this.h.a(false);
  }

  private void a(DataFreshnessParam paramDataFreshnessParam)
  {
    if (this.d.b());
    while (true)
    {
      return;
      FolderName localFolderName = b();
      FetchThreadListParams localFetchThreadListParams = FetchThreadListParams.newBuilder().a(paramDataFreshnessParam).a(localFolderName).f();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchThreadListParams", localFetchThreadListParams);
      this.d.a("fetch_thread_list", localBundle);
      this.h.setMessage(getContext().getResources().getString(2131362418));
      this.h.a(true);
    }
  }

  private void a(OperationResult paramOperationResult)
  {
    this.i = ((FetchThreadListResult)paramOperationResult.h()).b();
    c();
  }

  private FolderName b()
  {
    return FolderName.a((FolderType)this.e.b());
  }

  private void c()
  {
    this.b.a(this.i.b());
    this.h.setMessage(getContext().getResources().getString(2131362421));
    this.h.a(false);
    EmptyListViewItem localEmptyListViewItem = this.h;
    boolean bool = this.i.d();
    int m = 0;
    if (bool);
    while (true)
    {
      localEmptyListViewItem.setVisibility(m);
      return;
      m = 8;
    }
  }

  public void a(ThreadChooserDialog.OnDialogFinishedListener paramOnDialogFinishedListener)
  {
    this.j = paramOnDialogFinishedListener;
  }

  public void a(String paramString)
  {
    this.f = paramString;
  }

  public void b(String paramString)
  {
    this.b.a(paramString);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903404);
    ((TextView)findViewById(2131296686)).setText(this.f);
    this.g = ((ListView)findViewById(2131297439));
    this.h = ((EmptyListViewItem)findViewById(2131297440));
    this.b.a(ThreadListAdapter.Mode.CHOOSE_DIALOG);
    this.g.setAdapter(this.b);
    this.g.setItemsCanFocus(true);
    this.g.setOnItemClickListener(new ThreadChooserDialog.1(this));
    this.d.a(new ThreadChooserDialog.2(this));
    a();
  }

  protected void onStop()
  {
    super.onStop();
    this.d.a(null);
    this.d.a();
    if (this.j != null)
      this.j.a(this.k);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadChooserDialog
 * JD-Core Version:    0.6.0
 */