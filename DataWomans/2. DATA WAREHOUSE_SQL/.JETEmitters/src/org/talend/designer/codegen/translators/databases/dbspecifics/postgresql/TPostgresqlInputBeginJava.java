package org.talend.designer.codegen.translators.databases.dbspecifics.postgresql;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.Map;
import java.util.List;

public class TPostgresqlInputBeginJava
{
  protected static String nl;
  public static synchronized TPostgresqlInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPostgresqlInputBeginJava result = new TPostgresqlInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL + "                log.error(message_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "                System.err.println(message_";
  protected final String TEXT_21 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_22 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_23 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Uses an existing connection ";
  protected final String TEXT_26 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_28 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_29 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_30 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\tconn_";
  protected final String TEXT_33 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_34 = ", dbUser_";
  protected final String TEXT_35 = ", dbPwd_";
  protected final String TEXT_36 = ");" + NL + "\t\t\t";
  protected final String TEXT_37 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_38 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_39 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\tif(\"com.mysql.cj.jdbc.Driver\".equals((String)globalMap.get(\"driverClass_";
  protected final String TEXT_41 = "\"))" + NL + "\t\t\t    && routines.system.BundleUtils.inOSGi()) {" + NL + "\t\t\t        Class.forName(\"com.mysql.cj.jdbc.AbandonedConnectionCleanupThread\")." + NL + "\t\t\t            getMethod(\"checkedShutdown\").invoke(null, (Object[]) null);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\tconn_";
  protected final String TEXT_43 = ".setAutoCommit(";
  protected final String TEXT_44 = NL + "\t\t\t\tlog.";
  protected final String TEXT_45 = "(\"";
  protected final String TEXT_46 = " - \" + ";
  protected final String TEXT_47 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t    \t\tlog.";
  protected final String TEXT_49 = "\");" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_51 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_53 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_54 = ": pstmt_";
  protected final String TEXT_55 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_56 = " += (countEach_";
  protected final String TEXT_57 = " < 0 ? 0 : ";
  protected final String TEXT_58 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "            java.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_60 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_61 = ") {";
  protected final String TEXT_62 = NL + "    \t\t\tString dsAlias_";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ";" + NL + "        \t\tif (dataSources_";
  protected final String TEXT_65 = ".get(dsAlias_";
  protected final String TEXT_66 = ") == null) {" + NL + "           \t\t\tthrow new RuntimeException(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_67 = " + \" available!\");" + NL + "              \t}" + NL + "        \t\tconn_";
  protected final String TEXT_68 = " = dataSources_";
  protected final String TEXT_69 = ").getConnection();" + NL + "            } else {";
  protected final String TEXT_70 = NL + "\t\t\t\tString driverClass_";
  protected final String TEXT_71 = " = \"";
  protected final String TEXT_72 = "\";" + NL + "\t\t\t    java.lang.Class jdbcclazz_";
  protected final String TEXT_73 = " = java.lang.Class.forName(driverClass_";
  protected final String TEXT_74 = NL + "\t\t\t\tString dbUser_";
  protected final String TEXT_75 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t";
  protected final String TEXT_77 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_78 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_79 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_80 = "; ";
  protected final String TEXT_81 = NL + "\t\t\t\t" + NL + "\t\t\t\tString dbPwd_";
  protected final String TEXT_82 = " = decryptedPassword_";
  protected final String TEXT_83 = ",dbUser_";
  protected final String TEXT_84 = ",dbPwd_";
  protected final String TEXT_85 = NL + "\t\t        ";
  protected final String TEXT_86 = NL + "\t\t    }";
  protected final String TEXT_87 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_88 = " = conn_";
  protected final String TEXT_89 = ".createStatement();";
  protected final String TEXT_90 = ".createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjava.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t\ttmpContent_";
  protected final String TEXT_92 = " = rs_";
  protected final String TEXT_93 = ".getString(";
  protected final String TEXT_94 = "column_index_";
  protected final String TEXT_95 = NL + "                        if(tmpContent_";
  protected final String TEXT_96 = " != null) {" + NL + "                            tmpContent_";
  protected final String TEXT_97 = " = tmpContent_";
  protected final String TEXT_98 = ";" + NL + "                        }";
  protected final String TEXT_99 = NL + "                    if(tmpContent_";
  protected final String TEXT_100 = " != null && tmpContent_";
  protected final String TEXT_101 = ".length() > 0) {\t\t\t  \t";
  protected final String TEXT_102 = NL + "                        ";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = ".charAt(0);\t\t\t  \t\t" + NL + "                    } else {\t\t\t  \t";
  protected final String TEXT_105 = "\t\t\t  \t    " + NL + "                            if(tmpContent_";
  protected final String TEXT_106 = " == null) {\t\t\t  \t   \t";
  protected final String TEXT_107 = NL + "                                ";
  protected final String TEXT_108 = " = null;\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t";
  protected final String TEXT_109 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            }";
  protected final String TEXT_110 = "\t\t\t  \t\t" + NL + "                            if((\"\").equals(tmpContent_";
  protected final String TEXT_111 = ")) {\t\t\t  \t\t";
  protected final String TEXT_112 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            } else {" + NL + "        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_113 = "' in '";
  protected final String TEXT_114 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "                            }\t\t\t  \t\t";
  protected final String TEXT_115 = NL + "                    }";
  protected final String TEXT_116 = NL + "\t\t\t";
  protected final String TEXT_117 = " = routines.system.JDBCUtil.getDate(rs_";
  protected final String TEXT_118 = ", ";
  protected final String TEXT_119 = NL + "        \t";
  protected final String TEXT_120 = " = routines.system.JDBCUtil.getString(rs_";
  protected final String TEXT_121 = "false";
  protected final String TEXT_122 = "true";
  protected final String TEXT_123 = NL + "            ";
  protected final String TEXT_124 = ".get";
  protected final String TEXT_125 = "(";
  protected final String TEXT_126 = ");" + NL + "            if(rs_";
  protected final String TEXT_127 = ".wasNull()){";
  protected final String TEXT_128 = NL + "                    ";
  protected final String TEXT_129 = " = null;";
  protected final String TEXT_130 = NL + "                    throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_131 = NL + "            }";
  protected final String TEXT_132 = NL + "\t\t\t\tString url_";
  protected final String TEXT_133 = " = \"jdbc:postgresql://\" + ";
  protected final String TEXT_134 = " + \":\" + ";
  protected final String TEXT_135 = " + \"/\" + ";
  protected final String TEXT_136 = ";";
  protected final String TEXT_137 = " + \"?\" + ";
  protected final String TEXT_138 = NL + "                stmt_";
  protected final String TEXT_139 = ".setFetchSize(";
  protected final String TEXT_140 = NL + "    " + NL + "\t";
  protected final String TEXT_141 = NL + "\t\t    int nb_line_";
  protected final String TEXT_142 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_143 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_144 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_145 = NL + "             boolean currentAutoCommitMode";
  protected final String TEXT_146 = " =  conn_";
  protected final String TEXT_147 = ".getAutoCommit();" + NL + "             conn_";
  protected final String TEXT_148 = ".setAutoCommit(true);" + NL + "             try{";
  protected final String TEXT_149 = NL + "                           try{" + NL + "                               conn_";
  protected final String TEXT_150 = ".createStatement().execute(\"BEGIN QUERY LOGGING WITH SQL,OBJECTS ON \" + ";
  protected final String TEXT_151 = ");" + NL + "                           }catch(Exception e){" + NL + "globalMap.put(\"";
  protected final String TEXT_152 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "                                 System.err.println(e.getMessage());" + NL + "                           }";
  protected final String TEXT_153 = NL + "                 conn_";
  protected final String TEXT_154 = ".createStatement().execute(" + NL + "              \"SET QUERY_BAND='\" +";
  protected final String TEXT_155 = NL + "               ";
  protected final String TEXT_156 = " + \"=\" + ";
  protected final String TEXT_157 = " + \";\" +";
  protected final String TEXT_158 = " \"' FOR SESSION\"" + NL + "           );" + NL + "              }catch(Exception e){" + NL + "globalMap.put(\"";
  protected final String TEXT_159 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "               System.err.println(e.getMessage());" + NL + "      }" + NL + "      conn_";
  protected final String TEXT_160 = ".setAutoCommit(currentAutoCommitMode";
  protected final String TEXT_161 = NL + "\t\t    ";
  protected final String TEXT_162 = NL + NL + "\t\t    String dbquery_";
  protected final String TEXT_163 = ";" + NL + "\t\t    ";
  protected final String TEXT_164 = NL;
  protected final String TEXT_165 = NL + "            \tglobalMap.put(\"";
  protected final String TEXT_166 = "_QUERY\",dbquery_";
  protected final String TEXT_167 = NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_168 = " = null;" + NL + "" + NL + "\t\t    try {" + NL + "\t\t    \trs_";
  protected final String TEXT_169 = " = stmt_";
  protected final String TEXT_170 = ".executeQuery(dbquery_";
  protected final String TEXT_171 = ");" + NL + "\t\t    \tjava.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_172 = ".getMetaData();" + NL + "\t\t    \tint colQtyInRs_";
  protected final String TEXT_173 = " = rsmd_";
  protected final String TEXT_174 = ".getColumnCount();" + NL;
  protected final String TEXT_175 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_176 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_177 = ".setDbmsId(\"";
  protected final String TEXT_178 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_179 = "=new java.util.ArrayList<String>();" + NL + "\t\t    ";
  protected final String TEXT_180 = NL + "\t\t    \t    listSchema_";
  protected final String TEXT_181 = ".add(\"";
  protected final String TEXT_182 = "\");" + NL + "\t    \t    ";
  protected final String TEXT_183 = NL + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_184 = ";" + NL + "" + NL + "            for (int i = ";
  protected final String TEXT_185 = "; i <= rsmd_";
  protected final String TEXT_186 = ".getColumnCount()-";
  protected final String TEXT_187 = "; i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_188 = ".contains(rsmd_";
  protected final String TEXT_189 = ".getColumnLabel(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_190 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_191 = ".setName(rsmd_";
  protected final String TEXT_192 = ".getColumnLabel(i));" + NL + "                \tdcm_";
  protected final String TEXT_193 = ".setDbName(rsmd_";
  protected final String TEXT_194 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_195 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_196 = "\", rsmd_";
  protected final String TEXT_197 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_198 = ".getPrecision(i), rsmd_";
  protected final String TEXT_199 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_200 = ".setDbType(rsmd_";
  protected final String TEXT_201 = ".getColumnTypeName(i));" + NL + "                \tdcm_";
  protected final String TEXT_202 = ".setDbTypeId(rsmd_";
  protected final String TEXT_203 = ".getColumnType(i));";
  protected final String TEXT_204 = NL + "                \tdcm_";
  protected final String TEXT_205 = ".setFormat(";
  protected final String TEXT_206 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_207 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_208 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_209 = ".setLength(rsmd_";
  protected final String TEXT_210 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_211 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_212 = NL + "\t\t\tdcm_";
  protected final String TEXT_213 = ".getPrecision(i));";
  protected final String TEXT_214 = ".setPrecision(rsmd_";
  protected final String TEXT_215 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_216 = ".setNullable(rsmd_";
  protected final String TEXT_217 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_218 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_219 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_220 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_221 = ".metadatas.add(dcm_";
  protected final String TEXT_222 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_223 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_224 = " = null;" + NL + "\t\t    ";
  protected final String TEXT_225 = NL + "\t\t    \tint column_index_";
  protected final String TEXT_226 = " =1;" + NL + "\t\t    ";
  protected final String TEXT_227 = NL + "\t\t    \tlog.debug(\"";
  protected final String TEXT_228 = " - Retrieving records from the database.\");" + NL + "\t\t    ";
  protected final String TEXT_229 = NL + "\t\t    while (rs_";
  protected final String TEXT_230 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_231 = "++;" + NL + "\t\t        ";
  protected final String TEXT_232 = NL + "\t\t\t\t\t\t\t\t\tcolumn_index_";
  protected final String TEXT_233 = " + dcg_";
  protected final String TEXT_234 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_235 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_237 = NL + "\t\t\t\t\t\t\tif(colQtyInRs_";
  protected final String TEXT_238 = " < ";
  protected final String TEXT_239 = ") {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_240 = ";" + NL + "\t\t\t\t\t\t\t} else {";
  protected final String TEXT_241 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_243 = NL + "\t\t                            ";
  protected final String TEXT_244 = " = (List)rs_";
  protected final String TEXT_245 = ".getObject(";
  protected final String TEXT_246 = NL + "\t                         \t\t";
  protected final String TEXT_247 = NL + "                                    oracle.sql.STRUCT jGeomStruct = (oracle.sql.STRUCT) rs_";
  protected final String TEXT_248 = ");" + NL + "                                    if (jGeomStruct != null) {" + NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load(jGeomStruct);" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_249 = NL + "                                    ";
  protected final String TEXT_250 = " = new Geometry(wktValue);" + NL + "                                    } else {";
  protected final String TEXT_251 = NL + "                                      ";
  protected final String TEXT_252 = " = null;" + NL + "                                    }";
  protected final String TEXT_253 = NL + "                                        if (";
  protected final String TEXT_254 = " != null) {";
  protected final String TEXT_255 = NL + "                                        ";
  protected final String TEXT_256 = ".setEPSG(";
  protected final String TEXT_257 = ");" + NL + "                                        }";
  protected final String TEXT_258 = NL + "                                  ";
  protected final String TEXT_259 = "=dcg_";
  protected final String TEXT_260 = NL + "\t\t\t\t\t\t\t\t\t\tList<String> list_";
  protected final String TEXT_261 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_262 = "; i_";
  protected final String TEXT_263 = "  <= rsmd_";
  protected final String TEXT_264 = ".getColumnCount(); i_";
  protected final String TEXT_265 = " ++){" + NL + "\t\t\t\t\t    \t\t\t\t\t";
  protected final String TEXT_266 = NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_267 = ".getColumnTypeName(i_";
  protected final String TEXT_268 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_269 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_270 = ".getClob(i_";
  protected final String TEXT_271 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_272 = " !=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_273 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_274 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_275 = ".add(tNTextImpl_";
  protected final String TEXT_276 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_277 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t";
  protected final String TEXT_278 = " " + NL + "\t\t\t\t\t\t   \t\t\t\t\tif(\"NTEXT\".equals(rsmd_";
  protected final String TEXT_279 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t   \t\t\t\t\t\tlist_";
  protected final String TEXT_280 = ".add(rs_";
  protected final String TEXT_281 = ".getString(i_";
  protected final String TEXT_282 = "));" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t";
  protected final String TEXT_283 = NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_284 = ", rs_";
  protected final String TEXT_285 = ", fixedColumnCount_";
  protected final String TEXT_286 = ",list_";
  protected final String TEXT_287 = ",";
  protected final String TEXT_288 = NL + "\t\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.readColumnsFromDatabase_Access(";
  protected final String TEXT_289 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_290 = NL + "                                  Object geom = rs_";
  protected final String TEXT_291 = ");" + NL + "                                  if (geom != null) {" + NL + "                                  \torg.postgis.Geometry o =" + NL + "                                      org.postgis.PGgeometry.geomFromString(geom.toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_292 = " = new Geometry(sb.toString());" + NL + "                                  } else {" + NL + "                                  \t";
  protected final String TEXT_293 = " = null;" + NL + "                                  }";
  protected final String TEXT_294 = NL + "\t\t                          ";
  protected final String TEXT_295 = NL + "\t\t                    }";
  protected final String TEXT_296 = NL + "\t\t\t\t\t";
  protected final String TEXT_297 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_298 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_299 = ";" + NL + "\t\t                            ";
  protected final String TEXT_300 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}

        public void logErrorMessage() {
            if(isLog4jEnabled){
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            } else {
            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            }
        }
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_26);
    } else {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
			connect_end();
		}
		
		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
     /* TESB-24900 - graceful shutdown for MYSQL connection */ 
    stringBuffer.append(TEXT_40);
    stringBuffer.append((connection!=null)?connection.replaceAll("'","").trim():"");
    stringBuffer.append(TEXT_41);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_36);
    
		}

		public void query(INode node, String dbQueryVariableName){
			beforeComponentProcess(node);
			//for input
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbQueryVariableName +" + \"'.");
		}

		/**
		* @deprecated please use another method instead: query(INode node, String dbQueryVariableName) because execution of the query expression can be not idempotent
		*/
		@Deprecated
		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_44);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_47);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_49);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_58);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	//this util class use by connection component
	class DefaultDBInputUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
		protected String dbport;
		protected String dbname;
		protected String dbuser;
		protected String dbpwd ;
		protected boolean isLog4jEnabled;
		protected boolean isDynamic;
		protected DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil;

		public void beforeComponentProcess(INode node){
			cid = node.getUniqueName();
			List<IMetadataTable> metadatas = node.getMetadataList();
			if ((metadatas != null) && (metadatas.size()>0)) {
				IMetadataTable metadata = metadatas.get(0);
				if (metadata != null) {
					isDynamic = metadata.isDynamicSchema();
				}
			}
			log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();
		}

		public void afterUseExistConnection(INode node) {
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
	    
	    public void afterUseNewConnection(INode node) {
	    }
	    
	    public void setURL(INode node) {
	    }
	    
		public void createConnection(INode node) {
			this.createConnection(node, true);
		}

		public void createConnection(INode node, boolean needUserAndPassword) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");

	 		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
 		if(specify_alias){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		}

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
				newInstance(node);

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_75);
    
				String passwordFieldName = "__PASS__";
				
    stringBuffer.append(TEXT_76);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_19);
    } else {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    this.setURL(node);
    stringBuffer.append(TEXT_76);
    
				log4jCodeGenerateUtil.debugConnectionParams(node);
				if (!needUserAndPassword){
					log4jCodeGenerateUtil.connect_begin_noUser();
				} else {
					log4jCodeGenerateUtil.connect_begin();
				}
				
    
			if(needUserAndPassword) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			} else {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
			}
			log4jCodeGenerateUtil.connect_end();

    stringBuffer.append(TEXT_85);
    this.afterUseNewConnection(node);
    
			if(specify_alias){

    stringBuffer.append(TEXT_86);
    
			}
		}
		
		protected void newInstance(INode node) {
			//do nothing as default
			//for sybase jdbc in java 11, we have to call jdbcclazz.newInstance method
		}
		
		public String getQueryString(INode node) {
			String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			
			return dbquery;
		}
		
		public void createStatement(INode node) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		}
		public void createMinValueStatement(INode node){

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    }
		public String mappingType(String typeToGenerate) {
		
            if(("byte[]").equals(typeToGenerate)) {
                return "Bytes";
            } else if(("java.util.Date").equals(typeToGenerate)) {
                return "Timestamp";
            } else if(("Integer").equals(typeToGenerate)) {
               return "Int";
            } else {
                return typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringCharAndCharacterSet(String firstConnName, IMetadataColumn column, int currentColNo,
					String trimMethod, String typeToGenerate, boolean whetherTrimAllCol, boolean whetherTrimCol) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    if(isDynamic){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_19);
    
                    if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_98);
    
                    }

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
                        if(("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_109);
    
                        } else {

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_114);
    
                        }

    stringBuffer.append(TEXT_115);
    
		}
		
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    if(isDynamic){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_19);
    
	    }
	    
	    public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    if(isDynamic){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_118);
    if(trimMethod==null||trimMethod.isEmpty()){
    stringBuffer.append(TEXT_121);
    } else {
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_19);
    
	    }
	    
	    public void generateDoubleResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    	generateOthersResultSet(firstConnName, column, currentColNo, "Double");
	    }
	    
	    public void generateBooleanResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    	generateOthersResultSet(firstConnName, column, currentColNo, "Boolean");
	    }
	    
	    public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
	    public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_125);
    if(isDynamic){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    
                if(column.isNullable()) {
                    
    stringBuffer.append(TEXT_128);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_129);
    
                } else {
                    
    stringBuffer.append(TEXT_130);
        
                }
                
    stringBuffer.append(TEXT_131);
    
	    }
	    //---------end according schema type to generate ResultSet
	    
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultDBInputUtil class
	
	DefaultDBInputUtil dbInputBeginUtil = new DefaultDBInputUtil();
	
	

    

	class DBInputBeginUtil extends DefaultDBInputUtil{
	
		public void beforeComponentProcess(INode node){
			super.beforeComponentProcess(node);
			cid = node.getUniqueName();
		}
	    
		public void setURL(INode node) {
		
			if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_136);
    
			} else {

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_136);
    
			}
		}
		
		public String getDirverClassName(INode node){
			return "org.postgresql.Driver";
		}
		
		public void createConnection(INode node) {
			super.createConnection(node);
			log4jCodeGenerateUtil.autoCommit(node,false);
		}
		public void createStatement(INode node) {
			super.createStatement(node);
			String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
			String cursorSize= ElementParameterParser.getValue(node, "__CURSOR_SIZE__");
            if(("true").equals(useCursor)) {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cursorSize );
    stringBuffer.append(TEXT_19);
    
            }
		}
		
		//-----------according schema type to generate ResultSet
	    
	    //---------end according schema type to generate ResultSet
	}//end class
	
	dbInputBeginUtil = new DBInputBeginUtil();

    stringBuffer.append(TEXT_140);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");

	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String enableStream = ElementParameterParser.getValue(node, "__ENABLE_STREAM__");
	String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
	if("tJDBCInput".equals(node.getComponent().getName())) {
		boolean isEnableMapping = ("true").equals(ElementParameterParser.getValue(node, "__ENABLE_MAPPING__"));
		if (!isEnableMapping) {
			dbms = "";
		}
	}
	
	boolean isAmazonAurora = "mysql_id".equalsIgnoreCase(dbms) && node.isVirtualGenerateNode() && (cid.matches("^.*?tAmazonAuroraInput_\\d+_in$") || cid.matches("^.*?tDBInput_\\d+_in$"));
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");

    dbInputBeginUtil.beforeComponentProcess(node);
    int dynamic_index=-1;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;
		        
		        if(isAmazonAurora){
                    conn += "_in";
                }

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_144);
    log4jCodeGenerateUtil.useExistConnection(node);
    
				dbInputBeginUtil.afterUseExistConnection(node);
		    } else {
				dbInputBeginUtil.createConnection(node);
				if ("teradata_id".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_76);
    
      boolean queryBand = "true".equals(ElementParameterParser.getValue(node, "__QUERY_BAND__"));
      boolean activateQueryLogging = "true".equals(ElementParameterParser.getValue(node, "__ACTIVATE_QUERY_LOGGING__"));
      String usrName = ElementParameterParser.getValue(node, "__USER__");
      List<Map<String, String>> queryBandList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__QUERY_BAND_PARAMETERS__");
      if(queryBand){
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
                    if(activateQueryLogging){
                        
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append( usrName );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
                    }
                  
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
            for(Map<String, String> map : queryBandList) {

    stringBuffer.append(TEXT_155);
    stringBuffer.append( map.get("KEY") );
    stringBuffer.append(TEXT_156);
    stringBuffer.append( map.get("VALUE") );
    stringBuffer.append(TEXT_157);
    
            }

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_19);
    }
    
				}
		    }

    stringBuffer.append(TEXT_161);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_163);
     log4jCodeGenerateUtil.query(node, "dbquery_" + cid); 
    stringBuffer.append(TEXT_164);
     
            if(isAmazonAurora){
            // why 3: ==> "_in".length()
            
    stringBuffer.append(TEXT_165);
    stringBuffer.append( cid.substring(0,cid.length() - 3) );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            }else{
            
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            }
            
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();
		    boolean isDynamic = metadata.isDynamicSchema();
		    if(isDynamic){
		    	String DynamicDatePattern = "\"dd-MM-yyyy\"";
		    	for(IMetadataColumn column : columnList) {
		    		if("id_Dynamic".equals(column.getTalendType())) {
		    			DynamicDatePattern = column.getPattern();
		    			break;
		    		}
		    	}
		    
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    

		    for(int i=0; i< columnList.size(); i++) {
		        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
		            dynamic_index = i+1;
		        }else{
		            IMetadataColumn column = columnList.get(i);
		            String columName = column.getOriginalDbColumnName();
		            if(columName==null || "".equals(columName)){
		                columName = column.getLabel();
		            }
	            
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(columName.toUpperCase());
    stringBuffer.append(TEXT_182);
    
		    	}
			}
		    
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(columnList.size()-dynamic_index);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_19);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
		} else {

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
		}

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
		    }
		    
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    if(isDynamic){
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    }
    stringBuffer.append(TEXT_161);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    }
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    
		        if(conns != null && conns.size() > 0) {
		            IConnection conn = conns.get(0);
		            String firstConnName = conn.getName();
		            int currentColNo = 1;
		            for(IMetadataColumn column : columnList) {
		                boolean whetherTrimCol = false;
		                if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
		                    for(Map<String, String> trimColumn : trimColumnList) {
		                        if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
		                            if(("true").equals(trimColumn.get("TRIM"))) {
		                                whetherTrimCol = true;
		                                break;
		                            }
		                        }
		                    }
		                }
		                String trimMethod = "";
		                if(whetherTrimAllCol || whetherTrimCol) {
		                    trimMethod = ".trim()";
		                }
		                String columnType = column.getType();

		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
		                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							if(isDynamic){
								if(!("Dynamic").equals(typeToGenerate) && dynamic_index < currentColNo) {
								
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(currentColNo-1);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    }else{
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_235);
    }
    stringBuffer.append(TEXT_236);
    
							}
							
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    if(isDynamic){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_239);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_240);
    
								typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);

								if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_241);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    
								} else if(("Timestamp").equals(typeToGenerate)) {
									if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_242);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_242);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_243);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    if(isDynamic){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_19);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_246);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if(("Double").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_246);
    dbInputBeginUtil.generateDoubleResultSet(firstConnName, column, currentColNo);
    
								} else if(("Boolean").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_246);
    dbInputBeginUtil.generateBooleanResultSet(firstConnName, column, currentColNo);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    if(isDynamic){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_248);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_250);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_252);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_253);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_254);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_256);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_257);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_241);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_258);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
     //for bug TDI-20886
									boolean trim = whetherTrimAllCol || whetherTrimCol;
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {
										String driver = "";
										if(("true").equals(useExistingConn)) {
											String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
											INode connectionNode = null; 
											for (INode processNode : node.getProcess().getGeneratingNodes()) { 
												if(connection.equals(processNode.getUniqueName())) { 
													connectionNode = processNode; 
													break; 
												} 
											}
											driver = ElementParameterParser.getValue(connectionNode,"__DRIVER__");
										} else {
											driver = ElementParameterParser.getValue(node,"__DRIVER__");
										}

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
     if("JTDS".equals(driver)) { 
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
     } else {
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
     } 
    stringBuffer.append(TEXT_283);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_19);
    
									}else if("access_id".equalsIgnoreCase(dbms)){

    stringBuffer.append(TEXT_288);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_19);
    
									}else{

    stringBuffer.append(TEXT_289);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_19);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    if(isDynamic){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_291);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_293);
    
                 	            } else {

    stringBuffer.append(TEXT_294);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_295);
    
		                    currentColNo++;
		                }
		            }

    stringBuffer.append(TEXT_296);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    }
    
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_243);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_299);
    
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_164);
    stringBuffer.append(TEXT_300);
    return stringBuffer.toString();
  }
}
