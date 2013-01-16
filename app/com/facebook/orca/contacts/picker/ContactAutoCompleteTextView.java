package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
import android.text.method.QwertyKeyListener;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.facebook.orca.common.ui.widgets.CustomFilter;
import com.facebook.orca.common.ui.widgets.CustomFilter.FilterListener;
import com.facebook.orca.common.ui.widgets.CustomFilter.FilteringState;
import com.facebook.orca.common.ui.widgets.CustomFilterable;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserWithIdentifier;

public class ContactAutoCompleteTextView extends AutoCompleteTextView
  implements CustomFilter.FilterListener
{
  private static final Class<?> a = ContactAutoCompleteTextView.class;
  private ContactPickerEditableUtil b;

  public ContactAutoCompleteTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public ContactAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public ContactAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.b = ((ContactPickerEditableUtil)FbInjector.a(paramContext).a(ContactPickerEditableUtil.class));
    setInputType(0x80000 | getInputType());
  }

  private CharSequence b(UserWithIdentifier paramUserWithIdentifier)
  {
    String str = paramUserWithIdentifier.a().g() + " ";
    PickedUserSpan localPickedUserSpan = new PickedUserSpan(paramUserWithIdentifier, getPaint(), getResources());
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(localPickedUserSpan, 0, str.length(), 33);
    return localSpannableString;
  }

  public void a(int paramInt)
  {
    super.onFilterComplete(paramInt);
  }

  public void a(CustomFilter.FilteringState paramFilteringState)
  {
  }

  void a(UserWithIdentifier paramUserWithIdentifier)
  {
    CharSequence localCharSequence = b(paramUserWithIdentifier);
    Editable localEditable = getEditableText();
    ContactPickerEditableUtil.Range localRange = this.b.a(localEditable);
    if (localRange != null)
    {
      QwertyKeyListener.markAsReplaced(localEditable, localRange.a, localRange.b, "");
      localEditable.replace(localRange.a, localRange.b, localCharSequence);
    }
    Selection.setSelection(localEditable, localEditable.length());
  }

  protected void performFiltering(CharSequence paramCharSequence, int paramInt)
  {
    Editable localEditable = getText();
    CharSequence localCharSequence = this.b.b(localEditable);
    ((CustomFilterable)getAdapter()).c().a(localCharSequence, this);
  }

  protected void replaceText(CharSequence paramCharSequence)
  {
    clearComposingText();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactAutoCompleteTextView
 * JD-Core Version:    0.6.0
 */