package virtual_filesystem.file_catalogs_comp;

import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 26.12.12
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
public class FileLocation implements Comparable<FileLocation>{
    public static String  FILE_LOCATION_STATUS_CLOSE = "FILE_LOCATION_STATUS_CLOSE";
    public static String  FILE_LOCATION_STATUS_ERROR = "FILE_LOCATION_STATUS_ERROR";
    public static String  FILE_LOCATION_STATUS_META = "FILE_LOCATION_STATUS_META";
    public static String  FILE_LOCATION_STATUS_OPEN = "FILE_LOCATION_STATUS_OPEN";

    private String status;
    private Integer locId;
    private String rootPath;
    private Integer priority;
    private FileCatalog catalog;
    private VirtualFile rootFile;

    private HashMap<Integer,VirtualFile> files = new HashMap<Integer, VirtualFile>();
    private DefaultTreeModel treeModel;

    public FileLocation(Integer locId, String rootPath, Integer priority){
        this.locId = locId;
        this.rootPath = rootPath;
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int compareTo(FileLocation o) {
        return priority.compareTo(o.priority);
    }

    public FileCatalog getCatalog(){
        return this.catalog;
    }

    public void setCatalog(FileCatalog catalog) {
        this.catalog = catalog;
    }

    public Integer getLocId() {
        return locId;
    }

    public void loadFiles(HashMap<Integer, VirtualFile> map){
        this.files = map;
        for (VirtualFile file: map.values()){
            this.files.put(file.getId(), file);
            if (file.getPid() == null) rootFile = file;
            else {
                VirtualFile p = files.get(file.getPid());
                file.setParentFile(p);
            }
        }
        for (VirtualFile file: map.values()){
            file.setPath(getPath(file.getParentFile(),file.getName()));
            System.out.println(file.getPath());
        }

    }

    public String getPath(VirtualFile file, String currPath){
        //System.out.println(file.getName() + file.getParentFile());
        if (file != null) return getPath(file.getParentFile(), file.getName() + "/" + currPath);
        else return rootPath + "/" + currPath;
    }
}
