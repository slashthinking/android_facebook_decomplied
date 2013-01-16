package com.facebook.orca.app;

import android.content.res.Resources;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.common.ui.widgets.text.TextListWithMoreComputer;
import com.facebook.orca.common.ui.widgets.text.ThreadNameView.TextOptions;
import com.facebook.orca.common.ui.widgets.text.ThreadNameViewComputer;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$NamesOnlyThreadNameViewComputerProvider extends AbstractProvider<ThreadNameViewComputer>
{
  private MessagesModule$NamesOnlyThreadNameViewComputerProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadNameViewComputer a()
  {
    return new ThreadNameViewComputer((ThreadDisplayCache)b(ThreadDisplayCache.class), (Resources)b(Resources.class), (TextListWithMoreComputer)b(TextListWithMoreComputer.class), ThreadNameView.TextOptions.USE_PARTICIPANTS_NAMES_ONLY);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.NamesOnlyThreadNameViewComputerProvider
 * JD-Core Version:    0.6.0
 */