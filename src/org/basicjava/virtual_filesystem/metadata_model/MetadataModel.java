package org.basicjava.virtual_filesystem.metadata_model;

import org.basicjava.virtual_filesystem.file_catalogs_comp.FileCatalog;
import org.basicjava.virtual_filesystem.file_catalogs_comp.FileLocation;
import org.basicjava.virtual_filesystem.file_catalogs_comp.VirtualFile;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 25.12.12
 * Time: 18:52
 * To change this template use File | Settings | File Templates.
 */
public class MetadataModel {
    String connString;
    Connection conn;

    public MetadataModel(String connString){
        try{
            this.connString = connString;
            conn = DriverManager.getConnection(connString, "sa", "");
            //conn = DriverManager.getConnection(connString);
        } catch(Exception ex){ex.printStackTrace();}
    }

    public List<FileCatalog> getCatalogs(){
        ResultSet res = executeQuery("select cat_id, cat_nat_id, cat_seq, cat_name from catalogs");
        ArrayList<FileCatalog> list = new ArrayList<FileCatalog>();
        try{
            while (res.next()){
                FileCatalog cat = new FileCatalog(res.getInt("cat_id"), res.getString("cat_nat_id"), res.getInt("cat_seq"));
                cat.setCatName(res.getString("cat_name"));
                list.add(cat);
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void loadFileCatalog(FileCatalog catalog){
        ResultSet res = executeQuery("SELECT loc_id, loc_root_path, priority FROM locations WHERE cat_id="+catalog.getCatId());
        try{
            while (res.next()){
                FileLocation loc = new FileLocation(res.getInt("loc_id"), res.getString("loc_root_path"), res.getInt("priority"));
                loc.setStatus(FileLocation.FILE_LOCATION_STATUS_CLOSE);
                catalog.addLocation(loc);
                loc.setCatalog(catalog);
                loadFiles(loc);
            }
            catalog.setStatus(FileCatalog.FILE_CATALOG_STATUS_OPEN);
        } catch (Exception ex){
            catalog.setStatus(FileCatalog.FILE_CATALOG_STATUS_ERROR);
            ex.printStackTrace();
        }
    }

    public void loadFiles(FileLocation loc){
        //String catNatId = loc.getCatalog().getCatNatId();
        HashMap<Integer,VirtualFile> map = new HashMap<Integer,VirtualFile>();
        ResultSet res = executeQuery("SELECT id, cat_id, name, pid FROM files_" + loc.getLocId());
        try{
            while (res.next()){
                VirtualFile file = new VirtualFile(res.getInt("id"),res.getString("name"),res.getInt("pid"));
                map.put(file.getId(),file);
            }
        } catch (Exception ex){ex.printStackTrace();}
        loc.loadFiles(map);
        loc.setStatus(FileLocation.FILE_LOCATION_STATUS_META);
    }

    public ResultSet executeQuery(String query){
        try{
            Statement stmt = conn.createStatement();
            ResultSet resSet = stmt.executeQuery(query);
            return resSet;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    private void execute(String sqlText){
        try{
            Statement stmt = conn.createStatement();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        //ResultSet rset = stmt.executeQuery("select BANNER from sys.v_$version");
        //stmt.execute("CREATE TABLE test (tes_id INTEGER, test_name VARCHAR(255))");
        //stmt.execute("TRUNCATE TABLE catalogs");
        //stmt.execute("INSERT INTO catalogs (cat_id, cat_name,cat_seq,cat_nat_id) VALUES(1, 'Изображения Макса', 0,'http://www.mchernov.com/catalogs/images')");


    }
}
