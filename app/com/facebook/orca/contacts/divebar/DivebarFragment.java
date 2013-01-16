package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.annotations.ForDivebarList;
import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.annotations.IsDivebarMoreMobileFriendsEnabled;
import com.facebook.orca.annotations.IsDivebarMoreMobileFriendsNewSectionEnabled;
import com.facebook.orca.annotations.IsLastActiveEnabled;
import com.facebook.orca.annotations.IsPartialAccount;
import com.facebook.orca.annotations.ShowOtherContactsDivebar;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.contacts.favorites.FavoriteContactsCache;
import com.facebook.orca.contacts.picker.ContactPickerColorScheme;
import com.facebook.orca.contacts.picker.ContactPickerListFilter;
import com.facebook.orca.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.orca.contacts.picker.ContactPickerRows;
import com.facebook.orca.contacts.picker.ContactPickerSectionHeaderRow;
import com.facebook.orca.contacts.picker.ContactPickerSectionSplitterRow;
import com.facebook.orca.contacts.picker.ContactPickerUserRow;
import com.facebook.orca.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.orca.contacts.picker.ContactPickerUserRow.RowStyle;
import com.facebook.orca.contacts.picker.ContactPickerUserRowBuilder;
import com.facebook.orca.contacts.picker.IContactPickerViewListAdapter;
import com.facebook.orca.contacts.picker.UserComparatorByName;
import com.facebook.orca.contacts.upload.ContactsUploadRunner;
import com.facebook.orca.contacts.upload.ContactsUploadState;
import com.facebook.orca.contacts.upload.ContactsUploadState.Status;
import com.facebook.orca.database.AddressBookPeriodicRunner;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.prefs.MessengerPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.presence.PresenceState;
import com.facebook.orca.users.LastActive;
import com.facebook.orca.users.LastActiveHelper;
import com.facebook.orca.users.LastActiveHelper.LastActiveFormat;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserIdentifier;
import com.facebook.orca.users.UserIdentifier.IdentifierType;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

public class DivebarFragment extends OrcaFragment
{
  private static final Class<?> a = DivebarFragment.class;
  private UserComparatorByName Y;
  private Provider<Boolean> Z;
  private Provider<Boolean> aa;
  private Provider<Boolean> ab;
  private Provider<Boolean> ac;
  private Provider<Boolean> ad;
  private Provider<Boolean> ae;
  private LastActiveHelper af;
  private ContactPickerListFilter.RowCreator ag;
  private ContactsUploadRunner ah;
  private SafeLocalBroadcastReceiver ai;
  private boolean aj;
  private List<User> ak;
  private List<User> al;
  private List<User> am;
  private List<User> an;
  private List<User> ao;
  private long ap = 0L;
  private long aq;
  private int ar = 0;
  private OrcaServiceOperationFactory as;
  private OrcaSharedPreferences at;
  private Clock au;
  private DivebarFragment.FragmentListener av;
  private AddressBookPeriodicRunner b;
  private DivebarPickerView c;
  private IContactPickerViewListAdapter d;
  private DivebarViewListener e;
  private PresenceManager f;
  private DivebarCache g;
  private FavoriteContactsCache h;
  private DivebarLoaderFactory i;

  private LoaderManager.LoaderCallbacks<DivebarLoader.Result> L()
  {
    return new DivebarFragment.4(this);
  }

  private boolean M()
  {
    int k;
    if (((Boolean)this.aa.b()).booleanValue())
      if ((this.ak == null) || (this.al == null) || (this.ao == null))
        k = 1;
    while (true)
    {
      return k;
      k = 0;
      continue;
      int j;
      if (this.ak != null)
      {
        List localList = this.al;
        j = 0;
        if (localList != null);
      }
      else
      {
        j = 1;
      }
      k = j;
    }
  }

