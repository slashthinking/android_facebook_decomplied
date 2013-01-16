package com.facebook.orca.merge;

import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.google.common.base.Function;
import java.util.Collection;

final class MergingUtil$2
  implements Function<MessagesCollection, Collection<Message>>
{
  public Collection<Message> a(MessagesCollection paramMessagesCollection)
  {
    return paramMessagesCollection.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil.2
 * JD-Core Version:    0.6.0
 */