package com.facebook.katana.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.fragment.NavigableFragment;
import com.facebook.fragment.NavigableFragment.Listener;
import com.facebook.katana.IntentUriHandler;
import com.facebook.orca.intents.MessagingIntentUris;
import com.google.common.base.Preconditions;

class AbstractPopupViewDelegate$7
  implements NavigableFragment.Listener
{
  public void a(NavigableFragment paramNavigableFragment, Intent paramIntent)
  {
    Preconditions.checkArgument(paramIntent.hasExtra("thread_id"));
    String str = paramIntent.getStringExtra("thread_id");
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramIntent.getExtras());
    IntentUriHandler.a(this.a.a.getContext(), AbstractPopupViewDelegate.b(this.a).a(str).toString(), localBundle);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.AbstractPopupViewDelegate.7
 * JD-Core Version:    0.6.0
 */