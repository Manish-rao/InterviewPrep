package com.extractor;

import java.sql.*;

public class DevDBExtractor {
    static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    //
    static final String ORACLE_DB_URL = "jdbc:oracle:thin:@idit-incl-ln-db:1521/ASIA_DEV";


    //  Database credentials
    static final String USER = "idit";
    static final String PASS = "idit";
    protected String extractTResFromSetup(int resourceType, Integer resourceCode, String newPromotionId) throws SQLException,ClassNotFoundException{
        Class.forName(ORACLE_DRIVER);

        Connection con= DriverManager.getConnection(
                ORACLE_DB_URL,USER,PASS);

        //Statement stmt=con.createStatement();
        String sql = "";
        String sqlIN = "";
        PreparedStatement stmt = null;
        String queryToUpdate="";
        try{
            if(resourceType == 106) {
                sql = "Select max(id),project_id from T_SETUP_PROJECT_DATA where entity_number=106 and CHANGE_TYPE =1 " +
                        "and entity_id = ? group by project_id";
                sqlIN = resourceCode.toString();
            }
            else {
                sql = "Select max(id),project_id from T_SETUP_PROJECT_DATA where entity_number=103 and CHANGE_TYPE =1 " +
                        "and entity_id like ? group by project_id";
                sqlIN = resourceCode+"_en_US";
            }
            stmt=con.prepareStatement(sql);
            stmt.setString(1,sqlIN);
            ResultSet rs = stmt.executeQuery();


            while(rs.next()) {
                printProjectID(rs.getInt("PROJECT_ID"));
                queryToUpdate="UPDATE T_SETUP_PROJECT_DATA set PROJECT_ID="+newPromotionId+" where id="+rs.getInt(1);
                System.out.println(queryToUpdate);
                return queryToUpdate;
            }
            rs.close();
            stmt.close();
            con.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
        return "IMP: ******RESOURCE CODE NOT FOUND in Setup**** "+resourceCode;
    }

    protected void printProjectID(int projectId) throws SQLException,ClassNotFoundException{
        Class.forName(ORACLE_DRIVER);

        Connection con= DriverManager.getConnection(
                ORACLE_DB_URL,USER,PASS);

        Statement stmt=con.createStatement();
        try{

            String sql="Select * from T_SETUP_PROJECT where id = "+projectId;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println("Project ID and Desc:"+rs.getInt(1)+" : "+rs.getString("DESCRIPTION"));
            }
            rs.close();
            stmt.close();
            con.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }

}
