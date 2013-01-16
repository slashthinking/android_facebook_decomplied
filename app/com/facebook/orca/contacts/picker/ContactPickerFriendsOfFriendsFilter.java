package com.facebook.orca.contacts.picker;

import com.facebook.orca.common.ui.widgets.CustomFilter.FilterResults;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.SearchUsersMethod;
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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ContactPickerFriendsOfFriendsFilter extends AbstractContactPickerListFilter
{
  private final SingleMethodRunner b;
  private final SearchUsersMethod c;

  public ContactPickerFriendsOfFriendsFilter(SingleMethodRunner paramSingleMethodRunner, SearchUsersMethod paramSearchUsersMethod)
  {
    this.b = paramSingleMethodRunner;
    this.c = paramSearchUsersMethod;
  }

  private void a(String paramString, Map<UserKey, User> paramMap)
  {
    if (paramString.length() < 3);
    while (true)
    {
      return;
      try
      {
        Iterator localIterator = ((List)this.b.a(this.c, paramString)).iterator();
        while (localIterator.hasNext())
        {
          User localUser = (User)localIterator.next();
          if (StringUtil.a(localUser.z()))
            continue;
          paramMap.put(localUser.c(), localUser);
        }
      }
      catch (Exception localException)
      {
        BLog.a("orca:ContactPickerFriendsOfFriendsFilter", "Failed to get result", localException);
      }
    }
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
        BLog.b("orca:ContactPickerFriendsOfFriendsFilter", "Skipping user with no FBID: " + localUser);
        continue;
      }
      if (a(localUserFbidIdentifier.c()))
        continue;
      UserWithIdentifier localUserWithIdentifier = new UserWithIdentifier(localUser, localUserFbidIdentifier);
      paramBuilder.b(this.a.a(localUserWithIdentifier));
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
        LinkedHashMap localLinkedHashMap = Maps.b();
        a(str, localLinkedHashMap);
        ArrayList localArrayList = Lists.a(localLinkedHashMap.values());
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
        BLog.c("orca:ContactPickerFriendsOfFriendsFilter", "Exception during filtering", localException);
        localFilterResults.a = ContactPickerFilterResult.b(paramCharSequence);
        localFilterResults.b = 0;
        localTracer.a();
        Tracer.b("orca:ContactPickerFriendsOfFriendsFilter");
      }
    }
    finally
    {
      localTracer.a();
      Tracer.b("orca:ContactPickerFriendsOfFriendsFilter");
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerFriendsOfFriendsFilter
 * JD-Core Version:    0.6.0
 */