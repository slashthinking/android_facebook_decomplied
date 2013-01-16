package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.users.UserIdentifier.IdentifierType;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

public class ContactPickerViewListAdapter extends BaseAdapter
  implements IContactPickerViewListAdapter
{
  private static final Class<?> a = ContactPickerViewListAdapter.class;
  private final Context b;
  private final Provider<? extends ContactPickerListFilter> c;
  private final LayoutInflater d;
  private final OrcaPhoneNumberUtil e;
  private final SecureContextHelper f;
  private final AnalyticsLogger g;
  private ImmutableList<ContactPickerRow> h = ImmutableList.d();
  private ImmutableList<ContactPickerRow> i = ImmutableList.d();
  private ContactPickerListFilter j;
  private ContactPickerColorScheme k = ContactPickerColorScheme.DEFAULT_SCHEME;

  public ContactPickerViewListAdapter(Context paramContext, Provider<? extends ContactPickerListFilter> paramProvider, LayoutInflater paramLayoutInflater, OrcaPhoneNumberUtil paramOrcaPhoneNumberUtil, SecureContextHelper paramSecureContextHelper, AnalyticsLogger paramAnalyticsLogger)
  {
    this.b = paramContext;
    this.c = paramProvider;
    this.d = paramLayoutInflater;
    this.e = paramOrcaPhoneNumberUtil;
    this.f = paramSecureContextHelper;
    this.g = paramAnalyticsLogger;
  }

  private View a(View paramView, ViewGroup paramViewGroup)
  {
    ContactPickerFavoritesSectionHeaderView localContactPickerFavoritesSectionHeaderView = (ContactPickerFavoritesSectionHeaderView)paramView;
    if (localContactPickerFavoritesSectionHeaderView == null)
    {
      localContactPickerFavoritesSectionHeaderView = new ContactPickerFavoritesSectionHeaderView(this.b);
      localContactPickerFavoritesSectionHeaderView.setColorScheme(this.k);
    }
    return localContactPickerFavoritesSectionHeaderView;
  }

  private View a(ContactPickerAddPhoneOrEmailRow paramContactPickerAddPhoneOrEmailRow, View paramView, ViewGroup paramViewGroup)
  {
    ContactPickerAddPhoneOrEmailView localContactPickerAddPhoneOrEmailView = (ContactPickerAddPhoneOrEmailView)paramView;
    if (localContactPickerAddPhoneOrEmailView == null)
    {
      localContactPickerAddPhoneOrEmailView = new ContactPickerAddPhoneOrEmailView(this.b);
      localContactPickerAddPhoneOrEmailView.setColorScheme(this.k);
    }
    Resources localResources = this.b.getResources();
    int m;
    if (paramContactPickerAddPhoneOrEmailRow.b() == UserIdentifier.IdentifierType.EMAIL)
      m = 2131362518;
    for (String str = paramContactPickerAddPhoneOrEmailRow.a(); ; str = this.e.c(paramContactPickerAddPhoneOrEmailRow.a()))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("<b>" + TextUtils.htmlEncode(str) + "</b>");
      localContactPickerAddPhoneOrEmailView.setSpannedText(Html.fromHtml(localResources.getString(m, arrayOfObject)));
      return localContactPickerAddPhoneOrEmailView;
      m = 2131362521;
    }
  }

  private View a(ContactPickerGroupRow paramContactPickerGroupRow, View paramView)
  {
    ContactPickerListGroupItem localContactPickerListGroupItem = (ContactPickerListGroupItem)paramView;
    if (localContactPickerListGroupItem == null)
    {
      localContactPickerListGroupItem = new ContactPickerListGroupItem(this.b);
      localContactPickerListGroupItem.setColorScheme(this.k);
    }
    localContactPickerListGroupItem.setContactRow(paramContactPickerGroupRow);
    return localContactPickerListGroupItem;
  }

  private View a(ContactPickerSectionHeaderRow paramContactPickerSectionHeaderRow, View paramView, ViewGroup paramViewGroup)
  {
    ContactPickerSectionHeaderView localContactPickerSectionHeaderView = (ContactPickerSectionHeaderView)paramView;
    if (localContactPickerSectionHeaderView == null)
    {
      localContactPickerSectionHeaderView = new ContactPickerSectionHeaderView(this.b);
      localContactPickerSectionHeaderView.setColorScheme(this.k);
    }
    localContactPickerSectionHeaderView.setText(paramContactPickerSectionHeaderRow.a());
    return localContactPickerSectionHeaderView;
  }

  private View a(ContactPickerSectionSplitterRow paramContactPickerSectionSplitterRow, View paramView, ViewGroup paramViewGroup)
  {
    ContactPickerSectionSplitterView localContactPickerSectionSplitterView = (ContactPickerSectionSplitterView)paramView;
    if (localContactPickerSectionSplitterView == null)
    {
      localContactPickerSectionSplitterView = new ContactPickerSectionSplitterView(this.b);
      localContactPickerSectionSplitterView.setColorScheme(this.k);
    }
    return localContactPickerSectionSplitterView;
  }

  private View a(ContactPickerUserRow paramContactPickerUserRow, View paramView)
  {
    ContactPickerListItem localContactPickerListItem = (ContactPickerListItem)paramView;
    if (localContactPickerListItem == null)
    {
      localContactPickerListItem = new ContactPickerListItem(this.b);
      localContactPickerListItem.setColorScheme(this.k);
    }
    localContactPickerListItem.setContactRow(paramContactPickerUserRow);
    return localContactPickerListItem;
  }

  private View b(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.d.inflate(2130903328, paramViewGroup, false);
    return paramView;
  }

  private View c(View paramView, ViewGroup paramViewGroup)
  {
    ContactPickerInviteFriendsView localContactPickerInviteFriendsView = (ContactPickerInviteFriendsView)paramView;
    if (localContactPickerInviteFriendsView == null)
      localContactPickerInviteFriendsView = new ContactPickerInviteFriendsView(this.b);
    return localContactPickerInviteFriendsView;
  }

  private View d(View paramView, ViewGroup paramViewGroup)
  {
    ContactPickerProgressView localContactPickerProgressView = (ContactPickerProgressView)paramView;
    if (localContactPickerProgressView == null)
      localContactPickerProgressView = new ContactPickerProgressView(this.b);
    return localContactPickerProgressView;
  }

  public void a(ContactPickerColorScheme paramContactPickerColorScheme)
  {
    this.k = paramContactPickerColorScheme;
  }

  public void a(ImmutableList<ContactPickerRow> paramImmutableList)
  {
    this.h = paramImmutableList;
    this.i = this.h;
    notifyDataSetChanged();
  }

  public void a(CharSequence paramCharSequence, ContactPickerFilterResult paramContactPickerFilterResult)
  {
    Preconditions.checkNotNull(paramContactPickerFilterResult);
    switch (ContactPickerViewListAdapter.2.a[paramContactPickerFilterResult.a().ordinal()])
    {
    default:
      b(ImmutableList.d());
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      b(paramContactPickerFilterResult.d());
      continue;
      e();
    }
  }

  public boolean areAllItemsEnabled()
  {
    return false;
  }

  void b(ImmutableList<ContactPickerRow> paramImmutableList)
  {
    this.i = paramImmutableList;
    if (paramImmutableList.size() > 0)
      notifyDataSetChanged();
    while (true)
    {
      return;
      notifyDataSetInvalidated();
    }
  }

  public ContactPickerListFilter d()
  {
    if (this.j == null)
    {
      this.j = ((ContactPickerListFilter)this.c.b());
      this.j.a(this);
    }
    return this.j;
  }

  public void e()
  {
    this.i = this.h;
    if (this.i.size() > 0)
      notifyDataSetChanged();
    while (true)
    {
      return;
      notifyDataSetInvalidated();
    }
  }

  public int getCount()
  {
    return this.i.size();
  }

  public Filter getFilter()
  {
    return new ContactPickerViewListAdapter.1(this);
  }

  public Object getItem(int paramInt)
  {
    return this.i.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    ContactPickerRow localContactPickerRow = (ContactPickerRow)this.i.get(paramInt);
    int m;
    if ((localContactPickerRow instanceof ContactPickerUserRow))
      m = 1;
    while (true)
    {
      return m;
      if ((localContactPickerRow instanceof ContactPickerGroupRow))
      {
        m = 8;
        continue;
      }
      if ((localContactPickerRow instanceof ContactPickerAddPhoneOrEmailRow))
      {
        m = 2;
        continue;
      }
      if (localContactPickerRow == ContactPickerRows.b)
      {
        m = 5;
        continue;
      }
      if ((localContactPickerRow instanceof ContactPickerSectionHeaderRow))
      {
        m = 3;
        continue;
      }
      if ((localContactPickerRow instanceof ContactPickerSectionSplitterRow))
      {
        m = 4;
        continue;
      }
      if (localContactPickerRow == ContactPickerRows.a)
      {
        m = 0;
        continue;
      }
      if (localContactPickerRow == ContactPickerRows.c)
      {
        m = 6;
        continue;
      }
      if (localContactPickerRow != ContactPickerRows.d)
        break;
      m = 7;
    }
    throw new IllegalArgumentException("Unknown object type " + localContactPickerRow.getClass());
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ContactPickerRow localContactPickerRow = (ContactPickerRow)this.i.get(paramInt);
    View localView;
    if ((localContactPickerRow instanceof ContactPickerUserRow))
      localView = a((ContactPickerUserRow)localContactPickerRow, paramView);
    while (true)
    {
      return localView;
      if ((localContactPickerRow instanceof ContactPickerGroupRow))
      {
        localView = a((ContactPickerGroupRow)localContactPickerRow, paramView);
        continue;
      }
      if ((localContactPickerRow instanceof ContactPickerAddPhoneOrEmailRow))
      {
        localView = a((ContactPickerAddPhoneOrEmailRow)localContactPickerRow, paramView, paramViewGroup);
        continue;
      }
      if (localContactPickerRow == ContactPickerRows.b)
      {
        localView = a(paramView, paramViewGroup);
        continue;
      }
      if ((localContactPickerRow instanceof ContactPickerSectionHeaderRow))
      {
        localView = a((ContactPickerSectionHeaderRow)localContactPickerRow, paramView, paramViewGroup);
        continue;
      }
      if ((localContactPickerRow instanceof ContactPickerSectionSplitterRow))
      {
        localView = a((ContactPickerSectionSplitterRow)localContactPickerRow, paramView, paramViewGroup);
        continue;
      }
      if (localContactPickerRow == ContactPickerRows.a)
      {
        localView = b(paramView, paramViewGroup);
        continue;
      }
      if (localContactPickerRow == ContactPickerRows.c)
      {
        localView = d(paramView, paramViewGroup);
        continue;
      }
      if (localContactPickerRow != ContactPickerRows.d)
        break;
      localView = c(paramView, paramViewGroup);
    }
    throw new IllegalArgumentException("Unknown object type " + localContactPickerRow.getClass());
  }

  public int getViewTypeCount()
  {
    return 9;
  }

  public boolean isEnabled(int paramInt)
  {
    if ((getItem(paramInt) instanceof ContactPickerSectionHeaderRow));
    for (int m = 0; ; m = 1)
      return m;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerViewListAdapter
 * JD-Core Version:    0.6.0
 */