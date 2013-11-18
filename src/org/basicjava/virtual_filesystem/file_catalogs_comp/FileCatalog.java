package org.basicjava.virtual_filesystem.file_catalogs_comp;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 25.12.12
 * Time: 18:54
 * To change this template use File | Settings | File Templates.
 */
public class FileCatalog {
    public static String  FILE_CATALOG_STATUS_CLOSE = "FILE_CATALOG_STATUS_CLOSE";
    public static String  FILE_CATALOG_STATUS_OPEN = "FILE_CATALOG_STATUS_OPEN";
    public static String  FILE_CATALOG_STATUS_ERROR = "FILE_CATALOG_STATUS_ERROR";

    private Integer catId;
    private String catNatId;
    private Integer catSeq;
    private String catName;
    private String status = FILE_CATALOG_STATUS_CLOSE;

    private TreeSet<FileLocation> locations;

    public FileCatalog(Integer catId, String catNatId, Integer catSeq){
        this.catId = catId;
        this.catNatId = catNatId;
        this.catSeq = catSeq;
    }

    public void addLocation(FileLocation loc){
        if (this.locations == null) this.locations = new TreeSet<FileLocation>();
        this.locations.add(loc);
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Integer getCatId() {
        return catId;
    }

    public String getCatNatId() {
        return catNatId;
    }

    public Integer getCatSeq() {
        return catSeq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        if (this.catName != null) return this.catName;
        else return this.catNatId;
    }


}
