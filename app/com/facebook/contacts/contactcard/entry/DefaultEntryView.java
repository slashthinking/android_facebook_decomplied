package com.facebook.contacts.contactcard.entry;

import android.content.Context;
import android.widget.TextView;
import com.facebook.contacts.models.entry.DefaultEntry;

public class DefaultEntryView extends EntryView
{
  public DefaultEntryView(Context paramContext)
  {
    super(paramContext);
  }

  protected void a(TextView paramTextView)
  {
    paramTextView.setText(((DefaultEntry)getEntry()).getLabel());
  }

  protected void b(TextView paramTextView)
  {
    paramTextView.setText(((DefaultEntry)getEntry()).getValue());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.entry.DefaultEntryView
 * JD-Core Version:    0.6.0
 */