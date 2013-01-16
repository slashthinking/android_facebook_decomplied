package com.facebook.orca.contacts.picker;

import android.telephony.PhoneNumberUtils;
import com.facebook.orca.common.ui.widgets.CustomFilter.FilterResults;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.users.PhoneUserIterator;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserIdentifier;
import com.facebook.orca.users.UserIdentifier.IdentifierType;
import com.facebook.orca.users.UserKey;
import com.facebook.orca.users.UserPhoneNumber;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;

public class ContactPickerAddressBookFilter extends AbstractContactPickerListFilter
{
  private final Provider<PhoneUserIterator> b;
  private boolean c = true;

  public ContactPickerAddressBookFilter(Provider<PhoneUserIterator> paramProvider)
  {
    this.b = paramProvider;
  }

  private void a(String paramString, Map<UserKey, User> paramMap)
  {
    PhoneUserIterator localPhoneUserIterator = (PhoneUserIterator)this.b.b();
    localPhoneUserIterator.a(paramString, 30);
    try
    {
      while (true)
      {
        User localUser = localPhoneUserIterator.e();
        if (localUser == null)
          break;
        if (!localUser.m())
          continue;
        paramMap.put(localUser.c(), localUser);
      }
    }
    finally
    {
      localPhoneUserIterator.c();
    }
  }

  private void a(List<User> paramList)
  {
    Collections.sort(paramList, new ContactPickerAddressBookFilter.1(this));
  }

  private void a(List<User> paramList, ImmutableList.Builder<ContactPickerRow> paramBuilder)
  {
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      User localUser = (User)localIterator1.next();
      Iterator localIterator2 = localUser.j().iterator();
      while (localIterator2.hasNext())
      {
        UserPhoneNumber localUserPhoneNumber = (UserPhoneNumber)localIterator2.next();
        if (a(localUserPhoneNumber.c()))
          continue;
        paramBuilder.b(this.a.a(new UserWithIdentifier(localUser, localUserPhoneNumber)));
      }
    }
  }

  protected CustomFilter.FilterResults b(CharSequence paramCharSequence)
  {
    Tracer.b(10L);
    Tracer localTracer = Tracer.a("ContactPickerAddressBookFilter.Filtering");
    CustomFilter.FilterResults localFilterResults = new CustomFilter.FilterResults();
    if (paramCharSequence != null);
    try
    {
      String str = paramCharSequence.toString().trim();
      ContactPickerFilterResult localContactPickerFilterResult;
      if (str.length() != 0)
      {
        HashMap localHashMap = Maps.a();
        a(str, localHashMap);
        ArrayList localArrayList = Lists.a(localHashMap.values());
        a(localArrayList);
        ImmutableList.Builder localBuilder = ImmutableList.e();
        if ((this.c) && (PhoneNumberUtils.isWellFormedSmsAddress(str)))
          localBuilder.b(new ContactPickerAddPhoneOrEmailRow(PhoneNumberUtil.convertAlphaCharactersInNumber(str), UserIdentifier.IdentifierType.PHONE));
        a(localArrayList, localBuilder);
        localContactPickerFilterResult = ContactPickerFilterResult.a(paramCharSequence, localBuilder.b());
        localFilterResults.a = localContactPickerFilterResult;
      }
      for (localFilterResults.b = localContactPickerFilterResult.c(); ; localFilterResults.b = -1)
      {
        return localFilterResults;
        str = "";
        break;
        localFilterResults.a = ContactPickerFilterResult.a(paramCharSequence);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        BLog.c("orca:ContactPickerAddressBookFilter", "Exception during filtering", localException);
        localFilterResults.a = ContactPickerFilterResult.b(paramCharSequence);
        localFilterResults.b = 0;
        localTracer.a();
        Tracer.b("orca:ContactPickerAddressBookFilter");
      }
    }
    finally
    {
      localTracer.a();
      Tracer.b("orca:ContactPickerAddressBookFilter");
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerAddressBookFilter
 * JD-Core Version:    0.6.0
 */