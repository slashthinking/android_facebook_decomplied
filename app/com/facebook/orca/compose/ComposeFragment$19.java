package com.facebook.orca.compose;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.EditText;
import com.facebook.orca.emoji.Emoji;
import com.facebook.orca.emoji.EmojiAttachmentPopup.EmojiAttachmentPopupListener;

class ComposeFragment$19 extends EmojiAttachmentPopup.EmojiAttachmentPopupListener
{
  public void a()
  {
    ComposeFragment.w(this.a);
  }

  public void a(int paramInt)
  {
    ComposeFragment.a(this.a, paramInt);
  }

  public void a(Emoji paramEmoji)
  {
    ComposeFragment.a(this.a, paramEmoji);
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    ComposeFragment.c(this.a).getLocationInWindow(arrayOfInt);
    float f = paramMotionEvent.getY();
    paramMotionEvent.setLocation(paramMotionEvent.getX(), paramMotionEvent.getY() - arrayOfInt[1]);
    boolean bool = ((ComposeRootView)ComposeFragment.c(this.a)).getEmojiAttachmentTouchDelegate().onTouchEvent(paramMotionEvent);
    paramMotionEvent.setLocation(paramMotionEvent.getX(), f);
    return bool;
  }

  public void b()
  {
    ComposeFragment.e(this.a).dispatchKeyEvent(new KeyEvent(0, 67));
  }

  public void c()
  {
    ComposeFragment.a(this.a, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeFragment.19
 * JD-Core Version:    0.6.0
 */