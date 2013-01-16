package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.ui.widgets.text.RowReceiptTextViewComputer;
import com.facebook.orca.common.ui.widgets.text.TextListWithMoreComputer;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$RowReceiptTextViewComputerProvider extends AbstractProvider<RowReceiptTextViewComputer>
{
  private MessagesModule$RowReceiptTextViewComputerProvider(MessagesModule paramMessagesModule)
  {
  }

  public RowReceiptTextViewComputer a()
  {
    return new RowReceiptTextViewComputer((Context)b(Context.class), (DataCache)b(DataCache.class), (TextListWithMoreComputer)b(TextListWithMoreComputer.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.RowReceiptTextViewComputerProvider
 * JD-Core Version:    0.6.0
 */