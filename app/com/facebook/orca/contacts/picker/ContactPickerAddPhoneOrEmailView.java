package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;

public class ContactPickerAddPhoneOrEmailView extends CustomViewGroup
{
  private final View a;
  private final TextView b;
  private View c;

  public ContactPickerAddPhoneOrEmailView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public ContactPickerAddPhoneOrEmailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ContactPickerAddPhoneOrEmailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903323);
    this.a = findViewById(2131296601);
    this.b = ((TextView)findViewById(2131297221));
    this.c = getView(2131296598);
  }

  public void setColorScheme(ContactPickerColorScheme paramContactPickerColorScheme)
  {
    Resources localResources = getResources();
    if (paramContactPickerColorScheme == ContactPickerColorScheme.DEFAULT_SCHEME)
    {
      this.a.setBackgroundDrawable(null);
      if (this.b != null)
        this.b.setTextColor(localResources.getColor(2131165406));
      this.c.setBackgroundDrawable(new ColorDrawable(2130839053));
    }
    while (true)
    {
      return;
      if (paramContactPickerColorScheme == ContactPickerColorScheme.DIVEBAR_SCHEME)
      {
        this.a.setBackgroundDrawable(localResources.getDrawable(2130837735));
        if (this.b != null)
          this.b.setTextColor(localResources.getColor(2131165414));
        this.c.setBackgroundDrawable(new ColorDrawable(localResources.getColor(2131165416)));
        continue;
      }
    }
  }

  public void setSpannedText(Spanned paramSpanned)
  {
    this.b.setText(paramSpanned);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerAddPhoneOrEmailView
 * JD-Core Version:    0.6.0
 */