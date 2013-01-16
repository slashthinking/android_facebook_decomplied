package com.facebook.orca.contacts.picker;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil.SmsAddress;
import com.facebook.orca.compose.ComposeMode;
import com.facebook.orca.database.AddressBookPeriodicRunner;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserBuilder;
import com.facebook.orca.users.UserIdentifier;
import com.facebook.orca.users.UserIdentifier.IdentifierType;
import com.facebook.orca.users.UserIdentifierKey;
import com.facebook.orca.users.UserPhoneNumber;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public class ContactPickerFragment extends OrcaFragment
{
  private static final Class<?> a = ContactPickerFragment.class;
  private AddressBookPeriodicRunner Y;
  private UserIdentifier.IdentifierType Z = null;
  private boolean aa = true;
  private IContactPickerViewListAdapter b;
  private ContactPickerFragment.OnPrimaryContactTypeChangedListener c;
  private View d;
  private TextView e;
  private ContactAutoCompleteTextView f;
  private TextView g;
  private ImmutableList<UserIdentifierKey> h;
  private OrcaPhoneNumberUtil i;

  private PickedUserSpan[] M()
  {
    Editable localEditable = this.f.getEditableText();
    return (PickedUserSpan[])localEditable.getSpans(0, localEditable.length(), PickedUserSpan.class);
  }

  private void N()
  {
    this.b.a(ImmutableList.d());
    this.f.setAdapter(new ContactPickerHackListAdapter(this.b));
    this.f.setTextKeepState(this.f.getText());
    this.b.d().a(b());
  }

  private void a(UserIdentifier.IdentifierType paramIdentifierType)
  {
    if ((!Objects.equal(paramIdentifierType, this.Z)) && (this.c != null))
    {
      this.Z = paramIdentifierType;
      this.c.a(paramIdentifierType);
    }
  }

  private void f(int paramInt)
  {
    Object localObject = this.b.getItem(paramInt);
    if ((localObject instanceof ContactPickerUserRow))
    {
      UserWithIdentifier localUserWithIdentifier2 = ((ContactPickerUserRow)localObject).a();
      this.f.a(localUserWithIdentifier2);
    }
    while (true)
    {
      return;
      if ((localObject instanceof ContactPickerAddPhoneOrEmailRow))
      {
        String str = ((ContactPickerAddPhoneOrEmailRow)localObject).a();
        OrcaPhoneNumberUtil.SmsAddress localSmsAddress = this.i.a(str);
        UserPhoneNumber localUserPhoneNumber = localSmsAddress.a(0);
        UserWithIdentifier localUserWithIdentifier1 = new UserWithIdentifier(new UserBuilder().a(User.Type.PHONE_NUMBER, localSmsAddress.b()).a(new Name(null, null, localSmsAddress.c())).w(), localUserPhoneNumber);
        this.f.a(localUserWithIdentifier1);
        continue;
      }
    }
  }

  public void B()
  {
    super.B();
    if (this.aa)
    {
      N();
      this.f.requestFocus();
    }
  }

  public void C()
  {
    super.C();
    this.aa = this.f.isPopupShowing();
  }

  void L()
  {
    if ((this.h != null) && (!this.h.isEmpty()))
    {
      ImmutableList.Builder localBuilder = ImmutableList.e();
      localBuilder.b(b());
      localBuilder.b(this.h);
      this.b.d().a(localBuilder.b());
      ImmutableList localImmutableList = a();
      if (localImmutableList.size() <= 0)
        break label109;
      a(((UserWithIdentifier)localImmutableList.get(0)).b().e());
    }
    while (true)
    {
      return;
      this.b.d().a(b());
      break;
      label109: a(null);
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.d = paramLayoutInflater.inflate(2130903322, paramViewGroup, false);
    this.e = ((TextView)a(this.d, 2131297215));
    this.f = ((ContactAutoCompleteTextView)a(this.d, 2131297216));
    this.g = ((TextView)a(this.d, 2131297220));
    return this.d;
  }

  public ImmutableList<UserWithIdentifier> a()
  {
    PickedUserSpan[] arrayOfPickedUserSpan = M();
    ImmutableList.Builder localBuilder = ImmutableList.e();
    int j = arrayOfPickedUserSpan.length;
    for (int k = 0; k < j; k++)
      localBuilder.b(arrayOfPickedUserSpan[k].a());
    return localBuilder.b();
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = Q();
    this.i = ((OrcaPhoneNumberUtil)localFbInjector.a(OrcaPhoneNumberUtil.class));
    this.Y = ((AddressBookPeriodicRunner)localFbInjector.a(AddressBookPeriodicRunner.class));
    this.Y.b();
    if (paramBundle != null)
      this.aa = paramBundle.getBoolean("selectionOnResume", true);
  }

  public void a(ComposeMode paramComposeMode)
  {
    if (paramComposeMode == ComposeMode.SHRUNK)
      this.f.requestFocus();
  }

  public void a(ContactPickerFragment.Mode paramMode)
  {
    if (paramMode == ContactPickerFragment.Mode.CREATE_THREAD)
    {
      this.e.setText(2131362519);
      this.g.setVisibility(8);
    }
    while (true)
    {
      return;
      this.e.setText(2131362520);
      this.g.setVisibility(0);
    }
  }

  public void a(ContactPickerFragment.OnPrimaryContactTypeChangedListener paramOnPrimaryContactTypeChangedListener)
  {
    this.c = paramOnPrimaryContactTypeChangedListener;
  }

  public void a(IContactPickerViewListAdapter paramIContactPickerViewListAdapter)
  {
    this.b = paramIContactPickerViewListAdapter;
    N();
  }

  public void a(UserWithIdentifier paramUserWithIdentifier)
  {
    this.f.a(paramUserWithIdentifier);
  }

  public void a(ImmutableList<UserIdentifierKey> paramImmutableList)
  {
    this.h = paramImmutableList;
  }

  public void a(String paramString)
  {
    this.f.setHint(paramString);
  }

  public ImmutableList<UserIdentifierKey> b()
  {
    PickedUserSpan[] arrayOfPickedUserSpan = M();
    ImmutableList.Builder localBuilder = ImmutableList.e();
    int j = arrayOfPickedUserSpan.length;
    for (int k = 0; k < j; k++)
      localBuilder.b(arrayOfPickedUserSpan[k].a().b().c());
    return localBuilder.b();
  }

  public UserIdentifier.IdentifierType c()
  {
    return this.Z;
  }

  public void d()
  {
    this.f.setEnabled(false);
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.f.setOnItemClickListener(new ContactPickerFragment.1(this));
    this.f.addTextChangedListener(new ContactPickerFragment.2(this));
  }

  public void e(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.putBoolean("selectionOnResume", this.aa);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerFragment
 * JD-Core Version:    0.6.0
 */