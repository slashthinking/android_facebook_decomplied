package com.facebook.orca.notify;

import android.app.Activity;
import android.content.Intent;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import com.facebook.app.Product;
import com.facebook.orca.activity.CheckBeforeLeaveActivity;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.async.CancellableRunnable;
import com.facebook.orca.common.ui.overlay.OverlayLayout;
import com.facebook.orca.common.ui.overlay.OverlayLayout.LayoutParams;
import com.facebook.orca.emoji.EmojiUtil;
import com.facebook.orca.threadlist.ThreadListActivity;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ThreadSnippetUtil;
import com.facebook.orca.threadview.ThreadViewActivity;
import com.facebook.orca.threadview.ThreadViewUtil;
import com.google.common.base.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.inject.Provider;

public class InAppMessagingNotificationHandler extends AbstractMessagingNotificationHandler
{
  private final Provider<Boolean> a;
  private final OrcaAppType b;
  private final InAppMessagingNotificationHandler.MyActivityListener c;
  private final EmojiUtil d;
  private final ThreadViewUtil e;
  private final ThreadSnippetUtil f;
  private final ExecutorService g;
  private final ExecutorService h;
  private final UserInteractionController i;
  private Activity j;
  private InAppNotificationView k;
  private CancellableRunnable l;
  private NewMessageNotification m;
  private boolean n;

  public InAppMessagingNotificationHandler(Provider<Boolean> paramProvider, OrcaAppType paramOrcaAppType, EmojiUtil paramEmojiUtil, ThreadViewUtil paramThreadViewUtil, ThreadSnippetUtil paramThreadSnippetUtil, ExecutorService paramExecutorService1, ExecutorService paramExecutorService2, UserInteractionController paramUserInteractionController)
  {
    this.a = paramProvider;
    this.b = paramOrcaAppType;
    this.d = paramEmojiUtil;
    this.e = paramThreadViewUtil;
    this.f = paramThreadSnippetUtil;
    this.g = paramExecutorService1;
    this.h = paramExecutorService2;
    this.i = paramUserInteractionController;
    this.c = new InAppMessagingNotificationHandler.MyActivityListener(this);
  }

