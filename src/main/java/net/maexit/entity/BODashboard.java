package net.maexit.entity;

import java.util.List;

/**
 * Created by arusov on 20.03.2018.
 */
public class BODashboard {

    private int index;
    private String  id;

    private List<BusinessOwnerKVD> kvds;

    public BODashboard() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<BusinessOwnerKVD> getKvds() {
        return kvds;
    }

    public void setKvds(List<BusinessOwnerKVD> kvds) {
        this.kvds = kvds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
