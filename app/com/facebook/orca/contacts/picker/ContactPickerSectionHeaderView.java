package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;

public class ContactPickerSectionHeaderView extends CustomViewGroup
{
  private final Context a;
  private final View b;
  private final TextView c;

  public ContactPickerSectionHeaderView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public ContactPickerSectionHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ContactPickerSectionHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    setContentView(2130903329);
    this.b = findViewById(2131297229);
    this.c = ((TextView)findViewById(2131297230));
  }

  public void setColorScheme(ContactPickerColorScheme paramContactPickerColorScheme)
  {
    Resources localResources = getResources();
    if (paramContactPickerColorScheme == ContactPickerColorScheme.DEFAULT_SCHEME)
    {
      this.b.setBackgroundDrawable(new ColorDrawable(localResources.getColor(2131165405)));
      if (this.c != null)
        this.c.setTextColor(localResources.getColor(2131165406));
    }
    while (true)
    {
      return;
      if (paramContactPickerColorScheme == ContactPickerColorScheme.DIVEBAR_SCHEME)
      {
        this.b.setBackgroundDrawable(new ColorDrawable(localResources.getColor(2131165410)));
        if (this.c == null)
          continue;
        this.c.setTextColor(localResources.getColor(2131165411));
        continue;
      }
    }
  }

  public void setText(String paramString)
  {
    this.c.setText(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerSectionHeaderView
 * JD-Core Version:    0.6.0
 */