package com.facebook.orca.notify;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.concurrent.ExecutorService;

class InAppMessagingNotificationHandler$AnimatingListener
  implements Animation.AnimationListener
{
  private InAppMessagingNotificationHandler$AnimatingListener(InAppMessagingNotificationHandler paramInAppMessagingNotificationHandler)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    InAppMessagingNotificationHandler.a(this.a, false);
    if (InAppMessagingNotificationHandler.e(this.a) != null)
    {
      NewMessageNotification localNewMessageNotification = InAppMessagingNotificationHandler.e(this.a);
      InAppMessagingNotificationHandler.b(this.a, null);
      InAppMessagingNotificationHandler.f(this.a).execute(new InAppMessagingNotificationHandler.AnimatingListener.1(this, localNewMessageNotification));
    }
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    InAppMessagingNotificationHandler.a(this.a, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.InAppMessagingNotificationHandler.AnimatingListener
 * JD-Core Version:    0.6.0
 */