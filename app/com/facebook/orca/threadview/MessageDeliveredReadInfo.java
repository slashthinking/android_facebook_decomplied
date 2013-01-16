package com.facebook.orca.threadview;

import com.facebook.orca.threads.ParticipantInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

public class MessageDeliveredReadInfo
{
  private final MessageDeliveredReadInfo.Type a;
  private List<RowReceiptParticipant> b;
  private ParticipantInfo c;
  private long d;

  private MessageDeliveredReadInfo(MessageDeliveredReadInfo.Type paramType)
  {
    this(paramType, -1L);
  }

  private MessageDeliveredReadInfo(MessageDeliveredReadInfo.Type paramType, long paramLong)
  {
    this.a = paramType;
    this.d = paramLong;
  }

  public static MessageDeliveredReadInfo a(long paramLong)
  {
    return new MessageDeliveredReadInfo(MessageDeliveredReadInfo.Type.READER, paramLong);
  }

  public static MessageDeliveredReadInfo a(ParticipantInfo paramParticipantInfo)
  {
    MessageDeliveredReadInfo localMessageDeliveredReadInfo = new MessageDeliveredReadInfo(MessageDeliveredReadInfo.Type.SENDER);
    localMessageDeliveredReadInfo.b(paramParticipantInfo);
    return localMessageDeliveredReadInfo;
  }

  private void b(ParticipantInfo paramParticipantInfo)
  {
    this.c = paramParticipantInfo;
  }

  public List<RowReceiptParticipant> a()
  {
    if (this.a == MessageDeliveredReadInfo.Type.READER);
    for (List localList = this.b; ; localList = null)
      return localList;
  }

  public void a(RowReceiptParticipant paramRowReceiptParticipant)
  {
    if (this.a == MessageDeliveredReadInfo.Type.READER);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "MessageDeliveredReadInfo is not of type READER - Cannot add a reader");
      if (this.b == null)
        this.b = Lists.a();
      int i = Collections.binarySearch(this.b, paramRowReceiptParticipant, RowReceiptParticipant.a);
      if (i < 0)
        i = -1 + -i;
      this.b.add(i, paramRowReceiptParticipant);
      return;
    }
  }

  public ParticipantInfo b()
  {
    if (this.a == MessageDeliveredReadInfo.Type.SENDER);
    for (ParticipantInfo localParticipantInfo = this.c; ; localParticipantInfo = null)
      return localParticipantInfo;
  }

  public ParticipantInfo c()
  {
    if (this.a == MessageDeliveredReadInfo.Type.DELIVEREE);
    for (ParticipantInfo localParticipantInfo = this.c; ; localParticipantInfo = null)
      return localParticipantInfo;
  }

  public MessageDeliveredReadInfo.Type d()
  {
    return this.a;
  }

  public long e()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.MessageDeliveredReadInfo
 * JD-Core Version:    0.6.0
 */