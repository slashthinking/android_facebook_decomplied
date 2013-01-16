package com.facebook.ipc.pages;

import android.net.Uri;
import com.facebook.base.BuildConstants;

public class PagesContract
{
  public static final String a = BuildConstants.b() + ".provider.PagesProvider";
  public static final Uri b;
  public static final Uri c;
  public static final Uri d;
  private static final String e = "content://" + a + "/";

  static
  {
    b = Uri.parse(e + "default_page_images");
    c = Uri.parse(e + "page_search_results");
    d = Uri.parse(e + "page_search_results" + "/uid");
  }

  public static String[] a()
  {
    return new String[] { "page_search_results", "default_page_images" };
  }

  public static String[] b()
  {
    return new String[] { "CREATE TABLE page_search_results (_id INTEGER PRIMARY KEY,page_id INT,display_name TEXT,pic TEXT);", "CREATE TABLE default_page_images (_id INTEGER PRIMARY KEY,pic BLOB);" };
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.pages.PagesContract
 * JD-Core Version:    0.6.0
 */