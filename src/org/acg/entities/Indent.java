package org.acg.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

/**
 * 商品类别实体类
 * @author yangyuhao
 */
@Table(name="INDENT")
@Entity
public class Indent {
	
	//订单id
	private Integer id;
	//购买数量
	private int number;
	//收货地址
	private String address;
	//联系方式
	private long phone;
	//邮编
	private int post;
	//消费金额
	private int money;
	//创建时间
	private Date createTime;
	
	//映射Indent与User双向多对一关联关系,Indent维护关联关系
	//订单所有者
	private User user;
	//外键列名为USER_ID
	@JoinColumn(name="USER_ID")
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	//映射Indent与Goods单向一对一关联关系
	private Goods goods;
	@JoinColumn(name="GOODS_ID")
	@OneToOne
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
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
	
	@Column(name="NUMBER", nullable=false)
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Column(name="ADDRESS", nullable=false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="PHONE", nullable=false)
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	@Column(name="POST", nullable=false)
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	
	@Column(name="MONEY", nullable=false)
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME", nullable=false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
