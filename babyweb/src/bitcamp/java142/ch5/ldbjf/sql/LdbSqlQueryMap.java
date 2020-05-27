package bitcamp.java142.ch5.ldbjf.sql;

public abstract class LdbSqlQueryMap {
	
	
	public static final	String LDB_MEMBER_LMEM_CHEABUM =
			" SELECT /*+ INDEX_DESC(A.SYS_C0011185)  */ "
       +" NVL(MAX(SUBSTR(A.LMEM, -4)) , 0) + 1 COMMNO FROM LDB_MEMBER A";


	public static String getInsertQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" INSERT INTO                             \n");
		sb.append("		 LDB_MEMBER(						\n");
		sb.append("	                 LMEM					\n");
		sb.append("                 ,LNAME					\n");
		sb.append("                 ,LID					\n");
		sb.append("                	,LPW					\n");
		sb.append("                	,LHP					\n");
		sb.append("                 ,LBIRTH					\n");
		sb.append("                 ,LEMAIL					\n");
		sb.append("                 ,LPOSTNO				\n");
		sb.append("                 ,LADDR					\n");
		sb.append("                 ,LDELETEYN				\n");
		sb.append("                 ,LINSERTDATE			\n");
		sb.append("                 ,LUPDATEDATE   )		\n");
		sb.append(" VALUES(									\n");
		sb.append("			 ?								\n");
		sb.append("			,?								\n");
		sb.append("			,?								\n");
		sb.append("			,?								\n");
		sb.append("			,?								\n");
		sb.append("			,?								\n");
		sb.append("			,?								\n");
		sb.append("			,?								\n");
		sb.append("			,?								\n");
		sb.append("			,?								\n");
		sb.append("			,SYSDATE						\n");
		sb.append("			,SYSDATE						\n");
		sb.append("			)								\n");
		
		return sb.toString();
	}

	public static String getUpdateQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" UPDATE                      	\n ");
		sb.append("			 LDB_MEMBER				\n ");
		sb.append(" SET								\n ");
		sb.append("			 LPW         = ?		\n ");
		sb.append("		    ,LUPDATEDATE = SYSDATE	\n ");
		sb.append("	WHERE    LMEM        = ?		\n ");
		sb.append("	AND      LDELETEYN   = 'Y'		\n ");	
		
		return sb.toString();
	}
	
	
	public static String getDeleteQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" UPDATE                      	\n ");
		sb.append("			LDB_MEMBER				\n ");
		sb.append(" SET								\n ");
		sb.append("		    LDELETEYN	= 'N'		\n ");
		sb.append("		   ,LUPDATEDATE = SYSDATE	\n ");
		sb.append(" WHERE   LMEM        = ?			\n ");
		sb.append(" AND     LDELETEYN   = 'Y'		\n ");	
		
		
		return sb.toString();
	}
	
	
	public static String getSelectQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT                                  \n ");
		sb.append("         A.LMEM         LMEM				\n ");
		sb.append("        ,A.LNAME        LNAME			\n ");
		sb.append("        ,A.LID          LID				\n ");
		sb.append("        ,A.LPW          LPW				\n ");
		sb.append("        ,A.LHP          LHP				\n ");
		sb.append("        ,A.LBIRTH       LBIRTH			\n ");
		sb.append("        ,A.LEMAIL       LEMAIL			\n ");
		sb.append("        ,A.LPOSTNO      LPOSTNO			\n ");
		sb.append("        ,A.LADDR        LADDR 			\n ");
		sb.append("        ,A.LDELETEYN    LDELETEYN		\n ");
		sb.append("        ,TO_CHAR(A.LINSERTDATE, 'YYYY-MM-DD') LINSERTDATE \n ");
		sb.append("        ,TO_CHAR(A.LUPDATEDATE, 'YYYY-MM-DD') LUPDATEDATE \n ");
		sb.append(" FROM 									\n ");
		sb.append("			LDB_MEMBER A					\n ");
		sb.append(" WHERE 	1=1								\n ");
		sb.append(" AND 	A.LDELETEYN = 'Y'				\n ");
		sb.append(" ORDER BY 1								\n ");
		
		return sb.toString();
	}
	
	
	public static String getSearchQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT                                  \n ");
		sb.append("         A.LMEM         LMEM				\n ");
		sb.append("        ,A.LNAME        LNAME			\n ");
		sb.append("        ,A.LID          LID				\n ");
		sb.append("        ,A.LPW          LPW				\n ");
		sb.append("        ,A.LHP          LHP				\n ");
		sb.append("        ,A.LBIRTH       LBIRTH			\n ");
		sb.append("        ,A.LEMAIL       LEMAIL			\n ");
		sb.append("        ,A.LPOSTNO      LPOSTNO			\n ");
		sb.append("        ,A.LADDR        LADDR 			\n ");
		sb.append("        ,A.LDELETEYN    LDELETEYN		\n ");
		sb.append("        ,TO_CHAR(A.LINSERTDATE, 'YYYY-MM-DD') LINSERTDATE \n ");
		sb.append("        ,TO_CHAR(A.LUPDATEDATE, 'YYYY-MM-DD') LUPDATEDATE \n ");
		sb.append(" FROM 									\n ");
		sb.append("			LDB_MEMBER A					\n ");
		sb.append(" WHERE 	1=1								\n ");
		sb.append(" AND 	A.LDELETEYN = 'Y'				\n ");
		sb.append(" AND		A.LMEM		=  ?				\n ");
		sb.append(" ORDER BY 1								\n ");
		
		return sb.toString();
	}
	
	
	public static String getLikeSearchQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT                                  \n ");
		sb.append("         A.LMEM         LMEM				\n ");
		sb.append("        ,A.LNAME        LNAME			\n ");
		sb.append("        ,A.LID          LID				\n ");
		sb.append("        ,A.LPW          LPW				\n ");
		sb.append("        ,A.LHP          LHP				\n ");
		sb.append("        ,A.LBIRTH       LBIRTH			\n ");
		sb.append("        ,A.LEMAIL       LEMAIL			\n ");
		sb.append("        ,A.LPOSTNO      LPOSTNO			\n ");
		sb.append("        ,A.LADDR        LADDR 			\n ");
		sb.append("        ,A.LDELETEYN    LDELETEYN		\n ");
		sb.append("        ,TO_CHAR(A.LINSERTDATE, 'YYYY-MM-DD') LINSERTDATE \n ");
		sb.append("        ,TO_CHAR(A.LUPDATEDATE, 'YYYY-MM-DD') LUPDATEDATE \n ");
		sb.append(" FROM 									\n ");
		sb.append("			LDB_MEMBER A					\n ");
		sb.append(" WHERE 	1=1								\n ");
		sb.append(" AND     A.LMEM LIKE '%' || ? || '%'  	\n ");
	    sb.append(" AND     A.LDELETEYN = 'Y'         		\n ");
		sb.append(" ORDER BY 1								\n ");
	
		return sb.toString();
	}

	
	public static String getLoginQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT                                  \n ");
		sb.append("         A.LID          LID				\n ");
		sb.append("        ,A.LPW          LPW				\n ");
		sb.append("        ,A.LDELETEYN    LDELETEYN		\n ");
		sb.append(" FROM 									\n ");
		sb.append("			LDB_MEMBER A					\n ");
		sb.append(" WHERE 	1=1								\n ");
		sb.append(" AND 	A.LID	= 		?				\n ");
		sb.append(" AND 	A.LPW	= 		?				\n ");
		sb.append(" AND 	A.LDELETEYN	= 		'Y'			\n ");

		
		return sb.toString();
	}
	

}//end of class


