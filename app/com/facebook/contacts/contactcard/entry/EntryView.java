package com.facebook.contacts.contactcard.entry;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.contacts.models.entry.Entry;
import com.facebook.widget.CustomRelativeLayout;

public abstract class EntryView extends CustomRelativeLayout
{
  private final TextView a;
  private final TextView b;
  private final ImageButton c;
  private Entry d;
  private EntryView.EntryViewListener e;

  public EntryView(Context paramContext)
  {
    this(paramContext, null);
  }

  public EntryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public EntryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903112);
    setClickable(true);
    if (Build.VERSION.SDK_INT >= 14)
      setBackgroundResource(2130838636);
    while (true)
    {
      setOnClickListener(new EntryView.1(this));
      this.b = ((TextView)b(2131296586));
      this.a = ((TextView)b(2131296585));
      this.c = ((ImageButton)b(2131296584));
      this.c.setOnClickListener(new EntryView.2(this));
      return;
      setBackgroundResource(17301602);
    }
  }

  protected abstract void a(TextView paramTextView);

  protected abstract void b(TextView paramTextView);

  public Entry getEntry()
  {
    return this.d;
  }

  public void setEditMode(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setClickable(false);
      this.c.setVisibility(0);
    }
    while (true)
    {
      return;
      setClickable(true);
      this.c.setVisibility(8);
    }
  }

  public void setEntry(Entry paramEntry)
  {
    this.d = paramEntry;
    a(this.a);
    b(this.b);
  }

  public void setEntryViewListener(EntryView.EntryViewListener paramEntryViewListener)
  {
    this.e = paramEntryViewListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.entry.EntryView
 * JD-Core Version:    0.6.0
 */