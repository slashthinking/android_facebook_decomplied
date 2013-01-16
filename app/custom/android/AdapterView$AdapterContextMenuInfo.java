package custom.android;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

public class AdapterView$AdapterContextMenuInfo
  implements ContextMenu.ContextMenuInfo
{
  public View a;
  public int b;
  public long c;

  public AdapterView$AdapterContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    this.a = paramView;
    this.b = paramInt;
    this.c = paramLong;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     custom.android.AdapterView.AdapterContextMenuInfo
 * JD-Core Version:    0.6.0
 */