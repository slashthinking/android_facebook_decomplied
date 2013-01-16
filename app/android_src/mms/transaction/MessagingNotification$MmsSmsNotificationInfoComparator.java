package android_src.mms.transaction;

import java.util.Comparator;

final class MessagingNotification$MmsSmsNotificationInfoComparator
  implements Comparator<MessagingNotification.MmsSmsNotificationInfo>
{
  public int a(MessagingNotification.MmsSmsNotificationInfo paramMmsSmsNotificationInfo1, MessagingNotification.MmsSmsNotificationInfo paramMmsSmsNotificationInfo2)
  {
    return Long.signum(paramMmsSmsNotificationInfo2.a() - paramMmsSmsNotificationInfo1.a());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.MessagingNotification.MmsSmsNotificationInfoComparator
 * JD-Core Version:    0.6.0
 */