  private void N()
  {
    int j = 1;
    long l = this.h.c();
    boolean bool1 = l < 0L;
    int k = 0;
    if (bool1)
    {
      boolean bool2 = l < this.ap;
      k = 0;
      if (bool2)
      {
        ImmutableList localImmutableList = this.h.b();
        k = 0;
        if (localImmutableList != null)
        {
          this.ak = Lists.a(localImmutableList);
          this.ap = l;
          k = j;
        }
      }
    }
    if (a(this.ah.c()));
    while (true)
    {
      if (j != 0)
        R();
      return;
      j = k;
    }
  }

  private void O()
  {
    BLog.b(a, "loadFriends");
    P();
    z().a(0, null, L());
  }

  private void P()
  {
    this.aq = 0L;
    this.ar = 0;
  }

  private void R()
  {
    List localList1 = this.ak;
    List localList2 = this.al;
    List localList3 = this.am;
    List localList4 = this.an;
    List localList5 = this.ao;
    ImmutableList.Builder localBuilder = ImmutableList.e();
    if (this.aj)
      localBuilder.b(ContactPickerRows.c);
    if (M())
    {
      BLog.a(a, "Top friends not loaded; not showing any users in list.");
      ImmutableList localImmutableList2 = localBuilder.b();
      this.c.a(localImmutableList2);
      if (!this.aj)
        this.c.d();
      return;
    }
    HashSet localHashSet = Sets.a();
    int j;
    if ((localList1 != null) && (localList1.size() > 0))
    {
      j = 1;
      if (localList2.size() <= 0)
        break label229;
    }
    label229: for (int k = 1; ; k = 0)
    {
      if ((j == 0) && (k == 0))
        break label235;
      localBuilder.b(ContactPickerRows.b);
      if (localList1 == null)
        break label235;
      Iterator localIterator4 = localList1.iterator();
      while (localIterator4.hasNext())
      {
        User localUser5 = (User)localIterator4.next();
        localBuilder.b(a(new UserWithIdentifier(localUser5, localUser5.h()), ContactPickerUserRow.ContactRowSectionType.FAVORITES));
        localHashSet.add(localUser5.c());
      }
      j = 0;
      break;
    }
    label235: if (j != 0)
      localBuilder.b(new ContactPickerSectionSplitterRow());
    int m = 0;
    if ((m < 15) && (m < localList2.size()))
    {
      User localUser4 = (User)localList2.get(m);
      if (localHashSet.contains(localUser4.c()));
      while (true)
      {
        m++;
        break;
        localBuilder.b(a(new UserWithIdentifier(localUser4, localUser4.h()), ContactPickerUserRow.ContactRowSectionType.TOP_FRIENDS));
        localHashSet.add(localUser4.c());
      }
    }
    ArrayList localArrayList1 = Lists.a();
    ArrayList localArrayList2 = Lists.a();
    if (localList3 != null)
    {
      if (!((Boolean)this.ad.b()).booleanValue())
        break label534;
      localArrayList1.addAll(localList3);
    }
    while (!localArrayList1.isEmpty())
    {
      Collections.sort(localArrayList1, this.Y);
      Iterator localIterator3 = localArrayList1.iterator();
      int i8 = 0;
      while (localIterator3.hasNext())
      {
        User localUser3 = (User)localIterator3.next();
        if (localHashSet.contains(localUser3.c()))
          continue;
        if (i8 == 0)
        {
          localBuilder.b(new ContactPickerSectionHeaderRow(p().getString(2131362533)));
          i8 = 1;
        }
        localBuilder.b(a(new UserWithIdentifier(localUser3, localUser3.h()), ContactPickerUserRow.ContactRowSectionType.UNKNOWN));
        localHashSet.add(localUser3.c());
      }
      label534: localArrayList2.addAll(localList3);
    }
    if (localList4 != null)
      localArrayList2.addAll(localList4);
    if (!localArrayList2.isEmpty())
    {
      Collections.sort(localArrayList2, this.Y);
      Iterator localIterator2 = localArrayList2.iterator();
      int i7 = 0;
      while (localIterator2.hasNext())
      {
        User localUser2 = (User)localIterator2.next();
        if (localHashSet.contains(localUser2.c()))
          continue;
        if (i7 == 0)
        {
          localBuilder.b(new ContactPickerSectionHeaderRow(p().getString(2131362532)));
          i7 = 1;
        }
        localBuilder.b(a(new UserWithIdentifier(localUser2, localUser2.h()), ContactPickerUserRow.ContactRowSectionType.UNKNOWN));
        localHashSet.add(localUser2.c());
      }
    }
    if (localList5 != null)
    {
      Collections.sort(localList5, this.Y);
      Iterator localIterator1 = localList5.iterator();
      int i6 = 0;
      while (localIterator1.hasNext())
      {
        User localUser1 = (User)localIterator1.next();
        if (localHashSet.contains(localUser1.c()))
          continue;
        if (i6 == 0)
        {
          localBuilder.b(new ContactPickerSectionHeaderRow(p().getString(2131362534)));
          i6 = 1;
        }
        UserWithIdentifier localUserWithIdentifier = new UserWithIdentifier(localUser1, localUser1.h());
        localBuilder.b(new ContactPickerUserRowBuilder().a(localUserWithIdentifier).a(ContactPickerUserRow.RowStyle.ONE_LINE).c(true).a(ContactPickerUserRow.ContactRowSectionType.ACTIVE_FRIENDS).a());
        localHashSet.add(localUser1.c());
      }
    }
    if (((Boolean)this.ab.b()).booleanValue())
      localBuilder.b(ContactPickerRows.d);
    ImmutableList localImmutableList1 = localBuilder.b();
    this.c.a(localImmutableList1);
    int n;
    label921: int i1;
    label933: int i2;
    if (localList1 != null)
    {
      n = localList1.size();
      if (localList2 == null)
        break label994;
      i1 = localList2.size();
      i2 = n + i1;
      if (localList3 == null)
        break label1000;
    }
    label994: label1000: for (int i3 = localList3.size(); ; i3 = 0)
    {
      int i4 = i3 + i2;
      int i5 = 0;
      if (localList5 != null)
        i5 = localList5.size();
      f(i4 + i5);
      break;
      n = 0;
      break label921;
      i1 = 0;
      break label933;
    }
  }

