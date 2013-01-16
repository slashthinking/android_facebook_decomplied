package com.facebook.orca.emoji;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Emojis
{
  public static final ImmutableList<EmojiSet> a;
  public static final EmojiSet b;
  public static int c;
  public static int d;
  public static final ImmutableList<Emojis.MinMaxCodePoint> e;
  public static final ImmutableMultimap<Integer, Integer> f;
  public static final ImmutableMap<Integer, Integer> g;
  public static final ImmutableList<Emoji> h;
  public static final ImmutableMap<String, Integer> i;
  public static Pattern j;
  private static ImmutableMap<Integer, Emoji> k;
  private static final Emoji l = new Emoji(2130838153, 2130838154, 0);
  private static final ImmutableList<Integer> m;

  static
  {
    c = 9728;
    d = 128591;
    e = ImmutableList.a(new Emojis.MinMaxCodePoint(9728, 10084, null), new Emojis.MinMaxCodePoint(57345, 58678, null), new Emojis.MinMaxCodePoint(127744, 128591, null));
    f = ImmutableMultimap.j().a(Integer.valueOf(57418), Integer.valueOf(9728)).a(Integer.valueOf(57417), Integer.valueOf(9729)).a(Integer.valueOf(57419), Integer.valueOf(9748)).a(Integer.valueOf(57416), Integer.valueOf(9924)).a(Integer.valueOf(57661), Integer.valueOf(9889)).a(Integer.valueOf(58435), Integer.valueOf(127744)).a(Integer.valueOf(58428), Integer.valueOf(127746)).a(Integer.valueOf(58430), Integer.valueOf(127754)).a(Integer.valueOf(58165), Integer.valueOf(127775)).a(Integer.valueOf(57616), Integer.valueOf(127808)).a(Integer.valueOf(58116), Integer.valueOf(127799)).a(Integer.valueOf(57616), Integer.valueOf(127793)).a(Integer.valueOf(57624), Integer.valueOf(127809)).a(Integer.valueOf(57392), Integer.valueOf(127800)).a(Integer.valueOf(57394), Integer.valueOf(127801)).a(Integer.valueOf(57625), Integer.valueOf(127810)).a(Integer.valueOf(58439), Integer.valueOf(127811)).a(Integer.valueOf(58115), Integer.valueOf(127802)).a(Integer.valueOf(58117), Integer.valueOf(127803)).a(Integer.valueOf(58119), Integer.valueOf(127796)).a(Integer.valueOf(58120), Integer.valueOf(127797)).a(Integer.valueOf(58436), Integer.valueOf(127806)).a(Integer.valueOf(58181), Integer.valueOf(127822)).a(Integer.valueOf(58182), Integer.valueOf(127818)).a(Integer.valueOf(58183), Integer.valueOf(127827)).a(Integer.valueOf(58393), Integer.valueOf(128064)).a(Integer.valueOf(58395), Integer.valueOf(128066)).a(Integer.valueOf(58394), Integer.valueOf(128067)).a(Integer.valueOf(58396), Integer.valueOf(128068)).a(Integer.valueOf(58377), Integer.valueOf(128069)).a(Integer.valueOf(58141), Integer.valueOf(128133)).a(Integer.valueOf(57345), Integer.valueOf(128102)).a(Integer.valueOf(57346), Integer.valueOf(128103)).a(Integer.valueOf(57348), Integer.valueOf(128104)).a(Integer.valueOf(57349), Integer.valueOf(128105)).a(Integer.valueOf(58408), Integer.valueOf(128107)).a(Integer.valueOf(57682), Integer.valueOf(128110)).a(Integer.valueOf(58409), Integer.valueOf(128111)).a(Integer.valueOf(58645), Integer.valueOf(128113)).a(Integer.valueOf(58646), Integer.valueOf(128114)).a(Integer.valueOf(58647), Integer.valueOf(128115)).a(Integer.valueOf(58648), Integer.valueOf(128116)).a(Integer.valueOf(58649), Integer.valueOf(128117)).a(Integer.valueOf(58650), Integer.valueOf(128118)).a(Integer.valueOf(58651), Integer.valueOf(128119)).a(Integer.valueOf(58652), Integer.valueOf(128120)).a(Integer.valueOf(57627), Integer.valueOf(128123)).a(Integer.valueOf(57422), Integer.valueOf(128124)).a(Integer.valueOf(57612), Integer.valueOf(128125)).a(Integer.valueOf(57643), Integer.valueOf(128126)).a(Integer.valueOf(57626), Integer.valueOf(128127)).a(Integer.valueOf(57628), Integer.valueOf(128128)).a(Integer.valueOf(58654), Integer.valueOf(128130)).a(Integer.valueOf(58655), Integer.valueOf(128131)).a(Integer.valueOf(58669), Integer.valueOf(128013)).a(Integer.valueOf(57652), Integer.valueOf(128014)).a(Integer.valueOf(58670), Integer.valueOf(128020)).a(Integer.valueOf(58671), Integer.valueOf(128023)).a(Integer.valueOf(58672), Integer.valueOf(128043)).a(Integer.valueOf(58662), Integer.valueOf(128024)).a(Integer.valueOf(58663), Integer.valueOf(128040)).a(Integer.valueOf(58664), Integer.valueOf(128018)).a(Integer.valueOf(58665), Integer.valueOf(128017)).a(Integer.valueOf(57610), Integer.valueOf(128025)).a(Integer.valueOf(58433), Integer.valueOf(128026)).a(Integer.valueOf(58661), Integer.valueOf(128027)).a(Integer.valueOf(58658), Integer.valueOf(128032)).a(Integer.valueOf(57369), Integer.valueOf(128033)).a(Integer.valueOf(58659), Integer.valueOf(128037)).a(Integer.valueOf(58657), Integer.valueOf(128038)).a(Integer.valueOf(57429), Integer.valueOf(128039)).a(Integer.valueOf(57426), Integer.valueOf(128041)).a(Integer.valueOf(57369), Integer.valueOf(128031)).a(Integer.valueOf(58656), Integer.valueOf(128044)).a(Integer.valueOf(57427), Integer.valueOf(128045)).a(Integer.valueOf(57424), Integer.valueOf(128047)).a(Integer.valueOf(57423), Integer.valueOf(128049)).a(Integer.valueOf(57428), Integer.valueOf(128051)).a(Integer.valueOf(57370), Integer.valueOf(128052)).a(Integer.valueOf(57609), Integer.valueOf(128053)).a(Integer.valueOf(57611), Integer.valueOf(128055)).a(Integer.valueOf(57425), Integer.valueOf(128059)).a(Integer.valueOf(58660), Integer.valueOf(128057)).a(Integer.valueOf(58666), Integer.valueOf(128058)).a(Integer.valueOf(58667), Integer.valueOf(128046)).a(Integer.valueOf(58668), Integer.valueOf(128048)).a(Integer.valueOf(58673), Integer.valueOf(128056)).a(Integer.valueOf(58678), Integer.valueOf(128062)).a(Integer.valueOf(57433), Integer.valueOf(128544)).a(Integer.valueOf(58371), Integer.valueOf(128553)).a(Integer.valueOf(58384), Integer.valueOf(128562)).a(Integer.valueOf(57432), Integer.valueOf(128542)).a(Integer.valueOf(58374), Integer.valueOf(128565)).a(Integer.valueOf(58383), Integer.valueOf(128560)).a(Integer.valueOf(58382), Integer.valueOf(128530)).a(Integer.valueOf(57606), Integer.valueOf(128525)).a(Integer.valueOf(58372), Integer.valueOf(128548)).a(Integer.valueOf(57605), Integer.valueOf(128540)).a(Integer.valueOf(58377), Integer.valueOf(128541)).a(Integer.valueOf(57430), Integer.valueOf(128523)).a(Integer.valueOf(58392), Integer.valueOf(128536)).a(Integer.valueOf(58391), Integer.valueOf(128538)).a(Integer.valueOf(58380), Integer.valueOf(128567)).a(Integer.valueOf(58381), Integer.valueOf(128563)).a(Integer.valueOf(57431), Integer.valueOf(128515)).a(Integer.valueOf(58378), Integer.valueOf(128518)).a(Integer.valueOf(58372), Integer.valueOf(128513)).a(Integer.valueOf(58386), Integer.valueOf(128514)).a(Integer.valueOf(58388), Integer.valueOf(9786)).a(Integer.valueOf(58389), Integer.valueOf(128516)).a(Integer.valueOf(58387), Integer.valueOf(128546)).a(Integer.valueOf(58385), Integer.valueOf(128557)).a(Integer.valueOf(58379), Integer.valueOf(128552)).a(Integer.valueOf(58374), Integer.valueOf(128547)).a(Integer.valueOf(58390), Integer.valueOf(128545)).a(Integer.valueOf(58378), Integer.valueOf(128524)).a(Integer.valueOf(58375), Integer.valueOf(128534)).a(Integer.valueOf(58371), Integer.valueOf(128532)).a(Integer.valueOf(57607), Integer.valueOf(128561)).a(Integer.valueOf(58376), Integer.valueOf(128554)).a(Integer.valueOf(58370), Integer.valueOf(128527)).a(Integer.valueOf(57608), Integer.valueOf(128531)).a(Integer.valueOf(58369), Integer.valueOf(128549)).a(Integer.valueOf(58374), Integer.valueOf(128555)).a(Integer.valueOf(58373), Integer.valueOf(128521)).a(Integer.valueOf(57431), Integer.valueOf(128570)).a(Integer.valueOf(58372), Integer.valueOf(128568)).a(Integer.valueOf(58386), Integer.valueOf(128569)).a(Integer.valueOf(58392), Integer.valueOf(128573)).a(Integer.valueOf(57606), Integer.valueOf(128571)).a(Integer.valueOf(58387), Integer.valueOf(128575)).a(Integer.valueOf(58372), Integer.valueOf(128572)).a(Integer.valueOf(58371), Integer.valueOf(128576)).a(Integer.valueOf(57362), Integer.valueOf(128587)).a(Integer.valueOf(58407), Integer.valueOf(128588)).a(Integer.valueOf(58371), Integer.valueOf(128589)).a(Integer.valueOf(58397), Integer.valueOf(128591)).a(Integer.valueOf(57618), Integer.valueOf(127873)).a(Integer.valueOf(57395), Integer.valueOf(127876)).a(Integer.valueOf(58440), Integer.valueOf(127877)).a(Integer.valueOf(58128), Integer.valueOf(127880)).a(Integer.valueOf(58130), Integer.valueOf(127881)).a(Integer.valueOf(58422), Integer.valueOf(127885)).a(Integer.valueOf(58424), Integer.valueOf(127886)).a(Integer.valueOf(58425), Integer.valueOf(127891)).a(Integer.valueOf(58427), Integer.valueOf(127887)).a(Integer.valueOf(58434), Integer.valueOf(127888)).a(Integer.valueOf(58437), Integer.valueOf(127875)).a(Integer.valueOf(57353), Integer.valueOf(128222)).a(Integer.valueOf(57354), Integer.valueOf(128241)).a(Integer.valueOf(57604), Integer.valueOf(128242)).a(Integer.valueOf(57355), Integer.valueOf(128224)).a(Integer.valueOf(57356), Integer.valueOf(128187)).a(Integer.valueOf(58134), Integer.valueOf(128189)).a(Integer.valueOf(58134), Integer.valueOf(128190)).a(Integer.valueOf(57638), Integer.valueOf(128191)).a(Integer.valueOf(57639), Integer.valueOf(128192)).a(Integer.valueOf(57406), Integer.valueOf(127925)).a(Integer.valueOf(58150), Integer.valueOf(127926)).a(Integer.valueOf(58150), Integer.valueOf(127932)).a(Integer.valueOf(57642), Integer.valueOf(128250)).a(Integer.valueOf(57347), Integer.valueOf(128139)).a(Integer.valueOf(57617), Integer.valueOf(128143)).a(Integer.valueOf(58118), Integer.valueOf(128144)).a(Integer.valueOf(58405), Integer.valueOf(128145)).a(Integer.valueOf(57632), Integer.valueOf(127828)).a(Integer.valueOf(57413), Integer.valueOf(9749)).a(Integer.valueOf(57412), Integer.valueOf(127864)).a(Integer.valueOf(57415), Integer.valueOf(127866)).a(Integer.valueOf(57378), Integer.valueOf(10084)).a(Integer.valueOf(58151), Integer.valueOf(128147)).a(Integer.valueOf(57379), Integer.valueOf(128148)).a(Integer.valueOf(58151), Integer.valueOf(128150)).a(Integer.valueOf(58152), Integer.valueOf(128151)).a(Integer.valueOf(58153), Integer.valueOf(128152)).a(Integer.valueOf(58154), Integer.valueOf(128153)).a(Integer.valueOf(58155), Integer.valueOf(128154)).a(Integer.valueOf(58156), Integer.valueOf(128155)).a(Integer.valueOf(58157), Integer.valueOf(128156)).a(Integer.valueOf(58423), Integer.valueOf(128157)).a(Integer.valueOf(58164), Integer.valueOf(128162)).a(Integer.valueOf(57660), Integer.valueOf(128164)).a(Integer.valueOf(58161), Integer.valueOf(128166)).a(Integer.valueOf(58160), Integer.valueOf(128168)).a(Integer.valueOf(57434), Integer.valueOf(128169)).a(Integer.valueOf(57676), Integer.valueOf(128170)).a(Integer.valueOf(58158), Integer.valueOf(10024)).a(Integer.valueOf(58149), Integer.valueOf(128276)).a(Integer.valueOf(57360), Integer.valueOf(9994)).a(Integer.valueOf(57362), Integer.valueOf(9995)).a(Integer.valueOf(57361), Integer.valueOf(9996)).a(Integer.valueOf(57357), Integer.valueOf(128074)).a(Integer.valueOf(57358), Integer.valueOf(128077)).a(Integer.valueOf(57359), Integer.valueOf(9757)).a(Integer.valueOf(57902), Integer.valueOf(128070)).a(Integer.valueOf(57903), Integer.valueOf(128071)).a(Integer.valueOf(57904), Integer.valueOf(128072)).a(Integer.valueOf(57905), Integer.valueOf(128073)).a(Integer.valueOf(58398), Integer.valueOf(128075)).a(Integer.valueOf(58399), Integer.valueOf(128079)).a(Integer.valueOf(58400), Integer.valueOf(128076)).a(Integer.valueOf(58401), Integer.valueOf(128078)).a(Integer.valueOf(58402), Integer.valueOf(128080)).a();
    g = ImmutableMap.k().b(Integer.valueOf(128158), Integer.valueOf(128147)).b(Integer.valueOf(128149), Integer.valueOf(128147)).b();
    Emoji localEmoji1 = new Emoji(2130838037, 2130838038, 128516);
    Emoji localEmoji2 = new Emoji(2130838035, 2130838036, 128515);
    Emoji localEmoji3 = new Emoji(2130838137, 2130838138, 9786);
    Emoji localEmoji4 = new Emoji(2130838041, 2130838042, 128521);
    Emoji localEmoji5 = new Emoji(2130838047, 2130838048, 128525);
    Emoji localEmoji6 = new Emoji(2130838059, 2130838060, 128536);
    Emoji localEmoji7 = new Emoji(2130838061, 2130838062, 128538);
    Emoji localEmoji8 = new Emoji(2130838063, 2130838064, 128540);
    Emoji localEmoji9 = new Emoji(2130838065, 2130838066, 128541);
    Emoji localEmoji10 = new Emoji(2130838097, 2130838098, 128563);
    Emoji localEmoji11 = new Emoji(2130838031, 2130838032, 128513);
    Emoji localEmoji12 = new Emoji(2130838055, 2130838056, 128532);
    Emoji[] arrayOfEmoji = new Emoji['Â'];
    arrayOfEmoji[0] = new Emoji(2130838045, 2130838046, 128524);
    arrayOfEmoji[1] = new Emoji(2130838051, 2130838052, 128530);
    arrayOfEmoji[2] = new Emoji(2130838067, 2130838068, 128542);
    arrayOfEmoji[3] = new Emoji(2130838075, 2130838076, 128547);
    arrayOfEmoji[4] = new Emoji(2130838073, 2130838074, 128546);
    arrayOfEmoji[5] = new Emoji(2130838033, 2130838034, 128514);
    arrayOfEmoji[6] = new Emoji(2130838089, 2130838090, 128557);
    arrayOfEmoji[7] = new Emoji(2130838085, 2130838086, 128554);
    arrayOfEmoji[8] = new Emoji(2130838079, 2130838080, 128549);
    arrayOfEmoji[9] = new Emoji(2130838091, 2130838092, 128560);
    arrayOfEmoji[10] = new Emoji(2130838053, 2130838054, 128531);
    arrayOfEmoji[11] = new Emoji(2130838083, 2130838084, 128553);
    arrayOfEmoji[12] = new Emoji(2130838087, 2130838088, 128555);
    arrayOfEmoji[13] = new Emoji(2130838081, 2130838082, 128552);
    arrayOfEmoji[14] = new Emoji(2130838093, 2130838094, 128561);
    arrayOfEmoji[15] = new Emoji(2130838069, 2130838070, 128544);
    arrayOfEmoji[16] = new Emoji(2130838071, 2130838072, 128545);
    arrayOfEmoji[17] = new Emoji(2130838077, 2130838078, 128548);
    arrayOfEmoji[18] = new Emoji(2130838057, 2130838058, 128534);
    arrayOfEmoji[19] = new Emoji(2130838039, 2130838040, 128518);
    arrayOfEmoji[20] = new Emoji(2130838043, 2130838044, 128523);
    arrayOfEmoji[21] = new Emoji(2130838101, 2130838102, 128567);
    arrayOfEmoji[22] = new Emoji(2130838099, 2130838100, 128565);
    arrayOfEmoji[23] = new Emoji(2130838095, 2130838096, 128562);
    arrayOfEmoji[24] = new Emoji(2130837957, 2130837958, 128127);
    arrayOfEmoji[25] = new Emoji(2130838049, 2130838050, 128527);
    arrayOfEmoji[26] = new Emoji(2130837935, 2130837936, 128114);
    arrayOfEmoji[27] = new Emoji(2130837937, 2130837938, 128115);
    arrayOfEmoji[28] = new Emoji(2130837929, 2130837930, 128110);
    arrayOfEmoji[29] = new Emoji(2130837945, 2130837946, 128119);
    arrayOfEmoji[30] = new Emoji(2130837961, 2130837962, 128130);
    arrayOfEmoji[31] = new Emoji(2130837943, 2130837944, 128118);
    arrayOfEmoji[32] = new Emoji(2130837919, 2130837920, 128102);
    arrayOfEmoji[33] = new Emoji(2130837921, 2130837922, 128103);
    arrayOfEmoji[34] = new Emoji(2130837923, 2130837924, 128104);
    arrayOfEmoji[35] = new Emoji(2130837925, 2130837926, 128105);
    arrayOfEmoji[36] = new Emoji(2130837939, 2130837940, 128116);
    arrayOfEmoji[37] = new Emoji(2130837941, 2130837942, 128117);
    arrayOfEmoji[38] = new Emoji(2130837933, 2130837934, 128113);
    arrayOfEmoji[39] = new Emoji(2130837951, 2130837952, 128124);
    arrayOfEmoji[40] = new Emoji(2130837947, 2130837948, 128120);
    arrayOfEmoji[41] = new Emoji(2130838107, 2130838108, 128570);
    arrayOfEmoji[42] = new Emoji(2130838103, 2130838104, 128568);
    arrayOfEmoji[43] = new Emoji(2130838109, 2130838110, 128571);
    arrayOfEmoji[44] = new Emoji(2130838113, 2130838114, 128573);
    arrayOfEmoji[45] = new Emoji(2130838111, 2130838112, 128572);
    arrayOfEmoji[46] = new Emoji(2130838117, 2130838118, 128576);
    arrayOfEmoji[47] = new Emoji(2130838115, 2130838116, 128575);
    arrayOfEmoji[48] = new Emoji(2130838105, 2130838106, 128569);
    arrayOfEmoji[49] = new Emoji(2130837959, 2130837960, 128128);
    arrayOfEmoji[50] = new Emoji(2130837953, 2130837954, 128125);
    arrayOfEmoji[51] = new Emoji(2130838029, 2130838030, 128293);
    arrayOfEmoji[52] = new Emoji(2130838003, 2130838004, 128169);
    arrayOfEmoji[53] = new Emoji(2130838149, 2130838150, 10024);
    arrayOfEmoji[54] = new Emoji(2130837749, 2130837750, 127775);
    arrayOfEmoji[55] = new Emoji(2130837995, 2130837996, 128162);
    arrayOfEmoji[56] = new Emoji(2130837999, 2130838000, 128166);
    arrayOfEmoji[57] = new Emoji(2130837997, 2130837998, 128164);
    arrayOfEmoji[58] = new Emoji(2130838001, 2130838002, 128168);
    arrayOfEmoji[59] = new Emoji(2130837889, 2130837890, 128066);
    arrayOfEmoji[60] = new Emoji(2130837887, 2130837888, 128064);
    arrayOfEmoji[61] = new Emoji(2130837891, 2130837892, 128067);
    arrayOfEmoji[62] = new Emoji(2130837895, 2130837896, 128069);
    arrayOfEmoji[63] = new Emoji(2130837893, 2130837894, 128068);
    arrayOfEmoji[64] = new Emoji(2130837911, 2130837912, 128077);
    arrayOfEmoji[65] = new Emoji(2130837913, 2130837914, 128078);
    arrayOfEmoji[66] = new Emoji(2130837909, 2130837910, 128076);
    arrayOfEmoji[67] = new Emoji(2130837905, 2130837906, 128074);
    arrayOfEmoji[68] = new Emoji(2130838143, 2130838144, 9994);
    arrayOfEmoji[69] = new Emoji(2130838147, 2130838148, 9996);
    arrayOfEmoji[70] = new Emoji(2130837907, 2130837908, 128075);
    arrayOfEmoji[71] = new Emoji(2130838145, 2130838146, 9995);
    arrayOfEmoji[72] = new Emoji(2130837917, 2130837918, 128080);
    arrayOfEmoji[73] = new Emoji(2130837897, 2130837898, 128070);
    arrayOfEmoji[74] = new Emoji(2130837899, 2130837900, 128071);
    arrayOfEmoji[75] = new Emoji(2130837903, 2130837904, 128073);
    arrayOfEmoji[76] = new Emoji(2130837901, 2130837902, 128072);
    arrayOfEmoji[77] = new Emoji(2130838121, 2130838122, 128588);
    arrayOfEmoji[78] = new Emoji(2130838125, 2130838126, 128591);
    arrayOfEmoji[79] = new Emoji(2130838135, 2130838136, 9757);
    arrayOfEmoji[80] = new Emoji(2130837915, 2130837916, 128079);
    arrayOfEmoji[81] = new Emoji(2130838005, 2130838006, 128170);
    arrayOfEmoji[82] = new Emoji(2130837963, 2130837964, 128131);
    arrayOfEmoji[83] = new Emoji(2130837927, 2130837928, 128107);
    arrayOfEmoji[84] = new Emoji(2130837969, 2130837970, 128143);
    arrayOfEmoji[85] = new Emoji(2130837973, 2130837974, 128145);
    arrayOfEmoji[86] = new Emoji(2130837931, 2130837932, 128111);
    arrayOfEmoji[87] = new Emoji(2130838119, 2130838120, 128587);
    arrayOfEmoji[88] = new Emoji(2130837965, 2130837966, 128133);
    arrayOfEmoji[89] = new Emoji(2130838123, 2130838124, 128589);
    arrayOfEmoji[90] = new Emoji(2130837743, 2130837744, 127746);
    arrayOfEmoji[91] = new Emoji(2130837989, 2130837990, 128155);
    arrayOfEmoji[92] = new Emoji(2130837985, 2130837986, 128153);
    arrayOfEmoji[93] = new Emoji(2130837991, 2130837992, 128156);
    arrayOfEmoji[94] = new Emoji(2130837987, 2130837988, 128154);
    arrayOfEmoji[95] = new Emoji(2130838151, 2130838152, 10084);
    arrayOfEmoji[96] = new Emoji(2130837977, 2130837978, 128148);
    arrayOfEmoji[97] = new Emoji(2130837981, 2130837982, 128151);
    arrayOfEmoji[98] = new Emoji(2130837975, 2130837976, 128147);
    arrayOfEmoji[99] = new Emoji(2130837979, 2130837980, 128150);
    arrayOfEmoji[100] = new Emoji(2130837983, 2130837984, 128152);
    arrayOfEmoji[101] = new Emoji(2130837967, 2130837968, 128139);
    arrayOfEmoji[102] = new Emoji(2130837881, 2130837882, 128058);
    arrayOfEmoji[103] = new Emoji(2130837865, 2130837866, 128049);
    arrayOfEmoji[104] = new Emoji(2130837873, 2130837874, 128054);
    arrayOfEmoji[105] = new Emoji(2130837857, 2130837858, 128045);
    arrayOfEmoji[106] = new Emoji(2130837879, 2130837880, 128057);
    arrayOfEmoji[107] = new Emoji(2130837863, 2130837864, 128048);
    arrayOfEmoji[108] = new Emoji(2130837877, 2130837878, 128056);
    arrayOfEmoji[109] = new Emoji(2130837861, 2130837862, 128047);
    arrayOfEmoji[110] = new Emoji(2130837849, 2130837850, 128040);
    arrayOfEmoji[111] = new Emoji(2130837883, 2130837884, 128059);
    arrayOfEmoji[112] = new Emoji(2130837875, 2130837876, 128055);
    arrayOfEmoji[113] = new Emoji(2130837859, 2130837860, 128046);
    arrayOfEmoji[114] = new Emoji(2130837827, 2130837828, 128023);
    arrayOfEmoji[115] = new Emoji(2130837871, 2130837872, 128053);
    arrayOfEmoji[116] = new Emoji(2130837823, 2130837824, 128018);
    arrayOfEmoji[117] = new Emoji(2130837869, 2130837870, 128052);
    arrayOfEmoji[118] = new Emoji(2130837821, 2130837822, 128017);
    arrayOfEmoji[119] = new Emoji(2130837829, 2130837830, 128024);
    arrayOfEmoji[120] = new Emoji(2130837847, 2130837848, 128039);
    arrayOfEmoji[121] = new Emoji(2130837845, 2130837846, 128038);
    arrayOfEmoji[122] = new Emoji(2130837843, 2130837844, 128037);
    arrayOfEmoji[123] = new Emoji(2130837825, 2130837826, 128020);
    arrayOfEmoji[124] = new Emoji(2130837817, 2130837818, 128013);
    arrayOfEmoji[125] = new Emoji(2130837835, 2130837836, 128027);
    arrayOfEmoji[126] = new Emoji(2130837831, 2130837832, 128025);
    arrayOfEmoji[127] = new Emoji(2130837833, 2130837834, 128026);
    arrayOfEmoji[''] = new Emoji(2130837839, 2130837840, 128032);
    arrayOfEmoji[''] = new Emoji(2130837837, 2130837838, 128031);
    arrayOfEmoji[''] = new Emoji(2130837855, 2130837856, 128044);
    arrayOfEmoji[''] = new Emoji(2130837867, 2130837868, 128051);
    arrayOfEmoji[''] = new Emoji(2130837819, 2130837820, 128014);
    arrayOfEmoji[''] = new Emoji(2130837841, 2130837842, 128033);
    arrayOfEmoji[''] = new Emoji(2130837853, 2130837854, 128043);
    arrayOfEmoji[''] = new Emoji(2130837851, 2130837852, 128041);
    arrayOfEmoji[''] = new Emoji(2130837885, 2130837886, 128062);
    arrayOfEmoji[''] = new Emoji(2130837971, 2130837972, 128144);
    arrayOfEmoji[''] = new Emoji(2130837759, 2130837760, 127800);
    arrayOfEmoji[''] = new Emoji(2130837757, 2130837758, 127799);
    arrayOfEmoji[''] = new Emoji(2130837769, 2130837770, 127808);
    arrayOfEmoji[''] = new Emoji(2130837761, 2130837762, 127801);
    arrayOfEmoji[''] = new Emoji(2130837765, 2130837766, 127803);
    arrayOfEmoji[''] = new Emoji(2130837763, 2130837764, 127802);
    arrayOfEmoji[''] = new Emoji(2130837771, 2130837772, 127809);
    arrayOfEmoji[''] = new Emoji(2130837775, 2130837776, 127811);
    arrayOfEmoji[''] = new Emoji(2130837773, 2130837774, 127810);
    arrayOfEmoji[''] = new Emoji(2130837767, 2130837768, 127806);
    arrayOfEmoji[''] = new Emoji(2130837755, 2130837756, 127797);
    arrayOfEmoji[''] = new Emoji(2130837753, 2130837754, 127796);
    arrayOfEmoji[''] = new Emoji(2130837751, 2130837752, 127793);
    arrayOfEmoji[''] = new Emoji(2130837747, 2130837748, 127769);
    arrayOfEmoji[''] = new Emoji(2130838127, 2130838128, 9728);
    arrayOfEmoji[''] = new Emoji(2130838129, 2130838130, 9729);
    arrayOfEmoji[''] = new Emoji(2130838139, 2130838140, 9889);
    arrayOfEmoji[''] = new Emoji(2130838131, 2130838132, 9748);
    arrayOfEmoji[''] = new Emoji(2130838141, 2130838142, 9924);
    arrayOfEmoji[''] = new Emoji(2130837741, 2130837742, 127744);
    arrayOfEmoji[''] = new Emoji(2130837745, 2130837746, 127754);
    arrayOfEmoji[''] = new Emoji(2130837801, 2130837802, 127885);
    arrayOfEmoji[' '] = new Emoji(2130837993, 2130837994, 128157);
    arrayOfEmoji['¡'] = new Emoji(2130837803, 2130837804, 127886);
    arrayOfEmoji['¢'] = new Emoji(2130837809, 2130837810, 127891);
    arrayOfEmoji['£'] = new Emoji(2130837805, 2130837806, 127887);
    arrayOfEmoji['¤'] = new Emoji(2130837807, 2130837808, 127888);
    arrayOfEmoji['¥'] = new Emoji(2130837791, 2130837792, 127875);
    arrayOfEmoji['¦'] = new Emoji(2130837949, 2130837950, 128123);
    arrayOfEmoji['§'] = new Emoji(2130837795, 2130837796, 127877);
    arrayOfEmoji['¨'] = new Emoji(2130837793, 2130837794, 127876);
    arrayOfEmoji['©'] = new Emoji(2130837789, 2130837790, 127873);
    arrayOfEmoji['ª'] = new Emoji(2130837799, 2130837800, 127881);
    arrayOfEmoji['«'] = new Emoji(2130837797, 2130837798, 127880);
    arrayOfEmoji['¬'] = new Emoji(2130838013, 2130838014, 128191);
    arrayOfEmoji['­'] = new Emoji(2130838015, 2130838016, 128192);
    arrayOfEmoji['®'] = new Emoji(2130838009, 2130838010, 128189);
    arrayOfEmoji['¯'] = new Emoji(2130838011, 2130838012, 128190);
    arrayOfEmoji['°'] = new Emoji(2130838007, 2130838008, 128187);
    arrayOfEmoji['±'] = new Emoji(2130838021, 2130838022, 128241);
    arrayOfEmoji['²'] = new Emoji(2130838017, 2130838018, 128222);
    arrayOfEmoji['³'] = new Emoji(2130838019, 2130838020, 128224);
    arrayOfEmoji['´'] = new Emoji(2130838025, 2130838026, 128250);
    arrayOfEmoji['µ'] = new Emoji(2130838027, 2130838028, 128276);
    arrayOfEmoji['¶'] = new Emoji(2130838023, 2130838024, 128242);
    arrayOfEmoji['·'] = new Emoji(2130837815, 2130837816, 127932);
    arrayOfEmoji['¸'] = new Emoji(2130837811, 2130837812, 127925);
    arrayOfEmoji['¹'] = new Emoji(2130837813, 2130837814, 127926);
    arrayOfEmoji['º'] = new Emoji(2130837955, 2130837956, 128126);
    arrayOfEmoji['»'] = new Emoji(2130838133, 2130838134, 9749);
    arrayOfEmoji['¼'] = new Emoji(2130837787, 2130837788, 127866);
    arrayOfEmoji['½'] = new Emoji(2130837785, 2130837786, 127864);
    arrayOfEmoji['¾'] = new Emoji(2130837783, 2130837784, 127828);
    arrayOfEmoji['¿'] = new Emoji(2130837779, 2130837780, 127822);
    arrayOfEmoji['À'] = new Emoji(2130837777, 2130837778, 127818);
    arrayOfEmoji['Á'] = new Emoji(2130837781, 2130837782, 127827);
    h = ImmutableList.a(localEmoji1, localEmoji2, localEmoji3, localEmoji4, localEmoji5, localEmoji6, localEmoji7, localEmoji8, localEmoji9, localEmoji10, localEmoji11, localEmoji12, arrayOfEmoji);
    Integer localInteger1 = Integer.valueOf(128515);
    Integer localInteger2 = Integer.valueOf(128521);
    Integer localInteger3 = Integer.valueOf(128536);
    Integer localInteger4 = Integer.valueOf(128563);
    Integer localInteger5 = Integer.valueOf(128513);
    Integer localInteger6 = Integer.valueOf(128540);
    Integer localInteger7 = Integer.valueOf(128530);
    Integer localInteger8 = Integer.valueOf(128527);
    Integer localInteger9 = Integer.valueOf(128546);
    Integer localInteger10 = Integer.valueOf(128514);
    Integer localInteger11 = Integer.valueOf(128545);
    Integer localInteger12 = Integer.valueOf(128127);
    Integer[] arrayOfInteger = new Integer[40];
    arrayOfInteger[0] = Integer.valueOf(128125);
    arrayOfInteger[1] = Integer.valueOf(128169);
    arrayOfInteger[2] = Integer.valueOf(128064);
    arrayOfInteger[3] = Integer.valueOf(128068);
    arrayOfInteger[4] = Integer.valueOf(128139);
    arrayOfInteger[5] = Integer.valueOf(10084);
    arrayOfInteger[6] = Integer.valueOf(128148);
    arrayOfInteger[7] = Integer.valueOf(128152);
    arrayOfInteger[8] = Integer.valueOf(128077);
    arrayOfInteger[9] = Integer.valueOf(128078);
    arrayOfInteger[10] = Integer.valueOf(128073);
    arrayOfInteger[11] = Integer.valueOf(128072);
    arrayOfInteger[12] = Integer.valueOf(127775);
    arrayOfInteger[13] = Integer.valueOf(128293);
    arrayOfInteger[14] = Integer.valueOf(9728);
    arrayOfInteger[15] = Integer.valueOf(9748);
    arrayOfInteger[16] = Integer.valueOf(9729);
    arrayOfInteger[17] = Integer.valueOf(9889);
    arrayOfInteger[18] = Integer.valueOf(128054);
    arrayOfInteger[19] = Integer.valueOf(128048);
    arrayOfInteger[20] = Integer.valueOf(128056);
    arrayOfInteger[21] = Integer.valueOf(128047);
    arrayOfInteger[22] = Integer.valueOf(128059);
    arrayOfInteger[23] = Integer.valueOf(128055);
    arrayOfInteger[24] = Integer.valueOf(128046);
    arrayOfInteger[25] = Integer.valueOf(128018);
    arrayOfInteger[26] = Integer.valueOf(128024);
    arrayOfInteger[27] = Integer.valueOf(128013);
    arrayOfInteger[28] = Integer.valueOf(128020);
    arrayOfInteger[29] = Integer.valueOf(128039);
    arrayOfInteger[30] = Integer.valueOf(128031);
    arrayOfInteger[31] = Integer.valueOf(128051);
    arrayOfInteger[32] = Integer.valueOf(128144);
    arrayOfInteger[33] = Integer.valueOf(127801);
    arrayOfInteger[34] = Integer.valueOf(127808);
    arrayOfInteger[35] = Integer.valueOf(9749);
    arrayOfInteger[36] = Integer.valueOf(127866);
    arrayOfInteger[37] = Integer.valueOf(127864);
    arrayOfInteger[38] = Integer.valueOf(127828);
    arrayOfInteger[39] = Integer.valueOf(127822);
    m = ImmutableList.a(localInteger1, localInteger2, localInteger3, localInteger4, localInteger5, localInteger6, localInteger7, localInteger8, localInteger9, localInteger10, localInteger11, localInteger12, arrayOfInteger);
    i = ImmutableMap.k().b(":-)", Integer.valueOf(128522)).b(":)", Integer.valueOf(128522)).b(":]", Integer.valueOf(128522)).b("=)", Integer.valueOf(128522)).b(":-(", Integer.valueOf(128542)).b(":(", Integer.valueOf(128542)).b(":[", Integer.valueOf(128542)).b("=(", Integer.valueOf(128542)).b(":-P", Integer.valueOf(128540)).b(":P", Integer.valueOf(128540)).b(":-p", Integer.valueOf(128540)).b(":p", Integer.valueOf(128540)).b("=P", Integer.valueOf(128540)).b(":-D", Integer.valueOf(128515)).b(":D", Integer.valueOf(128515)).b("=D", Integer.valueOf(128515)).b(":-O", Integer.valueOf(128562)).b(":O", Integer.valueOf(128562)).b(":-o", Integer.valueOf(128562)).b(":o", Integer.valueOf(128562)).b(";-)", Integer.valueOf(128521)).b(";)", Integer.valueOf(128521)).b("8-)", Integer.valueOf(128526)).b("8)", Integer.valueOf(128526)).b("B-)", Integer.valueOf(128526)).b("B)", Integer.valueOf(128526)).b("8-|", Integer.valueOf(128526)).b("8|", Integer.valueOf(128526)).b("B-|", Integer.valueOf(128526)).b("B|", Integer.valueOf(128526)).b(">:(", Integer.valueOf(128544)).b(">:-(", Integer.valueOf(128544)).b(":/", Integer.valueOf(128527)).b(":-/", Integer.valueOf(128527)).b(":\\", Integer.valueOf(128527)).b(":-\\", Integer.valueOf(128527)).b(":'(", Integer.valueOf(128546)).b("3:)", Integer.valueOf(128520)).b("3:-)", Integer.valueOf(128520)).b("O:)", Integer.valueOf(128519)).b("O:-)", Integer.valueOf(128519)).b("0:)", Integer.valueOf(128519)).b("0:-)", Integer.valueOf(128519)).b(":-*", Integer.valueOf(128536)).b(":*", Integer.valueOf(128536)).b("<3", Integer.valueOf(10084)).b("&lt;3", Integer.valueOf(10084)).b("^_^", Integer.valueOf(128516)).b("-_-", Integer.valueOf(128528)).b("o.O", Integer.valueOf(128534)).b("O.o", Integer.valueOf(128534)).b(">:O", Integer.valueOf(128544)).b(">:-O", Integer.valueOf(128544)).b(">:o", Integer.valueOf(128544)).b(">:-o", Integer.valueOf(128544)).b(">_<", Integer.valueOf(128544)).b(">.<", Integer.valueOf(128544)).b("<(\")", Integer.valueOf(128039)).b(":-|", Integer.valueOf(128528)).b(":|", Integer.valueOf(128528)).b(":like:", Integer.valueOf(128077)).b("(y)", Integer.valueOf(128077)).b("(Y)", Integer.valueOf(128077)).b("(n)", Integer.valueOf(128078)).b("(N)", Integer.valueOf(128078)).b("(poo)", Integer.valueOf(128169)).b();
    j = Pattern.compile("(?:^|\\s|'|\"|\\.)((\\:\\-\\))|(\\:\\))|(\\:\\])|(=\\))|(\\:\\-\\()|(\\:\\()|(\\:\\[)|(=\\()|(\\:\\-P)|(\\:P)|(\\:\\-p)|(\\:p)|(=P)|(\\:\\-D)|(\\:D)|(=D)|(\\:\\-O)|(\\:O)|(\\:\\-o)|(\\:o)|(\\;\\-\\))|(\\;\\))|(8\\-\\))|(8\\))|(B\\-\\))|(B\\))|(8\\-\\|)|(8\\|)|(B\\-\\|)|(B\\|)|(>\\:\\()|(>\\:\\-\\()|(\\:/)|(\\:\\-/)|(\\:\\\\)|(\\:\\-\\\\)|(\\:'\\()|(3\\:\\))|(3\\:\\-\\))|(O\\:\\))|(O\\:\\-\\))|(0\\:\\))|(0\\:-\\))|(\\:\\-\\*)|(\\:\\*)|(<3)|(&lt\\;3)|(\\^_\\^)|(\\-_\\-)|(o\\.O)|(O\\.o)|(>\\:O)|(>\\:\\-O)|(>\\:o)|(>\\:\\-o)|(>_<)|(>\\.<)|(<\\(\"\\))|(\\:\\-\\|)|(\\:\\|)|(\\:like\\:)|(\\(y\\))|(\\(Y\\))|(\\(n\\))|(\\(N\\))|(\\(poo\\)))(?:|'|\"|\\.|,|!|\\?|$)");
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    Iterator localIterator1 = h.iterator();
    while (localIterator1.hasNext())
    {
      Emoji localEmoji13 = (Emoji)localIterator1.next();
      localBuilder.b(Integer.valueOf(localEmoji13.c()), localEmoji13);
    }
    k = localBuilder.b();
    ImmutableList localImmutableList1 = h.a(0, 114);
    ImmutableList localImmutableList2 = h.a(114, 171);
    ImmutableList localImmutableList3 = h.a(171, 206);
    a = ImmutableList.a(new EmojiSet(2130838604, localImmutableList1), new EmojiSet(2130838602, localImmutableList2), new EmojiSet(2130838603, localImmutableList3));
    ArrayList localArrayList = Lists.a();
    Iterator localIterator2 = m.iterator();
    while (localIterator2.hasNext())
    {
      Integer localInteger13 = (Integer)localIterator2.next();
      localArrayList.add(k.get(localInteger13));
    }
    b = new EmojiSet(0, ImmutableList.a(localArrayList));
  }

  public Emoji a(int paramInt)
  {
    Emoji localEmoji;
    if (!b(paramInt))
      localEmoji = null;
    while (true)
    {
      return localEmoji;
      ImmutableCollection localImmutableCollection = f.c(Integer.valueOf(paramInt));
      if ((localImmutableCollection != null) && (localImmutableCollection.size() > 0))
        paramInt = ((Integer)localImmutableCollection.iterator().next()).intValue();
      localEmoji = (Emoji)k.get(Integer.valueOf(paramInt));
      if (localEmoji == null)
      {
        Integer localInteger = (Integer)g.get(Integer.valueOf(paramInt));
        if (localInteger != null)
          localEmoji = (Emoji)k.get(localInteger);
      }
      if (localEmoji != null)
        continue;
      localEmoji = l;
    }
  }

  public Emoji a(String paramString)
  {
    if (!i.containsKey(paramString));
    for (Emoji localEmoji = null; ; localEmoji = (Emoji)k.get(i.get(paramString)))
      return localEmoji;
  }

  boolean b(int paramInt)
  {
    int n;
    if ((paramInt < c) || (paramInt > d))
      n = 0;
    while (true)
    {
      return n;
      Iterator localIterator = e.iterator();
      Emojis.MinMaxCodePoint localMinMaxCodePoint;
      do
      {
        if (!localIterator.hasNext())
          break label73;
        localMinMaxCodePoint = (Emojis.MinMaxCodePoint)localIterator.next();
        if (paramInt >= Emojis.MinMaxCodePoint.a(localMinMaxCodePoint))
          continue;
        n = 0;
        break;
      }
      while (paramInt > Emojis.MinMaxCodePoint.b(localMinMaxCodePoint));
      n = 1;
      continue;
      label73: n = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.Emojis
 * JD-Core Version:    0.6.0
 */