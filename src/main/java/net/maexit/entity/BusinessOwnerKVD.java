package net.maexit.entity;

/**
 * Created by arusov on 20.03.2018.
 */
public class BusinessOwnerKVD {

    private int kvdId;
    private String kvdName;
    private int kvdIndex;

    public BusinessOwnerKVD(int kvdId, String kvdName, int kvdIndex) {
        this.kvdId = kvdId;
        this.kvdName = kvdName;
        this.kvdIndex = kvdIndex;
    }

    public int getKvdId() {
        return kvdId;
    }

    public void setKvdId(int kvdId) {
        this.kvdId = kvdId;
    }

    public String getKvdName() {
        return kvdName;
    }

    public void setKvdName(String kvdName) {
        this.kvdName = kvdName;
    }

    public int getKvdIndex() {
        return kvdIndex;
    }

    public void setKvdIndex(int kvdIndex) {
        this.kvdIndex = kvdIndex;
    }
}
