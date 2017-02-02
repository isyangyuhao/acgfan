package org.acg.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

/**
 * 商品类别实体类
 * @author yangyuhao
 */
@Table(name="GOODS_TYPE")
@Entity
public class GoodsType {
	
	//商品类别id
	private Integer id;
	//类别名
	private String typeName;
	
	//映射GoodsType与Goods双向一对多关联关系,由Goods维护关联关系
	private Set<Goods> goodsSet = new HashSet<>();
	//映射到Goods中的goodsType属性
	@OneToMany(mappedBy="goodsType")
	public Set<Goods> getGoodsSet() {
		return goodsSet;
	}
	public void setGoodsSet(Set<Goods> goodsSet) {
		this.goodsSet = goodsSet;
	}
	
	public GoodsType() {
		
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
	
	@Column(name="TYPE_NAME", nullable=false)
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
