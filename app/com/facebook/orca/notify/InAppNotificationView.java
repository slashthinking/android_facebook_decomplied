package com.facebook.orca.notify;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.orca.emoji.EmojiUtil;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadSnippetUtil;
import com.facebook.widget.CustomViewGroup;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InAppNotificationView extends CustomViewGroup
{
  private static final Pattern a = Pattern.compile("\\n+");
  private UserTileView b;
  private TextView c;
  private TextView d;
  private ImageButton e;
  private Message f;
  private final Context g;
  private final EmojiUtil h;
  private final ThreadSnippetUtil i;

  public InAppNotificationView(Context paramContext, EmojiUtil paramEmojiUtil, ThreadSnippetUtil paramThreadSnippetUtil)
  {
    super(paramContext);
    this.g = paramContext;
    this.h = paramEmojiUtil;
    this.i = paramThreadSnippetUtil;
    a(paramContext);
  }

  private String a(Message paramMessage)
  {
    String str = this.i.a(paramMessage);
    if (str == null)
      str = "";
    while (true)
    {
      return str;
      Matcher localMatcher = a.matcher(str);
      if (!localMatcher.find())
        continue;
      str = localMatcher.replaceAll(" ");
    }
  }

  private void a(Context paramContext)
  {
    setContentView(2130903350);
    this.b = ((UserTileView)getView(2131297305));
    this.c = ((TextView)getView(2131297307));
    this.d = ((TextView)getView(2131297308));
    this.e = ((ImageButton)getView(2131297306));
  }

  public Message getMessage()
  {
    return this.f;
  }

  public void setMessage(Message paramMessage)
  {
    this.f = paramMessage;
    ParticipantInfo localParticipantInfo = paramMessage.f();
    if (localParticipantInfo != null)
    {
      this.c.setText(localParticipantInfo.d());
      this.b.setParams(UserTileViewParams.a(localParticipantInfo.e()));
    }
    while (true)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(a(paramMessage));
      int j = this.g.getResources().getDimensionPixelSize(2131230897);
      this.h.a(localSpannableStringBuilder, j);
      this.d.setText(localSpannableStringBuilder);
      return;
      this.c.setText("");
      this.b.setParams(null);
    }
  }

  public void setOnDismissListener(View.OnClickListener paramOnClickListener)
  {
    this.e.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.InAppNotificationView
 * JD-Core Version:    0.6.0
 */