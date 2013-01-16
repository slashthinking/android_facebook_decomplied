package com.facebook.orca.sms;

import com.facebook.analytics.AnalyticsPropertyUtil;
import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.database.DbParticipantsSerialization;
import com.facebook.orca.database.ThreadsDatabaseSupplier;
import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$MmsSmsLogExternalMessagesLogicProvider extends AbstractProvider<MmsSmsLogExternalMessagesLogic>
{
  private MmsSmsModule$MmsSmsLogExternalMessagesLogicProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsSmsLogExternalMessagesLogic a()
  {
    return new MmsSmsLogExternalMessagesLogic((DataCache)b(DataCache.class), a(Boolean.class, IsClientSmsEnabled.class), (ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class), (DbParticipantsSerialization)b(DbParticipantsSerialization.class), (AnalyticsPropertyUtil)b(AnalyticsPropertyUtil.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsSmsLogExternalMessagesLogicProvider
 * JD-Core Version:    0.6.0
 */