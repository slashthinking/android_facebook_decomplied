package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter extends BaseAdapter
  implements CursorFilter.CursorFilterClient, Filterable
{
  protected boolean a;
  protected boolean b;
  protected Cursor c;
  protected Context d;
  protected int e;
  protected CursorAdapter.ChangeObserver f;
  protected DataSetObserver g;
  protected CursorFilter h;
  protected FilterQueryProvider i;

  public CursorAdapter(Context paramContext, Cursor paramCursor, int paramInt)
  {
    a(paramContext, paramCursor, paramInt);
  }

  public Cursor a()
  {
    return this.c;
  }

  public Cursor a(CharSequence paramCharSequence)
  {
    if (this.i != null);
    for (Cursor localCursor = this.i.runQuery(paramCharSequence); ; localCursor = this.c)
      return localCursor;
  }

  public abstract View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);

  void a(Context paramContext, Cursor paramCursor, int paramInt)
  {
    int j = 1;
    label25: int k;
    if ((paramInt & 0x1) == j)
    {
      paramInt |= 2;
      this.b = j;
      if (paramCursor == null)
        break label142;
      this.c = paramCursor;
      this.a = j;
      this.d = paramContext;
      if (j == 0)
        break label148;
      k = paramCursor.getColumnIndexOrThrow("_id");
      label56: this.e = k;
      if ((paramInt & 0x2) != 2)
        break label154;
      this.f = new CursorAdapter.ChangeObserver(this);
    }
    for (this.g = new CursorAdapter.MyDataSetObserver(this, null); ; this.g = null)
    {
      if (j != 0)
      {
        if (this.f != null)
          paramCursor.registerContentObserver(this.f);
        if (this.g != null)
          paramCursor.registerDataSetObserver(this.g);
      }
      return;
      this.b = false;
      break;
      label142: j = 0;
      break label25;
      label148: k = -1;
      break label56;
      label154: this.f = null;
    }
  }

  public void a(Cursor paramCursor)
  {
    Cursor localCursor = b(paramCursor);
    if (localCursor != null)
      localCursor.close();
  }

  public abstract void a(View paramView, Context paramContext, Cursor paramCursor);

  public Cursor b(Cursor paramCursor)
  {
    Cursor localCursor;
    if (paramCursor == this.c)
      localCursor = null;
    while (true)
    {
      return localCursor;
      localCursor = this.c;
      if (localCursor != null)
      {
        if (this.f != null)
          localCursor.unregisterContentObserver(this.f);
        if (this.g != null)
          localCursor.unregisterDataSetObserver(this.g);
      }
      this.c = paramCursor;
      if (paramCursor != null)
      {
        if (this.f != null)
          paramCursor.registerContentObserver(this.f);
        if (this.g != null)
          paramCursor.registerDataSetObserver(this.g);
        this.e = paramCursor.getColumnIndexOrThrow("_id");
        this.a = true;
        notifyDataSetChanged();
        continue;
      }
      this.e = -1;
      this.a = false;
      notifyDataSetInvalidated();
    }
  }

  public View b(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return a(paramContext, paramCursor, paramViewGroup);
  }

  protected void b()
  {
    if ((this.b) && (this.c != null) && (!this.c.isClosed()))
      this.a = this.c.requery();
  }

  public CharSequence c(Cursor paramCursor)
  {
    if (paramCursor == null);
    for (String str = ""; ; str = paramCursor.toString())
      return str;
  }

  public int getCount()
  {
    if ((this.a) && (this.c != null));
    for (int j = this.c.getCount(); ; j = 0)
      return j;
  }

  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a)
    {
      this.c.moveToPosition(paramInt);
      if (paramView == null)
        paramView = b(this.d, this.c, paramViewGroup);
      a(paramView, this.d, this.c);
    }
    while (true)
    {
      return paramView;
      paramView = null;
    }
  }

  public Filter getFilter()
  {
    if (this.h == null)
      this.h = new CursorFilter(this);
    return this.h;
  }

  public Object getItem(int paramInt)
  {
    if ((this.a) && (this.c != null))
      this.c.moveToPosition(paramInt);
    for (Cursor localCursor = this.c; ; localCursor = null)
      return localCursor;
  }

  public long getItemId(int paramInt)
  {
    long l = 0L;
    if ((this.a) && (this.c != null) && (this.c.moveToPosition(paramInt)))
      l = this.c.getLong(this.e);
    return l;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.a)
      throw new IllegalStateException("this should only be called when the cursor is valid");
    if (!this.c.moveToPosition(paramInt))
      throw new IllegalStateException("couldn't move cursor to position " + paramInt);
    if (paramView == null)
      paramView = a(this.d, this.c, paramViewGroup);
    a(paramView, this.d, this.c);
    return paramView;
  }

  public boolean hasStableIds()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.CursorAdapter
 * JD-Core Version:    0.6.0
 */