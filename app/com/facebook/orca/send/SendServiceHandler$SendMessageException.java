package com.facebook.orca.send;

import android.os.Parcelable;
import com.facebook.orca.common.base.ExceptionWithExtraData;
import com.facebook.orca.threads.Message;
import com.google.common.base.Preconditions;

class SendServiceHandler$SendMessageException extends Exception
  implements ExceptionWithExtraData
{
  private final Message mOutgoingMessage;

  private SendServiceHandler$SendMessageException(Throwable paramThrowable, Message paramMessage)
  {
    super(paramThrowable);
    this.mOutgoingMessage = ((Message)Preconditions.checkNotNull(paramMessage));
  }

  public Parcelable a()
  {
    return this.mOutgoingMessage;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.send.SendServiceHandler.SendMessageException
 * JD-Core Version:    0.6.0
 */