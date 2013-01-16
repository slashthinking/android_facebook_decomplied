package com.facebook.orca.contacts.picker;

import android.text.Selection;
import android.text.Spannable;

public class ContactPickerEditableUtil
{
  ContactPickerEditableUtil.Range a(CharSequence paramCharSequence)
  {
    ContactPickerEditableUtil.Range localRange;
    if (!(paramCharSequence instanceof Spannable))
      localRange = new ContactPickerEditableUtil.Range(0, paramCharSequence.length());
    while (true)
    {
      return localRange;
      Spannable localSpannable = (Spannable)paramCharSequence;
      int i = Selection.getSelectionStart(localSpannable);
      if (i != Selection.getSelectionEnd(localSpannable))
      {
        localRange = null;
        continue;
      }
      int j = paramCharSequence.length();
      PickedUserSpan[] arrayOfPickedUserSpan = (PickedUserSpan[])localSpannable.getSpans(0, paramCharSequence.length(), PickedUserSpan.class);
      int k = arrayOfPickedUserSpan.length;
      int m = 0;
      int n = 0;
      int i1 = j;
      if (m < k)
      {
        PickedUserSpan localPickedUserSpan = arrayOfPickedUserSpan[m];
        int i2 = localSpannable.getSpanStart(localPickedUserSpan);
        int i3 = localSpannable.getSpanEnd(localPickedUserSpan);
        if ((i2 < i) && (i3 > i))
        {
          localRange = null;
          continue;
        }
        if (i2 < i)
          n = Math.max(n, i3);
        while (true)
        {
          m++;
          break;
          if (i3 <= i)
            continue;
          i1 = Math.min(i1, i2);
        }
      }
      while ((n < i1) && (Character.isWhitespace(localSpannable.charAt(n))))
        n++;
      while ((n < i1 - 1) && (Character.isWhitespace(localSpannable.charAt(i1 - 1))))
        i1--;
      localRange = new ContactPickerEditableUtil.Range(n, i1);
    }
  }

  CharSequence b(CharSequence paramCharSequence)
  {
    ContactPickerEditableUtil.Range localRange = a(paramCharSequence);
    if (localRange == null);
    for (Object localObject = ""; ; localObject = paramCharSequence.subSequence(localRange.a, localRange.b))
      return localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerEditableUtil
 * JD-Core Version:    0.6.0
 */