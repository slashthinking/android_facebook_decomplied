package com.facebook.orca.contacts.favorites;

import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.common.ui.widgets.FavoritesDragSortListView;
import com.facebook.orca.contacts.divebar.DivebarCache;
import com.facebook.orca.contacts.divebar.DivebarLoader.Result;
import com.facebook.orca.contacts.divebar.DivebarLoaderFactory;
import com.facebook.orca.contacts.picker.ContactPickerListFilter;
import com.facebook.orca.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.orca.contacts.picker.ContactPickerRows;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.UpdateFavoriteContactsParams;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserFbidIdentifier;
import com.facebook.orca.users.UserIdentifierKey;
import com.facebook.orca.users.UserWithIdentifier;
import com.facebook.widget.DragSortListView.DropListener;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EditFavoritesActivity extends FbFragmentActivity
  implements AnalyticsActivity
{
  private static final Class<?> o = EditFavoritesActivity.class;
  private List<User> A;
  private boolean B = false;
  private DragSortListView.DropListener C = new EditFavoritesActivity.4(this);
  ContactPickerListFilter.RowCreator n;
  private FavoritesEditListAdapter p;
  private FavoriteContactsCache q;
  private DivebarLoaderFactory r;
  private DivebarCache s;
  private AnalyticsLogger t;
  private OrcaServiceOperationFactory u;
  private ListenableFuture<OperationResult> v;
  private DialogBasedProgressIndicator w;
  private FavoritesEditPickerView x;
  private FavoritesDragSortListView y;
  private List<User> z;

  private void a(DivebarLoader.Result paramResult)
  {
    if (paramResult == null);
    while (true)
    {
      return;
      if ((paramResult.a() != null) && (paramResult.b() != null))
      {
        this.z = Lists.a(paramResult.a());
        this.A = Lists.a(paramResult.b());
        n();
      }
      if ((this.z == null) || (paramResult.f()))
        continue;
      h().a(1).p();
    }
  }

  private void a(ServiceException paramServiceException)
  {
    this.t.a(new HoneyClientEvent("update_favorites_failed").h(e()).b("reason", paramServiceException.getMessage()));
    ErrorDialogBuilder.a(this).a(2131362339).b(getString(2131362529)).a(new EditFavoritesActivity.7(this)).a();
  }

  private void a(OperationResult paramOperationResult)
  {
    this.t.a(new HoneyClientEvent("update_favorites_success").h(e()));
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext())
      localBuilder.b((User)localIterator.next());
    this.q.a(localBuilder.b());
    this.B = false;
    finish();
  }

  private void a(User paramUser)
  {
    EditFavoritesActivity.5 local5 = new EditFavoritesActivity.5(this, paramUser);
    new AlertDialog.Builder(this).setMessage(getString(2131362530)).setPositiveButton(getString(2131362171), local5).setNegativeButton(getString(2131362172), local5).show();
  }

  private void b(User paramUser)
  {
    this.z.add(paramUser);
    m();
    n();
    int i = -1 + this.z.size();
    if (i < this.y.getFirstVisiblePosition())
      this.y.smoothScrollToPosition(i);
  }

  private void j()
  {
    h().a(1, null, new EditFavoritesActivity.3(this));
  }

  private void k()
  {
    if (this.B)
      o();
    while (true)
    {
      return;
      finish();
    }
  }

  private ImmutableList<UserIdentifierKey> l()
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext())
      localBuilder.b(((User)localIterator.next()).h().c());
    return localBuilder.b();
  }

  private void m()
  {
    this.B = true;
  }

  private void n()
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    HashSet localHashSet = Sets.a();
    if (this.z.size() == 0)
      localBuilder.b(ContactPickerRows.f);
    Iterator localIterator1 = this.z.iterator();
    while (localIterator1.hasNext())
    {
      User localUser2 = (User)localIterator1.next();
      localHashSet.add(localUser2.c());
      FavoriteContactRow localFavoriteContactRow = new FavoriteContactRow(localUser2);
      localFavoriteContactRow.a(new EditFavoritesActivity.6(this));
      localBuilder.b(localFavoriteContactRow);
    }
    if (this.A != null)
    {
      Iterator localIterator2 = this.A.iterator();
      for (int i = 0; localIterator2.hasNext(); i = i)
      {
        User localUser1 = (User)localIterator2.next();
        if (localHashSet.contains(localUser1.c()))
          continue;
        if (i == 0)
        {
          localBuilder.b(ContactPickerRows.e);
          i = 1;
        }
        localBuilder.b(this.n.a(new UserWithIdentifier(localUser1, localUser1.h())));
      }
    }
    this.p.d().a(l());
    ImmutableList localImmutableList = localBuilder.b();
    this.x.a(localImmutableList);
    this.p.notifyDataSetChanged();
  }

  private void o()
  {
    this.t.a(new HoneyClientEvent("update_favorites").a("favorite_count", this.z.size()).h(e()));
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("favorites", new UpdateFavoriteContactsParams(this.z));
    this.v = this.u.a("update_favorite_contacts", localBundle).d();
    Futures.a(this.v, new EditFavoritesActivity.8(this));
    this.w = new DialogBasedProgressIndicator(this, 2131362528);
    this.w.a();
  }

  public String a()
  {
    return "edit_messaging_favorites";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903339);
    FbInjector localFbInjector = C();
    this.q = ((FavoriteContactsCache)localFbInjector.a(FavoriteContactsCache.class));
    this.r = ((DivebarLoaderFactory)localFbInjector.a(DivebarLoaderFactory.class));
    this.s = ((DivebarCache)localFbInjector.a(DivebarCache.class));
    this.p = ((FavoritesEditListAdapter)localFbInjector.a(FavoritesEditListAdapter.class));
    this.u = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.t = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.x = new FavoritesEditPickerView(this, this.p);
    this.x.setOnDoneClickedListener(new EditFavoritesActivity.1(this));
    this.x.setSearchHint(getString(2131362522));
    ((ViewGroup)f(2131297266)).addView(this.x);
    this.n = new EditFavoritesActivity.2(this);
    this.p.d().a(this.n);
    this.y = this.x.getDraggableList();
    this.y.setDropListener(this.C);
    this.z = Lists.a();
    if (this.q.b() != null)
      this.z = Lists.a(this.q.b());
    ImmutableList localImmutableList = this.s.a();
    if (localImmutableList != null)
      this.A = Lists.a(localImmutableList);
    n();
    j();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.EditFavoritesActivity
 * JD-Core Version:    0.6.0
 */