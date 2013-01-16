package com.facebook.katana.nux;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.app.DialogFragment;
import android.widget.ImageView;
import com.facebook.katana.fragment.dialog.ProgressDialogFragment;

class SetProfilePicActivity$LoadProfilePicture extends AsyncTask<String, Void, Bitmap>
{
  private final DialogFragment b = ProgressDialogFragment.a(2131362850, true, false);

  private SetProfilePicActivity$LoadProfilePicture(SetProfilePicActivity paramSetProfilePicActivity)
  {
    this.b.e(true);
  }

  // ERROR //
  protected Bitmap a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 38	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: iconst_0
    //   6: aaload
    //   7: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 45	java/io/File:exists	()Z
    //   15: istore_3
    //   16: aconst_null
    //   17: astore 4
    //   19: iload_3
    //   20: ifne +6 -> 26
    //   23: aload 4
    //   25: areturn
    //   26: new 38	java/io/File
    //   29: dup
    //   30: aload_0
    //   31: getfield 13	com/facebook/katana/nux/SetProfilePicActivity$LoadProfilePicture:a	Lcom/facebook/katana/nux/SetProfilePicActivity;
    //   34: ldc 47
    //   36: iconst_0
    //   37: invokevirtual 53	com/facebook/katana/nux/SetProfilePicActivity:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   40: new 55	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   47: ldc 58
    //   49: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: bipush 6
    //   54: invokestatic 67	com/facebook/katana/util/StringUtils:a	(I)Ljava/lang/String;
    //   57: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 74	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   66: astore 5
    //   68: aload_0
    //   69: getfield 13	com/facebook/katana/nux/SetProfilePicActivity$LoadProfilePicture:a	Lcom/facebook/katana/nux/SetProfilePicActivity;
    //   72: aload 5
    //   74: invokevirtual 77	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   77: invokestatic 80	com/facebook/katana/nux/SetProfilePicActivity:a	(Lcom/facebook/katana/nux/SetProfilePicActivity;Ljava/lang/String;)Ljava/lang/String;
    //   80: pop
    //   81: aload_0
    //   82: getfield 13	com/facebook/katana/nux/SetProfilePicActivity$LoadProfilePicture:a	Lcom/facebook/katana/nux/SetProfilePicActivity;
    //   85: invokevirtual 84	com/facebook/katana/nux/SetProfilePicActivity:getApplicationContext	()Landroid/content/Context;
    //   88: aload_2
    //   89: invokestatic 90	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   92: sipush 1280
    //   95: sipush 1280
    //   98: iconst_1
    //   99: invokestatic 95	com/facebook/katana/util/ImageUtils:a	(Landroid/content/Context;Landroid/net/Uri;IIZ)Landroid/graphics/Bitmap;
    //   102: astore 8
    //   104: aload 8
    //   106: invokevirtual 101	android/graphics/Bitmap:getWidth	()I
    //   109: aload 8
    //   111: invokevirtual 104	android/graphics/Bitmap:getHeight	()I
    //   114: invokestatic 110	java/lang/Math:min	(II)I
    //   117: istore 10
    //   119: aload 8
    //   121: iload 10
    //   123: iload 10
    //   125: invokestatic 113	com/facebook/katana/util/ImageUtils:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   128: astore 11
    //   130: aload 11
    //   132: astore 4
    //   134: aload 4
    //   136: getstatic 119	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   139: bipush 100
    //   141: aload 5
    //   143: invokestatic 122	com/facebook/katana/util/ImageUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/io/File;)V
    //   146: goto -123 -> 23
    //   149: astore 7
    //   151: aload_0
    //   152: getfield 13	com/facebook/katana/nux/SetProfilePicActivity$LoadProfilePicture:a	Lcom/facebook/katana/nux/SetProfilePicActivity;
    //   155: invokestatic 126	com/facebook/katana/nux/SetProfilePicActivity:c	(Lcom/facebook/katana/nux/SetProfilePicActivity;)Lcom/facebook/common/util/FbErrorReporter;
    //   158: invokestatic 129	com/facebook/katana/nux/SetProfilePicActivity:i	()Ljava/lang/String;
    //   161: new 55	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   168: ldc 131
    //   170: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 7
    //   175: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokeinterface 139 3 0
    //   186: goto -163 -> 23
    //   189: astore 9
    //   191: aload 8
    //   193: astore 4
    //   195: aload 9
    //   197: astore 7
    //   199: goto -48 -> 151
    //
    // Exception table:
    //   from	to	target	type
    //   81	104	149	com/facebook/katana/util/ImageUtils$ImageException
    //   134	146	149	com/facebook/katana/util/ImageUtils$ImageException
    //   104	130	189	com/facebook/katana/util/ImageUtils$ImageException
  }

  protected void a(Bitmap paramBitmap)
  {
    this.b.b();
    if ((paramBitmap != null) && (SetProfilePicActivity.d(this.a) != null))
      SetProfilePicActivity.d(this.a).setImageBitmap(paramBitmap);
    while (true)
    {
      return;
      this.a.setResult(1001);
      this.a.finish();
    }
  }

  protected void onPreExecute()
  {
    this.b.a(this.a.g(), null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.SetProfilePicActivity.LoadProfilePicture
 * JD-Core Version:    0.6.0
 */