package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 周边商城轮播图
 * @author yangyuhao
 */
@Table(name="SHOP_SHOW")
@Entity
public class ShopShow {
	
	//轮播图id
	private Integer id;
	//轮播图片链接地址
	private String photoSrc;
	//购买地址
	private String buySrc;
	
	public ShopShow() {
		
	}
	
	@Column(name="ID")
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="PHOTO_SRC")
	public String getPhotoSrc() {
		return photoSrc;
	}
	public void setPhotoSrc(String photoSrc) {
		this.photoSrc = photoSrc;
	}
	
	@Column(name="BUY_SRC")
	public String getBuySrc() {
		return buySrc;
	}
	public void setBuySrc(String buySrc) {
		this.buySrc = buySrc;
	}
	
}
