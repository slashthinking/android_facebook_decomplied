package com.facebook.orca.threadview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.threads.Message;
import com.facebook.widget.animatablelistview.ItemBasedListAdapter;

public class MessageListAdapter
  implements ItemBasedListAdapter<RowItem>
{
  public static final RowItem a = new SimpleRowItem(1);
  public static final RowItem b = new SimpleRowItem(2);
  public static final RowItem c = new SimpleRowItem(3);
  private final Context d;
  private final LayoutInflater e;
  private MessageListAdapter.MessageListAdapterListener f;

  public MessageListAdapter(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    this.d = paramContext;
    this.e = paramLayoutInflater;
  }

  private View a(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.e.inflate(2130903352, paramViewGroup, false);
    return paramView;
  }

  private View a(RowItem paramRowItem, View paramView)
  {
    ReceiptItemView localReceiptItemView = (ReceiptItemView)paramView;
    if (localReceiptItemView == null)
      localReceiptItemView = new ReceiptItemView(this.d);
    localReceiptItemView.setRowReceiptItem((RowReceiptItem)paramRowItem);
    return localReceiptItemView;
  }

  private View a(RowItem paramRowItem, View paramView, boolean paramBoolean)
  {
    MessageItemView localMessageItemView = (MessageItemView)paramView;
    if (localMessageItemView == null)
      localMessageItemView = new MessageItemView(this.d, paramBoolean);
    localMessageItemView.setRowMessageItem((RowMessageItem)paramRowItem, this);
    return localMessageItemView;
  }

  private View b(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.e.inflate(2130903351, paramViewGroup, false);
    return paramView;
  }

  private View b(RowItem paramRowItem, View paramView)
  {
    RowTypingItem localRowTypingItem = (RowTypingItem)paramRowItem;
    TypingItemView localTypingItemView = (TypingItemView)paramView;
    if (localTypingItemView == null)
      localTypingItemView = new TypingItemView(this.d);
    localTypingItemView.setTypingItem(localRowTypingItem);
    return localTypingItemView;
  }

  private View c(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.e.inflate(2130903353, paramViewGroup, false);
    return paramView;
  }

  private View c(RowItem paramRowItem, View paramView)
  {
    AdminMessageItemView localAdminMessageItemView = (AdminMessageItemView)paramView;
    if (localAdminMessageItemView == null)
      localAdminMessageItemView = new AdminMessageItemView(this.d);
    localAdminMessageItemView.setMessage(((RowMessageItem)paramRowItem).b());
    return localAdminMessageItemView;
  }

  public int a()
  {
    return 24;
  }

  public View a(RowItem paramRowItem, View paramView, ViewGroup paramViewGroup)
  {
    if (paramRowItem == null)
      throw new IllegalArgumentException("Null item");
    View localView;
    switch (paramRowItem.a())
    {
    default:
      throw new IllegalArgumentException("Unknown object type " + paramRowItem.getClass());
    case 1:
      localView = a(paramView, paramViewGroup);
    case 2:
    case 3:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    case 20:
    case 21:
    case 22:
    case 23:
    case 0:
    case 4:
    case 5:
    }
    while (true)
    {
      return localView;
      localView = b(paramView, paramViewGroup);
      continue;
      localView = c(paramView, paramViewGroup);
      continue;
      localView = a(paramRowItem, paramView, false);
      continue;
      localView = a(paramRowItem, paramView, true);
      continue;
      localView = c(paramRowItem, paramView);
      continue;
      localView = a(paramRowItem, paramView);
      continue;
      localView = b(paramRowItem, paramView);
    }
  }

  public void a(MessageListAdapter.MessageListAdapterListener paramMessageListAdapterListener)
  {
    this.f = paramMessageListAdapterListener;
  }

  public boolean a(RowItem paramRowItem)
  {
    int i = 1;
    if ((paramRowItem instanceof RowMessageItem))
      if (((RowMessageItem)paramRowItem).b().q());
    while (true)
    {
      return i;
      i = 0;
      continue;
      if (paramRowItem == b)
        continue;
      i = 0;
    }
  }

  public long b(RowItem paramRowItem)
  {
    long l;
    if (paramRowItem == a)
      l = 1L;
    while (true)
    {
      return l;
      if (paramRowItem == b)
      {
        l = 2L;
        continue;
      }
      if (paramRowItem == c)
      {
        l = 3L;
        continue;
      }
      if ((paramRowItem instanceof RowMessageItem))
      {
        l = StringUtil.e(((RowMessageItem)paramRowItem).b().a());
        continue;
      }
      l = -9223372036854775808L;
    }
  }

  public boolean b()
  {
    return true;
  }

  public int c(RowItem paramRowItem)
  {
    return paramRowItem.a();
  }

  public void d(RowItem paramRowItem)
  {
    if (this.f != null)
      this.f.a(paramRowItem);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.MessageListAdapter
 * JD-Core Version:    0.6.0
 */