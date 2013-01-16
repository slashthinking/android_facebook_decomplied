package com.facebook.orca.messageview;

import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threadview.RowReceiptParticipant;
import java.util.List;

public class MessageReaderListView$Parameters
{
  private List<RowReceiptParticipant> a;
  private List<ParticipantInfo> b;
  private ThreadSummary c;
  private Message d;

  public List<RowReceiptParticipant> a()
  {
    return this.a;
  }

  public void a(Message paramMessage)
  {
    this.d = paramMessage;
  }

  public void a(ThreadSummary paramThreadSummary)
  {
    this.c = paramThreadSummary;
  }

  public void a(List<RowReceiptParticipant> paramList)
  {
    this.a = paramList;
  }

  public List<ParticipantInfo> b()
  {
    return this.b;
  }

  public void b(List<ParticipantInfo> paramList)
  {
    this.b = paramList;
  }

  public ThreadSummary c()
  {
    return this.c;
  }

  public Message d()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.messageview.MessageReaderListView.Parameters
 * JD-Core Version:    0.6.0
 */