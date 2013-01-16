package com.facebook.contacts.contactcard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.facebook.contacts.contactcard.entry.TextRowView;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GroupMembersSectionView extends SectionView
{
  private List<ThreadParticipant> a = Collections.emptyList();
  private boolean b = true;
  private GroupMembersSectionView.GroupMembersSectionListener c;

  public GroupMembersSectionView(Context paramContext)
  {
    this(paramContext, null);
  }

  public GroupMembersSectionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public GroupMembersSectionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    b();
    Iterator localIterator = this.a.iterator();
    if (localIterator.hasNext())
    {
      ThreadParticipant localThreadParticipant = (ThreadParticipant)localIterator.next();
      ThreadMemberRow localThreadMemberRow = new ThreadMemberRow(getContext());
      localThreadMemberRow.setParticipant(localThreadParticipant);
      if (localThreadParticipant.d().a() == User.Type.EMAIL)
        localThreadMemberRow.setOnClickListener(new GroupMembersSectionView.1(this));
      while (true)
      {
        b(localThreadMemberRow);
        break;
        localThreadMemberRow.setOnClickListener(new GroupMembersSectionView.2(this));
      }
    }
    if (this.b)
    {
      TextRowView localTextRowView = new TextRowView(getContext());
      localTextRowView.setText(getResources().getString(2131362452));
      localTextRowView.setOnClickListener(new GroupMembersSectionView.3(this));
      b(localTextRowView);
    }
  }

  private void a(ThreadParticipant paramThreadParticipant)
  {
    if (this.c != null)
      this.c.a(paramThreadParticipant.d());
  }

  private void a(UserKey paramUserKey)
  {
    if (User.Type.EMAIL == paramUserKey.a());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      Intent localIntent = new Intent("android.intent.action.SEND");
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramUserKey.b();
      localIntent.putExtra("android.intent.extra.EMAIL", arrayOfString);
      localIntent.setType("plain/text");
      getContext().startActivity(Intent.createChooser(localIntent, ""));
      return;
    }
  }

  private void c()
  {
    if (this.c != null)
      this.c.a();
  }

  public void setGroupMembersSectionListener(GroupMembersSectionView.GroupMembersSectionListener paramGroupMembersSectionListener)
  {
    this.c = paramGroupMembersSectionListener;
  }

  public void setThreadSummary(ThreadSummary paramThreadSummary)
  {
    if ((!MessagingIdUtil.g(paramThreadSummary.a())) && (paramThreadSummary.v()));
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      this.a = paramThreadSummary.i();
      a();
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.GroupMembersSectionView
 * JD-Core Version:    0.6.0
 */