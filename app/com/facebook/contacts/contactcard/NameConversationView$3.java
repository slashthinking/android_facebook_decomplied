package com.facebook.contacts.contactcard;

import com.facebook.orca.threadview.ThreadNamePicker.Listener;
import com.facebook.orca.threadview.ThreadNamePicker.Result;

class NameConversationView$3 extends ThreadNamePicker.Listener
{
  public void a(ThreadNamePicker.Result paramResult, String paramString)
  {
    if (paramResult == ThreadNamePicker.Result.CHANGE)
    {
      NameConversationView.a(this.a, paramString);
      NameConversationView.c(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.NameConversationView.3
 * JD-Core Version:    0.6.0
 */