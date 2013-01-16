package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.orca.common.ui.widgets.text.ThreadNameView;
import com.facebook.orca.photos.tiles.ThreadTileView;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.widget.CustomViewGroup;

public class ContactPickerListGroupItem extends CustomViewGroup
{
  private static final Class<?> a = ContactPickerListGroupItem.class;
  private final ThreadNameView b;
  private final ThreadNameView c;
  private final ThreadTileView d;
  private final View e;
  private ContactPickerGroupRow f;

  public ContactPickerListGroupItem(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public ContactPickerListGroupItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ContactPickerListGroupItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903326);
    this.b = ((ThreadNameView)getView(2131297004));
    this.c = ((ThreadNameView)getView(2131297227));
    this.d = ((ThreadTileView)getView(2131297226));
    this.e = getView(2131296598);
  }

  private void a()
  {
    ThreadSummary localThreadSummary = this.f.a();
    this.b.setData(localThreadSummary);
    this.d.setThreadSummary(localThreadSummary);
    if (localThreadSummary.e())
    {
      this.c.setData(localThreadSummary);
      this.c.setVisibility(0);
    }
    while (true)
    {
      return;
      this.c.setVisibility(8);
    }
  }

  public ContactPickerGroupRow getContactRow()
  {
    return this.f;
  }

  public void setColorScheme(ContactPickerColorScheme paramContactPickerColorScheme)
  {
    if (paramContactPickerColorScheme == ContactPickerColorScheme.DEFAULT_SCHEME);
    while (true)
    {
      return;
      if (paramContactPickerColorScheme == ContactPickerColorScheme.DIVEBAR_SCHEME)
      {
        Resources localResources = getResources();
        setBackgroundDrawable(localResources.getDrawable(2130837735));
        this.e.setBackgroundDrawable(new ColorDrawable(localResources.getColor(2131165416)));
        this.b.setTextColor(localResources.getColor(2131165414));
        this.c.setTextColor(localResources.getColor(2131165415));
        continue;
      }
    }
  }

  public void setContactRow(ContactPickerGroupRow paramContactPickerGroupRow)
  {
    this.f = paramContactPickerGroupRow;
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerListGroupItem
 * JD-Core Version:    0.6.0
 */