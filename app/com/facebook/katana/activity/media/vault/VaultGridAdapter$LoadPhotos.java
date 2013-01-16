package com.facebook.katana.activity.media.vault;

import android.os.AsyncTask;
import com.facebook.photos.grid.UrlImageGrid;
import com.facebook.photos.grid.UrlImageGrid.UI_STATE;

public class VaultGridAdapter$LoadPhotos extends AsyncTask<String, Void, Void>
{
  public VaultGridAdapter$LoadPhotos(VaultGridAdapter paramVaultGridAdapter)
  {
  }

  // ERROR //
  protected Void a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 11	com/facebook/katana/activity/media/vault/VaultGridAdapter$LoadPhotos:a	Lcom/facebook/katana/activity/media/vault/VaultGridAdapter;
    //   8: invokestatic 22	com/facebook/katana/activity/media/vault/VaultGridAdapter:a	(Lcom/facebook/katana/activity/media/vault/VaultGridAdapter;)Landroid/content/Context;
    //   11: invokestatic 27	com/facebook/orca/inject/FbInjector:a	(Landroid/content/Context;)Lcom/facebook/orca/inject/FbInjector;
    //   14: ldc 29
    //   16: invokevirtual 32	com/facebook/orca/inject/FbInjector:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   19: checkcast 29	com/facebook/orca/protocol/base/SingleMethodRunner
    //   22: astore_3
    //   23: aload_3
    //   24: new 34	com/facebook/katana/service/vault/methods/VaultAllImagesGetMethod
    //   27: dup
    //   28: invokespecial 35	com/facebook/katana/service/vault/methods/VaultAllImagesGetMethod:<init>	()V
    //   31: new 37	com/facebook/katana/service/vault/methods/VaultAllImagesGetParams
    //   34: dup
    //   35: bipush 40
    //   37: aload_2
    //   38: invokespecial 40	com/facebook/katana/service/vault/methods/VaultAllImagesGetParams:<init>	(ILjava/lang/String;)V
    //   41: invokevirtual 43	com/facebook/orca/protocol/base/SingleMethodRunner:a	(Lcom/facebook/orca/protocol/base/ApiMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 45	com/facebook/katana/service/vault/methods/VaultAllImagesGetResult
    //   47: astore 5
    //   49: aload_0
    //   50: monitorenter
    //   51: aload 5
    //   53: getfield 49	com/facebook/katana/service/vault/methods/VaultAllImagesGetResult:data	Ljava/util/List;
    //   56: invokeinterface 55 1 0
    //   61: ifle +184 -> 245
    //   64: aload_0
    //   65: getfield 11	com/facebook/katana/activity/media/vault/VaultGridAdapter$LoadPhotos:a	Lcom/facebook/katana/activity/media/vault/VaultGridAdapter;
    //   68: iconst_0
    //   69: invokevirtual 59	com/facebook/katana/activity/media/vault/VaultGridAdapter:setNotifyOnChange	(Z)V
    //   72: aload 5
    //   74: getfield 49	com/facebook/katana/service/vault/methods/VaultAllImagesGetResult:data	Ljava/util/List;
    //   77: invokeinterface 63 1 0
    //   82: astore 7
    //   84: aload 7
    //   86: invokeinterface 69 1 0
    //   91: ifeq +98 -> 189
    //   94: aload 7
    //   96: invokeinterface 73 1 0
    //   101: checkcast 75	com/facebook/katana/service/vault/methods/VaultImageResultObject
    //   104: astore 10
    //   106: aload 10
    //   108: getfield 79	com/facebook/katana/service/vault/methods/VaultImageResultObject:dateTaken	Ljava/lang/String;
    //   111: ldc 81
    //   113: ldc 83
    //   115: invokevirtual 89	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   118: astore 11
    //   120: new 91	java/text/SimpleDateFormat
    //   123: dup
    //   124: ldc 93
    //   126: invokespecial 96	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   129: aload 11
    //   131: invokevirtual 100	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   134: astore 12
    //   136: aload_0
    //   137: getfield 11	com/facebook/katana/activity/media/vault/VaultGridAdapter$LoadPhotos:a	Lcom/facebook/katana/activity/media/vault/VaultGridAdapter;
    //   140: new 102	com/facebook/photos/photogallery/photos/VaultRemotePhoto
    //   143: dup
    //   144: aload 10
    //   146: getfield 106	com/facebook/katana/service/vault/methods/VaultImageResultObject:fbid	J
    //   149: aload 10
    //   151: getfield 109	com/facebook/katana/service/vault/methods/VaultImageResultObject:uri	Ljava/lang/String;
    //   154: aload 12
    //   156: invokevirtual 115	java/util/Date:getTime	()J
    //   159: invokespecial 118	com/facebook/photos/photogallery/photos/VaultRemotePhoto:<init>	(JLjava/lang/String;J)V
    //   162: invokevirtual 122	com/facebook/katana/activity/media/vault/VaultGridAdapter:add	(Ljava/lang/Object;)V
    //   165: goto -81 -> 84
    //   168: astore 6
    //   170: aload_0
    //   171: monitorexit
    //   172: aload 6
    //   174: athrow
    //   175: astore 4
    //   177: invokestatic 126	com/facebook/katana/activity/media/vault/VaultGridAdapter:d	()Ljava/lang/String;
    //   180: ldc 128
    //   182: aload 4
    //   184: invokestatic 133	com/facebook/common/util/Log:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: aconst_null
    //   188: areturn
    //   189: aload_0
    //   190: getfield 11	com/facebook/katana/activity/media/vault/VaultGridAdapter$LoadPhotos:a	Lcom/facebook/katana/activity/media/vault/VaultGridAdapter;
    //   193: invokevirtual 136	com/facebook/katana/activity/media/vault/VaultGridAdapter:c	()V
    //   196: aload_0
    //   197: getfield 11	com/facebook/katana/activity/media/vault/VaultGridAdapter$LoadPhotos:a	Lcom/facebook/katana/activity/media/vault/VaultGridAdapter;
    //   200: iconst_1
    //   201: invokevirtual 59	com/facebook/katana/activity/media/vault/VaultGridAdapter:setNotifyOnChange	(Z)V
    //   204: aload 5
    //   206: getfield 140	com/facebook/katana/service/vault/methods/VaultAllImagesGetResult:paging	Ljava/util/Map;
    //   209: ldc 141
    //   211: invokeinterface 147 2 0
    //   216: checkcast 85	java/lang/String
    //   219: astore 8
    //   221: aload 8
    //   223: ifnonnull +27 -> 250
    //   226: aload_0
    //   227: getfield 11	com/facebook/katana/activity/media/vault/VaultGridAdapter$LoadPhotos:a	Lcom/facebook/katana/activity/media/vault/VaultGridAdapter;
    //   230: getstatic 153	com/facebook/katana/activity/media/vault/VaultGridAdapter$DATA_LOADER_STATE:FETCHED_ALL	Lcom/facebook/katana/activity/media/vault/VaultGridAdapter$DATA_LOADER_STATE;
    //   233: putfield 155	com/facebook/katana/activity/media/vault/VaultGridAdapter:a	Lcom/facebook/katana/activity/media/vault/VaultGridAdapter$DATA_LOADER_STATE;
    //   236: aload_0
    //   237: getfield 11	com/facebook/katana/activity/media/vault/VaultGridAdapter$LoadPhotos:a	Lcom/facebook/katana/activity/media/vault/VaultGridAdapter;
    //   240: ldc 83
    //   242: putfield 158	com/facebook/katana/activity/media/vault/VaultGridAdapter:b	Ljava/lang/String;
    //   245: aload_0
    //   246: monitorexit
    //   247: goto -60 -> 187
    //   250: aload 8
    //   252: invokestatic 163	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   255: astore 9
    //   257: aload_0
    //   258: getfield 11	com/facebook/katana/activity/media/vault/VaultGridAdapter$LoadPhotos:a	Lcom/facebook/katana/activity/media/vault/VaultGridAdapter;
    //   261: aload 9
    //   263: ldc 165
    //   265: invokevirtual 169	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   268: putfield 158	com/facebook/katana/activity/media/vault/VaultGridAdapter:b	Ljava/lang/String;
    //   271: goto -26 -> 245
    //
    // Exception table:
    //   from	to	target	type
    //   51	172	168	finally
    //   189	271	168	finally
    //   23	51	175	java/lang/Exception
    //   172	175	175	java/lang/Exception
  }

  protected void a(Void paramVoid)
  {
    this.a.notifyDataSetChanged();
    if (this.a.getCount() > 0)
    {
      VaultGridAdapter.b(this.a);
      VaultGridAdapter.c(this.a).a(UrlImageGrid.UI_STATE.HAS_PHOTO);
    }
    while (true)
    {
      if (this.a.a != VaultGridAdapter.DATA_LOADER_STATE.FETCHED_ALL)
        this.a.a = VaultGridAdapter.DATA_LOADER_STATE.IDLE;
      return;
      VaultGridAdapter.d(this.a).a(UrlImageGrid.UI_STATE.NO_PHOTO);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultGridAdapter.LoadPhotos
 * JD-Core Version:    0.6.0
 */