  private void S()
  {
    Bundle localBundle = new Bundle();
    this.as.a("contacts_invite_all", localBundle).d();
  }

  private void T()
  {
    OrcaSharedPreferences.Editor localEditor = this.at.b();
    localEditor.a(MessengerPrefKeys.D, true);
    localEditor.a(MessengerPrefKeys.E, this.au.a());
    localEditor.a();
  }

  private void U()
  {
    int j = this.at.a(MessengerPrefKeys.C, 0);
    OrcaSharedPreferences.Editor localEditor = this.at.b();
    localEditor.a(MessengerPrefKeys.C, j + 1);
    localEditor.a(MessengerPrefKeys.B, this.au.a());
    localEditor.a();
  }

  private ContactPickerUserRow a(UserWithIdentifier paramUserWithIdentifier, ContactPickerUserRow.ContactRowSectionType paramContactRowSectionType)
  {
    User localUser = paramUserWithIdentifier.a();
    ContactPickerUserRowBuilder localContactPickerUserRowBuilder;
    String str;
    if (UserIdentifier.IdentifierType.FBID == paramUserWithIdentifier.b().e())
    {
      boolean bool = this.f.a(localUser.c());
      LastActive localLastActive = localUser.B();
      PresenceState localPresenceState = this.f.b(localUser.c());
      localContactPickerUserRowBuilder = new ContactPickerUserRowBuilder().a(paramUserWithIdentifier).a(ContactPickerUserRow.RowStyle.ONE_LINE).a(bool).b(localPresenceState.b()).c(true).a(paramContactRowSectionType);
      if ((((Boolean)this.Z.b()).booleanValue()) && (!bool))
        str = this.af.a(localLastActive, localPresenceState, LastActiveHelper.LastActiveFormat.SHORT);
    }
    for (ContactPickerUserRow localContactPickerUserRow = localContactPickerUserRowBuilder.a(str).a(); ; localContactPickerUserRow = new ContactPickerUserRowBuilder().a(paramUserWithIdentifier).a(ContactPickerUserRow.RowStyle.TWO_LINE).a())
    {
      return localContactPickerUserRow;
      str = null;
      break;
    }
  }

