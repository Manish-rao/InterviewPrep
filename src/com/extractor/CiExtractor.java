package com.extractor;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CiExtractor {
    @SuppressWarnings("org.reflections")
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //
    static final String DB_URL = "jdbc:sqlserver://idit-incl-db:1433;instance=INCL_CI;DatabaseName=INCL_CI_QA;User=incl_user;";
    //static final String DB_URL = "jdbc:sqlserver://CORESQL2017-DB:1433;DatabaseName=CI_TRUNK_DEVDB;User=core_user;";


    //  Database credentials
    static final String USER = "incl_user";
    static final String PASS = "incl_user";

    //static final String USER = "core_user";
    //static final String PASS = "core_user";



    public List<Integer> getIdsFromCI(List descIds) {
        Connection conn = null;
        Statement stmt = null;

        List<Integer> fullList = new ArrayList<>();
        try{
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql="Select RESOURCE_CODE from T_RESOURCE_CODE where RESOURCE_CODE in (?)";
            String sqlIN =(String) descIds.stream()
                    .map(x -> String.valueOf(x))
                    .collect(Collectors.joining(",", "(", ")"));
            sql = sql.replace("(?)",sqlIN);
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                fullList.add(rs.getInt("RESOURCE_CODE"));
            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return fullList;
    }
}
