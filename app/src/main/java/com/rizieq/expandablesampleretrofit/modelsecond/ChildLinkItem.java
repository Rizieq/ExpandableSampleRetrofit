package com.rizieq.expandablesampleretrofit.modelsecond;

import com.google.gson.annotations.SerializedName;

public class ChildLinkItem{

	@SerializedName("orientation")
	private String orientation;

	@SerializedName("link_key")
	private String linkKey;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("message")
	private String message;

	@SerializedName("title")
	private String title;

	@SerializedName("link_id")
	private int linkId;

	@SerializedName("url")
	private String url;

	@SerializedName("avatar_type")
	private String avatarType;

	@SerializedName("link_type")
	private String linkType;

	@SerializedName("account_id")
	private int accountId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("group_link_id")
	private int groupLinkId;

	@SerializedName("position")
	private Object position;

	@SerializedName("status")
	private int status;

	public ChildLinkItem(String avatar, String title, int linkId, int accountId, int groupLinkId, int status) {
		this.avatar = avatar;
		this.title = title;
		this.linkId = linkId;
		this.accountId = accountId;
		this.groupLinkId = groupLinkId;
		this.status = status;
	}

	public void setOrientation(String orientation){
		this.orientation = orientation;
	}

	public String getOrientation(){
		return orientation;
	}

	public void setLinkKey(String linkKey){
		this.linkKey = linkKey;
	}

	public String getLinkKey(){
		return linkKey;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return avatar;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setLinkId(int linkId){
		this.linkId = linkId;
	}

	public int getLinkId(){
		return linkId;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setAvatarType(String avatarType){
		this.avatarType = avatarType;
	}

	public String getAvatarType(){
		return avatarType;
	}

	public void setLinkType(String linkType){
		this.linkType = linkType;
	}

	public String getLinkType(){
		return linkType;
	}

	public void setAccountId(int accountId){
		this.accountId = accountId;
	}

	public int getAccountId(){
		return accountId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setGroupLinkId(int groupLinkId){
		this.groupLinkId = groupLinkId;
	}

	public int getGroupLinkId(){
		return groupLinkId;
	}

	public void setPosition(Object position){
		this.position = position;
	}

	public Object getPosition(){
		return position;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}