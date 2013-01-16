package com.facebook.contacts.contactcard;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.users.UserKey;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Objects;

public class ThreadMemberRow extends CustomViewGroup
{
  private final TextView a;
  private final TextView b;
  private final UserTileView c;
  private ThreadParticipant d;

  public ThreadMemberRow(Context paramContext)
  {
    this(paramContext, null);
  }

  public ThreadMemberRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ThreadMemberRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903411);
    setClickable(true);
    if (Build.VERSION.SDK_INT >= 14)
      setBackgroundResource(2130838636);
    while (true)
    {
      this.a = ((TextView)getView(2131297475));
      this.b = ((TextView)getView(2131297476));
      this.c = ((UserTileView)getView(2131297474));
      getView(2131297477).setVisibility(8);
      return;
      setBackgroundResource(17301602);
    }
  }

  public ThreadParticipant getParticipant()
  {
    return this.d;
  }

  public void setParticipant(ThreadParticipant paramThreadParticipant)
  {
    this.d = paramThreadParticipant;
    String str1 = paramThreadParticipant.a().d();
    this.a.setText(str1);
    String str2;
    if (paramThreadParticipant.c())
    {
      str2 = paramThreadParticipant.d().b();
      if (!StringUtil.a(str2))
        break label125;
      this.b.setVisibility(8);
    }
    while (true)
    {
      this.c.setParams(UserTileViewParams.a(paramThreadParticipant));
      return;
      boolean bool1 = paramThreadParticipant.b();
      str2 = null;
      if (bool1)
        break;
      boolean bool2 = StringUtil.a(paramThreadParticipant.e());
      str2 = null;
      if (bool2)
        break;
      boolean bool3 = Objects.equal(paramThreadParticipant.f(), paramThreadParticipant.e());
      str2 = null;
      if (bool3)
        break;
      str2 = paramThreadParticipant.e();
      break;
      label125: this.b.setText(str2);
      this.b.setVisibility(0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.ThreadMemberRow
 * JD-Core Version:    0.6.0
 */