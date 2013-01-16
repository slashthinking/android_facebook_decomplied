package com.facebook.orca.emoji;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.app.FragmentHost;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

class EmojiAttachmentPopup$6 extends Dialog
{
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Rect localRect;
    int i;
    float f1;
    float f2;
    boolean bool;
    if (paramMotionEvent.getAction() == 4)
      if (EmojiAttachmentPopup.f(this.a) != null)
      {
        localRect = new Rect();
        this.a.o().d().getDecorView().getWindowVisibleDisplayFrame(localRect);
        i = paramMotionEvent.getAction();
        f1 = paramMotionEvent.getY();
        if (EmojiAttachmentPopup.g(this.a))
        {
          f2 = paramMotionEvent.getY() + EmojiAttachmentPopup.h(this.a) + localRect.top;
          paramMotionEvent.setAction(0);
          paramMotionEvent.setLocation(paramMotionEvent.getX(), f2);
          if (!EmojiAttachmentPopup.f(this.a).a(paramMotionEvent))
            break label150;
          bool = true;
        }
      }
    while (true)
    {
      return bool;
      f2 = localRect.bottom - (EmojiAttachmentPopup.i(this.a) + EmojiAttachmentPopup.h(this.a)) + paramMotionEvent.getY();
      break;
      label150: paramMotionEvent.setAction(i);
      paramMotionEvent.setLocation(paramMotionEvent.getX(), f1);
      EmojiAttachmentPopup.f(this.a).c();
      EmojiAttachmentPopup.a(this.a, "popup_dismiss_outside_click");
      dismiss();
      bool = true;
      continue;
      bool = super.onTouchEvent(paramMotionEvent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiAttachmentPopup.6
 * JD-Core Version:    0.6.0
 */