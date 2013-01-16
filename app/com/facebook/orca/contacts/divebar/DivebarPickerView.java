package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil.SmsAddress;
import com.facebook.orca.contacts.picker.ContactPickerAddPhoneOrEmailRow;
import com.facebook.orca.contacts.picker.ContactPickerRow;
import com.facebook.orca.contacts.picker.ContactPickerUserRow;
import com.facebook.orca.contacts.picker.ContactPickerView;
import com.facebook.orca.contacts.picker.ContactPickerView.OnContactListScrollListener;
import com.facebook.orca.contacts.picker.ContactPickerView.OnFilterStateChangedListener;
import com.facebook.orca.contacts.picker.IContactPickerViewListAdapter;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserBuilder;
import com.facebook.orca.users.UserPhoneNumber;
import com.facebook.orca.users.UserWithIdentifier;
import com.facebook.widget.CustomViewGroup;
import com.google.common.collect.ImmutableList;

public class DivebarPickerView extends CustomViewGroup
{
  private final ContactPickerView a;
  private final OrcaPhoneNumberUtil b;
  private final DivebarChatAvailabilityWarning c;
  private DivebarViewListener d;

  public DivebarPickerView(Context paramContext, IContactPickerViewListAdapter paramIContactPickerViewListAdapter)
  {
    super(paramContext);
    this.a = new ContactPickerView(paramContext, paramIContactPickerViewListAdapter, 2130903332);
    this.b = ((OrcaPhoneNumberUtil)getInjector().a(OrcaPhoneNumberUtil.class));
    this.a.setSearchHint(paramContext.getString(2131362522));
    addView(this.a);
    this.c = ((DivebarChatAvailabilityWarning)getView(2131297241));
    this.a.setOnRowClickedListener(new DivebarPickerView.1(this));
    setBackgroundColor(getResources().getColor(2131165412));
  }

  private void a(ContactPickerRow paramContactPickerRow)
  {
    if (this.d != null)
    {
      if (!(paramContactPickerRow instanceof ContactPickerUserRow))
        break label44;
      ContactPickerUserRow localContactPickerUserRow = (ContactPickerUserRow)paramContactPickerRow;
      this.d.a(localContactPickerUserRow.a(), this.a.f(), paramContactPickerRow);
    }
    while (true)
    {
      return;
      label44: if ((paramContactPickerRow instanceof ContactPickerAddPhoneOrEmailRow))
      {
        String str = ((ContactPickerAddPhoneOrEmailRow)paramContactPickerRow).a();
        OrcaPhoneNumberUtil.SmsAddress localSmsAddress = this.b.a(str);
        UserPhoneNumber localUserPhoneNumber = localSmsAddress.a(0);
        UserWithIdentifier localUserWithIdentifier = new UserWithIdentifier(new UserBuilder().a(User.Type.PHONE_NUMBER, localSmsAddress.b()).a(new Name(null, null, localSmsAddress.c())).w(), localUserPhoneNumber);
        this.d.a(localUserWithIdentifier, this.a.f(), paramContactPickerRow);
        continue;
      }
    }
  }

  public void a()
  {
    this.a.b();
  }

  public void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, int paramInt)
  {
    this.a.a(paramOnClickListener1, paramOnClickListener2, paramInt);
  }

  public void a(ImmutableList<ContactPickerRow> paramImmutableList)
  {
    this.a.a(paramImmutableList);
    this.c.a();
  }

  public void b()
  {
    this.a.c();
  }

  public void c()
  {
    this.a.d();
  }

  public void d()
  {
    this.a.e();
  }

  public String getSearchBoxText()
  {
    return this.a.getSearchBoxText();
  }

  public void setContactPickerViewListener(DivebarViewListener paramDivebarViewListener)
  {
    this.d = paramDivebarViewListener;
  }

  public void setOnContactListScrollListener(ContactPickerView.OnContactListScrollListener paramOnContactListScrollListener)
  {
    this.a.setOnContactListScrollListener(paramOnContactListScrollListener);
  }

  public void setOnFilterStateChangedListener(ContactPickerView.OnFilterStateChangedListener paramOnFilterStateChangedListener)
  {
    this.a.setOnFilterStateChangedListener(paramOnFilterStateChangedListener);
  }

  public void setSearchBoxText(String paramString)
  {
    this.a.setSearchBoxText(paramString);
  }

  public void setSearchHint(String paramString)
  {
    this.a.setSearchHint(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarPickerView
 * JD-Core Version:    0.6.0
 */