package iu4.chernov.tel_dic.contr;

import iu4.chernov.tel_dic.model.DBModel;
import iu4.chernov.tel_dic.prop.GP;
import iu4.chernov.tel_dic.view.TelDicView;

import java.sql.Timestamp;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 17:39
 */
public class TelDicController {
    private DBModel model;
    private TelDicView view;

    public void start(){
        this.model = new DBModel(GP.getProp(DBModel.PROP_DB_PATH),
                                 GP.getProp(DBModel.PROP_DB_NAME),
                                 GP.getProp(DBModel.PROP_DB_USER),
                                 GP.getProp(DBModel.PROP_DB_PASS));
        this.view = new TelDicView();

        view.show(model.getTree(Timestamp.valueOf("2013-09-01 01:00:00.0")));
    }
}
