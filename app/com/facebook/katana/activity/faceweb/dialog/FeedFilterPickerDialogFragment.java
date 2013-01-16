package com.facebook.katana.activity.faceweb.dialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.jsonmirror.JMException;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.Log;
import com.facebook.katana.model.NewsFeedToggleOption;
import com.fasterxml.jackson.core.JsonParseException;
import java.io.IOException;
import java.util.List;

public class FeedFilterPickerDialogFragment extends BaseFacewebDialogFragment
{
  private List<NewsFeedToggleOption> Y = null;

  public static BaseFacewebDialogFragment a(String paramString1, String paramString2, int paramInt)
  {
    FeedFilterPickerDialogFragment localFeedFilterPickerDialogFragment = new FeedFilterPickerDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("feed_filter_buttons", paramString1);
    localBundle.putString("feed_filter_dismiss_script", paramString2);
    localBundle.putInt("feed_filter_selected_index", paramInt);
    localFeedFilterPickerDialogFragment.f(localBundle);
    return localFeedFilterPickerDialogFragment;
  }

  public Dialog c(Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = n();
    String str1 = m().getString("feed_filter_dismiss_script");
    int i = m().getInt("feed_filter_selected_index");
    try
    {
      String str2 = m().getString("feed_filter_buttons");
      this.Y = JMParser.b(FBJsonFactory.a.createJsonParser(str2), NewsFeedToggleOption.class);
      if ((this.Y == null) || (this.Y.size() == 0))
      {
        localAlertDialog = new AlertDialog.Builder(localFragmentActivity).setTitle(2131362911).setMessage(2131362911).setNegativeButton(2131361888, new FeedFilterPickerDialogFragment.1(this)).create();
        return localAlertDialog;
      }
    }
    catch (JsonParseException localJsonParseException)
    {
      while (true)
        Log.a("received bad faceweb data", localJsonParseException);
    }
    catch (IOException localIOException)
    {
      while (true)
        Log.a("received bad faceweb data", localIOException);
    }
    catch (JMException localJMException)
    {
      while (true)
      {
        Log.a("received bad faceweb data", localJMException);
        continue;
        CharSequence[] arrayOfCharSequence = new CharSequence[this.Y.size()];
        for (int j = 0; j < this.Y.size(); j++)
          arrayOfCharSequence[j] = ((NewsFeedToggleOption)this.Y.get(j)).title;
        AlertDialog localAlertDialog = new AlertDialog.Builder(localFragmentActivity).setItems(arrayOfCharSequence, new FeedFilterPickerDialogFragment.2(this, i, str1)).create();
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.dialog.FeedFilterPickerDialogFragment
 * JD-Core Version:    0.6.0
 */