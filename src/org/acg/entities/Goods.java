package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

/**
 * 商品实体类
 * @author yangyuhao
 */
@Table(name="GOODS")
@Entity
public class Goods {
	
	//商品id
	private Integer id;
	//商品名
	private String name;
	//商品价格
	private double price;
	//商品库存
	private int stock;
	//商品介绍图链接地址
	private String photoDesc;
	//商品详情图链接地址
	private String photoMore;
	
	//连接到B站的购买地址
	private String buySrc;
	@Column(name="BUY_SRC")
	public String getBuySrc() {
		return buySrc;
	}
	public void setBuySrc(String buySrc) {
		this.buySrc = buySrc;
	}
	
	//映射Goods与GoodsType双向多对一关联关系,由Goods维护关联关系
	//商品类型
	private GoodsType goodsType;
	//外键列名为GOODS_TYPE
	@JoinColumn(name="GOODS_TYPE")
	@ManyToOne
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
	
	public Goods() {
		
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

	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="PRICE", nullable=false)
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name="STOCK", nullable=false)
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Column(name="PHOTO_DESC", nullable=true)
	public String getPhotoDesc() {
		return photoDesc;
	}
	public void setPhotoDesc(String photoDesc) {
		this.photoDesc = photoDesc;
	}

	@Column(name="PHOTO_MORE", nullable=true)
	public String getPhotoMore() {
		return photoMore;
	}
	public void setPhotoMore(String photoMore) {
		this.photoMore = photoMore;
	}
	
}