  private void a(DivebarLoader.Result paramResult)
  {
    int j = 1;
    if (!s());
    int k;
    while (true)
    {
      return;
      if (paramResult == null)
        break;
      if ((this.ar != 0) && (this.aq > 0L) && (SystemClock.elapsedRealtime() - this.aq < 2000L))
      {
        BLog.b(a, "Skipping list udpate. user is interacting with list");
        continue;
      }
      ImmutableList localImmutableList = paramResult.b();
      k = 0;
      if (localImmutableList != null)
      {
        this.al = Lists.a(paramResult.b());
        k = j;
      }
      if (paramResult.c() != null)
      {
        this.am = Lists.a(paramResult.c());
        k = j;
      }
      if (paramResult.a() != null)
      {
        this.ak = Lists.a(paramResult.a());
        k = j;
      }
      if (paramResult.e() != null)
      {
        this.an = Lists.a(paramResult.e());
        k = j;
      }
      if (paramResult.d() == null)
        break label245;
      this.ao = Lists.a(paramResult.d());
    }
    while (true)
    {
      if (j != 0)
      {
        BLog.b(a, "updating list with new result from loader");
        R();
      }
      if ((this.al == null) || ((this.am == null) && (this.an == null)) || (paramResult.f()))
        break;
      d();
      BLog.b(a, "Stopped loader with new result=" + paramResult.toString());
      break;
      break;
      label245: j = k;
    }
  }

  private boolean a(ContactsUploadState paramContactsUploadState)
  {
    boolean bool1 = true;
    ContactsUploadState.Status localStatus = paramContactsUploadState.a();
    boolean bool2;
    if ((localStatus == ContactsUploadState.Status.STARTED) || (localStatus == ContactsUploadState.Status.RUNNING))
    {
      bool2 = bool1;
      if (bool2 == this.aj)
        break label47;
      this.aj = bool2;
    }
    while (true)
    {
      return bool1;
      bool2 = false;
      break;
      label47: bool1 = false;
    }
  }

  private void b(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    int j;
    if ("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED".equals(str))
    {
      BLog.b(a, "CONTACTS_UPLOAD_STATE_CHANGED");
      boolean bool2 = u();
      j = 0;
      if (bool2)
      {
        if (a((ContactsUploadState)paramIntent.getParcelableExtra("state")))
          R();
        j = 1;
      }
    }
    while (true)
    {
      if (j != 0)
        a();
      return;
      boolean bool1 = "com.facebook.orca.presence.PRESENCE_MANAGER_SETTINGS_CHANGED".equals(str);
      j = 0;
      if (!bool1)
        continue;
      BLog.b(a, "PRESENCE_MANAGER_SETTINGS_CHANGED");
      j = 1;
    }
  }

  private void d()
  {
    Loader localLoader = z().a(0);
    if (localLoader != null)
    {
      BLog.b(a, "stopping DivebarLoader");
      localLoader.b(null);
      localLoader.p();
    }
  }

  private void f(int paramInt)
  {
    DivebarFragment.5 local5 = new DivebarFragment.5(this);
    DivebarFragment.6 local6 = new DivebarFragment.6(this);
    this.c.a(local5, local6, paramInt);
  }

  public void B()
  {
    super.B();
    N();
  }

  public void C()
  {
    super.C();
    if (this.av != null)
      this.av.a();
  }

