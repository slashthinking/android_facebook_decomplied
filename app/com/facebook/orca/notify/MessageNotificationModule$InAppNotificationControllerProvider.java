package com.facebook.orca.notify;

import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.annotations.IsInAppNotificationsEnabled;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.emoji.EmojiUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threads.ThreadSnippetUtil;
import com.facebook.orca.threadview.ThreadViewUtil;
import java.util.concurrent.ExecutorService;

class MessageNotificationModule$InAppNotificationControllerProvider extends AbstractProvider<InAppMessagingNotificationHandler>
{
  private MessageNotificationModule$InAppNotificationControllerProvider(MessageNotificationModule paramMessageNotificationModule)
  {
  }

  public InAppMessagingNotificationHandler a()
  {
    return new InAppMessagingNotificationHandler(a(Boolean.class, IsInAppNotificationsEnabled.class), (OrcaAppType)b(OrcaAppType.class), (EmojiUtil)b(EmojiUtil.class), (ThreadViewUtil)b(ThreadViewUtil.class), (ThreadSnippetUtil)b(ThreadSnippetUtil.class), (ExecutorService)b(ExecutorService.class, DefaultExecutorService.class), (ExecutorService)b(ExecutorService.class, ForUiThread.class), (UserInteractionController)b(UserInteractionController.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.MessageNotificationModule.InAppNotificationControllerProvider
 * JD-Core Version:    0.6.0
 */