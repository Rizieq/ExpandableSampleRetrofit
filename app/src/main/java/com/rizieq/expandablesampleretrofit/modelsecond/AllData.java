package com.rizieq.expandablesampleretrofit.modelsecond;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllData {

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("title")
    private String title;

    @SerializedName("link_id")
    private int linkId;

    @SerializedName("account_id")
    private int accountId;

    @SerializedName("group_link_id")
    private int groupLinkId;

    @SerializedName("status")
    private int status;

    @SerializedName("unicode")
    private Object unicode;

    @SerializedName("child_link")
    private List<ChildLinkItem> childLink = null;

    public AllData(String avatar, String title, int linkId, int accountId, int groupLinkId, int status, Object unicode, List<ChildLinkItem> childLinkItems) {
        this.avatar = avatar;
        this.title = title;
        this.linkId = linkId;
        this.accountId = accountId;
        this.groupLinkId = groupLinkId;
        this.status = status;
        this.unicode = unicode;
        this.childLink = childLinkItems;
    }

    public List<ChildLinkItem> getChildLink() {
        return childLink;
    }

    public void setChildLink(List<ChildLinkItem> childLink) {
        this.childLink = childLink;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getGroupLinkId() {
        return groupLinkId;
    }

    public void setGroupLinkId(int groupLinkId) {
        this.groupLinkId = groupLinkId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getUnicode() {
        return unicode;
    }

    public void setUnicode(Object unicode) {
        this.unicode = unicode;
    }
}