  public void D()
  {
    super.D();
    d();
    this.ai.b();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FbInjector localFbInjector = Q();
    this.d = ((IContactPickerViewListAdapter)localFbInjector.a(IContactPickerViewListAdapter.class, ForDivebarList.class));
    this.d.a(ContactPickerColorScheme.DIVEBAR_SCHEME);
    this.d.d().a(this.ag);
    this.c = new DivebarPickerView(p(), this.d);
    this.c.setContactPickerViewListener(this.e);
    this.c.setOnContactListScrollListener(new DivebarFragment.2(this));
    this.ac = localFbInjector.b(Boolean.class, IsDivebarMoreMobileFriendsEnabled.class);
    this.ad = localFbInjector.b(Boolean.class, IsDivebarMoreMobileFriendsNewSectionEnabled.class);
    return this.c;
  }

  public void a()
  {
    if (M())
      this.c.d();
    LoaderManager localLoaderManager = z();
    if (localLoaderManager.a(0) != null)
    {
      d();
      P();
      localLoaderManager.b(0, null, L());
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.ag = new DivebarFragment.1(this);
  }

  public void a(DivebarFragment.FragmentListener paramFragmentListener)
  {
    this.av = paramFragmentListener;
  }

  public void a(DivebarViewListener paramDivebarViewListener)
  {
    this.e = paramDivebarViewListener;
    if (this.c != null)
      this.c.setContactPickerViewListener(this.e);
  }

  public void a(String paramString)
  {
    if (this.c != null)
      this.c.setSearchBoxText(paramString);
  }

  public void b()
  {
    this.c.a();
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    FbInjector localFbInjector = Q();
    this.b = ((AddressBookPeriodicRunner)localFbInjector.a(AddressBookPeriodicRunner.class));
    this.f = ((PresenceManager)localFbInjector.a(PresenceManager.class));
    this.g = ((DivebarCache)localFbInjector.a(DivebarCache.class));
    this.i = ((DivebarLoaderFactory)localFbInjector.a(DivebarLoaderFactory.class));
    this.h = ((FavoriteContactsCache)localFbInjector.a(FavoriteContactsCache.class));
    this.Z = localFbInjector.b(Boolean.class, IsLastActiveEnabled.class);
    this.ae = localFbInjector.b(Boolean.class, IsClientSmsEnabled.class);
    this.aa = localFbInjector.b(Boolean.class, ShowOtherContactsDivebar.class);
    this.ab = localFbInjector.b(Boolean.class, IsPartialAccount.class);
    this.af = ((LastActiveHelper)Q().a(LastActiveHelper.class));
    this.ah = ((ContactsUploadRunner)localFbInjector.a(ContactsUploadRunner.class));
    this.Y = new UserComparatorByName();
    this.as = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.at = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.au = ((Clock)localFbInjector.a(Clock.class));
    if (((Boolean)this.ae.b()).booleanValue())
      this.c.setSearchHint(e(2131362523));
    while (true)
    {
      this.b.b();
      ImmutableList localImmutableList1 = this.h.b();
      if (localImmutableList1 != null)
        this.ak = Lists.a(localImmutableList1);
      ImmutableList localImmutableList2 = this.g.a();
      if (localImmutableList2 != null)
        this.al = Lists.a(localImmutableList2);
      ImmutableList localImmutableList3 = this.g.c();
      if (localImmutableList3 != null)
        this.am = Lists.a(localImmutableList3);
      if (((Boolean)this.ac.b()).booleanValue())
      {
        ImmutableList localImmutableList5 = this.g.d();
        if (localImmutableList5 != null)
          this.an = Lists.a(localImmutableList5);
      }
      ImmutableList localImmutableList4 = this.g.b();
      if (localImmutableList4 != null)
        this.ao = Lists.a(localImmutableList4);
      this.c.d();
      R();
      O();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED");
      localIntentFilter.addAction("com.facebook.orca.presence.PRESENCE_MANAGER_SETTINGS_CHANGED");
      this.ai = new DivebarFragment.3(this, p(), localIntentFilter);
      this.ai.a();
      return;
      this.c.setSearchHint(e(2131362522));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarFragment
 * JD-Core Version:    0.6.0
 */