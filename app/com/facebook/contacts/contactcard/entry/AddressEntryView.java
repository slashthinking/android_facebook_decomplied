package com.facebook.contacts.contactcard.entry;

import android.content.Context;
import android.widget.TextView;
import com.facebook.contacts.models.entry.AddressEntry;

public class AddressEntryView extends EntryView
{
  public AddressEntryView(Context paramContext)
  {
    super(paramContext);
  }

  protected void a(TextView paramTextView)
  {
    paramTextView.setText(2131362457);
  }

  protected void b(TextView paramTextView)
  {
    paramTextView.setText(((AddressEntry)getEntry()).getAddress());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.entry.AddressEntryView
 * JD-Core Version:    0.6.0
 */