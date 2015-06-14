
package com.intouchapp.models;

import com.google.gson.annotations.Expose;

public class ScannedCard {

    @Expose
    private String id;
    @Expose
    private String url;
    @Expose
    private boolean convert;
    @Expose
    private boolean deleted;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The convert
     */
    public boolean isConvert() {
        return convert;
    }

    /**
     * 
     * @param convert
     *     The convert
     */
    public void setConvert(boolean convert) {
        this.convert = convert;
    }

    /**
     * 
     * @return
     *     The deleted
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * 
     * @param deleted
     *     The deleted
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
