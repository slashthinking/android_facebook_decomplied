package com.facebook.contacts.contactcard.entry;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.contacts.models.entry.PhoneEntry;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.inject.FbInjector;

public class PhoneEntryView extends EntryView
{
  private final OrcaPhoneNumberUtil a = (OrcaPhoneNumberUtil)getInjector().a(OrcaPhoneNumberUtil.class);

  public PhoneEntryView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PhoneEntryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PhoneEntryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(TextView paramTextView)
  {
    int i;
    switch (((PhoneEntry)getEntry()).getType())
    {
    default:
      i = 2131362453;
    case 2:
    case 1:
    }
    while (true)
    {
      paramTextView.setText(i);
      return;
      i = 2131362454;
      continue;
      i = 2131362455;
    }
  }

  protected void b(TextView paramTextView)
  {
    PhoneEntry localPhoneEntry = (PhoneEntry)getEntry();
    paramTextView.setText(this.a.c(localPhoneEntry.getNumber()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.entry.PhoneEntryView
 * JD-Core Version:    0.6.0
 */