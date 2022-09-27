import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class main {


    public static void main(String args[]) {

        Logger logger = Logger.getLogger(main.class.getName());
        /**
         * Database connection
         */
        String url = "jdbc:mysql://localhost:3306/task1-map";
        String username = "root";
        String password = "";
        String sql = "SELECT * FROM task1";

        logger.log(Level.INFO, "Connection established!");

        ArrayList<POJO> table = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            /**
             * Set Values
             */
            while (rs.next()) {
                POJO pojo = new POJO();
                pojo.setSKU(rs.getInt("SKU"));
                pojo.setProduct(rs.getString("Product"));
                pojo.setQuarter(rs.getInt("Quarter"));
                pojo.setYear(rs.getInt("Year"));
                pojo.setAmerica(rs.getInt("America"));
                pojo.setEurope(rs.getInt("Europe"));
                pojo.setAsia(rs.getInt("Asia"));
                pojo.setAustralia(rs.getInt("Australia"));
                table.add(pojo);
            }
            /**
             * Print Values
             */
            for (POJO obj : table) {
                System.out.print("SKU: " + obj.getSKU() + ", ");
                System.out.print("Product: " + obj.getProduct() + ", ");
                System.out.print("Quarter: " + obj.getQuarter() + ", ");
                System.out.print("Year: " + obj.getYear() + ", ");
                System.out.print("America: " + obj.getAmerica() + ", ");
                System.out.print("Europe: " + obj.getEurope() + ", ");
                System.out.print("Asia: " + obj.getAsia() + ", ");
                System.out.print("Australia: " + obj.getAustralia());
                System.out.println();
            }
            logger.log(Level.INFO, "Table printed!");
            /**
             * Write values to disk
             */
            Writer writer = new FileWriter("C:\\Users\\nikol\\OneDrive - Cyprus University of Technology\\Desktop\\map\\staff.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(table, writer);
            writer.flush();
            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            /**
             * Close connection
             */
            if (conn != null) {

                try {
                    conn.close();
                    logger.log(Level.INFO, "Connection closed!");
                } catch (Exception e) { /* Ignored */}
            }
        }


    }

}