package com.facebook.katana.activity.findfriends;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.common.util.Log;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.model.FacebookPhonebookContactUser;
import com.facebook.katana.service.method.ContactRemoteInfoFetcher;
import com.facebook.katana.service.method.FriendsAddFriend;
import com.facebook.katana.util.GrowthUtils;
import com.facebook.katana.util.PhonebookUtils;
import com.facebook.katana.view.FacebookProgressCircleView;
import com.facebook.katana.view.findfriends.FriendCandidate;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StepAddFriendsActivity extends BaseFacebookActivity
  implements NotNewNavEnabled
{
  private static int A;
  private static final Class<?> n = StepAddFriendsActivity.class;
  private SecureContextHelper B;
  private AnalyticsLogger C;
  private long D;
  private Map<Long, FacebookPhonebookContact> E;
  private Map<Long, FacebookPhonebookContact> F;
  private List<FriendCandidate> G;
  private FriendCandidatesAdapter H;
  private HashMap<String, FriendCandidate> I;
  private PhonebookUtils J;
  private AppSession o;
  private StepAddFriendsActivity.StepAddFriendsListener p;
  private boolean q = true;
  private int r = 0;
  private boolean s = false;
  private float t = 0.0F;
  private float u = 0.0F;
  private float v = 0.0F;
  private int x = 0;
  private int y = 0;
  private int z = 0;

  static
  {
    A = 3201;
  }

  private void A()
  {
    int i = k();
    TitleBarButtonSpecBuilder localTitleBarButtonSpecBuilder = TitleBarButtonSpec.newBuilder();
    if (i <= 0)
    {
      localTitleBarButtonSpecBuilder.b(getString(2131363188));
      ((Button)findViewById(2131296857)).setText(2131363390);
    }
    for (this.s = true; ; this.s = false)
    {
      a(localTitleBarButtonSpecBuilder.i());
      return;
      localTitleBarButtonSpecBuilder.b(getString(2131362175));
      Button localButton = (Button)findViewById(2131296857);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i);
      localButton.setText(getString(2131363442, arrayOfObject));
    }
  }

  private void B()
  {
    if (this.r < 100)
    {
      findViewById(2131296854).setVisibility(4);
      findViewById(2131296858).setVisibility(0);
      ((FacebookProgressCircleView)findViewById(2131296684)).setProgress(this.r);
    }
    while (true)
    {
      return;
      findViewById(2131296854).setVisibility(0);
      findViewById(2131296858).setVisibility(4);
    }
  }

  private void E()
  {
    TextView localTextView = (TextView)findViewById(2131296855);
    int i = F();
    if (i == 0)
    {
      c(0);
      z();
      finish();
      return;
    }
    if (i == 1)
      localTextView.setText(getString(2131363440));
    while (true)
    {
      A();
      break;
      if (i <= 1)
        continue;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i);
      localTextView.setText(getString(2131363441, arrayOfObject));
    }
  }

  private int F()
  {
    if (this.H == null)
      this.H = new FriendCandidatesAdapter(this, 2130903194, this.G);
    this.H.a(this.y);
    GridView localGridView = (GridView)findViewById(2131296856);
    localGridView.setAdapter(this.H);
    localGridView.setNumColumns(this.x);
    localGridView.setColumnWidth(this.y);
    localGridView.setPadding(this.z, localGridView.getPaddingTop(), this.z, localGridView.getPaddingBottom());
    localGridView.setOnItemClickListener(new StepAddFriendsActivity.4(this));
    localGridView.setOnItemSelectedListener(null);
    return this.G.size();
  }

  private void c(int paramInt)
  {
    this.C.a(new FindFriendsAnalyticsEvent("add_friends").i("submitted").c(this.q).b(SystemClock.elapsedRealtime() - this.D).a(this.E.size()).c(this.G.size()).b(paramInt));
  }

  private void e(int paramInt)
  {
    this.r = Math.max(0, Math.min(100, paramInt));
    B();
  }

  private void p()
  {
    a(TitleBarButtonSpec.newBuilder().b(getString(2131363188)).i());
    t().m();
    l();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.t = localDisplayMetrics.widthPixels;
    this.u = TypedValue.applyDimension(1, 160.0F, localDisplayMetrics);
    this.v = TypedValue.applyDimension(1, 1.0F, localDisplayMetrics);
    this.x = 1;
    this.x = (int)FloatMath.ceil((this.t - this.v) / this.u);
    this.y = ((int)(this.t - this.v) / this.x);
    this.z = (((int)this.t - this.x * this.y) / 2);
    this.p = new StepAddFriendsActivity.StepAddFriendsListener(this);
    if (this.r == 0)
      n();
    while (true)
    {
      B();
      return;
      if (this.r != 100)
        continue;
      E();
    }
  }

  private void q()
  {
    if ((s() == 0) && (Boolean.TRUE.equals(Gatekeeper.a(this, "new_android_ci_are_you_sure_dialog"))))
      r();
    while (true)
    {
      return;
      z();
    }
  }

  private void r()
  {
    if (Build.VERSION.SDK_INT >= 14);
    for (AlertDialog.Builder localBuilder = new AlertDialog.Builder(this, 4); ; localBuilder = new AlertDialog.Builder(this))
    {
      localBuilder.setMessage(getString(2131363403));
      StepAddFriendsActivity.1 local1 = new StepAddFriendsActivity.1(this);
      localBuilder.setPositiveButton(getString(2131363404), local1);
      StepAddFriendsActivity.2 local2 = new StepAddFriendsActivity.2(this);
      localBuilder.setNegativeButton(getString(2131363405), local2);
      localBuilder.create().show();
      return;
    }
  }

  private int s()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.G != null)
    {
      Iterator localIterator = this.G.iterator();
      while (localIterator.hasNext())
      {
        FriendCandidate localFriendCandidate = (FriendCandidate)localIterator.next();
        if (!localFriendCandidate.d())
          continue;
        localArrayList.add(Long.valueOf(localFriendCandidate.a.userId));
      }
    }
    Class localClass = n;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(localArrayList.size());
    Log.e(localClass, StringLocaleUtil.a("Sending friend requests to %d users.", arrayOfObject));
    if (localArrayList.size() > 0)
      FriendsAddFriend.a(this.o, this, localArrayList, null);
    c(localArrayList.size());
    return localArrayList.size();
  }

  private void z()
  {
    this.H.a();
    ArrayList localArrayList = new ArrayList(this.F.size());
    Iterator localIterator = this.F.values().iterator();
    while (localIterator.hasNext())
      localArrayList.add(((FacebookPhonebookContact)localIterator.next()).a());
    Intent localIntent = new Intent(this, StepInviteActivity.class);
    localIntent.putStringArrayListExtra("invitee_credentials", localArrayList);
    localIntent.putExtra("is_part_of_nux", this.q);
    ((SecureContextHelper)C().a(SecureContextHelper.class)).a(localIntent, this);
    if (!this.q)
      finish();
  }

  public String a(FriendCandidate paramFriendCandidate)
  {
    int i = getResources().getDisplayMetrics().densityDpi;
    String str1 = paramFriendCandidate.e();
    String str2 = null;
    if (str1 == null)
    {
      if ((i <= 120) || (paramFriendCandidate.a.mLargeImageUrl == null) || (paramFriendCandidate.a.mLargeImageUrl.length() == 0))
        break label100;
      str2 = this.o.c(this, paramFriendCandidate.a.mLargeImageUrl);
      this.I.put(str2, paramFriendCandidate);
    }
    while (true)
    {
      this.I.put(str2, paramFriendCandidate);
      paramFriendCandidate.a(str2);
      return str2;
      label100: String str3 = paramFriendCandidate.a.imageUrl;
      str2 = null;
      if (str3 == null)
        continue;
      int j = paramFriendCandidate.a.imageUrl.length();
      str2 = null;
      if (j == 0)
        continue;
      str2 = this.o.c(this, paramFriendCandidate.a.imageUrl);
      this.I.put(str2, paramFriendCandidate);
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.C = ((AnalyticsLogger)C().a(AnalyticsLogger.class));
    this.J = ((PhonebookUtils)C().a(PhonebookUtils.class));
    this.q = getIntent().getBooleanExtra("is_part_of_nux", true);
    this.C.a(new FindFriendsAnalyticsEvent("add_friends").c(this.q).i("opened"));
    this.D = SystemClock.elapsedRealtime();
    this.o = AppSession.a(this, true);
    this.I = new HashMap();
    this.B = ((SecureContextHelper)C().a(SecureContextHelper.class));
    GrowthUtils.a().i(this);
    setContentView(2130903198);
    p();
  }

  public String i()
  {
    return getString(2131363439);
  }

  public void j()
  {
    if (this.G != null)
    {
      Iterator localIterator = this.G.iterator();
      while (localIterator.hasNext())
        ((FriendCandidate)localIterator.next()).a();
    }
  }

  public int k()
  {
    Iterator localIterator = this.G.iterator();
    int i = 0;
    if (localIterator.hasNext())
      if (!((FriendCandidate)localIterator.next()).d())
        break label47;
    label47: for (int j = i + 1; ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  public void l()
  {
    findViewById(2131296857).setOnClickListener(new StepAddFriendsActivity.3(this));
  }

  protected void m()
  {
    j();
    s();
    z();
  }

  protected void n()
  {
    e(1);
    StepAddFriendsActivity.GetPhoneBookTask localGetPhoneBookTask = new StepAddFriendsActivity.GetPhoneBookTask(this, null);
    Void[] arrayOfVoid = new Void[1];
    arrayOfVoid[0] = ((Void)null);
    localGetPhoneBookTask.execute(arrayOfVoid);
  }

  protected void o()
  {
    e(33);
    new ContactRemoteInfoFetcher(this).a(this.E);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    p();
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.p != null))
      this.p.a();
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  public void onPause()
  {
    if (this.o != null)
      this.o.b(this.p);
    super.onPause();
  }

  public void onResume()
  {
    if (this.o != null)
      this.o.a(this.p);
    super.onResume();
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    q();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepAddFriendsActivity
 * JD-Core Version:    0.6.0
 */