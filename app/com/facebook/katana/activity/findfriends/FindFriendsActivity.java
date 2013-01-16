package com.facebook.katana.activity.findfriends;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.activity.profilelist.ProfileListActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ProfileImagesCache;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.model.FacebookPhonebookContactUser;
import com.facebook.katana.service.method.ContactRemoteInfoFetcher;
import com.facebook.katana.service.method.FriendsAddFriend;
import com.facebook.katana.service.method.UsersInvite;
import com.facebook.katana.ui.SectionedListView;
import com.facebook.katana.util.GrowthUtils;
import com.facebook.katana.util.PhonebookUtils;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.inject.FbInjector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FindFriendsActivity extends ProfileListActivity
  implements NotNewNavEnabled
{
  private List<FacebookPhonebookContactUser> A;
  private ProfileImagesCache C;
  private int D;
  private boolean E = false;
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private PhonebookUtils I;
  private AppSession t;
  private FriendsAdapter u;
  private InvitesAdapter v;
  private Map<Long, FacebookPhonebookContact> y;
  private Map<Long, FacebookPhonebookContact> z;

  private Spanned B()
  {
    SpannableString localSpannableString = new SpannableString(getString(2131363240));
    localSpannableString.setSpan(new FindFriendsActivity.3(this), 0, localSpannableString.length(), 33);
    if (this.D == 1);
    for (Spanned localSpanned = (Spanned)TextUtils.concat(new CharSequence[] { new SpannableString(getString(2131363396) + " "), localSpannableString }); ; localSpanned = (Spanned)TextUtils.concat(new CharSequence[] { new SpannableString(getString(2131363397) + " "), localSpannableString }))
      return localSpanned;
  }

  private Spanned E()
  {
    if (this.D == 1);
    for (Spanned localSpanned = g(this.A.size()); ; localSpanned = g(this.z.size()))
      return localSpanned;
  }

  private Spanned F()
  {
    return new SpannableString(getString(2131363398));
  }

  private Spanned g(int paramInt)
  {
    if (paramInt == 1);
    Object[] arrayOfObject;
    for (SpannableString localSpannableString = new SpannableString(getString(2131363392)); ; localSpannableString = new SpannableString(getString(2131363393, arrayOfObject)))
    {
      return localSpannableString;
      arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
    }
  }

  protected void A()
  {
    new ContactRemoteInfoFetcher(this).a(this.y);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903197);
    this.t = AppSession.a(this, true);
    this.C = this.t.j();
    c(2131363377);
    this.u = new FriendsAdapter(this, new ArrayList(), this.C);
    this.v = new InvitesAdapter(this, new ArrayList(), F());
    this.B = this.u;
    this.o = new FindFriendsActivity.ContactRemoteInfoFetcherListener(this);
    SectionedListView localSectionedListView = (SectionedListView)m();
    localSectionedListView.setSectionedListAdapter(this.u);
    localSectionedListView.setItemsCanFocus(true);
    this.I = ((PhonebookUtils)C().a(PhonebookUtils.class));
    GrowthUtils.a().i(this);
  }

  public void a(List<Long> paramList)
  {
    if (!paramList.isEmpty())
    {
      FriendsAddFriend.a(this.t, this, paramList, null);
      this.E = true;
    }
    s();
  }

  public void b(List<Long> paramList)
  {
    if (!paramList.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        localArrayList.add(((FacebookPhonebookContact)this.z.get(localLong)).a());
      }
      UsersInvite.a(this.t, this, localArrayList, null, Locale.getDefault().getCountry());
      this.F = true;
    }
    s();
  }

  public String i()
  {
    return getString(2131363374);
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 1:
    case 2:
    }
    while (true)
    {
      return localObject;
      View localView = LayoutInflater.from(this).inflate(2130903202, null);
      TextView localTextView = (TextView)localView.findViewById(2131296867);
      if ((this.E == true) && (this.F == true))
        localTextView.setText(2131363380);
      while (true)
      {
        FindFriendsActivity.4 local4 = new FindFriendsActivity.4(this);
        ((Button)localView.findViewById(2131296868)).setOnClickListener(local4);
        localObject = new AlertDialog.Builder(new ContextThemeWrapper(this, 2131492967)).setCancelable(false).setView(localView).setInverseBackgroundForced(true).create();
        break;
        if (this.E == true)
        {
          localTextView.setText(2131363379);
          continue;
        }
        if (this.F != true)
          continue;
        localTextView.setText(2131363378);
      }
      localObject = new AlertDialog.Builder(this).setCancelable(true).setMessage(2131363402).setPositiveButton(2131361888, new FindFriendsActivity.5(this)).create();
    }
  }

  public void onResume()
  {
    super.onResume();
    z();
  }

  public void p()
  {
    this.D = 1;
    this.B = this.u;
    ((SectionedListView)m()).setSectionedListAdapter(this.u);
    ((TextView)findViewById(2131296851)).setText(2131363376);
    TextView localTextView = (TextView)findViewById(2131296852);
    localTextView.setText(E());
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    FindFriendsActivity.1 local1 = new FindFriendsActivity.1(this);
    Button localButton = (Button)findViewById(2131296853);
    localButton.setText(2131363390);
    localButton.setOnClickListener(local1);
    TitleBarButtonSpecBuilder localTitleBarButtonSpecBuilder;
    if (this.G)
    {
      localButton.setVisibility(8);
      localTitleBarButtonSpecBuilder = TitleBarButtonSpec.newBuilder();
      if (!this.v.d())
        break label164;
      localTitleBarButtonSpecBuilder.b(getString(2131362910));
    }
    while (true)
    {
      a(localTitleBarButtonSpecBuilder.i());
      r();
      return;
      localButton.setVisibility(0);
      break;
      label164: localTitleBarButtonSpecBuilder.b(getString(2131362175));
    }
  }

  public void q()
  {
    this.D = 2;
    c(false);
    this.B = this.v;
    ((SectionedListView)m()).setSectionedListAdapter(this.v);
    a(TitleBarButtonSpec.newBuilder().b(getString(2131362910)).i());
    if (this.z.size() == 0)
      return;
    ((TextView)findViewById(2131296851)).setText(2131363375);
    TextView localTextView = (TextView)findViewById(2131296852);
    localTextView.setText(E());
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    FindFriendsActivity.2 local2 = new FindFriendsActivity.2(this);
    Button localButton = (Button)findViewById(2131296853);
    localButton.setText(2131363391);
    localButton.setOnClickListener(local2);
    if (this.H)
      localButton.setVisibility(8);
    while (true)
    {
      r();
      break;
      localButton.setVisibility(0);
    }
  }

  public void r()
  {
    ((Button)findViewById(2131296341)).setVisibility(0);
    ((LinearLayout)findViewById(2131296850)).setVisibility(0);
  }

  public void s()
  {
    if ((this.D == 1) && (!this.v.d()))
      q();
    while (true)
    {
      return;
      if ((this.E == true) || (this.F == true))
      {
        showDialog(1);
        continue;
      }
      finish();
    }
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    if (this.D == 2)
      if (this.H)
        b(this.v.g());
    while (true)
    {
      return;
      b(this.v.f());
      continue;
      if (this.G)
      {
        a(this.u.g());
        continue;
      }
      a(this.u.f());
    }
  }

  protected void z()
  {
    if (this.y == null)
    {
      FindFriendsActivity.GetPhoneBookTask localGetPhoneBookTask = new FindFriendsActivity.GetPhoneBookTask(this, null);
      Void[] arrayOfVoid = new Void[1];
      arrayOfVoid[0] = ((Void)null);
      localGetPhoneBookTask.execute(arrayOfVoid);
    }
    while (true)
    {
      return;
      A();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.FindFriendsActivity
 * JD-Core Version:    0.6.0
 */