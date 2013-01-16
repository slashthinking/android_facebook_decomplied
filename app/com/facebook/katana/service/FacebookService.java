package com.facebook.katana.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.model.FacebookNotifications;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.FacebookUserFull;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.service.method.AuthLogin;
import com.facebook.katana.service.method.BatchRunDONOTUSE;
import com.facebook.katana.service.method.ConnectionsSync;
import com.facebook.katana.service.method.FqlGetMutualFriends;
import com.facebook.katana.service.method.FqlGetUsersFriendStatus;
import com.facebook.katana.service.method.FqlGetUsersProfile;
import com.facebook.katana.service.method.FqlMultiQuery;
import com.facebook.katana.service.method.FqlStatusQuery;
import com.facebook.katana.service.method.FriendRequestRespond;
import com.facebook.katana.service.method.NotificationsGet;
import com.facebook.katana.service.method.PhotoDownload;
import com.facebook.katana.service.method.PhotosAddTag;
import com.facebook.katana.service.method.PhotosCreateAlbum;
import com.facebook.katana.service.method.PhotosDeletePhoto;
import com.facebook.katana.service.method.PhotosUpload;
import com.facebook.katana.service.method.ProfileImageDownload;
import com.facebook.katana.service.method.ServiceOperation;
import com.facebook.katana.service.method.ServiceOperationListener;
import com.facebook.katana.service.method.UsersSearch;
import com.facebook.katana.util.PhonebookUtils;
import com.facebook.orca.app.AppInitLock;
import com.facebook.orca.inject.FbInjector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class FacebookService extends Service
  implements ServiceOperationListener
{
  public static Map<String, ServiceOperation> a = new HashMap();
  public static boolean b = true;
  private final Map<String, ServiceOperation> c = Collections.synchronizedMap(new HashMap());
  private Context d;
  private final List<ServiceOperation> e = new LinkedList();
  private final List<ServiceOperation> f = new LinkedList();
  private final List<ServiceOperation> g = new LinkedList();
  private long h;
  private PhonebookUtils i;

  private String a(ServiceOperation paramServiceOperation)
  {
    return paramServiceOperation.o().getStringExtra("rid");
  }

  // ERROR //
  private void a(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 70
    //   3: iconst_0
    //   4: invokevirtual 74	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   7: istore_2
    //   8: aload_1
    //   9: ldc 76
    //   11: iconst_0
    //   12: invokevirtual 74	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   15: istore_3
    //   16: aload_0
    //   17: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   20: iconst_1
    //   21: invokestatic 83	com/facebook/katana/binding/AppSession:a	(Landroid/content/Context;Z)Lcom/facebook/katana/binding/AppSession;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +33 -> 61
    //   31: aload 4
    //   33: invokevirtual 86	com/facebook/katana/binding/AppSession:i	()Lcom/facebook/katana/binding/AppSession$LoginStatus;
    //   36: getstatic 92	com/facebook/katana/binding/AppSession$LoginStatus:STATUS_LOGGING_OUT	Lcom/facebook/katana/binding/AppSession$LoginStatus;
    //   39: if_acmpne +22 -> 61
    //   42: iload_2
    //   43: iconst_2
    //   44: if_icmpeq +17 -> 61
    //   47: iload_2
    //   48: sipush 1000
    //   51: if_icmpne +401 -> 452
    //   54: iload_3
    //   55: sipush 701
    //   58: if_icmpne +394 -> 452
    //   61: iload_2
    //   62: lookupswitch	default:+370->432, 1:+391->453, 2:+571->633, 3:+471->533, 50:+1170->1232, 51:+1194->1256, 52:+1227->1289, 60:+1258->1320, 61:+1298->1360, 62:+1350->1412, 63:+1409->1471, 64:+1449->1511, 65:+1512->1574, 66:+1654->1716, 67:+1692->1754, 68:+1730->1792, 72:+1768->1830, 73:+1768->1830, 74:+1768->1830, 75:+1768->1830, 76:+1768->1830, 77:+1768->1830, 78:+1952->2014, 80:+1035->1097, 81:+1102->1164, 82:+754->816, 83:+931->993, 90:+2078->2140, 91:+2078->2140, 92:+2078->2140, 100:+1872->1934, 131:+2101->2163, 132:+2179->2241, 133:+2232->2294, 140:+2310->2372, 201:+2078->2140, 202:+2078->2140, 203:+2078->2140, 204:+2078->2140, 205:+2078->2140, 211:+2022->2084, 300:+2078->2140, 507:+1967->2029, 1000:+2351->2413, 1001:+2351->2413, 1100:+1074->1136
    //   433: astore 6
    //   435: aload 6
    //   437: ifnull +2014 -> 2451
    //   440: aload_0
    //   441: aload_1
    //   442: ldc 61
    //   444: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   447: aload 6
    //   449: invokespecial 95	com/facebook/katana/service/FacebookService:a	(Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperation;)V
    //   452: return
    //   453: invokestatic 100	com/facebook/base/BuildConstants:a	()Z
    //   456: ifeq +41 -> 497
    //   459: aload_1
    //   460: ldc 102
    //   462: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   465: ifnonnull +32 -> 497
    //   468: ldc 104
    //   470: new 106	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   477: ldc 109
    //   479: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_1
    //   483: ldc 115
    //   485: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   488: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 124	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: new 126	com/facebook/katana/service/method/AuthLogin
    //   500: dup
    //   501: aload_0
    //   502: invokevirtual 130	com/facebook/katana/service/FacebookService:getApplicationContext	()Landroid/content/Context;
    //   505: aload_1
    //   506: aload_1
    //   507: ldc 102
    //   509: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   512: aload_1
    //   513: ldc 132
    //   515: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   518: aload_1
    //   519: ldc 115
    //   521: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   524: aload_0
    //   525: invokespecial 135	com/facebook/katana/service/method/AuthLogin:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   528: astore 6
    //   530: goto -95 -> 435
    //   533: new 137	java/util/ArrayList
    //   536: dup
    //   537: invokespecial 138	java/util/ArrayList:<init>	()V
    //   540: astore 59
    //   542: new 27	java/util/HashMap
    //   545: dup
    //   546: invokespecial 30	java/util/HashMap:<init>	()V
    //   549: astore 60
    //   551: aload_1
    //   552: ldc 140
    //   554: ldc2_w 141
    //   557: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   560: lstore 61
    //   562: aload_1
    //   563: ldc 148
    //   565: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   568: astore 63
    //   570: aload 60
    //   572: lload 61
    //   574: invokestatic 154	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   577: aconst_null
    //   578: invokeinterface 160 3 0
    //   583: pop
    //   584: aload 59
    //   586: new 162	com/facebook/katana/service/method/FqlGetUsersProfile
    //   589: dup
    //   590: aload_0
    //   591: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   594: aload_1
    //   595: aload 63
    //   597: aconst_null
    //   598: aload 60
    //   600: ldc 164
    //   602: invokespecial 167	com/facebook/katana/service/method/FqlGetUsersProfile:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;Ljava/util/Map;Ljava/lang/Class;)V
    //   605: invokeinterface 173 2 0
    //   610: pop
    //   611: new 175	com/facebook/katana/service/method/BatchRunDONOTUSE
    //   614: dup
    //   615: aload_0
    //   616: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   619: aload_1
    //   620: aload 63
    //   622: aload 59
    //   624: aload_0
    //   625: invokespecial 178	com/facebook/katana/service/method/BatchRunDONOTUSE:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/util/List;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   628: astore 6
    //   630: goto -195 -> 435
    //   633: new 137	java/util/ArrayList
    //   636: dup
    //   637: invokespecial 138	java/util/ArrayList:<init>	()V
    //   640: astore 53
    //   642: aload_0
    //   643: getfield 43	com/facebook/katana/service/FacebookService:c	Ljava/util/Map;
    //   646: astore 54
    //   648: aload 54
    //   650: monitorenter
    //   651: aload_0
    //   652: getfield 43	com/facebook/katana/service/FacebookService:c	Ljava/util/Map;
    //   655: invokeinterface 182 1 0
    //   660: invokeinterface 188 1 0
    //   665: astore 56
    //   667: aload 56
    //   669: invokeinterface 193 1 0
    //   674: ifeq +53 -> 727
    //   677: aload 56
    //   679: invokeinterface 197 1 0
    //   684: checkcast 55	com/facebook/katana/service/method/ServiceOperation
    //   687: astore 57
    //   689: aload 57
    //   691: invokevirtual 59	com/facebook/katana/service/method/ServiceOperation:o	()Landroid/content/Intent;
    //   694: ldc 70
    //   696: iconst_0
    //   697: invokevirtual 74	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   700: sipush 701
    //   703: if_icmpeq -36 -> 667
    //   706: aload 53
    //   708: aload 57
    //   710: invokeinterface 173 2 0
    //   715: pop
    //   716: goto -49 -> 667
    //   719: astore 55
    //   721: aload 54
    //   723: monitorexit
    //   724: aload 55
    //   726: athrow
    //   727: aload 54
    //   729: monitorexit
    //   730: aload_0
    //   731: getfield 43	com/facebook/katana/service/FacebookService:c	Ljava/util/Map;
    //   734: invokeinterface 200 1 0
    //   739: new 202	com/facebook/orca/common/async/AsyncTaskRunner
    //   742: dup
    //   743: new 204	com/facebook/katana/service/FacebookService$2
    //   746: dup
    //   747: aload_0
    //   748: aload 53
    //   750: invokespecial 207	com/facebook/katana/service/FacebookService$2:<init>	(Lcom/facebook/katana/service/FacebookService;Ljava/util/List;)V
    //   753: invokespecial 210	com/facebook/orca/common/async/AsyncTaskRunner:<init>	(Ljava/lang/Runnable;)V
    //   756: invokevirtual 212	com/facebook/orca/common/async/AsyncTaskRunner:a	()V
    //   759: aload_0
    //   760: getfield 48	com/facebook/katana/service/FacebookService:e	Ljava/util/List;
    //   763: invokeinterface 213 1 0
    //   768: aload_0
    //   769: getfield 50	com/facebook/katana/service/FacebookService:f	Ljava/util/List;
    //   772: invokeinterface 213 1 0
    //   777: aload_0
    //   778: getfield 52	com/facebook/katana/service/FacebookService:g	Ljava/util/List;
    //   781: invokeinterface 213 1 0
    //   786: new 215	com/facebook/katana/service/method/AuthLogout
    //   789: dup
    //   790: aload_0
    //   791: invokevirtual 130	com/facebook/katana/service/FacebookService:getApplicationContext	()Landroid/content/Context;
    //   794: aload_1
    //   795: aload_1
    //   796: ldc 148
    //   798: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   801: aload_0
    //   802: aload_1
    //   803: ldc 217
    //   805: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   808: invokespecial 220	com/facebook/katana/service/method/AuthLogout:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;Ljava/lang/String;)V
    //   811: astore 6
    //   813: goto -378 -> 435
    //   816: new 222	java/util/LinkedHashMap
    //   819: dup
    //   820: invokespecial 223	java/util/LinkedHashMap:<init>	()V
    //   823: astore 42
    //   825: aload_1
    //   826: ldc 148
    //   828: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   831: astore 43
    //   833: aload_1
    //   834: ldc 140
    //   836: ldc2_w 141
    //   839: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   842: lstore 44
    //   844: aload_1
    //   845: ldc 225
    //   847: ldc2_w 141
    //   850: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   853: lstore 46
    //   855: new 27	java/util/HashMap
    //   858: dup
    //   859: invokespecial 30	java/util/HashMap:<init>	()V
    //   862: astore 48
    //   864: aload 48
    //   866: new 150	java/lang/Long
    //   869: dup
    //   870: lload 44
    //   872: invokespecial 228	java/lang/Long:<init>	(J)V
    //   875: aconst_null
    //   876: invokeinterface 160 3 0
    //   881: pop
    //   882: aload 42
    //   884: ldc 230
    //   886: new 162	com/facebook/katana/service/method/FqlGetUsersProfile
    //   889: dup
    //   890: aload_0
    //   891: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   894: aload_1
    //   895: aload 43
    //   897: aconst_null
    //   898: aload 48
    //   900: ldc 232
    //   902: invokespecial 167	com/facebook/katana/service/method/FqlGetUsersProfile:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;Ljava/util/Map;Ljava/lang/Class;)V
    //   905: invokevirtual 233	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   908: pop
    //   909: aload 42
    //   911: ldc 235
    //   913: new 162	com/facebook/katana/service/method/FqlGetUsersProfile
    //   916: dup
    //   917: aload_0
    //   918: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   921: aload_1
    //   922: aload 43
    //   924: aconst_null
    //   925: ldc 237
    //   927: ldc 164
    //   929: invokespecial 240	com/facebook/katana/service/method/FqlGetUsersProfile:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;Ljava/lang/String;Ljava/lang/Class;)V
    //   932: invokevirtual 233	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   935: pop
    //   936: lload 44
    //   938: lload 46
    //   940: lcmp
    //   941: ifeq +30 -> 971
    //   944: aload 42
    //   946: ldc 242
    //   948: new 244	com/facebook/katana/service/method/FqlGetUsersFriendStatus
    //   951: dup
    //   952: aload_0
    //   953: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   956: aload_1
    //   957: aload 43
    //   959: lload 46
    //   961: lload 44
    //   963: aconst_null
    //   964: invokespecial 247	com/facebook/katana/service/method/FqlGetUsersFriendStatus:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;JJLcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   967: invokevirtual 233	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   970: pop
    //   971: new 249	com/facebook/katana/service/method/FqlMultiQuery
    //   974: dup
    //   975: aload_0
    //   976: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   979: aload_1
    //   980: aload 43
    //   982: aload 42
    //   984: aload_0
    //   985: invokespecial 252	com/facebook/katana/service/method/FqlMultiQuery:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/util/LinkedHashMap;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   988: astore 6
    //   990: goto -555 -> 435
    //   993: new 222	java/util/LinkedHashMap
    //   996: dup
    //   997: invokespecial 223	java/util/LinkedHashMap:<init>	()V
    //   1000: astore 35
    //   1002: aload_1
    //   1003: ldc 148
    //   1005: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1008: astore 36
    //   1010: aload_1
    //   1011: ldc 140
    //   1013: ldc2_w 141
    //   1016: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1019: lstore 37
    //   1021: new 27	java/util/HashMap
    //   1024: dup
    //   1025: invokespecial 30	java/util/HashMap:<init>	()V
    //   1028: astore 39
    //   1030: aload 39
    //   1032: new 150	java/lang/Long
    //   1035: dup
    //   1036: lload 37
    //   1038: invokespecial 228	java/lang/Long:<init>	(J)V
    //   1041: aconst_null
    //   1042: invokeinterface 160 3 0
    //   1047: pop
    //   1048: aload 35
    //   1050: ldc 230
    //   1052: new 162	com/facebook/katana/service/method/FqlGetUsersProfile
    //   1055: dup
    //   1056: aload_0
    //   1057: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1060: aload_1
    //   1061: aload 36
    //   1063: aconst_null
    //   1064: aload 39
    //   1066: ldc 164
    //   1068: invokespecial 167	com/facebook/katana/service/method/FqlGetUsersProfile:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;Ljava/util/Map;Ljava/lang/Class;)V
    //   1071: invokevirtual 233	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1074: pop
    //   1075: new 249	com/facebook/katana/service/method/FqlMultiQuery
    //   1078: dup
    //   1079: aload_0
    //   1080: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1083: aload_1
    //   1084: aload 36
    //   1086: aload 35
    //   1088: aload_0
    //   1089: invokespecial 252	com/facebook/katana/service/method/FqlMultiQuery:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/util/LinkedHashMap;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1092: astore 6
    //   1094: goto -659 -> 435
    //   1097: new 254	com/facebook/katana/service/method/ConnectionsSync
    //   1100: dup
    //   1101: aload_0
    //   1102: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1105: aload_1
    //   1106: aload_1
    //   1107: ldc 148
    //   1109: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1112: aload_1
    //   1113: ldc 225
    //   1115: ldc2_w 141
    //   1118: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1121: aload_1
    //   1122: ldc 102
    //   1124: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1127: aload_0
    //   1128: invokespecial 257	com/facebook/katana/service/method/ConnectionsSync:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;JLjava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1131: astore 6
    //   1133: goto -698 -> 435
    //   1136: new 259	com/facebook/katana/service/method/ContinuousImport
    //   1139: dup
    //   1140: aload_0
    //   1141: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1144: aload_1
    //   1145: aload_1
    //   1146: ldc 148
    //   1148: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1151: aload_0
    //   1152: aload_0
    //   1153: getfield 261	com/facebook/katana/service/FacebookService:i	Lcom/facebook/katana/util/PhonebookUtils;
    //   1156: invokespecial 264	com/facebook/katana/service/method/ContinuousImport:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;Lcom/facebook/katana/util/PhonebookUtils;)V
    //   1159: astore 6
    //   1161: goto -726 -> 435
    //   1164: aload_0
    //   1165: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1168: astore 32
    //   1170: aload_1
    //   1171: ldc 148
    //   1173: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1176: astore 33
    //   1178: iconst_1
    //   1179: anewarray 266	java/lang/Object
    //   1182: astore 34
    //   1184: aload 34
    //   1186: iconst_0
    //   1187: aload_1
    //   1188: ldc 225
    //   1190: ldc2_w 141
    //   1193: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1196: invokestatic 154	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1199: aastore
    //   1200: new 268	com/facebook/katana/service/method/FqlStatusQuery
    //   1203: dup
    //   1204: aload 32
    //   1206: aload_1
    //   1207: aload 33
    //   1209: ldc_w 270
    //   1212: aload 34
    //   1214: invokestatic 275	com/facebook/orca/common/util/StringLocaleUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1217: aload_1
    //   1218: ldc 102
    //   1220: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1223: aload_0
    //   1224: invokespecial 276	com/facebook/katana/service/method/FqlStatusQuery:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1227: astore 6
    //   1229: goto -794 -> 435
    //   1232: new 278	com/facebook/katana/service/method/NotificationsGet
    //   1235: dup
    //   1236: aload_0
    //   1237: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1240: aload_1
    //   1241: aload_1
    //   1242: ldc 148
    //   1244: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1247: aload_0
    //   1248: invokespecial 281	com/facebook/katana/service/method/NotificationsGet:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1251: astore 6
    //   1253: goto -818 -> 435
    //   1256: new 283	com/facebook/katana/service/method/FqlSyncNotifications
    //   1259: dup
    //   1260: aload_0
    //   1261: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1264: aload_1
    //   1265: aload_1
    //   1266: ldc 148
    //   1268: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1271: aload_1
    //   1272: ldc 225
    //   1274: ldc2_w 141
    //   1277: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1280: aload_0
    //   1281: invokespecial 286	com/facebook/katana/service/method/FqlSyncNotifications:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;JLcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1284: astore 6
    //   1286: goto -851 -> 435
    //   1289: new 288	com/facebook/katana/service/method/NotificationsMarkRead
    //   1292: dup
    //   1293: aload_0
    //   1294: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1297: aload_1
    //   1298: aload_1
    //   1299: ldc 148
    //   1301: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1304: aload_1
    //   1305: ldc_w 290
    //   1308: invokevirtual 294	android/content/Intent:getLongArrayExtra	(Ljava/lang/String;)[J
    //   1311: aload_0
    //   1312: invokespecial 297	com/facebook/katana/service/method/NotificationsMarkRead:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;[JLcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1315: astore 6
    //   1317: goto -882 -> 435
    //   1320: new 299	com/facebook/katana/service/method/SyncAlbums
    //   1323: dup
    //   1324: aload_0
    //   1325: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1328: aload_1
    //   1329: aload_1
    //   1330: ldc 148
    //   1332: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1335: aload_1
    //   1336: ldc 140
    //   1338: ldc2_w 141
    //   1341: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1344: aload_1
    //   1345: ldc_w 301
    //   1348: invokevirtual 305	android/content/Intent:getStringArrayExtra	(Ljava/lang/String;)[Ljava/lang/String;
    //   1351: aload_0
    //   1352: invokespecial 308	com/facebook/katana/service/method/SyncAlbums:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;J[Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1355: astore 6
    //   1357: goto -922 -> 435
    //   1360: new 310	com/facebook/katana/service/method/PhotosCreateAlbum
    //   1363: dup
    //   1364: aload_0
    //   1365: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1368: aload_1
    //   1369: aload_1
    //   1370: ldc 148
    //   1372: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1375: aload_1
    //   1376: ldc_w 312
    //   1379: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1382: aload_1
    //   1383: ldc_w 314
    //   1386: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1389: aload_1
    //   1390: ldc_w 316
    //   1393: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1396: aload_1
    //   1397: ldc_w 318
    //   1400: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1403: aload_0
    //   1404: invokespecial 321	com/facebook/katana/service/method/PhotosCreateAlbum:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1407: astore 6
    //   1409: goto -974 -> 435
    //   1412: new 323	com/facebook/katana/service/method/PhotosEditAlbum
    //   1415: dup
    //   1416: aload_0
    //   1417: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1420: aload_1
    //   1421: aload_1
    //   1422: ldc 148
    //   1424: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1427: aload_1
    //   1428: ldc_w 301
    //   1431: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1434: aload_1
    //   1435: ldc_w 312
    //   1438: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1441: aload_1
    //   1442: ldc_w 314
    //   1445: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1448: aload_1
    //   1449: ldc_w 316
    //   1452: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1455: aload_1
    //   1456: ldc_w 318
    //   1459: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1462: aload_0
    //   1463: invokespecial 326	com/facebook/katana/service/method/PhotosEditAlbum:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1466: astore 6
    //   1468: goto -1033 -> 435
    //   1471: new 328	com/facebook/katana/service/method/PhotosDeleteAlbum
    //   1474: dup
    //   1475: aload_0
    //   1476: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1479: aload_1
    //   1480: aload_1
    //   1481: ldc 148
    //   1483: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1486: aload_1
    //   1487: ldc 140
    //   1489: ldc2_w 141
    //   1492: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1495: aload_1
    //   1496: ldc_w 301
    //   1499: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1502: aload_0
    //   1503: invokespecial 329	com/facebook/katana/service/method/PhotosDeleteAlbum:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;JLjava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1506: astore 6
    //   1508: goto -1073 -> 435
    //   1511: new 331	com/facebook/katana/service/method/PhotosGetPhotos
    //   1514: dup
    //   1515: aload_0
    //   1516: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1519: aload_1
    //   1520: aload_1
    //   1521: ldc 148
    //   1523: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1526: aload_1
    //   1527: ldc_w 301
    //   1530: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1533: aload_1
    //   1534: ldc_w 333
    //   1537: invokevirtual 305	android/content/Intent:getStringArrayExtra	(Ljava/lang/String;)[Ljava/lang/String;
    //   1540: aload_1
    //   1541: ldc 140
    //   1543: ldc2_w 141
    //   1546: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1549: aload_1
    //   1550: ldc_w 335
    //   1553: iconst_0
    //   1554: invokevirtual 74	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1557: aload_1
    //   1558: ldc_w 337
    //   1561: iconst_m1
    //   1562: invokevirtual 74	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1565: aload_0
    //   1566: invokespecial 340	com/facebook/katana/service/method/PhotosGetPhotos:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;JIILcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1569: astore 6
    //   1571: goto -1136 -> 435
    //   1574: new 342	com/facebook/katana/service/method/PhotosUpload
    //   1577: dup
    //   1578: aload_0
    //   1579: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1582: aload_1
    //   1583: aload_1
    //   1584: ldc 148
    //   1586: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1589: aload_1
    //   1590: ldc_w 344
    //   1593: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1596: aload_1
    //   1597: ldc_w 346
    //   1600: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1603: aload_0
    //   1604: aload_1
    //   1605: ldc_w 301
    //   1608: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1611: aload_1
    //   1612: ldc_w 348
    //   1615: ldc2_w 141
    //   1618: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1621: aload_1
    //   1622: ldc_w 350
    //   1625: ldc2_w 141
    //   1628: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1631: aload_1
    //   1632: ldc_w 352
    //   1635: iconst_0
    //   1636: invokevirtual 356	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1639: aload_1
    //   1640: ldc_w 358
    //   1643: ldc2_w 141
    //   1646: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1649: aload_1
    //   1650: ldc_w 360
    //   1653: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1656: aload_1
    //   1657: ldc_w 362
    //   1660: ldc2_w 141
    //   1663: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1666: aload_1
    //   1667: ldc_w 364
    //   1670: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1673: aload_1
    //   1674: ldc_w 366
    //   1677: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1680: invokespecial 369	com/facebook/katana/service/method/PhotosUpload:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;Ljava/lang/String;JJZJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;)V
    //   1683: astore 6
    //   1685: aload_1
    //   1686: ldc_w 371
    //   1689: lconst_0
    //   1690: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1693: lstore 29
    //   1695: lload 29
    //   1697: lconst_0
    //   1698: lcmp
    //   1699: ifle -1264 -> 435
    //   1702: aload 6
    //   1704: checkcast 342	com/facebook/katana/service/method/PhotosUpload
    //   1707: lload 29
    //   1709: invokevirtual 374	com/facebook/katana/service/method/PhotosUpload:a	(J)Lcom/facebook/katana/service/method/PhotosUpload;
    //   1712: pop
    //   1713: goto -1278 -> 435
    //   1716: new 376	com/facebook/katana/service/method/PhotosEditPhoto
    //   1719: dup
    //   1720: aload_0
    //   1721: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1724: aload_1
    //   1725: aload_1
    //   1726: ldc 148
    //   1728: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1731: aload_1
    //   1732: ldc_w 333
    //   1735: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1738: aload_1
    //   1739: ldc_w 344
    //   1742: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1745: aload_0
    //   1746: invokespecial 377	com/facebook/katana/service/method/PhotosEditPhoto:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1749: astore 6
    //   1751: goto -1316 -> 435
    //   1754: new 379	com/facebook/katana/service/method/PhotosDeletePhoto
    //   1757: dup
    //   1758: aload_0
    //   1759: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1762: aload_1
    //   1763: aload_1
    //   1764: ldc 148
    //   1766: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1769: aload_1
    //   1770: ldc_w 301
    //   1773: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1776: aload_1
    //   1777: ldc_w 333
    //   1780: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1783: aload_0
    //   1784: invokespecial 380	com/facebook/katana/service/method/PhotosDeletePhoto:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1787: astore 6
    //   1789: goto -1354 -> 435
    //   1792: new 382	com/facebook/katana/service/method/PhotosAddTag
    //   1795: dup
    //   1796: aload_0
    //   1797: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1800: aload_1
    //   1801: aload_1
    //   1802: ldc 148
    //   1804: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1807: aload_1
    //   1808: ldc_w 333
    //   1811: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1814: aload_1
    //   1815: ldc_w 360
    //   1818: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1821: aload_0
    //   1822: invokespecial 383	com/facebook/katana/service/method/PhotosAddTag:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1825: astore 6
    //   1827: goto -1392 -> 435
    //   1830: new 385	com/facebook/katana/service/method/PhotoDownload
    //   1833: dup
    //   1834: aload_0
    //   1835: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1838: aload_1
    //   1839: aload_1
    //   1840: ldc 140
    //   1842: ldc2_w 141
    //   1845: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1848: aload_1
    //   1849: ldc_w 301
    //   1852: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1855: aload_1
    //   1856: ldc_w 333
    //   1859: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1862: aload_1
    //   1863: ldc_w 387
    //   1866: ldc2_w 141
    //   1869: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1872: aload_1
    //   1873: ldc_w 346
    //   1876: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1879: aload_1
    //   1880: ldc 70
    //   1882: iconst_m1
    //   1883: invokevirtual 74	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1886: aload_0
    //   1887: invokespecial 390	com/facebook/katana/service/method/PhotoDownload:<init>	(Landroid/content/Context;Landroid/content/Intent;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;ILcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1890: astore 6
    //   1892: aload_0
    //   1893: aload 6
    //   1895: invokespecial 393	com/facebook/katana/service/FacebookService:b	(Lcom/facebook/katana/service/method/ServiceOperation;)V
    //   1898: aload_0
    //   1899: getfield 48	com/facebook/katana/service/FacebookService:e	Ljava/util/List;
    //   1902: invokeinterface 397 1 0
    //   1907: aload_0
    //   1908: getfield 50	com/facebook/katana/service/FacebookService:f	Ljava/util/List;
    //   1911: invokeinterface 397 1 0
    //   1916: iadd
    //   1917: aload_0
    //   1918: getfield 52	com/facebook/katana/service/FacebookService:g	Ljava/util/List;
    //   1921: invokeinterface 397 1 0
    //   1926: iadd
    //   1927: iconst_3
    //   1928: if_icmple -1493 -> 435
    //   1931: goto -1479 -> 452
    //   1934: new 399	com/facebook/katana/service/method/ProfileImageDownload
    //   1937: dup
    //   1938: aload_0
    //   1939: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1942: aload_1
    //   1943: aload_1
    //   1944: ldc 140
    //   1946: ldc2_w 141
    //   1949: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   1952: aload_1
    //   1953: ldc_w 346
    //   1956: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1959: aload_0
    //   1960: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   1963: invokestatic 404	com/facebook/katana/util/FileUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   1966: aload_0
    //   1967: invokespecial 407	com/facebook/katana/service/method/ProfileImageDownload:<init>	(Landroid/content/Context;Landroid/content/Intent;JLjava/lang/String;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   1970: astore 6
    //   1972: aload_0
    //   1973: aload 6
    //   1975: invokespecial 393	com/facebook/katana/service/FacebookService:b	(Lcom/facebook/katana/service/method/ServiceOperation;)V
    //   1978: aload_0
    //   1979: getfield 48	com/facebook/katana/service/FacebookService:e	Ljava/util/List;
    //   1982: invokeinterface 397 1 0
    //   1987: aload_0
    //   1988: getfield 50	com/facebook/katana/service/FacebookService:f	Ljava/util/List;
    //   1991: invokeinterface 397 1 0
    //   1996: iadd
    //   1997: aload_0
    //   1998: getfield 52	com/facebook/katana/service/FacebookService:g	Ljava/util/List;
    //   2001: invokeinterface 397 1 0
    //   2006: iadd
    //   2007: iconst_1
    //   2008: if_icmple -1573 -> 435
    //   2011: goto -1559 -> 452
    //   2014: aload_0
    //   2015: aload_0
    //   2016: getfield 52	com/facebook/katana/service/FacebookService:g	Ljava/util/List;
    //   2019: invokespecial 410	com/facebook/katana/service/FacebookService:a	(Ljava/util/List;)Z
    //   2022: pop
    //   2023: aconst_null
    //   2024: astore 6
    //   2026: goto -1591 -> 435
    //   2029: aload_1
    //   2030: ldc_w 412
    //   2033: invokevirtual 416	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   2036: checkcast 418	com/facebook/ipc/katana/model/FacebookPlace
    //   2039: astore 27
    //   2041: aload_0
    //   2042: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   2045: aload 27
    //   2047: invokestatic 423	com/facebook/katana/service/method/PlaceSuggestions:a	(Landroid/content/Context;Lcom/facebook/ipc/katana/model/FacebookPlace;)Lcom/facebook/katana/service/method/PlaceSuggestions;
    //   2050: astore 6
    //   2052: aload 6
    //   2054: new 425	java/io/File
    //   2057: dup
    //   2058: aload_1
    //   2059: ldc_w 346
    //   2062: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2065: invokespecial 428	java/io/File:<init>	(Ljava/lang/String;)V
    //   2068: invokevirtual 431	com/facebook/katana/service/method/PlaceSuggestions:a	(Ljava/io/File;)Z
    //   2071: ifeq -1639 -> 432
    //   2074: aload 6
    //   2076: aload_1
    //   2077: aload_0
    //   2078: invokevirtual 434	com/facebook/katana/service/method/ServiceOperation:a	(Landroid/content/Intent;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   2081: goto -1646 -> 435
    //   2084: new 436	com/facebook/katana/service/method/UsersSearch
    //   2087: dup
    //   2088: aload_0
    //   2089: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   2092: aload_1
    //   2093: aload_1
    //   2094: ldc 61
    //   2096: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2099: invokestatic 442	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2102: aload_1
    //   2103: ldc 148
    //   2105: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2108: aload_1
    //   2109: ldc_w 444
    //   2112: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2115: aload_1
    //   2116: ldc_w 335
    //   2119: iconst_0
    //   2120: invokevirtual 74	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2123: aload_1
    //   2124: ldc_w 337
    //   2127: iconst_0
    //   2128: invokevirtual 74	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2131: aload_0
    //   2132: invokespecial 447	com/facebook/katana/service/method/UsersSearch:<init>	(Landroid/content/Context;Landroid/content/Intent;ILjava/lang/String;Ljava/lang/String;IILcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   2135: astore 6
    //   2137: goto -1702 -> 435
    //   2140: aload_0
    //   2141: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   2144: aload_1
    //   2145: sipush 200
    //   2148: ldc_w 449
    //   2151: aconst_null
    //   2152: aconst_null
    //   2153: aconst_null
    //   2154: invokestatic 452	com/facebook/katana/binding/AppSession:a	(Landroid/content/Context;Landroid/content/Intent;ILjava/lang/String;Ljava/lang/Exception;Ljava/lang/Object;Ljava/lang/Object;)V
    //   2157: aconst_null
    //   2158: astore 6
    //   2160: goto -1725 -> 435
    //   2163: aload_1
    //   2164: ldc 148
    //   2166: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2169: astore 21
    //   2171: aload_1
    //   2172: ldc 140
    //   2174: ldc2_w 141
    //   2177: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   2180: lstore 22
    //   2182: new 106	java/lang/StringBuilder
    //   2185: dup
    //   2186: ldc_w 454
    //   2189: invokespecial 455	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2192: astore 24
    //   2194: aload 24
    //   2196: lload 22
    //   2198: invokestatic 460	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2201: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2204: pop
    //   2205: aload 24
    //   2207: ldc_w 462
    //   2210: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2213: pop
    //   2214: new 162	com/facebook/katana/service/method/FqlGetUsersProfile
    //   2217: dup
    //   2218: aload_0
    //   2219: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   2222: aload_1
    //   2223: aload 21
    //   2225: aload_0
    //   2226: aload 24
    //   2228: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2231: ldc 164
    //   2233: invokespecial 240	com/facebook/katana/service/method/FqlGetUsersProfile:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;Ljava/lang/String;Ljava/lang/Class;)V
    //   2236: astore 6
    //   2238: goto -1803 -> 435
    //   2241: aload_1
    //   2242: ldc 148
    //   2244: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2247: astore 17
    //   2249: aload_1
    //   2250: ldc 140
    //   2252: ldc2_w 141
    //   2255: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   2258: lstore 18
    //   2260: aload_1
    //   2261: ldc_w 464
    //   2264: iconst_0
    //   2265: invokevirtual 356	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2268: istore 20
    //   2270: new 466	com/facebook/katana/service/method/FriendRequestRespond
    //   2273: dup
    //   2274: aload_0
    //   2275: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   2278: aload_1
    //   2279: aload 17
    //   2281: aload_0
    //   2282: lload 18
    //   2284: iload 20
    //   2286: invokespecial 469	com/facebook/katana/service/method/FriendRequestRespond:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;JZ)V
    //   2289: astore 6
    //   2291: goto -1856 -> 435
    //   2294: aload_1
    //   2295: ldc 148
    //   2297: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2300: astore 11
    //   2302: aload_1
    //   2303: ldc 140
    //   2305: ldc2_w 141
    //   2308: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   2311: lstore 12
    //   2313: new 106	java/lang/StringBuilder
    //   2316: dup
    //   2317: ldc_w 471
    //   2320: invokespecial 455	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2323: astore 14
    //   2325: aload 14
    //   2327: lload 12
    //   2329: invokestatic 460	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2332: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2335: pop
    //   2336: aload 14
    //   2338: ldc_w 462
    //   2341: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2344: pop
    //   2345: new 473	com/facebook/katana/service/method/FqlGetMutualFriends
    //   2348: dup
    //   2349: aload_0
    //   2350: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   2353: aload_1
    //   2354: aload 11
    //   2356: aload_0
    //   2357: lload 12
    //   2359: aload 14
    //   2361: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2364: invokespecial 476	com/facebook/katana/service/method/FqlGetMutualFriends:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;JLjava/lang/String;)V
    //   2367: astore 6
    //   2369: goto -1934 -> 435
    //   2372: aload_1
    //   2373: ldc 148
    //   2375: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2378: astore 8
    //   2380: aload_1
    //   2381: ldc 140
    //   2383: ldc2_w 141
    //   2386: invokevirtual 146	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   2389: lstore 9
    //   2391: new 478	com/facebook/katana/service/method/FqlGetFacebookAffiliation
    //   2394: dup
    //   2395: aload_0
    //   2396: getfield 78	com/facebook/katana/service/FacebookService:d	Landroid/content/Context;
    //   2399: aload_1
    //   2400: aload 8
    //   2402: aload_0
    //   2403: lload 9
    //   2405: invokespecial 481	com/facebook/katana/service/method/FqlGetFacebookAffiliation:<init>	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/katana/service/method/ServiceOperationListener;J)V
    //   2408: astore 6
    //   2410: goto -1975 -> 435
    //   2413: aload_1
    //   2414: ldc 61
    //   2416: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2419: astore 5
    //   2421: getstatic 32	com/facebook/katana/service/FacebookService:a	Ljava/util/Map;
    //   2424: aload 5
    //   2426: invokeinterface 485 2 0
    //   2431: checkcast 55	com/facebook/katana/service/method/ServiceOperation
    //   2434: astore 6
    //   2436: aload 6
    //   2438: ifnull -2003 -> 435
    //   2441: aload 6
    //   2443: aload_1
    //   2444: aload_0
    //   2445: invokevirtual 434	com/facebook/katana/service/method/ServiceOperation:a	(Landroid/content/Intent;Lcom/facebook/katana/service/method/ServiceOperationListener;)V
    //   2448: goto -2013 -> 435
    //   2451: iload_2
    //   2452: sipush 2000
    //   2455: if_icmpne -2003 -> 452
    //   2458: aload_1
    //   2459: ldc 61
    //   2461: invokevirtual 67	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2464: astore 7
    //   2466: aload_0
    //   2467: getfield 43	com/facebook/katana/service/FacebookService:c	Ljava/util/Map;
    //   2470: aload 7
    //   2472: invokeinterface 488 2 0
    //   2477: ifeq -2025 -> 452
    //   2480: new 202	com/facebook/orca/common/async/AsyncTaskRunner
    //   2483: dup
    //   2484: new 490	com/facebook/katana/service/FacebookService$3
    //   2487: dup
    //   2488: aload_0
    //   2489: aload_0
    //   2490: getfield 43	com/facebook/katana/service/FacebookService:c	Ljava/util/Map;
    //   2493: aload 7
    //   2495: invokeinterface 493 2 0
    //   2500: checkcast 55	com/facebook/katana/service/method/ServiceOperation
    //   2503: invokespecial 496	com/facebook/katana/service/FacebookService$3:<init>	(Lcom/facebook/katana/service/FacebookService;Lcom/facebook/katana/service/method/ServiceOperation;)V
    //   2506: invokespecial 210	com/facebook/orca/common/async/AsyncTaskRunner:<init>	(Ljava/lang/Runnable;)V
    //   2509: invokevirtual 212	com/facebook/orca/common/async/AsyncTaskRunner:a	()V
    //   2512: goto -2060 -> 452
    //
    // Exception table:
    //   from	to	target	type
    //   651	724	719	finally
    //   727	730	719	finally
  }

  private void a(String paramString, ServiceOperation paramServiceOperation)
  {
    this.c.put(paramString, paramServiceOperation);
    paramServiceOperation.b();
  }

  private boolean a(List<ServiceOperation> paramList)
  {
    if (paramList.size() > 0)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ServiceOperation localServiceOperation = (ServiceOperation)localIterator.next();
        String str = a(localServiceOperation);
        if (this.c.containsKey(str))
          continue;
        a(str, localServiceOperation);
      }
    }
    for (int j = 1; ; j = 0)
      return j;
  }

  private void b(ServiceOperation paramServiceOperation)
  {
    if ((paramServiceOperation instanceof ProfileImageDownload))
      this.g.add(paramServiceOperation);
    while (true)
    {
      return;
      long l = System.currentTimeMillis();
      if (l > 100L + this.h)
      {
        this.f.addAll(this.e);
        this.e.clear();
      }
      this.e.add(paramServiceOperation);
      this.h = l;
    }
  }

  private void c(ServiceOperation paramServiceOperation)
  {
    int j = 1;
    int k;
    int m;
    label37: int n;
    if (this.e.remove(paramServiceOperation))
    {
      k = j;
      if ((k != 0) || (!this.f.remove(paramServiceOperation)))
        break label122;
      m = j;
      if (((m == 0) && (this.g.remove(paramServiceOperation))) && (!a(this.e)))
        break label128;
      n = j;
      label69: if ((n != 0) || (!a(this.f)))
        break label134;
      label85: if ((j == 0) && (this.g.size() != 0))
      {
        if (!BackgroundDetectionService.a())
          break label139;
        a(this.g);
      }
    }
    while (true)
    {
      return;
      k = 0;
      break;
      label122: m = 0;
      break label37;
      label128: n = 0;
      break label69;
      label134: j = 0;
      break label85;
      label139: AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
      Intent localIntent = new Intent(this, FacebookService.class);
      localIntent.putExtra("type", 78);
      PendingIntent localPendingIntent = PendingIntent.getService(this, 0, localIntent, 0);
      localAlarmManager.set(2, 100L + SystemClock.elapsedRealtime(), localPendingIntent);
    }
  }

  public void a(ServiceOperation paramServiceOperation, long paramLong1, long paramLong2)
  {
    Intent localIntent = paramServiceOperation.o();
    switch (localIntent.getIntExtra("type", 0))
    {
    default:
    case 65:
    }
    while (true)
    {
      return;
      AppSession.a(this.d, localIntent, Integer.valueOf(Math.min((int)(100L * paramLong1 / paramLong2), 100)), null);
    }
  }

  public void a_(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    Intent localIntent1 = paramServiceOperation.o();
    String str1 = localIntent1.getStringExtra("rid");
    this.c.remove(str1);
    long l2;
    FacebookPhoto localFacebookPhoto;
    switch (localIntent1.getIntExtra("type", 0))
    {
    default:
      AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, null, null);
    case 1:
    case 3:
    case 61:
      while (true)
      {
        return;
        if (paramInt == 200)
        {
          String str3 = localIntent1.getStringExtra("rid");
          FacebookSessionInfo localFacebookSessionInfo2 = ((AuthLogin)paramServiceOperation).g();
          ArrayList localArrayList = new ArrayList();
          Intent localIntent3 = new Intent();
          localIntent3.putExtra("type", 3);
          localIntent3.putExtra("FacebookService.originalIntent", localIntent1);
          localIntent3.putExtra("ApiMethod.secret", localFacebookSessionInfo2.sessionSecret);
          HashMap localHashMap = new HashMap();
          localHashMap.put(Long.valueOf(localFacebookSessionInfo2.userId), null);
          localArrayList.add(new FqlGetUsersProfile(this.d, localIntent3, localFacebookSessionInfo2.sessionKey, null, localHashMap, localFacebookSessionInfo2));
          a(str3, new BatchRunDONOTUSE(this.d, localIntent3, localFacebookSessionInfo2.sessionKey, localArrayList, this));
          continue;
        }
        AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, null, null);
        continue;
        Object localObject = null;
        if (paramInt == 200)
        {
          FqlGetUsersProfile localFqlGetUsersProfile5 = (FqlGetUsersProfile)((BatchRunDONOTUSE)paramServiceOperation).g().get(0);
          FacebookSessionInfo localFacebookSessionInfo1 = (FacebookSessionInfo)localFqlGetUsersProfile5.h();
          if (localFacebookSessionInfo1 == null)
            localFacebookSessionInfo1 = AppSession.a(this.d, false).b();
          localFacebookSessionInfo1.a((FacebookUser)localFqlGetUsersProfile5.g().get(Long.valueOf(localFacebookSessionInfo1.userId)));
          String str2 = localFacebookSessionInfo1.d().toString();
          UserValuesManager.c(this.d, str2);
          localObject = localFacebookSessionInfo1;
        }
        Intent localIntent2 = (Intent)localIntent1.getParcelableExtra("FacebookService.originalIntent");
        if (localIntent2 != null)
        {
          AppSession.a(this.d, localIntent2, paramInt, paramString, paramException, localObject, null);
          continue;
        }
        AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, localObject, null);
        continue;
        PhotosCreateAlbum localPhotosCreateAlbum = (PhotosCreateAlbum)paramServiceOperation;
        AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, localPhotosCreateAlbum.g(), localPhotosCreateAlbum.h());
      }
    case 65:
      l2 = localIntent1.getLongExtra("session_user_id", -1L);
      if (paramInt != 200)
        break;
      localFacebookPhoto = ((PhotosUpload)paramServiceOperation).g();
    case 67:
    case 68:
    case 507:
    case 77:
    case 72:
    case 73:
    case 74:
    case 76:
    case 75:
    case 100:
    case 82:
    case 83:
    case 80:
    case 1100:
    case 211:
    case 81:
    case 50:
    case 131:
    case 132:
    case 133:
    case 140:
    case 1000:
    case 1001:
    }
    while (true)
    {
      AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, localFacebookPhoto, null);
      break;
      if (localIntent1.getLongExtra("checkin_id", -1L) == -1L)
      {
        localFacebookPhoto = new FacebookPhoto(null, localIntent1.getStringExtra("aid"), l2, localIntent1.getStringExtra("subject"), null, null, null, 0L, null, -1L, -1L, null, true);
        continue;
        AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, Boolean.valueOf(((PhotosDeletePhoto)paramServiceOperation).g()), null);
        break;
        AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, ((PhotosAddTag)paramServiceOperation).g(), null);
        break;
        AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, null, null);
        break;
        AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, ((PhotoDownload)paramServiceOperation).h(), null);
        c(paramServiceOperation);
        break;
        AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, ((PhotoDownload)paramServiceOperation).g(), null);
        c(paramServiceOperation);
        break;
        AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, ((PhotoDownload)paramServiceOperation).i(), null);
        c(paramServiceOperation);
        break;
        AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, null, null);
        c(paramServiceOperation);
        break;
        AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, ((ProfileImageDownload)paramServiceOperation).g(), null);
        c(paramServiceOperation);
        break;
        FqlMultiQuery localFqlMultiQuery2 = (FqlMultiQuery)paramServiceOperation;
        FacebookUserFull localFacebookUserFull2;
        FacebookUserFull localFacebookUserFull1;
        boolean bool3;
        if (paramInt == 200)
        {
          FqlGetUsersProfile localFqlGetUsersProfile3 = (FqlGetUsersProfile)localFqlMultiQuery2.c("user");
          Assert.a(1, localFqlGetUsersProfile3.g().size());
          Iterator localIterator2 = localFqlGetUsersProfile3.g().values().iterator();
          boolean bool4 = localIterator2.hasNext();
          localFacebookUserFull2 = null;
          if (bool4)
            localFacebookUserFull2 = (FacebookUserFull)(FacebookUser)localIterator2.next();
          FqlGetUsersProfile localFqlGetUsersProfile4 = (FqlGetUsersProfile)localFqlMultiQuery2.c("significant_other");
          if (localFqlGetUsersProfile4.g().size() == 1)
          {
            Iterator localIterator3 = localFqlGetUsersProfile4.g().values().iterator();
            while (localIterator3.hasNext())
              localFacebookUserFull2.a((FacebookUser)localIterator3.next());
          }
          FqlGetUsersFriendStatus localFqlGetUsersFriendStatus = (FqlGetUsersFriendStatus)localFqlMultiQuery2.c("arefriends");
          if ((localFqlGetUsersFriendStatus != null) && (!localFqlGetUsersFriendStatus.g()))
          {
            localFacebookUserFull1 = localFacebookUserFull2;
            bool3 = false;
          }
        }
        while (true)
        {
          AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, localFacebookUserFull1, Boolean.valueOf(bool3));
          break;
          FqlMultiQuery localFqlMultiQuery1 = (FqlMultiQuery)paramServiceOperation;
          FacebookUser localFacebookUser = null;
          if (paramInt == 200)
          {
            FqlGetUsersProfile localFqlGetUsersProfile2 = (FqlGetUsersProfile)localFqlMultiQuery1.c("user");
            Assert.a(1, localFqlGetUsersProfile2.g().size());
            Iterator localIterator1 = localFqlGetUsersProfile2.g().values().iterator();
            boolean bool2 = localIterator1.hasNext();
            localFacebookUser = null;
            if (bool2)
              localFacebookUser = (FacebookUser)localIterator1.next();
          }
          AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, localFacebookUser, null);
          break;
          Map localMap3 = null;
          if (paramInt == 200)
            localMap3 = ((ConnectionsSync)paramServiceOperation).a();
          AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, localMap3, null);
          break;
          AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, null, null);
          break;
          UsersSearch localUsersSearch = (UsersSearch)paramServiceOperation;
          AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, Integer.valueOf(localUsersSearch.j()), Integer.valueOf(localUsersSearch.k()));
          break;
          AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, ((FqlStatusQuery)paramServiceOperation).g(), null);
          break;
          FacebookNotifications localFacebookNotifications = null;
          if (paramInt == 200)
            localFacebookNotifications = ((NotificationsGet)paramServiceOperation).g();
          AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, localFacebookNotifications, null);
          break;
          FqlGetUsersProfile localFqlGetUsersProfile1 = (FqlGetUsersProfile)paramServiceOperation;
          Map localMap2 = null;
          if (paramInt == 200)
            localMap2 = localFqlGetUsersProfile1.g();
          AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, localMap2, null);
          break;
          FriendRequestRespond localFriendRequestRespond = (FriendRequestRespond)paramServiceOperation;
          long l1 = localFriendRequestRespond.g();
          if (paramInt == 200);
          for (boolean bool1 = localFriendRequestRespond.h(); ; bool1 = false)
          {
            AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, new Long(l1), new Boolean(bool1));
            break;
            FqlGetMutualFriends localFqlGetMutualFriends = (FqlGetMutualFriends)paramServiceOperation;
            Map localMap1 = null;
            if (paramInt == 200)
              localMap1 = localFqlGetMutualFriends.g();
            AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, localMap1, null);
            break;
            FacebookAffiliation.e();
            AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, null, null);
            break;
            AppSession.a(this.d, localIntent1, paramInt, paramString, paramException, paramServiceOperation, null);
            break;
          }
          localFacebookUserFull1 = localFacebookUserFull2;
          bool3 = true;
          continue;
          bool3 = true;
          localFacebookUserFull1 = null;
        }
      }
      localFacebookPhoto = null;
    }
  }

  public void b(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    this.d = getApplicationContext();
    this.i = ((PhonebookUtils)FbInjector.a(this).a(PhonebookUtils.class));
  }

  public void onDestroy()
  {
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if (paramIntent == null);
    while (true)
    {
      return;
      Intent localIntent = (Intent)paramIntent.clone();
      ((AppInitLock)FbInjector.a(this).a(AppInitLock.class)).a(new FacebookService.1(this, localIntent));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.FacebookService
 * JD-Core Version:    0.6.0
 */