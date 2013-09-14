package virtual_filesystem.containers;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 26.12.12
 * Time: 0:26
 * To change this template use File | Settings | File Templates.
 */
public class LangTag {
    String name;
    String tag;

    public LangTag(String tag){
        this.tag = tag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        if (name != null) return name;
        else return tag;
    }

}
