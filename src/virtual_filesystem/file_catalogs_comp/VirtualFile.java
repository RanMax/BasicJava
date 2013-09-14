package virtual_filesystem.file_catalogs_comp;

import javax.swing.tree.TreeNode;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 26.12.12
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
public class VirtualFile{
    private String fileNatId;
    private String path;
    private Integer id;
    private String name;
    private Integer pid;

    private VirtualFile parentFile;

    public VirtualFile(String id, String path){
        this.fileNatId = id;
        this.path = path;
    }

    public VirtualFile(Integer id, String name, Integer pid){
        this.id = id;
        this.name = name;
        this.pid = pid;
    }

    public String getFileNatId() {
        return fileNatId;
    }

    public String getPath() {
        return path;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPid() {
        return pid;
    }

    public VirtualFile getParentFile() {
        return parentFile;
    }

    public void setParentFile(VirtualFile parentFile) {
        this.parentFile = parentFile;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String toString(){
        return this.name;
    }
}
