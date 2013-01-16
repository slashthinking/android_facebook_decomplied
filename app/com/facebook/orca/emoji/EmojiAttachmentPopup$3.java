package com.facebook.orca.emoji;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

class EmojiAttachmentPopup$3
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    EmojiAttachmentPopup.a(this.a, paramMotionEvent);
    return EmojiAttachmentPopup.b(this.a).onTouchEvent(paramMotionEvent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiAttachmentPopup.3
 * JD-Core Version:    0.6.0
 */