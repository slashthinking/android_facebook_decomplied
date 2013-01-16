package com.facebook.orca.contacts.picker;

import com.facebook.orca.common.ui.widgets.CustomFilter.FilterResults;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.users.FacebookUserIterator;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserFbidIdentifier;
import com.facebook.orca.users.UserIdentifier;
import com.facebook.orca.users.UserKey;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;

public class ContactPickerFriendFilter extends AbstractContactPickerListFilter
{
  private final Provider<FacebookUserIterator> b;

  public ContactPickerFriendFilter(Provider<FacebookUserIterator> paramProvider)
  {
    this.b = paramProvider;
  }

  private void a(String paramString, Map<UserKey, User> paramMap)
  {
    FacebookUserIterator localFacebookUserIterator = (FacebookUserIterator)this.b.b();
    localFacebookUserIterator.a(paramString, 30);
    try
    {
      User localUser = localFacebookUserIterator.d();
      if (localUser != null)
        paramMap.put(localUser.c(), localUser);
    }
    finally
    {
      localFacebookUserIterator.e();
    }
  }

  private void a(List<User> paramList)
  {
    Collections.sort(paramList, new ContactPickerFriendFilter.1(this));
  }

  private void a(List<User> paramList, ImmutableList.Builder<ContactPickerRow> paramBuilder)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      User localUser = (User)localIterator.next();
      UserFbidIdentifier localUserFbidIdentifier = localUser.h();
      if (localUserFbidIdentifier == null)
      {
        BLog.b("orca:ContactPickerFriendFilter", "Skipping user with no FBID: " + localUser);
        continue;
      }
      if (a(localUserFbidIdentifier.c()))
        continue;
      paramBuilder.b(this.a.a(new UserWithIdentifier(localUser, localUserFbidIdentifier)));
    }
  }

  protected CustomFilter.FilterResults b(CharSequence paramCharSequence)
  {
    Tracer.b(10L);
    Tracer localTracer = Tracer.a("ContactPickerFriendFilter.Filtering");
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
        BLog.c("orca:ContactPickerFriendFilter", "Exception during filtering", localException);
        localFilterResults.a = ContactPickerFilterResult.b(paramCharSequence);
        localFilterResults.b = 0;
        localTracer.a();
        Tracer.b("orca:ContactPickerFriendFilter");
      }
    }
    finally
    {
      localTracer.a();
      Tracer.b("orca:ContactPickerFriendFilter");
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerFriendFilter
 * JD-Core Version:    0.6.0
 */