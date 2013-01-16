package com.facebook.contacts.contactcard;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.annotations.ContextAwareAuthTokenString;
import com.facebook.contacts.contactcard.entry.LabelValueRowView;
import com.facebook.contacts.data.ContactSerialization;
import com.facebook.contacts.models.ContactDetails;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.contacts.models.EntrySection;
import com.facebook.contacts.models.entry.AddressEntry;
import com.facebook.contacts.models.entry.EmailEntry;
import com.facebook.contacts.models.entry.Entry;
import com.facebook.contacts.models.entry.PhoneEntry;
import com.facebook.contacts.protocol.ContactClaimFormatHelper;
import com.facebook.contacts.server.BlockContactParams;
import com.facebook.contacts.server.CreateContactClaimParams;
import com.facebook.contacts.server.DeleteContactClaimParams;
import com.facebook.contacts.server.FetchContactParams;
import com.facebook.contacts.server.FetchContactResult;
import com.facebook.contacts.server.PrivacyParam;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.annotations.IsMergeThreadsEnabled;
import com.facebook.orca.annotations.IsPartialAccount;
import com.facebook.orca.annotations.IsVoipEnabledForUser;
import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.IntentUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.locale.FBLocaleMapper;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public class ContactCardFragment extends OrcaFragment
{
  private static final Class<?> a = ContactCardFragment.class;
  private ContactSerialization Y;
  private OrcaServiceOperationFactory Z;
  private ContactSummary aA;
  private ContactDetails aB;
  private boolean aC;
  private ThreadSummary aD;
  private MessagesCollection aE;
  private boolean aF = false;
  private boolean aG = false;
  private boolean aH = false;
  private OrcaSharedPreferences aa;
  private ListenableFuture<OperationResult> ab;
  private ListenableFuture<OperationResult> ac;
  private ListenableFuture<OperationResult> ad;
  private ListenableFuture<OperationResult> ae;
  private Executor af;
  private UserKey ag;
  private OrcaAppType ah;
  private Button ai;
  private HeaderView aj;
  private EmptyListViewItem ak;
  private ViewGroup al;
  private ViewGroup am;
  private LabelValueRowView an;
  private ViewGroup ao;
  private LabelValueRowView ap;
  private EntrySectionView aq;
  private ConversationSettingsView ar;
  private MapSectionView as;
  private Button at;
  private ViewGroup au;
  private SecureContextHelper av;
  private LabelValueRowView aw;
  private BlockContactDialogFragment.Listener ax;
  private ProgressDialog ay;
  private ContactCardFragment.ContactCardListener az;
  private DataCache b;
  private AnalyticsLogger c;
  private ContactClaimFormatHelper d;
  private Provider<Boolean> e;
  private Provider<Boolean> f;
  private Provider<User> g;
  private Provider<String> h;
  private Provider<Boolean> i;

  private void R()
  {
    BlockContactDialogFragment localBlockContactDialogFragment = (BlockContactDialogFragment)r().a("blockContactDialog");
    if (localBlockContactDialogFragment != null)
      localBlockContactDialogFragment.a(this.ax);
  }

  private void S()
  {
    if (!this.aF);
    for (boolean bool = true; ; bool = false)
    {
      this.aF = bool;
      this.aq.setEditMode(this.aF);
      if (this.az != null)
        this.az.c();
      return;
    }
  }

  private void T()
  {
    boolean bool1 = true;
    Preconditions.checkNotNull(this.ag);
    BLog.c(a, "Updating contact info: " + this.aA + ", " + this.aB);
    label110: boolean bool2;
    label149: label174: int j;
    if (this.aA == ContactSummary.a)
    {
      this.aj.setVisibility(8);
      this.ai.setVisibility(0);
      if ((this.aB == null) || (!this.aB.getHasTimeline()))
        break label266;
      this.am.setVisibility(0);
      this.as.setVisibility(0);
      if ((!((Boolean)this.i.b()).booleanValue()) || (this.ag.a() != User.Type.FACEBOOK))
        break label287;
      this.ao.setVisibility(0);
      if ((this.aA == ContactSummary.a) || (this.ag.a() == User.Type.FACEBOOK))
        break label299;
      bool2 = bool1;
      Button localButton = this.at;
      if (!bool2)
        break label304;
      j = 0;
      label187: localButton.setVisibility(j);
      if (this.aB == null)
        break label311;
      this.aq.setEntrySection(this.aB.getContactInfoSection());
    }
    label266: label287: label299: label304: label311: 
    do
    {
      this.aq.setEditMode(this.aF);
      this.aq.setVisibility(0);
      return;
      this.aj.setContactSummary(this.aA);
      this.aj.setVisibility(0);
      this.ai.setVisibility(8);
      break;
      this.am.setVisibility(8);
      this.as.setVisibility(8);
      break label110;
      this.ao.setVisibility(8);
      break label149;
      bool2 = false;
      break label174;
      j = 8;
      break label187;
    }
    while (this.aA != ContactSummary.a);
    if (this.ag.a() == User.Type.PHONE_NUMBER);
    while (true)
    {
      Preconditions.checkArgument(bool1);
      EntrySection localEntrySection = this.Y.a(this.ag.b());
      this.aq.setEntrySection(localEntrySection);
      break;
      bool1 = false;
    }
  }

  private void U()
  {
    Preconditions.checkNotNull(this.ag);
    if (this.ag.a() == User.Type.PHONE_NUMBER);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      String str = this.ag.b();
      Intent localIntent = new Intent("android.intent.action.INSERT");
      localIntent.setType("vnd.android.cursor.dir/contact");
      localIntent.putExtra("phone", str);
      this.aG = true;
      a(localIntent);
      return;
    }
  }

  private void V()
  {
    String str = this.aA.getLookupKey();
    Preconditions.checkNotNull(str);
    Uri localUri1 = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, Uri.encode(str));
    Uri localUri2 = ContactsContract.Contacts.lookupContact(p().getContentResolver(), localUri1);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(localUri2);
    this.aG = true;
    a(localIntent);
  }

  private void W()
  {
    Preconditions.checkNotNull(this.aA);
    Intent localIntent = new Intent(p(), HiddenEntryPickerActivity.class);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("contact_id", this.aA.getContactId());
    a(localIntent, 21);
  }

  private void X()
  {
    Preconditions.checkNotNull(this.ag);
    boolean bool;
    String str;
    label62: Intent localIntent1;
    Uri.Builder localBuilder;
    if ((this.ag.a() == User.Type.FACEBOOK) || (this.ag.a() == User.Type.FACEBOOK_CONTACT))
    {
      bool = true;
      Preconditions.checkArgument(bool);
      if (this.ag.a() != User.Type.FACEBOOK)
        break label218;
      str = this.ag.b();
      localIntent1 = new Intent("android.intent.action.VIEW", Uri.parse("fb://profile/" + str).buildUpon().build());
      if (IntentUtil.a(p(), localIntent1))
        break label238;
      localBuilder = Uri.parse("http://m.facebook.com/profile.php").buildUpon();
      localBuilder.appendQueryParameter("id", str);
    }
    label218: label238: for (Intent localIntent2 = new Intent("android.intent.action.VIEW", localBuilder.build()); ; localIntent2 = localIntent1)
    {
      if (this.ay == null)
      {
        this.ay = new ProgressDialog(p());
        this.ay.setCancelable(true);
        this.ay.setMessage(e(2131362441));
        this.ay.show();
      }
      a(localIntent2);
      return;
      bool = false;
      break;
      Preconditions.checkNotNull(this.aA);
      str = this.aA.getProfileFbid();
      break label62;
    }
  }

  private void Y()
  {
    if (this.ag.a() == User.Type.FACEBOOK);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      String str = this.ag.b();
      Intent localIntent = new Intent();
      localIntent.setAction("com.facebook.orca.fbwebrtc.intent.action.CALL");
      localIntent.putExtra("CONTACT_ID", Long.parseLong(str));
      this.av.a(localIntent, p());
      return;
    }
  }

  private void Z()
  {
    BlockContactDialogFragment localBlockContactDialogFragment = new BlockContactDialogFragment();
    localBlockContactDialogFragment.a(this.ax);
    localBlockContactDialogFragment.a(r(), "blockContactDialog");
  }

  private void a(HoneyClientEvent paramHoneyClientEvent)
  {
    paramHoneyClientEvent.d("GroupContactCardFragment");
    if (this.aD != null)
      paramHoneyClientEvent.b("thread_id", this.aD.a());
    this.c.a(paramHoneyClientEvent);
  }

  private void a(Entry paramEntry)
  {
    switch (ContactCardFragment.12.a[paramEntry.a().ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      f("dial_phone_number");
      c(((PhoneEntry)paramEntry).getNumber());
      continue;
      f("open_email_client");
      d(((EmailEntry)paramEntry).getEmail());
      continue;
      f("open_address_in_map");
      e(((AddressEntry)paramEntry).getAddress());
    }
  }

  private void a(PhoneEntry paramPhoneEntry)
  {
    Preconditions.checkNotNull(this.aA);
    if (this.ae != null);
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("deleteContactClaimParams", new DeleteContactClaimParams(paramPhoneEntry.getGraphApiWriteId(), this.aA.getGraphApiWriteId(), this.aA.getContactId()));
      OrcaServiceOperationFactory.OrcaServiceOperation localOrcaServiceOperation = this.Z.a("delete_contact_claim", localBundle);
      localOrcaServiceOperation.a(new DialogBasedProgressIndicator(p(), 2131362450));
      this.ae = localOrcaServiceOperation.d();
      Futures.a(this.ae, new ContactCardFragment.9(this));
    }
  }

  private void a(ServiceException paramServiceException)
  {
    BLog.e(a, "Fetching contact failed, error " + paramServiceException);
    a(false);
  }

  private void a(DataFreshnessParam paramDataFreshnessParam)
  {
    Preconditions.checkNotNull(this.ag);
    if (this.ab != null);
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchContactParams", new FetchContactParams(paramDataFreshnessParam, this.ag));
      this.ab = this.Z.a("fetch_contact", localBundle).d();
      Futures.a(this.ab, new ContactCardFragment.8(this));
    }
  }

  private void a(OperationResult paramOperationResult)
  {
    FetchContactResult localFetchContactResult = (FetchContactResult)paramOperationResult.h();
    this.aA = localFetchContactResult.a();
    this.aB = localFetchContactResult.b();
    BLog.c(a, "Fetched contact successfully, result: " + localFetchContactResult);
    if (this.az != null)
      this.az.c();
    T();
    if (localFetchContactResult.e() == DataFreshnessResult.FROM_SERVER)
    {
      BLog.b(a, "Contact fetched from server, done.");
      a(false);
    }
    while (true)
    {
      return;
      if (localFetchContactResult.e() == DataFreshnessResult.FROM_CACHE_INCOMPLETE)
      {
        BLog.b(a, "Got name from cached user, checking for new data...");
        a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
        continue;
      }
      BLog.c(a, "Checking server for new data...");
      a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
      if (this.aB.getContactInfoSection() == null)
        continue;
      a(false);
    }
  }

  private void a(String paramString)
  {
    Preconditions.checkNotNull(this.aA);
    if (this.ad != null);
    while (true)
    {
      return;
      String str = this.d.a(paramString, 1);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("createContactClaimParams", new CreateContactClaimParams(this.aA.getContactId(), this.aA.getGraphApiWriteId(), str, PrivacyParam.b));
      OrcaServiceOperationFactory.OrcaServiceOperation localOrcaServiceOperation = this.Z.a("create_contact_claim", localBundle);
      localOrcaServiceOperation.a(new DialogBasedProgressIndicator(p(), 2131362449));
      this.ad = localOrcaServiceOperation.d();
      Futures.a(this.ad, new ContactCardFragment.10(this));
    }
  }

  private void a(boolean paramBoolean)
  {
    if ((this.ak == null) || (this.al == null));
    while (true)
    {
      return;
      this.ak.a(paramBoolean);
      if (paramBoolean)
      {
        this.ak.setMessage(2131362437);
        this.ak.setVisibility(0);
        this.al.setVisibility(8);
        continue;
      }
      this.ak.setVisibility(8);
      this.al.setVisibility(0);
    }
  }

  private void aa()
  {
    PrefKey localPrefKey = MessagesPrefKeys.a(this.aD.a());
    this.aa.b().a(localPrefKey, NotificationSetting.b.d()).a();
    this.ar.a();
  }

  private void ab()
  {
    Preconditions.checkNotNull(this.ag);
    if (this.ac != null);
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("blockContactParams", new BlockContactParams(this.ag));
      this.ac = this.Z.a("block_contact", localBundle).d();
      Futures.a(this.ac, new ContactCardFragment.11(this), this.af);
    }
  }

  private void ac()
  {
    Uri.Builder localBuilder = Uri.parse("https://m.facebook.com/help/contact/messenger-reporting").buildUpon();
    User localUser = (User)this.g.b();
    localBuilder.appendQueryParameter("cid", this.ah.b());
    localBuilder.appendQueryParameter("auth_token", (String)this.h.b());
    localBuilder.appendQueryParameter("rep", localUser.b());
    localBuilder.appendQueryParameter("resp", this.ag.b());
    localBuilder.appendQueryParameter("locale", FBLocaleMapper.a(Locale.getDefault()));
    Intent localIntent = new Intent("android.intent.action.VIEW", localBuilder.build());
    this.av.b(localIntent, p());
  }

  private boolean ad()
  {
    return ((Boolean)this.f.b()).booleanValue();
  }

  private void c(String paramString)
  {
    String str = "tel:" + paramString;
    Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse(str));
    Context localContext = p();
    if (localContext.getPackageManager().checkPermission("android.permission.CALL_PHONE", localContext.getPackageName()) == 0)
      localIntent = new Intent("android.intent.action.CALL", Uri.parse(str));
    a(localIntent);
  }

  private void d(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString });
    localIntent.setType("plain/text");
    a(Intent.createChooser(localIntent, ""));
  }

  private void e(String paramString)
  {
    Context localContext = p();
    try
    {
      String str = URLEncoder.encode(paramString, "ISO-8859-1");
      paramString = str;
      label17: Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + paramString));
      if (IntentUtil.a(localContext, localIntent))
        a(localIntent);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label17;
    }
  }

  private void f(String paramString)
  {
    a(new HoneyClientEvent("click").e("button").f(paramString));
  }

  public void B()
  {
    super.B();
    O();
    N();
  }

  public boolean L()
  {
    return this.aF;
  }

  public void M()
  {
    if (this.ab != null)
    {
      this.ab.cancel(false);
      this.ab = null;
      this.ag = null;
    }
  }

  public void N()
  {
    if (!this.aH);
    while (true)
    {
      return;
      if (this.aC)
      {
        this.ar.setVisibility(0);
        this.ar.a();
        continue;
      }
      this.ar.setVisibility(8);
    }
  }

  void O()
  {
    if (this.ag == null);
    while (true)
    {
      return;
      if ((this.aG) || (this.aA == null))
      {
        a(true);
        a(DataFreshnessParam.DO_NOT_CHECK_SERVER);
        if (this.az != null)
          this.az.d();
        this.aG = false;
        continue;
      }
      T();
    }
  }

  public void P()
  {
    if (this.aj != null)
    {
      this.aj.setVisibility(8);
      this.aj.a();
    }
    if (this.am != null)
      this.am.setVisibility(8);
    if (this.ao != null)
      this.ao.setVisibility(8);
    if (this.as != null)
    {
      this.as.a();
      this.as.setVisibility(8);
    }
    if (this.ai != null)
      this.ai.setVisibility(8);
    if (this.at != null)
      this.at.setVisibility(8);
    if (this.aq != null)
      this.aq.setVisibility(8);
    this.ag = null;
    M();
    a(true);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903109, paramViewGroup, false);
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 1;
    int k;
    if ((paramInt1 == 21) && (paramInt2 == j))
    {
      k = paramIntent.getIntExtra("entry_position", -1);
      if (k == -1)
        break label75;
    }
    while (true)
    {
      Preconditions.checkArgument(j);
      EntrySection localEntrySection = this.aq.getEntrySection();
      Preconditions.checkNotNull(localEntrySection);
      a(((PhoneEntry)(Entry)localEntrySection.getHiddenEntries().get(k)).getNumber());
      return;
      label75: j = 0;
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null)
    {
      this.ag = UserKey.a(paramBundle.getString("userKey"));
      this.aC = paramBundle.getBoolean("showConversationSettings");
    }
  }

  public void a(ContactCardFragment.ContactCardListener paramContactCardListener)
  {
    this.az = paramContactCardListener;
    if (this.as != null)
    {
      this.as.setContactCardListener(paramContactCardListener);
      this.ar.setContactCardListener(paramContactCardListener);
    }
  }

  public void a(ThreadSummary paramThreadSummary, MessagesCollection paramMessagesCollection)
  {
    if (!this.aH);
    while (true)
    {
      return;
      if ((paramThreadSummary != this.aD) || (paramMessagesCollection != this.aE))
      {
        this.aD = paramThreadSummary;
        this.aE = paramMessagesCollection;
        this.aj.setThreadSummary(paramThreadSummary);
        if (paramThreadSummary != null)
          this.ar.setThreadId(paramThreadSummary.a());
        if ((paramMessagesCollection != null) && (this.ag != null))
        {
          this.as.setMessagesAndUserKey(paramMessagesCollection, this.ag);
          continue;
        }
        this.as.a();
        continue;
      }
    }
  }

  public void a(UserKey paramUserKey, boolean paramBoolean)
  {
    if ((paramUserKey.equals(this.ag)) && (paramBoolean == this.aC));
    do
    {
      return;
      this.ag = paramUserKey;
      this.aC = paramBoolean;
    }
    while (!this.aH);
    ThreadSummary localThreadSummary = this.b.c(paramUserKey);
    if (localThreadSummary != null);
    for (MessagesCollection localMessagesCollection = this.b.c(localThreadSummary.a()); ; localMessagesCollection = null)
    {
      this.aj.setVisibility(8);
      this.aj.a();
      this.aA = null;
      this.aB = null;
      a(localThreadSummary, localMessagesCollection);
      O();
      N();
      break;
    }
  }

  public boolean a()
  {
    if ((this.aA != null) && (this.aA != ContactSummary.a) && (this.aB != null) && (this.ag != null) && (this.ag.a() == User.Type.FACEBOOK) && (((Boolean)this.e.b()).booleanValue()));
    for (int j = 1; ; j = 0)
      return j;
  }

  public void b()
  {
    Preconditions.checkNotNull(this.ag);
    if (this.ag.a() == User.Type.FACEBOOK)
      S();
  }

  public void c()
  {
    if (!this.aF);
    while (true)
    {
      return;
      String str = this.aq.getAddEntryValue();
      if ((str == null) || (str.isEmpty()))
      {
        S();
        continue;
      }
      a(str);
    }
  }

  public void d()
  {
    if (this.aF)
      S();
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    FbInjector localFbInjector = Q();
    this.b = ((DataCache)localFbInjector.a(DataCache.class));
    this.c = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.d = ((ContactClaimFormatHelper)localFbInjector.a(ContactClaimFormatHelper.class));
    this.Y = ((ContactSerialization)localFbInjector.a(ContactSerialization.class));
    this.e = localFbInjector.b(Boolean.class, IsMergeThreadsEnabled.class);
    this.f = localFbInjector.b(Boolean.class, IsPartialAccount.class);
    this.g = localFbInjector.b(User.class, MeUser.class);
    this.h = localFbInjector.b(String.class, ContextAwareAuthTokenString.class);
    this.Z = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.ah = ((OrcaAppType)localFbInjector.a(OrcaAppType.class));
    this.av = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    this.i = localFbInjector.b(Boolean.class, IsVoipEnabledForUser.class);
    this.af = ((Executor)localFbInjector.a(Executor.class, ForUiThread.class));
    this.aa = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.av = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    this.ai = ((Button)g(2131296567));
    this.aj = ((HeaderView)g(2131296566));
    this.ak = ((EmptyListViewItem)g(2131296568));
    this.al = ((ViewGroup)g(2131296569));
    this.ar = ((ConversationSettingsView)g(2131296570));
    this.am = ((ViewGroup)g(2131296571));
    this.an = ((LabelValueRowView)g(2131296572));
    this.ao = ((ViewGroup)g(2131296573));
    this.ap = ((LabelValueRowView)g(2131296574));
    this.aq = ((EntrySectionView)g(2131296575));
    this.as = ((MapSectionView)g(2131296576));
    this.at = ((Button)g(2131296577));
    this.au = ((ViewGroup)g(2131296578));
    this.aw = ((LabelValueRowView)g(2131296579));
    if (this.az != null)
    {
      this.as.setContactCardListener(this.az);
      this.ar.setContactCardListener(this.az);
    }
    this.ak.setBackgroundDrawable(q().getDrawable(2130839055));
    this.ai.setOnClickListener(new ContactCardFragment.1(this));
    this.at.setOnClickListener(new ContactCardFragment.2(this));
    this.an.setLabelText(2131362439);
    this.an.setOnClickListener(new ContactCardFragment.3(this));
    this.ap.setLabelText(2131362440);
    this.ap.setOnClickListener(new ContactCardFragment.4(this));
    this.aw.setLabelText(2131362458);
    this.aw.setOnClickListener(new ContactCardFragment.5(this));
    this.ax = new ContactCardFragment.6(this);
    R();
    this.aq.setEntryListener(new ContactCardFragment.7(this));
    if (ad())
      this.au.setVisibility(0);
    this.aH = true;
    ThreadSummary localThreadSummary = this.b.c(this.ag);
    MessagesCollection localMessagesCollection = null;
    if (localThreadSummary != null)
      localMessagesCollection = this.b.c(localThreadSummary.a());
    a(localThreadSummary, localMessagesCollection);
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.ag == null);
    for (String str = null; ; str = this.ag.c())
    {
      paramBundle.putString("userKey", str);
      paramBundle.putBoolean("showConversationSettings", this.aC);
      return;
    }
  }

  public void g()
  {
    super.g();
    if (this.ay != null)
    {
      this.ay.dismiss();
      this.ay = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.ContactCardFragment
 * JD-Core Version:    0.6.0
 */