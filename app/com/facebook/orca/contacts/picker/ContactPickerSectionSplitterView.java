package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomViewGroup;

public class ContactPickerSectionSplitterView extends CustomViewGroup
{
  private final View a;

  public ContactPickerSectionSplitterView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public ContactPickerSectionSplitterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ContactPickerSectionSplitterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903330);
    this.a = findViewById(2131297229);
  }

  public void setColorScheme(ContactPickerColorScheme paramContactPickerColorScheme)
  {
    Resources localResources = getResources();
    if (paramContactPickerColorScheme == ContactPickerColorScheme.DEFAULT_SCHEME)
      this.a.setBackgroundDrawable(new ColorDrawable(localResources.getColor(2131165405)));
    while (true)
    {
      return;
      if (paramContactPickerColorScheme == ContactPickerColorScheme.DIVEBAR_SCHEME)
      {
        this.a.setBackgroundDrawable(new ColorDrawable(localResources.getColor(2131165410)));
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerSectionSplitterView
 * JD-Core Version:    0.6.0
 */