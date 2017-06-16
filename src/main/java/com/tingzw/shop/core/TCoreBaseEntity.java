package com.tingzw.shop.core;

import java.util.Date;

/**
 * 基类
 *
 * @author tingzw
 * @date 2017-06-16 11:12
 **/
public class TCoreBaseEntity {
    private String creater;// 创建人
    private Date credate;// 创建时间
    private String editor;// 修改人
    private Date editdate;// 修改时间

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }
}