  private InAppNotificationView a(OverlayLayout paramOverlayLayout)
  {
    InAppNotificationView localInAppNotificationView = new InAppNotificationView(this.j, this.d, this.f);
    OverlayLayout.LayoutParams localLayoutParams = new OverlayLayout.LayoutParams(-1, -2);
    localLayoutParams.b = 2131296299;
    localLayoutParams.a = true;
    localLayoutParams.c = 68;
    localInAppNotificationView.setLayoutParams(localLayoutParams);
    paramOverlayLayout.addView(localInAppNotificationView);
    localInAppNotificationView.measure(View.MeasureSpec.makeMeasureSpec(this.j.getWindowManager().getDefaultDisplay().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -localInAppNotificationView.getMeasuredHeight(), 0.0F);
    localTranslateAnimation.setDuration(600L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new InAppMessagingNotificationHandler.AnimatingListener(this, null));
    localInAppNotificationView.startAnimation(localTranslateAnimation);
    localInAppNotificationView.setOnDismissListener(new InAppMessagingNotificationHandler.3(this));
    localInAppNotificationView.setOnClickListener(new InAppMessagingNotificationHandler.4(this));
    return localInAppNotificationView;
  }

  private void a(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof ViewGroup))
      ((ViewGroup)localViewParent).removeView(paramView);
  }

  private void a(InAppMessagingNotificationHandler.DismissAnimation paramDismissAnimation)
  {
    if (this.k == null)
      return;
    if (paramDismissAnimation == InAppMessagingNotificationHandler.DismissAnimation.SLIDE_OUT)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.k.getMeasuredHeight());
      localTranslateAnimation.setDuration(600L);
      localTranslateAnimation.setFillAfter(false);
      localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
      localTranslateAnimation.setAnimationListener(new InAppMessagingNotificationHandler.AnimatingListener(this, null));
      this.k.startAnimation(localTranslateAnimation);
    }
    while (true)
    {
      a(this.k);
      this.k = null;
      break;
      if (paramDismissAnimation != InAppMessagingNotificationHandler.DismissAnimation.FADE_OUT)
        continue;
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(400L);
      localAlphaAnimation.setFillAfter(false);
      localAlphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
      localAlphaAnimation.setAnimationListener(new InAppMessagingNotificationHandler.AnimatingListener(this, null));
      this.k.startAnimation(localAlphaAnimation);
    }
  }

  private boolean b(NewMessageNotification paramNewMessageNotification)
  {
    int i1;
    if (this.n)
    {
      this.m = paramNewMessageNotification;
      i1 = 1;
    }
    View localView1;
    Object localObject;
    while (true)
    {
      return i1;
      ViewGroup localViewGroup = (ViewGroup)this.j.findViewById(16908290);
      localView1 = localViewGroup.getChildAt(0);
      if ((localView1 instanceof OverlayLayout))
        break;
      View localView2 = localViewGroup.findViewById(2131296299);
      if (localView2 == null)
      {
        i1 = 0;
        continue;
      }
      localObject = (ViewGroup)localView2.getParent();
      if ((localObject == null) || (!(localObject instanceof OverlayLayout)))
        break;
    }
    while (true)
    {
      if (!(localObject instanceof OverlayLayout))
      {
        i1 = 0;
        break;
      }
      OverlayLayout localOverlayLayout = (OverlayLayout)localObject;
      if (this.k == null)
      {
        this.k = a(localOverlayLayout);
        this.k.setMessage(paramNewMessageNotification.b());
      }
      while (true)
      {
        this.l = new CancellableRunnable(new InAppMessagingNotificationHandler.2(this));
        this.k.postDelayed(this.l, 5000L);
        i1 = 1;
        break;
        this.k.setMessage(paramNewMessageNotification.b());
        this.l.a();
      }
      localObject = localView1;
    }
  }

  private void c()
  {
    if ((this.k == null) || (this.j == null));
    while (true)
    {
      return;
      String str = this.k.getMessage().b();
      if ((this.j instanceof CheckBeforeLeaveActivity))
      {
        ((CheckBeforeLeaveActivity)this.j).a(new InAppMessagingNotificationHandler.5(this, str));
        continue;
      }
      c(str);
    }
  }

  private void c(String paramString)
  {
    if (this.b.i() == Product.MESSENGER)
    {
      Intent localIntent1 = new Intent(this.j, ThreadListActivity.class);
      localIntent1.setFlags(67108864);
      this.j.startActivity(localIntent1);
      Intent localIntent2 = new Intent(this.j, ThreadViewActivity.class);
      localIntent2.putExtra("thread_id", paramString);
      this.j.startActivity(localIntent2);
    }
    while (true)
    {
      e();
      return;
      Intent localIntent3 = new Intent(this.j, ThreadViewActivity.class);
      localIntent3.putExtra("thread_id", paramString);
      localIntent3.setFlags(67108864);
      this.j.startActivity(localIntent3);
    }
  }

  private void d()
  {
    a(InAppMessagingNotificationHandler.DismissAnimation.FADE_OUT);
    e();
  }

  private void e()
  {
    if (this.l != null)
    {
      this.l.a();
      this.l = null;
    }
    a(InAppMessagingNotificationHandler.DismissAnimation.NONE);
  }

  public void a(NewMessageNotification paramNewMessageNotification)
  {
    if (!((Boolean)this.a.b()).booleanValue());
    while (true)
    {
      return;
      if (!paramNewMessageNotification.e().f())
      {
        InAppMessagingNotificationHandler.1 local1 = new InAppMessagingNotificationHandler.1(this, paramNewMessageNotification);
        this.i.c();
        try
        {
          if (!((Boolean)this.h.submit(local1).get()).booleanValue())
            continue;
          paramNewMessageNotification.e().g();
        }
        catch (InterruptedException localInterruptedException)
        {
        }
        catch (ExecutionException localExecutionException)
        {
        }
        continue;
      }
    }
  }

  public InAppMessagingNotificationHandler.MyActivityListener b()
  {
    return this.c;
  }

  public boolean b(String paramString)
  {
    int i1;
    if (!((Boolean)this.a.b()).booleanValue())
      i1 = 0;
    while (true)
    {
      return i1;
      boolean bool = this.e.b(this.j);
      if ((!bool) && ((this.j instanceof ThreadListActivity)) && (!((ThreadListActivity)this.j).k()))
      {
        i1 = 0;
        continue;
      }
      if ((bool) && (Objects.equal(this.e.a(this.j), paramString)))
      {
        i1 = 0;
        continue;
      }
      i1 = 1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.InAppMessagingNotificationHandler
 * JD-Core Version:    0.6.0
 */