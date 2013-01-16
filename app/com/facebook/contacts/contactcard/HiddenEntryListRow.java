package com.facebook.contacts.contactcard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.contacts.models.entry.Entry;
import com.facebook.contacts.models.entry.PhoneEntry;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.threads.ThreadDateUtil;
import com.facebook.widget.CustomRelativeLayout;

public class HiddenEntryListRow extends CustomRelativeLayout
{
  private final ThreadDateUtil a;
  private final OrcaPhoneNumberUtil b;
  private final TextView c;
  private final TextView d;
  private final TextView e;

  public HiddenEntryListRow(Context paramContext)
  {
    this(paramContext, null);
  }

  public HiddenEntryListRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public HiddenEntryListRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    FbInjector localFbInjector = getInjector();
    this.a = ((ThreadDateUtil)localFbInjector.a(ThreadDateUtil.class));
    this.b = ((OrcaPhoneNumberUtil)localFbInjector.a(OrcaPhoneNumberUtil.class));
    setContentView(2130903116);
    this.c = ((TextView)b(2131296595));
    this.d = ((TextView)b(2131296596));
    this.e = ((TextView)b(2131296597));
  }

  public void setEntry(Entry paramEntry)
  {
    PhoneEntry localPhoneEntry = (PhoneEntry)paramEntry;
    String str1 = this.b.c(localPhoneEntry.getNumber());
    this.c.setText(str1);
    this.d.setText(localPhoneEntry.getSource());
    String str2 = this.a.a(1000L * localPhoneEntry.getCreationTime());
    this.e.setText(str2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.HiddenEntryListRow
 * JD-Core Version:    0.6.0
 */