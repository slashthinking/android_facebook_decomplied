package com.facebook.orca.contacts.picker;

import com.facebook.orca.common.ui.widgets.CustomFilter.FilterListener;
import com.facebook.orca.common.ui.widgets.CustomFilter.FilteringState;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.users.UserIdentifier;
import com.facebook.orca.users.UserIdentifierKey;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ContactPickerMergedFilter
  implements ContactPickerListFilter
{
  private static final Class<?> a = ContactPickerMergedFilter.class;
  private final ImmutableList<ContactPickerMergedFilter.ContactPickerFilterInstance> b;
  private ContactPickerListFilterReceiver c;
  private CustomFilter.FilterListener d;
  private CustomFilter.FilteringState e = CustomFilter.FilteringState.FINISHED;

  public ContactPickerMergedFilter(ImmutableList<ContactPickerMergedFilter.ContactPickerSubFilterConfig> paramImmutableList)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramImmutableList.iterator();
    while (localIterator.hasNext())
      localBuilder.b(new ContactPickerMergedFilter.ContactPickerFilterInstance((ContactPickerMergedFilter.ContactPickerSubFilterConfig)localIterator.next()));
    this.b = localBuilder.b();
  }

  private ContactPickerFilterResult a(ContactPickerFilterResult paramContactPickerFilterResult, Set<UserIdentifierKey> paramSet)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramContactPickerFilterResult.d().iterator();
    while (localIterator.hasNext())
    {
      ContactPickerRow localContactPickerRow = (ContactPickerRow)localIterator.next();
      if ((localContactPickerRow instanceof ContactPickerUserRow))
      {
        ContactPickerUserRow localContactPickerUserRow = (ContactPickerUserRow)localContactPickerRow;
        if (paramSet.contains(localContactPickerUserRow.a().b().c()))
          continue;
        localBuilder.b(localContactPickerUserRow);
        continue;
      }
      if ((localContactPickerRow instanceof ContactPickerGroupRow))
      {
        localBuilder.b((ContactPickerGroupRow)localContactPickerRow);
        continue;
      }
      localBuilder.b(localContactPickerRow);
    }
    return ContactPickerFilterResult.a(paramContactPickerFilterResult.b(), localBuilder.b());
  }

  private void a(ImmutableList<ContactPickerRow> paramImmutableList, ImmutableList.Builder<ContactPickerRow> paramBuilder, Set<UserIdentifierKey> paramSet)
  {
    Iterator localIterator = paramImmutableList.iterator();
    while (localIterator.hasNext())
    {
      ContactPickerRow localContactPickerRow = (ContactPickerRow)localIterator.next();
      if ((localContactPickerRow instanceof ContactPickerUserRow))
      {
        ContactPickerUserRow localContactPickerUserRow = (ContactPickerUserRow)localContactPickerRow;
        UserIdentifier localUserIdentifier = localContactPickerUserRow.a().b();
        if (paramSet.contains(localUserIdentifier.c()))
          continue;
        paramBuilder.b(localContactPickerUserRow);
        paramSet.add(localUserIdentifier.c());
        continue;
      }
      if ((localContactPickerRow instanceof ContactPickerGroupRow))
      {
        paramBuilder.b((ContactPickerGroupRow)localContactPickerRow);
        continue;
      }
      paramBuilder.b(localContactPickerRow);
    }
  }

  private void b()
  {
    CustomFilter.FilteringState localFilteringState1 = CustomFilter.FilteringState.FINISHED;
    Iterator localIterator = this.b.iterator();
    ContactPickerMergedFilter.ContactPickerFilterInstance localContactPickerFilterInstance;
    do
    {
      if (!localIterator.hasNext())
        break;
      localContactPickerFilterInstance = (ContactPickerMergedFilter.ContactPickerFilterInstance)localIterator.next();
    }
    while (CustomFilter.FilteringState.FILTERING != localContactPickerFilterInstance.d());
    for (CustomFilter.FilteringState localFilteringState2 = CustomFilter.FilteringState.FILTERING; ; localFilteringState2 = localFilteringState1)
    {
      if (localFilteringState2 != this.e)
      {
        this.e = localFilteringState2;
        BLog.a(a, "New filtering state: %s", new Object[] { localFilteringState2 });
        if (this.d != null)
          this.d.a(this.e);
      }
      return;
    }
  }

  private void b(CharSequence paramCharSequence)
  {
    ContactPickerFilterResult localContactPickerFilterResult = c(paramCharSequence);
    int j;
    if (localContactPickerFilterResult != null)
    {
      BLog.a(a, "New filtering result: %s", new Object[] { localContactPickerFilterResult });
      this.c.a(paramCharSequence, localContactPickerFilterResult);
      if (this.d != null)
      {
        int i = ContactPickerMergedFilter.3.a[localContactPickerFilterResult.a().ordinal()];
        j = 0;
        switch (i)
        {
        default:
        case 1:
        case 2:
        }
      }
    }
    while (true)
    {
      this.d.a(j);
      return;
      j = -1;
      continue;
      j = localContactPickerFilterResult.c();
    }
  }

  private ContactPickerFilterResult c(CharSequence paramCharSequence)
  {
    ContactPickerFilterResult localContactPickerFilterResult1 = ((ContactPickerMergedFilter.ContactPickerFilterInstance)this.b.get(0)).c();
    if ((localContactPickerFilterResult1 == null) || (!Objects.equal(paramCharSequence, localContactPickerFilterResult1.b())));
    ImmutableList.Builder localBuilder;
    for (localContactPickerFilterResult1 = null; ; localContactPickerFilterResult1 = ContactPickerFilterResult.a(paramCharSequence, localBuilder.b()))
    {
      do
        return localContactPickerFilterResult1;
      while ((localContactPickerFilterResult1.a() == ContactPickerFilterResult.Type.EMPTY_CONSTRAINT) || (localContactPickerFilterResult1.a() == ContactPickerFilterResult.Type.EXCEPTION));
      HashSet localHashSet = Sets.a();
      localBuilder = ImmutableList.e();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        ContactPickerMergedFilter.ContactPickerFilterInstance localContactPickerFilterInstance = (ContactPickerMergedFilter.ContactPickerFilterInstance)localIterator.next();
        ContactPickerFilterResult localContactPickerFilterResult2 = localContactPickerFilterInstance.c();
        if (localContactPickerFilterResult2 == null)
          continue;
        if ((localContactPickerFilterResult2.a() == ContactPickerFilterResult.Type.OK) && (Objects.equal(paramCharSequence, localContactPickerFilterResult2.b())))
        {
          localContactPickerFilterResult2 = a(localContactPickerFilterResult2, localHashSet);
          localContactPickerFilterInstance.a(localContactPickerFilterResult2);
        }
        if (localContactPickerFilterResult2.c() <= 0)
          continue;
        if (localContactPickerFilterInstance.b() != null)
          localBuilder.b(new ContactPickerSectionHeaderRow(localContactPickerFilterInstance.b()));
        a(localContactPickerFilterResult2.d(), localBuilder, localHashSet);
      }
    }
  }

  public void a(ContactPickerListFilter.RowCreator paramRowCreator)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((ContactPickerMergedFilter.ContactPickerFilterInstance)localIterator.next()).a().a(paramRowCreator);
  }

  public void a(ContactPickerListFilterReceiver paramContactPickerListFilterReceiver)
  {
    this.c = paramContactPickerListFilterReceiver;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ContactPickerMergedFilter.ContactPickerFilterInstance localContactPickerFilterInstance = (ContactPickerMergedFilter.ContactPickerFilterInstance)localIterator.next();
      localContactPickerFilterInstance.a().a(new ContactPickerMergedFilter.1(this, localContactPickerFilterInstance));
    }
  }

  public void a(ImmutableList<UserIdentifierKey> paramImmutableList)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((ContactPickerMergedFilter.ContactPickerFilterInstance)localIterator.next()).a().a(paramImmutableList);
  }

  public void a(CharSequence paramCharSequence)
  {
    a(paramCharSequence, null);
  }

  public void a(CharSequence paramCharSequence, CustomFilter.FilterListener paramFilterListener)
  {
    this.d = paramFilterListener;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ContactPickerMergedFilter.ContactPickerFilterInstance localContactPickerFilterInstance = (ContactPickerMergedFilter.ContactPickerFilterInstance)localIterator.next();
      localContactPickerFilterInstance.a().a(paramCharSequence, new ContactPickerMergedFilter.2(this, localContactPickerFilterInstance));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerMergedFilter
 * JD-Core Version:    0.6.0
 */