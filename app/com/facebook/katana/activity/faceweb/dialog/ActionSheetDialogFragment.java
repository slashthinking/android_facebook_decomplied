package com.facebook.katana.activity.faceweb.dialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.jsonmirror.JMException;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.activity.faceweb.ActionSheetButton;
import com.fasterxml.jackson.core.JsonParseException;
import java.io.IOException;
import java.util.List;

public class ActionSheetDialogFragment extends BaseFacewebDialogFragment
{
  private List<ActionSheetButton> Y = null;

  public static BaseFacewebDialogFragment a(String paramString, boolean paramBoolean)
  {
    ActionSheetDialogFragment localActionSheetDialogFragment = new ActionSheetDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("action_sheet_buttons", paramString);
    localBundle.getBoolean("action_sheet_hide_cancel", paramBoolean);
    localActionSheetDialogFragment.f(localBundle);
    return localActionSheetDialogFragment;
  }

  public Dialog c(Bundle paramBundle)
  {
    String str = m().getString("action_sheet_buttons");
    FBJsonFactory localFBJsonFactory = FBJsonFactory.a;
    this.Y = null;
    try
    {
      this.Y = JMParser.b(localFBJsonFactory.createJsonParser(str), ActionSheetButton.class);
      if ((this.Y == null) || (this.Y.size() == 0))
      {
        localAlertDialog = new AlertDialog.Builder(n()).setTitle(2131362911).setMessage(2131362911).setNegativeButton(2131361888, new ActionSheetDialogFragment.1(this)).create();
        return localAlertDialog;
      }
    }
    catch (JsonParseException localJsonParseException)
    {
      while (true)
        ErrorReporting.a("JSON", "Could not parse JSON:" + str, localJsonParseException);
    }
    catch (IOException localIOException)
    {
      while (true)
        ErrorReporting.a("JSON", "IOError in JSON parser", localIOException);
    }
    catch (JMException localJMException)
    {
      while (true)
      {
        ErrorReporting.a("JSON", "JMParser could not parse JSON:" + str, localJMException);
        continue;
        CharSequence[] arrayOfCharSequence = new CharSequence[this.Y.size()];
        for (int i = 0; i < this.Y.size(); i++)
          arrayOfCharSequence[i] = ((ActionSheetButton)this.Y.get(i)).title;
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(n()).setItems(arrayOfCharSequence, new ActionSheetDialogFragment.2(this));
        if (!m().getBoolean("action_sheet_hide_cancel"))
          localBuilder.setNegativeButton(2131362848, new ActionSheetDialogFragment.3(this));
        AlertDialog localAlertDialog = localBuilder.create();
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.dialog.ActionSheetDialogFragment
 * JD-Core Version:    0.6.0
 */