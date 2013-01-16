package com.facebook.contacts.contactcard.entry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;

public class CreatePhoneEntryView extends CustomRelativeLayout
{
  private final InputMethodManager a = (InputMethodManager)getInjector().a(InputMethodManager.class);
  private final EditText b;
  private final ImageButton c;
  private CreatePhoneEntryView.Listener d;

  public CreatePhoneEntryView(Context paramContext)
  {
    this(paramContext, null);
  }

  public CreatePhoneEntryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public CreatePhoneEntryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903110);
    this.b = ((EditText)b(2131296580));
    this.b.setOnEditorActionListener(new CreatePhoneEntryView.1(this));
    this.c = ((ImageButton)b(2131296581));
    this.c.setOnClickListener(new CreatePhoneEntryView.2(this));
  }

  public String getInputValue()
  {
    return this.b.getText().toString();
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    if (paramInt == 8)
    {
      this.a.hideSoftInputFromWindow(this.b.getWindowToken(), 0);
      this.b.setText("");
    }
  }

  public void setListener(CreatePhoneEntryView.Listener paramListener)
  {
    this.d = paramListener;
  }

  public void setPlusButtonVisibility(boolean paramBoolean)
  {
    ImageButton localImageButton = this.c;
    if (paramBoolean);
    for (int i = 0; ; i = 4)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.entry.CreatePhoneEntryView
 * JD-Core Version:    0.6.0
 */