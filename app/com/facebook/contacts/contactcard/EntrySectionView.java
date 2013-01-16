package com.facebook.contacts.contactcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.contacts.contactcard.entry.AddressEntryView;
import com.facebook.contacts.contactcard.entry.CreatePhoneEntryView;
import com.facebook.contacts.contactcard.entry.DefaultEntryView;
import com.facebook.contacts.contactcard.entry.EmailEntryView;
import com.facebook.contacts.contactcard.entry.EntryView;
import com.facebook.contacts.contactcard.entry.PhoneEntryView;
import com.facebook.contacts.models.EntrySection;
import com.facebook.contacts.models.entry.Entry;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;

public class EntrySectionView extends CustomLinearLayout
{
  private final TextView a;
  private final SectionView b;
  private ArrayList<EntryView> c;
  private CreatePhoneEntryView d;
  private EntrySection e;
  private EntrySectionView.OnEntrySelectedListener f;

  public EntrySectionView(Context paramContext)
  {
    this(paramContext, null);
  }

  public EntrySectionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    setContentView(2130903111);
    this.a = ((TextView)b(2131296582));
    this.b = ((SectionView)b(2131296583));
    this.c = new ArrayList();
  }

  private void a()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(8);
    this.b.b();
    this.c.clear();
  }

  private void a(Entry paramEntry)
  {
    Object localObject;
    switch (EntrySectionView.3.a[paramEntry.a().ordinal()])
    {
    default:
      return;
    case 1:
      localObject = new PhoneEntryView(getContext());
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      ((EntryView)localObject).setEntry(paramEntry);
      ((EntryView)localObject).setEntryViewListener(new EntrySectionView.2(this));
      this.b.setVisibility(0);
      this.b.b((View)localObject);
      this.c.add(localObject);
      break;
      localObject = new EmailEntryView(getContext());
      continue;
      localObject = new AddressEntryView(getContext());
      continue;
      localObject = new DefaultEntryView(getContext());
    }
  }

  public String getAddEntryValue()
  {
    if (this.d == null);
    for (String str = null; ; str = this.d.getInputValue())
      return str;
  }

  public EntrySection getEntrySection()
  {
    return this.e;
  }

  public void setEditMode(boolean paramBoolean)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
      ((EntryView)localIterator.next()).setEditMode(paramBoolean);
    boolean bool;
    label117: SectionView localSectionView;
    int i;
    if (paramBoolean)
    {
      if (this.d == null)
      {
        this.d = new CreatePhoneEntryView(getContext());
        this.d.setListener(new EntrySectionView.1(this));
      }
      if (this.e != null)
      {
        if (this.e.getHiddenEntries().size() > 0)
        {
          bool = true;
          this.d.setPlusButtonVisibility(bool);
        }
      }
      else
      {
        this.b.b(this.d);
        if (this.c.size() == 0)
        {
          localSectionView = this.b;
          i = 0;
          if (!paramBoolean)
            break label173;
        }
      }
    }
    while (true)
    {
      localSectionView.setVisibility(i);
      return;
      bool = false;
      break;
      if (this.d == null)
        break label117;
      this.b.a(this.d);
      break label117;
      label173: i = 8;
    }
  }

  public void setEntryListener(EntrySectionView.OnEntrySelectedListener paramOnEntrySelectedListener)
  {
    this.f = paramOnEntrySelectedListener;
  }

  public void setEntrySection(EntrySection paramEntrySection)
  {
    this.e = paramEntrySection;
    this.a.setText(paramEntrySection.getTitle());
    a();
    Iterator localIterator = paramEntrySection.getEntries().iterator();
    while (localIterator.hasNext())
      a((Entry)localIterator.next());
    if (this.d != null)
      if (paramEntrySection.getHiddenEntries().size() <= 0)
        break label81;
    label81: for (boolean bool = true; ; bool = false)
    {
      this.d.setPlusButtonVisibility(bool);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.EntrySectionView
 * JD-Core Version:    0.6.0
 */