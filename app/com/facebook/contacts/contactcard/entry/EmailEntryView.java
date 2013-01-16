package com.facebook.contacts.contactcard.entry;

import android.content.Context;
import android.widget.TextView;
import com.facebook.contacts.models.entry.EmailEntry;

public class EmailEntryView extends EntryView
{
  public EmailEntryView(Context paramContext)
  {
    super(paramContext);
  }

  protected void a(TextView paramTextView)
  {
    paramTextView.setText(2131362456);
  }

  protected void b(TextView paramTextView)
  {
    paramTextView.setText(((EmailEntry)getEntry()).getEmail());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.entry.EmailEntryView
 * JD-Core Version:    0.6.0
 */